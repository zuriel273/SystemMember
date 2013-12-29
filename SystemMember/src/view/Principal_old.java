/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Dados.MembroDAO;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import negocio.Membro; 

/**
 *
 * @author massilva
 */
public class Principal_old extends javax.swing.JFrame {
    
    private String msg_busca = "Digite o telefone do cliente";
    private Color bgcolor;
    DefaultTableModel modelo;
    /**
     * Creates new form Principal
     */
    public Principal_old() {
        initComponents();
        jT_busca.setText(msg_busca);
        float [] hsb = new float[3];
        Color.RGBtoHSB(242,241,240,hsb);
        this.bgcolor = Color.getHSBColor(hsb[0],hsb[1],hsb[2]);
        jDesktopPane1.setBackground(this.bgcolor);
        try {        
        
            atualizarLista("");
        } catch (Exception ex) {
            Logger.getLogger(Principal_old.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jL_titulo = new javax.swing.JLabel();
        jB_add_membro = new javax.swing.JButton();
        jB_listar_disciplinados = new javax.swing.JButton();
        jB_disciplina = new javax.swing.JButton();
        jB_fechar = new javax.swing.JButton();
        jB_buscar = new javax.swing.JButton();
        jT_busca = new javax.swing.JTextField();
        jS_lista = new javax.swing.JScrollPane();
        jT_lista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Galeteria");
        setName("frame"); // NOI18N
        setResizable(false);

        jL_titulo.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jL_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_titulo.setText("Gerenciamento de Membros");
        jL_titulo.setBounds(0, 0, 800, 80);
        jDesktopPane1.add(jL_titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_add_membro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/+.png"))); // NOI18N
        jB_add_membro.setMnemonic('C');
        jB_add_membro.setText("Novo Membro");
        jB_add_membro.setToolTipText("Novo Cliente");
        jB_add_membro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_add_membroActionPerformed(evt);
            }
        });
        jB_add_membro.setBounds(20, 140, 160, 80);
        jDesktopPane1.add(jB_add_membro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_listar_disciplinados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/clientes.png"))); // NOI18N
        jB_listar_disciplinados.setMnemonic('l');
        jB_listar_disciplinados.setText("Membros Em Disciplina");
        jB_listar_disciplinados.setToolTipText("Listar Clientes");
        jB_listar_disciplinados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_listar_disciplinadosActionPerformed(evt);
            }
        });
        jB_listar_disciplinados.setBounds(20, 230, 160, 80);
        jDesktopPane1.add(jB_listar_disciplinados, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_disciplina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/cart_add.png"))); // NOI18N
        jB_disciplina.setMnemonic('n');
        jB_disciplina.setText("Disciplina");
        jB_disciplina.setToolTipText("Novo Pedido");
        jB_disciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_disciplinaActionPerformed(evt);
            }
        });
        jB_disciplina.setBounds(20, 320, 160, 80);
        jDesktopPane1.add(jB_disciplina, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_fechar.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jB_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/exit.png"))); // NOI18N
        jB_fechar.setMnemonic('f');
        jB_fechar.setText("Fechar");
        jB_fechar.setToolTipText("Fechar Programa");
        jB_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_fecharActionPerformed(evt);
            }
        });
        jB_fechar.setBounds(20, 500, 160, 80);
        jDesktopPane1.add(jB_fechar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jB_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/imagem/find.png"))); // NOI18N
        jB_buscar.setMnemonic('b');
        jB_buscar.setText("Buscar");
        jB_buscar.setBounds(660, 90, 120, 40);
        jDesktopPane1.add(jB_buscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jT_busca.setForeground(new java.awt.Color(187, 187, 187));
        jT_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_buscaActionPerformed(evt);
            }
        });
        jT_busca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jT_buscaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jT_buscaFocusLost(evt);
            }
        });
        jT_busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_buscaKeyReleased(evt);
            }
        });
        jT_busca.setBounds(20, 90, 630, 40);
        jDesktopPane1.add(jT_busca, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jT_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jS_lista.setViewportView(jT_lista);

        jS_lista.setBounds(200, 140, 580, 360);
        jDesktopPane1.add(jS_lista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void atualizarLista(String nome) throws Exception{
        
        this.setAlwaysOnTop(false);
        
        String [] colunas = new String []{"Id","Nome","Telefone","Endereco"};
        modelo = new DefaultTableModel(null, colunas){
            
        @Override
        public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        
         MembroDAO f = new MembroDAO();
         List listar = f.listaMembro(nome);
        if(listar.isEmpty()){
            jB_disciplina.setEnabled(false);
            //jB_excluir.setVisible(false);
            
        }
        
        Iterator it = listar.iterator();
        while(it.hasNext()){
            Membro l = (Membro)it.next();
            modelo.addRow(new Object[]{l.getId(),l.getNome(),l.getTelefone(),l.getCongregacao()});
        }
        
        jT_lista.setModel(modelo);
        jT_lista.setShowHorizontalLines(false);
        jT_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jT_lista.getColumnModel().getColumn(0).setPreferredWidth(80);   
        jT_lista.getColumnModel().getColumn(1).setPreferredWidth(120);  
    }
    
    private void jT_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_buscaActionPerformed
        
    }//GEN-LAST:event_jT_buscaActionPerformed

    private void jB_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_fecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jB_fecharActionPerformed

    private void jT_buscaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_buscaFocusGained
        if(jT_busca.getText().equals(msg_busca)){
            jT_busca.setText("");
            jT_busca.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jT_buscaFocusGained

    private void jT_buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_buscaKeyReleased
        if(!jT_busca.getText().isEmpty()){
            jT_busca.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jT_buscaKeyReleased

    private void jT_buscaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jT_buscaFocusLost
        if(jT_busca.getText().isEmpty())
        {
            jT_busca.setForeground(Color.gray);
            jT_busca.setText(msg_busca);
        }
    }//GEN-LAST:event_jT_buscaFocusLost

    private void jB_add_membroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_add_membroActionPerformed
        new CadastroMembro().setVisible(true);
    }//GEN-LAST:event_jB_add_membroActionPerformed

    private void jB_listar_disciplinadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_listar_disciplinadosActionPerformed
       // new ListarCliente(bgcolor).setVisible(true);
    }//GEN-LAST:event_jB_listar_disciplinadosActionPerformed

    private void jB_disciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_disciplinaActionPerformed
       // new CadastroDisciplina(bgcolor).setVisible(true);
    }//GEN-LAST:event_jB_disciplinaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_add_membro;
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jB_disciplina;
    private javax.swing.JButton jB_fechar;
    private javax.swing.JButton jB_listar_disciplinados;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jL_titulo;
    private javax.swing.JScrollPane jS_lista;
    private javax.swing.JTextField jT_busca;
    private javax.swing.JTable jT_lista;
    // End of variables declaration//GEN-END:variables
}