package view;

import controller.EmprestimoController;
import controller.UsuarioController;
import java.util.List;
import javax.swing.JOptionPane;
import model.EmprestimoModel;
import model.UsuarioModel;

public class EmprestimoView extends javax.swing.JFrame {

    private PrincipalView principal;
    private EmprestimoController empcontroller;
    private boolean habilitaAtualizacao = false;
    private boolean habilitaExclusao = false;
    private String emprestimoID = null;

    public EmprestimoView() {
        initComponents();

        UsuarioController usuarioController = new UsuarioController();
        for (UsuarioModel usuarioModel : usuarioController.listar()) {
            comboBoxUsuarios.addItem(usuarioModel);
        }

    }

    public void voltaPrincipal() {
        principal = new PrincipalView();
        principal.setVisible(true);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonVoltar = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        textFieldItem = new javax.swing.JTextField();
        labelItem = new javax.swing.JLabel();
        labelParaQuem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxUsuarios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonVoltar.setText("<< Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        textFieldItem.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        labelItem.setText("Item Emprestado");

        labelParaQuem.setText("Para Quem");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPRÉSTIMO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelParaQuem)
                            .addComponent(labelItem))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldItem, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(comboBoxUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonEditar, buttonExcluir, buttonSalvar, buttonVoltar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelItem, labelParaQuem});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelItem))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelParaQuem)
                    .addComponent(comboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonEditar, buttonExcluir, buttonSalvar, buttonVoltar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelItem, labelParaQuem});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        voltaPrincipal();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        empcontroller = new EmprestimoController();

        UsuarioModel usuarioModel = (UsuarioModel) comboBoxUsuarios.getSelectedItem();

        boolean resposta = empcontroller.inserir(textFieldItem.getText(), usuarioModel.getUsuarioID());

        if (resposta == true) {
            JOptionPane.showMessageDialog(null, "O empréstimo foi criado com sucesso", "Salvar Empréstimo", JOptionPane.INFORMATION_MESSAGE);
            voltaPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao criar o empréstimo", "Salvar Empréstimo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        empcontroller = new EmprestimoController();
        textFieldItem.setEnabled(false);
        comboBoxUsuarios.setEnabled(false);

        if (habilitaExclusao == false) {
            emprestimoID = JOptionPane.showInputDialog("Entre com o ID do emprestimo a ser excluido: ");
            List<EmprestimoModel> lista = empcontroller.buscarPeloID(Integer.parseInt(emprestimoID));

            if (!lista.isEmpty()) {
                EmprestimoModel retorno = lista.get(0);
                textFieldItem.setText(retorno.getEmprestimoItem());
                comboBoxUsuarios.setSelectedIndex(retorno.getUsuarioID() - 1);
                buttonExcluir.setEnabled(true);
                buttonSalvar.setEnabled(false);
                buttonEditar.setEnabled(false);
                habilitaExclusao = true;
            } else {
                JOptionPane.showMessageDialog(null, "Não existe emprestimo com esse ID", "Excluir Empréstimo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            boolean resposta = empcontroller.excluir(Integer.parseInt(emprestimoID));

            if (resposta == true) {
                JOptionPane.showMessageDialog(null, "O empréstimo foi excluido com sucesso", "Excluir Empréstimo", JOptionPane.INFORMATION_MESSAGE);
                voltaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao excluir o empréstimo", "Excluir Empréstimo", JOptionPane.ERROR_MESSAGE);
            }

            habilitaExclusao = false;
        }

    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        empcontroller = new EmprestimoController();
        textFieldItem.setEnabled(false);
        comboBoxUsuarios.setEnabled(false);

        if (habilitaAtualizacao == false) {
            emprestimoID = JOptionPane.showInputDialog("Entre com o ID do emprestimo a ser buscado: ");
            List<EmprestimoModel> lista = empcontroller.buscarPeloID(Integer.parseInt(emprestimoID));

            if (!lista.isEmpty()) {
                textFieldItem.setEnabled(true);
                comboBoxUsuarios.setEnabled(true);
                buttonSalvar.setEnabled(false);
                buttonExcluir.setEnabled(false);
                EmprestimoModel retorno = lista.get(0);
                textFieldItem.setText(retorno.getEmprestimoItem());
                comboBoxUsuarios.setSelectedIndex(retorno.getUsuarioID() - 1);
                habilitaAtualizacao = true;
                buttonEditar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Não existe emprestimo com esse ID", "Editar Empréstimo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            UsuarioModel usuarioModel = (UsuarioModel) comboBoxUsuarios.getSelectedItem();
            boolean resposta = empcontroller.editar(textFieldItem.getText(), usuarioModel.getUsuarioID(), Integer.parseInt(emprestimoID));

            if (resposta == true) {
                JOptionPane.showMessageDialog(null, "O empréstimo foi editado com sucesso", "Editar Empréstimo", JOptionPane.INFORMATION_MESSAGE);
                voltaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao editar o empréstimo", "Editar Empréstimo", JOptionPane.ERROR_MESSAGE);
            }

            habilitaAtualizacao = false;
        }

    }//GEN-LAST:event_buttonEditarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmprestimoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JComboBox<Object> comboBoxUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelParaQuem;
    private javax.swing.JTextField textFieldItem;
    // End of variables declaration//GEN-END:variables
}
