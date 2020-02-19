/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1compi1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author fercho
 */
public class EscribirArchivo {
    
    public void escribirArchivo(String path,String valor) throws IOException{
        FileWriter fw=new FileWriter(path);
        BufferedWriter bw=new BufferedWriter(fw);
           bw.write(valor);
           bw.flush();
        }
    
    public void nuevoArchivo(String path){
        
    }
    
    
}
    

