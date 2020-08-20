/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.img;

import com.arpablue.arpaimage.gif.GifDecoder;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AugLaptop
 */
public class ImageSpliterTest {
    
    public ImageSpliterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of split method, of class ImageSpliter.
     */
//    @Test
    public void test_ImageSpliter_splitImage() {
        String imgPath = "./testResource/psylockeSprite.png";
        ImageSpliter target  = new ImageSpliter();
        target.set(1, 30);
        BufferedImage img = DrawImage.loadImage( imgPath );
        if( img == null ){
            fail("It is not possible load the image ["+imgPath+"].");
        }
        target.setImage(img);
        ArrayList<BufferedImage> imgs = target.split();
        int index = 0;
        String pimg ;
        for( BufferedImage i : imgs ){
            index++;
            if( i != null ){
                pimg = "./testResource/psy_"+index+".png";
                if( DrawImage.saveImage(i, pimg) ){
                    System.out.println(" - SUCCESS: The ["+pimg+"] file has been saved.");
                }else{
                    System.out.println(" - FAIL: The ["+pimg+"] file cannot be saved.");
                }
                
            }
        }
    }
    @Test
   public void test_GifDecoder_LoadImages(){
               String imgPath = "./testResource/taunt2.gif";
        GifDecoder gif = new GifDecoder();
        gif.read(imgPath);
        ArrayList<BufferedImage> imgs = gif.getFrames();
        System.out.println("size - > "+imgs.size());
        int index = 0;
        String pimg ;
        for( BufferedImage i : imgs ){
            index++;
            if( i != null ){
                pimg = "./testResource/chunli_"+index+".png";
                if( DrawImage.saveImage(i, pimg) ){
                    System.out.println(" - SUCCESS: The ["+pimg+"] file has been saved.");
                }else{
                    System.out.println(" - FAIL: The ["+pimg+"] file cannot be saved.");
                }
                
            }
        }
   }

    
}
