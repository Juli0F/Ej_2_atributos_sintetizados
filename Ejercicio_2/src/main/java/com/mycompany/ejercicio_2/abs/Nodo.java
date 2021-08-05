/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.abs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julio
 */
public class Nodo {
    List<Nodo> hijos ;
    String valor;

    public Nodo( String valor) {
        this.hijos = new ArrayList<>();
        this.valor = valor;
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    public void addHijo(String valorHijo){
        this.hijos.add(new Nodo(valorHijo));
        
    }
    public void addHijos(List<Nodo> hijos){
        hijos.forEach(h ->{
            this.hijos.add(h);
        });
    }
    public void addHijoNodo(Nodo hijo){
        this.hijos.add(hijo);
    }
    //agrega el root
    public void addFirstHijo(Nodo Hijo){
        this.hijos.add(0, Hijo);
    }
    
    
    
}
