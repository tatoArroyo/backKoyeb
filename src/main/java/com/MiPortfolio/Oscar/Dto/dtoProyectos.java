
package com.MiPortfolio.Oscar.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {

    private String nombre;

    private String acercaproyec;
    
    private String img;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String acercaproyec, String img) {
        this.nombre = nombre;
        this.acercaproyec = acercaproyec;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAcercaproyec() {
        return acercaproyec;
    }

    public void setAcercaproyec(String acercaproyec) {
        this.acercaproyec = acercaproyec;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
}
