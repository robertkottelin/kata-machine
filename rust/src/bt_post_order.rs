pub struct BinaryNode<T> {
    pub value: T,
    pub left: Option<Box<BinaryNode<T>>>,
    pub right: Option<Box<BinaryNode<T>>>,
}

fn walk<T>(curr: Option<&BinaryNode<T>>, path: &mut Vec<T>)
where
    T: Copy,
{
    if let Some(node) = curr {
        walk(node.left.as_ref(), path);
        walk(node.right.as_ref(), path);
        path.push(node.value);
    }
}

pub fn post_order_search(head: &BinaryNode<i32>) -> Vec<i32> {
    let mut path: Vec<i32> = Vec::new();
    walk(Some(head), &mut path);
    path
}
