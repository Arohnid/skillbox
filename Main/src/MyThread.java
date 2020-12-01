public class MyThread extends Thread {

    private int threadNumber;

    public MyThread (int number) {
        threadNumber = number;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println(threadNumber);
        }
    }
}
