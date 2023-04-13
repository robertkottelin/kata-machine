export default class ArrayList<T> {
    public length: number;
    private items: T[];

    constructor() {
        this.length = 0;
        this.items = [];
    }

    prepend(item: T): void {
        this.items.unshift(item);
        this.length++;
    }

    insertAt(item: T, idx: number): void {
        if (idx < 0 || idx > this.length) {
            throw new Error('Index out of bounds');
        }

        this.items.splice(idx, 0, item);
        this.length++;
    }

    append(item: T): void {
        this.items.push(item);
        this.length++;
    }

    remove(item: T): T | undefined {
        const idx = this.items.indexOf(item);
        if (idx === -1) {
            return undefined;
        }

        this.items.splice(idx, 1);
        this.length--;
        return item;
    }

    get(idx: number): T | undefined {
        if (idx < 0 || idx >= this.length) {
            return undefined;
        }

        return this.items[idx];
    }

    removeAt(idx: number): T | undefined {
        if (idx < 0 || idx >= this.length) {
            return undefined;
        }

        const [item] = this.items.splice(idx, 1);
        this.length--;
        return item;
    }
}


// RUST
// use std::collections::VecDeque;

// #[derive(Debug)]
// pub struct ArrayList<T> {
//     length: usize,
//     items: VecDeque<T>,
// }

// impl<T> ArrayList<T> {
//     pub fn new() -> Self {
//         Self {
//             length: 0,
//             items: VecDeque::new(),
//         }
//     }

//     pub fn prepend(&mut self, item: T) {
//         self.items.push_front(item);
//         self.length += 1;
//     }

//     pub fn insert_at(&mut self, item: T, idx: usize) {
//         if idx < 0 || idx > self.length {
//             panic!("Index out of bounds");
//         }

//         self.items.insert(idx, item);
//         self.length += 1;
//     }

//     pub fn append(&mut self, item: T) {
//         self.items.push_back(item);
//         self.length += 1;
//     }

//     pub fn remove(&mut self, item: T) -> Option<T> {
//         let idx = self.items.iter().position(|x| x == item);
//         if let None = idx {
//             return None;
//         }

//         self.items.remove(idx.unwrap());
//         self.length -= 1;
//         Some(item)
//     }

//     pub fn get(&self, idx: usize) -> Option<&T> {
//         if idx < 0 || idx >= self.length {
//             return None;
//         }

//         self.items.get(idx)
//     }

//     pub fn remove_at(&mut self, idx: usize) -> Option<T> {
//         if idx < 0 || idx >= self.length {
//             return None;
//         }

//         let item = self.items.remove(idx);
//         self.length -= 1;
//         Some(item)
//     }
// }