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
public class RenderPro extends DefaultTableCellRenderer {

    DataSet baseDatos = new DataSet();

    
    public void pasarDataSet(DataSet baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (column > 0) {
            String regexp = baseDatos.getAtributos().get(column - 1).getDominio();
            String cadena = value.toString();
            if (Pattern.matches(regexp, cadena)) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
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
