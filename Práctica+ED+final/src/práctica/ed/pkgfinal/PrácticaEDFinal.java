/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package práctica.ed.pkgfinal;

import java.util.Scanner;

/**
 *
 * @author r.pedroso.2023
 */
public class PrácticaEDFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Empezamos definiendo el tamaño del tablero.");

        int columnas;
        do {
            System.out.println("Introduce el número par de columnas (entre 4 y 8):");
            columnas = sc.nextInt();
            if(columnas < 4 || columnas > 8 || columnas % 2 != 0){
                System.out.println("Error: El numero debe de ser mayor o igual que 4, menor o igual que 8 y par");
            }
        } while (columnas < 4 || columnas > 8 || columnas % 2 != 0);

        int filas;
        do {
            System.out.println("Introduce el número de filas (entre 3 y 5):");
            filas = sc.nextInt();
            if(filas < 3 || filas > 5){
                System.out.println("Error: El numero debe de ser mayor o igual que 3 y menor o igual que 5");
            }
        } while (filas < 3 || filas > 5);

        // Inicializar jugadores
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        // Inicializar baraja y tablero
        Baraja baraja = new Baraja();
        baraja.inicializarBaraja();

        Tablero tablero = new Tablero(filas, columnas);
        tablero.inicializarTablero(baraja);

        boolean turnoJugador1 = true;

        while (!tablero.todoRevelado()) {
            tablero.mostrarTableroRevelado();

            Jugador actual;
            if(turnoJugador1){
                actual = jugador1;
            }else{
                actual = jugador2;
            }
            System.out.println(actual.getNombre() + ", escoja una posición.");

            int[] n = pedirCarta(sc, tablero);
            Carta carta1 = tablero.getCarta(n[0], n[1]);
            mostrarCartaDescubierta(carta1);

            int[] m = pedirCarta(sc, tablero);
            Carta carta2 = tablero.getCarta(m[0], m[1]);
            mostrarCartaDescubierta(carta2);

            if (carta1 != null && carta2 != null && carta1.equals(carta2) && carta1 != carta2) {
                System.out.println("¡Pareja encontrada!");
                carta1.setNombre(true);
                carta2.setNombre(true);
                actual.getCartasGanadas().add(carta1);
                
            } else {
                System.out.println("No hay pareja, turno para el otro jugador.");
                
                turnoJugador1 = !turnoJugador1;
            }
        }

        // Mostrar resultados
        tablero.mostrarTableroRevelado();
        System.out.println();
        System.out.println("El " + jugador1.getNombre() + " ha descubierto las cartas:");
        for (Carta c : jugador1.getCartasGanadas()) System.out.print(c.GetNombre() + " ");
        System.out.println();

        System.out.println("El " + jugador2.getNombre() + " ha descubierto las cartas:");
        for (Carta c : jugador2.getCartasGanadas()) System.out.print(c.GetNombre() + " ");
        System.out.println();

        if (jugador1.getNumeroParejas() > jugador2.getNumeroParejas()) {
            System.out.println(jugador1.getNombre() + " ha ganado!");
        } else if (jugador2.getNumeroParejas() > jugador1.getNumeroParejas()) {
            System.out.println(jugador2.getNombre() + " ha ganado!");
        } else {
            System.out.println("¡Ha habido un empate!");
        }
    }

    // Pide una carta válida
    public static int[] pedirCarta(Scanner sc, Tablero tablero) {
        int col, fila;
        do {
            System.out.println("Introduce una columna entre 0 y " + (tablero.getColumnas() - 1) + ":");
            col = sc.nextInt();
            System.out.println("Introduce una fila entre 0 y " + (tablero.getFilas() - 1) + ":");
            fila = sc.nextInt();
            if(!posicionValida(col, fila, tablero)){
                System.out.println("Error: posición no válida.");
            }
        } while(!posicionValida(col, fila, tablero));
        int[] n = new int[2];
        n[0] = fila;
        n[1] = col;
        return n;
    }

    public static void mostrarCartaDescubierta(Carta c) {
        if (c != null) {
            System.out.println("En la posición seleccionada se encuentra la carta " + c.GetNombre() + ".");
        }
    }
    
    public static boolean posicionValida(int col, int fila, Tablero tablero){
        if((col > tablero.getColumnas() || col < 0) || (fila > tablero.getFilas() || fila < 0)){
            return false;
        }
        
        Carta carta = tablero.getCarta(fila, col);
        
        if(carta.Getrevelada()){
            return false;
        }
            
        return true;
    }
    
}
