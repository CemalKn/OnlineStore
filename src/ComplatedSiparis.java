import java.util.ArrayList;
import java.util.List;

public class ComplatedSiparis {

    public static List<Sepet>comlatedOrders = new ArrayList<>();
    public static void comlatedSiparis() {
        System.out.println("-----Complated Orders-----");
        if (ComplatedSiparis.comlatedOrders.size()==0){
            System.out.println();
            System.out.println("You have no completed orders...");
            System.out.println();
            MainPage.mainPage();
        }
    }
}
