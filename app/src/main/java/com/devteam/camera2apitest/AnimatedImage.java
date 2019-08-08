package com.devteam.camera2apitest;

import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;

public class AnimatedImage {

    public ArrayList<Bitmap> frames;
    public double duration;

    public Bitmap getFrame(double time)
    {
        int index = (int)((time % (frames.size() * duration)) / duration);
        return frames.get(index);
    }

}
