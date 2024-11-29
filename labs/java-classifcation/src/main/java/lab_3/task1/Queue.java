package lab_3.task1;

interface Queue<Car> {
    void enqueue(Car car);
    void dequeue();
    Car peek();
    boolean isEmpty();
    int size();
    void display();
}