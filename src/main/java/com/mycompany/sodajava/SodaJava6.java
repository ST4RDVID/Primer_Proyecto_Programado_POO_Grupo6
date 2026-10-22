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
        SistemaSoda sistema = new SistemaSoda();

        System.out.println("Sistema SodaJava iniciado correctamente.");
        java.awt.EventQueue.invokeLater(() -> new VentanaLogin().setVisible(true)
);
    }
    
}
