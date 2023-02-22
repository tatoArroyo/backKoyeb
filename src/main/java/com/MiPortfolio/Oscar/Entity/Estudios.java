
package com.MiPortfolio.Oscar.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Estudios {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private int id;
    private String nombreE;
    private String descripcionE;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    
    private String titulo;
    
    private String img;

    public Estudios() {
    }

    public Estudios(String nombreE, String descripcionE, Date fin, String titulo, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fin = fin;
        this.titulo = titulo;
        this.img = img;
    }

    public Estudios(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
