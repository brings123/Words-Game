package TpSrc;

public class MultiChances extends Lettre implements Malus {
	private int nbrechec=0;
	public int getNbrechec() {
		return nbrechec;
	}
	public void setNbrechec(int nbrechec) {
		this.nbrechec = nbrechec;
	}
	
	public int veriflettre(char c)
	{
		if (getLetrre()==c)
		{
			return 1 ;
		}
		else
		{
			return 0;
		}
	}
	public int CalculerMalus()
	{
		if (getNbrechec()>0)
		{
			return getNbrechec()*2;
		}
		else 
		{
			return 0;
		}
	}
}
