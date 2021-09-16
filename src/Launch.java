import java.util.Scanner;
import java.util.Random;

public class Launch {
    public static void main(String[] args) {
        int level = 1;
        Random r = new Random();
        int diff;        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a Number to Choose your Difficulty");
        diff = Integer.parseInt(cin.nextLine());
        System.out.println("Enter Your Name");

        String name = cin.nextLine();
        System.out.println("Welcome back, " + name);
        double score = 0;
        int saiZi = r.nextInt(100);
        Player player = new Player(name, 30 + r.nextInt(20), 200 + saiZi, 30 + r.nextInt(20));
        Pack pack = new Pack(player);
        player.setMedicine(5);
        do {
            System.out.println("-------\nWhat do you want to do?");
            String s = cin.nextLine();
            if(s.equals("help")) {
                Help.help();
                continue;
            }
            if (s.equals("show")) {
                player.show(score, level, pack);
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
                if (saiZi >= 5) {
                    Enemy enemy = new Enemy("ene", (10 + r.nextInt(20) * level)*diff, (10 + r.nextInt(90) * level)*diff,
                            (10 + r.nextInt(40) * level)*diff);
                    double cnt = enemy.getAtk() * enemy.getDef() * enemy.getHp();
                    System.out.println("-------");
                    System.out.println("!!!Meet An Enemy!!!");
                    Battle.show(enemy);
                    int round = Battle.play(player, enemy, score, level, pack);
                    if (player.getHp() <= 0)
                        break;
                    score += (cnt) / round*diff;
                    System.out.println("You Got Score of " + (cnt) / round*diff);
                    continue;
                }

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
            if (s.equals("pack")) {
                pack.show();
                continue;
            }
            if (s.equals("\n"))
                continue;
            System.out.println("-------\nNo Such Command\nPlease Check The Game tutorial");
            System.out.println("Enter help to Check");
        } while (player.getHp() > 0);
        System.out.println("-------\nYou Died");
        System.out.print("-------\nYour Score Is " + score);
        cin.close();
    }
}
