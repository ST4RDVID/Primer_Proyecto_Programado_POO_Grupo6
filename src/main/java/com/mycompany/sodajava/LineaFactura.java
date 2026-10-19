/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class LineaFactura {
    // Atributos
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    
    // Constructor
    public LineaFactura(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    // Metodos
    public double calcularSubtotal() {
    return cantidad * precioUnitario;
    }
    
    public void modificarCantidad(int cantidad) {
    if (cantidad > 0) {
        this.cantidad = cantidad;
       }
   }

    // Getters
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    
    
}
