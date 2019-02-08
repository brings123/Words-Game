package TpSrc;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) throws Exception {
		String username =new String();
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		username=sc.nextLine();
		GameManager Game = new GameManager();
		//Game.createAccount(username);
		Game.createGame();
		Mot[] words = new Mot[10];
		//words=Game.stage1.getWords();
		int score=0;
		for(Mot a:words)
		{
			System.out.println(a.getIndication());
			System.out.println(a.getTypeIndic());
			for(int i=0;i<a.getLetters().size();i++)
			{
				System.out.println("Guess the letter :");
				String c=sc.next();
				score = a.getLetters().get(i).veriflettre(c.charAt(0));
				a.getLetters().get(i).setScore(score);
				if (a.getLetters().get(i) instanceof Proposition)
				{
					
					if (score==0)
					{
						a.getLetters().get(i).setEchoue(1);
						System.out.println("Vous avez échoué dans ce mot!");
						break;
					}
					else System.out.println("congrats le lettre est correcte");
				}
				else if (a.getLetters().get(i) instanceof MultiChances)
				{
						int nb=1;	
						while (score==0&&nb<=3)
						{
							a.getLetters().get(i).setNbrechec(nb);
							score=a.getLetters().get(i).veriflettre(c.charAt(0));
							if(score!=0) break;
							if(nb<3)
							{
								System.out.println("ReGuess the letter :");
								c=sc.next();
							}
							nb++;
						}
						a.getLetters().get(i).setScore(score);
						if(score==0)
						{
							System.out.println("vous avez échoué dans ce mot!");
							break;
						}
						else System.out.println("congrats le lettre est correcte");
				}
				else 
				{
					if (score==0)
					{
						break;
					}
					else System.out.println("congrats le lettre est correcte");
				}
			}
			if(score!=0) System.out.println("congrats le mot est correcte");
		}
		sc.close();
	}
	
}
