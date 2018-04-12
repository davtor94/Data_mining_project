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
import clases.*;
import java.util.Collections;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

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
        //Inicializando variables globales y algunos componentes
        this.baseDatos = baseDatos;
        titulo.setText(baseDatos.getNombre());
        comboBoxAtributo.removeAllItems();

        //Creacion de un arreglo para el header de la Jtable
        String[] columnas = new String[baseDatos.getNumAtributos() + 1];
        columnas[0] = "ID";
        for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
            columnas[i + 1] = baseDatos.getAtributos().get(i).getNombre();
        }

        //Creacion y carga de un JTable
        ModeloTable modelo = new ModeloTable();
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
        }
        DefaultListModel listaModelo = new DefaultListModel();
        for (int i = 1; i < columnas.length; i++) {
            listaModelo.addElement(columnas[i]);
            comboBoxAtributo.addItem(columnas[i]);
        }

        //Creacion y llenado de datos de un modelo para el Jlits
        for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
            columnas[0] = String.valueOf((i + 1));
            for (int j = 0; j < baseDatos.getNumAtributos(); j++) {
                columnas[j + 1] = baseDatos.getAtributos().get(j).getInstancias().get(i);
            }
            modelo.addRow(columnas);
        }

        //Fijando los modelos
        listaAtributos.setModel(listaModelo);
        dataGrid.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dataGrid.setAutoscrolls(true);
        dataGrid.setModel(modelo);
        //Clase Render que se encarga de pintar las celdas del JTable
        RenderPro render = new RenderPro();
        render.pasarDataSet(baseDatos);
        dataGrid.setDefaultRenderer(Object.class, render);
        //Cargando la informacion general
        actualizarTextAreaGeneral();
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
        botonAgregarInstancia = new javax.swing.JButton();
        botonEliminarInstancia = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaAtributos = new javax.swing.JList<>();
        botonEliminarAtributo = new javax.swing.JButton();
        botonEditarAtributo = new javax.swing.JButton();
        botonExpresion = new javax.swing.JButton();
        comboBoxAtributo = new javax.swing.JComboBox<>();
        textFieldValor = new javax.swing.JTextField();
        botonRemplazar = new javax.swing.JButton();
        textFieldNuevoValor = new javax.swing.JTextField();
        botonAnalisisBivariable = new javax.swing.JButton();
        jButtonAnalisisUnivariable = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        dataGrid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dataGridPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(dataGrid);

        datosGenerales.setEditable(false);
        datosGenerales.setColumns(20);
        datosGenerales.setRows(5);
        jScrollPane2.setViewportView(datosGenerales);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Nombre de la Base de Datos xD");

        jLabel2.setText("Datos Generales de la Base de Datos");

        jLabel3.setText("Datos del Atributo");

        textAreaAtributo.setEditable(false);
        textAreaAtributo.setColumns(20);
        textAreaAtributo.setRows(5);
        jScrollPane3.setViewportView(textAreaAtributo);

        botonAgregarInstancia.setText("Agregar");
        botonAgregarInstancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarInstanciaMouseClicked(evt);
            }
        });

        botonEliminarInstancia.setText("Eliminar");
        botonEliminarInstancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarInstanciaMouseClicked(evt);
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

        comboBoxAtributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonRemplazar.setText("Remplazar");
        botonRemplazar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRemplazarMouseClicked(evt);
            }
        });

        botonAnalisisBivariable.setText("Analisis Bivariable");
        botonAnalisisBivariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalisisBivariableActionPerformed(evt);
            }
        });

        jButtonAnalisisUnivariable.setText("Analisis Univariable");
        jButtonAnalisisUnivariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalisisUnivariableActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonEliminarAtributo)
                                        .addGap(64, 64, 64)
                                        .addComponent(botonEditarAtributo)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonAgregarInstancia)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarInstancia)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonRemplazar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAnalisisBivariable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonExpresion)
                            .addComponent(jButtonAnalisisUnivariable))
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminarInstancia)
                    .addComponent(botonAgregarInstancia)
                    .addComponent(comboBoxAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRemplazar)
                    .addComponent(textFieldNuevoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnalisisUnivariable)
                    .addComponent(botonAnalisisBivariable))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarInstanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarInstanciaMouseClicked
        //Agregar nueva instancia a la tabla
        DefaultTableModel modelo = new DefaultTableModel(0, 0);
        modelo = (DefaultTableModel) dataGrid.getModel();
        String[] datos = new String[baseDatos.getNumAtributos() + 1];
        datos[0] = String.valueOf(dataGrid.getRowCount() + 1);
        for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
            datos[i + 1] = baseDatos.getFaltante();
        }
        modelo.addRow(datos);
        //Agregando instancia a la memoria
        for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
            baseDatos.getAtributos().get(i).getInstancias().add(datos[i + 1]);
        }
        //Recalculando los datos
        baseDatos.setNumInstancias(baseDatos.getNumInstancias() + 1);
        baseDatos.calcularErrores();
        //Actualizando la informacion en pantalla
        actualizarTextAreaAtributo();
        actualizarTextAreaGeneral();
    }//GEN-LAST:event_botonAgregarInstanciaMouseClicked

    private void botonEliminarInstanciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarInstanciaMouseClicked
        //Validando que el usuario haya seleccionado una fila
        if (dataGrid.getSelectedRow() >= 0) {
            int indice = dataGrid.getSelectedRow();
            //Actualizar Tabla
            DefaultTableModel modelo = (DefaultTableModel) dataGrid.getModel();
            modelo.removeRow(dataGrid.getSelectedRow());
            //Actualizar en Memoria
            for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
                baseDatos.getAtributos().get(i).getInstancias().remove(indice);
            }
            //Recalculando Datos
            baseDatos.setNumInstancias(baseDatos.getNumInstancias() - 1);
            baseDatos.calcularErrores();
            //Actualizando la informacion en la pantalla
            actualizarTextAreaAtributo();
            actualizarTextAreaGeneral();
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar una fila primero.");
        }
    }//GEN-LAST:event_botonEliminarInstanciaMouseClicked

    private void botonEditarAtributoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarAtributoMouseClicked
        //Validando que el usuario haya seleccionado una fila
        if (listaAtributos.getSelectedIndex() >= 0) {
            String respuesta = "";
            //Metodo que le pregunta al usuario que nombre desea introducir
            respuesta = JOptionPane.showInputDialog(null, "Introduce el nuevo Nombre:", listaAtributos.getSelectedValue());
            //Validacion en caso de que el usuario no introduzca nada o un valor nulo
            if (respuesta != null && !respuesta.equals("")) {
                int indice = listaAtributos.getSelectedIndex();
                //Actualizacion del header de la tabla
                TableColumnModel tableColumnModel = dataGrid.getColumnModel();
                tableColumnModel.getColumn(indice + 1).setHeaderValue(respuesta);
                //Actualizacion del JList
                DefaultListModel listaModelo = (DefaultListModel) listaAtributos.getModel();
                listaModelo.set(indice, respuesta);
                //actualizacion del dato en Memoria
                baseDatos.getAtributos().get(indice).setNombre(respuesta);
                //Actualizando Combobox
                comboBoxAtributo.removeAllItems();
                for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
                    comboBoxAtributo.addItem(baseDatos.getAtributos().get(i).getNombre());
                }
                comboBoxAtributo.setSelectedIndex(indice);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonEditarAtributoMouseClicked

    private void botonEliminarAtributoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarAtributoMouseClicked
        //Validando que el usuario haya seleccionado una fila
        if (listaAtributos.getSelectedIndex() >= 0) {
            int indice = listaAtributos.getSelectedIndex();
            //Eliminado del Jlist
            DefaultListModel listaModelo = (DefaultListModel) listaAtributos.getModel();
            listaModelo.removeElementAt(indice);
            //Eliminacion de la columna
            TableColumn tcol = dataGrid.getColumnModel().getColumn(indice + 1);
            dataGrid.getColumnModel().removeColumn(tcol);
            //Eliminacion del Combobox
            comboBoxAtributo.removeItemAt(indice);
            //Eliminacion del dato en memoria
            baseDatos.getAtributos().remove(indice);
            baseDatos.setNumAtributos(baseDatos.getNumAtributos() - 1);
            //Actualizacion de la informacion en pantalla
            actualizarTextAreaAtributo();
            actualizarTextAreaGeneral();
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonEliminarAtributoMouseClicked

    private void botonExpresionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExpresionMouseClicked
        //Validando que el usuario haya seleccionado una fila
        if (listaAtributos.getSelectedIndex() >= 0) {
            int indice = listaAtributos.getSelectedIndex();
            String respuesta = JOptionPane.showInputDialog(null, "Actualiza la expresion:", baseDatos.getAtributos().get(indice).getDominio());
            //Validacion para evitar que introduzca una expresion vacia
            if (respuesta != null && !respuesta.equals("")) {
                //Actualizando la Expresion
                baseDatos.getAtributos().get(indice).setDominio(respuesta);
                //Recalculando y actualizando
                actualizarTextAreaAtributo();
                //Actualizar la Tabla
                dataGrid.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un Atributo.");
        }
    }//GEN-LAST:event_botonExpresionMouseClicked

    private void listaAtributosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAtributosValueChanged
        //Cada que se selecciona un atributo se carga la informacion sobre este
        actualizarTextAreaAtributo();
    }//GEN-LAST:event_listaAtributosValueChanged

    private void dataGridPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dataGridPropertyChange
        //Cada vez que la informacion del JTable cambia, se deben actualizar los valores 
        int indiceColumna = dataGrid.getEditingColumn();
        int indiceFila = dataGrid.getEditingRow();
        //Validando que se haya modificado una fila y columna en especifico
        if (indiceFila >= 0 && indiceColumna >= 0) {
            String nuevoValor = dataGrid.getValueAt(indiceFila, indiceColumna).toString();
            //Cargar en Memoria 
            baseDatos.getAtributos().get(indiceColumna - 1).getInstancias().set(indiceFila, nuevoValor);
            //recalculando
            baseDatos.calcularErrores();
            //Actualizando los datos en pantalla
            actualizarTextAreaAtributo();
            actualizarTextAreaGeneral();
        }
    }//GEN-LAST:event_dataGridPropertyChange

    private void botonRemplazarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRemplazarMouseClicked
        String cadenaAntigua = textFieldValor.getText();
        String nuevaCadena = textFieldNuevoValor.getText();
        //Validamos que ambas cadenas no esten vacias para hacer un remplazo correcto
        if (!nuevaCadena.equals("") && !cadenaAntigua.equals("")) {
            //Validamos que sean diferentes las cadenas
            if (!nuevaCadena.equals(cadenaAntigua)) {
                int indice = comboBoxAtributo.getSelectedIndex();
                String cadena;
                //Ciclo que itera todas las instancias y remplaza valores viejos por nuevos
                for (int i = 0; i < baseDatos.getNumInstancias(); i++) {
                    cadena = baseDatos.getAtributos().get(indice).getInstancias().get(i);
                    if (cadena.equals(cadenaAntigua)) {
                        //actualizacion en memoria
                        baseDatos.getAtributos().get(indice).getInstancias().set(i, nuevaCadena);
                        //Actualizacion del componente
                        dataGrid.setValueAt(nuevaCadena, i, indice + 1);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Es necesario que la cadena de entrada sea diferente a la de salida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los datos.");
        }
    }//GEN-LAST:event_botonRemplazarMouseClicked

    private void botonAnalisisBivariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalisisBivariableActionPerformed
        int indice1 = listaAtributos.getSelectedIndex();
        int indice2;
        //Comprobar que se selecciono un atributo
        if (indice1 >= 0) {
            //Creamos un componente para preguntar por el segundo atributo
            String[] atributos = new String[baseDatos.getNumAtributos()];
            for (int i = 0; i < baseDatos.getNumAtributos(); i++) {
                atributos[i] = baseDatos.getAtributos().get(i).getNombre();
            }
            String resp = (String) JOptionPane.showInputDialog(null, "Seleccione el atributo a comparar", "Atributos", JOptionPane.QUESTION_MESSAGE, null, atributos, atributos[0]);
            //Validamos que el usuario haya seleccionado el segundo atributo
            if (resp != null) {
                indice2 = baseDatos.getIndexAtributo(resp);
                String tipoAtributo1 = baseDatos.getAtributos().get(indice1).getTipoDato();
                String tipoAtributo2 = baseDatos.getAtributos().get(indice2).getTipoDato();
                //validamos que el atributo sea diferente de si mismo y que los dos atributos sean del mismo tipo
                if (tipoAtributo1.equals(tipoAtributo2) && indice1 != indice2) {
                    //Creamos la nueva ventana y le pasamos los datos que ocupa
                    AnalisisBivariable example = new AnalisisBivariable(indice1, indice2, baseDatos);
                    example.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Los atributos no se pueden comparar, es necesario que sean del mismop tipo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un atributo a comparar.");
        }
    }//GEN-LAST:event_botonAnalisisBivariableActionPerformed

    private void jButtonAnalisisUnivariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalisisUnivariableActionPerformed
        int indice = listaAtributos.getSelectedIndex();
        if (indice > -1) {
            atributo atr = baseDatos.getAtributos().get(indice);
            if ("numeric".equals(atr.getTipoDato())) {
                analisisUnivariable window = new analisisUnivariable(atr);
                window.setVisible(true);
                BoxAndWhiskerChart boxplot = new BoxAndWhiskerChart(atr.getNombre(), atr);
                boxplot.pack();
                RefineryUtilities.centerFrameOnScreen(boxplot);
                boxplot.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                boxplot.setVisible(true);
            } else if ("binary".equals(atr.getTipoDato())) {
                JFreeChart Grafica_frecuencia;
                DefaultCategoryDataset Datos = new DefaultCategoryDataset();
                HashSet<String> valoresUnicos = new HashSet<>(atr.getInstancias());
                for (String valor : valoresUnicos) {
                    int frecuencia = Collections.frequency(atr.getInstancias(), valor);
                    Datos.addValue(frecuencia, atr.getNombre(), valor);
                }
                Grafica_frecuencia = ChartFactory.createBarChart("Grafica de Frecuencia ´ " + atr.getNombre() + " ' ", "Valor", "Repeticiones", Datos);
                ChartPanel Panel = new ChartPanel(Grafica_frecuencia);
                JFrame Ventana = new JFrame("Grafica de Frecuencia '" + atr.getNombre() + " '");
                Ventana.getContentPane().add(Panel);
                Ventana.pack();
                Ventana.setVisible(true);
                Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            } else if ("nominal".equals(atr.getTipoDato())) {
                JFreeChart Grafica_frecuencia;
                DefaultCategoryDataset Datos = new DefaultCategoryDataset();
                HashSet<String> valoresUnicos = new HashSet<>(atr.getInstancias());
                for (String valor : valoresUnicos) {
                    int frecuencia = Collections.frequency(atr.getInstancias(), valor);
                    Datos.addValue(frecuencia, atr.getNombre(), valor);
                }
                Grafica_frecuencia = ChartFactory.createBarChart("Grafica de Frecuencia ´ " + atr.getNombre() + " ' ", "Valor", "Repeticiones", Datos);
                ChartPanel Panel = new ChartPanel(Grafica_frecuencia);
                JFrame Ventana = new JFrame("Grafica de Frecuencia '" + atr.getNombre() + " '");
                Ventana.getContentPane().add(Panel);
                Ventana.pack();
                Ventana.setVisible(true);
                Ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Tipo de dato no concido ' " + atr.getTipoDato() + " '");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar un atributo a comparar.");
        }
    }//GEN-LAST:event_jButtonAnalisisUnivariableActionPerformed

    public void actualizarTextAreaAtributo() {
        //validamos que el indice del atributo seleccionado sea valido.
        if (listaAtributos.getSelectedIndex() >= 0) {
            //vaciamos el TextArea y lo cargamos con nueva informacion.
            textAreaAtributo.setText(null);
            int indice = listaAtributos.getSelectedIndex();
            float porcentajeFaltante = (baseDatos.getAtributos().get(indice).getValoresFaltantes() * 100) / baseDatos.getNumInstancias();
            float porcentajeErroneo = (baseDatos.getAtributos().get(indice).getNumeroValoresErroneos() * 100) / baseDatos.getNumInstancias();
            textAreaAtributo.append("Tipo: " + baseDatos.getAtributos().get(indice).getTipoDato() + "\n");
            textAreaAtributo.append("Expresion Regular: " + baseDatos.getAtributos().get(indice).getDominio() + "\n");
            textAreaAtributo.append("Valores Faltantes: " + baseDatos.getAtributos().get(indice).getValoresFaltantes() + "\n");
            textAreaAtributo.append("Porcentaje de Valores Faltantes: " + porcentajeFaltante + "% \n");
            textAreaAtributo.append("Numero de Valores Erroneos: " + baseDatos.getAtributos().get(indice).getNumeroValoresErroneos() + "\n");
            textAreaAtributo.append("Porcentaje de Valores Erroneos: " + porcentajeErroneo + "% \n");
        } else {
            textAreaAtributo.setText("");
        }
    }

    public void actualizarTextAreaGeneral() {
        //Cargamos los datos generales sobre la Base.
        datosGenerales.setText("");
        datosGenerales.append(baseDatos.getComentarios());
        datosGenerales.append("Numero de Instancias: " + baseDatos.getNumInstancias() + "\n");
        datosGenerales.append("Numero de Atributos: " + baseDatos.getNumAtributos() + "\n");
        datosGenerales.append("Numero de Valores Faltantes: " + "\n");
        datosGenerales.append("Porcentaje de Valores Faltantes: \n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarInstancia;
    private javax.swing.JButton botonAnalisisBivariable;
    private javax.swing.JButton botonEditarAtributo;
    private javax.swing.JButton botonEliminarAtributo;
    private javax.swing.JButton botonEliminarInstancia;
    private javax.swing.JButton botonExpresion;
    private javax.swing.JButton botonRemplazar;
    private javax.swing.JComboBox<String> comboBoxAtributo;
    private javax.swing.JTable dataGrid;
    private javax.swing.JTextArea datosGenerales;
    private javax.swing.JButton jButtonAnalisisUnivariable;
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
    private javax.swing.JTextField textFieldNuevoValor;
    private javax.swing.JTextField textFieldValor;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
