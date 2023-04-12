package view;

import report.Relatorio;

public class PrincipalView extends javax.swing.JFrame {

    private UsuarioNovoView usuarioNovo;
    private UsuarioEditarView usuarioEditar;
    private UsuarioExcluirView usuario;
    private EmprestimoView emprestimo;
    private ObservacaoView observacao;
    private Relatorio relatorio;

    public PrincipalView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonEmprestimos = new javax.swing.JButton();
        buttonObservacoes = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRelatorios = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        menuItemNovoUsuario = new javax.swing.JMenuItem();
        menuItemEditarUsuario = new javax.swing.JMenuItem();
        menuItemExcluirUsuario = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonEmprestimos.setText("Emprestimos");
        buttonEmprestimos.setFocusPainted(false);
        buttonEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmprestimosActionPerformed(evt);
            }
        });

        buttonObservacoes.setText("Observações");
        buttonObservacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonObservacoesActionPerformed(evt);
            }
        });

        buttonSair.setForeground(java.awt.Color.red);
        buttonSair.setText("Sair do sistema");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciador de Emprestimos");

        btnRelatorios.setText("Relatórios");
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });

        menuUsuario.setText("Usuário");

        menuItemNovoUsuario.setText("Novo usuário");
        menuItemNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNovoUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemNovoUsuario);

        menuItemEditarUsuario.setText("Editar usuário");
        menuItemEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemEditarUsuario);

        menuItemExcluirUsuario.setText("Excluir usuário");
        menuItemExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExcluirUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemExcluirUsuario);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(buttonObservacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonEmprestimos, buttonObservacoes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEmprestimos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonObservacoes)
                    .addComponent(btnRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonEmprestimos, buttonObservacoes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmprestimosActionPerformed
        emprestimo = new EmprestimoView();
        emprestimo.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonEmprestimosActionPerformed

    private void menuItemExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExcluirUsuarioActionPerformed
        usuario = new UsuarioExcluirView();
        usuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemExcluirUsuarioActionPerformed

    private void menuItemNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNovoUsuarioActionPerformed
        usuarioNovo = new UsuarioNovoView();
        usuarioNovo.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemNovoUsuarioActionPerformed

    private void menuItemEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarUsuarioActionPerformed
        usuarioEditar = new UsuarioEditarView();
        usuarioEditar.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemEditarUsuarioActionPerformed

    private void buttonObservacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonObservacoesActionPerformed
        observacao = new ObservacaoView();
        observacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonObservacoesActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonSairActionPerformed

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        relatorio = new Relatorio();
        relatorio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRelatoriosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton buttonEmprestimos;
    private javax.swing.JButton buttonObservacoes;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemEditarUsuario;
    private javax.swing.JMenuItem menuItemExcluirUsuario;
    private javax.swing.JMenuItem menuItemNovoUsuario;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
