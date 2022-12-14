/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import komunikacija.util.Operacije;
import model.Kandidat;
import model.Zaposleni;
/**
 *
 * @author Viktorija
 */
public class Komunikacija {
    private static Komunikacija instanca;
    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    
        private Komunikacija() {
    }

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    public void konekcija() throws Exception {
        try {
            soket = new Socket("localhost", 9000);
            System.out.println("AA");
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {
            throw new Exception("Server is not connected!");
        }
    }

    public Zaposleni logIn(String korisnickoIme, String sifra) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, new Zaposleni("","",korisnickoIme, sifra, false));
        posiljalac.posalji(zahtev);
        System.out.println(zahtev);
        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println(odgovor);
        if (odgovor.getGreska() == null) {
            return (Zaposleni) odgovor.getPodatak();
        } else {
            throw odgovor.getGreska();
    }
    }

    public List<Kandidat> ucitajKandidate() throws Exception {
Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KANDIDATE, null);
        System.out.println(zahtev);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
         System.out.println(odgovor);
        if (odgovor.getGreska() == null) {
            return (List<Kandidat>) odgovor.getPodatak();
        } else {
            throw odgovor.getGreska();
        }
    }

    public void ubaci(Kandidat kandidat) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.ZAPAMTI_KANDIDATA, kandidat);
        System.out.println(zahtev);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println(odgovor);
        if (odgovor.getGreska() == null) {
            return;
        } else {
            throw odgovor.getGreska();
        }
    }

    public void obrisiKandidata(Kandidat k) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.OBRISI_KANDIDATA, k);
        System.out.println(zahtev);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println(odgovor);
        if (odgovor.getGreska() == null) {
            return;
        } else {
            throw odgovor.getGreska();
        }
    }
}
