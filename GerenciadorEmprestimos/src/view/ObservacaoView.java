package view;

import controller.ObservacaoController;
import controller.EmprestimoController;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObservacaoModel;
import model.EmprestimoModel;

public class ObservacaoView extends javax.swing.JFrame {

    private PrincipalView principal;
    private ObservacaoController obscontroller;
    private boolean habilitaAtualizacao = false;
    private boolean habilitaExclusao = false;
    private String observacaoID = null;

    public ObservacaoView() {
        initComponents();

        EmprestimoController emprestimoController = new EmprestimoController();
        for (EmprestimoModel emprestimoModel : emprestimoController.listar()) {
            comboboxItensEmprestados.addItem(emprestimoModel);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareaDescricao = new javax.swing.JTextArea();
        buttonVoltar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboboxItensEmprestados = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OBSERVAÇÃO");

        textareaDescricao.setColumns(20);
        textareaDescricao.setRows(5);
        jScrollPane1.setViewportView(textareaDescricao);

        buttonVoltar.setText("<< Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
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

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição");

        jLabel3.setText("Item Emprestado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(150, 150, 150)
                            .addComponent(buttonEditar)
                            .addGap(18, 18, 18)
                            .addComponent(buttonExcluir)
                            .addGap(18, 18, 18)
                            .addComponent(buttonSalvar))
                        .addComponent(jScrollPane1)
                        .addComponent(comboboxItensEmprestados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonEditar, buttonExcluir, buttonSalvar, buttonVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxItensEmprestados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEditar)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonSalvar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonEditar, buttonExcluir, buttonSalvar, buttonVoltar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        voltaPrincipal();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        obscontroller = new ObservacaoController();
        textareaDescricao.setEnabled(false);
        comboboxItensEmprestados.setEnabled(false);

        if (habilitaAtualizacao == false) {
            observacaoID = JOptionPane.showInputDialog("Entre com o ID da observação a ser editado: ");
            List<ObservacaoModel> lista = obscontroller.buscarPeloID(Integer.parseInt(observacaoID));

            if (!lista.isEmpty()) {
                buttonSalvar.setEnabled(false);
                buttonExcluir.setEnabled(false);
                ObservacaoModel retorno = lista.get(0);
                textareaDescricao.setText(retorno.getObservacaoDescricao());
                comboboxItensEmprestados.setSelectedIndex(retorno.getEmprestimoID() - 1);
                textareaDescricao.setEnabled(true);
                comboboxItensEmprestados.setEnabled(true);
                habilitaAtualizacao = true;
            } else {
                JOptionPane.showMessageDialog(null, "Não existe observação com esse ID", "Editar Observação", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            EmprestimoModel emprestimoModel = (EmprestimoModel) comboboxItensEmprestados.getSelectedItem();
            boolean resposta = obscontroller.editar(textareaDescricao.getText(), emprestimoModel.getEmprestimoID(), Integer.parseInt(observacaoID));

            if (resposta == true) {
                JOptionPane.showMessageDialog(null, "A observação foi editada com sucesso", "Editar Observação", JOptionPane.INFORMATION_MESSAGE);
                voltaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao editar a observação", "Editar Observação", JOptionPane.ERROR_MESSAGE);
            }

            habilitaAtualizacao = false;
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        obscontroller = new ObservacaoController();
        textareaDescricao.setEnabled(false);
        comboboxItensEmprestados.setEnabled(false);

        if (habilitaExclusao == false) {
            observacaoID = JOptionPane.showInputDialog("Entre com o ID da observação a ser excluido: ");
            List<ObservacaoModel> lista = obscontroller.buscarPeloID(Integer.parseInt(observacaoID));

            if (!lista.isEmpty()) {
                buttonEditar.setEnabled(false);
                buttonSalvar.setEnabled(false);
                ObservacaoModel retorno = lista.get(0);
                textareaDescricao.setText(retorno.getObservacaoDescricao());
                comboboxItensEmprestados.setSelectedIndex(retorno.getEmprestimoID() - 1);
                habilitaExclusao = true;
            } else {
                JOptionPane.showMessageDialog(null, "Não existe observação com esse ID", "Excluir Observação", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            boolean resposta = obscontroller.excluir(Integer.parseInt(observacaoID));

            if (resposta == true) {
                JOptionPane.showMessageDialog(null, "A observação foi excluida com sucesso", "Excluir Observação", JOptionPane.INFORMATION_MESSAGE);
                voltaPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao excluir a observação", "Excluir Observação", JOptionPane.ERROR_MESSAGE);
            }

            habilitaExclusao = false;
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        obscontroller = new ObservacaoController();

        EmprestimoModel emprestimoModel = (EmprestimoModel) comboboxItensEmprestados.getSelectedItem();

        boolean resposta = obscontroller.inserir(textareaDescricao.getText(), emprestimoModel.getEmprestimoID());

        if (resposta == true) {
            JOptionPane.showMessageDialog(null, "A observação foi criada com sucesso", "Salvar Observação", JOptionPane.INFORMATION_MESSAGE);
            voltaPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha ao criar a observação", "Salvar Observação", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObservacaoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JComboBox<Object> comboboxItensEmprestados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textareaDescricao;
    // End of variables declaration//GEN-END:variables
}
