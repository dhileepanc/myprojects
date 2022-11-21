import java.util.InputMismatchException;
import java.util.Scanner;

public class flames {
	public static void main(String[] args) {

		// get both user and another name
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter male/ Female Name :");
			String Fname = sc.nextLine();
			
			if (Fname == "") {
				System.out.println("please enter your name");
			}
			
			System.out.println("Enter your opppsite Name :");
			String Sname = sc.nextLine();
			
			if (Sname == "") {
				System.out.println("please enter your name");
			}
//	String Fname="Dhileepan";
//	String Sname="Dhileep";

			// merge both names
			String merge = Fname.concat(Sname);

			char mn[] = merge.toCharArray();

			// System.out.println(mn[10]);

			// Strings are split by character
			for (char c1 : mn) {
				System.out.print(c1 + " ");
			}

			// Check the length of the char array

			int len = mn.length;

			System.out.println();

			int count1 = 0;

			// for checking how many letters same on the character

			for (int i = 0; i < mn.length; i++) {
				int x = mn[i];
				int count = 0;

				for (int j = 0; j < mn.length; j++) {
					// if the same letter on the char array count increase
					if (mn[j] == x) {
						count++;
//				System.out.print(count);
					}
				}

				// if letter placed on the char array one time, this statement executed
				if (count == 1) {
					count1++;
//		System.out.print("\n if case :"+count);
//		System.out.print(mn[i]);

				}

			}
			// how many single letters placed on the char array
			System.out.println(count1);

			// for choosing which sentence correct by FLAMES
			switch (count1) {
			case 1:
			case 7:
			case 13:
			case 19:
				System.out.println("You are FRIEND with " + Sname);
				break;
			
			case 2:
			case 8:
			case 14:
			case 20:
				System.out.println("You are Love with " + Sname);
				break;
			
			case 3:
			case 9:
			case 15:
			case 21:
				System.out.println("You are Just Affection with " + Sname);
				break;
			
			case 4:
			case 10:
			case 16:
			case 22:
				System.out.println("You are going to marry " + Sname);
				break;
			
			case 5:
			case 11:
			case 17:
			case 23:
				System.out.println("Your Enemy " + Sname);
				break;
			
			case 6:
			case 12:
			case 18:
			case 24:
				System.out.println("Your Sister/Brother with " + Sname);
				break;

			}
		} catch (NullPointerException ne) {
			System.out.println("Please enter your name");
		} catch (InputMismatchException im) {
			System.out.println("please enter names only");
		}

	}
}
