/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.MyPageOrdered;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import semi.project.com.DB.DBUtil;
import semi.project.com.Login.LoginService;

/**
 *
 * @author tmfrl
 */
public class MyPageOrderedDAO {
    public ArrayList<MyPageOrderedDTO> selectAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

       ArrayList<MyPageOrderedDTO> list=new ArrayList<>();
        try{
            //1,2
            con=DBUtil.getConnection();
            
            int MemNo=LoginService.mem_no;
            //3
            String sql="select * from OrderedTable where MemNo=? order by No";
            ps=con.prepareStatement(sql);
            ps.setInt(1, MemNo);
            //4.
            rs=ps.executeQuery();    
            while(rs.next()){
                int No=rs.getInt("No");
                int PdNo=rs.getInt("PdNo");
                int OrderQty=rs.getInt("OrderQty");
                Timestamp OrderDate=rs.getTimestamp("OrderDate");
                
                MyPageOrderedDTO dto = new MyPageOrderedDTO(No, OrderDate, PdNo, OrderQty, MemNo);
                list.add(dto);
            }
            for(MyPageOrderedDTO i : list){
                 System.out.println("값 : " + i );
                }
            System.out.println("전체 조회 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
    }
    
    public ArrayList<MyPageProductDTO> selectP(int number) throws SQLException{
        System.out.println("zzz");
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        ArrayList<MyPageProductDTO> list=new ArrayList<>();

        int orderNo=number;
        //int orderNo=2;
        int memNo=LoginService.mem_no;
        System.out.println("상품연결");
        System.out.println("주문번호="+orderNo);
        try{

            con=DBUtil.getConnection();
            
            String sql="select a.NO, b.PDNAME, a.ORDERDATE, b.PDPRICE, a.ORDERQTY, a.pdno from OrderedTable a, pdtable b where a.PDNO = b.PDNO and a.NO =?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, orderNo);
            rs=ps.executeQuery();
             
            while(rs.next()){
                
                int No = rs.getInt("NO");
                String pdName=rs.getString("PDNAME");
                Timestamp OrderDate=rs.getTimestamp("OrderDate");
                int pdPrice =rs.getInt("PDPRICE");
                int pdNo =rs.getInt("PDNO");
                int orderQty = rs.getInt("ORDERQTY");
                              
                MyPageProductDTO dto = new MyPageProductDTO(No, OrderDate, pdName, pdPrice, orderQty, pdNo, memNo);
                list.add(dto);
                System.out.println(list.size());
                System.out.println("상품개수="+orderQty);
            }
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }   
    }

}
