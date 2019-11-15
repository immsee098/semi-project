/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.Join;

/**
 *
 * @author LIAM LEE
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import semi.project.com.DB.DBUtil;
import semi.project.com.Login.LoginService;


public class JoinDAO {
	//회원가입 DAO
	JoinDTO dto = new JoinDTO();
	
	public  int insertMember(JoinDTO dto) throws SQLException{
		
	
		Connection con= null;
		PreparedStatement ps = null;
	
	//1.
	//2. 
	try {
			con =DBUtil.getConnection();
                        System.out.println("연결완료");
			
	//3.ps		
			String sql= "insert into memTable(memno, email, pwd, memname, address, phone)"
                                + " values(seq_mem.nextval, ?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getMemName());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getPhone());
	//4.exec
            int cnt=ps.executeUpdate();
            System.out.println("회원가입 결과, cnt="+cnt);
            
            return cnt;
        }finally{
            DBUtil.dbClose(ps, con);
        }
        }
	 public int duplicateEmail(String email) throws SQLException{
        //아이디 중복확인
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        int result=0;
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select  count(*)from memTable" +
                        " where email= ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, email);
            
            //4
            rs=ps.executeQuery();
            if(rs.next()){
                int count=rs.getInt(1);
                if(count>0){ //이미 해당 아이디가 존재=> 사용불가
                    result=LoginService.UNUSABLE_EMAIL;
                }else{ //사용가능
                    result=LoginService.USABLE_EMAIL;                    
                }
            }            
            System.out.println("이메일 중복확인 결과, result="+result);
            
            return result;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }
}