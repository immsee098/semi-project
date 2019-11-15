/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import semi.project.com.DB.DBUtil;
import semi.project.com.cart.CartDTO;
import semi.project.com.product.ProductDTO;

/**
 *
 * @author dbstj
 */
public class MainDAO {
    
    public ArrayList<ProductDTO> selectPD() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ProductDTO> list = new ArrayList<>();
        
        
        try {
            con = DBUtil.getConnection();
            
            String sql = "select * from PdTable";
            ps = con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                int PdNo = rs.getInt("PdNo");
                String PdName = rs.getString("PdName");
                int PdPrice = rs.getInt("PdPrice");
                int PdQty = rs.getInt("PdQty");
                String PdDesc = rs.getString("PdDesc");
                String PdImg = rs.getString("PdImg");
                
                ProductDTO dto = new ProductDTO(PdNo, PdName, PdPrice, PdQty, PdDesc, PdImg);
                list.add(dto);
              
            }
            
            System.out.println("전체 조회 결과:"+list.size());
             return list;
            
        } finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }
    
    public ProductDTO PdselectByName(String name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto = new ProductDTO();
        
        try{
            con=DBUtil.getConnection();
            
            String sql ="select * from PdTable where PdName=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, name);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int PdNo = rs.getInt("PdNo");
                int PdPrice = rs.getInt("PdPrice");
                int PdQty = rs.getInt("PdQty");
                String PdDesc = rs.getString("PdDesc");
                String PdImg = rs.getString("PdImg");
                
                dto.setPdNo(PdNo);
                dto.setPdPrice(PdPrice);
                dto.setPdQty(PdQty);
                dto.setPdDesc(PdDesc);
                dto.setPdImg(PdImg);
            }
            System.out.println("이름으로 조회 결과:"+dto);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public ProductDTO PdselectByNo(int No) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProductDTO dto = new ProductDTO();
        
        try{
            con=DBUtil.getConnection();
            
            String sql ="select * from PdTable where PdNo=?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, No);
            
            rs = ps.executeQuery();
            if(rs.next()){
                String PdName = rs.getString("PdName");
                int PdPrice = rs.getInt("PdPrice");
                int PdQty = rs.getInt("PdQty");
                String PdDesc = rs.getString("PdDesc");
                String PdImg = rs.getString("PdImg");
                
                dto.setPdName(PdName);
                dto.setPdPrice(PdPrice);
                dto.setPdQty(PdQty);
                dto.setPdDesc(PdDesc);
                dto.setPdImg(PdImg);
            }
            System.out.println("번호로 조회 결과:"+dto);
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public int insertToCart(CartDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con=DBUtil.getConnection();
            String sql = "insert into CartTable\n" +
"                         values(seq_cart.nextval, ?, ?, ?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, dto.getPdNo());
            ps.setInt(2, dto.getOrderQty());
            ps.setInt(3, dto.getMemNo());
            
            int cnt = ps.executeUpdate();
            System.out.println("카트 등록 결과:"+cnt);
            
            return cnt;
        } finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public int updatePd(ProductDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con=DBUtil.getConnection();
            
            String sql = "update PdTable \n" +
            "set PdName=?, PdPrice=?, PdQty=?, PdDesc=?, PdImg=?\n" +
            "where PdNo=?";
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, dto.getPdName());
            ps.setInt(2, dto.getPdPrice());
            ps.setInt(3, dto.getPdQty());
            ps.setString(4, dto.getPdDesc());
            ps.setString(5, dto.getPdImg());
            ps.setInt(6, dto.getPdNo());
            
            int cnt = ps.executeUpdate();
            System.out.println("업데이트 결과:"+cnt);
            return cnt;     
        } finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    public int deleteProduct(int no) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DBUtil.getConnection();
            
            String sql = "delete from PdTable where PdNo=? CASCADE CONSTRAINTS";
            ps = con.prepareStatement(sql);
            ps.setInt(1, no);
            
            int cnt = ps.executeUpdate();
            System.out.println("삭제 결과:"+cnt);
            return cnt;
        } finally {
            DBUtil.dbClose(ps, con);
        }       
    }
    
    public int addPd(ProductDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DBUtil.getConnection();
            String sql="insert into PdTable(PdNo, PdName, PdPrice, PdQty, PdDesc, PdImg)\n" +
                " values(seq_pd.nextval, ?,?,?,?, 'http://~')";
            ps=con.prepareStatement(sql);
            
            ps.setString(1,dto.getPdName());
            ps.setInt(2, dto.getPdPrice());
            ps.setInt(3, dto.getPdQty());
            ps.setString(4, dto.getPdDesc());
            
            //4. 
            int cnt = ps.executeUpdate();
            System.out.println("상품등록 결과 cnt="+cnt);
            return cnt;
            
        } finally{
            DBUtil.dbClose(ps, con);
        }
    }
    
    
}
