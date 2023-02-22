
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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombreE;
   private String descripcionE;
   
   private String puesto;
   
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date inicio;
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date fin;

   private String img;

   //constructor

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String puesto, Date inicio, Date fin, String img) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.puesto = puesto;
        this.inicio = inicio;
        this.fin = fin;
        this.img = img;
    }

    public Experiencia(String nombreE, String descripcionE) {

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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

    
    
   
           
           