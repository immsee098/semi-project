/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import semi.project.com.Login.LoginService;
import semi.project.com.cart.CartDTO;
import semi.project.com.Main.MainDAO;
import semi.project.com.Main.MainDTO;
import semi.project.com.MyPage.MyPageDAO;
import semi.project.com.MyPage.MyPageDTO;
import semi.project.com.product.ProductDTO;

/**
 *
 * @author EZEN
 */
public class MainGUI extends javax.swing.JFrame implements ActionListener{
    private LoginService ls;
    private MainDAO maindao;
    private DefaultTableModel model=new DefaultTableModel();
    private String[] colNames = {"제품이름", "가격"};
    /**
     * Creates new form Main
     */
    public MainGUI() {

        maindao = new MainDAO();
        initComponents();
        init();
        addEvent();
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
        btJoin = new javax.swing.JButton();
        btSign = new javax.swing.JButton();
        btCart = new javax.swing.JButton();
        btMypage = new javax.swing.JButton();
        lbEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btAdmin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        tfPdName = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        btIncart = new javax.swing.JButton();
        lbQty = new javax.swing.JLabel();
        btPlus = new javax.swing.JButton();
        btMinus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btJoin.setText("회원가입");
        btJoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJoinActionPerformed(evt);
            }
        });

        btSign.setText("로그인");
        btSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignActionPerformed(evt);
            }
        });

        btCart.setForeground(new java.awt.Color(0, 153, 153));
        btCart.setText("장바구니");
        btCart.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btMypage.setForeground(new java.awt.Color(0, 153, 153));
        btMypage.setText("마이페이지");
        btMypage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbEmail.setText("비회원");

        jLabel6.setText("님 안녕하세요!");

        btAdmin.setText("관리자(임시)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btCart, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btMypage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addComponent(btJoin)
                .addGap(18, 18, 18)
                .addComponent(btSign)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btMypage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAdmin))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btJoin)
                                .addComponent(btSign))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbEmail)
                                .addComponent(jLabel6)))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OOO 마켓");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "제품이름", "가격"
            }
        ));
        jScrollPane1.setViewportView(table1);

        lbImg.setBackground(new java.awt.Color(204, 204, 255));
        lbImg.setForeground(new java.awt.Color(153, 0, 255));
        lbImg.setBorder(javax.swing.BorderFactory.createTitledBorder("상품 이미지"));

        jLabel3.setText("상품명");

        jLabel4.setText("가격");

        jLabel5.setText("수량");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("상품설명"));

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane3.setViewportView(taDesc);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        tfPdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPdNameActionPerformed(evt);
            }
        });

        tfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPriceActionPerformed(evt);
            }
        });

        tfQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQtyActionPerformed(evt);
            }
        });

        btIncart.setText("장바구니 넣기");
        btIncart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncartActionPerformed(evt);
            }
        });

        lbQty.setText("0");

        btPlus.setText("+");
        btPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlusActionPerformed(evt);
            }
        });

        btMinus.setText("-");
        btMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMinusActionPerformed(evt);
            }
        });

        jLabel2.setText("재고:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIncart))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPdName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(btMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lbQty)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPdName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQty)
                    .addComponent(btPlus)
                    .addComponent(btMinus)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btIncart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btJoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btJoinActionPerformed

    private void btSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSignActionPerformed

    private void btIncartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btIncartActionPerformed

    private void tfQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQtyActionPerformed

    private void btPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPlusActionPerformed

    private void tfPdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPdNameActionPerformed

    private void tfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPriceActionPerformed

    private void btMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMinusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMinusActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdmin;
    private javax.swing.JButton btCart;
    private javax.swing.JButton btIncart;
    private javax.swing.JButton btJoin;
    private javax.swing.JButton btMinus;
    private javax.swing.JButton btMypage;
    private javax.swing.JButton btPlus;
    private javax.swing.JButton btSign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbQty;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tfPdName;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQty;
    // End of variables declaration//GEN-END:variables

    private void init() {
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
       ls = new LoginService();
       tfQty.setText("1");
       
       showList();
       
       if(ls.getLOGIN_STAT()==1){
                    lbEmail.setText(LoginService.getEmail());
                    System.out.println(LoginService.getEmail());
                    btSign.setText("로그아웃");
                    btJoin.setVisible(false);
                } else {
                    btSign.setText("로그인");
                } 
    }

    private void addEvent() {
        btSign.addActionListener(this);
        btMinus.addActionListener(this);
        btPlus.addActionListener(this);
        btCart.addActionListener(this);
        btIncart.addActionListener(this);
        btCart.addActionListener(this);
        btJoin.addActionListener(this);
        btMypage.addActionListener(this);
        btAdmin.addActionListener(this);
        
        table1.addMouseListener(new EventHandler());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btSign){
            if(btSign.getText().equals("로그인")){
                Login f = new Login();
                f.setVisible(true);
                if(ls.getLOGIN_STAT()==1){
                    lbEmail.setText(LoginService.getEmail());
                    System.out.println(LoginService.getEmail());
                    btSign.setText("로그아웃");         
                    btJoin.setVisible(false);
                    init();
                } else {
                    btSign.setText("로그인");
                } 
            } else {
                LoginService.setLOGIN_STAT(0);
                btJoin.setVisible(true);
                lbEmail.setText("비회원");
                init();
            }
        } else if(e.getSource()==btIncart){
            if(ls.getLOGIN_STAT()==1){
                try {
                    insertCart();
                } catch (SQLException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }  
            } else {
                JOptionPane.showMessageDialog(this, "로그인한 사용자만 이용 가능합니다.");
            }
        } else if(e.getSource()==btCart){
            Cart ct = new Cart();
            ct.setVisible(true);
        } else if (e.getSource()==btJoin){
            Join jn = new Join();
            jn.setVisible(true);
        } else if (e.getSource()==btMypage){
            try {
                if(LoginService.LOGIN_STAT==1){
                    MyPage mp = new MyPage();
                    mp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "로그인한 사용자만 이용 가능합니다.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource()==btAdmin){
            String verEmail = lbEmail.getText();
            if(verEmail.equals("admin@admin.com")){
                AdminSelect asl = new AdminSelect();
                asl.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "관리자로 로그인 요망.");
                btAdmin.setVisible(false);
            }
            
        }
        
        if(e.getSource()==btMinus){
            int qty = Integer.parseInt(tfQty.getText());
            if(Integer.parseInt(tfQty.getText())>1){
                qty = Integer.parseInt(tfQty.getText())-1;
            }
            tfQty.setText(qty+"");
        } else if (e.getSource()==btPlus){
            int qty = Integer.parseInt(tfQty.getText());
            if(Integer.parseInt(lbQty.getText())>Integer.parseInt(tfQty.getText())){
                qty = Integer.parseInt(tfQty.getText())+1;
            }
            tfQty.setText(qty+"");
   
        }
       
    }

    private void showList() {
        DecimalFormat df = new DecimalFormat("#,###");
        try {
            ArrayList<ProductDTO> list = maindao.selectPD();
            
            String[][] data = new String[list.size()][2];
            
            for(int i =0; i<list.size(); i++){
                ProductDTO dto = list.get(i);
                int qty = maindao.PdselectByName(dto.getPdName()).getPdQty();
      
                if(qty != 0){
                    data[i][0] = dto.getPdName();
                    String price = df.format(dto.getPdPrice());
                    data[i][1] = price; 
                } else {
                    data[i][0] = "품절 상품입니다";
                    data[i][1] = 0 +"";
                }          
            }
            ProductDTO dto = new ProductDTO();
            int idx = maindao.PdselectByName(dto.getPdName()).getPdNo();
            String str = "../image/"+idx;
            lbImg = new JLabel();
            ImageIcon icon = new ImageIcon(str); 
            lbImg.setIcon(icon);
            model.setDataVector(data, colNames);
            table1.setModel(model);
            
        } catch (SQLException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insertCart() throws SQLException {
        System.out.println("인카트 구동");
            int pdNo = 0;
            
            MyPageDAO mpdao = new MyPageDAO();
            MyPageDTO mpdto = mpdao.selectMember(lbEmail.getText());
            int memNo = mpdto.getMemNo();
            System.out.println("memNo는"+memNo);
            
            ProductDTO pdto = new ProductDTO();
            //이미 입력된 상품명으로 pdno을 끌어와 가져다 붙임
            String name = tfPdName.getText();
            try {
                pdto = maindao.PdselectByName(name);
                pdNo = pdto.getPdNo();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            int orderQty = Integer.parseInt(tfQty.getText());
            
            CartDTO dto = new CartDTO();
            dto.setMemNo(memNo);
            dto.setOrderQty(orderQty);
            dto.setPdNo(pdNo);
            int pdPrice= Integer.parseInt(tfPrice.getText());
            int pdQty = Integer.parseInt(lbQty.getText());
            String pdDesc = taDesc.getText();
            String pdImg = lbImg.getText();
            
            int cnt = maindao.insertToCart(dto);
            
            if(cnt>0){
                JOptionPane.showMessageDialog(this, "카트에 등록되었습니다.");
                int afterQty = pdto.getPdQty()-Integer.parseInt(tfQty.getText());
                pdto = new ProductDTO(pdNo, name, pdPrice, afterQty, pdDesc, pdImg);
                
                maindao.updatePd(pdto);
       
            } else {
                JOptionPane.showMessageDialog(this, "카트 등록 실패");
            }
    }

    private void Test1() {
        JOptionPane.showMessageDialog(this, "테스트");
    }


    public class EventHandler extends MouseAdapter implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table1.getSelectedRow();
            
            String name = (String) table1.getValueAt(row, 0);
            
            try {
                ProductDTO dto = maindao.PdselectByName(name);
                
                tfPdName.setText(name);
                tfPrice.setText(dto.getPdPrice()+"");
                lbQty.setText(dto.getPdQty()+"");
                taDesc.setText(dto.getPdDesc());
                lbImg.setText(dto.getPdImg());
                
            } catch (SQLException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
