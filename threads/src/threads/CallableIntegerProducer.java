package threads;

import java.util.concurrent.Callable;

public class CallableIntegerProducer implements Callable<Integer> {

    private final int id;
    private int sumOfPushed = 0;
    private Stack<Integer> stack;

    public CallableIntegerProducer(Stack<Integer> stack, int i) {
        this.stack  = stack;
        this.id = i;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 20; ++i) {
            int toPush = (int) Math.floor(Math.random() * 100);
            this.sumOfPushed += toPush;
            this.stack.push(toPush);
            System.out.printf("%d added #%d item, sum: %d\n", this.id, i, this.sumOfPushed);
            try {
                Thread.sleep((long) (10000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.sumOfPushed % 2 == 0)
            return this.sumOfPushed;
        throw new Exception("Pushed uneven sum!");

    }
}
