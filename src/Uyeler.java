public class Uyeler {
    public static void uyeleriGoster() {
        System.out.println("-----Members-----");
        Login.count=1;
        if (Register.registers.size()-1>0){
            int count = 0;
            for (Register a : Register.registers){
                if (count>0) {
                    System.out.println(Login.count +" . "+a.getEmail());
                    Login.count++;
                }else {
                    count++;
                }
            }
            System.out.println();
            System.out.println("Number of members : "+(Login.count-1));
        }else {
            System.out.println("Sorry, we don't have a member. Would you like to be our first member?");
        }
        System.out.println();
        Runner.start();
    }
}
