/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.AdminMem;

/**
 *
 * @author tmfrl
 */
public class AdminMemDTO {
        private int MemNo; 
	private String Email;
	private String pwd;
	private String MemName;
	private String Address;
	private String Phone;
	private int Mileage;

    public int getMemNo() {
        return MemNo;
    }

    public void setMemNo(int MemNo) {
        this.MemNo = MemNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMemName() {
        return MemName;
    }

    public void setMemName(String MemName) {
        this.MemName = MemName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int Mileage) {
        this.Mileage = Mileage;
    }

    public AdminMemDTO() {
    }

    public AdminMemDTO(int MemNo, String Email, String pwd, String MemName, String Address, String Phone, int Mileage) {
        this.MemNo = MemNo;
        this.Email = Email;
        this.pwd = pwd;
        this.MemName = MemName;
        this.Address = Address;
        this.Phone = Phone;
        this.Mileage = Mileage;
    }

    @Override
    public String toString() {
        return "MyPageDTO{" + "MemNo=" + MemNo + ", Email=" + Email + ", pwd=" + pwd + ", MemName=" + MemName + ", Address=" + Address + ", Phone=" + Phone + ", Mileage=" + Mileage + '}';
    }
        
   
}
