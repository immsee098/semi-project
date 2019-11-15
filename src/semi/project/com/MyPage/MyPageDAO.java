/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.MyPage;

import semi.project.com.Login.LoginService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import semi.project.com.DB.DBUtil;

/**
 *
 * @author tmfrl
 */
public class MyPageDAO {
      //로그인 처리
    public int login(String email, String pwd) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        int result=0;
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select pwd from MemTable where email=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            
            //4.
            rs=ps.executeQuery();
 
            if(rs.next()){
                String dbPwd=rs.getString(1);
                if(dbPwd.equals(pwd)){
                    result=LoginService.LOGIN_OK;
  
                }else{
                    result=LoginService.PWD_DISAGREE;                    
                }
            }else{
                result=LoginService.ID_NONE;
            }
            System.out.println("로그인 처리 결과 result="+result);
            
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }//login
    
     public MyPageDTO selectMember(String email) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        MyPageDTO dto=new MyPageDTO();
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select * from MemTable where email=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            
            //4.
            rs=ps.executeQuery();
                
            if(rs.next()){
                int no=rs.getInt("MemNo");
                String pwd=rs.getString("Pwd");
                String name=rs.getString("MemName");
                String address=rs.getString("Address");
                String phone=rs.getString("Phone");
                int mileage=rs.getInt("Mileage");
                
                        
                dto.setAddress(address);
                dto.setEmail(email);
                dto.setMemName(name);
                dto.setMemNo(no);
                dto.setMileage(mileage);
                dto.setPhone(phone);
                dto.setPwd(pwd);
            }
            System.out.println("회원정보 조회 결과 dto="+dto);
            
            return dto;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }

    public int updateMember(MyPageDTO dto) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="update MemTable" +
            " set Address=?, Phone=?" +
            " where Email=? and pwd=?";
            ps=con.prepareStatement(sql);
                        
            ps.setString(1, dto.getAddress());
            ps.setString(2, dto.getPhone());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getPwd());
            
            //4
            int cnt=ps.executeUpdate();
            System.out.println("회원정보 수정 결과, cnt="+cnt);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
    }

    public int deleteMember(String email) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        
        try{
            //1
            //2
            con=DBUtil.getConnection();
            
            //3
            String sql="delete from MemTable where email=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, email);
            
            //4
            int cnt=ps.executeUpdate();
            System.out.println("삭제 결과 cnt="+cnt);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }    
    }
    
}
