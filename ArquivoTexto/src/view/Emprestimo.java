package view;

import controller.ControleTexto;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static view.Principal.getArquivo;

public class Emprestimo extends javax.swing.JFrame {

    private ControleTexto controle;
    private Principal principal;

    public Emprestimo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textfieldItem = new javax.swing.JTextField();
        textfieldParaQuem = new javax.swing.JTextField();
        textfieldData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvarEmprestimo = new javax.swing.JButton();
        btnAbrirEmprestimo = new javax.swing.JButton();
        btnNovoEmprestimo = new javax.swing.JButton();
        btnVoltarMenu = new javax.swing.JButton();
        btnExcluirEmprestimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emprestimo");

        jLabel1.setText("Item Emprestado");

        jLabel2.setText("Para quem");

        jLabel3.setText("Data");

        btnSalvarEmprestimo.setText("Salvar");
        btnSalvarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEmprestimoActionPerformed(evt);
            }
        });

        btnAbrirEmprestimo.setText("Editar");
        btnAbrirEmprestimo.setMaximumSize(new java.awt.Dimension(69, 25));
        btnAbrirEmprestimo.setMinimumSize(new java.awt.Dimension(69, 25));
        btnAbrirEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirEmprestimoActionPerformed(evt);
            }
        });

        btnNovoEmprestimo.setText("Novo");
        btnNovoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoEmprestimoActionPerformed(evt);
            }
        });

        btnVoltarMenu.setText("<< Voltar");
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });

        btnExcluirEmprestimo.setText("Excluir");
        btnExcluirEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEmprestimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnAbrirEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnExcluirEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textfieldItem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldParaQuem, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltarMenu)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textfieldParaQuem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textfieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrirEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(btnVoltarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEmprestimoActionPerformed
        if (controle != null) {
            String item = textfieldItem.getText();
            String paraQuem = textfieldParaQuem.getText();
            String data = textfieldData.getText();

            controle.Escreve(item, false);
            controle.Escreve(paraQuem, true);
            controle.Escreve(data, true);

            JOptionPane.showMessageDialog(this,
                    "Emprestimo salvo com sucesso",
                    "Salvar emprestimo",
                    JOptionPane.INFORMATION_MESSAGE
            );

            principal = new Principal();
            principal.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Crie um novo empréstimo antes de salvar os dados",
                    "Salvar emprestimo",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }//GEN-LAST:event_btnSalvarEmprestimoActionPerformed

    private void btnAbrirEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirEmprestimoActionPerformed
        File arquivo = getArquivo(0);
        controle = new ControleTexto(arquivo);
        ArrayList<String> vetorLerArquivo = controle.LeTextInput();

        textfieldItem.setText(vetorLerArquivo.get(0));
        textfieldParaQuem.setText(vetorLerArquivo.get(1));
        textfieldData.setText(vetorLerArquivo.get(2));

        textfieldItem.requestFocus();
    }//GEN-LAST:event_btnAbrirEmprestimoActionPerformed

    private void btnNovoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoEmprestimoActionPerformed
        File arquivo = getArquivo(1);

        if (arquivo != null) {
            controle = new ControleTexto(arquivo);
            JOptionPane.showMessageDialog(this,
                    "Novo arquivo para cadastrar emprestimo foi criado com sucesso",
                    "Novo emprestimo",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(this,
                    "Erro ao criar arquivo de cadastro de emprestimo",
                    "Novo emprestimo",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_btnNovoEmprestimoActionPerformed

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void btnExcluirEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEmprestimoActionPerformed
        File arquivo = getArquivo(0);
        controle = new ControleTexto(arquivo);

        arquivo.delete();

        principal = new Principal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExcluirEmprestimoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Emprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirEmprestimo;
    private javax.swing.JButton btnExcluirEmprestimo;
    private javax.swing.JButton btnNovoEmprestimo;
    private javax.swing.JButton btnSalvarEmprestimo;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textfieldData;
    private javax.swing.JTextField textfieldItem;
    private javax.swing.JTextField textfieldParaQuem;
    // End of variables declaration//GEN-END:variables
}
