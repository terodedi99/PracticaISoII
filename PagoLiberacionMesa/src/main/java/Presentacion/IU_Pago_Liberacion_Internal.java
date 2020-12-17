/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Comanda;
import Dominio.Empleado;
import Dominio.GestorPagoComanda;
import Dominio.Servicio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class IU_Pago_Liberacion_Internal extends javax.swing.JInternalFrame {

    public static Empleado sesionEmpleado;
    private ModeloTabla modelo;
    
    /**
     * Creates new form IU_Pago_Liberacion_Internal
     */
    public IU_Pago_Liberacion_Internal() {
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        //Se ponen las propiedades para la ventana
        this.setTitle("PAGO Y LIBERACIÓN DE MESAS");
        
        //Ajustes de la tabla
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos(); 
    }

    private void cargarTabla() {
        String nombreColumnas [] = {"ID_SERVICIO", "FECHA", "TURNO", "MESA", "ESTADO", "NUM_COMENSALES", "ID_COMANDA", "TOTAL"};
        
        for (String nombreColumna : nombreColumnas) {
            modelo.addColumn(nombreColumna);
        }
        
        TableColumn id = tablaServicios.getColumn("ID_SERVICIO");
        id.setMinWidth(80);
        
        TableColumn fecha = tablaServicios.getColumn("FECHA");
        fecha.setMinWidth(80);
        
        TableColumn turno = tablaServicios.getColumn("TURNO");
        turno.setMinWidth(80);
        
        TableColumn mesa = tablaServicios.getColumn("MESA");
        mesa.setMinWidth(80);
        
        TableColumn estado = tablaServicios.getColumn("ESTADO");
        estado.setMinWidth(80);
        
        TableColumn comensales = tablaServicios.getColumn("NUM_COMENSALES");
        comensales.setMinWidth(80);
        
        TableColumn idComanda = tablaServicios.getColumn("ID_COMANDA");
        idComanda.setMinWidth(80);
        
        TableColumn total = tablaServicios.getColumn("TOTAL");
        total.setMinWidth(80);
    }
    
    public void cargarDatos() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Comanda> lista = GestorPagoComanda.buscarListaComandas(sesionEmpleado);
        
        Object[] obj = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            Comanda c = lista.get(i);
            
            obj[0] = c.getServicio().getIdServicio();
            obj[1] = formatter.format(c.getServicio().getFecha());
            obj[2] = c.getServicio().getnTurno().getNombreTurno();
            obj[3] = c.getServicio().getnMesa().getNombreMesa();
            obj[4] = c.getServicio().getEstado().toString();
            obj[5] = c.getServicio().getNum_comensales();
            obj[6] = c.getIdComanda();
            obj[7] = c.getTotal();
            
            modelo.addRow(obj);
        }
    }
    
    public JTable getTablaServicios () {
        return this.tablaServicios;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnMostrarCuenta = new javax.swing.JButton();
        btnCuentaEntregada = new javax.swing.JButton();
        btnConfirmarPago = new javax.swing.JButton();
        btnMesaPreparada = new javax.swing.JButton();

        tablaServicios.setModel(modelo);
        jScrollPane1.setViewportView(tablaServicios);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("PAGO Y LIBERACIÓN DE MESA");

        btnMostrarCuenta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostrarCuenta.setText("MOSTRAR LA CUENTA");
        btnMostrarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCuentaActionPerformed(evt);
            }
        });

        btnCuentaEntregada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCuentaEntregada.setText("CUENTA ENTREGADA");
        btnCuentaEntregada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaEntregadaActionPerformed(evt);
            }
        });

        btnConfirmarPago.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnConfirmarPago.setText("CONFIRMAR PAGO");
        btnConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarPagoActionPerformed(evt);
            }
        });

        btnMesaPreparada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMesaPreparada.setText("MESA PREPARADA");
        btnMesaPreparada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesaPreparadaActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarCuenta)
                            .addComponent(btnCuentaEntregada, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmarPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMesaPreparada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarCuenta)
                    .addComponent(btnConfirmarPago))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuentaEntregada)
                    .addComponent(btnMesaPreparada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCuentaActionPerformed
        int filaSeleccionada = tablaServicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("SERVIDOS")) {
                Servicio s = new Servicio (Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 0).toString()), 0, "");
                s.setEstado(Servicio.Estado.ESPERANDO_LA_CUENTA);
                Comanda c = new Comanda(s);
                c.updateServicio();
            }
            IU_Mostrar_Comanda formMostrarComanda = new IU_Mostrar_Comanda(null, true);
            formMostrarComanda.setDatosComanda(Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 6).toString()), Float.parseFloat(tablaServicios.getValueAt(filaSeleccionada, 7).toString()));
            formMostrarComanda.cargarDatos();
            formMostrarComanda.setVisible(true);

            cargarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN SERVICIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMostrarCuentaActionPerformed

    private void btnCuentaEntregadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaEntregadaActionPerformed
        int filaSeleccionada = tablaServicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("ESPERANDO_LA_CUENTA")) {
                Servicio s = new Servicio (Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 0).toString()), 0, "");
                s.setEstado(Servicio.Estado.PAGANDO);
                Comanda c = new Comanda(s);
                c.updateServicio();

                cargarDatos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN SERVICIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCuentaEntregadaActionPerformed

    private void btnConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarPagoActionPerformed
        int filaSeleccionada = tablaServicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("PAGANDO")) {
                IU_Metodo_Pago formMetodoPago = new IU_Metodo_Pago(null, true);
                formMetodoPago.setDatosComanda(Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 6).toString()), Float.parseFloat(tablaServicios.getValueAt(filaSeleccionada, 7).toString()));
                formMetodoPago.setFormPagoLiberacion(this);
                formMetodoPago.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN SERVICIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarPagoActionPerformed

    private void btnMesaPreparadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesaPreparadaActionPerformed
        int filaSeleccionada = tablaServicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("EN_PREPARACION")) {
                Servicio s = new Servicio (Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 0).toString()), 0, "");
                s.setEstado(Servicio.Estado.FINALIZADA);
                Comanda c = new Comanda(s);
                c.updateServicio();

                cargarDatos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN SERVICIO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMesaPreparadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmarPago;
    private javax.swing.JButton btnCuentaEntregada;
    private javax.swing.JButton btnMesaPreparada;
    private javax.swing.JButton btnMostrarCuenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
}