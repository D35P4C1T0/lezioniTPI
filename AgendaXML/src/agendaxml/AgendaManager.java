/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaxml;

/**
 *
 * @author matteo
 */
public class AgendaManager {

    private Agenda agenda;

    public AgendaManager(Agenda agenda) {
        this.agenda = agenda;
    }

    public void addContatto(Contatto cnt) {
        this.agenda.addContatto(cnt);
    }

    public void rmvContatto(Contatto cnt) {
        this.agenda.rmvContatto(cnt);
    }

}