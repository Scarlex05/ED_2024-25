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
public class Baraja {
    private ArrayList<Carta> cartas; // Colección de cartas NO repetidas


    // Constructor
    public Baraja() {
        this.cartas = new ArrayList<>(); 
    }

    // Añadir carta
    public void añadirCarta(Carta c) {
        // Evita duplicados usando contains (usa equals de Carta)
        if (!cartas.contains(c)) {
            cartas.add(c);
        }
    }

    // Sacar una carta de la baraja
    public Carta sacarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0); // Saca la primera carta
        }
        return null;
    }

    //Metodo get para acceder a la lista cartas
    public ArrayList<Carta> getCartas(){
        return this.cartas;
    }

    // Inicializar la baraja con símbolos A-Z y 0-9
    public void inicializarBaraja() {
        cartas.clear(); // Limpiamos por si ya tenía algo

        // Bucle que recorre las letras de la A a la Z
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            // Crea dos cartas para cada letra (una pareja)
            // Usa String.valueOf para convertir el char a String
            cartas.add(new Carta(String.valueOf(letra), 1)); // Primera carta de la pareja
            cartas.add(new Carta(String.valueOf(letra), 2)); // Segunda carta de la pareja
        }

        // Bucle que recorre los números del 0 al 9 (como caracteres)
        for (char num = '0'; num <= '9'; num++) {
            // Igual que antes, crea una pareja de cartas por número
            cartas.add(new Carta(String.valueOf(num), 1)); // Primera carta de la pareja
            cartas.add(new Carta(String.valueOf(num), 2)); // Segunda carta de la pareja
        }
    }

    
}
