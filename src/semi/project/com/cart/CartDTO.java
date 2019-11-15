/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.cart;

public class CartDTO {
    
      int orderNo;
       int pdNo;
       String pdName;
       int pdPrice;
       int orderQty;
       int memNo;
       
       public int getPdNo() {
		return pdNo;
	}
	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}
       
       public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
       
       public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	public CartDTO() {
		super();
	}
        
        public CartDTO(int orderNo, String pdName, int pdPrice, int orderQty) {
		super();
                this.orderNo = orderNo;
		this.pdName = pdName;
		this.pdPrice = pdPrice;
		this.orderQty = orderQty;
	}
    
}
