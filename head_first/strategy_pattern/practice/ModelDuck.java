package strategy_pattern.practice;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehhavior = new Quack();
    }

    public void display() {
        System.out.println("ModelDuck: 저는 모형 오리입니다.");
    }
}
