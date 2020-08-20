/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.img;

import com.arpablue.arpaimage.core.IDraw;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author AugLaptop
 */
public class DrawImage extends IDraw {

    protected BufferedImage mImg;

    public void setImage(BufferedImage img) {
        mImg = img;
    }

    public void setImage(String file) {
        mImg = loadImage(file);
        if (mImg == null) {
            this.setWitdh(0);
            this.setHeight(0);
            return;
        }
        this.setWitdh(mImg.getHeight());
        this.setHeight(mImg.getHeight());
    }

    public void setImage(File file) {
        mImg = loadImage(file);
        if (mImg == null) {
            this.setWitdh(0);
            this.setHeight(0);
            return;
        }
        this.setWitdh(mImg.getHeight());
        this.setHeight(mImg.getHeight());
    }

    /**
     * It load a image from specific path.
     *
     * @param imagePath It is the path of the file.
     * @return It is the image loaded, if the image not exists then the method
     * return null.
     */
    public static BufferedImage loadImage(String imagePath) {
        if (imagePath == null) {
            return null;
        }
        return loadImage(new File(imagePath));
    }

    /**
     * It load an image from a File object, if the image not exists or is not a
     * image then the method return null.
     *
     * @param imageIt is the image loaded.
     * @return It is the image loaded.
     */
    public static BufferedImage loadImage(File image) {
        BufferedImage img = null;
        try {
            if (image == null) {
                return null;
            }
            if (!image.exists()) {
                return null;
            }
            if (!image.isFile()) {
                return null;
            }
            img = ImageIO.read(image);
            return img;
        } catch (IOException e) {
        }
        return null;
    }

    public static BufferedImage[] loadGifImage(String gifFile) {
        return null;
    }

    public static boolean saveImage(BufferedImage img, String path) {
        if (path == null) {
            return false;
        }
        return saveImage(img, new File(path));
    }

    public static boolean saveImage(BufferedImage img, File file) {
        if (file == null) {
            return false;
        }
        if (img == null) {
            return false;
        }
        try {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            ImageIO.write(img, "png", file);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void getImage(Graphics2D g) {
        if (g == null) {
            return;
        }
        if (mImg == null) {
            return;
        }
        g.drawImage(mImg, (int) this.getX(), (int) this.getY(), null);
    }

    @Override
    public void mouseClicked(int x, int y) {
    }

    @Override
    public void mousePressed(int x, int y) {
    }

    @Override
    public void mouseReleased(int x, int y) {
    }

    @Override
    public void mouseEntered(int x, int y) {
    }

    @Override
    public void mouseExited(int x, int y) {
    }

    @Override
    public void mouseDragged(int x, int y) {
    }

    @Override
    public void mouseMoved(int x, int y) {
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
