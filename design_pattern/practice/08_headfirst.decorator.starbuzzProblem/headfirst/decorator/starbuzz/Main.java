package headfirst.decorator.starbuzz;

public class Main {
 
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
 
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + beverage3.cost());

		// (1) HouseBlend 커피에 Soy 1번, Mocha 2번, Whip 2번의 순서로 추가하여 가격 계산


		// (2) HouseBlend 커피에 위의 역순으로 추가하여 가격 계산


		// (3) HouseBlend 커피를 DarkRoast로 꾸미기 시도


		// (4) Mocha를 Beverage로 하여 Whip 추가 시도 후 가격 계산 – Mocha 생성자에 null 전달

	}
}