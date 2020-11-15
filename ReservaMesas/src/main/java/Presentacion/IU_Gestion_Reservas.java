/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.Empleado;
import Dominio.GestorServicio;
import Dominio.Pase;
import Dominio.Restaurante;
import Dominio.Servicio;
import com.toedter.calendar.JTextFieldDateEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.TableColumn;

/**
 *
 * @author pikac
 */
public class IU_Gestion_Reservas extends javax.swing.JFrame {

    private static Empleado sesionEmpleado;
    private ModeloTabla modelo;
    private Pase[] pases;
    
    /**
     * Creates new form IU_Gestion_Reservas
     */
    public IU_Gestion_Reservas() {
        //Se establece el empleado hasta que tengamos un sistema de login
        sesionEmpleado = new Empleado (3, "33333333C", "JEFE", "DE SALA", 926123458, Empleado.Rol.JEFE_DE_SALA, new Restaurante(1));
        
        //Establecemos el modelo de tabla
        modelo = new ModeloTabla();
        
        initComponents();
        
        //Establecer Pases para Combobox
        this.pases = new Pase[3];
        pases[0] = new Pase(0,"--PASES--"); 
        pases[1] = new Pase(1,"COMIDA"); 
        pases[2] = new Pase(2,"CENA");
        cargarPases();
        
        //Se inicializa el JDateChooser
        this.seleccionFecha.setDate(new Date());
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.seleccionFecha.getDateEditor();
        editor.setEditable(false);
        
        //Se ponen las propiedades para la ventana
        this.setTitle("GESTIÓN DE RESERVAS");
        this.setLocationRelativeTo(null);
        
        //Ajustes de la tabla
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        cargarTabla(); cargarDatos(); 
    }

    private void cargarPases() {
        for (Pase pase : this.pases) {
            cboPases.addItem(pase);
        }
        
        cboPases.setSelectedIndex(0);
    }
    
    private void cargarTabla() {
        String nombreColumnas [] = {"ID_SERVICIO", "FECHA", "TURNO", "MESA", "ESTADO"};
        
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
    }
    
    private void cargarDatos() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Servicio> lista = GestorServicio.buscarListaServicios(this.seleccionFecha.getDate(), sesionEmpleado);
        
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i);
            
            obj[0] = s.getIdServicio();
            obj[1] = formatter.format(s.getFecha());
            obj[2] = s.getnTurno();
            obj[3] = s.getnMesa();
            obj[4] = s.getEstado().toString();
            
            modelo.addRow(obj);
        }
    }
    
    private void cargarDatos (Pase pase) {    
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        ArrayList<Servicio> lista = GestorServicio.buscarListaServicios(this.seleccionFecha.getDate(), sesionEmpleado, pase);
        
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i);
            
            obj[0] = s.getIdServicio();
            obj[1] = formatter.format(s.getFecha());
            obj[2] = s.getnTurno();
            obj[3] = s.getnMesa();
            obj[4] = s.getEstado().toString();
            
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
        btnReservarMesa = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        btnAsignarCamarero = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        btnBuscarServicio = new javax.swing.JButton();
        seleccionFecha = new com.toedter.calendar.JDateChooser();
        cboPases = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("GESTIÓN DE RESERVAS");

        btnReservarMesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReservarMesa.setText("RESERVAR MESA");
        btnReservarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarMesaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCancelarReserva.setText("CANCELAR RESERVA");
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        btnAsignarCamarero.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAsignarCamarero.setText("ASIGNAR CAMARERO");
        btnAsignarCamarero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCamareroActionPerformed(evt);
            }
        });

        tablaServicios.setModel(modelo);
        jScrollPane1.setViewportView(tablaServicios);

        btnBuscarServicio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBuscarServicio.setText("BUSCAR");
        btnBuscarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServicioActionPerformed(evt);
            }
        });

        seleccionFecha.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnReservarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboPases, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(seleccionFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAsignarCamarero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(40, 40, 40)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReservarMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAsignarCamarero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPases))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnReservarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservarMesaActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void btnAsignarCamareroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCamareroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarCamareroActionPerformed

    private void btnBuscarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServicioActionPerformed
        if (cboPases.getSelectedIndex() > 0) {
            cargarDatos ((Pase) cboPases.getSelectedItem());
        } else {
            cargarDatos();
        }
    }//GEN-LAST:event_btnBuscarServicioActionPerformed

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
            java.util.logging.Logger.getLogger(IU_Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_Gestion_Reservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IU_Gestion_Reservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarCamarero;
    private javax.swing.JButton btnBuscarServicio;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnReservarMesa;
    private javax.swing.JComboBox<Pase> cboPases;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelReservas;
    private com.toedter.calendar.JDateChooser seleccionFecha;
    private javax.swing.JTable tablaServicios;
    // End of variables declaration//GEN-END:variables
}
