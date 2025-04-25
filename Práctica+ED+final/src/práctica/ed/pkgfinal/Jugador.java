/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package práctica.ed.pkgfinal;

import java.util.ArrayList;

/**
 *
 * @author r.pedroso.2023
 */
public class Jugador {
    private String nombre; // Nombre del jugador
    private ArrayList<Carta> cartasGanadas;//Parejas encontradas

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasGanadas = new ArrayList<>();// Se inicia la lista vacía
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter (por si se quiere cambiar el nombre después)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    Método para añadir cartas ganadas (se añaden las dos de la pareja)
    en caso de que sea necesario lo dejo por si acaso
    
    public void añadirPareja(Carta c1, Carta c2) {
        cartasGanadas.add(c1);
        cartasGanadas.add(c2);
    }
    */

    // Getter lista de cartas ganadas
    public ArrayList<Carta> getCartasGanadas() {
        return cartasGanadas;
    }

    // Getter cantidad de parejas ganadas
    public int getNumeroParejas() {
        return cartasGanadas.size() / 2;
        //se divide entre 2 porque las parejas están formadas pro 2 cartas
    }

    // Para imprimir la info del jugador
    @Override
    public String toString() {
        return "Jugador: " + nombre + ", Parejas encontradas: " + getNumeroParejas();
    }
}
