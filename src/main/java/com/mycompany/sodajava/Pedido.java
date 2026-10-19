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
public class Pedido {
    //atributos 
    private EstadoPedido estado;
    private LinkedList<LineaFactura> lineas;
    private boolean bloqueado;
    
    //constructor 

    public Pedido() {
    this.estado = EstadoPedido.EN_PREPARACION;
    this.lineas = new LinkedList<>();
    this.bloqueado = false;
    }
    
    // Metodos
    public void agregarLinea(LineaFactura linea) {
        if (!bloqueado && linea != null) {
            lineas.add(linea);
        }
    }

    public void modificarLinea(LineaFactura linea, int cantidad) {
        if (!bloqueado && lineas.contains(linea) && cantidad > 0) {
            linea.modificarCantidad(cantidad);
        }
    }

    public void eliminarLinea(LineaFactura linea) {
        if (!bloqueado) {
            lineas.remove(linea);
        }
    }

    public double calcularSubtotal() {
        double subtotal = 0;

        for (LineaFactura linea : lineas) {
            subtotal += linea.calcularSubtotal();
        }

        return subtotal;
    }

    public void cambiarEstado(EstadoPedido estado) {
        if (estado != null) {
            this.estado = estado;
        }
    }
    
    public void bloquearPedido() {
        this.bloqueado = true;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }
    
    //getts 

    public EstadoPedido getEstado() {
        return estado;
    }

    public LinkedList<LineaFactura> getLineas() {
    return new LinkedList<>(lineas);
}
    
}
