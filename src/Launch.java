import java.util.Scanner;
import java.util.Random;
import javax.swing.plaf.metal.MetalBorders.ScrollPaneBorder;

public class Launch {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("Enter Your Name");
        Scanner cin = new Scanner(System.in);
        String name = cin.nextLine();
        System.out.println("Welcome back, " + name);
        double score = 0;
        int saiZi = r.nextInt(100);
        Player player = new Player(name, 10, 200+saiZi, 10);
        player.setMedicine(5);
        do {
            System.out.println("-------\nWhat do you want to do?");
            String s = cin.nextLine();
            System.out.println(s);
            if (s.equals("show")) {
                player.show(score);
                continue;
            }
                
            if(s.equals("kill")) {
                player.setHp(-1);
                continue;
            } 
            if(s.equals("heal")) {
                player.huiFu();
                continue;
            }
            if(s.equals("go")) {
                saiZi = r.nextInt(9);
                if(0<=saiZi&&saiZi<=1) Fire.xiuXi(player);

            }
            System.out.println("-------\nNo Such Command\nPlease Check The Game tutorial");
            System.out.println("Enter help to Check\n-------");    
        } while (player.getHp() > 0);
        System.out.println("-------\nYou Died");
        System.out.print("-------\nYour Score Is " + score);
        cin.close();
    }
}
