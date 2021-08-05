/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.abs;

import com.mycompany.ejercicio_2.ts.Arbol;
import com.mycompany.ejercicio_2.ts.Tabla;



/**
 *
 * @author julio
 */
public abstract class Instruccion {
    private int fila;
    private int columna;

    public Instruccion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
    
    public abstract Object interpretar(Tabla tabla, Arbol arbol);
    public abstract Nodo getNodo();
    
}
