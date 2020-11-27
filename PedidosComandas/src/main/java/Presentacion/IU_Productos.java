/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.GestorProducto;
import Dominio.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;


public class IU_Productos extends javax.swing.JFrame {

    private final WindowListener exitListener;
    private IU_Anotar_Linea_Comanda formAnotarLineaComanda;
    private ModeloTabla modelo;
    
    /**
     * Creates new form IU_Productos
     */
    public IU_Productos() {
        this.exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                formAnotarLineaComanda.setVisible(true);
                cerrar();
            }
        };
        
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        this.setTitle("PRODUCTOS");
        this.setLocationRelativeTo(null); 
        this.addWindowListener(exitListener);
        
        //Ajustes de la tabla
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos(); 
    }
    
    private void cargarTabla() {
        String nombreColumnas [] = {"ID_PRODUCTO", "DESCRIPCION", "TIPO_PRODUCTO", "PRECIO", "PLATOS_DISPONIBLES"};
        
        for (String nombreColumna : nombreColumnas) {
            modelo.addColumn(nombreColumna);
        }
        
        TableColumn id = tablaProductos.getColumn("ID_PRODUCTO");
        id.setMinWidth(80);
        
        TableColumn descripcion = tablaProductos.getColumn("DESCRIPCION");
        descripcion.setMinWidth(80);
        
        TableColumn tipo = tablaProductos.getColumn("TIPO_PRODUCTO");
        tipo.setMinWidth(80);
        
        TableColumn precio = tablaProductos.getColumn("PRECIO");
        precio.setMinWidth(80);
        
        TableColumn platos = tablaProductos.getColumn("PLATOS_DISPONIBLES");
        platos.setMinWidth(80);
    }
    
    public void cargarDatos() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Producto> lista = GestorProducto.buscarProductos();
        
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            Producto p = lista.get(i);
            
            obj[0] = p.getIdProducto();
            obj[1] = p.getDescripcionProducto();
            obj[2] = p.getTipoProducto();
            obj[3] = p.getPrecio();
            obj[4] = p.getPlatosDisponibles();
            
            modelo.addRow(obj);
        }
    }
    
    public void setFormAnotarLineaComanda (IU_Anotar_Linea_Comanda formAnotarLineaComanda) {
        this.formAnotarLineaComanda = formAnotarLineaComanda;
    }
    
    private void cerrar() {
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("PRODUCTOS");

        tablaProductos.setModel(modelo);
        jScrollPane1.setViewportView(tablaProductos);

        btnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConfirmar.setText("CONFIRMAR PRODUCTO");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(307, 307, 307)
                                .addComponent(lblTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnConfirmar)))
                        .addGap(0, 340, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            this.setVisible(false);
            formAnotarLineaComanda.setInformacion(new Producto(Integer.parseInt(tablaProductos.getValueAt(filaSeleccionada, 0).toString()), tablaProductos.getValueAt(filaSeleccionada, 1).toString(), tablaProductos.getValueAt(filaSeleccionada, 2).toString(), Float.parseFloat(tablaProductos.getValueAt(filaSeleccionada, 3).toString())));
            formAnotarLineaComanda.setVisible(true);
            cerrar();
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN PRODUCTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}