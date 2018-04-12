/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.awt.Component;
import java.util.regex.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author juan_
 */
//Clase que se encarga de realizar el renderizado de cada celda
public class RenderPro extends DefaultTableCellRenderer {

    DataSet baseDatos = new DataSet();

    public void pasarDataSet(DataSet baseDatos) {
        this.baseDatos = baseDatos;
    }

    //Metodo que recoge cierta informacion para el renderizado
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //validamos que la columna sea mayor a cero, ya que la primera es una columnna extra para identificar cada instancia
        if (column > 0) {
            String regexp = baseDatos.getAtributos().get(column - 1).getDominio();
            String cadena;
            if (value == null) {
                cadena = baseDatos.getFaltante();
            } else {
                cadena = value.toString();
            }
            //Validamos que el valor que esta en la celda sea correspondiente al dominio
            if (Pattern.matches(regexp, cadena)) {
                //si es correcto pintamos normal
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
                //De otra manera lo pintamos de rojo
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            }
        } else {
            cell.setBackground(Color.WHITE);
            cell.setForeground(Color.BLACK);
        }
        return cell;
    }
}
