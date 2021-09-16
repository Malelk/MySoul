import java.util.ArrayList;

import java.util.Random;

public class Pack {
    private ArrayList<Arm> arrArm = new ArrayList<>();
    private ArrayList<Equip> arrEquip = new ArrayList<>();
    private static Random r = new Random();

    Pack(Player p) {
        arrArm.add(new Arm(0, 0, 0));
        arrArm.get(0).setUsed(true);
        for (int i = 0; i < 4; i++) {
            arrEquip.add(new Equip(i, 0, i));
            p.use[i] = i;
        }
    }

    public static void add(int l, Pack p) {
        int i = r.nextInt(2);
        if (i == 0) {
            addEquip(l, p);
        } else
            addArm(l, p);
    }

    private static void addEquip(int l, Pack p) {
        int i = r.nextInt(3);
        int j = r.nextInt(15);
        int num = p.getArrEquip().size();
        p.getArrEquip().add(new Equip(num, (5 + j) * l, i));
        System.out.println("------\nGet a new Equip No." + num + "\n");
        System.out.println("Def:" + (5 + j) * l);
        System.out.println("Type:" + i);
    }

    private static void addArm(int l, Pack p) {
        int num = p.arrArm.size();
        int i = r.nextInt(20);
        int j = r.nextInt(20);
        System.out.println("i=" + i);
        p.arrArm.add(new Arm(num, i * l + 10, j * l));
        System.out.println("------\nGet a new Arm No." + num + "\n");
        System.out.println("Atk:" + (i * l + 10));
        System.out.println("Def:" + j * l);
    }

    public ArrayList<Arm> getArrArm() {
        return arrArm;
    }

    public ArrayList<Equip> getArrEquip() {
        return arrEquip;
    }

    public void show() {
        System.out.println("-------\nYour Arm");
        for (int i = 0; i < arrArm.size(); i++) {

            System.out.println("-------\nArm No." + i);
            System.out.println("Atk: " + arrArm.get(i).getAtk());
        }

        System.out.println("-------\n Your Equip");
        for (int i = 0; i < arrEquip.size(); i++) {
            System.out.println("-------\nEquip No." + i);
            System.out.println("Type" + arrEquip.get(i).getType() + "\nDef Is " + arrEquip.get(i).getDef());
        }
    }
}
