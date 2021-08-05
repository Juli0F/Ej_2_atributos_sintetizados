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
public class Asignacion extends Instruccion{

    private Object value;
    private String id;
    private int line;
    private int column;

    public Asignacion(String id, Object value,  int line, int column) {
        this.value = value;
        this.id = id;
        this.line = line;
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    

    @Override
    public Nodo getNodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol arbol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
           
}
