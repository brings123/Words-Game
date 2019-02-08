package TpSrc;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class NewStageCont implements Initializable {

	ArrayList<Node> fill = new ArrayList<Node>();
    @FXML
    private GridPane GridPane;

    @FXML
    private Label indic;

    @FXML
    private Label indicType;
    
    @FXML
    void Return(ActionEvent event) throws IOException {
    	Main.showStage();
    }

    public void won()
    {
    	boolean valid=false;
		for(Node n:GridPane.getChildren())
		{
			if(n.isDisabled()) 
			{
				valid=true;
			}
			else
			{
				valid=false;
				break;
			}
		}
		if(valid)
		{
			indic.setText("You have got the right word, good work");
			Task<Void> sleeper1 = new Task<Void>() {
    			@Override
    			protected Void call() throws Exception {
    				try {
    					Thread.sleep(2000);
    				} catch (InterruptedException e) {
    				}
    				return null;
    			}
    		};
    		sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    			public void handle(WorkerStateEvent event) {
    				if(Main.fail>=6||Main.Choice.size()>9)
    				{
    					System.out.println(Main.fail);
    					System.out.println(Main.Choice.size());
    					try {
    						Main.showScore();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    				}
    				else
    				try {
						Return(null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	
    			}
    		});
    		new Thread(sleeper1).start();
		}
    }
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int i=0,j=0;
		int score=0;
		indicType.setText(Stage.words[Main.Choice.get(Main.Choice.size()-1)].getTypeIndic());
		indic.setText(Stage.words[Main.Choice.get(Main.Choice.size()-1)].getIndication());
		for(Lettre c: Stage.words[Main.Choice.get(Main.Choice.size()-1)].getLetters())
		{
			if(j==5)
			{
				i++;
				j=0;
			}
			if((c instanceof ZeroChance ||c instanceof MultiChances) && !(c instanceof Proposition) )
			{
				System.out.println(c.getLetrre());
				GridPane.add(new JFXTextField(),j,i);
			}
			else 
			{
				System.out.println(c.getLetrre()+"dddddddddddddddddddddddddddc");
				GridPane.add(new JFXComboBox<String>(),j,i);
			}
			j++;
		}
		for(int l=0;l<Stage.words[Main.Choice.get(Main.Choice.size()-1)].getLetters().size();l++)
		{
			if(GridPane.getChildren().get(l) instanceof JFXTextField)
			{
				JFXTextField a = (JFXTextField) GridPane.getChildren().get(l);
				System.out.println(",,,,,,,,,,,,,,,,,,,jjjjjjjjjjjjjjjj"+a.getText());
				Lettre c = Stage.words[Main.Choice.get(Main.Choice.size()-1)].getLetters().get(l);
				System.out.println("Scoreword : "+Stage.words[0].getLetters().get(0).getScore());
				if(!a.getText().equals(""))score = c.veriflettre(a.getText().charAt(0));
				else score=0;
				//c.setScore(score);
				a.setLabelFloat(true);
				if(c instanceof MultiChances) a.setPromptText("Multi Chances");
				else if(c instanceof ZeroChance) a.setPromptText("Zero Chance");
				a.focusedProperty().addListener(new ChangeListener<Boolean>()
				{
				    @Override
				    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
				    {
				        if (newPropertyValue)
				        {
				            System.out.println("Textfield on focus");
				            a.setText("");
				        }
				        else
				        {
				            System.out.println("Textfield out focus");
				        }
				    }
				});
				
				GridPane.getChildren().get(l).setOnKeyPressed(new EventHandler<KeyEvent>() {
					
					
					@Override
					public void handle(KeyEvent arg0) {
						int score1=0;
						if(arg0.getCode()==KeyCode.ENTER)
						{
							if(!a.getText().equals(""))score1 = c.veriflettre(a.getText().charAt(0));
							c.setScore(score1);
							
							//Stage.words[Main.Choice.get(Main.Choice.size()-1)].calculateScore();
							System.out.println("Score : "+c.getScore());
							for(Mot word:Stage.words)
							{
								word.calculateScore();
							}
							Main.Game.stage1.calculateTotalScore();
							if(GameManager.meanPlayer.getMeilleurScaore()<Main.Game.stage1.getCurrentScore()) GameManager.meanPlayer.setMeilleurScaore(Main.Game.stage1.getCurrentScore());
							if(c.getLetrre() == a.getText().charAt(0))
							{
								System.out.println(",,,,,,,,,,,,,,,,,,,jjjjjjjjjjjjjjkkkkkkkkkkkkkkkkk"+a.getText());
								a.setText(a.getText()+"  Correct");
								a.setStyle("-fx-text-inner-color: green;");
								a.setDisable(true);
								won();
							}
							else 
							{
								System.out.println(",,,,,,,,,,,,,,,,,,,jjjjjjjjjjjjjjkkkkkkkkkkkkkkkkk"+a.getText());
								a.setText(a.getText()+"  Wrong");
								a.setStyle("-fx-text-inner-color: red;");
								if(c instanceof ZeroChance)
								{
									a.setDisable(true);
									GridPane.setDisable(true);
									indic.setText("You Failed in this word ");
									Main.fail++;
									Task<Void> sleeper1 = new Task<Void>() {
				            			@Override
				            			protected Void call() throws Exception {
				            				try {
				            					Thread.sleep(2000);
				            				} catch (InterruptedException e) {
				            				}
				            				return null;
				            			}
				            		};
				            		sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
				            			public void handle(WorkerStateEvent event) {
				            				
				            				if(Main.fail>=6||Main.Choice.size()>9)
				            				{
				            					System.out.println(Main.fail);
				            					System.out.println(Main.Choice.size());
				            					try {
				            						Main.showScore();
				            					} catch (IOException e) {
				            						// TODO Auto-generated catch block
				            						e.printStackTrace();
				            					}
				            				}
				            				else
				            				try {
												Return(null);
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
				    	            	
				            			}
				            		});
				            		new Thread(sleeper1).start();
							            		
							            	
									
								}
								else
								{
									if(c.getScore()==0 && c.getNbrechec()<2)
									{
										c.setNbrechec(c.getNbrechec()+1);
										//score=c.veriflettre(a.getText().charAt(0));
									}
									else if(c.getNbrechec()==2)
									{
										a.setDisable(true);
										GridPane.setDisable(true);
										indic.setText("You Failed in this word ");
										Main.fail++;
										Task<Void> sleeper1 = new Task<Void>() {
					            			@Override
					            			protected Void call() throws Exception {
					            				try {
					            					Thread.sleep(2000);
					            				} catch (InterruptedException e) {
					            				}
					            				return null;
					            			}
					            		};
					            		sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
					            			public void handle(WorkerStateEvent event) {
					            				if(Main.fail>=6||Main.Choice.size()>9)
					            				{
					            					System.out.println(Main.fail);
					            					System.out.println(Main.Choice.size());
					            					try {
					            						Main.showScore();
					            					} catch (IOException e) {
					            						// TODO Auto-generated catch block
					            						e.printStackTrace();
					            					}
					            				}
					            				else
					            				try {
													Return(null);
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
					    	            	
					            			}
					            		});
					            		new Thread(sleeper1).start();
									}
									//a.getLetters().get(i).setScore(score);
									//if(k==2) a.setDisable(true);
								}
							}
						}
						
					}
				});
				
			}
			else if(GridPane.getChildren().get(l) instanceof JFXComboBox<?>)
			{
				Lettre c = Stage.words[Main.Choice.get(Main.Choice.size()-1)].getLetters().get(l);
				JFXComboBox<String> a = (JFXComboBox<String>) GridPane.getChildren().get(l);
				System.out.println(a.getValue());
				if(!(a.getValue()==null))score =c.veriflettre(a.getValue().charAt(0));
				else score=0;
				//c.setScore(score);
				List<String> letters = new ArrayList<String>();
				a.setPromptText("Propositions");
				a.setLabelFloat(true);
				String Alphabet = "abcdefghijklmnopqrstuvwxyz";
				letters.add(""+Stage.words[Main.Choice.get(Main.Choice.size()-1)].getLetters().get(l).getLetrre());
				while(letters.size()!=4)
				{
					int guess = ThreadLocalRandom.current().nextInt(0, 26);
					if(!letters.contains(""+Alphabet.charAt(guess)))letters.add(""+Alphabet.charAt(guess));
				}
				Collections.sort(letters);
				a.setItems(FXCollections.observableArrayList(letters));
				GridPane.getChildren().get(l).setOnKeyPressed(new EventHandler<KeyEvent>() {
					
					
					@Override
					public void handle(KeyEvent arg0) {
						int score1=0;
						if(arg0.getCode()==KeyCode.ENTER)
						{
							if(!(a.getValue()==null)) score1 =c.veriflettre(a.getValue().charAt(0));
							c.setScore(score1);
							for(Mot word:Stage.words)
							{
								word.calculateScore();
							}
							Main.Game.stage1.calculateTotalScore();
							if(GameManager.meanPlayer.getMeilleurScaore()<Main.Game.stage1.getCurrentScore()) GameManager.meanPlayer.setMeilleurScaore(Main.Game.stage1.getCurrentScore());
							//Stage.words[Main.Choice.get(Main.Choice.size()-1)].calculateScore();
							System.out.println("Score : "+c.getScore());
							System.out.println("Score : "+Stage.words[Main.Choice.get(Main.Choice.size()-1)].getScore());
							if(c.getLetrre() == a.getValue().charAt(0))
							{
								System.out.println(",,,,,,,,,,,,,,,,,,,jjjjjjjjjjjjjjkkkkkkkkkkkkkkkkk"+a.getValue());
								a.setPromptText(a.getValue()+"  Correct");
								a.setValue("");
								a.setStyle("-fx-text-inner-color: green;");
								a.setDisable(true);
								won();
							}
							else 
							{
								System.out.println(",,,,,,,,,,,,,,,,,,,jjjjjjjjjjjjjjkkkkkkkkkkkkkkkkk"+a.getValue());
								a.setPromptText(a.getValue()+"  Wrong");
								a.setValue("");
								a.setStyle("-fx-text-inner-color: red;");
								a.setDisable(true);
								c.setEchoue(1);
								GridPane.setDisable(true);
								Main.fail++;
								indic.setText("You Failed in this word ");
								Task<Void> sleeper1 = new Task<Void>() {
			            			@Override
			            			protected Void call() throws Exception {
			            				try {
			            					Thread.sleep(2000);
			            				} catch (InterruptedException e) {
			            				}
			            				return null;
			            			}
			            		};
			            		sleeper1.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			            			public void handle(WorkerStateEvent event) {
			            				if(Main.fail>=6||Main.Choice.size()>9)
			            				{
			            					System.out.println(Main.fail);
			            					System.out.println(Main.Choice.size());
			            					try {
			            						Main.showScore();
			            					} catch (IOException e) {
			            						// TODO Auto-generated catch block
			            						e.printStackTrace();
			            					}
			            				}
			            				else
			            				try {
											Return(null);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
			    	            	
			            			}
			            		});
			            		new Thread(sleeper1).start();
								
								
							}
							
						}
						
					}
				});
				
			}
			
		}
		
		
		
		
	}

}


