import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static void show (Enemy e) {
        System.out.println("-------");
        System.out.println("Enemy ");
        System.out.println("Hp: "+e.getHp());
        System.out.println("Atk: "+e.getAtk());
        System.out.println("Def: "+e.getDef());   
        return;    
    }
    public static int  play(Player p,Enemy e,double score,int level,Pack pp) {
        int cnt = 0;
        String[] op = new String[] {"","tap","smash","parry"};
        Random r = new Random();
        

        Scanner cin = new Scanner(System.in);
        do {
            System.out.println("-------");
            int i = r.nextInt(3)+1;
            String s = cin.nextLine();

            double to = 0, from = 0;
            double baseTo = e.getAtk()*100/(100+p.getDef());
            double baseFrom = p.getAtk()*100/(100+e.getDef());
            if(s.equals("info")) {
                show(e);
                continue;
            }
            if(s.equals("show")) {
                p.show(score, level, pp);
                continue;
            }            
            System.out.println("The Enemy Use "+op[i]);
            if(s.equals("tap")) {
    //计算伤害倍率
                if(i==1) {
                    to = 1;
                    from = 1;
                }
                if(i==2) {
                    to = 1;
                    from = 0.3;

                }
                if(i==3) {
                    to = 0;
                    from = 3.0;
                }
            }
            if(s.equals("smash")) {
                if(i==1) {
                    to = 0.3;
                    from =1;
                }
                if(i==2) {
                    to = 1.5;
                    from = 1.5;
                }
                if(i==3) {
                    to = 1.5;
                    from = 0;
                }
            }
            if(s.equals("parry")) {
                if(i == 1) {
                    to = 3.0;
                    from = 0;
                }
                if(i==2) {
                    from = 1.5;
                }
            }
            if(s.equals("heal")) {
                if(i==1) from = 1;
                if(i==2) from = 1.5;
            }
            System.out.println("Damage Given To:"+baseTo*to);
            System.out.println("Damage Give From Enemy :" + baseFrom*from);
            p.setHp(p.getHp()-baseFrom*from);
            e.setHp(e.getHp()-baseTo*to);
            cnt ++;
        }while(p.getHp()>0&&e.getHp()>0);
        if(e.getHp()<0) p.setHp(1);
        cin.close();
        return cnt;
    }
}
