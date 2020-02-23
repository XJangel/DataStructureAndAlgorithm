package matrix_stack_queue;

import java.util.Queue;
import java.util.Stack;


public class StackForQueue<E> {
    private Stack<E> push;
    private Stack<E> pop;
    
    public StackForQueue() {
        push = new Stack<E>();
        pop = new Stack<E>();
    }
    
    public boolean add(E e) {
        while(!pop.isEmpty()) {
            push.add(pop.pop());
        }
        push.add(e);
        return true;
    }
    
    
    public E poll() {
        if(push.isEmpty() && pop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if(pop.isEmpty()) {
            while(!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }
    
    
    public E peek() {
        if(push.isEmpty() && pop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if(pop.isEmpty()) {
            while(!push.isEmpty()) {
                pop.push(push.pop());
            }
        }
        return pop.peek();
    }
}
