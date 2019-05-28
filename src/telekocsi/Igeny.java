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
public class Igeny {

    private final String azon;
    private final String indul;
    private final String cel;
    private final int fo;
    private boolean siker;

    public Igeny(String azon, String indul, String cel, int fo) {
        this.azon = azon;
        this.indul = indul;
        this.cel = cel;
        this.fo = fo;
        this.siker = false;
    }

    public boolean isSiker() {
        return siker;
    }

    public void setSiker(boolean siker) {
        this.siker = siker;
    }

    public String getAzon() {
        return azon;
    }

    public String getIndul() {
        return indul;
    }

    public String getCel() {
        return cel;
    }

    public int getFo() {
        return fo;
    }

}
