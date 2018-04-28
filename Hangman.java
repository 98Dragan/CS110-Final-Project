import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

public static void letsPlay(String word) {
	
	//The following two arrays are essential for displaying the in the draw method
	//Creates and fills array with dashes.
	String dashes[]= new String[word.length()];
	for (int i=0;i<word.length();i++) {
		dashes[i]="-";
	}
	//Creates array for Letters
	String currentLetters[] = new String[word.length()];
	for (int i=0;i<word.length();i++) {
		currentLetters[i]=" ";
	}
	
	
	//Creates array for used letters
	ArrayList<Character> NoDuplicates= new ArrayList<Character>();
	
	//This makes sure that our arraylist is not empty for the first run through of the code
	//Since 0 is not a playable character, it will have no effect on the game
	NoDuplicates.add('0');
	

//Initializes Scanner
	Scanner input = new Scanner(System.in);
	
//First draw of the hangman board
	int error=0;
	Draw(error,dashes,currentLetters);
	
//This while loop starts the game, if error =6 or correctCounter = the length of the word, the game is over
	int correctCounter=0;
	while (error < 6) {

//The Compiles the user input and selects their letter 
		System.out.println("Please input a letter, if you input more than one character, then the code will only use the first character");
		String userInput=input.next();
		Character letter=userInput.toLowerCase().charAt(0);
		System.out.println("You have chosen: " + letter);
		
		
//This checks to see if the input letter already exists
boolean alreadyUsed=characterChecker(letter,NoDuplicates);

		//This adds the letter they chose to the array of letters that exist		
		NoDuplicates.add(letter);
		
		//If the letter didn't match any of the letters in the duplicate array, the code can continue
		if (!alreadyUsed) {
			
			//If the letter is a letter between a and z, the code can continue	
			if (letter >='a' && letter<='z')  {
			
			//Correct corresponds to whether or not the letter is in the word, is default set to zero in case it never appears in the word
					int correct=0;
					
			//This Checks where if at all the input matches a letter in the word
				
					for (int i=0;i<word.length();i++) {	
						if (word.charAt(i)==letter) {
							currentLetters[i]=letter.toString();
							correct=1;
							correctCounter++;
							}
						
					}
			
		//If the letter didn't match any letters in the word, error is incremented and the new hangman is drawn			

		if (correct==0) {
			System.out.println("Im sorry user, that letter is not in the word");
			error++;
			Draw(error,dashes,currentLetters);
		}
		
		//If the letter did match letters in the word, error is not incremented
		
		else if (correct==1) {
			System.out.println("Congrats user, that letter was in your word");
			Draw(error,dashes,currentLetters);
		}
		
		//This is if the user lost the game
		if (error == 6) {
			System.out.println("You have lost and now will forever regret the fact that the blood \nof the hangman is now on your hands, \nthe correct word was " + word + ". \n");
		}
		
			//This is if the user won the game
			if (correctCounter==word.length()) {
				System.out.println("Congrats User, you have won");
				error=6;
			}

		}
		
		//This is if the input is not a letter
		else if (letter<'a' || letter>'z' ) {
			System.out.println("Im sorry to inform you that " + letter + " isn't a letter");
		}
		
		}
		//This is if the user already input this letter
		else if (alreadyUsed) {
			System.out.println("Really? You already input " + letter);
		}
	}
}



public static boolean characterChecker(Character letter,ArrayList<Character> Array) {
	
	boolean alreadyUsed = false;
	for (int i=0;i<Array.size();i++) {
		if (letter==Array.get(i)) {
			alreadyUsed=true;
		}
		}
	return alreadyUsed;
	}

public static void Draw(int Error,String dashes[],String letters[]) {
	if (Error==0) {
	System.out.println("                            ");
	System.out.println("		---------------     ");
	System.out.println("		|              |    ");
	System.out.println("		|              |    ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("		|                   ");
	System.out.println("	=============           ");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}

	//Stage 1
	if (Error==1) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\" );
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|           ");
	System.out.println("	|            ");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}
	


	//Stage 2

	if (Error==2) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\"); 
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|              _|_");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               ");
	System.out.println("	|               ");
	System.out.println("	|               ");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}

	//Stage 3
	if (Error==3) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\"); 
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|              _|_");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|              / ");
	System.out.println("	|             /  ");
	System.out.println("	|            / ");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}
	
	//Stage 4
	if (Error==4) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\"); 
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|              _|_");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|               |");
	System.out.println("	|              / \\");
	System.out.println("	|             /   \\");
	System.out.println("	|            /     \\");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}

	//Stage 5
	if (Error==5) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\"); 
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|              _|_");
	System.out.println("	|             / |");
	System.out.println("	|            /  |");
	System.out.println("	|           /   |");
	System.out.println("	|               |");
	System.out.println("	|              / \\");
	System.out.println("	|             /   \\");
	System.out.println("	|            /     \\");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}
	//Stage 6
	if (Error==6) {
	System.out.println("	---------------");
	System.out.println("	|              |");
	System.out.println("	|              |");
	System.out.println("	|              --");
	System.out.println("	|            / x x\\"); 
	System.out.println("	|           |      |");
	System.out.println("	|           | ---- |");
	System.out.println("	|           \\      /");
	System.out.println("	|            \\____/");
	System.out.println("	|              _|_");
	System.out.println("	|             / | \\");
	System.out.println("	|            /  |  \\");
	System.out.println("	|           /   |   \\");
	System.out.println("	|               |");
	System.out.println("	|              / \\");
	System.out.println("	|             /   \\");
	System.out.println("	|            /     \\");
	System.out.println("	|");
	System.out.println("=============");
	
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(letters[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	System.out.print("                                      ");
	for (int i=0;i<dashes.length;i++) {
		System.out.print(dashes[i]);
		System.out.print(" ");
	}
	System.out.print("\n");
	}
}
}



