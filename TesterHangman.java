import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class TesterHangman {
	public static void main(String[] args) {
		//Intro
		System.out.println("Hello, It is your turn to test your wits, by tring to save the dear Hangmsn's life.");
		System.out.println("You will have to input letters and guess word to save the hangman, if you guess wrong six times however,");
		System.out.println("..............");
		System.out.println("You will have the blood of the hangman on your hands...");
		boolean exit=false;
		int numofplay=0;
		//mainloop
		while(!exit) {
			int playagain=0;
			String word = null;
			String FileToAnalyze ="C:\\Users\\ferra\\Desktop\\CS 110\\Lab Javas\\Final Project\\src\\words.txt";
			int randomint = ThreadLocalRandom.current().nextInt(0, 2623);
			Scanner input = new Scanner(System.in);
			try {
				FileReader myFileReader=new FileReader(FileToAnalyze);
				BufferedReader myBufferReader=new BufferedReader(myFileReader);
				for(int i=0; i<randomint;i++) {
					word=myBufferReader.readLine();
				}
				word=word.toLowerCase();
			}
			catch(Exception ex) {
				System.out.println("Cant find word file");
			}
			
			System.out.println("How many players will be participating, 1 or 2");
			numofplay=input.nextInt();
			
			if(numofplay==1) {
				System.out.println("Ok then, we will randomly pick a word for you then, Good luck!");
				Hangman.letsPlay(word);
			}
			else if(numofplay==2){
				System.out.println("Ok then, Player 1 will input the word for player 2 to guess, Good luck Player 2!");
				word=input.next();
				
				for(int i=0; i<1000; i++) {
					System.out.println("");
				}
				
				word=word.toLowerCase();
				Hangman.letsPlay(word);
			}
			//Play Again?
			System.out.println("Would you like to Play again? 1 means yes, 0 means no.");
			playagain=input.nextInt();
			
			if(playagain==0) {
				exit=true;
			}
		}
		//Outro
		System.out.println("Thanks for Playing!");
	}
}
