//[2/11/2012] Challenge #3 [easy]
//write a program that can encrypt texts with an alphabetical caesar cipher.
//this cipher can ignore numbers, symbols, whitespace

// august 20,2015
// by dostap

package easy3challenge;
import java.util.ArrayList;
import java.util.Scanner;

public class easy3 {

	public static void main(String[] args) {
		
		//declare variables
		Scanner scan = new Scanner(System.in);
		String answer = "";
		
		//ask user for input until they provide soemthign valid
		//either encrypt, decrypt or quit
		while(!answer.equalsIgnoreCase("d") || !answer.equalsIgnoreCase("e")
				|| !answer.equalsIgnoreCase("q"))
		{
		System.out.println("Press \"e\" to encrypt "
				+ ", press \"d\" to decrypt"
				+ ", or press \"q\" to quit");
		answer = scan.nextLine();
		
				if(answer.equalsIgnoreCase("e"))
				{
				encrypt();
				}
				else if (answer.equalsIgnoreCase("d"))
				{
				decrypt();
				}
				else
				{
					System.out.println("Invalid input");
				}
		}
	}
	

	public static void encrypt() {
		String sentence;
		String newSentence = "";
		String encryptedSentence = "";
		String encryptedSentenceWSpaces = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		ArrayList<Integer> spaces = new ArrayList<>();
		char character;
		char newCharacter;
		int shift; 
		int origPosition;
		int newPosition;
		String choice = "";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Press \"e\" to continue, press q to quit");
		choice = scan.nextLine();
		while(choice.equalsIgnoreCase("e"))
		{
		System.out.println("Input the sentence you want to encrypt: ");
		sentence = scan.nextLine();
		sentence = sentence.trim();
		System.out.println("Input the shift (right) you would like to use 1-25");
		shift = scan.nextInt();
		
		//clean up spaces in the input
		for(int i =0; i < sentence.length(); i++)
		{
			if(sentence.charAt(i) != ' ')
				newSentence += sentence.charAt(i);
			else if(sentence.charAt(i) == ' ')
			{
				spaces.add(i);
			}
		}
	
		System.out.println("Without spaces: " + newSentence);

		//encrypt
		for (int x = 0; x < newSentence.length(); x++)
		{
			character = newSentence.charAt(x); 
			
			origPosition = alphabet.indexOf(character);
			newPosition = origPosition + shift;
			//check if we exceed the length of the alphabet string
			if(newPosition > 25)
			{
				newPosition -=26;
			}
			newCharacter = alphabet.charAt(newPosition);
			encryptedSentence += newCharacter;
		}
		
		int a = 0;
		int h = 0;
		//reinsert spaces
		for(int v = 0; v < spaces.size(); v++)
		{
			int y = spaces.get(v) - h;
			encryptedSentenceWSpaces += encryptedSentence.substring(a, y);
			encryptedSentenceWSpaces += " ";
			a = y;
			h++;
		}
		
		encryptedSentenceWSpaces += 
				encryptedSentence.substring(a, encryptedSentence.length());
		
		System.out.println(encryptedSentenceWSpaces);
		choice = "y"; //reset choice that enables while loop
		System.out.println("\nPress \"e\" to continue encrypting, or \"q\" to quit encrypting");
		choice = scan.nextLine();
		}//end of while loop
		
		}
		
	public static void decrypt(){
			
			String sentence;
			String newSentence = "";
			String decryptedSentence = "";
			//String encryptedSentenceWSpaces = "";
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			ArrayList<Integer> spaces = new ArrayList<>();
			char character;
			char newCharacter;
			int shift; 
			int origPosition;
			int newPosition;
			
			String choice = "y";
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Press \"d\" to continue, press q to quit");
			choice = scan.nextLine();
			while(choice.equalsIgnoreCase("d"))
			{
				choice = "y";
			System.out.println("Input the sentence you want to decrypt: ");
			sentence = scan.nextLine();
			sentence = sentence.trim();
			
			//clean up spaces in the input
			for(int i =0; i < sentence.length(); i++)
			{
				if(sentence.charAt(i) != ' ')
					newSentence += sentence.charAt(i);
				else if(sentence.charAt(i) == ' ')
				{
					spaces.add(i);
				}
			}
		
			System.out.println("Without spaces: " + newSentence);
		
			//decrypt
			for(shift= 0; shift < 26; shift++)
			{
				for (int x = 0; x < newSentence.length(); x++)
				{
					character = newSentence.charAt(x); 
					origPosition = alphabet.indexOf(character);
					newPosition = origPosition - shift;
					//check if we have negative position
					if(newPosition < 0)
					{
						newPosition +=26;
					}
					newCharacter = alphabet.charAt(newPosition);
					decryptedSentence += newCharacter;
				}
				System.out.println("Shift of " + shift +": " + decryptedSentence);
				decryptedSentence = "";
			}//end of for loop
			System.out.println("\n Press \"d\" to continue decrypting, or \"q\" to quit decrypting");
			choice = scan.nextLine();
    }//end while loop
  }//end method body

}//end class
	
	
