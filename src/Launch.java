import java.util.Scanner;
import java.util.Random;

public class Launch {
    public static void main(String[] args) {
        int level = 1;
        Random r = new Random();

        System.out.println("Enter Your Name");
        Scanner cin = new Scanner(System.in);
        String name = cin.nextLine();
        System.out.println("Welcome back, " + name);
        double score = 0;
        int saiZi = r.nextInt(100);
        Player player = new Player(name, 10+r.nextInt(20), 200 + saiZi, 10+r.nextInt(20));
        Pack pack = new Pack(player);
        player.setMedicine(5);
        do {
            System.out.println("-------\nWhat do you want to do?");
            String s = cin.nextLine();
            if (s.equals("show")) {
                player.show(score,level,pack);
                continue;
            }

            if (s.equals("kill")) {
                player.setHp(-1);
                continue;
            }
            if (s.equals("heal")) {
                player.huiFu();
                continue;
            }
            if (s.equals("go")) {
                saiZi = r.nextInt(9);
                if (0 <= saiZi && saiZi <= 1) {
                    player.raise(r.nextInt(30), r.nextInt(30), r.nextInt(30));  
                    Fire.xiuXi(player);
                    level++;
                }
                if (2 <= saiZi && saiZi <= 4)
                    Pack.add(level, pack);
                continue;
            }
            if (s.equals("arm")) {
                System.out.println("-------\nPlease Input the Number");
                String i = cin.nextLine();
                player.useArm(Integer.parseInt(i), pack);
                continue;
            }
            if (s.equals("equip")) {
                System.out.println("-------\nPlease Input the Number");
                String i = cin.nextLine();
                player.useEquip(Integer.parseInt(i), pack);
                continue;
            }
            if(s.equals("pack")) {
                pack.show();
                continue;
            }
            if(s.equals("\n")) continue;
             System.out.println("-------\nNo Such Command\nPlease Check The Game tutorial");
             System.out.println("Enter help to Check");
        } while (player.getHp() > 0);
        System.out.println("-------\nYou Died");
        System.out.print("-------\nYour Score Is " + score);
        cin.close();
    }
}
