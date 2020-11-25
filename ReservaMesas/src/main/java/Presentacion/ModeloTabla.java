package Presentacion;


import javax.swing.table.DefaultTableModel;

/**
 * Modelo de la tabla
 * @author Antonio
 */
public class ModeloTabla extends DefaultTableModel {
    
    //Para que la celda no sea editable
    @Override
    public boolean isCellEditable(int row, int column) {
	return false;
    }
}
