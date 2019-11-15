/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.cart;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;
import semi.project.com.DB.DBUtil;
import semi.project.com.Login.LoginService;


public class CartDAO {
    
    public void purchase(int no, int qty) throws SQLException {
    
        Connection con=null;
        PreparedStatement ps=null;
        int memno = LoginService.getMem_no();
         try{
        
            con=DBUtil.getConnection();
            
            String sql="insert into orderedtable values (seq_ordered.nextval, sysdate, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, no);
            ps.setInt(2, qty);
            ps.setInt(3, memno);
         
            ps.executeUpdate();
            
            String sql2="delete from carttable where memno = ?";
            ps=con.prepareStatement(sql2);
            
            ps.setInt(1, memno);
            
            ps.executeUpdate();
            
         
        }finally{
            DBUtil.dbClose(ps, con);
        }
        
    }
    
    
    
    public int delone(int no) throws SQLException {
    
        Connection con=null;
        PreparedStatement ps=null;
        
        try{

            con=DBUtil.getConnection();
            
            String sql="delete from carttable where orderno=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, no);
            
            int cnt=ps.executeUpdate();
            System.out.println("삭제 결과 cnt="+cnt);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public boolean delAll() throws SQLException {
    
        Connection con=null;
        PreparedStatement ps=null;
        boolean chk = false;
        
        int memno = LoginService.getMem_no();
        
        try{
            con=DBUtil.getConnection();
           
            String sql="delete from carttable where memno = ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, memno);
            
            int cnt=ps.executeUpdate();
            
            if (cnt>0) {
                chk = true; 
            } else if (cnt==0) {
                chk = false;
            } 
            
            return chk;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }

    
    public ArrayList<CartDTO> selectAll() throws SQLException{

        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<CartDTO> list=new ArrayList<>();
        
        int memno = LoginService.getMem_no();
        
        try{

            con=DBUtil.getConnection();
            
            String sql="select a.ORDERNO, b.PDNAME, b.PDPRICE, a.ORDERQTY from carttable a, pdtable b where a.PDNO = b.PDNO and a.MEMNO =?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, memno);
            rs=ps.executeQuery();
             
            while(rs.next()){
                
                int orderNo = rs.getInt("ORDERNO");
                String pdName=rs.getString("PDNAME");
                int pdPrice =rs.getInt("PDPRICE");
                int orderQty = rs.getInt("ORDERQTY");
                              
                CartDTO dto = new CartDTO(orderNo, pdName, pdPrice, orderQty);
     
                list.add(dto);
            }
        
             return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
  
  
    
}
