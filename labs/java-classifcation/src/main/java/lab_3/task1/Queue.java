package lab_3.task1;

public interface Queue<Car> {
    public void enqueue(Car car);
    public void dequeue();
    public Car peek();
    public boolean isEmpty();
    public int size();
    public void display();
}