package headfirst.decorator.io.skeleton;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Input String :");
			try {
				int c;
				Scanner scanInput = new Scanner(System.in);
				String exampleString = scanInput.nextLine();
				InputStream inputStream =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));

				// 1. simple case :
				inputStream = new LowerCaseInputStream(inputStream) ;

				// 2. more decorators :
				// inputStream = new ShiftInputStream(new LowerCaseInputStream(new BufferedInputStream(inputStream)), 1);

				// 3. even more !:
				// inputStream = new ShiftInputStream(new ShiftInputStream(new LowerCaseInputStream(new BufferedInputStream(inputStream)), 4),-4);

				while ( (c = inputStream.read()) >= 0)
					System.out.print((char)c);

				System.out.println();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}