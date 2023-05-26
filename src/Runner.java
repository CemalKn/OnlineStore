public class Runner {
    public static void main(String[] args) {
        Depo.urunleriEkle();
        storeAndBank();
    }

    public static void storeAndBank() {
        System.out.println("------------------------\n--------Wellcome--------\n------------------------");
        System.out.println("1-OnlineStore 2-Bank 3-Exit");
        String secim = Depo.input.next();
        switch (secim){
            case "1":
                start();
            case "2":
                BankaMethod.bankMenu();
            case "3":
                System.exit(0);
            case"58":
                BankaMethod.kartHazirla();
                BankaMethod.odeme();
            default:
                System.out.println("Please make a valid entry...");
                storeAndBank();
        }
    }

    public static void start(){
        System.out.println("----------------------------------\n--------Wellcome The Store--------\n----------------------------------");
        System.out.println("1-Login 2-Register 3-Number of Members and e-mail addresses 4-Exit");
        String secim = Depo.input.next();
        switch (secim){
            case "1":
                Login.login();
            case "2":
                RegisterMethod.register();
            case "3":
                Uyeler.uyeleriGoster();
            case "4":
                storeAndBank();
            default:
                System.out.println("invalid input...");
                for (int i = 0 ; i<3;i++){
                    try {
                        Thread.sleep(300);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println();
                start();
        }
    }
}
