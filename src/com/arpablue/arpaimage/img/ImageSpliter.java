/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.img;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author AugLaptop
 */
public class ImageSpliter {

    protected int mCols;
    protected int mRows;
    protected int mWidth;
    protected int mHeight;
    protected BufferedImage mImg;

    public ImageSpliter() {

    }

    public void setCols(int cols) {
        mCols = cols;
    }

    public void setRows(int rows) {
        mRows = rows;
    }

    public int getRows() {
        return mRows;
    }

    public int getCols() {
        return mRows;
    }

    public void set(int cols, int rows) {
        setCols(cols);
        setRows(rows);
    }

    public void setImage(BufferedImage image) {
        mImg = image;
    }

    public ArrayList<BufferedImage> split() {
        ArrayList<BufferedImage> res = new ArrayList<BufferedImage>();
        if (mImg == null) {
            return res;
        }
        calculateDimension();
        for (int j = 0; j < mRows; j++) {
            for (int i = 0; i < mCols; i++) {
                res.add(mImg.getSubimage((i * mWidth) + 1, (j * mHeight) + 1, mWidth - 1, mHeight - 1));
            }
        }
        return res;
    }

    protected void calculateDimension() {
        if (mCols <= 0) {
            mCols = 1;
        }
        if (mRows <= 0) {
            mRows = 1;
        }
        mWidth = mImg.getWidth() / mCols;
        mHeight = mImg.getHeight() / mRows;

    }

}
