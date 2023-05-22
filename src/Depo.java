import java.util.Scanner;

public class Depo {
    public static Scanner input = new Scanner(System.in);

    public static void urunleriEkle(){
        Elektronik.urunEkleElektronik();
        Manav.urunEkleManav();
        TatliVeKuruyemis.urunEkleTatliVeKuruyemis();

        Register a = new Register("a","a");
        Register.registers.add(a);

        Sepet gecici = new Sepet("Manav","Domates 30 KG","900");
        Sepet.sepet.add(gecici);

    }
}
