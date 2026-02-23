public class queue {
    int size;
    int[] queue;
    int fIdx;
    int rIdx;

    public queue() {
        this.size = 5;
        this.queue = new int[size];
        this.fIdx = -1;
        this.rIdx = -1;
    }

    // isEmpty: returns true if queue is empty
    public boolean isEmpty() {
        return this.fIdx == -1 || fIdx > rIdx;
    }

    // isFull: returns true if queue is full
    public boolean isFull() {
        return this.rIdx == this.size - 1;
    }

    // Enqueue: adds an element to the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        if (this.fIdx == -1) {
            this.fIdx = 0;
        }

        this.rIdx++;
        this.queue[this.rIdx] = data;
    }

    // Dequeue: removes an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        this.fIdx++;

        // reset when queue becomes empty
        if (this.fIdx > this.rIdx) {
            this.fIdx = -1;
            this.rIdx = -1;
        }
    }

    // getFront: returns the element at the front of the queue
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return this.queue[fIdx];
    }

    // getRear: returns the element at the rear of the queue
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[rIdx];
    }

    // Display: displays the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("\nQueue: ");

        for (int i = fIdx; i <= rIdx; i++) {
            System.out.print(queue[i] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        queue q = new queue();
        System.out.println(q.getClass().getName());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();
        q.dequeue();
        q.dequeue();
        q.display();
        System.out.println(q.getFront());
        System.out.println(q.getRear());
    }
}