/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package práctica.ed.pkgfinal;

/**
 *
 * @author r.pedroso.2023
 */
public class Carta {
    //atributos
    private String nombre; //símbolo asociado a la carta. 
    private int idPareja; //diferenciar entre las dos cartas de una pareja con el mismo nombre o símbolo
    private boolean revelada; //identificará si se ha encontrado la pareja de esta cartay, por tanto, si se encuentra boca arriba revelada
    
    //Constructor
    public Carta (String nom, int pareja){
        this.nombre = nom;
        this.idPareja = pareja;
        this.revelada = false; // Por defecto, la carta empieza sin revelar
    }
    
    //Getters 
    public String GetNombre(){
        return nombre;
    }
    
    public int GetIdPareja(){
        return idPareja;
    }
    
    public boolean Getrevelada(){
        return revelada;
    }
    
    public void Setrevelada(boolean revelada){
        this.revelada = revelada;
    }
    
    //Setters
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setIdPareja(int pareja){
        this.idPareja = pareja;
    }
    
    public void setNombre(boolean rev){
        this.revelada = rev;
    }
    
    //método equals modificado
    /*
    este método determinará cuándo dos cartas sean iguales. 
    */
    
    @Override //sobreescribimos el método existente de equals
    public boolean equals(Object obj) {
        //Comprobamos si es null o no es de la misma clase que esta carta
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        
        //Convertimos el objeto de tipo Object a una Carta
        Carta c = (Carta) obj;
        
        //Comparamos los nombres de las cartas (el símbolo asociado)
        return this.nombre.equals(c.nombre);
        // true si son iguales, false si NO
    }
}
