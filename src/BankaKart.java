import java.util.ArrayList;
import java.util.List;

public class BankaKart {
    public static List<BankaKart> bankaList = new ArrayList<>();
    public static String userMoney = "500";

    private String isim;
    private String soyIsim;
    private String kartNo;
    private String sonKullanmaTarihi;
    private String ccv;

    public BankaKart(String isim, String soyIsim) {
        this.isim = isim;
        this.soyIsim = soyIsim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public String getKartNo() {
        return kartNo;
    }

    public void setKartNo(String kartNo) {
        this.kartNo = kartNo;
    }

    public String getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }

    public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

}
