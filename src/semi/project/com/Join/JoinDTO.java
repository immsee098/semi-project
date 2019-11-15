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

import java.security.Timestamp;

public class JoinDTO {

	
	private int memno;
	private String memname;
	private String email;
	private String pwd;
	private String phone;
	private String address;
	//생성자 
		

	public JoinDTO() {
            super();
		
	}
	

	public JoinDTO(int memno, String memname, String email, String pwd, String phone,
			String address) {
                super();
		this.memno = memno;
		this.memname = memname;
		this.email = email;
		this.pwd = pwd;
		this.phone = phone;
		this.address = address;
	
	}

    public int getMemNo() {
        return memno;
    }

    public void setMemNo(int memNo) {
        this.memno = memNo;
    }

    public String getMemName() {
        return memname;
    }

    public void setMemName(String memName) {
        this.memname = memName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "JoinDTO{" + "memno=" + memno + ", memname=" + memname + 
                ", email=" + email + ", pwd=" + pwd + ", phone=" + phone + ", address=" + address + '}';
    }


}
