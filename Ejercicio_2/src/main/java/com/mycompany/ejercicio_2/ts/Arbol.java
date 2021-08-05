/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.ts;

import com.mycompany.ejercicio_2.abs.Instruccion;
import com.mycompany.ejercicio_2.abs.Nodo;
import java.util.List;

/**
 *
 * @author julio
 */
public class Arbol {
    private Instruccion instruccion;
    private Tabla tabla;
    private List<GrammarException>excepciones;
    private String consola;
    private String dot;
    private int contador;

    public Arbol(Instruccion instruccion, Tabla tabla, List<GrammarException> excepciones) {
        this.instruccion = instruccion;
        this.tabla = tabla;
        this.excepciones = excepciones;
        this.consola = "";
        this.dot = "";
        this.contador = 0;
    }

    public Instruccion getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(Instruccion instruccion) {
        this.instruccion = instruccion;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public List<GrammarException> getExcepciones() {
        return excepciones;
    }

    public void setExcepciones(List<GrammarException> excepciones) {
        this.excepciones = excepciones;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }
    
    public void update(String cadena){
        this.consola += cadena + "\n";
    }
    
    public String getDot(Nodo raiz){
     
        this.dot = "";
        this.dot += "digraph {\n";
        this.dot += "n0[label=\"" + raiz.getValor().replace("\"", "\\\"") + "\"];\n";
        this.contador = 1;
        this.recorrerAST("n0", raiz);
        this.dot += "}";
        return this.dot;
    }
    public void recorrerAST(String idPadre, Nodo nodoPadre){
        nodoPadre.getHijos().forEach( hijo ->{
            String nombreHijo = "n"+String.valueOf(this.contador);
            this.dot += nombreHijo + "[label=\""+hijo.getValor()+"\"]";
            this.dot += idPadre + "->"+nombreHijo+";\n";
            this.contador += 1;
            this.recorrerAST(nombreHijo, hijo);
            
        });
        
    }
    
            
}
