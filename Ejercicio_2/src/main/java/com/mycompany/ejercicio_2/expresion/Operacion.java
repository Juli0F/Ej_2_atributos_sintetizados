/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.expresion;

import com.mycompany.ejercicio_2.abs.Instruccion;
import com.mycompany.ejercicio_2.abs.Nodo;
import com.mycompany.ejercicio_2.principal.Principal;
import com.mycompany.ejercicio_2.ts.Arbol;
import com.mycompany.ejercicio_2.ts.Operador;
import com.mycompany.ejercicio_2.ts.Tabla;

/**
 *
 * @author julio
 */
public class Operacion extends Instruccion {

    private Operador operador;
    private Object izq;
    private Object der;
    private double result;
    public Operacion(Operador operador, Object izq, Object der, int fila, int columna) {
        super(fila, columna);
        this.operador = operador;
        this.izq = izq;
        this.der = der;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Object getIzq() {
        return izq;
    }

    public void setIzq(Object izq) {
        this.izq = izq;
    }

    public Object getDer() {
        return der;
    }

    public void setDer(Object der) {
        this.der = der;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol arbol) {
        Double valueIzq;
        Double valueDer;

        if (izq instanceof Operacion) {
            Operacion op = (Operacion) izq;
            valueIzq = (Double) op.interpretar(tabla, arbol);
            //Principal.postFijo += " " + valueIzq;
        } else if (izq instanceof Identificador) {
            valueIzq = isIdentificador(izq);
        } else {
            Primitivo op = (Primitivo) izq;
            valueIzq = (Double) op.interpretar(tabla, arbol);
            
        }
        Principal.postFijo += " " + valueIzq;

        if (der instanceof Operacion) {
            Operacion op = (Operacion) der;
            valueDer = (Double) op.interpretar(tabla, arbol);

        } else if (der instanceof Identificador) {
            valueDer = isIdentificador(der);
        } else {
            Primitivo op = (Primitivo) der;
            valueDer = (Double) op.interpretar(tabla, arbol);

        }
        Principal.postFijo += " " + valueDer;

        //Principal.postFijo += " "+ String.valueOf(operador);
        if (operador == Operador.POR) {
            Principal.postFijo += " (*)";
            return result =  valueIzq * valueDer;
        } else {
            if (operador == Operador.MAS) {
                Principal.postFijo += " (+)";
                return result = valueIzq + valueDer;

            }
        }
        return 0;
    }

    @Override
    public Nodo getNodo() {
        //Nodo nodo = new Nodo("Operacion");

        Nodo nodo = new Nodo(String.valueOf(operador)+ " "+ result);
        if (izq instanceof Operacion) {
            Operacion izqOp = (Operacion) izq;
            nodo.addHijoNodo(izqOp.getNodo());
        } else if (izq instanceof Identificador) {
            Identificador x = (Identificador) izq;
            nodo.addHijoNodo(x.getNodo());

        } else {
            Primitivo x = (Primitivo) izq;
            nodo.addHijoNodo(x.getNodo());
        }

        //nodo.addHijo(String.valueOf(operador));
        if (der instanceof Operacion) {
            Operacion derOp = (Operacion) der;
            nodo.addHijoNodo(derOp.getNodo());
        } else if (der instanceof Identificador) {
            Identificador x = (Identificador) der;
            nodo.addHijoNodo(x.getNodo());

        } else {
            Primitivo x = (Primitivo) der;
            nodo.addHijoNodo(x.getNodo());
        }

        return nodo;

//        
//        Primitivo x = (Primitivo) izq;
//        nodo.addHijoNodo(x.getNodo());
//        nodo.addHijo(String.valueOf(operador));
//         x = (Primitivo) der;
//        //nodo.addHijoNodo(x.getNodo());
//        return nodo;
    }

    private double isIdentificador(Object obj) {
        if (Operador.MAS == operador) {
            Identificador id = (Identificador) obj;
            id.setValue(0);
            return 0.0;
        } else {
            Identificador id = (Identificador) obj;
            id.setValue(1);
            return 1.0;
        }
    }

}
