/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.product;

/**
 *
 * @author tmfrl
 */
public class ProductDTO {
    private int PdNo;
    private String PdName;
    private int PdPrice;
    private int PdQty;
    private String PdDesc;
    private String PdImg;

    public int getPdNo() {
        return PdNo;
    }

    public void setPdNo(int PdNo) {
        this.PdNo = PdNo;
    }

    public String getPdName() {
        return PdName;
    }

    public void setPdName(String PdName) {
        this.PdName = PdName;
    }

    public int getPdPrice() {
        return PdPrice;
    }

    public void setPdPrice(int PdPrice) {
        this.PdPrice = PdPrice;
    }

    public int getPdQty() {
        return PdQty;
    }

    public void setPdQty(int PdQty) {
        this.PdQty = PdQty;
    }

    public String getPdDesc() {
        return PdDesc;
    }

    public void setPdDesc(String PdDesc) {
        this.PdDesc = PdDesc;
    }

    public String getPdImg() {
        return PdImg;
    }

    public void setPdImg(String PdImg) {
        this.PdImg = PdImg;
    }

    public ProductDTO(int PdNo, String PdName, int PdPrice, int PdQty, String PdDesc, String PdImg) {
        this.PdNo = PdNo;
        this.PdName = PdName;
        this.PdPrice = PdPrice;
        this.PdQty = PdQty;
        this.PdDesc = PdDesc;
        this.PdImg = PdImg;
    }

    public ProductDTO() {
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "PdNo=" + PdNo + ", PdName=" + PdName + ", PdPrice=" + PdPrice + ", PdQty=" + PdQty + ", PdDesc=" + PdDesc + ", PdImg=" + PdImg + '}';
    }
    
}
