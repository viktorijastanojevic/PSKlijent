/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.controller;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Zaposleni;
import pogledi.cordinator.Cordinator;
/**
 *
 * @author Viktorija
 */
public class LogInController {
  private final LoginForma frmLogIn;

    public LogInController(LoginForma frmLogIn) {
        this.frmLogIn = frmLogIn;
        addActionListeners(); // na dugme stavi listener
    }

    public void otvoriFormu() {
        frmLogIn.setVisible(true);
       
    }
    

    private void addActionListeners() {
        frmLogIn.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            public void prijava(ActionEvent e) {
                System.out.println("Kliknuto dugme");
                try {
                    String korisnickoIme = frmLogIn.getjTextFieldKorisnickoIme().getText().trim();
                    String sifra = String.copyValueOf(frmLogIn.getjTextFieldLozinka().getPassword()).trim();
                   // frmLogIn.getLblKorisnickoImeValidacija().setText("");
                    //frmLogIn.getLblSifraValidacija().setText("");
                    //validirajKorisnika(korisnickoIme, sifra);
                    Komunikacija.getInstanca().konekcija();
                    Zaposleni z = Komunikacija.getInstanca().logIn(korisnickoIme,sifra);
                   // Cordinator.getInstanca().dodajParam("korisnik", k);
                    JOptionPane.showMessageDialog(frmLogIn, "Prijava na sistem uspesna","Uspeh",JOptionPane.INFORMATION_MESSAGE);
                    Cordinator.getInstanca().otvoriGlavnuFormu();
                    frmLogIn.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmLogIn, "Sistem ne moze da pronadje trazeni nalog", "Greska", JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex.getMessage());
                }
            }

           /* private void validirajKorisnika(String korisnickoIme, String sifra) throws Exception {
                if (korisnickoIme.equals("") || sifra.equals("")) {
                    if (korisnickoIme.equals("")) {
                        frmLogIn.getLblKorisnickoImeValidacija().setText("Unesite korisnicko ime");
                    }
                    if (sifra.equals("")) {
                        frmLogIn.getLblSifraValidacija().setText("Unesite sifru");
                    }

                    frmLogIn.getTxtSifra().setText("");
                    throw new Exception("Korisnicko ime i sifra moraju biti uneti");
                }
                frmLogIn.getLblKorisnickoImeValidacija().setText("");
                frmLogIn.getLblSifraValidacija().setText("");
            } */
        });
    }  
}
