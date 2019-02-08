package TpSrc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class NewGameCont implements Initializable ,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@FXML
    private ImageView Hungedman;

    @FXML
    private JFXButton Word1;

    @FXML
    private JFXButton Word10;

    @FXML
    private JFXButton Word9;

    @FXML
    private JFXButton Word8;

    @FXML
    private JFXButton Word7;

    @FXML
    private JFXButton Word6;

    @FXML
    private JFXButton Word5;

    @FXML
    private JFXButton Word4;

    @FXML
    private JFXButton Word3;

    @FXML
    private JFXButton Word2;
    
    @FXML
    private Label playername;

    @FXML
    private Label meilleurscore;

    @FXML
    private Label score;
    
    @FXML
    private JFXButton score1;
    
    @FXML
    void showscore(ActionEvent event) throws IOException {
    	Main.showscoreviewer();
    }
    
    @FXML
    void GoLetterChoice1(ActionEvent event) throws IOException {
    	Main.Choice.add(0);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice2(ActionEvent event) throws IOException {
    	Main.Choice.add(1);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice3(ActionEvent event) throws IOException {
    	Main.Choice.add(2);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice4(ActionEvent event) throws IOException {
    	Main.Choice.add(3);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice5(ActionEvent event) throws IOException {
    	Main.Choice.add(4);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice6(ActionEvent event) throws IOException {
    	Main.Choice.add(5);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice7(ActionEvent event) throws IOException {
    	Main.Choice.add(6);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice8(ActionEvent event) throws IOException {
    	Main.Choice.add(7);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice9(ActionEvent event) throws IOException {
    	Main.Choice.add(8);
    	Main.showLetterChoice();

    }
    
    @FXML
    void GoLetterChoice10(ActionEvent event) throws IOException {
    	Main.Choice.add(9);
    	Main.showLetterChoice();

    }

    
	public static void writefile(Set<Joueur> players)
	{
		 BufferedWriter writer = null;
	        try {
	            File logFile = new File("GamesAcounts.txt");

	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());

	            writer = new BufferedWriter(new FileWriter(logFile));
	            for(Joueur ga:players )
	            {
	            	String word = new String();
	            	word=ga.getPseudo()+";";
	            	word=word+ga.getMeilleurScaore()+";";
	            	for(int i :ga.getScorelist())
	            	{
	            		word=word+i+";";
	            	}
	            	 writer.write(word);
	            	 writer.newLine();
	            }   
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	}
	
	public static Set<Joueur> readfile()
	{
		Set<Joueur> players = new HashSet<Joueur>();
		 BufferedReader writer = null;
	        try {
	            File logFile = new File("GamesAcounts.txt");

	            // This will output the full path where the file will be written to...
	            System.out.println(logFile.getCanonicalPath());

	            //writer = new BufferedWriter(new FileWriter(logFile));
	            writer=new BufferedReader(new FileReader(logFile));
	            /*for(Joueur ga:players )
	            {
	            	String word = new String();
	            	word=ga.getPseudo()+";";
	            	for(int i :ga.getScorelist())
	            	{
	            		word=word+i+";";
	            	}
	            	 writer.write(word);
	            } */
	    		List<String> lines = new ArrayList<String>();
	    		String line = writer.readLine();
	    		while (line != null)
	    		{
	    		    lines.add(line);
	    		    line = writer.readLine();
	    		}
	    		for(String lin: lines)
	    		{
	    			int i=0;
	    			String[] accounts =lin.split(";");
	    			Joueur player = new Joueur();
    				ArrayList<Integer> score =new ArrayList<Integer>();
	    			for(String info:accounts)
	    			{
	    				if (i==0)
							try {
								player.setPseudo(info);
							} catch (FalsePseudoException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								break;
							}
	    				else if(i==1) player.setMeilleurScaore(Integer.parseInt(info));
	    				else 
	    				{
	    					score.add(Integer.parseInt(info));
	    				}
	    				i++;
	    			}
	    			player.setScorelist(score);
	    			players.add(player);
	    		}
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	        return players;
	}

   static void writeToFile(Set<Joueur> players) throws IOException {
        File f = new File(GameManager.meanPlayer.getPseudo()+"score");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        //for(Joueur p:players)
        //{
        	oos.writeObject(players);
        	//oos.writeObject("hello world");
        //}
        oos.flush();
        oos.close();
    }
    
    @SuppressWarnings("unchecked")
	static void ScanFile(Set<Joueur> players) throws IOException {
		
        File f = new File(GameManager.meanPlayer.getPseudo()+"score");
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(f));
        try {	
			players = (Set<Joueur>) oi.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        oi.close();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Set<Joueur> players = new HashSet<Joueur>();
		/*try {
			NewGameCont.writeToFile(Main.Game.players);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			NewGameCont.ScanFile(players);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Joueur p:players)
		{
			System.out.println(p.getPseudo());
			System.out.println(p.getScorelist().get(0));
		}*/
		
		//writefile(Main.Game.players);
		//players =readfile();
		//for(Joueur p:players)
		//{
			//System.out.println(p.getPseudo());
			//System.out.println(p.getScorelist().get(0));
		//}
		System.out.println(Main.fail);
		System.out.println(Main.Choice.size());
		
			
		
		playername.setText("Player :  "+ GameManager.meanPlayer.getPseudo());
		meilleurscore.setText("Best score:  "+GameManager.meanPlayer.getMeilleurScaore());
		score.setText("Score:  "+Main.Game.stage1.getCurrentScore());
		
		
		for(int i : Main.Choice)
		{
			switch(i)
			{
			case 0:
				Word1.setDisable(true);
				break;
			case 1:
				Word2.setDisable(true);
				break;
			case 2:
				Word3.setDisable(true);
				break;
			case 3:
				Word4.setDisable(true);
				break;
			case 4:
				Word5.setDisable(true);
				break;
			case 5:
				Word6.setDisable(true);
				break;
			case 6:
				Word7.setDisable(true);
				break;
			case 7:
				Word8.setDisable(true);
				break;
			case 8:
				Word9.setDisable(true);
				break;
			case 9:
				Word10.setDisable(true);
				break;
			}
		}
		
	}

}