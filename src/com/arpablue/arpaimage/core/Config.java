/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arpablue.arpaimage.core;

import com.arpablue.jsontree.JSONtree;

/**
 *
 * @author AugLaptop
 */
public class Config {
    protected static JSONtree SETTINGS;
    public JSONtree getSettings(){
        if( SETTINGS == null ){
            SETTINGS = new JSONtree();
            
        }
        return SETTINGS;
    }
}
