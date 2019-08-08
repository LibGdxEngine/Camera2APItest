package com.devteam.camera2apitest;

import android.graphics.Point;
import android.icu.text.IDNA;

public class Find {
    public IDNA.Info aInfo;
    public int RMid=0, GMid=0, BMid=0,Thresh=100;

//    public Point Find(){
//
//        Point p1=new Point (-1,-1);
//        int W1=200;
//        int H1=200;
//
//
//        for(int j=0;j<H1;j++)
//            for(int i=0;i<W1;i++){
//                int c1=aInfo.Total_Image.getRGB(i, j);
//                int R =  ((c1 >> 16) & 0x000000FF);
//                int G =  ((c1 >> 8) & 0x000000FF);
//                int B =  ((c1 ) & 0x000000FF);
//                int d=Math.abs(R-RMid) + Math.abs(G-GMid) + Math.abs(B-BMid);
//
//                if(d<50)
//                {
//                    if(VerifyBlock(i,j)) ;
//                    return new Point(i,j);
//                }
//
//
//            }
//
//
//
//
//        return p1;
//    }
//    ////////////////////////////
//    boolean VerifyBlock(int x,int y){
//        int count=0;
//        for(int i=0;i<20;i++)
//            for(int j=0;j<20;j++){
//
//                int c1=aInfo.Total_Image.getRGB(i, j);
//                int R =  ((c1 >> 16) & 0x000000FF);
//                int G =  ((c1 >> 8) & 0x000000FF);
//                int B =  ((c1 ) & 0x000000FF);
//                int d=Math.abs(R-RMid) + Math.abs(G-GMid) + Math.abs(B-BMid);
//
//                if(d<50)
//                    count++;
//
//            }
//
//        if(count >300)
//            return true;
//
//
//        return false;
//    }

}