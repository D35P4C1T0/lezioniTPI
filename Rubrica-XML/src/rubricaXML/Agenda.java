/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaXML;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Agenda {

    private ArrayList<Contatto> listaContatti;

    public Agenda() {
        this.listaContatti = new ArrayList<>();
    }

    public Agenda(ArrayList<Contatto> listaContatti) {
        this.listaContatti = listaContatti;
    }

    public void addContatto(Contatto cnt) {
        this.listaContatti.add(cnt);
    }

    public void addContattoIndex(Contatto cnt, int i) {
        this.listaContatti.add(i, cnt);
    }

    public void rmvContatto(Contatto cnt) {
        this.listaContatti.remove(cnt);
    }

    public void rmvContattoIndex(int i) {
        this.listaContatti.remove(i);
    }

    public ArrayList<Contatto> getListaContatti() {
        return listaContatti;
    }

}
