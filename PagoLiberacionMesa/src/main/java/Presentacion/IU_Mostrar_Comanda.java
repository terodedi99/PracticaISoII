/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.GestorPagoComanda;
import Dominio.LineaComanda;
import java.util.ArrayList;
import javax.swing.table.TableColumn;


public class IU_Mostrar_Comanda extends javax.swing.JDialog {

    private ModeloTabla modelo;
    
    /**
     * Creates new form IU_Mostrar_Comanda
     */
    public IU_Mostrar_Comanda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        //Se ponen las propiedades para la ventana
        this.setTitle("DATOS COMANDA");
        this.setLocationRelativeTo(parent);
        
        //Ajustes de la tabla
        tablaLineasComanda.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); //cargarDatos(); 
    }

    private void cargarTabla() {
        String nombreColumnas [] = {"ID_LINEA_COMANDA", "DESCRIPCION_PRODUCTO", "TIPO_PRODUCTO", "CANTIDAD", "PRECIO VENTA"};
        
        for (String nombreColumna : nombreColumnas) {
            modelo.addColumn(nombreColumna);
        }
        
        TableColumn id = tablaLineasComanda.getColumn("ID_LINEA_COMANDA");
        id.setMinWidth(80);
        
        TableColumn descripcion = tablaLineasComanda.getColumn("DESCRIPCION_PRODUCTO");
        descripcion.setMinWidth(80);
        
        TableColumn tipo = tablaLineasComanda.getColumn("TIPO_PRODUCTO");
        tipo.setMinWidth(80);
        
        TableColumn cantidad = tablaLineasComanda.getColumn("CANTIDAD");
        cantidad.setMinWidth(80);
        
        TableColumn precio = tablaLineasComanda.getColumn("PRECIO VENTA");
        precio.setMinWidth(80);
    }
    
    public void cargarDatos() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<LineaComanda> lista = GestorPagoComanda.buscarLineasComanda(Integer.parseInt(txtIdComanda.getText()));
        
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            LineaComanda l = lista.get(i);
            
            obj[0] = l.getIdLineaComanda();
            obj[1] = l.getnLinea().getDescripcionProducto();
            obj[2] = l.getnLinea().getTipoProducto();
            obj[3] = l.getCantidad();
            obj[4] = l.getPrecioVenta();
            
            modelo.addRow(obj);
        }
    }
    
    public void setDatosComanda (int idComanda, float total) {
        txtIdComanda.setText(String.valueOf(idComanda));
        txtTotal.setText(String.valueOf(total));
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
        lblIdComanda = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtIdComanda = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLineasComanda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("COMANDA");

        lblIdComanda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIdComanda.setText("ID COMANDA:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal.setText("TOTAL:");

        txtIdComanda.setEditable(false);

        txtTotal.setEditable(false);

        tablaLineasComanda.setModel(modelo);
        jScrollPane1.setViewportView(tablaLineasComanda);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(328, 328, 328)
                                .addComponent(lblTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdComanda)
                                    .addComponent(lblTotal))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 323, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdComanda)
                    .addComponent(txtIdComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(IU_Mostrar_Comanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_Mostrar_Comanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_Mostrar_Comanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_Mostrar_Comanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IU_Mostrar_Comanda dialog = new IU_Mostrar_Comanda(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdComanda;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaLineasComanda;
    private javax.swing.JTextField txtIdComanda;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}