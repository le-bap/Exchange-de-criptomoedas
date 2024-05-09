package view;

import control.ControllerVenderBitcoin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Letizia
 */
public class VenderBitcoin extends javax.swing.JFrame {
    private Investidor investidor;
    
    public VenderBitcoin(Investidor investidor) {
        initComponents();
        this.investidor = investidor;
        control = new ControllerVenderBitcoin(this, investidor);
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public ControllerVenderBitcoin getControl() {
        return control;
    }

    public void setControl(ControllerVenderBitcoin control) {
        this.control = control;
    }

    public JButton getBtComprar() {
        return btVender;
    }

    public void setBtComprar(JButton btComprar) {
        this.btVender = btComprar;
    }

    public JLabel getLblTexto() {
        return lblTexto;
    }

    public void setLblTexto(JLabel lblTexto) {
        this.lblTexto = lblTexto;
    }

    public JLabel getLblTexto3() {
        return lblTexto3;
    }

    public void setLblTexto3(JLabel lblTexto3) {
        this.lblTexto3 = lblTexto3;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(JTextField txtValor) {
        this.txtValor = txtValor;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTexto = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btVender = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblTexto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTexto.setText("Por favor, digite a quantidade que deseja vender:");

        btVender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btVender.setForeground(new java.awt.Color(51, 51, 255));
        btVender.setText("Vender");
        btVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("Vender Bitcoins");

        lblTexto3.setText("LEMBRE-SE QUE HAVERÁ UMA COBRANÇA DE 3% DO VALOR DESEJADO.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTexto3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
        control.vender(investidor);
    }//GEN-LAST:event_btVenderActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VenderBitcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VenderBitcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VenderBitcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VenderBitcoin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VenderBitcoin().setVisible(true);
//            }
//        });
//    }
    private ControllerVenderBitcoin control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVender;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblTexto3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
