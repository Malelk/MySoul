public class Arm {
    private int atk,def,num;
    private boolean used;
    Arm(int nu,int at,int de) {
        num = nu;
        atk = at;
        def = de;
        used = false;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public boolean getUsed() {
        return used;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }
}
