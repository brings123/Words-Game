package TpSrc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Stage {
	private int currentScore;
	public static Mot[] words = new Mot[10] ;
	
	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	
	public int calculateTotalScore()
	{
		int score=0;
		for(Mot word:words)
		{
			score=score+word.getScore();
		}
		currentScore=score;
		return currentScore;
	}

	public Stage(String filePath) throws Exception {
		super();
		this.currentScore = 0;
		
		Stage.words=scanWords(filePath);
	}
	public Mot[] scanWords(String filePath) throws Exception
	{
		Mot[] words = new Mot[10] ;
		Set<Integer> indexs = new HashSet<>();
		List<String> lines = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		String line = in.readLine();
		while (line != null)
		{
		    lines.add(line);
		    line = in.readLine();
		}
		in.close();
		int l=0;
		while(indexs.size() <10)
		{
			int ind = ThreadLocalRandom.current().nextInt(0, lines.size());
			String tmp[]=new String[3];
			
			tmp=StringDevider(lines.get(ind));
			if(!indexs.contains(ind) && tmp[2].length()>6 )
			{
				int somme=0;
				Lettre a =null;
				List <Lettre> letters = new LinkedList<Lettre>();
				Mot mot = new Mot();
				mot.setTypeIndic(tmp[0]);
				for (int i=0;i<tmp[2].length();i++)
				{
					int typ;
					if(!(somme<3)) typ =2;
					else typ = ThreadLocalRandom.current().nextInt(1, 4);
					switch (typ)
					{
					case 1:
						a = new Proposition();
						somme++;
						break;
					case 2:
						a = new MultiChances();
						break;
					case 3: 
						a=new ZeroChance();
						somme++;
						break;
					}
					a.setLetrre(tmp[2].charAt(i));
					letters.add(a);
				}
				mot.setLetters(letters);
				mot.setIndication(tmp[1]);
				mot.setSomme();
				words[l]=mot;
				indexs.add(ind);
				l++;
			}
		}
			return words;
	}
	
	public String[] StringDevider(String str)
	{
		String tmp[]=new String[3];
		int indice=0;
		for (int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==';')
			{
				indice++;
			}
			else 
			{
				if(tmp[indice]==null) tmp[indice]=""+str.charAt(i);
				else tmp[indice]=tmp[indice]+str.charAt(i);
			}
		}
		return tmp;
	}
	
	
	

}
