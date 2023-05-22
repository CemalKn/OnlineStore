import java.util.ArrayList;
import java.util.List;

public class Elektronik {

    private String isim;
    private String fiyat;

    public static List<Elektronik> elektronikList = new ArrayList<>();

    public Elektronik( String isim, String fiyat) {
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public String getFiyat() {
        return fiyat;
    }

    public static void urunEkleElektronik() {
        Elektronik urun1 = new Elektronik("Laptop","Piece 100000 TL");
        Elektronik urun2 = new Elektronik("Phone","Piece 50000 TL");
        Elektronik urun3 = new Elektronik("Television","Piece 70000 TL");
        Elektronik urun4 = new Elektronik("Speaker","Piece 10000 TL");
        Elektronik urun5 = new Elektronik("Mouse","Piece 1379 TL");
        Elektronik urun6 = new Elektronik("Keyboard","Piece 3980 TL");
        Elektronik urun7 = new Elektronik("Tablet","Piece 32000 TL");
        Elektronik urun8 = new Elektronik("Camera","Piece 80000 TL");
        Elektronik urun9 = new Elektronik("Headset","Piece 5400 TL");
        elektronikList.add(urun1);
        elektronikList.add(urun2);
        elektronikList.add(urun3);
        elektronikList.add(urun4);
        elektronikList.add(urun5);
        elektronikList.add(urun6);
        elektronikList.add(urun7);
        elektronikList.add(urun8);
        elektronikList.add(urun9);
    }
}
