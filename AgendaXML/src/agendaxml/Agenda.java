/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

import java.util.List;

/**
 *
 * @author matteo
 */
public class Agenda {

    private List<Contatto> listaContatti;

    public Agenda() {
    }

    public Agenda(List<Contatto> listaContatti) {
        this.listaContatti = listaContatti;
    }

    public void addContatto(Contatto cnt) {
        this.listaContatti.add(cnt);
    }

    public void rmvContatto(Contatto cnt) {
        this.listaContatti.remove(cnt);
    }

}
