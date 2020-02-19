/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1compi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fercho
 */
public class LeerArchivo {
    
    
    public String leerArchivoIDE(){
          String entrada="";
          String nombreProyecto ="";
        // muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos IDE", "ide");
        selectorArchivos.setFileFilter(filtro);
        // indica cual fue la accion de usuario sobre el jfilechooser
        int valor = selectorArchivos.showOpenDialog(null);
        if(valor==0){
            FileReader f = null;
            try {
                File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado
                nombreProyecto = archivo.getName();
                // muestra error si es inválido
                if ((archivo == null) || (archivo.getName().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
                } // fin de if
                String cadena;
                f = new FileReader(archivo);
                BufferedReader b = new BufferedReader(f);
                try {
                    while((cadena = b.readLine())!=null) {
                        entrada+=cadena+"\n";
                    }
                } catch (IOException ex) {
                    Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al abrir archivo","Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          /*  
            MultiPanel multiPanel = new MultiPanel();
            multiPanel.getJtxt_area().setText(entrada);
            Principal.jTabbedPane1.add(multiPanel,nombreProyecto);
          */
    }
    return entrada;
}
    
    public void leerArchivoCSV(String nombre, String path) throws IOException{
        FileReader f=null;
        try {
            String entrada="";
            String cadena;
            f = new FileReader(path);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                entrada += cadena;
            }     b.close();
            MultiPanel multiPanel = new MultiPanel();
            multiPanel.getJtxt_area().setText(entrada);
            multiPanel.getJtxt_rutaArchivo().setText(path);
            Principal.jTabbedPane1.add(multiPanel,nombre);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error al abrir archivo","Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
}
