/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio_2.write;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author julio
 */
public class WriteFile {
    
    public String writeFile(String path,String content){
        
        String pathFinal = "";

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(path);

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo);
            

            //Escribimos en el archivo con el metodo write 
           
            escribir.write(content);
            pathFinal= archivo.getAbsolutePath();
            //Cerramos la conexion
            
            escribir.close();
            
            return pathFinal;
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al escribir");
        }
        System.out.println(pathFinal);
        return pathFinal;
    }
     public void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}