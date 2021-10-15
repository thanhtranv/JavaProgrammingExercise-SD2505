package Exercise;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input, output;
		
		Scanner sc = new Scanner(System.in);
		
        System.out.print("Input text: ");
        
        input = sc.nextLine();
        
        String[] wordList = input.split(" ");
        
        for (int i = 0; i < wordList.length; i++) {
        	if (wordList[i].length() > 1) {
        		wordList[i] = wordList[i].substring(0, 1).toUpperCase() + wordList[i].substring(1);
        	}
        }
        
        output = String.join(" ", wordList);
        
        System.out.println("Output text: " + output);
	}

}
