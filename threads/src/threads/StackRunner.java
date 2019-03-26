package threads;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;

class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t =new Thread(r);
        t.setDaemon(true);
        return t;
    }
}

public class StackRunner {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        //runAsRunnable(stack);
        runAsCallable(stack);
    }

    private static void runAsCallable(Stack<Integer> stack) {
        ExecutorService es = Executors.newFixedThreadPool(6, new MyThreadFactory());

        Collection<Callable<Integer>> col = new HashSet<Callable<Integer>>();
        col.add(new CallableConsumer(stack, 0));
        col.add(new CallableConsumer(stack, 1));
        col.add(new CallableConsumer(stack, 2));
        col.add(new CallableConsumer(stack, 3));
        col.add(new CallableIntegerProducer(stack, 0));
        col.add(new CallableIntegerProducer(stack, 1));
        col.add(new CallableIntegerProducer(stack, 2));
        col.add(new CallableIntegerProducer(stack, 3));

        try {
            List<Future<Integer>> results = es.invokeAll(col);
            printResults(results);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printResults(List<Future<Integer>> results) {
        for (Future<Integer> res: results) {
            try {
                System.out.println(res.get().toString());
            } catch (Exception e) {
                System.out.println(e.getCause().getMessage());
            }
        }
    }

    private static void runAsRunnable(Stack<Integer> stack) {
        Thread p1 = new Thread(new RunnableIntegerProducer(stack, 1));
        Thread p2 = new Thread(new RunnableIntegerProducer(stack, 2));
        Thread p3 = new Thread(new RunnableIntegerProducer(stack, 3));
        Thread p4 = new Thread(new RunnableIntegerProducer(stack, 4));

        Thread c1 = new Thread(new RunnableConsumer(stack, 1));
        Thread c2 = new Thread(new RunnableConsumer(stack, 2));
        Thread c3 = new Thread(new RunnableConsumer(stack, 3));
        Thread c4 = new Thread(new RunnableConsumer(stack, 4));

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
