package strategy_pattern.practice;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehhavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a Mallard Duck");
    }
}
