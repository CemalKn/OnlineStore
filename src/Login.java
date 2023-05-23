public class Login {
    public static int count;
    public static Register correctReg;
    public static void login() {
        System.out.println("-----Login-----");
        String email;
        String password;
        do {
            System.out.println("Please enter e-mail");
            email = Depo.input.next();
        }while (!sameEmail(email)&&!email.equals("0"));
        do {
            System.out.println("Please enter password");
            password = Depo.input.next();
        }while (!samePassword(password)&&!password.equals("0"));
        if (email.equals("a")){
            System.out.println("Admin login...");
            MainPage.mainPage();
        }
        System.out.println("Successful login...");
        for (int i = 0 ; i<3 ; i++){
            try {
                Thread.sleep(300);
                System.out.print(".");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        MainPage.mainPage();
    }

    private static boolean samePassword(String password) {
        if (correctReg.getPassword().equals(password)){
            return true;
        }else {
            if (password.equals("0")){
                System.out.println("You are redirected to the main menu...");
                for (int i = 0 ; i<3 ; i++){
                    try {
                        Thread.sleep(300);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println();
                Runner.start();
            }
            System.out.println("Invalid password try again or press '0' to exit");
            for (int i = 0 ; i<3 ; i++){
                try {
                    Thread.sleep(300);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
            return false;
        }
    }

    private static boolean sameEmail(String email) {
        count = 0;
        for (Register a : Register.registers){
            if (a.getEmail().equals(email)){
                correctReg=a;
                count++;
            }
        }
        if (count>0){
            return true;
        }else {
            if (email.equals("0")){
                System.out.println("You are redirected to the main menu...");
                for (int i = 0 ; i<3 ; i++){
                    try {
                        Thread.sleep(300);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println();
                Runner.start();
            }
            System.out.println("Invalid email try again or press '0' to exit");
            for (int i = 0 ; i<3 ; i++){
                try {
                    Thread.sleep(300);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
            return false;
        }
    }
}
