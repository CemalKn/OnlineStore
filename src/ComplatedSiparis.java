import java.util.List;

public class ComplatedSiparis {

    public static void comlatedSiparis() {
        int count = 0;
        System.out.println("-----Complated Orders-----");
        System.out.println();
        if (Sepet.eskiSiparisler.size()==0){
            System.out.println("You have no completed orders...");
            System.out.println();
            MainPage.mainPage();
        }
        for (List<Sepet> b : Sepet.eskiSiparisler){
            count++;
            System.out.println("-----"+count+". Order-----");
            System.out.print("    Product         |  Price\n");
            System.out.println("---------------------------");
            int toplamFiyat = 0;
            for (Sepet a : b) {
                System.out.printf("%-21s -->  %-20s\n",a.isim,a.fiyat+" TL"+" ("+a.isim.split(" ")[2]+" = "+(Integer.valueOf(a.fiyat.replaceAll("[^0-9]",""))/Integer.valueOf(a.isim.split(" ")[1]))+" TL)");
                toplamFiyat += Integer.valueOf(a.getFiyat());
            }
            System.out.println("---------------------------");
            System.out.println("Total amount : "+toplamFiyat+" TL");
            System.out.println();
        }
        MainPage.mainPage();
    }
}
