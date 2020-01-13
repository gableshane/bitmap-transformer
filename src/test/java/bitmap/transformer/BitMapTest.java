package bitmap.transformer;

import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;

public class BitMapTest {
    String destination = "src/main/resources/test.bmp";
    @Test
    public void testWriteMethod() throws IOException {

        BitMap test = new BitMap("src/main/resources/mario.bmp");
        test.writeBmp(destination);
        File outputFile = new File(destination);
        boolean exists = outputFile.exists();
        assertTrue("Output file should exist",exists);
        // Learned how to do this here: https://howtodoinjava.com/java/io/how-to-check-if-file-exists-in-java/
    }
    @Test
    public void testTurnGrey() throws IOException {

        // instantiates two bitmap objects. One transformed and one original to compare.
        BitMap test = new BitMap("src/main/resources/mario.bmp");
        test.turnGrey();
        test.writeBmp(destination);
        BitMap original = new BitMap(destination);

        // Gets three sample colors from 3 points on each bitmap to compare.
        Color testColorOne = new Color(test.imageData.getRGB(1,1));
        Color originalColorOne = new Color(original.imageData.getRGB(1,1));
        Color testColorTwo = new Color(test.imageData.getRGB(5,5));
        Color originalColorTwo = new Color(original.imageData.getRGB(5,5));
        Color testColorThree = new Color(test.imageData.getRGB(10,10));
        Color originalColorThree = new Color(original.imageData.getRGB(10,10));

        Color[] colors = new Color[]{testColorOne,testColorTwo,testColorThree};
        Color[] testArray = new Color[]{originalColorOne,originalColorTwo,originalColorThree};

        // loops through and compares the colors to see if they match the expected value.
        for(int i = 0; i < colors.length;i++) {
            int red = colors[i].getRed();
            int green = colors[i].getGreen();
            int blue = colors[i].getBlue();
            int testColor = new Color(red/4,green/4,blue/4).getRGB();
            int originalRed = testArray[i].getRed();
            int originalGreen = testArray[i].getGreen();
            int originalBlue = testArray[i].getBlue();
            int originalColor = new Color(originalRed/4,originalGreen/4,originalBlue/4).getRGB();
            boolean testTest = testColor == originalColor;
            assertTrue("Colors should match the transform value",testTest);
        }

    }
    @Test
    public void testGreyScale() throws IOException {

        // instantiates two bitmap objects. One transformed and one original to compare.
        BitMap test = new BitMap("src/main/resources/mario.bmp");
        test.greyScale();
        test.writeBmp(destination);
        BitMap original = new BitMap(destination);

        // Gets three sample colors from 3 points on each bitmap to compare.
        Color testColorOne = new Color(test.imageData.getRGB(1,1));
        Color originalColorOne = new Color(original.imageData.getRGB(1,1));
        Color testColorTwo = new Color(test.imageData.getRGB(5,5));
        Color originalColorTwo = new Color(original.imageData.getRGB(5,5));
        Color testColorThree = new Color(test.imageData.getRGB(10,10));
        Color originalColorThree = new Color(original.imageData.getRGB(10,10));

        Color[] colors = new Color[]{testColorOne,testColorTwo,testColorThree};
        Color[] testArray = new Color[]{originalColorOne,originalColorTwo,originalColorThree};

        // loops through and compares the colors to see if they match the expected value.
        for(int i = 0; i < colors.length;i++) {
            int red = colors[i].getRed();
            int green = colors[i].getGreen();
            int blue = colors[i].getBlue();
            int alpha = colors[i].getAlpha();
            int grey = (red + green + blue) / 3;
            int testColor = new Color(grey,grey,grey,alpha).getRGB();
            int originalRed = testArray[i].getRed();
            int originalGreen = testArray[i].getGreen();
            int originalBlue = testArray[i].getBlue();
            int originalAlpha = testArray[i].getAlpha();
            int originalGrey = (originalRed+ originalGreen + originalBlue) / 3;
            int originalColor = new Color(originalGrey,originalGrey,originalGrey,originalAlpha).getRGB();
            boolean testTest = testColor == originalColor;
            assertTrue("Colors should match the transform value",testTest);
        }

    }
}