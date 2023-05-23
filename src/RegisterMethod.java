public class RegisterMethod {
    public static void register() {
        System.out.println("-----Register-----");
        String email;
        String password;
        do {
            System.out.println("Please enter e-mail || hotmail.com or gmail.com");
            email = Depo.input.next();
        }while (!correctEmail(email));
        do {
            System.out.println("Please enter password || Min length 6");
            password = Depo.input.next();
        }while (!correctPassword(password));
        Register uye = new Register(email,password);
        Register.registers.add(uye);
        String[] tamam = {"Your","Membership","Process","Has","Been","Successfully","Completed"};
        for (String a : tamam){
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(a+" ");
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        Runner.start();
    }

    private static boolean correctPassword(String password) {
        if (password.length()>5){
            return true;
        }else {
            System.out.println("Password length min 6");
            for (int i = 0 ; i<3 ; i++){
                try {
                    Thread.sleep(300);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
        return false;
    }

    public static boolean correctEmail(String email){
        if (email.endsWith("@hotmail.com")||email.endsWith("@gmail.com")){
            int look = 0;
            for (Register a : Register.registers){
                if (a.getEmail().equals(email)){
                    look++;
                }
            }
            if (look>0){
                System.out.println("This e-mail already registered");
            }else {
                return true;
            }
        }else {
            System.out.println("Please enter correct e-mail");
            for (int i = 0 ; i<3 ; i++){
                try {
                    Thread.sleep(300);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
        return false;
    }
}
