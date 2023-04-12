package report;

import factory.conectaPostgreSQL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio extends javax.swing.JFrame {

    public static final String ClientesCadastradosView = System.getProperty("user.dir") + "/src/reports/RelatorioClientesCadastrados.jasper";
    public static final String ClientesCadastradosPDF = System.getProperty("user.dir") + "/src/reports/RelatorioClientesCadastrados.pdf";
    
    public static final String EmprestimosParaUsuarioEspecificoView = System.getProperty("user.dir") + "/src/reports/RelatorioEmprestimosParaUsuarioEspecifico.jasper";
    public static final String EmprestimosParaUsuarioEspecificoPDF = System.getProperty("user.dir") + "/src/reports/RelatorioEmprestimosParaUsuarioEspecifico.pdf";
    
    public static final String QuantidadeObservacoesPorEmprestimoView = System.getProperty("user.dir") + "/src/reports/RelatorioQuantidadeObservacoesPorEmprestimo.jasper";
    public static final String QuantidadeObservacoesPorEmprestimoPDF = System.getProperty("user.dir") + "/src/reports/RelatorioQuantidadeObservacoesPorEmprestimo.pdf";

    private Map parametroRelatorioEmprestimos(int valor) {
        Map params = new HashMap();
        params.put("USUARIO_ID", valor);
        return params;
    }
    
    public Relatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        visualizarClientesCadastrados = new javax.swing.JButton();
        visualizarEmprestimosPorUsuario = new javax.swing.JButton();
        visualizarQuantidadeObservacoes = new javax.swing.JButton();
        imprimirClientesCadastrados = new javax.swing.JButton();
        imprimirEmprestimosPorUsuario = new javax.swing.JButton();
        imprimirQuantidadeObservacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Visualizar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Imprimir");

        visualizarClientesCadastrados.setText("Clientes Cadastrados");
        visualizarClientesCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarClientesCadastradosActionPerformed(evt);
            }
        });

        visualizarEmprestimosPorUsuario.setText("Emprestimos pada Determinado Usuario");
        visualizarEmprestimosPorUsuario.setToolTipText("");
        visualizarEmprestimosPorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarEmprestimosPorUsuarioActionPerformed(evt);
            }
        });

        visualizarQuantidadeObservacoes.setText("Quantidade de Observacoes por Emprestimo");
        visualizarQuantidadeObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarQuantidadeObservacoesActionPerformed(evt);
            }
        });

        imprimirClientesCadastrados.setText("Clientes Cadastrados");
        imprimirClientesCadastrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirClientesCadastradosActionPerformed(evt);
            }
        });

        imprimirEmprestimosPorUsuario.setText("Emprestimos pada Determinado Usuario");
        imprimirEmprestimosPorUsuario.setToolTipText("");
        imprimirEmprestimosPorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirEmprestimosPorUsuarioActionPerformed(evt);
            }
        });

        imprimirQuantidadeObservacoes.setText("Quantidade de Observacoes por Emprestimo");
        imprimirQuantidadeObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirQuantidadeObservacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(visualizarClientesCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(visualizarEmprestimosPorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(visualizarQuantidadeObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imprimirClientesCadastrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirEmprestimosPorUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imprimirQuantidadeObservacoes)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visualizarClientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(visualizarEmprestimosPorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(visualizarQuantidadeObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imprimirClientesCadastrados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imprimirEmprestimosPorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imprimirQuantidadeObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void visualizarClientesCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarClientesCadastradosActionPerformed
        JasperPrint visualizarRelatorio;
        try {
            visualizarRelatorio = JasperFillManager.fillReport(ClientesCadastradosView, null, conectaPostgreSQL.conectaBanco());
            JasperViewer.viewReport(visualizarRelatorio);
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao visualizar o relatorio de Clientes Cadastrados");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_visualizarClientesCadastradosActionPerformed

    private void imprimirClientesCadastradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirClientesCadastradosActionPerformed
        JasperPrint imprimirRelatorio;
        try {
            imprimirRelatorio = JasperFillManager.fillReport(ClientesCadastradosView, null, conectaPostgreSQL.conectaBanco());
            JasperExportManager.exportReportToPdfFile(imprimirRelatorio, ClientesCadastradosPDF);
            JOptionPane.showMessageDialog(this, "Relatório de Clientes Gerado com Sucesso");
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao imprimir o relatorio de Clientes Cadastrados");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_imprimirClientesCadastradosActionPerformed

    private void visualizarEmprestimosPorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarEmprestimosPorUsuarioActionPerformed
        JasperPrint visualizarRelatorio;
        String valorString = JOptionPane.showInputDialog("Entre com o ID do Usuario: ");
        try {
            visualizarRelatorio = JasperFillManager.fillReport(EmprestimosParaUsuarioEspecificoView, parametroRelatorioEmprestimos(Integer.parseInt(valorString)), conectaPostgreSQL.conectaBanco());
            JasperViewer.viewReport(visualizarRelatorio);
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao visualizar o relatorio de Emprestimos");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_visualizarEmprestimosPorUsuarioActionPerformed

    private void imprimirEmprestimosPorUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirEmprestimosPorUsuarioActionPerformed
        JasperPrint imprimirRelatorio;
        String valorString = JOptionPane.showInputDialog("Entre com o ID do Usuario: ");
        try {
            imprimirRelatorio = JasperFillManager.fillReport(EmprestimosParaUsuarioEspecificoView, parametroRelatorioEmprestimos(Integer.parseInt(valorString)), conectaPostgreSQL.conectaBanco());
            JasperExportManager.exportReportToPdfFile(imprimirRelatorio, EmprestimosParaUsuarioEspecificoPDF);
            JOptionPane.showMessageDialog(this, "Relatório de Emprestimos Gerado com Sucesso");
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao imprimir o relatorio de Emprestimos");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_imprimirEmprestimosPorUsuarioActionPerformed

    private void visualizarQuantidadeObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarQuantidadeObservacoesActionPerformed
        JasperPrint visualizarRelatorio;
        try {
            visualizarRelatorio = JasperFillManager.fillReport(QuantidadeObservacoesPorEmprestimoView, null, conectaPostgreSQL.conectaBanco());
            JasperViewer.viewReport(visualizarRelatorio);
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao visualizar o relatorio de Quantidade de Observações");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_visualizarQuantidadeObservacoesActionPerformed

    private void imprimirQuantidadeObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirQuantidadeObservacoesActionPerformed
        JasperPrint imprimirRelatorio;
        try {
            imprimirRelatorio = JasperFillManager.fillReport(QuantidadeObservacoesPorEmprestimoView, null, conectaPostgreSQL.conectaBanco());
            JasperExportManager.exportReportToPdfFile(imprimirRelatorio, QuantidadeObservacoesPorEmprestimoPDF);
            JOptionPane.showMessageDialog(this, "Relatório de Quantidade de Observações Gerado com Sucesso");
        } catch (JRException ex) {
            System.err.println("Ocorreu um erro ao imprimir o relatorio de Quantidade de Observações");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_imprimirQuantidadeObservacoesActionPerformed

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
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imprimirClientesCadastrados;
    private javax.swing.JButton imprimirEmprestimosPorUsuario;
    private javax.swing.JButton imprimirQuantidadeObservacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton visualizarClientesCadastrados;
    private javax.swing.JButton visualizarEmprestimosPorUsuario;
    private javax.swing.JButton visualizarQuantidadeObservacoes;
    // End of variables declaration//GEN-END:variables
}
