/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.scene.control.DatePicker;

/**
 *
 * @author Logan
 */
public class Cotiser {
    private int idMembre;
    private DatePicker dateVersement;
    private int Cotisation;
    private int don;
    private boolean recuEmail;

    public Cotiser(int idMembre, DatePicker dateVersement, int Cotisation, int don, boolean recuEmail) {
        this.idMembre = idMembre;
        this.dateVersement = dateVersement;
        this.Cotisation = Cotisation;
        this.don = don;
        this.recuEmail = recuEmail;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public DatePicker getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(DatePicker dateVersement) {
        this.dateVersement = dateVersement;
    }

    public int getCotisation() {
        return Cotisation;
    }

    public void setCotisation(int Cotisation) {
        this.Cotisation = Cotisation;
    }

    public int getDon() {
        return don;
    }

    public void setDon(int don) {
        this.don = don;
    }

    public boolean isRecuEmail() {
        return recuEmail;
    }

    public void setRecuEmail(boolean recuEmail) {
        this.recuEmail = recuEmail;
    }
    
    
}
