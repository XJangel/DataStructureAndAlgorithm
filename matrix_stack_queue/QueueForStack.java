package matrix_stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueForStack<E> {
    private Queue<E> queue;
    private Queue<E> help;
    
    public QueueForStack() {
        queue = new LinkedList<E>();
        help = new LinkedList<E>();
    }
    
    public void push(E e) {
        queue.add(e);
    }
    
    public E pop() {
        if(queue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while(queue.size() > 1) {
            help.add(queue.poll());
        }
        E e = queue.poll();
        swap();
        return e;
    }
    public E peek() {
        if(queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while(queue.size() > 1) {
            help.add(queue.poll());
        }
        E e = queue.poll();
        help.add(e);
        swap();
        return e;
    }
    
    private void swap() {
        Queue<E> tmp = queue;
        queue = help;
        help = tmp;
    }
}
