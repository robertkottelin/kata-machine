class ArrayList<T> {
    private int length;
    private T[] items;

    ArrayList() {
        this.length = 0;
        this.items = new T[0];
    }

    void prepend(T item) {
        this.items.unshift(item);
        this.length++;
    }

    void insertAt(T item, int idx) {
        if (idx < 0 || idx > this.length) {
            throw new Error('Index out of bounds');
        }

        this.items.splice(idx, 0, item);
        this.length++;
    }

    void append(T item) {
        this.items.push(item);
        this.length++;
    }

    T remove(T item) {
        const idx = this.items.indexOf(item);
        if (idx === -1) {
            return undefined;
        }

        this.items.splice(idx, 1);
        this.length--;
        return item;
    }

    T get(int idx) {
        if (idx < 0 || idx >= this.length) {
            return undefined;
        }

        return this.items[idx];
    }

    T removeAt(int idx) {
        if (idx < 0 || idx >= this.length) {
            return undefined;
        }

        const [item] = this.items.splice(idx, 1);
        this.length--;
        return item;
    }
}