
#[derive(Debug)]
struct Node<T> {
    value: T,
    next: Option<Box<Node<T>>>,
}

#[derive(Debug)]
pub struct Queue<T> {
    length: usize,
    head: Option<Box<Node<T>>>,
    tail: Option<*mut Node<T>>,
}

impl<T> Queue<T> {
    pub fn new() -> Self {
        Queue {
            length: 0,
            head: None,
            tail: None,
        }
    }

    pub fn enqueue(&mut self, item: T) {
        let mut node = Box::new(Node {
            value: item,
            next: None,
        });
        let raw_node = &mut *node as *mut Node<T>;
        self.length += 1;

        match self.tail.take() {
            Some(tail) => unsafe { (*tail).next = Some(node) },
            None => self.head = Some(node),
        }
        self.tail = Some(raw_node);
    }

    pub fn deque(&mut self) -> Option<T> {
        if self.head.is_none() {
            return None;
        }

        self.length -= 1;

        let head = self.head.take();
        self.head = head.as_ref().unwrap().next.clone();

        Some(head.unwrap().value)
    }

    pub fn peek(&self) -> Option<&T> {
        self.head.as_ref().map(|head| &head.value);
    }
}
