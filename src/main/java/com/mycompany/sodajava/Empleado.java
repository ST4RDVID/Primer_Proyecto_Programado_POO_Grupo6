/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public abstract class Empleado {
// atributos 
    protected String nombre;
    protected String rol;
    protected String usuario;
    protected String contrasena;
    protected String numeroEmpleado;
    
    //constructor
    public Empleado(String nombre, String rol, String usuario, String contrasena, String numeroEmpleado) {
        this.nombre = nombre;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroEmpleado = numeroEmpleado;
    }
    
    //metodos
    
    public boolean validarContrasena(String contrasena ){
        return this.contrasena.equals(contrasena);
    }
    
    // Setts y Getts
    public String getUsuario() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    
    
}
