/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.window;

import arpaimage.WinMain;
import com.arpablue.arpaimage.core.Paralel;
import com.arpablue.arpaimage.img.DrawImage;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author AugLaptop
 */
public class ImageChooserDlg extends ImageExplorerDlg implements PropertyChangeListener, ActionListener {

    private Paralel mDraw;
    private DrawImage mImg;
    private WinMain mParent;

    public ImageChooserDlg(Frame parent, boolean modal) {
        super(parent, modal);
        if (parent == null) {
            return;
        }
        if (parent instanceof WinMain) {
            mParent = (WinMain) parent;
        }

    }

    @Override
    protected void init() {
        super.init();
        FileFilter pngFilter = new FileTypeFilter(".png", "Portable Network Graphics");
        FileFilter jpgFilter = new FileTypeFilter(".jpg", "Joint Photographic Experts Group");
        FileFilter jpegFilter = new FileTypeFilter(".jpeg", "Joint Photographic Experts Group");

        this.getFileChooser().addChoosableFileFilter(pngFilter);
        this.getFileChooser().addChoosableFileFilter(jpgFilter);
        this.getFileChooser().addChoosableFileFilter(jpegFilter);
        this.getFileChooser().setFileFilter(pngFilter);
        this.getFileChooser().addPropertyChangeListener(this);
        mImg = new DrawImage();
        mDraw = new Paralel();
        mDraw.setCanvas(this.getCanvas());

        this.getFileChooser().addActionListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JFileChooser chooser = (JFileChooser) evt.getSource();
//          File oldFile = (File) evt.getOldValue();
//          File newFile = (File) evt.getNewValue();
//
//          System.out.println("Old file: "+oldFile);
//          System.out.println("New file: "+newFile);
        showFile(chooser.getSelectedFile());

    }

    public void showFile(File file) {
        mImg.setImage(file);
        mDraw.setDrawObject(mImg);

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.mImg = null;
        mDraw.stop();
    }

    @Override
    public void setVisible(boolean flag) {
        if (mDraw != null) {
            mDraw.start();
        }
        super.setVisible(flag);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals(JFileChooser.CANCEL_SELECTION) ) {
            this.mImg = null;
        }
        if( mParent != null ){
            mParent.add( mImg );
        }
        this.setVisible(false);
    }

}
