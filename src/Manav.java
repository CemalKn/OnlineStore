import java.util.ArrayList;
import java.util.List;

public class Manav {
        private String isim;
        private String fiyat;

        public static List<Manav> manavList = new ArrayList<>();

        public Manav(String isim, String fiyat) {
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

        public static void urunEkleManav() {
                Manav urun1 = new Manav("Tomatoes","KG 30 TL");
                Manav urun2 = new Manav("Potatoes","KG 15 TL");
                Manav urun3 = new Manav("Onion","KG 17 TL");
                Manav urun4 = new Manav("Carrot","KG 30 TL");
                Manav urun5 = new Manav("Pepper","KG 40 TL");
                Manav urun6 = new Manav("Banana","KG 50 TL");
                Manav urun7 = new Manav("Orange","KG 43 TL");
                Manav urun8 = new Manav("Plum","KG 599 TL");
                Manav urun9 = new Manav("Apricot","KG 30 TL");
                manavList.add(urun1);
                manavList.add(urun2);
                manavList.add(urun3);
                manavList.add(urun4);
                manavList.add(urun5);
                manavList.add(urun6);
                manavList.add(urun7);
                manavList.add(urun8);
                manavList.add(urun9);
        }
}
