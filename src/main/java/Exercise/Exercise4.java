package Exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Item {
	int price;
	String name;
	int total;
	
	public int caculate(int quantity) {
		total = quantity * this.price;
		return total;
	}
}

public class Exercise4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Item coca = new Item();
		Item noodle = new Item();
		Item orange = new Item();
		
		coca.name = "Coca";
		coca.price = 5000;
		
		noodle.name = "Noodle";
		noodle.price = 3000;
		
		orange.name = "Orange";
		orange.price = 7000;
		
		String filePath = new File("").getAbsolutePath();
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath + "/src/main/resources/Exercise4.txt"));
		FileWriter fileWriter = new FileWriter(filePath + "/src/main/resources/Exercise4Output.txt");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
		try
		{                           
		    String line = null; 
		    int totalAmount;
		    while ((line = reader.readLine()) != null)
		    {
		        if (!(line.startsWith("*")))
		        {
		        	String[] listLine = line.split(": ");
		        	String product = listLine[0].trim();
		        	String quantity = listLine[1].trim();
		        	
		        	if (product.trim().toLowerCase().equals(coca.name.toLowerCase())) {
		        		coca.caculate(Integer.parseInt(quantity));
		        		printWriter.printf("%s %s %d \n", coca.name, quantity, coca.total);
		        	}
		        	if (product.trim().toLowerCase().equals(noodle.name.toLowerCase())) {
		        		noodle.caculate(Integer.parseInt(quantity));
		        		printWriter.printf("%s %s %d \n", noodle.name, quantity, noodle.total);
		        	}
		        	if (product.trim().toLowerCase().equals(orange.name.toLowerCase())) {
		        		orange.caculate(Integer.parseInt(quantity));
		        		if (Integer.parseInt(quantity) > 2) {
		        			orange.total = orange.total - 5000;
		        		}
		        		printWriter.printf("%s %s %d \n", orange.name, quantity, orange.total);
		        	}
		        }
		    } 
		    
		    totalAmount = coca.total + noodle.total + orange.total;
		    printWriter.printf("============= \n");
		    printWriter.printf("Total %d", totalAmount);
		    printWriter.close();
		    System.out.println("Successfully Output caculation file!");
		}
		catch (IOException ex)
		{
		    ex.printStackTrace();
		}       
		
	}

}


