
package com.mycompany.sodajava;

/**
 *
 * @author sara
 */
public class Cliente {

    // Atributos
    private String codigo;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private static int contadorClientes = 0;

    // Constructor
    public Cliente(String nombreCompleto, String telefono, String correo) {
        contadorClientes++;

        this.codigo = String.format("Cliente-%02d", contadorClientes);
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Gets y Sets
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }
}
