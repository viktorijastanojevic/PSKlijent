/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.forme.komponente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kandidat;

/**
 *
 * @author Viktorija
 */
public class KandidatiModelTabele extends AbstractTableModel{
    
    List<Kandidat> musterije= new ArrayList<>();
    String[] kolone = {"Ime", "Prezime", "Telefon", "Adresa"};

    public KandidatiModelTabele(List<Kandidat> musterije) {
        this.musterije = musterije;
    }
        @Override
    public int getRowCount() {
        return musterije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Kandidat> getMusterije() {
        return musterije;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return musterije.get(rowIndex).getIme();
            case 1:
                return musterije.get(rowIndex).getPrezime();
            case 2:
                return musterije.get(rowIndex).getBrojTelefona();
            case 3:
                return musterije.get(rowIndex).getAdresa();
            default:
                return "N/A";
        }
    }

    public Kandidat getMusterijaAt(int index) {
        return musterije.get(index);
    }


    public void izmeniElement(int i, Kandidat musterija) {
        musterije.set(i, musterija);
        fireTableRowsUpdated(i, i);
    }

 

    public void obrisiMusteriju(int red) {
        if(red>=0){
            musterije.remove(red);
        }
    fireTableRowsDeleted(red, red);
    }
}
