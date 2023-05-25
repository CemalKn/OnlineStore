import java.util.List;

public class ComplatedSiparis {

    public static void comlatedSiparis() {
        int count = 0;
        System.out.println("-----Complated Orders-----");
        System.out.println();
        if (Sepet.eskiSiparisler.size()==0){
            System.out.println();
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
                System.out.print( a.getIsim()+ a.getFiyat() + " TL");
                toplamFiyat += Integer.valueOf(a.getFiyat());
            }
            System.out.println("---------------------------");
            System.out.println("Total amount : "+toplamFiyat+" TL");
            System.out.println();
        }
    }
}
