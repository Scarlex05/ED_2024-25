/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package práctica.ed.pkgfinal;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author r.pedroso.2023
 */
public class Tablero {
    private int columnas, filas; //creamos las variables int para las columnas y las filas
    private Carta[][] tablero; //creamos la variable de tipo carta para el tablero (dado a que el tablero esta hecho de cartas, no solo numeros)

    //Constructor tablero en caso de no introducir ningun dato
    Tablero(){
        this.columnas = 4;
        this.filas = 3;
        this.tablero = crearTablero();
    }

    //Constructor tablero en caso de introducir el numero de filas y columnas
    Tablero(int columnas, int filas){
        this.columnas = columnas;
        this.filas = filas;
        this.tablero = crearTablero();
    }

    //metodo q crear el tablero tras haber asignador el hnumero de filas y columnas
    public Carta[][] crearTablero(){
        return new Carta[this.filas][this.columnas];
    }

    //metodo set para las columnas
    public void setColumnas(int columnas){
        this.columnas = columnas;
    }

    //metodo set para las filas
    public void setFilas(int filas){
        this.filas = filas;
    }

    //metodo get para las columnas
    public int getColumnas(){
        return this.columnas;
    }

    //metodo get para las filas
    public int getFilas(){
        return this.filas;
    }
    
    public Carta getCarta(int x, int y){
        return this.tablero[x][y];
    }

    //metodo para inicializar el tablero teniendo en cuenta la baraja
    public void inicializarTablero(Baraja baraja){
        int totalCartas = this.columnas * this.filas; //obtenemos el numero de cartas que necesitamos

        ArrayList<Carta> cartasSeleccionadas = new ArrayList<>(); //creamos un array para guardar las cartas necesarias

        for(int i = 0; i < totalCartas; i++){ //bucle for para sacar las cartas necesarias.
            Carta carta = baraja.sacarCarta();
            if(carta != null){
                cartasSeleccionadas.add(carta);
            }
        }

        Collections.shuffle(cartasSeleccionadas); //barajamos las caras en cartas selccionadas para colocar las parejas en un orden random

        //creamos un index para el numero de cartas y un bucle for para colocarlas en el tablero
        int index = 0;
        for(int i = 0; i < this.filas; i++){
            for(int j = 0; j < this.columnas; j++){
                this.tablero[i][j] = cartasSeleccionadas.get(index++);
            }
        }
    }

    //metodo para revelar una carta en concreto al encontrar su pareja
    public void revelarCarta(int columna, int fila){
        Carta carta = this.tablero[fila][columna];
        carta.Setrevelada(true);
    }

    //muestra el tablero con todas las cartas que ya han sido reveladas
    public void mostrarTableroRevelado(){
        for(int i = 0; i < this.columnas; i++){
            for(int j = 0; j < this.filas; j++){
                Carta carta = this.tablero[j][i];
                if(carta.Getrevelada()){ //obtenemos si una carta ha sido revelada o no para saber si enseñamos su nombre
                    System.out.print("[" + carta.GetNombre() + "] ");
                }else{
                    System.out.print("[ ] ");
                }
            }
            System.out.println("");
        }
    }

    //metodo comprueba si todo el tablero ha sido revelado, para dar fin a la partida.
    public boolean todoRevelado(){
        for(int i = 0; i < this.columnas; i++){
            for(int j = 0; j < this.filas; j++){
                Carta carta = this.tablero[j][i];
                if(carta.Getrevelada() == false){
                    return false;
                }
            }
        }
        return true;
    }
}
