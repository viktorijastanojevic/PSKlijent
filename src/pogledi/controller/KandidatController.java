/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.controller;

import forme.FormaKandidat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Kandidat;
import pogledi.cordinator.Cordinator;
import pogledi.forme.util.FormaMod;

/**
 *
 * @author Viktorija
 */
public class KandidatController {
    private final FormaKandidat frmKandidat;

    public KandidatController(FormaKandidat frmKlijent) {
        this.frmKandidat = frmKlijent;
        addActionListener();
    }
    public void otvoriFormu(FormaMod formaMod) {
        try {
            pripremiFormu(formaMod);
            frmKandidat.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmKandidat, "Sistem nije uspeo da otvori formu", "Greska", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void addActionListener() {
            frmKandidat.addBtnSacuvajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  //  validacija();
                    sacuvaj();
                    JOptionPane.showMessageDialog(frmKandidat, "Sistem je uspesno zapamtio kandidata", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    frmKandidat.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmKandidat, "Sistem nije uspeo da zapamti kandidata", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }

            /* private void validacija() throws Exception {
                if (frmKandidat.getTxtTelefon().getText()== null || frmKandidat.getTxtTelefon().getText().equals("")) {
                    throw new Exception("Nije unesen telefon");
                }
                if (frmKandidat.getTxtIme() == null || frmKandidat.getTxtIme().getText().equals("")) {
                    throw new Exception("Nije uneseno ime");
                }
                if (frmKandidat.getTxtPrezime() == null || frmKandidat.getTxtPrezime().getText().equals("")) {
                    throw new Exception("Nije uneseno prezime");
                }
            } */

            private void sacuvaj() throws Exception {
                Kandidat kandidat = new Kandidat(Integer.MIN_VALUE, frmKandidat.getjTextFieldIme().getText(), frmKandidat.getjTextFieldPrezime().getText(), frmKandidat.getjTextFieldBrojTelefona().getText(), frmKandidat.getjTextFieldAdresa().getText());
                Komunikacija.getInstanca().ubaci(kandidat);
            }
        });

        frmKandidat.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   // validacija();
                    izmeni();
                    JOptionPane.showMessageDialog(frmKandidat, "Sistem je uspesno obradio kandidata", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    frmKandidat.dispose();
                  //  Cordinator.getInstanca().srediFormuPrikazMusterija();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmKandidat, "Sistem nije uspeo da obradi kandidata", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }

          /*  private void validacija() throws Exception {
                if (frmKandidat.getTxtTelefon() == null || frmKandidat.getTxtTelefon().getText().equals("")) {
                    throw new Exception("Nije unesena adresa");
                }
                if (frmKandidat.getTxtIme() == null || frmKandidat.getTxtIme().getText().equals("")) {
                    throw new Exception("Nije uneseno ime");
                }
                if (frmKandidat.getTxtPrezime() == null || frmKandidat.getTxtPrezime().getText().equals("")) {
                    throw new Exception("Nije uneseno prezime");
                }
            } */

            private void izmeni() throws Exception {
              //  Klijent musterija = (Klijent) Cordinator.getInstanca().vratiParam("Musterija");
             //   musterija.setIme(frmKandidat.getTxtIme().getText());
              //  musterija.setPrezime(frmKandidat.getTxtPrezime().getText());
               // musterija.setTelefon(frmKandidat.getTxtTelefon().getText());
                
               
             //   Komunikacija.getInstanca().izmeni(musterija);
             //  Cordinator.getInstanca().dodajParam("Musterija", musterija);
            }
        });
         
         
         
         
         
         
     }
    private void pripremiFormu(FormaMod formaMod) throws Exception {
         
        pripremiMod(formaMod);

    }
    private void pripremiMod(FormaMod formaMod) {
        switch (formaMod) {
            case DODAJ:
                frmKandidat.getjButtonSacuvaj().setEnabled(true);
                frmKandidat.getjButtonSacuvaj().setVisible(true);
                frmKandidat.getjButtonIzmeni().setVisible(false);
                frmKandidat.getjTextFieldIme().setText("");
                frmKandidat.getjTextFieldPrezime().setText("");
                frmKandidat.getjTextFieldAdresa().setText("");
                frmKandidat.getjTextFieldBrojTelefona().setText("");
                break;
           // case IZMENI:
             //   frmKandidat.getBtnIzmeni().setVisible(true);
               // frmKandidat.getBtnIzmeni().setEnabled(true);
                //frmKandidat.getBtnSacuvaj().setVisible(false);
                //Klijent m = (Klijent) Cordinator.getInstanca().vratiParam("Musterija");
                //frmKandidat.getTxtIme().setText(m.getIme());
                //frmKandidat.getTxtPrezime().setText(m.getPrezime());
                //frmKandidat.getTxtTelefon().setText(m.getTelefon());

              

               // break;
        }
    }
    
}
