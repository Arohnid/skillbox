import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;


public class Main {
    public static void main(String[] args) {

        String ACCESS_TOKEN = "bijmsSa8IHcAAAAAAAAAAfHqpDbDPQ9fUMzr_AekP0AiEdZyGx8zNnQfexT3oO6d";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        MyThread thread1 = new MyThread(client);

        thread1.start();
    }
}
