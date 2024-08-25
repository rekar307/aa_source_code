package strategy_pattern.practice;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehhavior quackBehhavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehhavior.quack();
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠.");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehhavior(QuackBehhavior qb) {
        quackBehhavior = qb;
    }
}
