/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import clases.*;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author David Torres
 */
public class Cargar_Archivo extends javax.swing.JFrame {

    /**
     * Creates new form Cargar_Archivo
     */
    public Cargar_Archivo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private DataSet baseDatos = new DataSet();
    private File origenOriginal;
    private boolean guardado = true;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCargarArchivo = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonGuardarComo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelNumInstancias = new javax.swing.JLabel();
        LabelNumAtri = new javax.swing.JLabel();
        LabellValoresPerdidos = new javax.swing.JLabel();
        jButtonMostrarTabla = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCargarArchivo.setBackground(new java.awt.Color(51, 51, 51));
        jButtonCargarArchivo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonCargarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCargarArchivo.setText("Abrir");
        jButtonCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        jButtonSalir.setBackground(new java.awt.Color(102, 102, 102));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, -1, -1));

        jButtonGuardar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 40));

        jButtonGuardarComo.setBackground(new java.awt.Color(51, 51, 51));
        jButtonGuardarComo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarComo.setText("Guardar como");
        jButtonGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarComoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardarComo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 110, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valores perdidos: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Numero de Atributos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de Instancias:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        LabelNombre.setBackground(new java.awt.Color(255, 255, 255));
        LabelNombre.setFont(new java.awt.Font("Castellar", 2, 16)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombre.setText("N/A");
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 500, 30));

        LabelNumInstancias.setBackground(new java.awt.Color(255, 255, 255));
        LabelNumInstancias.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        LabelNumInstancias.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumInstancias.setText("N/A");
        getContentPane().add(LabelNumInstancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        LabelNumAtri.setBackground(new java.awt.Color(255, 255, 255));
        LabelNumAtri.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        LabelNumAtri.setForeground(new java.awt.Color(255, 255, 255));
        LabelNumAtri.setText("N/A");
        getContentPane().add(LabelNumAtri, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        LabellValoresPerdidos.setBackground(new java.awt.Color(255, 255, 255));
        LabellValoresPerdidos.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 14)); // NOI18N
        LabellValoresPerdidos.setForeground(new java.awt.Color(255, 255, 255));
        LabellValoresPerdidos.setText("N/A");
        getContentPane().add(LabellValoresPerdidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jButtonMostrarTabla.setBackground(new java.awt.Color(51, 51, 51));
        jButtonMostrarTabla.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMostrarTabla.setText("Mostrar tabla");
        jButtonMostrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMostrarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 120, 30));

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/5236392-gray-wallpaper.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 421));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private DataSet cargarArchivo() {
        
        DataSet data = new DataSet();
        String aux;
        String comentarios = "";
        ArrayList<atributo> atributos = new ArrayList<>();
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File abre = file.getSelectedFile();
            origenOriginal = abre;
            boolean cargaDatos = false;
            /**
             * recorremos el archivo
             */
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    //si entra aqui llego la hora de cargar los datos
                    if (cargaDatos) {
                        //Para el caso que tenga espacios la cadena, eliminarmos para compararlos
                        aux = aux.replace(" ", "");
                        String[] campos = aux.split(",");
                        String dato;
                        int numeroAtributos = campos.length;
                        if(numeroAtributos != atributos.size()){
                            int confirmacion = JOptionPane.showConfirmDialog(null, "Una instancia no contiene el numero de atributos necesarios\n"
                            + "Desea agregarla de todos modos?");
                            if(confirmacion == 0){
                                    int i;
                                 for ( i = 0; i < numeroAtributos; i++) {
                                     
                                     dato = campos[i];
                                     if(dato.isEmpty()){
                                         dato = data.getFaltante();
                                     }
                                    atributos.get(i).getInstancias().add(dato);
                                }
                                 for(;i<atributos.size();i++){
                                     atributos.get(i).getInstancias().add(data.getFaltante());
                                 }
        }
                        }else{
                            for ( int i = 0; i < numeroAtributos; i++) {
                                dato = campos[i];
                                     if(dato.isEmpty()){
                                         dato = data.getFaltante();
                                     }
                                    atributos.get(i).getInstancias().add(dato);
                                }
                        }
                    } else if (aux.startsWith("%")) {
                        //es comentario
                        comentarios += aux + "\n";
                        //para borrar los %% al inicio de la cadena
                        comentarios = comentarios.replace("%%", "");
                        
                    } else if (aux.startsWith("@relation")) {
                        data.setNombre(aux.substring(10));
                    } else if (aux.startsWith("@attribute")) {
                        String[] parts = aux.split(" ");
                        atributo atr = new atributo(parts[1], parts[3], parts[2]);
                        atributos.add(atr);
                    } else if (aux.startsWith("@missingValue")) {
                        data.setFaltante(aux.substring(14));
                    } else if (aux.startsWith("@data")) {
                        cargaDatos = true;
                        
                    }
                }
                lee.close();
                if (data.getNombre() == null) {
                    JOptionPane.showMessageDialog(null,
                            "El Archvio no cuenta con las caracteristicas necesarias.",
                            "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
                } else {
                    //Calculamos algunos valores generales del DataSet
                    data.setAtributos(atributos);
                    data.updateNumAtributos();
                    data.updateNumInstancias();
                    data.calcularErrores();
                    data.setComentarios(comentarios);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return data;
    }

    private void acutlizarInterfaz() {
        LabelNombre.setText(baseDatos.getNombre());
        LabelNumAtri.setText(String.valueOf(baseDatos.getNumAtributos()));
        LabelNumInstancias.setText(" " + baseDatos.getNumInstancias());
        LabellValoresPerdidos.setText(baseDatos.getFaltante());
    }


    private void jButtonCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarArchivoActionPerformed
        baseDatos = cargarArchivo();
        if (baseDatos.getNombre() == null) {
            JOptionPane.showMessageDialog(null,
                    "El archivo debe contener: \n"
                    + "Nombre(@relation)\n"
                    + "atributos(@attribute)\n"
                    + "variable representando valores perdidos(@missingValue)\n"
                    + "y datos(@data)\n"
                    + "Para mayor informacion consulte el manual tecnico.",
                    "Recuerda!", JOptionPane.WARNING_MESSAGE);
        } else {
            //JOptionPane.showMessageDialog(null,
            //        baseDatos.getComentarios(),
            //        "Comentarios!", JOptionPane.INFORMATION_MESSAGE);
            acutlizarInterfaz();
        }
    }//GEN-LAST:event_jButtonCargarArchivoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        if(!guardado){
            int confirmacion = JOptionPane.showConfirmDialog(null, "Se han detectado cambios sin guardar\n"
                    + "Desea salir descartando los cambios?");
            if(confirmacion == 0){
            System.exit(0);
        }
        }
        else{
            System.exit(0);
        }
        
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonMostrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarTablaActionPerformed
        if (baseDatos == null) {
            JOptionPane.showMessageDialog(null,
                    "Es necesario abriri un archivo valido.",
                    "DataSet invalido!", JOptionPane.ERROR_MESSAGE);
        }
        else {
            MostrarDatos nueva = new MostrarDatos(baseDatos);
            nueva.setVisible(true);
            guardado = false;
        }
    }//GEN-LAST:event_jButtonMostrarTablaActionPerformed
    public void guardar_archivo(File archivo, String datos){
        try{
            
            FileOutputStream salida = new FileOutputStream(archivo);
            byte[] datosAguardar = datos.getBytes();
           
            salida.write(datosAguardar);
        }catch (Exception e){
            
        }
    }
    public String datasetToText(DataSet datos){
        //GUardamos los comentarios en la cadena
        String text ="", aux;
        aux = "%%";
        aux += datos.getComentarios();
        //aqui solo borro el ultimo salto de linea, entendido?
        aux = aux.substring(0, aux.length()-1);
        //aqui remplazo los saltos de liena con salyo de linea +"%%" para que sea comentario
        aux = aux.replace("\n", "\r\n%%");
        text +=aux +  "\r\n";
        //Guardamos el nombre del data set
        aux = "@relation " + datos.getNombre() +"\r\n";
        text +=aux;
        //Guardamos los atributos del data set
        for (int i =0; i<datos.getNumAtributos();i++){
            aux = "@attribute "+ datos.getAtributos().get(i).getNombre() + " ";
            aux += datos.getAtributos().get(i).getTipoDato() +" ";
            aux += datos.getAtributos().get(i).getDominio()+  "\r\n";
            text +=aux ;
        }
        //Guardamops el missin value
        aux = "@missingValue " + datos.getFaltante() + "\r\n";
        text +=aux;
        //Guardamops todos los datukis
        aux = "@data" + "\r\n";
        text +=aux;
        for(int i = 0; i<datos.getNumInstancias();i++){
            aux ="";
            for(int j = 0; j<datos.getNumAtributos();j++){
                aux += datos.getAtributos().get(j).getInstancias().get(i)+",";
            }
            aux = aux.substring(0, aux.length()-1);
            aux += "\r\n";
            text +=aux;
        }
        JOptionPane.showMessageDialog(null,
                    "Guardado con exito",
                    "Cambios Guardados con exito", JOptionPane.INFORMATION_MESSAGE);
        return text;
    }
    private void jButtonGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarComoActionPerformed
         JFileChooser seleccionar = new  JFileChooser();
         File archivo;
         if(seleccionar.showDialog(null, "Guardar")== JFileChooser.APPROVE_OPTION){
             archivo = seleccionar.getSelectedFile();
             guardar_archivo(archivo,datasetToText(baseDatos));
         }
         guardado = true;
    }//GEN-LAST:event_jButtonGuardarComoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        
         guardar_archivo(origenOriginal,datasetToText(baseDatos));        
         guardado = true;
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(Cargar_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargar_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargar_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargar_Archivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargar_Archivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JLabel LabelNumAtri;
    private javax.swing.JLabel LabelNumInstancias;
    private javax.swing.JLabel LabellValoresPerdidos;
    private javax.swing.JButton jButtonCargarArchivo;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonGuardarComo;
    private javax.swing.JButton jButtonMostrarTabla;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
