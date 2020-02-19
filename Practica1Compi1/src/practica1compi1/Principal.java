/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1compi1;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author fercho
 */
public class Principal extends javax.swing.JFrame {

    String historialComandos="";
    Nodo archivoALeer;
    String cuerpoProyecto;
    
    public Principal() {
        initComponents();
        Nodo simple = new Nodo("/",null,false);
        DefaultMutableTreeNode nodos = new DefaultMutableTreeNode(simple);
        DefaultTreeModel modelo = new DefaultTreeModel(nodos);
            jTree1.setModel(modelo);
    }

    public  JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public  void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }
    
    
    public void agregarHistorial(String mensaje){
        historialComandos += mensaje+"\n";
        jTextArea2.setText(historialComandos);
    }
    
    public void mostarArbol(DefaultTreeModel model){
        jTree1.setModel(model);
        jTree1.repaint();
    }
    
    public void desactivarAbrirProyecto(){
        jMenuItem1.setEnabled(false);
    }
    
    private void guardarProyecto(){
        try {
            String mensaje;
            TreeNode raiz = (TreeNode) jTree1.getModel().getRoot();
            cuerpoProyecto = "";
            escribirNodo(raiz, "PROYECTO");
            System.out.println(cuerpoProyecto);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void escribirNodo(TreeNode nodo, String carpeta){
        Nodo hijo = (Nodo)((DefaultMutableTreeNode) nodo).getUserObject();
        if(nodo.getChildCount() >= 0){
            if(hijo.isIsArchivo()){
                cuerpoProyecto += (("\n <ARCHIVO nombre=\""+hijo.getNombre()+"\""+" ubicacion=\""+hijo.getPath()+"\"/>"));
            }else{
                cuerpoProyecto += (("\n<"+carpeta+" nombre=\""+hijo.getNombre()+"\">"));
        }
        for (Enumeration e = nodo.children(); e.hasMoreElements();){
            TreeNode n = (TreeNode) e.nextElement();
            escribirNodo(n,"CARPETA");
        }
            
        }
        if(!hijo.isIsArchivo()){
            cuerpoProyecto += (("\n</"+carpeta+">"));
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jbtn_abrirArchivo = new javax.swing.JButton();
        jtxt_info = new javax.swing.JTextField();
        jbtn_nuevoArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jtxt_nombre = new javax.swing.JTextField();
        jtxt_path = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jbtn_abrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica1compi1/openFile.png"))); // NOI18N
        jbtn_abrirArchivo.setToolTipText("Abrir Archivo");
        jbtn_abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_abrirArchivoActionPerformed(evt);
            }
        });

        jtxt_info.setEditable(false);

        jbtn_nuevoArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica1compi1/newFile.png"))); // NOI18N
        jbtn_nuevoArchivo.setToolTipText("Nuevo Archivo");
        jbtn_nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_nuevoArchivoActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane1.setViewportView(jTextArea2);

        jTextField1.setText("sql>");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Path:");

        jButton1.setText("Eliminar Nodo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Proyecto");

        jMenuItem1.setText("Abrir Proyecto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Guardar Proyecto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Cerrar ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_info)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_abrirArchivo)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtxt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtn_nuevoArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jtxt_path))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_abrirArchivo)
                            .addComponent(jbtn_nuevoArchivo)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxt_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LeerArchivo n = new LeerArchivo();
        String cadenaEntrada = n.leerArchivoIDE();
        if(cadenaEntrada!=""){
        IDELexico lexico = new IDELexico(new StringReader(cadenaEntrada));
        try {
            parser parse = new parser(lexico,this);
            parse.parse();
        } catch (Exception e) {
        }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbtn_abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_abrirArchivoActionPerformed
        LeerArchivo archivo = new LeerArchivo();
        try {
            if(archivoALeer!=null){
                String nombre = archivoALeer.getNombre();
                String path = archivoALeer.getPath();
                if(path==null){
                    JOptionPane.showMessageDialog(null, "No has seleccionado un archivo .CSV","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    archivo.leerArchivoCSV(nombre, path);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtn_abrirArchivoActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
       
        try {
            DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
             jtxt_info.setText(nodoSeleccionado.getUserObject().toString());
             archivoALeer = (Nodo) nodoSeleccionado.getUserObject();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jTree1MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    
                    historialComandos += jTextField1.getText()+"\n";
                    IDELexico lexico = new IDELexico(new StringReader(jTextField1.getText()));
                    try {
                        parser parse = new parser(lexico,this);
                        parse.parse();
                    } catch (Exception e) {
                    }
                    
                    jTextArea2.setText(historialComandos);
                    jTextField1.setText("sql>");
             
                }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jbtn_nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_nuevoArchivoActionPerformed
        DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        
        Nodo ObjetoSeleccionado = (Nodo) nodoSeleccionado.getUserObject();
        
        if(!ObjetoSeleccionado.isIsArchivo()){
            Nodo nuevoArchivo = new Nodo(this.jtxt_nombre.getText(),this.jtxt_path.getText(),true);
            DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(nuevoArchivo);
            nodoSeleccionado.add(nuevoNodo);
            
            File file = new File(this.jtxt_path.getText());
            // Si el archivo no existe es creado
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            DefaultTreeModel modelArbol = (DefaultTreeModel) jTree1.getModel();
            modelArbol.reload();
        }else{
                JOptionPane.showMessageDialog(null, "No puedes crear archivo sobre otro archivo","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jbtn_nuevoArchivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) jTree1.getSelectionPath().getLastPathComponent();
        DefaultTreeModel modelArbol = (DefaultTreeModel) jTree1.getModel();
        Nodo s = (Nodo) nodoSeleccionado.getUserObject();
        File file = new File(s.getPath());
            // Si el archivo no existe es creado
            if (file.delete()) {
               modelArbol.removeNodeFromParent(nodoSeleccionado);
                modelArbol.reload();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo","Error",JOptionPane.ERROR_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
        Principal s = new Principal();
        s.setVisible(true);
        s.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        guardarProyecto();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbtn_abrirArchivo;
    private javax.swing.JButton jbtn_nuevoArchivo;
    private javax.swing.JTextField jtxt_info;
    private javax.swing.JTextField jtxt_nombre;
    private javax.swing.JTextField jtxt_path;
    // End of variables declaration//GEN-END:variables
}