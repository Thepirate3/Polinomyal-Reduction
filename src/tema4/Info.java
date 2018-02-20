//package tema4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Info {

	int number_nodes;
	int number_edges;
	int number_colors;
	List<Edges> edges = new ArrayList<Edges>();
	
	public Info() {
		BufferedReader buffer;
		String line = null;
		try {
			buffer = new BufferedReader(new FileReader(new File("test.in")));

			line = buffer.readLine();
			String[] sizes = line.split(" ");

			number_nodes = Integer.parseInt(sizes[0]);
			number_edges = Integer.parseInt(sizes[1]);
			number_colors = Integer.parseInt(sizes[2]);
			
			int first = 0; 
			int second = 0;
			for(int i=0;i<number_edges;i++) {
				line = buffer.readLine();
				sizes = line.split(" ");
				
				first = Integer.parseInt(sizes[0]);
				second = Integer.parseInt(sizes[1]);
				edges.add(new Edges(first, second));
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
