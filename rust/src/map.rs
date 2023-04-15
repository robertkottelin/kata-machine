use std::collections::HashMap;
use std::hash::Hash;

pub struct CustomMap<T: Eq + Hash + Clone, V> {
    items: HashMap<T, V>,
}

impl<T: Eq + Hash + Clone, V> CustomMap<T, V> {
    pub fn new() -> CustomMap<T, V> {
        CustomMap {
            items: HashMap::new(),
        }
    }

    pub fn get(&self, key: T) -> Option<&V> {
        self.items.get(&key)
    }

    pub fn set(&mut self, key: T, value: V) {
        self.items.insert(key, value);
    }

    pub fn delete(&mut self, key: T) -> Option<V> {
        self.items.remove(&key)
    }

    pub fn size(&self) -> usize {
        self.items.len()
    }
}
