import java.util.Iterator;

public class SepetMethods{

    public static void sepetMenu() {
        System.out.println("1-Complete order\n2-Deleting Items in Orders\n3-Delete Orders Completely\n4-Previous page");
        String secim = Depo.input.next();
        switch (secim){
            case "1":
                siparisTamamla();
            case "2":
                sepettenUrunSil();
            case "3":
                sepetiTamamenSil();
            case "4":
                MainPage.mainPage();
            default:
                System.out.println("Please make a valid entry");
                sepetMenu();
        }
    }

    private static void sepetiTamamenSil() {
        if (Sepet.sepet.size()==0){
            System.out.println();
            System.out.println("Orders are empty...");
            System.out.println();
            sepetMenu();
        }
        do {
            System.out.println("Are you sure you want to delete orders completely?");
            System.out.println("1-Yes 2-No");
            String secim = Depo.input.next();
            switch (secim) {
                case "1":
                    Iterator<Sepet> myItr = Sepet.sepet.iterator();
                    while (myItr.hasNext()){
                        myItr.next();
                        myItr.remove();
                    }
                    System.out.println("Orders deleted successfully...");
                    sepetMenu();
                case "2":
                    System.out.println("Transaction canceled...");
                    sepetMenu();
                default:
                    System.out.println("Please make a valid entry...");
            }
        }while (true);
    }

    private static void sepettenUrunSil() {
        if (Sepet.sepet.size()==0){
            System.out.println();
            System.out.println("Orders are empty...");
            System.out.println();
            sepetMenu();
        }
        for (Sepet a : Sepet.sepet){
            System.out.println("      Product             |            Price");
            System.out.println("----------------------------------------------------");
            int toplamFiyat = 0;
            for (Sepet b : Sepet.sepet){
                System.out.printf("%-21s -->  %-20s\n",b.isim,b.fiyat+" TL"+" ("+b.isim.split(" ")[2]+" = "+(Integer.valueOf(b.fiyat.replaceAll("[^0-9]",""))/Integer.valueOf(b.isim.split(" ")[1]))+" TL)");
                toplamFiyat+=Integer.valueOf(b.fiyat);
            }
            System.out.println("----------------------------------------------------");
            System.out.println("Total amount : "+toplamFiyat+" TL");
            System.out.println();
            String silUrun;
            Sepet silUrunS = Sepet.sepet.get(0);
            String silinenUrunIsmi;
            do {
                System.out.println("Enter the name of the product you want to delete...press 0 to exit");
                silUrun = Depo.input.next();
                silinenUrunIsmi = silUrun;
                Login.count = 0;
                for (Sepet b : Sepet.sepet) {
                    if (silUrun.equalsIgnoreCase(b.isim.split(" ")[0])){
                        silUrunS = b;
                        Login.count++;
                    } else {
                        if (silUrun.equals("0")){
                            sepetMenu();
                        }
                    }
                }
                if (Login.count==0){
                    System.out.println("Wrong product name...");
                }
            }while (Login.count==0&&!silUrun.equals("0"));

            Login.count = 0;
            int eskiAdet;

            int eksilenAdet;
            do {
                System.out.println("How many KG/Pieces do you want to delete from the product you want to delete... press 0 to exit");
                silUrun = Depo.input.next();
                eskiAdet = Integer.valueOf(silUrunS.isim.replaceAll("[^0-9]",""));
                eksilenAdet = Integer.valueOf(silUrun);
                if (eskiAdet<eksilenAdet||silUrun.replaceAll("[0-9]", "").length()>0){
                    System.out.println("Please enter a valid value...");
                } else if (silUrun.equals("0")) {
                    sepetMenu();
                }
            }while (silUrun.replaceAll("[0-9]", "").length()>0||eskiAdet<eksilenAdet);
            System.out.println();
            String bilgi1 = "Previous --> "+silUrunS.isim+" "+silUrunS.fiyat+" TL";
            int yeniAdet = eskiAdet-eksilenAdet;
            silUrunS.isim = silUrunS.isim.replaceFirst(silUrunS.isim.split(" ")[1],yeniAdet+"");
            if (silUrunS.getCesit().equalsIgnoreCase("elektronik")){
                for (Elektronik e : Elektronik.elektronikList){
                    if(e.getIsim().equalsIgnoreCase(silinenUrunIsmi)){
                        silUrunS.fiyat = (Integer.valueOf(e.getFiyat().replaceAll("[^0-9]",""))*yeniAdet)+"";
                    }
                }
            }
            if (silUrunS.getCesit().equalsIgnoreCase("manav")){
                for (Manav e : Manav.manavList){
                    if(e.getIsim().equalsIgnoreCase(silinenUrunIsmi)){
                        silUrunS.fiyat = (Integer.valueOf(e.getFiyat().replaceAll("[^0-9]",""))*yeniAdet)+"";
                    }
                }
            }
            if (silUrunS.getCesit().equalsIgnoreCase("TatliKuruyemis")){
                for (TatliVeKuruyemis e : TatliVeKuruyemis.tatliVeKuruyemisList){
                    if(e.getIsim().equalsIgnoreCase(silinenUrunIsmi)){
                        silUrunS.fiyat = (Integer.valueOf(e.getFiyat().replaceAll("[^0-9]",""))*yeniAdet)+"";
                    }
                }
            }
            if (silUrunS.isim.replaceAll("[^0-9]","").equalsIgnoreCase("0")){
                Sepet.sepet.remove(silUrunS);
            }
            System.out.println("Islem Basari ile gerceklesti...");
            System.out.println(bilgi1+"  |  Next --> "+silUrunS.isim+" "+silUrunS.fiyat+" TL");

            sepettenUrunSil();
        }
    }

    private static void siparisTamamla() {
        if (Sepet.sepet.size()==0){
            System.out.println();
            System.out.println("Orders are empty...");
            System.out.println();
            sepetMenu();
        }
        System.out.printf("    Product         |  Price\n");
        System.out.println("-----------------------");
        int toplamFiyat = 0;
        for (Sepet a : Sepet.sepet){
            System.out.printf("%-20s %-20s\n",a.isim,a.fiyat+" TL");
            toplamFiyat+=Integer.valueOf(a.fiyat);
        }
        System.out.println("------------------------------");
        System.out.println("Total amount : "+toplamFiyat+" TL");
        System.out.println();
        sepetMenu();
    }
}