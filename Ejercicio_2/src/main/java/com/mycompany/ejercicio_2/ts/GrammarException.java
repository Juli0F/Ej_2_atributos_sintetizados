/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.ts;

/**
 *
 * @author julio
 */
public class GrammarException extends  Exception{
    private String tipo;
    private String descripcion;
    private int fila;
    private int columna;

    public GrammarException(String tipo, String descripcion, int fila, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    public GrammarException(String tipo, String descripcion, int fila, int columna, String message) {
        super(message);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return "GrammarException{" + "tipo=" + tipo + ", descripcion=" + descripcion + ", fila=" + fila + ", columna=" + columna + '}';
    }

    
    
    
    
           
}
