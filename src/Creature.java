public class Creature {
    protected String name;
    protected double def,hp,atk;
    Creature() {
        name="Creature";
        def = hp = atk = 0;
    }
    Creature(String nam,double de,double h,double at) {
        name = nam;
        def = de;
        hp = h;
        atk = at;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getAtk() {
        return atk;
    }
    public void setAtk(double atk) {
        this.atk = atk;
    }
    public double getDef() {
        return def;
    }
    public void setDef(double def) {
        this.def = def;
    }
    public double getHp() {
        return hp;
    }
    public void setHp(double hp) {
        this.hp = hp;
    }
}
