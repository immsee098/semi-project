/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.AdminMem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import semi.project.com.DB.DBUtil;
import semi.project.com.Login.LoginService;
import semi.project.com.MyPage.MyPageDTO;
import semi.project.com.MyPageOrdered.MyPageOrderedDTO;

/**
 *
 * @author tmfrl
 */
public class AdminMemDAO {
    public ArrayList<AdminMemDTO> selectAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

       ArrayList<AdminMemDTO> list=new ArrayList<>();
        try{
            //1,2
            con=DBUtil.getConnection();
            //3
            String sql="select * from MemTable order by MemNo";
            ps=con.prepareStatement(sql);

            //4.
            rs=ps.executeQuery();    
            while(rs.next()){
                int memNo=rs.getInt("MemNo");
                String email=rs.getString("email"); 
                String pwd=rs.getString("Pwd"); 
                String name=rs.getString("MemName"); 
                String address=rs.getString("address");
                String phone=rs.getString("phone");  
                int mileage=rs.getInt("mileage");
                
                AdminMemDTO dto = new AdminMemDTO(memNo,email,pwd,name,address,phone,mileage);
                list.add(dto);
            }
            System.out.println("전체 조회 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }

    public ArrayList<AdminMemDTO> selectName() throws SQLException {
 
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

       ArrayList<AdminMemDTO> list=new ArrayList<>();
        try{
            //1,2
            con=DBUtil.getConnection();
            //3
            String sql="select * from MemTable order by MemNo desc";
            ps=con.prepareStatement(sql);

            //4.
            rs=ps.executeQuery();    
            while(rs.next()){
                int memNo=rs.getInt("MemNo");
                String email=rs.getString("email"); 
                String pwd=rs.getString("Pwd"); 
                String name=rs.getString("MemName"); 
                String phone=rs.getString("phone"); 
                String address=rs.getString("address"); 
                int mileage=rs.getInt("mileage");
                
                AdminMemDTO dto = new AdminMemDTO(memNo,email,pwd,name,phone,address,mileage);
                list.add(dto);
            }
            System.out.println("전체 조회 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    

    public int deleteMember(int row) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;

        try{
            //1
            //2
            con=DBUtil.getConnection();
            
            //3
            String sql="delete from MemTable where MemNo=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, row);
            
            //4
            int cnt=ps.executeUpdate();
            System.out.println("삭제 결과 cnt="+cnt);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }    
    }

    public ArrayList<AdminMemDTO> selectName(String memName) throws SQLException {
        
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

       ArrayList<AdminMemDTO> list=new ArrayList<>();
        try{
            //1,2
            con=DBUtil.getConnection();
            //3
            String sql="select * from MemTable where MemName=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, memName);
            
            //4.
            rs=ps.executeQuery();    
            while(rs.next()){
                int memNo=rs.getInt("MemNo");
                String email=rs.getString("email"); 
                String pwd=rs.getString("Pwd"); 
                String name=rs.getString("MemName"); 
                String phone=rs.getString("phone"); 
                String address=rs.getString("address"); 
                int mileage=rs.getInt("mileage");
                
                AdminMemDTO dto = new AdminMemDTO(memNo,email,pwd,name,phone,address,mileage);
                list.add(dto);
            }
            System.out.println("전체 조회 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
}
