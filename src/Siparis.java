public class Siparis {

    static ManavSiparis manavSiparis = new ManavSiparis();
    static ElektronikSiparis elektronikSiparis = new ElektronikSiparis();
    static TatliVeKuruyemisSiparis tatliVeKuruyemisSiparis = new TatliVeKuruyemisSiparis();
    public static void siparis() {
        System.out.println("-----Order-----");
        do {
            System.out.println("Category\n--------\n1-Fruits and vegetables \n2-Electronic \n3-Sweets and Kuruyemis \n4-Previous page");
            String secim = Depo.input.next();
            switch (secim) {
                case "1":
                    manavSiparis.urunListesiVeSiparis();
                case "2":
                    elektronikSiparis.urunListesiVeSiparis();
                case "3":
                    tatliVeKuruyemisSiparis.urunListesiVeSiparis();
                case "4":
                    MainPage.mainPage();
                default:
                    System.out.println("Please enter valid");
            }
        }while (true);
    }
}
