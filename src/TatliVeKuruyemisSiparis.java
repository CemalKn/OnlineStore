public class TatliVeKuruyemisSiparis implements UrunListesiVeSiparis{
    @Override
    public void urunListesiVeSiparis() {
        System.out.println("Product            Price");
        System.out.println("-----------------------------");
        TatliVeKuruyemis istenenUrun = TatliVeKuruyemis.tatliVeKuruyemisList.get(0);
        for (TatliVeKuruyemis a : TatliVeKuruyemis.tatliVeKuruyemisList){
            System.out.printf("%-13s --> %-10s\n",a.getIsim(),a.getFiyat());
        }
        System.out.println("Enter the name of the product you want to order, press 0 to exit");
        String siparisUrun = Depo.input.next();
        if (!siparisUrun.equals("0")) {
            Login.count = 0;
            for (TatliVeKuruyemis a : TatliVeKuruyemis.tatliVeKuruyemisList) {
                if (siparisUrun.equalsIgnoreCase(a.getIsim())) {
                    Login.count++;
                    istenenUrun = a;
                }
            }
            if (Login.count == 0) {
                System.out.println("Incorrect product name please try again");
                urunListesiVeSiparis();
            }
        }else {
            Siparis.siparis();
        }
        do {
            System.out.println("How many KG/Pieces do you want to buy? press 0 to exit");
            siparisUrun = Depo.input.next();
            if (!siparisUrun.equals("0")) {
                if (siparisUrun.replaceAll("[0-9]", "").length() > 0) {
                    System.out.println("Enter a valid digit/number... ");
                    siparisUrun="-1";
                }
            } else {
                Siparis.siparis();
            }
        }while (Integer.valueOf(siparisUrun)==-1);
        String fiyatAdet = Integer.valueOf(istenenUrun.getFiyat().replaceAll("[^0-9]",""))*Integer.valueOf(siparisUrun)+"";
        String kg = siparisUrun;
        do {
            System.out.println(istenenUrun.getIsim() + " " + Integer.valueOf(siparisUrun) + " "+ istenenUrun.getFiyat().split(" ")[0]+" "+fiyatAdet+" TL Do you confirm?");
            System.out.println("1-Yes 2-No");
            String onay = Depo.input.next();
            Login.count = 0;
            Sepet gecici = null;
            if (Sepet.sepet.isEmpty()){
                gecici = new Sepet("a","a","a");
                Sepet.sepet.add(gecici);
            }
            Sepet ayni = Sepet.sepet.get(0);
            switch (onay) {
                case "1":
                    for (Sepet a : Sepet.sepet){
                        if (a.isim.split(" ")[0].equalsIgnoreCase(istenenUrun.getIsim())){
                            Login.count++;
                            ayni=a;
                        }
                    }
                    if (Login.count>0){
                        System.out.println("Since you want to buy the same product again, only the number of pieces has been added");
                        System.out.print("Previous --> "+ayni.isim+" "+ayni.fiyat+" TL");
                        Sepet.sepet.remove(ayni);
                        ayni.fiyat = ""+(Integer.valueOf(ayni.fiyat) + Integer.valueOf(istenenUrun.getFiyat().replaceAll("[^0-9]",""))*Integer.valueOf(siparisUrun));
                        ayni.isim = istenenUrun.getIsim()+" "+ (Integer.valueOf(kg)+Integer.valueOf(ayni.isim.replaceAll("[^0-9]","")))+" "+istenenUrun.getFiyat().split(" ")[0];
                        Sepet.sepet.add(ayni);
                        System.out.println("  |  Next --> "+ayni.isim+" "+ayni.fiyat+" TL");
                        urunListesiVeSiparis();
                    }else {
                        System.out.println("Product added to orders...");
                        Sepet urunSepet = new Sepet("TatliKuruyemis",istenenUrun.getIsim() + " " + kg + " "+istenenUrun.getFiyat().split(" ")[0], fiyatAdet);
                        Sepet.sepet.add(urunSepet);
                        Sepet.sepet.remove(gecici);
                        urunListesiVeSiparis();
                    }
                case "2":
                    System.out.println("Order canceled");
                    urunListesiVeSiparis();
                default:
                    System.out.println("Please make a valid entry...");
            }
        }while (true);

    }
}
