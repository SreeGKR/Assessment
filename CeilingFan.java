import java.time.LocalDate;

public class CeilingFan {
    private int speed; // 0=off, 1=low, 2=medium, 3=high
    private boolean direction; // true=forward, false=reverse
    private boolean isChristmas; // true=ceiling fan is off on Dec 25th
    
    public CeilingFan() {
        speed = 0;
        direction = true;
        isChristmas = false;
    }
    
    public void pullCord1() {
        if (!isChristmas) {
            speed = (speed + 1) % 4;
            if (speed == 0) {
                direction = true; // reset direction to forward when turning off
            }
        }
    }
    
    public void pullCord2() {
        if (!isChristmas) {
            direction = !direction;
        }
    }
    
    public void setChristmas(boolean isChristmas) {
        this.isChristmas = isChristmas;
        if (isChristmas) {
            speed = 0; // turn off ceiling fan on Christmas day
            direction = true;
        }
    }
    
    public String toString() {
        String directionStr = direction ? "forward" : "reverse";
        return "Ceiling fan speed: " + speed + ", direction: " + directionStr;
    }
    
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        LocalDate today = LocalDate.now();
        fan.setChristmas(today.getMonthValue() == 12 && today.getDayOfMonth() == 25);
        fan.pullCord1();
        fan.pullCord2();
        System.out.println(fan);
    }
}
