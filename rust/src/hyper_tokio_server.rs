use hyper::{Body, Request, Response, Server, StatusCode};
use hyper::service::{make_service_fn, service_fn};
use hyper::Method;
use std::convert::Infallible;
use std::sync::{Arc, Mutex};
use std::collections::HashSet;

type Items = Arc<Mutex<HashSet<String>>>;

async fn api_handler(items: Items, req: Request<Body>) -> Result<Response<Body>, Infallible> {
    let (method, uri) = (req.method().clone(), req.uri().clone());
    let response = match (method, uri.path()) {
        (Method::GET, "/items") => {
            let items = items.lock().unwrap();
            let items = items.iter().cloned().collect::<Vec<String>>().join(", ");
            let body = format!("Items: [{}]", items);
            Response::new(Body::from(body))
        }
        (Method::POST, "/items") => {
            let item = uri.query().unwrap_or("").to_string();
            if !item.is_empty() {
                items.lock().unwrap().insert(item);
                Response::new(Body::from("Item added"))
            } else {
                let mut response = Response::new(Body::from("Empty item not allowed"));
                *response.status_mut() = StatusCode::BAD_REQUEST;
                response
            }
        }
        _ => {
            let mut response = Response::new(Body::from("Not found"));
            *response.status_mut() = StatusCode::NOT_FOUND;
            response
        }
    };

    Ok(response)
}

#[tokio::main]
async fn main() {
    let items: Items = Arc::new(Mutex::new(HashSet::new()));
    let addr = ([127, 0, 0, 1], 3000).into();
    let make_svc = make_service_fn(move |_| {
        let items = items.clone();
        async move {
            Ok::<_, Infallible>(service_fn(move |req| {
                let items = items.clone();
                api_handler(items, req)
            }))
        }
    });

    let server = Server::bind(&addr).serve(make_svc);
    println!("Server started on http://{}", addr);
    if let Err(e) = server.await {
        eprintln!("Server error: {}", e);
    }
}
