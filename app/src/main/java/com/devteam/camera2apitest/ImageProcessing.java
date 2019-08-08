package com.devteam.camera2apitest;

import android.graphics.Bitmap;
import android.graphics.Color;

public class ImageProcessing {
    //the color that we should search on --> controlled by user touch !
    public int currentColor = Color.argb(1 , 255 , 255 , 255);
    //the x , y coordinates of this color if it is found in the screen
    public int x = 0;
    public int y = 0;
    boolean lightON = false;

    public int number;
    // a counter to see how many pixels with the specified color are found on the screen
    int count = 0;
    //threshold is the maximum difference between the specified color (Current Color) and the the colors on the screen.
    private int threshold = 30;

    public ImageProcessing() { }

    // function to process bitmaps generated from camera
    public void process(Bitmap bitmap) {
        number = 0;
        count = 0;
        lightON = false;
        for (int i = 0; i < bitmap.getWidth(); i += 5) {
            for (int j = 0; j < bitmap.getHeight(); j += 5) {
                // get each pixel and extract r , g & b colors from it
                int p = bitmap.getPixel(i, j);
                int r1 = Color.red(p);
                int g1 = Color.green(p);
                int b1 = Color.blue(p);
                // our current color ( r , g , b ) attributes !
                int r2 = Color.red(currentColor);
                int g2 = Color.green(currentColor);
                int b2 = Color.blue(currentColor);

                if (dis(r1, g1, b1, r2, g2, b2) < threshold) {
                    if(VerifyBlock(r1, g1, b1, r2, g2, b2) == true){
                        x = i;
                        y = j;
                        if(checkBrightness(r1, g1, b1, r2, g2, b2) == true){
                            lightON = true;
                        }
                    }
                }

            }
        }
    }


    boolean VerifyBlock(int r1, int g1, int b1, int r2, int g2, int b2){
        int count=0;
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                int d=Math.abs(r1-r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);

                if(d < threshold)
                    count++;
            }

        if(count >300)
            return true;


        return false;
    }
    //Function to calculate the euclidean distance between two colors and return how much they are "Different"
    public int dis(int r1, int g1, int b1, int r2, int g2, int b2) {

        int difference = (int) Math.sqrt(Math.pow(Math.abs(r1 - r2), 2) + Math.pow(Math.abs(g1 - g2), 2) + Math.pow(Math.abs(b1 - b2), 2));

        return difference;
    }

    public boolean checkBrightness ( int r1, int g1, int b1, int r2, int g2, int b2 ) {
        int count  = 0;
        int d=Math.abs(r1-r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
        for (int i = x; i < x + 200 ; i++) {
            for ( int j = y + 200; j < y + 400 ; j++ ) {
                if(d < 50)
                    count++;
            }
        }
        if(count > 300)
            return true;

        return false;
    }
}
