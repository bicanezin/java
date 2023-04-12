package view;

import controller.ControleTexto;
import java.io.File;
import javax.swing.JOptionPane;
import static view.Principal.getArquivo;

public class Observacoes extends javax.swing.JFrame {

    private ControleTexto controle;
    private Principal principal;

    public Observacoes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaObservacoes = new javax.swing.JTextArea();
        btnSalvarObservacao = new javax.swing.JButton();
        btnEditarObservacao = new javax.swing.JButton();
        btnNovoObservacao = new javax.swing.JButton();
        btnVoltarMenu = new javax.swing.JButton();
        btnExcluirObservacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Observações");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Escreva suas observações");

        textAreaObservacoes.setColumns(20);
        textAreaObservacoes.setRows(5);
        jScrollPane1.setViewportView(textAreaObservacoes);

        btnSalvarObservacao.setText("Salvar");
        btnSalvarObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarObservacaoActionPerformed(evt);
            }
        });

        btnEditarObservacao.setText("Editar");
        btnEditarObservacao.setMaximumSize(new java.awt.Dimension(69, 25));
        btnEditarObservacao.setMinimumSize(new java.awt.Dimension(69, 25));
        btnEditarObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarObservacaoActionPerformed(evt);
            }
        });

        btnNovoObservacao.setText("Novo");
        btnNovoObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoObservacaoActionPerformed(evt);
            }
        });

        btnVoltarMenu.setText("<< Voltar ");
        btnVoltarMenu.setMaximumSize(new java.awt.Dimension(69, 25));
        btnVoltarMenu.setMinimumSize(new java.awt.Dimension(69, 25));
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });

        btnExcluirObservacao.setText("Excluir");
        btnExcluirObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirObservacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(55, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnNovoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEditarObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnExcluirObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvarObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnExcluirObservacao.getAccessibleContext().setAccessibleName("Excluir");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarObservacaoActionPerformed
        if (controle != null) {
            String textArea = textAreaObservacoes.getText();
            controle.Escreve(textArea, false);
            JOptionPane.showMessageDialog(this,
                    "Observação salva com sucesso",
                    "Salvar observação",
                    JOptionPane.INFORMATION_MESSAGE
            );

            principal = new Principal();
            principal.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Crie uma nova observação antes de salvar os dados",
                    "Salvar observação",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnSalvarObservacaoActionPerformed

    private void btnEditarObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarObservacaoActionPerformed
        File arquivo = getArquivo(0);
        controle = new ControleTexto(arquivo);
        String aux = controle.Le();

        textAreaObservacoes.setText(aux);
        textAreaObservacoes.requestFocus();
    }//GEN-LAST:event_btnEditarObservacaoActionPerformed

    private void btnNovoObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoObservacaoActionPerformed
        File arquivo = getArquivo(1);

        if (arquivo != null) {
            controle = new ControleTexto(arquivo);
            JOptionPane.showMessageDialog(this,
                    "Novo arquivo de cadastro de observações foi criado com sucesso",
                    "Nova observação",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao criar arquivo de cadastro de observações",
                    "Nova observação",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnNovoObservacaoActionPerformed

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void btnExcluirObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirObservacaoActionPerformed
        File arquivo = getArquivo(0);
        controle = new ControleTexto(arquivo);

        arquivo.delete();

        principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExcluirObservacaoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Observacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarObservacao;
    private javax.swing.JButton btnExcluirObservacao;
    private javax.swing.JButton btnNovoObservacao;
    private javax.swing.JButton btnSalvarObservacao;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaObservacoes;
    // End of variables declaration//GEN-END:variables
}
