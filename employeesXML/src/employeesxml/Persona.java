/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesxml;

/**
 *
 * @author matteo
 */
public class Persona {

    private String ID;
    private String nome;
    private String cognome;
    private String paese;

    public String getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getPaese() {
        return paese;
    }

    public Persona(String ID, String nome, String cognome, String paese) {
        this.ID = ID;
        this.nome = nome;
        this.cognome = cognome;
        this.paese = paese;
    }

    @Override
    public String toString() {
        return "Persona{" + "ID=" + ID + ", nome=" + nome + ", cognome=" + cognome + ", paese=" + paese + '}';
    }

}
