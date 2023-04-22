//mod array_list;
//mod bfs_graph_matrix;
//mod bt_in_order;
//mod bt_post_order;
//mod bt_pre_order;
//mod btbfs;
//mod bubble_sort;
//mod compare_binary_trees;
//mod dfs_graph_list;
//mod dfs_on_bst;
//mod dijkstra_list;
//mod doubly_linked_list;
//mod linear_search_list;
//mod lru;
//mod map;
//mod maze_solver;
//mod merge_sort;
//mod min_heap;
mod queue;
use queue::Queue;
//mod quick_sort;
//mod singly_linked_list;
//mod stack;
//mod trie;
//mod two_crystall_balls;
//mod priority_queue;

fn main() {
    //    let mut arr = vec![5, 3, 8, 4, 2, 7, 1, 6];
    //    bubble_sort::bubble_sort(&mut arr);
    //    println!("{:?}", arr);
    let mut queue: Queue<i32> = Queue::new();

    // Enqueue items
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    // Peek at the first item
    println!("Peek: {:?}", queue.peek());

    // Dequeue items and print them
    while let Some(value) = queue.deque() {
        println!("Dequeued: {}", value);
    }
}
