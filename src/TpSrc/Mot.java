package TpSrc;


import java.util.LinkedList;
import java.util.List;
public class Mot {
	private String typeIndic;
	private String Indication;
	private List <Lettre> letters = new LinkedList<Lettre>();
	private int score=0;
	private int somme=0;
	public int calculateScore()
	{
		int n=0,m=0;
		for(Lettre a:letters)
		{
			n=a.getScore();
		
		if (Indication.equals("definition"))
		{
			n=n*3;
		}
		else
			if (Indication.equals("synonyme"))
			{
				n=n*2;
			}
			else
			{
				n=n*1;
			}
		m=m+n;
		}
		for(Lettre b:letters)
		{
			if (getSomme()>5)
			{
				m=m-b.CalculerMalus();
			}
		}
		score=m;
		return m;
	}
	public String getTypeIndic() {
		return typeIndic;
	}
	public void setTypeIndic(String typeIndic) {
		this.typeIndic = typeIndic;
	}
	public String getIndication() {
		return Indication;
	}
	public void setIndication(String indication) {
		Indication = indication;
	}
	public List<Lettre> getLetters() {
		return letters;
	}
	public void setLetters(List<Lettre> letters) {
		this.letters = letters;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSomme() {
		return somme;
	}
	public void setSomme() {
		for(Lettre a:letters)
		{
			if(a instanceof MultiChances || a instanceof Proposition) somme++;
		}
	}
	
}
