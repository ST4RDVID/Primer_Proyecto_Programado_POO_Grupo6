/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

import java.util.LinkedList;

/**
 *
 * @author sara
 */
public class SistemaSoda {
    // Atributos
    private LinkedList<Empleado> empleados;
    private LinkedList<Cliente> clientes;
    private LinkedList<Producto> productos;
    private LinkedList<Factura> facturas;
    private int contadorFacturas;

    public SistemaSoda() {
        this.empleados = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.productos = new LinkedList<>();
        this.facturas = new LinkedList<>();
        this.contadorFacturas = 0;
    }
    
    
    
    
}
