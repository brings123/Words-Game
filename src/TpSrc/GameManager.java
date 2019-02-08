package TpSrc;

import java.util.*;
public class GameManager {
	public Set<Joueur> players = new HashSet<Joueur>();
	public static Joueur meanPlayer = new Joueur();
	public Stage stage1;
	
	
	public void checkAccount(Joueur p) throws AcountExist
	{
		if(players.contains(p))
			throw new AcountExist();
	}
	
	public void createAccount(String username) throws AcountExist, FalsePseudoException
	{
		Joueur newPlayer = new Joueur();
		newPlayer.setPseudo(username);
		newPlayer.setMeilleurScaore(0);
		meanPlayer=newPlayer;
		checkAccount(meanPlayer);
		players.add(meanPlayer);
		
		System.out.println("Account created  "+ meanPlayer.getPseudo());
		//Joueur.writefile();
		
	}
	
	public void createGame() throws Exception
	{
		//Mot[] words = new Mot[10] ;//The list of words that we get from the file
		stage1 = new Stage("C:\\Users\\GATTAL\\Desktop\\Tp_Poo1\\src\\mots.poo");//entrer le chemin de fichier la 
		meanPlayer.setJeux(stage1);
	}
	
	public void connect(Joueur p)
	{
		try {
			checkAccount(p);
		} catch (AcountExist e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			meanPlayer=p;
		}
		
	}
}
