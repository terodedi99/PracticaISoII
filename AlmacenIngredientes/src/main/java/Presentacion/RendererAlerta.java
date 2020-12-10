/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererAlerta extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
                                                   boolean isSelected, 
                                                   boolean hasFocus, 
                                                   int row, 
                                                   int column) {
 
        float stock = Float.parseFloat(table.getValueAt(row, 2).toString());
        float cantidad = Float.parseFloat(table.getValueAt(row, 3).toString());
 
        if (cantidad < stock) {
            setBackground(Color.RED);
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
 
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
