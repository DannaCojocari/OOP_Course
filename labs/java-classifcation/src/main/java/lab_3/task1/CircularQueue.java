package lab_3.task1;

import java.util.ArrayList;

public class CircularQueue<Car> implements Queue<Car> {
    private Integer size, peek, rear, length;
    private ArrayList<Car> car;

    public CircularQueue(int length) {
        this.peek = -1;
        this.rear = -1;
        this.length = length;
        this.size = 0;
        this.car = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            car.add(null);
        }
    }

    @Override
    public void enqueue(Car car) {
        if (size == length) {
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()) {
            peek = 0;
        }
        rear = (rear + 1) % length;
        this.car.set(rear, car);
        size++;
    }


    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        // remove the front element and update pointers
        this.car.set(peek, null);
        peek = (peek + 1) % length;
        size--;

        // Reset pointers if queue becomes empty
        if (size == 0) {
            peek = -1;
            rear = -1;
        }
    }

    @Override
    public Car peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return car.get(peek);
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
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(car.get((peek + i) % length) + " ");
        }
        System.out.println();
    }
}

