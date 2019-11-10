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
public class Contatto {

    private String nome;
    private String cognome;
    private String nTel;

    public Contatto(String nome, String cognome, String nTel) {
        this.nome = nome;
        this.cognome = cognome;
        this.nTel = nTel;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getnTel() {
        return nTel;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
