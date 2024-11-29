package lab_3.task1;

public class ArrayQueue<Car> implements Queue<Car> {
    private Integer peek;
    private Integer rear;
    private Integer size;
    private Car[] car;

    public ArrayQueue(Integer length) {
        this.peek = 0;
        this.rear = -1;
        this.size = 0;
        this.car = (Car[]) new Object[length];
    }

    @Override
    public void enqueue(Car car) {
        //check if queue is full
        if (size == this.car.length) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % this.car.length;
        this.car[rear] = car;
        size++;
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        car[peek] = null;
        peek = (peek + 1) % this.car.length;
        size--;
    }

    @Override
    public Car peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return car[peek];
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
        for (int i = 0; i < size; i++) {
            System.out.println(car[(peek + i) % this.car.length].toString());
        }
        System.out.println();
    }
}
