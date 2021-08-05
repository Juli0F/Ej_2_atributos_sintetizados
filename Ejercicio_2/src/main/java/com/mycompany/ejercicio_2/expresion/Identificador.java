/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.expresion;

import com.mycompany.ejercicio_2.abs.Instruccion;
import com.mycompany.ejercicio_2.abs.Nodo;
import com.mycompany.ejercicio_2.ts.Arbol;
import com.mycompany.ejercicio_2.ts.Tabla;

/**
 *
 * @author julio
 */
public class Identificador extends Instruccion{

    private int value;
    private String id;

    public Identificador( String id, int fila, int columna) {
        super(fila, columna);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    @Override
    public Object interpretar(Tabla tabla, Arbol arbol) {
        return value;
    }

    @Override
    public Nodo getNodo() {
         Nodo nodo = new Nodo("Identificador");
        //Nodo nodo = new Nodo(String.valueOf(value));
        
        nodo.addHijo(String.valueOf(value));
        return nodo;
    }

}
