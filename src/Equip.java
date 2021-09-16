public class Equip {
    private int def,num,type;
    private boolean used;
    Equip(int num,int def,int type) {
        this.num = num;
        this.def = def;
        this.type = type;
        used = false;
    }
    public int getDef() {
        return def;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setUsed(boolean used) {
        this.used = used;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public boolean getUsed() {
        return used;
    }
    
}
