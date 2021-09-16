import java.util.ArrayList;

import java.util.Random;
public class Pack {
    private static ArrayList<Arm> arrArm = new ArrayList<>();
    private static ArrayList<Equip> arrEquip = new ArrayList<>();
    private static Random r = new Random();
    Pack() {
        arrArm.add(new Arm(0,0,0));
        arrArm.get(0).setUsed(true);
    }
    public static void add(int l) {        
        int i = r.nextInt(1);
        if(i==0) {
            addEquip(l)
        }
        else addArm(l);
    }
    private static void addEquip(int l) {
        int i = r.nextInt(3);
        int j = r.nextInt(15);
        int num = arrEquip.size();
        arrEquip.add(new Equip(num,(5+j)*l,i));
        System.out.println("------\nGet a new Equip No."+num+"\n");
        System.out.println("Def:"+(5+j)*l);
        System.out.println("Type:"+i);         
    }

    private static void addArm(int l) {
        int num = arrArm.size();
        int i = r.nextInt(20);
        int j = r.nextInt(20);
        arrArm.add(new Arm(num,i*l+10,j*l)); 
        System.out.println("------\nGet a new Arm No."+num+"\n");
        System.out.println("Atk:"+i*l+10);
        System.out.println("Def:"+j*l);       
    }
}
