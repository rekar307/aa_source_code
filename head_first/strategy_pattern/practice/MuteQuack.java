package strategy_pattern.practice;

public class MuteQuack implements QuackBehhavior {
    public void quack() {
        System.out.println("MuteQuack: << 조용~ >>");
    }
}
