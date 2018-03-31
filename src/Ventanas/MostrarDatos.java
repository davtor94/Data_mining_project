/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import clases.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juan_
 */
public class MostrarDatos extends javax.swing.JFrame {

    /**
     * Creates new form MostrarDatos
     */
    DataSet baseDatos = new DataSet();

    public MostrarDatos(DataSet baseDatos) {
        initComponents();
        this.baseDatos = baseDatos;
        titulo.setText(baseDatos.getNombre());
        String[] columnas = new String[baseDatos.getNumAtributos() + 1];
        columnas[0] = "ID";
        for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
            columnas[i + 1] = baseDatos.getAtributos().get(i).getNombre();
        }
        DefaultTableModel modelo = new DefaultTableModel(0, 0);
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
        }

        for (int i = 1; i < columnas.length; i++) {
            listaModelo.addElement(columnas[i]);
        }

        for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
            columnas[0] = String.valueOf((i + 1));
            for (int j = 0; j < baseDatos.getNumAtributos(); j++) {
                columnas[j + 1] = baseDatos.getAtributos().get(j).getInstancias().get(i);
            }
            modelo.addRow(columnas);
        }

        listaAtributos.setModel(listaModelo);
        dataGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dataGrid.setAutoscrolls(true);
        datosGenerales.append("Numero de Instancias: " + baseDatos.getNumInstancias() + "\n");
        datosGenerales.append("Numero de Atributos: " + baseDatos.getNumAtributos() + "\n");
        datosGenerales.append("Numero de Valores Faltantes: " + "\n");
        datosGenerales.append("Porcentaje de Valores Faltantes: \n");
        dataGrid.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataGrid = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosGenerales = new javax.swing.JTextArea();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaAtributo = new javax.swing.JTextArea();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaAtributos = new javax.swing.JList<>();
        botonEliminarAtributo = new javax.swing.JButton();
        botonEditarAtributo = new javax.swing.JButton();
        botonExpresion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        dataGrid.setAutoCreateRowSorter(true);
        dataGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(dataGrid);

        datosGenerales.setEditable(false);
        datosGenerales.setColumns(20);
        datosGenerales.setRows(5);
        jScrollPane2.setViewportView(datosGenerales);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titulo.setText("Nombre de la Base de Datos xD");

        jLabel2.setText("Datos Generales de la Base de Datos");

        jLabel3.setText("Datos del Atributo");

        textAreaAtributo.setEditable(false);
        textAreaAtributo.setColumns(20);
        textAreaAtributo.setRows(5);
        jScrollPane3.setViewportView(textAreaAtributo);

        botonAgregar.setText("Agregar");
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarMouseClicked(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });

        listaAtributos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaAtributos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAtributosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listaAtributos);

        botonEliminarAtributo.setText("Eliminar");
        botonEliminarAtributo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarAtributoMouseClicked(evt);
            }
        });
        botonEliminarAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAtributoActionPerformed(evt);
            }
        });

        botonEditarAtributo.setText("Editar");
        botonEditarAtributo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarAtributoMouseClicked(evt);
            }
        });

        botonExpresion.setText("Editar Expresion");
        botonExpresion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonExpresionMouseClicked(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem4.setText("Cargar ");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Guardar");

        jMenuItem3.setText("Guardar");
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Guardar Como");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Acerca de");

        jMenuItem7.setText("Software");
        jMenu3.add(jMenuItem7);

        jMenuItem6.setText("Salir");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(botonAgregar)
                        .addGap(38, 38, 38)
                        .addComponent(botonEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEliminarAtributo)
                                .addGap(18, 18, 18)
                                .addComponent(botonEditarAtributo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonExpresion))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(titulo)
                .addGap(205, 205, 205)
                .addComponent(jLabel2)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonEliminarAtributo)
                            .addComponent(botonEditarAtributo)
                            .addComponent(botonExpresion)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregar)
                    .addComponent(botonEliminar))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarMouseClicked
        DefaultTableModel modelo = new DefaultTableModel(0, 0);
        modelo = (DefaultTableModel) dataGrid.getModel();
        String[] datos = new String[6];
        modelo.addRow(datos);
        dataGrid.setModel(modelo);
    }//GEN-LAST:event_botonAgregarMouseClicked

    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        if (dataGrid.getSelectedRow() >= 0) {
            DefaultTableModel modelo = new DefaultTableModel(0, 0);
            modelo = (DefaultTableModel) dataGrid.getModel();
            modelo.removeRow(dataGrid.getSelectedRow());
            dataGrid.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar una fila primero.");
        }
    }//GEN-LAST:event_botonEliminarMouseClicked

    private void botonEditarAtributoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarAtributoMouseClicked
        if (listaAtributos.getSelectedIndex() >= 0) {
            String respuesta = "";
            respuesta = JOptionPane.showInputDialog(null, "Introduce el nuevo Nombre:", listaAtributos.getSelectedValue());
            if (respuesta != null && !respuesta.equals("")) {
                int indice = listaAtributos.getSelectedIndex();
                //Actualizacion del header de la tabla
                TableColumnModel tableColumnModel = dataGrid.getColumnModel();
                tableColumnModel.getColumn(indice + 1).setHeaderValue(respuesta);
                dataGrid.setColumnModel(tableColumnModel);
                //Actualizacion del JList
                DefaultListModel listaModelo = (DefaultListModel) listaAtributos.getModel();
                listaModelo.set(indice, respuesta);
                listaAtributos.setModel(listaModelo);
                //actualizacion del dato en Memoria
                baseDatos.getAtributos().get(indice).setNombre(respuesta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonEditarAtributoMouseClicked

    private void botonEliminarAtributoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarAtributoMouseClicked
        if (listaAtributos.getSelectedIndex() >= 0) {
            //int indice = listaAtributos.getSelectedIndex();
            //Eliminado del Jlist
            DefaultListModel listaModelo = (DefaultListModel) listaAtributos.getModel();
            listaModelo.remove(listaAtributos.getSelectedIndex());
            listaAtributos.setModel(listaModelo);
            //Eliminacion de la columna
            //TableColumn tcol = dataGrid.getColumnModel().getColumn(indice + 1);
            //dataGrid.getColumnModel().removeColumn(tcol);
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonEliminarAtributoMouseClicked

    private void botonExpresionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExpresionMouseClicked
        if (listaAtributos.getSelectedIndex() >= 0) {
            String respuesta = JOptionPane.showInputDialog(null, "Actualiza la expresion:", listaAtributos.getSelectedValue());
            if (respuesta != null && !respuesta.equals("")) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonExpresionMouseClicked

    private void listaAtributosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAtributosValueChanged
        textAreaAtributo.setText(null);
        int indice = listaAtributos.getSelectedIndex();
        float porcentaje = (baseDatos.getAtributos().get(indice).getValoresFaltantes() * 100) / baseDatos.getNumInstancias();
        textAreaAtributo.append("Tipo: " + baseDatos.getAtributos().get(indice).getTipoDato() + "\n");
        textAreaAtributo.append("Expresion Regular: " + baseDatos.getAtributos().get(indice).getDominio() + "\n");
        textAreaAtributo.append("Valores Faltantes: " + baseDatos.getAtributos().get(indice).getValoresFaltantes() + "\n");
        textAreaAtributo.append("Porcentaje de Valores Faltantes: " + porcentaje + "% \n");
    }//GEN-LAST:event_listaAtributosValueChanged

    private void botonEliminarAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarAtributoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEditarAtributo;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonEliminarAtributo;
    private javax.swing.JButton botonExpresion;
    private javax.swing.JTable dataGrid;
    private javax.swing.JTextArea datosGenerales;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listaAtributos;
    private javax.swing.JTextArea textAreaAtributo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
