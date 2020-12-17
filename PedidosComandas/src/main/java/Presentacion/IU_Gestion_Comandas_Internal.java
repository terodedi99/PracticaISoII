/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empleado;
import Dominio.GestorComandas;
import Dominio.Servicio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;


public class IU_Gestion_Comandas_Internal extends javax.swing.JInternalFrame {
    
    public static Empleado sesionEmpleado;
    private ModeloTabla modelo;
    
    /**
     * Creates new form IU_Gestion_Comandas_Internal
     */
    public IU_Gestion_Comandas_Internal() {
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        //Se ponen las propiedades para la ventana
        this.setTitle("GESTIÓN DE COMANDAS");

        //Ajustes de la tabla
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos(); 
    }

    private void cargarTabla() {
        String nombreColumnas [] = {"ID_SERVICIO", "FECHA", "TURNO", "MESA", "ESTADO", "NUM_COMENSALES"};
        
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
    }
    
    public void cargarDatos() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Servicio> lista = GestorComandas.buscarListaServicios(sesionEmpleado);
        
        Object[] obj = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i);
            
            obj[0] = s.getIdServicio();
            obj[1] = formatter.format(s.getFecha());
            obj[2] = s.getnTurno();
            obj[3] = s.getnMesa();
            obj[4] = s.getEstado().toString();
            obj[5] = s.getNum_comensales();
            
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

        panelReservas = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnAnotarComanda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        btnBuscarServicio = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("GESTIÓN DE COMANDAS");

        btnAnotarComanda.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAnotarComanda.setText("ANOTAR COMANDA");
        btnAnotarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnotarComandaActionPerformed(evt);
            }
        });

        tablaServicios.setModel(modelo);
        jScrollPane1.setViewportView(tablaServicios);

        btnBuscarServicio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBuscarServicio.setText("BUSCAR SERVICIOS");
        btnBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addComponent(btnAnotarComanda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarServicio)))
                .addContainerGap())
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(lblTitulo)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnotarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnotarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnotarComandaActionPerformed
        int filaSeleccionada = tablaServicios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("OCUPADA") || tablaServicios.getValueAt(filaSeleccionada, 4).equals("PIDIENDO")) {
                if (tablaServicios.getValueAt(filaSeleccionada, 4).equals("OCUPADA")) {
                    boolean exito = GestorComandas.cambiarEstadoServicio(Integer.parseInt(tablaServicios.getValueAt(filaSeleccionada, 0).toString()), "PIDIENDO");
                    if (!exito) {
                        JOptionPane.showMessageDialog(null, "NO SE PUEDE CAMBIAR EL ESTADO A PIDIENDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } 
                }
                IU_Anotar_Comanda_Dialog anotarComanda = new IU_Anotar_Comanda_Dialog(null, true);
                anotarComanda.setFormGestionComandas(this);
                anotarComanda.setDatosComanda(tablaServicios.getValueAt(filaSeleccionada, 0).toString(), tablaServicios.getValueAt(filaSeleccionada, 2).toString(), tablaServicios.getValueAt(filaSeleccionada, 3).toString(), tablaServicios.getValueAt(filaSeleccionada, 1).toString(), tablaServicios.getValueAt(filaSeleccionada, 5).toString());
                anotarComanda.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DEBES SELECCIONAR UN SERVICIO", "NO SE PUEDE ANOTAR UNA COMANDA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnotarComandaActionPerformed

    private void btnBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicioActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnBuscarServicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnotarComanda;
    private javax.swing.JButton btnBuscarServicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
}