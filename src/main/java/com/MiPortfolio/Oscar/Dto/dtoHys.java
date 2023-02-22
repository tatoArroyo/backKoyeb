package com.MiPortfolio.Oscar.Dto;

public class dtoHys {


    private String nombre;
    private String img;
    private int porcentaje;
    

    public dtoHys() {
    }

    public dtoHys(String nombre, String img, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    
}
