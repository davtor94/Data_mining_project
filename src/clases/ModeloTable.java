/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan_
 */

public class ModeloTable extends DefaultTableModel {

    public boolean isCellEditable(int row, int column) {
        if (column == 0) {
            return false;
        }
        return true;
    }
    
}
