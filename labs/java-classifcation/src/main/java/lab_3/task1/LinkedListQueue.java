package lab_3.task1;

public class LinkedListQueue<Car> implements Queue<Car> {
    static class Node<Car> {
        Car car;
        Node<Car> next;

        Node(Car car) {
            this.car = car;
            this.next = null;
        }
    }

    private Node<Car> peek, rear;
    private Integer size;

    public LinkedListQueue() {
        this.peek = null;
        this.rear = null;
        this.size = 0;
    }

    @Override
    public void enqueue(Car car) {
        Node<Car> newNode = new Node<>(car);

        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;

        if (peek == null) {
            peek = rear;
        }
        size++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        peek = peek.next;

        //if peek null, then rear is also null
        if (peek == null) {
            rear = null;
        }
        size--;
    }

    @Override
    public Car peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return peek.car;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Node<Car> item = peek;
        while (item != null) {
            System.out.println(item.car.toString());
            item = item.next;
        }
        System.out.println();
    }
}

