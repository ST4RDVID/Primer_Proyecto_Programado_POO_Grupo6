/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class Administrador extends Empleado {
    
    //atributos 
    private String cedula;
    private String correo;
    
    //constructor
    public Administrador(String cedula, String correo, String nombre, String rol, String usuario, String contrasena, String numeroEmpleado) {
        super(nombre, rol, usuario, contrasena, numeroEmpleado);
        this.cedula = cedula;
        this.correo = correo;
    
    
    }
    //sets y gets
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
