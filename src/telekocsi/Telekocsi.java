/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telekocsi;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Ilyés Ádám
 */
public class Telekocsi {

    static ArrayList<Auto> list1 = new ArrayList<>();
    static ArrayList<Igeny> list2 = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
    }

    public static void feladat1() {
        try (Scanner be1 = new Scanner(new File("autok.csv"), "Cp1250")) {
            be1.nextLine();
            Auto a;
            while (be1.hasNextLine()) {
                String s[] = be1.nextLine().split(";");
                a = new Auto(s[0], s[1], s[2], s[3], Integer.parseInt(s[4]));
                list1.add(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void feladat2() {
        System.out.println("2. Feladat:");
        System.out.println("\t" + list1.size() + " autós hirdet fuvart");
    }

    public static void feladat3() {
        System.out.println("3. Feladat:");
        int szum = 0;
        for (Auto a : list1) {
            if (a.getIndul().equals("Budapest") && a.getCel().equals("Miskolc")) {
                szum += a.getHely();
            }
        }

        System.out.println("\tÖsszesen: " + szum + " férőhelyet hirdettek meg Budapestről Miskolcra");
    }

    public static void feladat4() {
        System.out.println("4. Feladat:");
        HashMap<String, Integer> ferohely = new HashMap<>();

        for (Auto ig : list1) {
            String s = ig.getIndul() + "-" + ig.getCel();
            Integer db = ferohely.get(s);
            if (db == null) {
                db = ig.getHely();
            } else {
                db += ig.getHely();
            }
            ferohely.put(s, db);
        }

        TreeMap<Integer, String> helyek = new TreeMap<>();

        for (String o : ferohely.keySet()) {
            helyek.put(ferohely.get(o), o);
        }

        int max = helyek.lastKey();

        System.out.println("\tA legtöbb férőhelyet (" + max + " hely) a " + helyek.get(max)
                + " útvonalon hirdettek meg");
    }

    public static void feladat5() {
        try (Scanner be2 = new Scanner(new File("igenyek.csv"), "Cp1250")) {
            be2.nextLine();
            Igeny ig;
            while (be2.hasNextLine()) {
                String s[] = be2.nextLine().split(";");
                ig = new Igeny(s[0], s[1], s[2], Integer.parseInt(s[3]));
                list2.add(ig);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("5. Feladat:");

        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (list2.get(i).getIndul().equals(list1.get(j).getIndul())
                        && list2.get(i).getCel().equals(list1.get(j).getCel()) && !list1.get(j).isUtas()
                        && list2.get(i).getFo() <= list1.get(j).getHely()) {
                    System.out.println("\t" + list2.get(i).getAzon() + " => " + list1.get(j).getRendszam());
                    list1.get(j).setUtas(true);
                    break;
                }
            }
        }
    }

    public static void feladat6() {
        System.out.println("6. Feladat: utasuzenetek.txt");
        for (Auto a : list1) {
            a.setUtas(false);
        }

        try (PrintWriter ki = new PrintWriter(new File("utasuzenetek.txt"))) {
            for (int i = 0; i < list2.size(); i++) {
                for (int j = 0; j < list1.size(); j++) {
                    if (list2.get(i).getIndul().equals(list1.get(j).getIndul())
                            && list2.get(i).getCel().equals(list1.get(j).getCel()) && !list1.get(j).isUtas()
                            && list2.get(i).getFo() <= list1.get(j).getHely()) {
                        ki.println(list2.get(i).getAzon() + ": Rendszám: " + list1.get(j).getRendszam()
                                + ", Telefonszám: " + list1.get(j).getTelefon());
                        list1.get(j).setUtas(true);
                        list2.get(i).setSiker(true);
                        break;
                    }
                }
                if (!list2.get(i).isSiker()) {
                    ki.println(list2.get(i).getAzon() + ": Sajnos nem sikerült autót találni");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
