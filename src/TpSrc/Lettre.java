package TpSrc;

abstract public class Lettre implements Malus {
	private char letrre;
	private int score=0;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	abstract int veriflettre(char c) ;
	public char getLetrre() {
		return letrre;
	}
	public void setLetrre(char letrre) {
		this.letrre = letrre;
	}
	public int CalculerMalus()
	{
		return 0;
	}
	public void setEchoue(int echoue) {
		
	}
	public void setNbrechec(int nbrechec) {
		
	}
	
	public int getNbrechec() {
		return 0;
		
	}
	
}

