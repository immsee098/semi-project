/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.MyPageOrdered;

import java.sql.Timestamp;

/**
 *
 * @author tmfrl
 */
public class MyPageProductDTO {
    private int No;
    private Timestamp OrderDate;
    private int pdNo;
    private int OrderQty;
    private int MemNo;
    private String pdName;
    private int pdPrice;

    public MyPageProductDTO() {
    }

    MyPageProductDTO(int No, Timestamp OrderDate, String pdName, int pdPrice, int orderQty, int pdNo, int memNo) {
        this.No = No;
        this.OrderDate = OrderDate;
        this.pdNo = pdNo;
        this.OrderQty = OrderQty;
        this.MemNo = MemNo;
        this.pdName = pdName;
        this.pdPrice = pdPrice;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public Timestamp getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Timestamp OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getPdNo() {
        return pdNo;
    }

    public void setPdNo(int pdNo) {
        this.pdNo = pdNo;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int OrderQty) {
        this.OrderQty = OrderQty;
    }

    public int getMemNo() {
        return MemNo;
    }

    public void setMemNo(int MemNo) {
        this.MemNo = MemNo;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public int getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(int pdPrice) {
        this.pdPrice = pdPrice;
    }
    
    
}
