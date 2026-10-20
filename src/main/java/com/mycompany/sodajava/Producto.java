/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class Producto {

    // Atributos
    private String codigo;
    private String nombre;
    private Tamano tamano;
    private String descripcion;
    private double precioUnitario;
    private int cantidadDisponible;

    // Constructor

    
    public Producto(String codigo, String nombre, Tamano tamano,String descripcion, double precioUnitario,int cantidadDisponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tamano = tamano;
        this.descripcion = descripcion;
        this.precioUnitario
                = Double.isFinite(precioUnitario) && precioUnitario >= 0
                ? precioUnitario : 0;

        this.cantidadDisponible
                = Math.max(0, cantidadDisponible);
    }

    

    // Metodos

    public boolean verificarDisponibilidad(int cantidad) {
        return cantidad > 0 && cantidad <= cantidadDisponible;
    }

    public boolean descontarPorciones(int cantidad) {
        if (verificarDisponibilidad(cantidad)) {
            cantidadDisponible -= cantidad;
            return true;
        }

        return false;
    }

    public void actualizarPorciones(int cantidad) {
        if (cantidad >= 0) {
            this.cantidadDisponible = cantidad;
        }
    }

    //  Setts y Getts

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tamano getTamano() {
        return tamano;
    }

    public void setTamano(Tamano tamano) {
        this.tamano = tamano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

        public void setPrecioUnitario(double precioUnitario) {
        if (Double.isFinite(precioUnitario) && precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        }
    }


    public String getCodigo() {
        return codigo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    
}
