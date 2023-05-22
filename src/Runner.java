public class Runner {
    static int count = 0;
    public static void main(String[] args) {
        Depo.urunleriEkle();
        start();
    }
    public static void start(){
        if (count==0) {
            System.out.println("------------------------\n--------Wellcome--------\n------------------------");
            count++;
        }
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
                System.exit(0);
            case "58":
                BankaMethod.kartHazirla();
            default:
                System.out.println("invalid input...");
                for (int i = 0 ; i<3;i++){
                    try {
                        Thread.sleep(300);
                        System.out.println(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                start();
        }
    }
}
