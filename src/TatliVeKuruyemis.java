import java.util.ArrayList;
import java.util.List;

public class TatliVeKuruyemis {
    private String isim;
    private String fiyat;

    public static List<TatliVeKuruyemis> tatliVeKuruyemisList = new ArrayList<>();

    public TatliVeKuruyemis(String isim, String fiyat) {
        this.isim = isim;
        this.fiyat = fiyat;
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

    public static void urunEkleTatliVeKuruyemis() {
        TatliVeKuruyemis urun1 = new TatliVeKuruyemis("Findik","KG 320 TL");
        TatliVeKuruyemis urun2 = new TatliVeKuruyemis("Badem","KG 300 TL");
        TatliVeKuruyemis urun3 = new TatliVeKuruyemis("Antep_Fistigi","KG 500 TL");
        TatliVeKuruyemis urun4 = new TatliVeKuruyemis("Leblebi","KG 30 TL");
        TatliVeKuruyemis urun5 = new TatliVeKuruyemis("Kazandibi","Piece 43 TL");
        TatliVeKuruyemis urun6 = new TatliVeKuruyemis("Baklava","KG 599 TL");
        TatliVeKuruyemis urun7 = new TatliVeKuruyemis("Sutlac","Piece 30 TL");
        tatliVeKuruyemisList.add(urun1);
        tatliVeKuruyemisList.add(urun2);
        tatliVeKuruyemisList.add(urun3);
        tatliVeKuruyemisList.add(urun4);
        tatliVeKuruyemisList.add(urun5);
        tatliVeKuruyemisList.add(urun6);
        tatliVeKuruyemisList.add(urun7);
    }
}
