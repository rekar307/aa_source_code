package headfirst.strategy;

public class Main {

	public static void main(String[] args) {

		MallardDuck mallard = new MallardDuck();
		RubberDuck rubberDuckie = new RubberDuck();
		DecoyDuck decoy = new DecoyDuck();
		ModelDuck model = new ModelDuck();
		Duck[] ducks = {mallard, model, rubberDuckie, decoy};

		for(Duck duck: ducks) {
			System.out.print(duck.getClass().getName() + ": ");
			duck.performQuack();
		}

		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

		// Practice 2-2
//		System.out.println("Practice 2-2 ######################");
//		model.setQuackBehavior(new DoubleQuack());
//		System.out.print(model.getClass().getName() + ": ");
//		model.performQuack();

		// Practice 2-3
//		System.out.println("Practice 2-3 ######################");
//		System.out.println("Before Setting EggBehavior ........ ");
//		for(Duck duck: ducks) {
//			duck.display();
//			duck.performEgg();
//			System.out.println("---");
//		}
//
//		System.out.println("After Letting MallardDuck Spawn ........ ");
//		mallard.setEggBehavior(new SpawnEgg());
//		for(Duck duck: ducks) {
//			duck.display();
//			duck.performEgg();
//			System.out.println("---");
//		}

		// Practice 2-4
//		System.out.println("Practice 2-4 ######################");
//		Duck[] ducks24 = {model, mallard};
//		mallard.setEggBehavior(new SpawnNothing());
//		for(Duck duck: ducks24) {
//			duck.display();
//			duck.performQuack();
//			duck.performFly();
//			duck.performEgg();
//			System.out.println("---");
//		}
//		System.out.println("After Copying MallardDuck to ModelDuck ........ ");
//		model.CopyBehavior(mallard);
//		mallard.setEggBehavior(new SpawnEgg());
//
//		for(Duck duck: ducks24) {
//			duck.display();
//			duck.performQuack();
//			duck.performFly();
//			duck.performEgg();
//			System.out.println("---");
//		}
	}
}

/*
headfirst.strategy.copy_behaviour.MallardDuck: Quack
headfirst.strategy.copy_behaviour.ModelDuck: Quack
headfirst.strategy.copy_behaviour.RubberDuck: Squeak
headfirst.strategy.copy_behaviour.DecoyDuck: << Silence >>
I can't fly
I'm flying with a rocket
Practice 2-2 ######################
headfirst.strategy.copy_behaviour.ModelDuck: Quack, Quack
Practice 2-3 ######################
Before Setting EggBehavior ........
I'm a real Mallard duck
I can't spawn :(
---
I'm a model duck
I can't spawn :(
---
I'm a rubber duckie
I can't spawn :(
---
I'm a duck Decoy
I can't spawn :(
---
After Letting MallardDuck Spawn ........
I'm a real Mallard duck
I have Spawned :)
---
I'm a model duck
I can't spawn :(
---
I'm a rubber duckie
I can't spawn :(
---
I'm a duck Decoy
I can't spawn :(
---
Practice 2-4 ######################
I'm a model duck
Quack, Quack
I'm flying with a rocket
I can't spawn :(
---
I'm a real Mallard duck
Quack
I'm flying!!
I can't spawn :(
---
After Copying MallardDuck to ModelDuck ........
I'm a model duck
Quack
I'm flying!!
I can't spawn :(
---
I'm a real Mallard duck
Quack
I'm flying!!
I have Spawned :)
---
 */