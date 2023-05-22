import java.time.LocalDate;
import java.util.Random;

public class BankaMethod {
    static Random rnd = new Random();
    public static void kartHazirla(){
        System.out.println("Please enter name...");
        String isim = Depo.input.next();
        System.out.println("Please enter surname...");
        String soyIsim = Depo.input.next();
        BankaKart kart = new BankaKart(isim,soyIsim);
        kart.setKartNo(kartNo());
        kart.setSonKullanmaTarihi(sonKullanmaTarihi());
        kart.setCcv(ccv());
        BankaKart.bankaList.add(kart);
        System.out.println("Transaction completed successfully");
        System.out.println("Kart No : "+kart.getKartNo()+"\n"+"Card Owner : "+kart.getIsim()+" "+kart.getSoyIsim()+"\n"+"Expiration date : "+kart.getSonKullanmaTarihi()+"   "+"CVV : "+kart.getCcv());
    }

    private static String ccv() {
        String ccv = rnd.nextInt(899)+100+"";
        return ccv;
    }

    private static String sonKullanmaTarihi() {
        String tarih ="";
        LocalDate myDate = LocalDate.now();
        int deger = rnd.nextInt(12-1)+1;
        if (deger<10){
            tarih = "0"+deger+"/"+((myDate.getYear()+5+"").substring(2));
        }else {
            tarih = deger+"/"+((myDate.getYear()+5+"").substring(2));
        }
        return tarih;
    }

    private static String kartNo() {
        String kartNo="5858 ";
        int deger;
        for (int i = 0; i<3 ;i++){
            deger = rnd.nextInt(8999)+1000;
            kartNo+=deger+" ";
        }
        return kartNo.trim();
    }
}
