/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1compi1;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author fercho
 */
public class Nodo {
    
    private String nombre;
    private String path;
    private ArrayList<DefaultMutableTreeNode> hijos;
    private boolean isArchivo;

    public Nodo(String nombre, String path, boolean isArchivo) {
        this.nombre = nombre;
        this.path = path;
        this.hijos = new ArrayList<>();
        this.isArchivo = isArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<DefaultMutableTreeNode> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<DefaultMutableTreeNode> hijos) {
        this.hijos = hijos;
    }

    public boolean isIsArchivo() {
        return isArchivo;
    }

    public void setIsArchivo(boolean isArchivo) {
        this.isArchivo = isArchivo;
    }
    
    public String toString(){
        return this.nombre;
    }
    
    
}
