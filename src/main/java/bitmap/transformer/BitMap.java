package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BitMap {

    BufferedImage imageData;
    int height;
    int width;


    public BitMap(String inputPath) throws IOException {

        File file = new File(inputPath);

        this.imageData = ImageIO.read(file);

        this.height = imageData.getHeight();

        this.width = imageData.getWidth();
    }
    public void writeBmp(String path) throws IOException {
        ImageIO.write(this.imageData,"bmp", new File(path));
    }
    public void turnGray() {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                Color color = new Color(this.imageData.getRGB(x,y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int greyOut = new Color(red/4,green/4,blue/4).getRGB();
                this.imageData.setRGB(x,y,greyOut);
            }
        }
    }
    public void greyScale() {
        for(int y = 0; y < this.height; y++) {
            for(int x = 0; x < this.width; x++) {
                Color color = new Color(this.imageData.getRGB(x,y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int alpha = color.getAlpha();
                int grey = (red + green + blue) / 3;
                Color greyScale = new Color(grey,grey,grey,alpha);
                this.imageData.setRGB(x,y,greyScale.getRGB());
            }
        }
    }
}
