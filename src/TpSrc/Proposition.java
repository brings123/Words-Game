package TpSrc;

public class Proposition extends ZeroChance implements Malus {
	private int echoue=0;
	public int getEchoue() {
		return echoue=0;
	}
	public void setEchoue(int echoue) {
		this.echoue = echoue;
	}
	public int veriflettre(char c)
	{
		if (getLetrre()==c)
		{
			return 2 ;
		}
		else
		{
			return 0;
		}
	}
	public int CalculerMalus()
	{
		if (getEchoue()==1)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
