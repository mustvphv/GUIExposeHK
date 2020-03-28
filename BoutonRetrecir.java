import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Text;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.scene.effect.DropShadow;




public class BoutonRetrecir{

    public Circle circle1 = new Circle(250,250,120);

    BoutonAgrandir btnAgrandirHandle = new BoutonAgrandir();

    public BoutonRetrecir(){
    }


    public void ActionAppuieSurBoutonRetrecir(HBox hbox, ActionEvent event, File file, Integer niveau){
        hbox.getChildren().remove(hbox.lookup(".cercle1"));


        String fileUrl = file.toURI().toString();
        Image image1 = new Image(fileUrl);

        ImageView ip = new ImageView(image1);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        this.circle1.setStroke(Color.SEAGREEN);
        this.circle1.setFill(new ImagePattern(image1));

        this.circle1.setTranslateY(70);
        this.circle1.setTranslateX(175);
        this.circle1.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        hbox.getChildren().remove(hbox.lookup(".cercle1"));
        this.circle1.getStyleClass().add("cercle1");
        hbox.getChildren().add(this.circle1);
        //System.out.println(this.circle1);


        this.circle1.setRadius(niveau);
        this.btnAgrandirHandle.diminueNiveauAgrandissement();

        //System.out.println("btnAgrandirHandle=" + btnAgrandirHandle.getNiveauAgrandissement());


    }







}
