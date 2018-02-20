//package tema4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClass {

	public static void main(String[] args) {
		
		Info i = new Info();
		try {
			PrintWriter writer = new PrintWriter(new File("test.out"));
			String output = Formula.getFormula(i);
			System.out.println(output);
			writer.println(output);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
