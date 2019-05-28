/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telekocsi;

/**
 *
 * @author Ilyés Ádám
 */
public class Auto {

    private final String indul;
    private final String cel;
    private final String rendszam;
    private final String telefon;
    private final int hely;
    private boolean utas;

    public Auto(String indul, String cel, String rendszam, String telefon, int hely) {
        this.indul = indul;
        this.cel = cel;
        this.rendszam = rendszam;
        this.telefon = telefon;
        this.hely = hely;
        this.utas = false;
    }

    public boolean isUtas() {
        return utas;
    }

    public void setUtas(boolean utas) {
        this.utas = utas;
    }

    public String getIndul() {
        return indul;
    }

    public String getCel() {
        return cel;
    }

    public String getRendszam() {
        return rendszam;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getHely() {
        return hely;
    }

}
