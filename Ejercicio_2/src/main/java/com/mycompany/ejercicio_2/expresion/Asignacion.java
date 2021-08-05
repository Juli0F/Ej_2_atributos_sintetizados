/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.expresion;

import com.mycompany.ejercicio_2.abs.Instruccion;
import com.mycompany.ejercicio_2.abs.Nodo;
import com.mycompany.ejercicio_2.ts.Arbol;
import com.mycompany.ejercicio_2.ts.GrammarException;
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
        super(line,column);
        this.value = value;
        this.id = id;
        
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
        Nodo nodo = new Nodo("ASIGNACION");
        nodo.addHijo(id);
        System.out.println("Clase en asigancion: "+ value.getClass());
        //nodo.addHijoNodo(t.getNodo());
        return nodo;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol arbol) {
        if (tabla.existKey(id)){
            return (new GrammarException("Semantico","se esta duplicando id",super.getFila(),super.getColumna()));
        }
        tabla.getTabla().put(id, value);
        return true;
        
    }
    
           
}
