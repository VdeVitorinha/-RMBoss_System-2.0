/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


import javax.swing.JOptionPane;

/**
 *
 * @author aless
 */
public class Tprojetos extends javax.swing.JInternalFrame {

    Connection conexao=null;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    public Tprojetos() {
        initComponents();
        conexao = ModuloConexao.conector();

    }
    
    private void buscarClient(){
            String sql = "select * from clientes where cpfcnpj=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCpfCnpjP.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    txtCpfCnpjP.setText(rs.getString(1)); 
                    txtNomeP.setText(rs.getString(2)); 
                    txtContatoP.setText(rs.getString(3));
                    txtPrazo.setText(rs.getString(4));
                    txtEmailP.setText(rs.getString(5));
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Cliente não cadastrado :(");
                    //as linhas abaixo limpa os campos
                    txtCpfCnpjP.setText(null);
                    txtNomeP.setText(null);
                    txtContatoP.setText(null);
                    txtPrazo.setText(null);
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    private void buscarPedi(){
            String sql = "select * from pedidos where idpedidos=?";
            try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtAtend.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                txtAtend.setText(rs.getString(1));
                txtPrazo.setText(rs.getString(4));
                txtDescricao.setText(rs.getString(5));
                BoxFase.setSelectedItem(rs.getString(6));
                txtCpfCnpjP.setText(rs.getString(10));
                }else{
                    JOptionPane.showMessageDialog(null,"Pedido não encontrado :(");

                    txtDescricao.setText(null);
                    BoxFase.setSelectedItem(null);
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    
    //metodo para editar a coluna metro antes de usar o metodo de subtracao
    private void editarMetro(){
        String sql = "update estoque set metro=? where produto=?";
         try{
             pst=conexao.prepareStatement(sql);
             
             pst.setString(1,txtnum.getText());
             pst.setString(2,txtdiminuir.getText());
             
             int somatoria = pst.executeUpdate();
             
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            }   
    }
    
    private void subtracao(){
        
        String sql = "update estoque set disponabilidade = disponabilidade - metro where produto=?";
        
        try{
            pst=conexao.prepareStatement(sql);
            
            pst.setString(1, txtdiminuir.getText());
            
            
            int subtracao = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Informações alretadas com sucesso!! ;)");
            
            txtnum.setText(null);
            txtdiminuir.setText(null);
            
            }catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);      
                    }
    }
    
