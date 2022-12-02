/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pogledi.cordinator;

import forme.LoginForma;
import java.util.HashMap;
import java.util.Map;
import pogledi.controller.LogInController;

/**
 *
 * @author Viktorija
 */
public class Cordinator {
    private static Cordinator instanca;


    private Map<String, Object> parametri;
    private Cordinator() {
        parametri = new HashMap<>();
    }

    public static Cordinator getInstanca() {
        if (instanca == null) {
            instanca = new Cordinator();
        }
        return instanca;
    }

    public void dodajParam(String s, Object o) {
        parametri.put(s, o);
    }

    public Object vratiParam(String s) {
        return parametri.get(s);
    }

    public void otvoriLoginFormu() {
        LogInController frmLogin = new LogInController(new LoginForma());
        frmLogin.otvoriFormu();
        }
    }