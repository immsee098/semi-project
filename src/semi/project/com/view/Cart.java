/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import semi.project.com.cart.CartDAO;
import semi.project.com.cart.CartDTO;
import semi.project.com.view.*;

public class Cart extends javax.swing.JFrame implements ActionListener{
    private String[] colNames={"주문번호", "상품명","가격","개수"};
    private int row;
    private int totalrow;
    private DefaultTableModel model=new DefaultTableModel();
    private CartDAO cartDao;
    
    public Cart() {
        initComponents();
        
        cartDao = new CartDAO();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        addEvent();
        
        showAll();
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        carttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        purchase = new javax.swing.JButton();
        delall = new javax.swing.JButton();
        delone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("장바구니");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("장바구니"));

        carttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "번호", "상품명", "가격", "개수"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(carttable);

        jLabel1.setText("총 금액:");

        jtotal.setText("0");
        jtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtotalActionPerformed(evt);
            }
        });

        jLabel2.setText("원");

        purchase.setText("구매");

        delall.setText("전체 비우기");
        delall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delallActionPerformed(evt);
            }
        });

        delone.setText("개별 삭제");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(delone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(delall))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(516, 516, 516)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchase)
                    .addComponent(delall)
                    .addComponent(delone))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtotalActionPerformed

    private void delallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delallActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delallActionPerformed

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
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable carttable;
    private javax.swing.JButton delall;
    private javax.swing.JButton delone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtotal;
    private javax.swing.JButton purchase;
    // End of variables declaration//GEN-END:variables

    private void addEvent() {
        purchase.addActionListener(this);
        delone.addActionListener(this);
        delall.addActionListener(this);
        carttable.addMouseListener(new EventHandler());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
            if(e.getSource()==purchase){
               purchase();
            } else if (e.getSource()==delone) {
               delone();
            } else if (e.getSource()==delall) {
               delall();
            } 
    }
    
    private void purchase() {
      
        int chk = 0;
        
        try {

            ArrayList<CartDTO> list = cartDao.selectAll();

            for(int i=0;i<list.size();i++){
                CartDTO dto=list.get(i);
                int no = dto.getOrderNo();
                int qty = dto.getOrderQty();
                cartDao.purchase(no, qty);
                chk+=1;
                 
            }
           
            if (chk == totalrow) {
                JOptionPane.showMessageDialog(this, "구매 완료.");
            
                showAll();
              
                
            } else if (chk != totalrow) {
                JOptionPane.showMessageDialog(this, "문제가 발생했습니다.");
            }
            
        } catch (Exception e) {
        
        }
        
    }
    
  private void delone () {
        
        try {
            if(row==0){
                JOptionPane.showMessageDialog(this, "항목을 선택하세요.");
                return;
            }
            
            int cnt = cartDao.delone(row);
            
            if (cnt == 1) {
                JOptionPane.showMessageDialog(this, "항목 삭제 완료.");
                showAll();
            } else if (cnt == 0) {
                JOptionPane.showMessageDialog(this, "문제가 발생했습니다.");
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
  private void delall () {
        
        try {
          
            boolean chk = cartDao.delAll();

            if (chk == true) {
                JOptionPane.showMessageDialog(this, "전체 항목 삭제 완료.");
                showAll();
            } else if (chk == false) {
                JOptionPane.showMessageDialog(this, "문제가 발생했습니다.");
            }
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
private void showAll()  {
      
        DecimalFormat df = new DecimalFormat("#,###");
        
        int total = 0;
        
       try {
            ArrayList<CartDTO> list = cartDao.selectAll();
            
            String[][] data = new String[list.size()][4];
            for(int i=0;i<list.size();i++){
                CartDTO dto=list.get(i);
                data[i][0] = Integer.toString(dto.getOrderNo());
                data[i][1] = dto.getPdName();
                String price=df.format(dto.getPdPrice());
                total += dto.getPdPrice();
                totalrow += 1;
                data[i][2] = price;
                data[i][3] = Integer.toString(dto.getOrderQty());
                           
            }
            
            model.setDataVector(data, colNames);
            carttable.setModel(model);
            jtotal.setText(Integer.toString(total));
            //
           
            carttable.getTableHeader().setReorderingAllowed(false);
            //carttable.setRowHeight(30);
            
           
            //carttable.getColumnModel().getColumn(0).setPreferredWidth(0);
            carttable.getColumn("주문번호").setWidth(0);
            carttable.getColumn("주문번호").setMinWidth(0);
            carttable.getColumn("주문번호").setMaxWidth(0);
            carttable.getColumnModel().getColumn(1).setPreferredWidth(120);
            carttable.getColumnModel().getColumn(2).setPreferredWidth(67);
            carttable.getColumnModel().getColumn(3).setPreferredWidth(67);
            
       } catch (SQLException ex) {
           ex.printStackTrace();
       }
    }


class EventHandler extends MouseAdapter implements  ItemListener{
        
        @Override
        public void mouseClicked(MouseEvent e) {
            int rowno = carttable.getSelectedRow();
          
            
            String orderno=(String) carttable.getValueAt(rowno,0);
            row = Integer.parseInt(orderno);

            
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            
            }//if
            
            
        
    }

}


