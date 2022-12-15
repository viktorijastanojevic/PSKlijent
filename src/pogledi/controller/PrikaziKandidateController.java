/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.controller;

import forme.FormaPrikaziKandidate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Kandidat;
import pogledi.cordinator.Cordinator;
import pogledi.forme.komponente.KandidatiModelTabele;

/**
 *
 * @author Viktorija
 */
public class PrikaziKandidateController {
    private final FormaPrikaziKandidate frmPM;

    public PrikaziKandidateController(FormaPrikaziKandidate frmPM) {
        this.frmPM = frmPM;
        addActionListener();
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
        frmPM.getjTableKandidati().setModel(kmt);
    }

    private void addActionListener() {
        frmPM.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = frmPM.getjTableKandidati().getSelectedRow();
                if (red >= 0) {
                    KandidatiModelTabele mmt = (KandidatiModelTabele) frmPM.getjTableKandidati().getModel();
                    Kandidat k = mmt.getMusterijaAt(red);
                    Cordinator.getInstanca().dodajParam("PozicijaKandidat", mmt.getMusterije().indexOf(k));
                    Cordinator.getInstanca().dodajParam("Kandidat", k);
                    try {
                        Komunikacija.getInstanca().obrisiKandidata(k);
                        mmt.obrisiMusteriju(red);
                        frmPM.getjTableKandidati().setModel(mmt);
                        JOptionPane.showMessageDialog(frmPM, "Sistem je obrisao kandidata", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmPM, "Sistem ne moze da obrise kandidata", "Greska", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        });
    }
    
}
