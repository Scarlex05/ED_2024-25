/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package práctica.ed.pkgfinal;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas; // Colección de cartas seleccionadas (parejas aleatorias)

    // Constructor
    public Baraja() {
        this.cartas = new ArrayList<>();
    }

    // Añadir una carta (evita duplicados)
    public void añadirCarta(Carta c) {
        if (!cartas.contains(c)) {
            cartas.add(c);
        }
    }

    // Sacar una carta de la baraja
    public Carta sacarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

    // Obtener todas las cartas seleccionadas
    public ArrayList<Carta> getCartas() {
        return this.cartas;
    }

    /**
     * Inicializa la baraja con un número determinado de parejas seleccionadas aleatoriamente.
     */
    public void inicializarBaraja(int numParejas) {
        cartas.clear(); // Vaciar la baraja actual

        ArrayList<Carta> todasLasCartas = new ArrayList<>();

        // Crear todas las posibles parejas (A-Z y 0-9)
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            String nombre = String.valueOf(letra);
            todasLasCartas.add(new Carta(nombre, 1));
            todasLasCartas.add(new Carta(nombre, 2));
        }

        for (char num = '0'; num <= '9'; num++) {
            String nombre = String.valueOf(num);
            todasLasCartas.add(new Carta(nombre, 1));
            todasLasCartas.add(new Carta(nombre, 2));
        }

        // Mezclar todas las cartas posibles
        Collections.shuffle(todasLasCartas);

        ArrayList<String> usados = new ArrayList<>();
        int i = 0;

        while (cartas.size() < numParejas * 2 && i < todasLasCartas.size() - 1) {
            Carta c1 = todasLasCartas.get(i);
            String nombre = c1.GetNombre(); 

            if (!usados.contains(nombre)) {
                for (int j = i + 1; j < todasLasCartas.size(); j++) {
                    Carta c2 = todasLasCartas.get(j);
                    if (c2.GetNombre().equals(nombre) && c2.GetIdPareja() != c1.GetIdPareja()) {
                        cartas.add(c1);
                        cartas.add(c2);
                        usados.add(nombre);
                        break;
                    }
                }
            }

            i++;
        }

        // Mezclar el resultado final para que las parejas no estén juntas
        Collections.shuffle(cartas);
    }
}
