package com.devteam.camera2apitest;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.media.Image;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * class used to draw on
 */
public class Canvas_ extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder = null;

    private Paint paint = null;
    AnimatedImage ufo = new AnimatedImage();
    ArrayList<Bitmap> imageArray = new ArrayList<>();
    private int score = 0;
    long startNanoTime;
    private int counter = 0;
    int lastXpos = 0;
    int lastYpos = 0;
    int xPos;
    int yPos;
    @Override
    protected void onDraw(Canvas canvas ) {
        super.onDraw(canvas);

    }

    public Canvas_(Context context ) {
        super(context);
        setFocusable(true);
        // Get surfaceHolder object.
        surfaceHolder = getHolder();
        // Add this as surfaceHolder callback object.
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        if (paint == null) {
            paint = new Paint();

            paint.setColor(Color.RED);
        }

        // Set the parent view background color. This can not set surfaceview background color.
        this.setBackgroundColor(Color.BLUE);

        // Set current surfaceview at top of the view tree.
        this.setZOrderOnTop(true);

        this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._1));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._2));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._3));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._4));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._5));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._6));
        imageArray.add(BitmapFactory.decodeResource(getResources(), R.drawable._7));

        ufo.frames = imageArray;
        ufo.duration = 1.000;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startNanoTime = System.nanoTime();
        //drawBall(200 , 200 );
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void drawBall(float x, float y ) {
        long currentNanoTime = System.nanoTime();
        double deltaTime = (int) ((currentNanoTime - startNanoTime) / 1000000);
        startNanoTime = currentNanoTime;
        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();
        //set the drawing color ==> here is white
        surfaceBackground.setColor(Color.RED);
        Paint surfaceBackground2 = new Paint();
        //set the drawing color ==> here is white
        surfaceBackground2.setColor(Color.BLACK);
        //apply clear mode drawing to clear the screen after each frame draw
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);


        counter++;
        int mCounter = counter % 20;
        // Draw the circle.
        //check if coordinates are coming from imageProcessing class or not
        if (x != 0 && x < this.getWidth() && y != 0 && y < this.getHeight()) {
            //draw a white circle on specified x , y coordinates
            //canvas.drawCircle(x, y, 100, surfaceBackground);
//            Matrix matrix = new Matrix();
//            matrix.setScale(0.5f , 0.5f);
//            matrix.setRotate(1, x  , y  );
//            canvas.drawBitmap(ufo.getFrame(deltaTime), matrix, paint);
//            canvas.drawBitmap(ufo.getFrame(1), matrix, paint);

            int LeftXPos = 0 ;//0
            int RightXPos = 500;//200
            int TopYPos = 100 ;//100
            int BotYPos = 600 ;//300
            if(mCounter == 0){
                xPos = (int) x;
                yPos = (int) y;
                lastXpos = xPos;
                lastYpos = yPos;
            }else{
                xPos = lastXpos;
                yPos = lastYpos;
            }
            xPos -= 100;
            yPos -= 150;
            int distanceBtween2Images = 1070;
            canvas.drawBitmap(ufo.getFrame(counter % imageArray.size()), null, new Rect(LeftXPos + xPos , TopYPos + yPos, RightXPos + xPos , BotYPos + yPos) , paint);
            canvas.drawBitmap(ufo.getFrame(counter % imageArray.size()), null, new Rect(LeftXPos + xPos , TopYPos + yPos + distanceBtween2Images, RightXPos + xPos , BotYPos + yPos + distanceBtween2Images) , paint);
//            canvas.drawCircle(x + 200,y + 300 ,100, surfaceBackground);
//            canvas.drawCircle(x+200,y + 1000 +300 ,100, surfaceBackground);
        }
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }

}