/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empleado;
import Dominio.GestorAlmacen;
import Dominio.Producto;
import Dominio.Restaurante;
import com.toedter.calendar.JTextFieldDateEditor;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

public class IU_Platos_Restaurante extends javax.swing.JFrame {

    public static Empleado sesionEmpleado;
    private ModeloTabla modelo;
     
    /**
     * Creates new form PlatosRestaurante
     */
    public IU_Platos_Restaurante() {
        //Se establece el empleado hasta que tengamos un sistema de login
        sesionEmpleado = new Empleado (3, "66666666F", "ALMACEN", "1", 926123451, Empleado.Rol.ALMACEN, new Restaurante(1));
        
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        //Se inicializa el JDateChooser
        this.seleccionFecha.setDate(new Date());
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.seleccionFecha.getDateEditor();
        editor.setEditable(false);
        
        //Se ponen las propiedades para la ventana
        this.setTitle("ALMACEN");
        this.setLocationRelativeTo(null);
        
        //Ajustes de la tabla
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos();
    }

    private void cargarTabla() {
        String nombreColumnas [] = {"ID_PRODUCTO", "DESCRIPCION_PRODUCTO", "TIPO_PRODUCTO", "TOTAL PREPARADOS"};
        
        for (String nombreColumna : nombreColumnas) {
            modelo.addColumn(nombreColumna);
        }
        
        TableColumn id = tablaProductos.getColumn("ID_PRODUCTO");
        id.setMinWidth(80);
        
        TableColumn descripcion = tablaProductos.getColumn("DESCRIPCION_PRODUCTO");
        descripcion.setMinWidth(80);
        
        TableColumn tipo = tablaProductos.getColumn("TIPO_PRODUCTO");
        tipo.setMinWidth(80);
        
        TableColumn total = tablaProductos.getColumn("TOTAL PREPARADOS");
        total.setMinWidth(80);
    }
    
    public void cargarDatos() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Producto> lista = GestorAlmacen.readProductosCantidad (this.seleccionFecha.getDate(), sesionEmpleado);
        
        Object[] obj = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            Producto p = lista.get(i);
            
            obj[0] = p.getIdProducto();
            obj[1] = p.getDescripcionProducto();
            obj[2] = p.getTipoProducto();
            obj[3] = p.getPlatosPreparados();
            
            modelo.addRow(obj);
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

        jPanel1 = new javax.swing.JPanel();
        lblTitutlo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnActualizarAlmacen = new javax.swing.JButton();
        seleccionFecha = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        btnIngredientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitutlo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitutlo.setText("PLATOS RESTAURANTE");

        tablaProductos.setModel(modelo);
        jScrollPane1.setViewportView(tablaProductos);

        btnActualizarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnActualizarAlmacen.setText("ACTUALIZAR ALMACEN");
        btnActualizarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAlmacenActionPerformed(evt);
            }
        });

        seleccionFecha.setDateFormatString("dd/MM/yyyy");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setText("BUSCAR PLATOS");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnIngredientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIngredientes.setText("MOSTRAR ALERTAS");
        btnIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(seleccionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizarAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIngredientes)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(lblTitutlo)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitutlo)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seleccionFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizarAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIngredientes))
                .addContainerGap())
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAlmacenActionPerformed
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            this.setVisible(false);
            IU_Platos_Stock formProductos = new IU_Platos_Stock();
            formProductos.setFormProductosRestaurante(this);
            formProductos.setVisible(true);
            formProductos.setDatosProducto(tablaProductos.getValueAt(filaSeleccionada, 0).toString(), tablaProductos.getValueAt(filaSeleccionada, 1).toString());
            formProductos.cargarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN PRODUCTO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarAlmacenActionPerformed

    private void btnIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngredientesActionPerformed
        this.setVisible(false);
        IU_Ingredientes_Stock formIngredientes = new IU_Ingredientes_Stock();
        formIngredientes.setFormProductosRestaurante(this);
        formIngredientes.setVisible(true);
    }//GEN-LAST:event_btnIngredientesActionPerformed

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
            java.util.logging.Logger.getLogger(IU_Platos_Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_Platos_Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_Platos_Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_Platos_Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IU_Platos_Restaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarAlmacen;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnIngredientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitutlo;
    private com.toedter.calendar.JDateChooser seleccionFecha;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
