package Visitor.interfaceVisitor;

interface ICarElementVisitor {
    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);
}

interface ICarElement {
    abstract public void accept(ICarElementVisitor visitor);
}

public class Main {
    public static void main(String[] args) {
        ICarElement car = new Car();
        System.out.println("\nCarElementPrintVisitor #####");
        car.accept(new CarElementPrintVisitor());
        System.out.println("\nCarElementDoVisitor #####");
        car.accept(new CarElementDoVisitor());

        // Practice 11-1
//        System.out.println("CarElementDestroyVisitor #####");
//        car.accept(new CarElementDestroyVisitor());
    }
}

class Wheel implements ICarElement {
    private String name;
    public Wheel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Engine implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Body implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Car implements ICarElement {
    ICarElement[] elements;
    public Car() {
        this.elements = new ICarElement[] {
                new Wheel("front left"),
                new Wheel("front right"),
                new Wheel("back left"),
                new Wheel("back right"),
                new Body(),
                new Engine()
        };
    }
    public void accept(ICarElementVisitor visitor) {
        for(ICarElement elem : elements)
            elem.accept(visitor);
        visitor.visit(this);
    }
}

class CarElementPrintVisitor implements ICarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }
    public void visit(Body body) {
        System.out.println("Visiting body");
    }
    public void visit(Car car) {
        System.out.println("Visiting car");
    }
}

class CarElementDoVisitor implements ICarElementVisitor {
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }
    public void visit(Body body) {
        System.out.println("Moving my body");
    }
    public void visit(Car car) {
        System.out.println("Starting my car");
    }
}

/*
Practice 11-1. CarElementDestroyVisitor

Print following lines:
------
Destroying front left wheel
Destroying front right wheel
Destroying back left wheel
Destroying back right wheel
Destroying body
Destroying engine
Destroying car
 */
//class CarElementDestroyVisitor implements ICarElementVisitor {
//
//}

