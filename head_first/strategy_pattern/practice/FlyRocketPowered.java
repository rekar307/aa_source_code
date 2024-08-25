package strategy_pattern.practice;

public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("FlyRocketPowered: 로켓 추진으로 날아갑니다.");
    }
}
