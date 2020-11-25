/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Dominio.GestorServicio;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class IU_Reservar_Mesa extends javax.swing.JFrame {

    private final WindowListener exitListener;
    private IU_Gestion_Reservas formGestion;
    
    /**
     * Creates new form IU_Reservar_Mesa
     */
    public IU_Reservar_Mesa() {
        this.exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                formGestion.setVisible(true);
                cerrar();
            }
        };
        
        initComponents();
        
        this.setTitle("RESERVAR MESA");
        this.setLocationRelativeTo(null); 
        this.addWindowListener(exitListener);
    }
    
    private void cerrar() {
        this.dispose();
    }
    
    public void setFormGestionReservas (IU_Gestion_Reservas formGestion) {
        this.formGestion = formGestion;
    }
    
    public void setDatosServicio (String idServicio, String turno, String mesa, String fecha) {
        txtIdServicio.setText(idServicio);
        txtTurno.setText(turno);
        txtMesa.setText(mesa);
        txtFecha.setText(fecha);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReservaMesas = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIdServicio = new javax.swing.JLabel();
        txtIdServicio = new javax.swing.JTextField();
        cboNumComensales = new javax.swing.JComboBox<>();
        lblNumComensales = new javax.swing.JLabel();
        lblComentarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        btnReservar = new javax.swing.JButton();
        lblMesa = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtMesa = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("RESERVA MESA");

        lblIdServicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIdServicio.setText("SERVICIO:");

        txtIdServicio.setEditable(false);

        cboNumComensales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- NUM COMENSALES --", "2", "4", "6" }));

        lblNumComensales.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNumComensales.setText("NÚMERO COMENSALES:");

        lblComentarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblComentarios.setText("COMENTARIOS:");

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane1.setViewportView(txtComentarios);

        btnReservar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReservar.setText("CONFIRMAR RESERVA");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        lblMesa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMesa.setText("MESA:");

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTurno.setText("TURNO:");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFecha.setText("FECHA:");

        txtMesa.setEditable(false);

        txtTurno.setEditable(false);

        txtFecha.setEditable(false);

        javax.swing.GroupLayout panelReservaMesasLayout = new javax.swing.GroupLayout(panelReservaMesas);
        panelReservaMesas.setLayout(panelReservaMesasLayout);
        panelReservaMesasLayout.setHorizontalGroup(
            panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservaMesasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(151, 151, 151))
            .addGroup(panelReservaMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservaMesasLayout.createSequentialGroup()
                        .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurno)
                            .addComponent(lblFecha))
                        .addGap(161, 161, 161)
                        .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTurno)
                            .addComponent(txtFecha)))
                    .addGroup(panelReservaMesasLayout.createSequentialGroup()
                        .addComponent(lblMesa)
                        .addGap(176, 176, 176)
                        .addComponent(txtMesa))
                    .addGroup(panelReservaMesasLayout.createSequentialGroup()
                        .addComponent(lblIdServicio)
                        .addGap(135, 135, 135)
                        .addComponent(txtIdServicio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelReservaMesasLayout.createSequentialGroup()
                        .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelReservaMesasLayout.createSequentialGroup()
                                .addComponent(lblNumComensales)
                                .addGap(18, 18, 18)
                                .addComponent(cboNumComensales, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnReservar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelReservaMesasLayout.setVerticalGroup(
            panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservaMesasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(43, 43, 43)
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdServicio)
                    .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMesa)
                    .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurno)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(panelReservaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumComensales)
                    .addComponent(cboNumComensales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblComentarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReservar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservaMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservaMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        boolean exito = GestorServicio.reservarServicio(Integer.parseInt(this.txtIdServicio.getText()), this.cboNumComensales.getSelectedItem().toString(), this.txtComentarios.getText());
        if (exito) {
            this.setVisible(false);
            formGestion.setVisible(true);
            formGestion.cargarDatos();
            cerrar();
        }
    }//GEN-LAST:event_btnReservarActionPerformed

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
            java.util.logging.Logger.getLogger(IU_Reservar_Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IU_Reservar_Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IU_Reservar_Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IU_Reservar_Mesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IU_Reservar_Mesa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cboNumComensales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblComentarios;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdServicio;
    private javax.swing.JLabel lblMesa;
    private javax.swing.JLabel lblNumComensales;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panelReservaMesas;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdServicio;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