    private void editafade(){
        
        String sql = "update pedidos set statusped=?,complementoped=? where idpedidos=?";
        try{
            pst=conexao.prepareStatement(sql);
            pst.setString(1,BoxFase.getSelectedItem().toString());
            pst.setString(2,txtDescricao.getText());
            pst.setString(3,txtAtend.getText());
            
            int editar = pst.executeUpdate();
            
        }catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);  
        }
    }
    
    private void limpartela(){
        txtAtend.setText(null);
        txtNomeP.setText(null);
        txtCpfCnpjP.setText(null);
        txtPrazo.setText(null);
        txtContatoP.setText(null);
        txtEmailP.setText(null);
        txtDescricao.setText(null);
        BoxFase.setSelectedItem(null);
        txtdiminuir.setText(null);
        txtnum.setText(null);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        txtAtend = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        BoxFase = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtdiminuir = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        txtale = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtNomeP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpfCnpjP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtContatoP = new javax.swing.JTextField();
        txtPrazo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmailP = new javax.swing.JFormattedTextField();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(236, 92, 92));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Cod. Pedido");

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/magnifier.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtAtend.setBackground(new java.awt.Color(0, 0, 0));
        txtAtend.setForeground(new java.awt.Color(255, 255, 255));
        txtAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtAtend)
                .addGap(3, 3, 3)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Fase de Atendimento");

        BoxFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "PEDIDO COLETADO", "EM PREPARAÇÃO", "PRONTO PARA ENTREGA", "ENTREGA", " " }));
        BoxFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BoxFase, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(BoxFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Subtração");

        txtnum.setBackground(new java.awt.Color(0, 0, 0));
        txtnum.setForeground(new java.awt.Color(255, 255, 255));
        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnum)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Material");

        txtdiminuir.setBackground(new java.awt.Color(0, 0, 0));
        txtdiminuir.setForeground(new java.awt.Color(255, 255, 255));
        txtdiminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiminuirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiminuir)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtdiminuir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Salvar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtale.setBackground(new java.awt.Color(0, 0, 0));
        txtale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtale.setForeground(new java.awt.Color(255, 255, 255));
        txtale.setText("Limpar");
        txtale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtale, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtale, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(26, 66, 305, 598);

        jPanel4.setBackground(new java.awt.Color(236, 92, 92));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Projetos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(-21, 10, 220, 34);

        txtDescricao.setBackground(new java.awt.Color(0, 0, 0));
        txtDescricao.setColumns(20);
        txtDescricao.setForeground(new java.awt.Color(255, 255, 255));
        txtDescricao.setRows(5);
        txtDescricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setViewportView(txtDescricao);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(380, 140, 370, 250);

        jPanel7.setBackground(new java.awt.Color(236, 92, 92));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Observações do pedido");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(103, 103, 103))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(380, 120, 370, 270);

        txtNomeP.setBackground(new java.awt.Color(0, 0, 0));
        txtNomeP.setForeground(new java.awt.Color(255, 255, 255));
        txtNomeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePActionPerformed(evt);
            }
        });
        jPanel1.add(txtNomeP);
        txtNomeP.setBounds(390, 30, 140, 22);

        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(390, 10, 140, 16);

        txtCpfCnpjP.setBackground(new java.awt.Color(0, 0, 0));
        txtCpfCnpjP.setForeground(new java.awt.Color(255, 255, 255));
        txtCpfCnpjP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfCnpjPActionPerformed(evt);
            }
        });
        jPanel1.add(txtCpfCnpjP);
        txtCpfCnpjP.setBounds(540, 30, 120, 22);

        jLabel3.setText("CPF/CNPJ:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(540, 10, 100, 16);

        jLabel4.setText("Contato:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 60, 110, 16);

        txtContatoP.setBackground(new java.awt.Color(0, 0, 0));
        txtContatoP.setForeground(new java.awt.Color(255, 255, 255));
        txtContatoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContatoPActionPerformed(evt);
            }
        });
        jPanel1.add(txtContatoP);
        txtContatoP.setBounds(390, 80, 120, 22);

        txtPrazo.setBackground(new java.awt.Color(0, 0, 0));
        txtPrazo.setForeground(new java.awt.Color(255, 255, 255));
        txtPrazo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 92, 92), 4));
        txtPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrazoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrazo);
        txtPrazo.setBounds(670, 30, 80, 24);

        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(520, 60, 180, 16);

        jLabel18.setText("Prazo:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(670, 10, 60, 16);

        txtEmailP.setBackground(new java.awt.Color(0, 0, 0));
        txtEmailP.setForeground(new java.awt.Color(255, 255, 255));
        txtEmailP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailPActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmailP);
        txtEmailP.setBounds(520, 80, 200, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtendActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        buscarPedi();
        buscarClient();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BoxFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxFaseActionPerformed

    private void txtNomePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePActionPerformed

    private void txtCpfCnpjPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCnpjPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCnpjPActionPerformed

    private void txtContatoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContatoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContatoPActionPerformed

    private void txtPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrazoActionPerformed

    private void txtEmailPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailPActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void txtdiminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiminuirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiminuirActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        editarMetro();
        subtracao();
        editafade();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaleActionPerformed
        // TODO add your handling code here:
        limpartela();
    }//GEN-LAST:event_txtaleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxFase;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField txtAtend;
    private javax.swing.JTextField txtContatoP;
    private javax.swing.JTextField txtCpfCnpjP;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JFormattedTextField txtEmailP;
    private javax.swing.JTextField txtNomeP;
    private javax.swing.JTextField txtPrazo;
    private javax.swing.JButton txtale;
    private javax.swing.JTextField txtdiminuir;
    private javax.swing.JTextField txtnum;
    // End of variables declaration//GEN-END:variables
}
