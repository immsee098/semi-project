/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import semi.project.com.AdminMem.AdminMemDAO;
import semi.project.com.AdminMem.AdminMemDTO;
import semi.project.com.Login.LoginService;
import semi.project.com.MyPage.MyPageDTO;
import semi.project.com.MyPageOrdered.MyPageOrderedDTO;

/**
 *
 * @author tmfrl
 */
public class AdminMem extends javax.swing.JFrame implements ActionListener,MouseListener{
    
    private DefaultTableModel model=new DefaultTableModel();
    private String[] colNames={"회원번호","이메일","이름","전화번호","주소"};
    private int row;
    private String memName;
    
    AdminMemDAO adminMemDao=new AdminMemDAO();
    /**
     * Creates new form AdminMem
     */
    public AdminMem() throws SQLException {
        initComponents();

        init();
        
        showMemberAll();
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        btDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "회원번호", "이메일", "이름", "전화번호", "주소"
            }
        ));
        jScrollPane1.setViewportView(memberTable);

        jLabel1.setText("이름");

        btSearch.setText("회원검색");

        btDel.setText("회원삭제");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfName))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDel)
                    .addComponent(btSearch)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(btSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AdminMem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminMem().setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDel;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberTable;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEvent() {
        btSearch.addActionListener(this);
        btDel.addActionListener(this);
        memberTable.addMouseListener(this);
    }
    
    private void showMemberAll() throws SQLException {
    try {
        ArrayList<AdminMemDTO> list=adminMemDao.selectAll();
            
            String[][] data = new String[list.size()][5];
            for(int i=0;i<list.size();i++){
                AdminMemDTO dto=list.get(i);
                data[i][0] = dto.getMemNo()+"";
                data[i][1] = dto.getEmail();
                data[i][2] = dto.getMemName();
                data[i][3] = dto.getPhone();
                data[i][4] = dto.getAddress();
            }
            
            //3
            model.setDataVector(data, colNames);
            memberTable.setModel(model);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btSearch){
            try {
         memName=tfName.getText();
         System.out.println(memName);
                memberSearch();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==btDel){
            try {
                memberDel();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void memberSearch() throws SQLException {

        ArrayList<AdminMemDTO> list=adminMemDao.selectName(memName);
            
            String[][] data = new String[list.size()][5];
            for(int i=0;i<list.size();i++){
                AdminMemDTO dto=list.get(i);
                data[i][0] = dto.getMemNo()+"";
                data[i][1] = dto.getEmail();
                data[i][2] = dto.getMemName();
                data[i][3] = dto.getPhone();
                data[i][4] = dto.getAddress();
            }
            
            //3
            model.setDataVector(data, colNames);
            memberTable.setModel(model);
    }

    private void memberDel() throws SQLException {
        if(row==0){
                JOptionPane.showMessageDialog(this, "항목을 선택하세요.");
                return;
            }else{
                int result=JOptionPane.showConfirmDialog(this, "탈퇴하시겠습니까?",
                "탈퇴", JOptionPane.YES_NO_OPTION);

                if(result==JOptionPane.YES_OPTION){
                
                    System.out.println(row);    
                //2.
                int cnt=adminMemDao.deleteMember(row);

                //3.
                if(cnt>0){
                    JOptionPane.showMessageDialog(this, "탈퇴 되었습니다.");
                    showMemberAll();
                }else{
                    JOptionPane.showMessageDialog(this, "탈퇴 실패");
                }
            }
            }

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowno = memberTable.getSelectedRow();
        String orderno=(String) memberTable.getValueAt(rowno,0);
        row = Integer.parseInt(orderno);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
