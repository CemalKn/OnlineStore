import java.util.ArrayList;
import java.util.List;

public class Register {
    public static List<Register> registers = new ArrayList<>();
    private String kullaniciAdi;
    private String email;
    private String password;

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
