import java.time.LocalDate;
import java.util.Random;

public class BankaMethod {
    public static String oneTimeCode = "";
    public static BankaKart kart = new BankaKart("a","A");
    public static int count = 0;
    static Random rnd = new Random();
    public static void kartHazirla(){
        if (count==0) {
            count++;
            String isim = isimYap();
            String soyIsim = soyIsimYap();
            kart.setIsim(isim);
            kart.setSoyIsim(soyIsim);
            kart.setKartNo(kartNo());
            kart.setSonKullanmaTarihi(sonKullanmaTarihi());
            kart.setCcv(ccv());
            BankaKart.bankaList.add(kart);
            System.out.println();
            System.out.println("Transaction completed successfully");
            System.out.println("Kart No : " + kart.getKartNo() + "\n" + "Card Owner : " + kart.getIsim() + " " + kart.getSoyIsim() + "\n" +
                    "Expiration date : " + kart.getSonKullanmaTarihi() + "   " + "CVV : " + kart.getCcv());
            System.out.println();
        }else {
            System.out.println("You already have a card...");
        }
        successfullyLogin();
    }

    private static String soyIsimYap() {
        int count2 = 0;
        String soyIsim;
        do {
            if (count2>0){
                System.out.println("Surname cannot be empty");
            }
            count2++;
            System.out.println("Please enter surname...");
            soyIsim = Depo.input.nextLine().toUpperCase().trim();
        }while (soyIsim.length()==0&&soyIsim.replaceAll(" ","").length()==0);
        return soyIsim;
    }

    private static String isimYap() {
        int count2 =0;
        String isim;
        Depo.input.nextLine();
        do {
            if (count2>0){
                System.out.println("Name cannot be empty");
            }
            count2++;
            System.out.println("Please enter name...");
            isim = Depo.input.nextLine().toUpperCase().trim();
        }while (isim.length()==0&&isim.replaceAll(" ","").length()==0);
        return isim;
    }

    public static void showCard(){
        if (count>0) {
            System.out.println();
            System.out.println("---Your Card---\n" + "Kart No : " + kart.getKartNo() + "\n" + "Card Owner : " + kart.getIsim() + " " + kart.getSoyIsim() + "\n" +
                    "Expiration date : " + kart.getSonKullanmaTarihi() + "   " + "CVV : " + kart.getCcv());
            System.out.println();
        }
    }

