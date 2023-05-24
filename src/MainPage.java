public class MainPage {
    static int count = 0;
    public static void mainPage() {
        if (count==0) {
            System.out.println("Welcome.");
        }
        System.out.println("1-Order \n2-Your Orders\n3-Completed Orders \n4-Exit");
        String secim = Depo.input.next();
        switch (secim){
            case "1":
                Siparis.siparis();
            case "2":
                SepetMethods.sepetMenu();
            case "3":
                ComplatedSiparis.comlatedSiparis();
            case "4":
                Runner.start();
            default:
                System.out.println("Invalid select...");
                for (int i = 0 ; i<3 ; i++){
                    try {
                        Thread.sleep(300);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                mainPage();
        }
    }
}
