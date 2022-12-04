package juegonaves;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class img {

    public static BufferedImage ImageLoader(String path)
    {
        try {
            File archivo = new File(path);
            return ImageIO.read(archivo);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

    }

}
