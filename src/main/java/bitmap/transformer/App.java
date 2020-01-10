/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        BitMap bmp = new BitMap(args[0]);
        String destination = args[1];
        if(args[2].equals("greyScale")) {
            bmp.greyScale();
        }
        if(args[2].equals("turnGray")){
            bmp.turnGray();
        }
        if(args[2].equals("mirror")){
            bmp.mirror();
        }
        bmp.writeBmp(destination);
    }

}
