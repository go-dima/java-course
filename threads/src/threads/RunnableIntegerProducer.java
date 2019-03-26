package threads;

public class RunnableIntegerProducer implements Runnable {

    private final int id;
    private Stack<Integer> stack;

    public RunnableIntegerProducer(Stack<Integer> stack, int i) {
        this.stack  = stack;
        this.id = i;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; ++i) {
            this.stack.push((int)Math.floor(Math.random() * 100));
            System.out.printf("%d added #%d item\n", this.id, i);
            try {
                Thread.sleep((long) (10000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
