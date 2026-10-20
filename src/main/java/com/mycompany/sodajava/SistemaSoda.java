/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sodajava;

import java.util.LinkedList;
import java.time.LocalDate;

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

    //constructor
    public SistemaSoda() {
        this.empleados = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.productos = new LinkedList<>();
        this.facturas = new LinkedList<>();
        this.contadorFacturas = 0;
        cargarDatosIniciales();

    }
    
    
    
    private void cargarDatosIniciales() {

        // Administradores
        registrarEmpleado(new Administrador(
                "101110111", "admin1@sodajava.com",
                "Carlos", "Administrador",
                "admin1", "1234", "EMP01"
        ));

        registrarEmpleado(new Administrador(
                "202220222", "admin2@sodajava.com",
                "Maria", "Administrador",
                "admin2", "1234", "EMP02"
        ));

        // Cajeros
        registrarEmpleado(new Cajero(
                "Juan", "Cajero",
                "cajero1", "1234", "EMP03"
        ));

        registrarEmpleado(new Cajero(
                "Ana", "Cajero",
                "cajero2", "1234", "EMP04"
        ));

        // Cocineros
        registrarEmpleado(new Cocinero(
                "Pedro", "Cocinero",
                "cocinero1", "1234", "EMP05"
        ));

        registrarEmpleado(new Cocinero(
                "Sofia", "Cocinero",
                "cocinero2", "1234", "EMP06"
        ));
        
        // Productos iniciales del menu
        agregarProducto(new Producto(
                "SOD-001", "Hamburguesa", Tamano.PEQUENO,
                "Torta de res de 90 g, lechuga y tomate",
                2500, 30
        ));

        agregarProducto(new Producto(
                "SOD-002", "Hamburguesa", Tamano.GRANDE,
                "Torta de res de 150 g, queso, lechuga y tomate",
                3500, 25
        ));

        agregarProducto(new Producto(
                "SOD-003", "Hamburguesa", Tamano.ESPECIAL,
                "Doble torta de res, queso, tocineta y huevo",
                4800, 15
        ));

        agregarProducto(new Producto(
                "SOD-004", "Taco", Tamano.PEQUENO,
                "1 taco de carne mechada con repollo",
                1500, 40
        ));

        agregarProducto(new Producto(
                "SOD-005", "Taco", Tamano.GRANDE,
                "2 tacos de carne mechada con repollo y salsas",
                2500, 30
        ));

        agregarProducto(new Producto(
                "SOD-006", "Taco", Tamano.ESPECIAL,
                "3 tacos con queso, guacamole y natilla",
                3500, 20
        ));

        agregarProducto(new Producto(
                "SOD-007", "Papas", Tamano.PEQUENO,
                "Porcion de papas fritas de 100 g",
                1200, 50
        ));

        agregarProducto(new Producto(
                "SOD-008", "Papas", Tamano.GRANDE,
                "Porcion de papas fritas de 200 g",
                1800, 40
        ));

        agregarProducto(new Producto(
                "SOD-009", "Papas", Tamano.ESPECIAL,
                "Papas con queso fundido y tocineta",
                2800, 20
        ));
        
        
        // Clientes iniciales
        Cliente cliente1 = new Cliente(
                "Luis Rodriguez", "88881111", "luis@correo.com"
        );

        Cliente cliente2 = new Cliente(
                "Maria Lopez", "88882222", "maria@correo.com"
        );

        registrarCliente(cliente1);
        registrarCliente(cliente2);

        // Cajero inicial
        Cajero cajeroInicial = (Cajero) iniciarSesion(
                "cajero1", "1234"
        );

        // Factura 1: PAGADA
        Pedido pedido1 = new Pedido();
        pedido1.agregarLinea(new LineaFactura(
                buscarProducto("SOD-001"), 2, 2500
        ));

        Factura factura1 = new Factura(
                0, cliente1, cajeroInicial, pedido1, ""
        );

        registrarFactura(factura1);
        factura1.procesarPago();

        // Factura 2: PAGADA
        Pedido pedido2 = new Pedido();
        pedido2.agregarLinea(new LineaFactura(
                buscarProducto("SOD-004"), 3, 1500
        ));

        Factura factura2 = new Factura(
                0, cliente2, cajeroInicial, pedido2, ""
        );

        registrarFactura(factura2);
        factura2.procesarPago();

        // Factura 3: PENDIENTE
        Pedido pedido3 = new Pedido();
        pedido3.agregarLinea(new LineaFactura(
                buscarProducto("SOD-007"), 2, 1200
        ));

        Factura factura3 = new Factura(
                0, cliente1, cajeroInicial, pedido3, ""
        );

        registrarFactura(factura3);

        // Factura 4: PENDIENTE
        Pedido pedido4 = new Pedido();
        pedido4.agregarLinea(new LineaFactura(
                buscarProducto("SOD-002"), 1, 3500
        ));

        Factura factura4 = new Factura(
                0, cliente2, cajeroInicial, pedido4, ""
        );

        registrarFactura(factura4);


    }


    // Metodos
    public Empleado iniciarSesion(String usuario, String contrasena) {

        for (Empleado empleado : empleados) {

            if (empleado.getUsuario().equals(usuario)
                    && empleado.validarContrasena(contrasena)) {

                return empleado;
            }
        }

        return null;
    }

    
    public void registrarEmpleado(Empleado empleado) {

        if (empleado == null) {
            return;
        }

        for (Empleado actual : empleados) {

            if (actual.getNumeroEmpleado().equals(empleado.getNumeroEmpleado())) {
                System.out.println("Ya existe un empleado con ese numero.");
                return;
            }

            if (actual.getUsuario().equals(empleado.getUsuario())) {
                System.out.println("Ese nombre de usuario ya esta registrado.");
                return;
            }
        }

        empleados.add(empleado);
    }

    
    public void modificarEmpleado(Empleado empleado) {

        if (empleado == null) {
            return;
        }

        for (Empleado actual : empleados) {

            if (!actual.getNumeroEmpleado().equals(empleado.getNumeroEmpleado())
                    && actual.getUsuario().equals(empleado.getUsuario())) {

                System.out.println("Ese nombre de usuario ya esta registrado.");
                return;
            }
        }

        for (Empleado actual : empleados) {

            if (actual.getNumeroEmpleado().equals(empleado.getNumeroEmpleado())) {

                actual.setNombre(empleado.getNombre());
                actual.setRol(empleado.getRol());
                actual.setUsuario(empleado.getUsuario());
                actual.setContrasena(empleado.getContrasena());

                return;
            }
        }
    }

    
    public void eliminarEmpleado(String numeroEmpleado) {

        empleados.removeIf(empleado
                -> empleado.getNumeroEmpleado().equals(numeroEmpleado));
    }
    
    
    public void registrarCliente(Cliente cliente) {

        if (cliente == null) {
            return;
        }

        for (Cliente actual : clientes) {

            if (actual.getCodigo().equals(cliente.getCodigo())) {
                System.out.println("Ya existe un cliente con ese codigo.");
                return;
            }
        }

        clientes.add(cliente);
    }

    
    
    public Cliente buscarCliente(String codigo) {

        for (Cliente cliente : clientes) {

            if (cliente.getCodigo().equals(codigo)) {
                return cliente;
            }
        }

        return null;
    }

    
    
    public void agregarProducto(Producto producto) {

        if (producto == null) {
            return;
        }

        for (Producto actual : productos) {

            if (actual.getCodigo().equals(producto.getCodigo())) {
                System.out.println("Ya existe un producto con ese codigo.");
                return;
            }
        }

        productos.add(producto);
    }


    public void eliminarProducto(String codigo) {

        productos.removeIf(producto
                -> producto.getCodigo().equals(codigo));
    }

    public Producto buscarProducto(String codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }

        return null;
    }

    
    
    public void registrarFactura(Factura factura) {

        if (factura == null) {
            return;
        }

        if (factura.getNumeroFactura() != 0) {
            System.out.println("La factura ya tiene un numero asignado.");
            return;
        }

        int siguienteNumero = contadorFacturas + 1;

        factura.asignarNumeroFactura(siguienteNumero);

        facturas.add(factura);
        contadorFacturas++;
    }

    
    
    public Factura buscarFactura(int numeroFactura) {

        for (Factura factura : facturas) {

            if (factura.getNumeroFactura() == numeroFactura) {
                return factura;
            }
        }

        return null;
    }



    public LinkedList<Factura> consultarHistorialCliente(Cliente cliente) {

        LinkedList<Factura> historial = new LinkedList<>();

        if (cliente == null) {
            return historial;
        }

        for (Factura factura : facturas) {

            if (factura.getCliente().getCodigo().equals(cliente.getCodigo())) {
                historial.add(factura);
            }
        }

        return historial;
    }

    public void generarReporteVentas(LocalDate inicio, LocalDate fin) {

        if (inicio == null || fin == null || inicio.isAfter(fin)) {
            System.out.println("Rango de fechas inválido.");
            return;
        }

        int cantidadVentas = 0;
        double totalVentas = 0;

        for (Factura factura : facturas) {

            LocalDate fechaFactura = factura.getFecha().toLocalDate();

            if (!fechaFactura.isBefore(inicio)
                    && !fechaFactura.isAfter(fin)
                    && factura.getEstado() == EstadoFactura.PAGADA) {

                cantidadVentas++;
                totalVentas += factura.calcularTotal();
            }
        }

        System.out.println("===== REPORTE DE VENTAS =====");
        System.out.println("Desde: " + inicio);
        System.out.println("Hasta: " + fin);
        System.out.println("Cantidad de ventas: " + cantidadVentas);
        System.out.println("Total vendido: CRC " + totalVentas);        
    }
    
    
    public LinkedList<Producto> getProductos() {
        return new LinkedList<>(productos);
    }

    public LinkedList<Factura> getFacturas() {
        return new LinkedList<>(facturas);
    }

    public LinkedList<Cliente> getClientes() {
        return new LinkedList<>(clientes);
    }

}
