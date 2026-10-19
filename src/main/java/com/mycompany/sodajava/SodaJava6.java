/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class SodaJava6 {

    public static void main(String[] args) {
        // 1. Crear un producto
        Producto hamburguesa = new Producto(
                "P01",
                "Hamburguesa",
                Tamano.GRANDE,
                "Hamburguesa con queso",
                2500,
                10
        );

        // 2. Crear un cliente
        Cliente cliente = new Cliente(
                "Juan Perez",
                "8888-8888",
                "juan@gmail.com"
        );

        // 3. Crear un cajero
        Cajero cajero = new Cajero(
                "Carlos",
                "Cajero",
                "carlos",
                "1234",
                "EMP01"
        );

        // 4. Crear una linea de factura
        LineaFactura linea = new LineaFactura(
                hamburguesa, 2, 2500
        );

        // 5. Crear un pedido
        Pedido pedido = new Pedido();
        pedido.agregarLinea(linea);

        // 6. Crear una factura pendiente
        Factura factura = new Factura(
                1,
                cliente,
                cajero,
                pedido,
                "Sin cebolla"
        );

        // 7. Mostrar inventario antes del pago
        System.out.println("Inventario inicial: "
                + hamburguesa.getCantidadDisponible());

        // 8. Procesar el pago
        boolean pagoExitoso = factura.procesarPago();

        System.out.println("Pago exitoso: " + pagoExitoso);

        // 9. Mostrar inventario despues del pago
        System.out.println("Inventario final: "
                + hamburguesa.getCantidadDisponible());

        // 10. Intentar modificar el pedido pagado
        pedido.modificarLinea(linea, 5);

        System.out.println("Cantidad despues del intento: "
                + linea.getCantidad());

        System.out.println("Pedido bloqueado: "
                + pedido.isBloqueado());

        // 11. Mostrar factura
        factura.mostrarFactura();
        
    }
}
