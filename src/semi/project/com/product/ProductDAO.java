/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import semi.project.com.DB.DBUtil;

/**
 *
 * @author tmfrl
 */
public class ProductDAO {
    public ArrayList<ProductDTO> selectProduct(String data[][]) throws SQLException {
        //주문상세번호로 검색
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        
       ArrayList<ProductDTO> list=new ArrayList<>();
        try{
            //1,2
            con=DBUtil.getConnection();
            
            //3
            String sql="select * from PdTable where PdNo=?";
            ps=con.prepareStatement(sql);
            for(int i=0;i<data.length;i++){
                ps.setString(1, data[i][0]);
            }
            //4.
            rs=ps.executeQuery();
                
            if(rs.next()){
                int pdNo=rs.getInt("PdNo");
                String pdName=rs.getString("PdName");
                int pdPrice=rs.getInt("PdPrice");
                int pdQty=rs.getInt("PdQty");
                String pdDesc=rs.getString("PdDesc");
                String pdImg=rs.getString("PdImg");
              
               ProductDTO dto = new ProductDTO(pdNo ,pdName, pdPrice, pdQty, pdDesc, pdImg);
               list.add(dto);
                System.out.println(dto);
            }
            System.out.println("전체 조회 결과 list.size="+list.size());
            return list;
        }finally{
            DBUtil.dbClose(rs, ps, con);
        }
        
    }
}
