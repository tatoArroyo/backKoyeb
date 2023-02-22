package com.MiPortfolio.Oscar.Dto;

import java.util.Date;



public class dtoEstudios {

    private String nombreE;
    private String descripcionE;

    private Date fin;

    private String titulo;
    private String img;
//constructores

    public dtoEstudios() {
    }

    public dtoEstudios(String nombreE, String descripcionE, Date fin, String titulo, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fin = fin;
        this.titulo = titulo;
        this.img = img;
    }

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

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

  

    
}