    private static String ccv() {
        return rnd.nextInt(899)+100+"";
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

    public static void bankMenu() {
        System.out.println("---------------------------------\n--------Wellcome The Bank--------\n---------------------------------");
        System.out.println("1-Login  2-Phone Code 3-Exit");
        String secim = Depo.input.next();
        switch (secim){
            case "1":
                loginBank();
            case "2":
                phoneCode();
            case "3":
                Runner.storeAndBank();
        }
    }

    private static void phoneCode() {
        System.out.println("1-One-time code generation  2-Exit");
        Depo.secim = Depo.input.next();
        switch (Depo.secim){
            case "1":
                oneTimeCode = rnd.nextInt(89)+10+"";
                System.out.println("Your code : "+oneTimeCode);
            case "2":
                bankMenu();
            default:
                System.out.println("Please make a valid entry...");
                phoneCode();
        }
    }

    private static void loginBank() {
        do {
            System.out.println("Enter the one-time code sent to your phone..press 0 to exit");
            Depo.secim = Depo.input.next();
            if (Depo.secim.equals(oneTimeCode)&&oneTimeCode.length()>0) {
                    System.out.println("Successfully login");
                    oneTimeCode = "";
                    successfullyLogin();
            }
            if (!Depo.secim.equals("0")) {
                System.out.println("Wrong code");
            }
        }while (!Depo.secim.equals("0"));
        bankMenu();
    }

    private static void successfullyLogin() {
        System.out.println("1-Create Card \n2-Show card information \n3-Balance \n4-Deposit \n5-Withdraw \n6-Exit");
        Depo.secim = Depo.input.next();
        switch (Depo.secim){
            case "1":
                kartHazirla();
            case "2":
                showCardInformation();
                successfullyLogin();
            case "3":
                showBalance();
            case "4":
                deposit();
            case "5":
                withdraw();
            default:
                System.out.println("Please make a valid entry...");
                bankMenu();
        }
    }

    private static void withdraw() {
        if (count>0) {
            System.out.println();
            System.out.println("Current Balance : "+BankaKart.userMoney+" TL");
            System.out.println();
            System.out.println("Enter the amount you want to withdraw");
            Depo.secim = Depo.input.next();
            if (Depo.secim.replaceAll("[0-9]", "").length() == 0) {
                if (Integer.valueOf(BankaKart.userMoney) >= Integer.valueOf(Depo.secim)) {
                    System.out.println("Withdraw successful");
                    BankaKart.userMoney = Integer.valueOf(BankaKart.userMoney) - Integer.valueOf(Depo.secim) + "";
                    successfullyLogin();
                } else {
                    System.out.println("You cannot withdraw an amount greater than the amount in your account.");
                    withdraw();
                }
            } else {
                System.out.println("Please enter a valid value");
                withdraw();
            }
        }else {
            System.out.println("You must have a card first");
            successfullyLogin();
        }
        successfullyLogin();
    }

    private static void deposit() {
        if (count>0) {
            System.out.println();
            System.out.println("Current Balance : "+BankaKart.userMoney+" TL");
            System.out.println();
            System.out.println("Enter the amount you want to deposit...");
            Depo.secim = Depo.input.next();
            if (Depo.secim.replaceAll("[0-9]", "").length() == 0) {
                System.out.println("Deposit successful.");
                BankaKart.userMoney = Integer.valueOf(BankaKart.userMoney) + Integer.valueOf(Depo.secim) + "";
            } else {
                System.out.println("Please enter a valid value");
                deposit();
            }
            successfullyLogin();
        }else {
            System.out.println("You must have a card first");
            successfullyLogin();
        }
    }

    private static void showCardInformation() {
        if (count>0) {
            System.out.println("Kart No : " + kart.getKartNo() + "\n" + "Card Owner : " + kart.getIsim() + " " + kart.getSoyIsim() + "\n" +
                    "Expiration date : " + kart.getSonKullanmaTarihi() + "   " + "CVV : " + kart.getCcv());
        }else {
            System.out.println("You must have a card first");
        }
        successfullyLogin();
    }

    private static void showBalance() {
        if (count>0){
            System.out.println();
            System.out.println("Current Balance : "+BankaKart.userMoney+" TL");
            System.out.println();
            successfullyLogin();
        }else {
            System.out.println("You must have a card first");
            successfullyLogin();
        }
    }

    public static void odeme() {
        showCard();
        System.out.println("Please enter the card number");
        Depo.input.next();
        String cardNo = Depo.input.nextLine();
        System.out.println("Please enter card owner name and surname");
        String nameSurname = Depo.input.nextLine();
        System.out.println("Please enter expiration date");
        String date = Depo.input.nextLine();
        System.out.println("Please enter CVV code");
        String cvv = Depo.input.nextLine();
        if (!cardNo.trim().replaceAll(" ","").equals(kart.getKartNo().replaceAll(" ",""))){
            System.out.println("Wrong card number");
        }
        if (!nameSurname.replaceAll(" ","").equals((kart.getIsim()+kart.getSoyIsim()).replaceAll(" ",""))){
            System.out.println("Wrong card owner");
        }
        if (!date.trim().replaceAll("/ ","").equals(kart.getSonKullanmaTarihi().replaceAll("/ ",""))){
            System.out.println("Wrong date");
        }
        if (!cvv.trim().replaceAll(" ","").equals(kart.getCcv().replaceAll(" ",""))){
            System.out.println("Wrong CVV");
        }
        System.out.println("line finish");
    }
}
















