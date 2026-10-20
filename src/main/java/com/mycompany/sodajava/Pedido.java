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

    
    public void cambiarEstado(EstadoPedido nuevoEstado) {

        if (nuevoEstado == null) {
            return;
        }

        if (estado == EstadoPedido.EN_PREPARACION
                && nuevoEstado == EstadoPedido.LISTO_PARA_RETIRAR
                && bloqueado) {

            estado = nuevoEstado;

        } else if (estado == EstadoPedido.LISTO_PARA_RETIRAR
                && nuevoEstado == EstadoPedido.ENTREGADO) {

            estado = nuevoEstado;
        }
    }

    
    
    public void bloquearPedido() {

        if (bloqueado) {
            return;
        }

        bloqueado = true;

        for (LineaFactura linea : lineas) {
            linea.bloquearLinea();
        }
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
