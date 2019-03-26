package threads;

public class RunnableConsumer implements Runnable{
    private final int id;
    private int counter;
    private Stack stack;

    public RunnableConsumer(Stack stack, int i) {
        this.stack  = stack;
        this.id = i;
        this.counter = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; ++i) {
            System.out.printf("%d popped %d, #%d\n", this.id, this.stack.pop(), this.counter++);
            try {
                Thread.sleep((long) (10000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
