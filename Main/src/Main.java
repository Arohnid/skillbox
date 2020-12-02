import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main {
    public static void main(String[] args) throws AWTException, IOException {

        String ACCESS_TOKEN = "bijmsSa8IHcAAAAAAAAAAfHqpDbDPQ9fUMzr_AekP0AiEdZyGx8zNnQfexT3oO6d";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[]imageInByte = baos.toByteArray();

        try {
            InputStream in = new ByteArrayInputStream(imageInByte);
            client.files().uploadBuilder("/image3.png")
                    .uploadAndFinish(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
