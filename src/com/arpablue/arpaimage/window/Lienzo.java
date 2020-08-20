/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.window;

import com.arpablue.arpaimage.core.Beholder;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author AugLaptop
 */
public class Lienzo extends Canvas implements MouseListener, MouseMotionListener{
    public Lienzo(){
        init();
    }
    protected void init(){
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    @Override
    public void update(Graphics g){
        paint( g );
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Beholder.mouseClicked( e.getX(), e.getY()) ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Beholder.mousePressed( e.getX(), e.getY()) ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Beholder.mouseReleased( e.getX(), e.getY()) ;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Beholder.mouseEntered( e.getX(), e.getY()) ;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Beholder.mouseExited( e.getX(), e.getY()) ;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Beholder.mouseDragged( e.getX(), e.getY()) ;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Beholder.mouseMoved( e.getX(), e.getY()) ;
    }
            
}
