/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.GestorAlmacen;
import Dominio.Ingrediente;
import java.util.ArrayList;
import javax.swing.table.TableColumn;


public class IU_Ingredientes_Stock_Dialog extends javax.swing.JDialog {

    private ModeloTabla modelo;
    
    /**
     * Creates new form IU_Ingredientes_Stock_Dialog
     */
    public IU_Ingredientes_Stock_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        this.setTitle("ALERTAS DE INGREDIENTES");
        this.setLocationRelativeTo(parent); 
        
        //Ajustes de la tabla
        tablaIngredientes.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos();
        
        this.tablaIngredientes.setDefaultRenderer(Object.class, new RendererAlerta());
    }

    private void cargarTabla() {
        String nombreColumnas [] = {"ID_INGREDIENTE", "DESCRIPCION", "STOCK MINIMO", "CANTIDAD", "UNIDAD"};
        
        for (String nombreColumna : nombreColumnas) {
            modelo.addColumn(nombreColumna);
        }
        
        TableColumn id = tablaIngredientes.getColumn("ID_INGREDIENTE");
        id.setMinWidth(80);
        
        TableColumn descripcion = tablaIngredientes.getColumn("DESCRIPCION");
        descripcion.setMinWidth(80);
        
        TableColumn stock = tablaIngredientes.getColumn("STOCK MINIMO");
        stock.setMinWidth(80);
        
        TableColumn cantidad = tablaIngredientes.getColumn("CANTIDAD");
        cantidad.setMinWidth(80);
        
        TableColumn unidad = tablaIngredientes.getColumn("UNIDAD");
        unidad.setMinWidth(80);
    }
    
    public void cargarDatos() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Ingrediente> lista = GestorAlmacen.readIngredientesStock(IU_Platos_Restaurante_Internal.sesionEmpleado.getnRestaurante());
        
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            Ingrediente ingr = lista.get(i);
            
            obj[0] = ingr.getIdIngrediente();
            obj[1] = ingr.getDescripcionIngrediente();
            obj[2] = ingr.getStockIdeal();
            obj[3] = ingr.getCantidad();
            obj[4] = ingr.getUnidad();
            
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
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("INGREDIENTES");

        tablaIngredientes.setModel(modelo);
        jScrollPane1.setViewportView(tablaIngredientes);

        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRefrescar.setText("REFRESCAR");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(lblTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRefrescar)))
                        .addGap(0, 248, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnRefrescar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnRefrescarActionPerformed

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
            java.util.logging.Logger.getLogger(IU_Ingredientes_Stock_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_Ingredientes_Stock_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_Ingredientes_Stock_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_Ingredientes_Stock_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IU_Ingredientes_Stock_Dialog dialog = new IU_Ingredientes_Stock_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaIngredientes;
    // End of variables declaration//GEN-END:variables
}
