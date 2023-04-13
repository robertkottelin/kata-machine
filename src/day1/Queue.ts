// first in first out, if the queue is empty

type Node<T> = {
    value: T,
    next?: Node<T>,
}

export default class Queue<T> {
    public length: number;
    private head?: Node<T>;
    private tail?: Node<T>;

    constructor() {
        this.head = this.tail = undefined;
        this.length = 0;
    }

    enqueue(item: T): void {
        const node = {value: item} as Node<T>;
        this.length ++;
        if (!this.tail) {
            this.tail = this.head = node;
            return;
        }

        this.tail.next  = node;
        this.tail = node;
    }

    deque(): T | undefined {
        if (!this.head) {
            return undefined;
        }

        this.length --;
        
        const head = this.head;
        this.head = this.head.next;

        head.next = undefined;

        return head.value;
    }

    peek(): T | undefined {
        return this.head?.value;
    }
}


interface LinkedList<T> {
    get length(): number;
    insertAt(item: T, index: number): void;
    remove(item: T): T | undefined;
    removeAt(index: number): T | undefined;
    append(item: T): void;
    prepend(item: T): void;
    get(index: number): T | undefined;
}