
package com.MiPortfolio.Oscar.Dto;


import javax.validation.constraints.NotBlank;
import java.util.Date;


public class dtoPersona {

    private String nombre;

    private String apellido;

    private String img;

    private String descripcion;

    private String domicilio;

    private String correo;

    private Date nacimiento;

    private int telefono;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String descripcion, String domicilio, String correo, Date nacimiento, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.domicilio = domicilio;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
