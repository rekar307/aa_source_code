package strategy_pattern.practice;

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("FlyNoWay: 저는 못 날아요.");
    }
}
