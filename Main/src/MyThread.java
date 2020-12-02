import com.dropbox.core.v2.DbxClientV2;

public class MyThread extends Thread {

    private int threadNumber;

    public MyThread(DbxClientV2 client) {

    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.println(threadNumber);
        }
    }
}
