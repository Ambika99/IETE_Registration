package ambika.android.com.iete_registration;
import java.io.Serializable;

public class Registration implements Serializable{
    private String name;
    private String reg;
    private String mobile;
    private String email;
    private String room;
    private String payment;
    public Registration(){
        super();
    }
    public Registration(String name,String reg,String mobile, String email,String room, String payment){
        this.name = name;
        this.reg = reg;
        this.mobile = mobile;
        this.email = email;
        this.room = room;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
