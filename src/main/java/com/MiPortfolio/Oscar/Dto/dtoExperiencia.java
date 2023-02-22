
package com.MiPortfolio.Oscar.Dto;


import java.util.Date;


public class dtoExperiencia {

    private String nombreE;

    private String descripcionE;

    private Date inicio;

    private Date fin;

    private String puesto;

    private String img;
    
    //constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, Date inicio, Date fin, String puesto, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.inicio = inicio;
        this.fin = fin;
        this.puesto = puesto;
        this.img = img;
    }

    //getter and setter

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
