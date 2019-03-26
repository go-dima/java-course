package threads;

import java.util.concurrent.Callable;

public class CallableConsumer implements Callable<Integer> {
    private Stack stack;
    private int id;
    private int sumPopped = 0;

    public CallableConsumer(Stack stack, int id){
        this.stack = stack;
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 20; ++i) {
            int popped = (int)this.stack.pop();
            this.sumPopped += popped;
            System.out.printf("%d popped #%d: %d, sum: %d\n", this.id, i, popped, this.sumPopped);
            try {
                Thread.sleep((long) (10000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (this.sumPopped % 2 == 0)
            return this.sumPopped;
        throw new Exception("Popped uneven sum!");
    }
}
