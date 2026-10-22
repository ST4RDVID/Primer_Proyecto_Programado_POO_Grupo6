/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

import java.time.LocalDateTime;

/**
 *
 * @author sara
 */
public class Factura {
    //Atributos 
    private int numeroFactura;   
    private LocalDateTime fecha;
    private Cliente cliente;       
    private Cajero cajero;       
    private Pedido pedido;
    private EstadoFactura estado;       
    private String observaciones;
    private static final double IVA = 0.13;       
    
    //Cosntructor        
    public Factura(int numeroFactura, Cliente cliente,Cajero cajero, Pedido pedido, String observaciones) {

        this.numeroFactura = numeroFactura;
        this.fecha = LocalDateTime.now();
        this.cliente = cliente;
        this.cajero = cajero;
        this.pedido = pedido;
        this.estado = EstadoFactura.PENDIENTE;
        this.observaciones = "";
    }
     void asignarNumeroFactura(int numeroFactura) {
        if (this.numeroFactura == 0 && numeroFactura > 0) {
            this.numeroFactura = numeroFactura;
        }
    }
    
    
    //Metodos
    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }
    
    public double calcularImpuesto() {
        return calcularSubtotal() * IVA;
    }
    
    public double calcularTotal() {
        return calcularSubtotal() + calcularImpuesto();
    }
    
    
    
    public boolean procesarPago() {
        if (estado != EstadoFactura.PENDIENTE
                || pedido == null
                || pedido.getLineas().isEmpty()) {
            return false;
        }

        java.util.Map<Producto, Long> cantidades =
                new java.util.HashMap<>();

        for (LineaFactura linea : pedido.getLineas()) {
            if (linea == null
                    || linea.getProducto() == null
                    || linea.getCantidad() <= 0) {
                return false;
            }

            cantidades.merge(
                linea.getProducto(),
                (long) linea.getCantidad(),
                Long::sum
            );
        }

        // Validar todos los productos antes de descontar.
        for (java.util.Map.Entry<Producto, Long> entrada
                : cantidades.entrySet()) {

            long cantidad = entrada.getValue();

            if (cantidad > Integer.MAX_VALUE
                    || !entrada.getKey().verificarDisponibilidad(
                        (int) cantidad)) {
                return false;
            }
        }

        // Todas las cantidades ya fueron validadas.
        for (java.util.Map.Entry<Producto, Long> entrada
                : cantidades.entrySet()) {

            entrada.getKey().descontarPorciones(
                entrada.getValue().intValue()
            );
        }

        estado = EstadoFactura.PAGADA;
        pedido.bloquearPedido();

        return true;
    }

    
    public void registrarPreparacion(Cocinero cocinero) {

        if (cocinero == null
                || estado != EstadoFactura.PAGADA
                || pedido == null
                || pedido.getEstado() != EstadoPedido.EN_PREPARACION) {
            return;
        }

        observaciones = "Pedido preparado por: "
                + cocinero.getNombre()
                + " | Empleado: "
                + cocinero.getNumeroEmpleado();

        pedido.cambiarEstado(EstadoPedido.LISTO_PARA_RETIRAR);
    }

    
    
    public void mostrarFactura() {

        System.out.println("===== FACTURA SODAJAVA =====");
        System.out.println("Factura No: " + numeroFactura);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombreCompleto());
        System.out.println("Estado: " + estado);

        System.out.println("----- PRODUCTOS -----");

        for (LineaFactura linea : pedido.getLineas()) {
            System.out.println(
                    linea.getProducto().getNombre()
                    + " | Cantidad: " + linea.getCantidad()
                    + " | Subtotal: " + linea.calcularSubtotal()
            );
        }

        System.out.println("---------------------");
        System.out.println("Subtotal: CRC " + calcularSubtotal());
        System.out.println("IVA (13%): CRC " + calcularImpuesto());
        System.out.println("TOTAL: CRC " + calcularTotal());
        System.out.println("Observaciones: " + observaciones);
    }

    //setts y getts

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
            
}
