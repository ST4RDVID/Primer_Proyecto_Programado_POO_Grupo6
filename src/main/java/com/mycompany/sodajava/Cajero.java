/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class Cajero extends Empleado {

    
    //constructor
    public Cajero(String nombre, String rol, String usuario, String contrasena, String numeroEmpleado) {
        super(nombre, rol, usuario, contrasena, numeroEmpleado);
    }
    
    //metodos
    
    public void marcarPedidoEntregado(Pedido pedido) {

        if (pedido == null) {
            return;
        }

        if (pedido.getEstado() == EstadoPedido.LISTO_PARA_RETIRAR) {
            pedido.cambiarEstado(EstadoPedido.ENTREGADO);
        }
    }

            
            
}
