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
                Manav urun1 = new Manav("Domates","KG 30 TL");
                Manav urun2 = new Manav("Patates","KG 15 TL");
                Manav urun3 = new Manav("Sogan","KG 17 TL");
                Manav urun4 = new Manav("Havuc","KG 30 TL");
                Manav urun5 = new Manav("Biber","KG 40 TL");
                Manav urun6 = new Manav("Muz","KG 50 TL");
                Manav urun7 = new Manav("Portakal","KG 43 TL");
                Manav urun8 = new Manav("Erik","KG 599 TL");
                Manav urun9 = new Manav("Kivi","KG 30 TL");
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
