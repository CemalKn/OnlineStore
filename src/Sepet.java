import java.util.ArrayList;
import java.util.List;

public class Sepet {
    public static List<Sepet> sepet = new ArrayList<>();
    public static List<List<Sepet>> eskiSiparisler = new ArrayList<>();
    String isim;
    String fiyat;
    private String cesit;
    public static int toplamFiyat = 0;

    public Sepet(String cesit ,String isim, String fiyat) {
        this.cesit = cesit;
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public String getCesit() {
        return cesit;
    }

    public String getIsim() {
        return isim;
    }


    public String getFiyat() {
        return fiyat;
    }
}
