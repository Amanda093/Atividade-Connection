/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Controle;

/**
 *
 * @author vovig
 */
public class cadastro extends javax.swing.JFrame {

    /**
     * Creates new form cadastro
     */
    public cadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conteudo = new javax.swing.JPanel();
        inputs = new javax.swing.JPanel();
        codigo = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        nome = new javax.swing.JPanel();
        labelEmail1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        datanasc = new javax.swing.JPanel();
        labelEmail2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        telefone = new javax.swing.JPanel();
        labelEmail3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        Email = new javax.swing.JPanel();
        labelEmail4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        titulo = new javax.swing.JPanel();
        log = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexão Java com MySql");
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);

        conteudo.setPreferredSize(new java.awt.Dimension(700, 500));

        inputs.setForeground(new java.awt.Color(89, 76, 71));
        inputs.setPreferredSize(new java.awt.Dimension(500, 400));

        codigo.setPreferredSize(new java.awt.Dimension(300, 70));

        labelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail.setForeground(new java.awt.Color(64, 39, 89));
        labelEmail.setText("Código");

        jTextField1.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField1.setSelectionColor(new java.awt.Color(79, 56, 89));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout codigoLayout = new javax.swing.GroupLayout(codigo);
        codigo.setLayout(codigoLayout);
        codigoLayout.setHorizontalGroup(
            codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(codigoLayout.createSequentialGroup()
                .addComponent(labelEmail)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        codigoLayout.setVerticalGroup(
            codigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(codigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inputs.add(codigo);

        nome.setPreferredSize(new java.awt.Dimension(300, 70));

        labelEmail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail1.setForeground(new java.awt.Color(64, 39, 89));
        labelEmail1.setText("Nome");

        jTextField2.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField2.setSelectionColor(new java.awt.Color(79, 56, 89));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nomeLayout = new javax.swing.GroupLayout(nome);
        nome.setLayout(nomeLayout);
        nomeLayout.setHorizontalGroup(
            nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(nomeLayout.createSequentialGroup()
                .addComponent(labelEmail1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        nomeLayout.setVerticalGroup(
            nomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        inputs.add(nome);

        datanasc.setPreferredSize(new java.awt.Dimension(300, 70));

        labelEmail2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail2.setForeground(new java.awt.Color(64, 39, 89));
        labelEmail2.setText("Data Nascimento");

        jTextField3.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField3.setSelectionColor(new java.awt.Color(79, 56, 89));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datanascLayout = new javax.swing.GroupLayout(datanasc);
        datanasc.setLayout(datanascLayout);
        datanascLayout.setHorizontalGroup(
            datanascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(datanascLayout.createSequentialGroup()
                .addComponent(labelEmail2)
                .addGap(0, 195, Short.MAX_VALUE))
        );
        datanascLayout.setVerticalGroup(
            datanascLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datanascLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        inputs.add(datanasc);

        telefone.setPreferredSize(new java.awt.Dimension(300, 70));

        labelEmail3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail3.setForeground(new java.awt.Color(64, 39, 89));
        labelEmail3.setText("Telefone");

        jTextField4.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField4.setSelectionColor(new java.awt.Color(79, 56, 89));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout telefoneLayout = new javax.swing.GroupLayout(telefone);
        telefone.setLayout(telefoneLayout);
        telefoneLayout.setHorizontalGroup(
            telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(telefoneLayout.createSequentialGroup()
                .addComponent(labelEmail3)
                .addGap(0, 249, Short.MAX_VALUE))
        );
        telefoneLayout.setVerticalGroup(
            telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        inputs.add(telefone);

        Email.setPreferredSize(new java.awt.Dimension(300, 70));

        labelEmail4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelEmail4.setForeground(new java.awt.Color(64, 39, 89));
        labelEmail4.setText("Email");

        jTextField5.setPreferredSize(new java.awt.Dimension(50, 20));
        jTextField5.setSelectionColor(new java.awt.Color(79, 56, 89));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmailLayout = new javax.swing.GroupLayout(Email);
        Email.setLayout(EmailLayout);
        EmailLayout.setHorizontalGroup(
            EmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EmailLayout.createSequentialGroup()
                .addComponent(labelEmail4)
                .addGap(0, 268, Short.MAX_VALUE))
        );
        EmailLayout.setVerticalGroup(
            EmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelEmail4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        inputs.add(Email);

        javax.swing.GroupLayout conteudoLayout = new javax.swing.GroupLayout(conteudo);
        conteudo.setLayout(conteudoLayout);
        conteudoLayout.setHorizontalGroup(
            conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        conteudoLayout.setVerticalGroup(
            conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titulo.setForeground(new java.awt.Color(89, 76, 71));
        titulo.setPreferredSize(new java.awt.Dimension(400, 80));

        log.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        log.setForeground(new java.awt.Color(64, 39, 89));
        log.setText("Cadastro do Cliente");
        titulo.add(log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conteudo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Email;
    private javax.swing.JPanel codigo;
    private javax.swing.JPanel conteudo;
    private javax.swing.JPanel datanasc;
    private javax.swing.JPanel inputs;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEmail1;
    private javax.swing.JLabel labelEmail2;
    private javax.swing.JLabel labelEmail3;
    private javax.swing.JLabel labelEmail4;
    private javax.swing.JLabel log;
    private javax.swing.JPanel nome;
    private javax.swing.JPanel telefone;
    private javax.swing.JPanel titulo;
    // End of variables declaration//GEN-END:variables
}
