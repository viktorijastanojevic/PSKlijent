/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.controller;

import forme.GlavnaForma;

/**
 *
 * @author Viktorija
 */
public class GlavniController {
    private final GlavnaForma frmGlavna;

    public GlavniController(GlavnaForma frmGlavna) {
        this.frmGlavna = frmGlavna;
        //addActionListener();
    }
    
    public void otvoriFormu() throws Exception {
        //pripremiFormu();
        frmGlavna.setVisible(true);
    }
    public GlavnaForma getFrmGlavna() {
        return frmGlavna;
    }
}
