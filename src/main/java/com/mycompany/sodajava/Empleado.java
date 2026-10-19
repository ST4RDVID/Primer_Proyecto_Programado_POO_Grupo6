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

    
}
