package threads;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<T>();
    }

    public synchronized void push(T data) {
        this.stack.add(data);
        this.notifyAll();
    }

    public synchronized T pop() {
        while (this.stack.isEmpty()) {
            try {
                System.out.println("Nothing to pop...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int last = this.stack.size();
        return this.stack.remove(last - 1);
    }

    public void printStack() {
        for (T item: this.stack) {
            System.out.println(item);
        }
    }
}
