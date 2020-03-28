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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;






public class BoutonFiltre2{

    public Circle circle1 = new Circle(250,250,120);

    public BoutonFiltre2(){
    }


    public void ActionAppuieSurBoutonFiltre2(HBox hbox, ActionEvent event, File file, Integer niveau){
        hbox.getChildren().remove(hbox.lookup(".cercle1"));


        String fileUrl = file.toURI().toString();
        Image image1 = new Image(fileUrl);

        ImageView ip = new ImageView(image1);
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);


        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(2.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(60, 60, Color.GREEN));

        this.circle1.setEffect(lighting);

        this.circle1.setStroke(Color.SEAGREEN);
        this.circle1.setFill(new ImagePattern(image1));

        this.circle1.setTranslateY(70);
        this.circle1.setTranslateX(175);
        hbox.getChildren().remove(hbox.lookup(".cercle1"));
        this.circle1.getStyleClass().add("cercle1");
        hbox.getChildren().add(this.circle1);
        //System.out.println(this.circle1);


        this.circle1.setRadius(niveau);

    }







}
