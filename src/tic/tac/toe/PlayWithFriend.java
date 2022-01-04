package tic.tac.toe;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class PlayWithFriend extends AnchorPane {

    protected Pane pane ;
    protected final Label playerName;

    boolean turnX = true;
   // flag lma el l3ba tnthy
    
    boolean playable = true;
    private Tile[][] board = new Tile[3][3];

        // el class da lkol square fe elboard w hwa el by7ot el X w O lma el user udos 3la el square 
        public class Tile extends StackPane{
         
            Text text = new Text();

        public Tile(){

           Rectangle border = new Rectangle(200,200);
           border.setFill(null);
           border.setStroke(Color.BLACK);
           setAlignment(Pos.CENTER);
           text.setFont(Font.font(72));
           getChildren().add(border);
           getChildren().add(text);


           setOnMouseClicked(event ->  {
               
               if (!playable){
                   return;
               }
               
               if(turnX==true){
                    drawX();
                    turnX= false;
               }
               else {
                   if(turnX==false){
                       drawO();
                       turnX=true;
                   }
               }              
           });
        }  

       private void drawX(){
           text.setText("X");
       }
          private void drawO(){
           text.setText("O");
       }
    }
    
        

    public PlayWithFriend(Stage stage) {

        pane = new Pane();

        playerName = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(700.0);

        playerName.setLayoutX(200.0);
        playerName.setLayoutY(20.0);
        playerName.setPrefHeight(35.0);
        playerName.setPrefWidth(300.0);
        playerName.setText(" ");
        playerName.setFont(new Font("Bell MT", 30.0));
        drawboard();
    
    }
         
    public void drawboard(){
        
        pane = new Pane();

        pane.setLayoutX(43.0);
        pane.setLayoutY(82.0);
        pane.setPrefHeight(400.0);
        pane.setPrefWidth(600.0);

        for(int i=0;i<3;i++){
                
            for (int j=0;j<3;j++){
                Tile tile = new Tile();
                tile.setTranslateX(j*200);
                tile.setTranslateY(i*200);
                pane.getChildren().add(tile);
                board[j][i] = tile;
            }
            
        }
        
    getChildren().add(pane);

    }

}


