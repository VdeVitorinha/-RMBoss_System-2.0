/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import java.sql.*;
import Conexao.ModuloConexao;
import javax.swing.JOptionPane;

public class TcadMaterial extends javax.swing.JInternalFrame {

    Connection conexao=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    public TcadMaterial() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void buscar(){
        String sql = "select * from estoque where produto=?";
                try {
                   pst = conexao.prepareStatement(sql);
                   pst.setString(1, txtmaterial.getText());
                   rs=pst.executeQuery();
                   if(rs.next()){
                       txtmaterial.setText(rs.getString(2));
                       txtmetro.setText(rs.getString(3));
                       txtcategoria.setText(rs.getString(4));
                       txtpreco.setText(rs.getString(5));
                       txtdate.setText(rs.getString(6));
                       txtdisp.setText(rs.getString(7));
                         
                               
                   }else{
                       JOptionPane.showMessageDialog(null,"Materail não cadastrado :(");
                       txtmaterial.setText(null);
                   }
                  } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e); 
                }
    }
    //Não esta rodando essa etapa... OBS: ver depois
    private void editar(){  
        String sql = "update estoque set metro=?,categoria=?,preco=?,datainicio=?,disponabilidade=? where produto=?";
        try {
            pst=conexao.prepareStatement(sql);

            pst.setString(1,txtmetro.getText());
            pst.setString(2,txtcategoria.getText());
            pst.setString(3,txtpreco.getText());
            pst.setString(4,txtdate.getText());
            pst.setString(5,txtdisp.getText());
            pst.setString(6,txtmaterial.getText());
            
            
            int editar = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "material adicionado com sucesso ;)");
                txtmaterial.setText(null);
                txtcategoria.setText(null);
                txtmetro.setText(null);
                txtdisp.setText(null);
                txtdate.setText(null);
                txtpreco.setText(null);
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }
        
    }
    
    private void limpaTela(){
        txtmaterial.setText(null);
        txtmetro.setText(null);
        txtcategoria.setText(null);
        txtpreco.setText(null);
        txtdate.setText(null);
        txtdisp.setText(null);
    }
    

    
    
    
    
            //Connection con = conexao = ModuloConexao.conector();
            //String sql = "select sum(disponabilidade) from metro";
             
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtmaterial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        txtmetro = new javax.swing.JTextField();
        txtcategoria = new javax.swing.JTextField();
        txtpreco = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtnsalvarEdiatr1 = new javax.swing.JButton();
        txtdisp = new java.awt.Label();

        setBackground(new java.awt.Color(254, 236, 236));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(254, 236, 236));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(236, 92, 92));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(null);

        txtmaterial.setBackground(new java.awt.Color(0, 0, 0));
        txtmaterial.setForeground(new java.awt.Color(255, 255, 255));
        txtmaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaterialActionPerformed(evt);
            }
        });
        jPanel4.add(txtmaterial);
        txtmaterial.setBounds(27, 28, 180, 22);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Material:");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(27, 6, 49, 16);

        BtnBuscar.setBackground(new java.awt.Color(0, 0, 0));
        BtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/magnifier.png"))); // NOI18N
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(BtnBuscar);
        BtnBuscar.setBounds(210, 28, 30, 22);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 100, 250, 60);

        txtmetro.setBackground(new java.awt.Color(0, 0, 0));
        txtmetro.setForeground(new java.awt.Color(255, 255, 255));
        txtmetro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtmetro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmetroActionPerformed(evt);
            }
        });
        jPanel1.add(txtmetro);
        txtmetro.setBounds(30, 190, 180, 30);

        txtcategoria.setBackground(new java.awt.Color(0, 0, 0));
        txtcategoria.setForeground(new java.awt.Color(255, 255, 255));
        txtcategoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(txtcategoria);
        txtcategoria.setBounds(260, 120, 180, 30);

        txtpreco.setBackground(new java.awt.Color(0, 0, 0));
        txtpreco.setForeground(new java.awt.Color(255, 255, 255));
        txtpreco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(txtpreco);
        txtpreco.setBounds(260, 250, 180, 30);

        txtdate.setBackground(new java.awt.Color(0, 0, 0));
        txtdate.setForeground(new java.awt.Color(255, 255, 255));
        txtdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(txtdate);
        txtdate.setBounds(30, 250, 180, 30);

        jButton3.setBackground(new java.awt.Color(236, 92, 92));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Limpar");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(370, 60, 70, 20);

        jPanel3.setBackground(new java.awt.Color(236, 92, 92));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Adição de Material");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 30, 191, 34);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Metro:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 170, 50, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Categoria:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 100, 70, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Preço:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(260, 230, 37, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Disponivel:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(260, 170, 90, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Data de Entrada:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 230, 100, 16);

        BtnsalvarEdiatr1.setBackground(new java.awt.Color(236, 92, 92));
        BtnsalvarEdiatr1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnsalvarEdiatr1.setText("Adicionar");
        BtnsalvarEdiatr1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        BtnsalvarEdiatr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnsalvarEdiatr1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnsalvarEdiatr1);
        BtnsalvarEdiatr1.setBounds(260, 60, 90, 20);

        txtdisp.setBackground(new java.awt.Color(0, 0, 0));
        txtdisp.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtdisp);
        txtdisp.setBounds(260, 190, 180, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
          buscar();
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpaTela();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtmetroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmetroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmetroActionPerformed

    private void txtmaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaterialActionPerformed

    private void BtnsalvarEdiatr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnsalvarEdiatr1ActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnsalvarEdiatr1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnsalvarEdiatr1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtdate;
    private java.awt.Label txtdisp;
    private javax.swing.JTextField txtmaterial;
    private javax.swing.JTextField txtmetro;
    private javax.swing.JTextField txtpreco;
    // End of variables declaration//GEN-END:variables
}
