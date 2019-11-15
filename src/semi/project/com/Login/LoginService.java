/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semi.project.com.Login;

/**
 *
 * @author dbstj
 */
public class LoginService {
    public static final int LOGIN_OK=1;  //로그인 성공
    public static final int ID_NONE=2;    //아이디 존재하지 않음
    public static final int PWD_DISAGREE=3; //비밀번호 불일치
    
    public static final int USABLE_EMAIL=1;  //사용가능한 이메일
    public static final int UNUSABLE_EMAIL=2; //이미 존재해서 사용불가능한 이메일
    
    private static String email;
    public static int LOGIN_STAT=0; //0은 로그아웃상태 1은 로그인상태
    public static int mem_no; //회원 식별번호 1은 임시

    public static int getMem_no() {
        return mem_no;
    }

    public static void setMem_no(int mem_no) {
        LoginService.mem_no = mem_no;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        LoginService.email = email;
    }

    public static int getLOGIN_STAT() {
        return LOGIN_STAT;
    }

    public static void setLOGIN_STAT(int LOGIN_STAT) {
        LoginService.LOGIN_STAT = LOGIN_STAT;
    }
}
    
