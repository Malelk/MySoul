public class Player extends Creature {
    private int Medicine;
    private double hpmax;
    public int[] use = new int[4];
    private int righthand;

    Player(String nam, int de, int h, int at) {
        righthand = 0;
        name = nam;
        def = de;
        hp = h;
        hpmax = h;
        atk = at;
    }

    public double getatk(Pack p) {
        return atk + (double) p.getArrArm().get(righthand).getAtk();
    }

    public double getdef(Pack p) {
        double d = 0;
        for (int i = 0; i < 4; i++) {
            d += (double) p.getArrEquip().get(use[i]).getDef();
        }
        d += def;
        return d;
    }

    public void show(double score, int level, Pack p) {
        System.out.println("-------\nYour Name Is " + getName());
        System.out.println("Lv." + level);
        System.out.println("Hp:" + getHp() + "/" + hpmax);
        System.out.println("YourScore is " + score);
        System.out.println("YourMedicine:" + getMedicine());
        System.out.println("YourATK:" + getatk(p));
        System.out.println("YourDef:" + getdef(p));
        System.out.println("Righthand Use No." + righthand);
    }

    public int getMedicine() {
        return Medicine;
    }

    public void setMedicine(int medicine) {
        Medicine = medicine;
    }

    public double getHpmax() {
        return hpmax;
    }

    public void setHpmax(double hpmax) {
        this.hpmax = hpmax;
    }

    public void useArm(int i, Pack p) {
        if (i > p.getArrArm().size()) {
            System.out.println("No Such Arm");
            return;
        }
        int pre = this.righthand;
        p.getArrArm().get(pre).setUsed(false);
        righthand = i;
        System.out.println("Now use Arm No." + i);
        p.getArrArm().get(righthand).setUsed(true);

    }

    public void useEquip(int i, Pack p) {
        // System.out.println("debug");
        if (i > p.getArrEquip().size()) {
            System.out.println("No Such Equip");
            return;
        }
        int type = p.getArrEquip().get(i).getType();
        use[type] = i;

    }

    public void huiFu() {
        if (Medicine == 0) {
            System.out.println("-------\nNo Medicine");
        } else {
            Medicine--;
            setHp(getHp() + hpmax * 0.4);
            System.out.println("-------\nDunDunDun");
            if (getHp() > hpmax)
                setHp(hpmax);
            ;
            System.out.println("Your Hp Now Is " + getHp());
        }
    }

    public int getRighthand() {
        return righthand;
    }

    public void setRighthand(int righthand) {
        this.righthand = righthand;
    }

    public void raise(int a, int b, int c) {
        this.hpmax += a;
        this.atk += b;
        this.def += c;
    }
}
