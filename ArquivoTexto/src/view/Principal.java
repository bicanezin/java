package view;

import controller.ControleTexto;
import java.io.File;
import javax.swing.JFileChooser;

public class Principal extends javax.swing.JFrame {

    private ControleTexto controle;
    private Observacoes observacoes;
    private Usuario usuario;
    private UsuarioEditar usuarioE;
    private UsuarioNovo usuarioN;
    private Emprestimo emprestimo;

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTelaEmprestimo = new javax.swing.JButton();
        btnTelaObservacao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUsuario = new javax.swing.JMenu();
        menuItemNovo = new javax.swing.JMenuItem();
        menuItemEditar = new javax.swing.JMenuItem();
        menuItemTrocar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        btnTelaEmprestimo.setText("Emprestimos");
        btnTelaEmprestimo.setFocusPainted(false);
        btnTelaEmprestimo.setFocusable(false);
        btnTelaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaEmprestimoActionPerformed(evt);
            }
        });

        btnTelaObservacao.setText("Observações");
        btnTelaObservacao.setToolTipText("");
        btnTelaObservacao.setFocusable(false);
        btnTelaObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaObservacaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerenciador de Emprestimos");

        btnSair.setForeground(new java.awt.Color(255, 51, 51));
        btnSair.setText("Sair do Sistema");
        btnSair.setToolTipText("");
        btnSair.setFocusable(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        menuUsuario.setText("Usuário");

        menuItemNovo.setText("Novo usuário");
        menuItemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNovoActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemNovo);

        menuItemEditar.setText("Editar perfil");
        menuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemEditar);

        menuItemTrocar.setText("Trocar de usuário");
        menuItemTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTrocarActionPerformed(evt);
            }
        });
        menuUsuario.add(menuItemTrocar);

        jMenuBar1.add(menuUsuario);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnTelaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(btnTelaObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTelaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTelaObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)))
                .addGap(79, 79, 79)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTelaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaEmprestimoActionPerformed
        emprestimo = new Emprestimo();
        emprestimo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTelaEmprestimoActionPerformed

    private void btnTelaObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaObservacaoActionPerformed
        observacoes = new Observacoes();
        observacoes.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTelaObservacaoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void menuItemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNovoActionPerformed
        usuarioN = new UsuarioNovo();
        usuarioN.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemNovoActionPerformed

    private void menuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarActionPerformed
        usuarioE = new UsuarioEditar();
        usuarioE.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemEditarActionPerformed

    private void menuItemTrocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTrocarActionPerformed
        usuario = new Usuario();
        usuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuItemTrocarActionPerformed

    public static File getArquivo(int opcao) {
        File arquivo = null;
        String pastainicial = System.getProperty("user.dir");
        System.out.println(System.getProperties());
        JFileChooser chooser = new JFileChooser(pastainicial);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resposta = -1;

        if (opcao == 0) {
            resposta = chooser.showOpenDialog(chooser);
        } else {
            resposta = chooser.showSaveDialog(chooser);
        }

        if (resposta == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();

            System.out.println("O Arquivo selecionado foi: "
                    + arquivo.getAbsolutePath()
            );
        }

        return arquivo;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTelaEmprestimo;
    private javax.swing.JButton btnTelaObservacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuItemEditar;
    private javax.swing.JMenuItem menuItemNovo;
    private javax.swing.JMenuItem menuItemTrocar;
    private javax.swing.JMenu menuUsuario;
    // End of variables declaration//GEN-END:variables
}
