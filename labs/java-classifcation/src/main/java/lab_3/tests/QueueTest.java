package lab_3.tests;

import lab_3.task1.ArrayQueue;
import lab_3.task1.CircularQueue;

import lab_3.task1.LinkedListQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    void testQueueInteger() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(3);
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        CircularQueue<Integer> circularQueue = new CircularQueue<>(3);


        arrayQueue.enqueue(109);
        arrayQueue.enqueue(23);
        Assertions.assertEquals(109, arrayQueue.peek());

        circularQueue.enqueue(26);
        Assertions.assertEquals(26, circularQueue.peek());

        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(57);
        Assertions.assertEquals(10, linkedListQueue.peek());
    }

    @Test
    void testQueueString() {
        // Initialize the queue
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(3);
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        CircularQueue<String> circularQueue = new CircularQueue<>(3);


        arrayQueue.enqueue("Hello world");
        arrayQueue.enqueue("!!");
        Assertions.assertEquals("Hello world", arrayQueue.peek());

        circularQueue.enqueue("TEST");
        Assertions.assertEquals("TEST", circularQueue.peek());

        linkedListQueue.enqueue("Linked");
        linkedListQueue.enqueue("List");
        Assertions.assertEquals("Linked", linkedListQueue.peek());
    }

    @Test
    void testQueueIsEmpty() {
        // Initialize the queue
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(3);
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        CircularQueue<Integer> circularQueue = new CircularQueue<>(3);

        Assertions.assertTrue(arrayQueue.isEmpty());
        arrayQueue.enqueue(1);
        Assertions.assertFalse(arrayQueue.isEmpty());
        arrayQueue.dequeue();
        Assertions.assertTrue(arrayQueue.isEmpty());

        Assertions.assertTrue(linkedListQueue.isEmpty());
        linkedListQueue.enqueue(11);
        Assertions.assertFalse(linkedListQueue.isEmpty());
        linkedListQueue.dequeue();
        Assertions.assertTrue(linkedListQueue.isEmpty());

        Assertions.assertTrue(circularQueue.isEmpty());
        circularQueue.enqueue(111);
        Assertions.assertFalse(circularQueue.isEmpty());
        circularQueue.dequeue();
        Assertions.assertTrue(circularQueue.isEmpty());
    }
}
