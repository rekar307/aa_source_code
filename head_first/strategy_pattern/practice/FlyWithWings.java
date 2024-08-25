package strategy_pattern.practice;

public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("FlyWithWings: 날고 있어요!");
    }
}
