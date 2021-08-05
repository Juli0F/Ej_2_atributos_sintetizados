/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.principal;

import com.mycompany.ejercicio_2.abs.Instruccion;
import com.mycompany.ejercicio_2.abs.Nodo;
import com.mycompany.ejercicio_2.analizador.Lexer;
import com.mycompany.ejercicio_2.analizador.parser;
import com.mycompany.ejercicio_2.ts.Arbol;
import com.mycompany.ejercicio_2.write.WriteFile;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class Principal {
    static String postFijo;
    
    public double compilar(String cadena){
        double resultado = 0;
        try {
            System.out.println("Iniciando ...");
            Lexer lex = new Lexer(new StringReader(cadena));
            parser p = new parser(lex);
            
            Instruccion instruccion = (Instruccion) p.parse().value;
            
            Arbol ast = new Arbol(instruccion, null, null);
            resultado = new Double(String.valueOf(instruccion.interpretar()));
            

            //Nodo init = new Nodo("Ast_Root");
            
            //Nodo instNodo = new Nodo("Instruccion");
            Nodo instNodo = new Nodo("Inicio");//"Resultado: "+resultado
            instNodo.addHijoNodo(ast.getInstruccion().getNodo());

            //init.addHijoNodo(instNodo);
            String grafo = ast.getDot(instNodo);

            WriteFile wf = new WriteFile();
            wf.writeFile("grafo.dot", grafo);
            wf.dibujar("grafo.dot", "grafo.png");

        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
