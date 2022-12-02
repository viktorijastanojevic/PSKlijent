/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.controller;

import forme.FormaPrikaziKandidate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Kandidat;
import pogledi.forme.komponente.KandidatiModelTabele;

/**
 *
 * @author Viktorija
 */
public class PrikaziKandidateController {
    private final FormaPrikaziKandidate frmPM;

    public PrikaziKandidateController(FormaPrikaziKandidate frmPM) {
        this.frmPM = frmPM;
       // addActionListener();
    }

    public PrikaziKandidateController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        
    public void otvoriFormu() {
        try {
            pripremiFormu();
            frmPM.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmPM, "Greska prilikom ucitavanja. Molimo Vas da probate ponovo", "Greska", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    private void pripremiFormu() throws Exception {
        List<Kandidat> kandidati= new ArrayList<>();
        kandidati=Komunikacija.getInstanca().ucitajKandidate();
        KandidatiModelTabele kmt = new KandidatiModelTabele(kandidati);
        frmPM.getjTable1().setModel(kmt);
    }
    
}
