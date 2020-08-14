
public class CounterRunnerTest {

    public static void main(String[] args) {
        Runnable runner = new Counter();
        Thread thread = new Thread(runner);
        thread.setName("子线程");
        thread.start();

        /*try {
            Thread.sleep(18 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



        // 观察者
        ((Counter)runner).getCounter();

        // 打断子线程
        thread.interrupt();
    }
}
