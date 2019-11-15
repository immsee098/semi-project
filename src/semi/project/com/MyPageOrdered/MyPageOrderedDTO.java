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
public class MyPageOrderedDTO {
    private int No;
    private Timestamp OrderDate;
    private int pdNo;
    private int OrderQty;
    private int MemNo;

    public MyPageOrderedDTO() {
        super();
    }

    public MyPageOrderedDTO(int No, Timestamp OrderDate, int pdNo, int OrderQty, int MemNo) {
        super();
        this.No = No;
        this.OrderDate = OrderDate;
        this.pdNo = pdNo;
        this.OrderQty = OrderQty;
        this.MemNo = MemNo;
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

    @Override
    public String toString() {
        return "MyPageOrderedDAO{" + "No=" + No + ", OrderDate=" + OrderDate + ", pdNo=" + pdNo + ", OrderQty=" + OrderQty + ", MemNo=" + MemNo + '}';
    }
    
    
}
