/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

import com.arpablue.arpaimage.paintobj.InteractiveSquare;

/**
 *
 * @author AugLaptop
 */
public class Beholder {
    private static ImageControl ACTIVE;

    public static void setActive( ImageControl active){
        ACTIVE = active;
    }
    public static ImageControl getActive(){
        return ACTIVE;
    }

    public static void mouseClicked(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseClicked(x, y);
    }

    public static void mousePressed(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mousePressed(x, y);
    }

    public static void mouseReleased(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseReleased(x, y);
    }

    public static void mouseEntered(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseEntered(x, y);
    }

    public static void mouseExited(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseExited(x, y);
    }

    public static void mouseDragged(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseDragged(x, y);
    }

    public static void mouseMoved(int x, int y)  {
        if( ACTIVE == null ){
            return;
        }
        ACTIVE.mouseMoved(x, y);
    }

    public static void add(IDraw image) {
      
    }

    
}
