package deligation.practice;

public class Main {
	public static void main(String[] args) {
		Worker[] workers = { new Dog("Baduki"), new Cat("Nabi"), new Robot(), new Dog("Bulldog") };

       for (Worker worker : workers) {
           worker.doWork();
           ((Sayable) worker).say();
       }
	}
}


//public class Main {
//
//    public static void main(String[] args) {		//
//
////		for (Worker worker: workers) {
////			worker.doWork();
////			((Sayable)worker).say(); // will trigger exception for Insect
////		}
//
//        Worker[] workers = { new Dog("Baduki"), new Cat("Nabi"), new Robot(), new Dog("Bulldog"), new Insect() };
//        workers[0].setEmployeeType(new Manager());
//        workers[0].setSalary(500);
//        workers[1].setEmployeeType(new Regular());
//        workers[1].setSalary(200);
//        workers[2].setEmployeeType(new Regular());
//        workers[2].setSalary(300);
//        workers[3].setEmployeeType(new Regular());
//        workers[3].setSalary(500);
//        workers[4].setEmployeeType(new Regular());
//        workers[4].setSalary(500);
//
//        for (int i=0; i < workers.length; i++) {
//            Worker worker = workers[i];
//            System.out.println("worker [" + i + "] : " + worker + "'s previous salary = " + worker.getSalary());
//            workers[i].increaseSalary(10);
//            System.out.println("worker [" + i + "] : " + worker + "'s  increased salary = " + worker.getSalary());
//        }
//        System.out.println("............. 1 year later ...............");
//
//        // Now worker 3 got promoted!!
//        double prevSalary = workers[3].getSalary();
//        workers[3].setEmployeeType(new Manager(prevSalary));
//
//        for (int i=0; i < workers.length; i++) {
//            System.out.println("worker [" + i + "] : " + workers[i] + "'s  previous salary = " + workers[i].getSalary());
//            workers[i].increaseSalary(10);
//            System.out.println("worker [" + i + "] : " + workers[i] + "'s  increased salary = " + workers[i].getSalary());
//        }
//    }
//}


/* expected
worker [0] : deligation.Dog@7adf9f5f's previous salary = 500.0
worker [0] : deligation.Dog@7adf9f5f's  increased salary = 561.0
worker [1] : deligation.Cat@6ce253f1's previous salary = 200.0
worker [1] : deligation.Cat@6ce253f1's  increased salary = 220.0
worker [2] : deligation.Robot@53d8d10a's previous salary = 300.0
worker [2] : deligation.Robot@53d8d10a's  increased salary = 330.0
worker [3] : deligation.Dog@e9e54c2's previous salary = 500.0
worker [3] : deligation.Dog@e9e54c2's  increased salary = 550.0
worker [4] : deligation.Insect@65ab7765's previous salary = 500.0
worker [4] : deligation.Insect@65ab7765's  increased salary = 550.0
............. 1 year later ...............
worker [0] : deligation.Dog@7adf9f5f's  previous salary = 561.0
worker [0] : deligation.Dog@7adf9f5f's  increased salary = 628.1
worker [1] : deligation.Cat@6ce253f1's  previous salary = 220.0
worker [1] : deligation.Cat@6ce253f1's  increased salary = 242.0
worker [2] : deligation.Robot@53d8d10a's  previous salary = 330.0
worker [2] : deligation.Robot@53d8d10a's  increased salary = 363.0
worker [3] : deligation.Dog@e9e54c2's  previous salary = 550.0
worker [3] : deligation.Dog@e9e54c2's  increased salary = 616.0
worker [4] : deligation.Insect@65ab7765's  previous salary = 550.0
worker [4] : deligation.Insect@65ab7765's  increased salary = 605.0
 */