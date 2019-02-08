package TpSrc;


import java.io.Serializable;
import java.util.ArrayList;

public class Joueur  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Pseudo;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pseudo == null) ? 0 : Pseudo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (Pseudo == null) {
			if (other.Pseudo != null)
				return false;
		} else if (!Pseudo.equals(other.Pseudo))
			return false;
		return true;
	}
	
	private int MeilleurScaore;
	private Stage Jeux;
	private ArrayList<Integer> scoreListe = new ArrayList<Integer>();
	
	public void saveScore(int score)
	{
		scoreListe.add(score);
	}
	public ArrayList<Integer> getScorelist()
	{
		return scoreListe;
	}
	public void setScorelist(ArrayList<Integer> score)
	{
		this.scoreListe=score;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setPseudo(String pseudo) throws FalsePseudoException {
		if(Character.isLetter(pseudo.charAt(0))) Pseudo = pseudo;
		else throw new FalsePseudoException();
	}

	public int getMeilleurScaore() {
		return MeilleurScaore;
	}

	public void setMeilleurScaore(int meilleurScaore) {
		MeilleurScaore = meilleurScaore;
	}

	public Stage getJeux() {
		return Jeux;
	}
	
	public void setJeux(Stage jeux) {
		Jeux = jeux;
	}
	
	

}
