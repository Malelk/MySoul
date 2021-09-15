public class Player extends Creature{
    private int Medicine;
    private double hpmax;
    Player(String nam,int de,int h,int at) {
        name = nam;
        def = de;
        hp = h;
        hpmax = h;
        atk = at;
    }
    public void show(double score) {
        System.out.println("-------\nYour Name Is "+getName());
        System.out.println("YourHp:"+getHp());
        System.out.println("YourScore is "+score);
        System.out.println("YourMedicine:"+getMedicine());
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
    public void huiFu() {
        if(Medicine==0) {
            System.out.println("-------\nNo Medicine");
        }
        else {
            Medicine--;
            setHp(getHp()+hpmax*0.4);
            System.out.println("-------\nDunDunDun");
            if(getHp()>hpmax) setHp(hpmax);;
            System.out.println("Your Hp Now Is "+getHp());
        }
    }
}
