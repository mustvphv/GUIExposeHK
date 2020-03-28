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



public class Main extends Application implements EventHandler<KeyEvent> {
    public static void main(String[] args) {
        launch(args);
    }
   
    Text text = new Text();

    private int newY = 100;
    private int newX = 100;
    public File file;
    public String currentFileStatus = "sans filtre";

    String filenameAvant = new String("null");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");

        Button btn = new Button();
        btn.setText("Fichier");

        primaryStage.setTitle("Exemple d'un logiciel utilisant ExposeHK");

        Button boutonAgrandir = new Button("Agrandir l'image");
        boutonAgrandir.setDisable(true);

        Button boutonRetrecir = new Button("Rétrécir l'image");
        boutonRetrecir.setDisable(true);

        Button boutonFiltre1 = new Button("Filtre1");
        boutonFiltre1.setDisable(true);

        Button boutonFiltre2 = new Button("Filtre2");
        boutonFiltre2.setDisable(true);

        Button boutonFiltre3 = new Button("Filtre3");
        boutonFiltre3.setDisable(true);

        Button boutonSansFiltre = new Button("Sans Filtre");
        boutonSansFiltre.setDisable(true);


        HBox hbox = new HBox(btn, boutonAgrandir, boutonRetrecir, boutonFiltre1, boutonFiltre2, boutonFiltre3, boutonSansFiltre, text);
        HBox.setHgrow(btn, Priority.ALWAYS);
        btn.setAlignment(Pos.TOP_LEFT);


        Pane pane = new Pane();

        Group root = new Group();

        root.getChildren().add(hbox);

        root.getChildren().add(pane);

        Scene scene = new Scene(root, 1600, 700);

        BoutonAgrandir btnAgrandirHandle = new BoutonAgrandir();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Sélectionner une image");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));


                file = fileChooser.showOpenDialog(primaryStage);

                //System.out.println("filename=" + file);
                if(file != null){

                //débloquer autre boutons
                boutonAgrandir.setDisable(false);
                boutonRetrecir.setDisable(true);
                boutonFiltre1.setDisable(false);
                boutonFiltre2.setDisable(false);
                boutonFiltre3.setDisable(false);
                boutonSansFiltre.setDisable(false);

                BoutonFichier btnFichierHandle = new BoutonFichier();

                btnFichierHandle.ActionAppuieSurBoutonFichier(hbox, file, 100, 100);

               }
               else{
                   if(filenameAvant.equals("null")){
                       //nothing
                   }
                   else{
                       file = new File(filenameAvant);
                   }
               }

               filenameAvant = file.getName();
                
                
            }
        });


        boutonAgrandir.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {

                BoutonFiltre1 btnFiltre1Handle = new BoutonFiltre1();
                BoutonFiltre2 btnFiltre2Handle = new BoutonFiltre2();
                BoutonFiltre3 btnFiltre3Handle = new BoutonFiltre3();

                BoutonAgrandir btnAgrandirHandle = new BoutonAgrandir();

                if(btnAgrandirHandle.getNiveauAgrandissement() == 0){


                    if(currentFileStatus.equals("sans filtre")){
                        btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 150);
                        boutonAgrandir.setDisable(false);
                        boutonRetrecir.setDisable(false);
                    }


                    else if(currentFileStatus.equals("filtre1")){

                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 150);
                        boutonAgrandir.setDisable(false);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre2")){

                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 150);
                        boutonAgrandir.setDisable(false);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre3")){

                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 150);
                        boutonAgrandir.setDisable(false);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    
                }

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 1){

                    if(currentFileStatus.equals("sans filtre")){
                        btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 200);
                        boutonRetrecir.setDisable(false);
                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 200);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 200);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 200);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                }

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 2){

                    if(currentFileStatus.equals("sans filtre")){
                        btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);
                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }



                }

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 3){

                    if(currentFileStatus.equals("sans filtre")){
                        btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 300);
                        boutonAgrandir.setDisable(true);
                        boutonRetrecir.setDisable(false);
                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 300);
                        boutonAgrandir.setDisable(true);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 300);
                        boutonAgrandir.setDisable(true);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 300);
                        boutonAgrandir.setDisable(true);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.augmenteNiveauAgrandissement();
                    }

                }
                
                
            }
        });

        boutonRetrecir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                BoutonFiltre1 btnFiltre1Handle = new BoutonFiltre1();

                BoutonFiltre2 btnFiltre2Handle = new BoutonFiltre2();

                BoutonFiltre3 btnFiltre3Handle = new BoutonFiltre3();

                BoutonRetrecir btnRetrecirHandle = new BoutonRetrecir();

                if(btnAgrandirHandle.getNiveauAgrandissement() == 4){


                    if(currentFileStatus.equals("sans filtre")){

                        btnRetrecirHandle.ActionAppuieSurBoutonRetrecir(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);
                        //boutonAgrandir.setDisable(false);

                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();


                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();


                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 250);
                        boutonRetrecir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();


                    }

                    boutonAgrandir.setDisable(false);
                }

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 3){

                    if(currentFileStatus.equals("sans filtre")){

                        btnRetrecirHandle.ActionAppuieSurBoutonRetrecir(hbox, event, file, 200);

                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 200);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 200);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 200);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }

                    boutonAgrandir.setDisable(false);
                }   

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 2){

                    if(currentFileStatus.equals("sans filtre")){
                        btnRetrecirHandle.ActionAppuieSurBoutonRetrecir(hbox, event, file, 150);
                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 150);

                        btnAgrandirHandle.diminueNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 150);

                        btnAgrandirHandle.diminueNiveauAgrandissement();
                    }

                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 150);

                        btnAgrandirHandle.diminueNiveauAgrandissement();
                    }

                    boutonAgrandir.setDisable(false);

                }

                else if(btnAgrandirHandle.getNiveauAgrandissement() == 1){

                    if(currentFileStatus.equals("sans filtre")){
                        btnRetrecirHandle.ActionAppuieSurBoutonRetrecir(hbox, event, file, 100);
                        boutonRetrecir.setDisable(true);
                        boutonAgrandir.setDisable(false);

                    }

                    else if(currentFileStatus.equals("filtre1")){
                        btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 100);
                        boutonRetrecir.setDisable(true);
                        boutonAgrandir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }

                    else if(currentFileStatus.equals("filtre2")){
                        btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 100);
                        boutonRetrecir.setDisable(true);
                        boutonAgrandir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }


                    else if(currentFileStatus.equals("filtre3")){
                        btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 100);
                        boutonRetrecir.setDisable(true);
                        boutonAgrandir.setDisable(false);

                        btnAgrandirHandle.diminueNiveauAgrandissement();

                    }

                }
                
            }
        });

        boutonFiltre1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                BoutonFiltre1 btnFiltre1Handle = new BoutonFiltre1();


                currentFileStatus = "filtre1";

                if(btnAgrandirHandle.getNiveauAgrandissement() == 4){
                    btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 300);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 3){
                    btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 250);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 2){
                    btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 200);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 1){
                    btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 150);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 0){
                    btnFiltre1Handle.ActionAppuieSurBoutonFiltre1(hbox, event, file, 100);
                }

                boutonFiltre1.setDisable(true);
                boutonFiltre2.setDisable(false);
                boutonFiltre3.setDisable(false);
                boutonSansFiltre.setDisable(false);
                
                
            }
        });

        boutonFiltre2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                BoutonFiltre2 btnFiltre2Handle = new BoutonFiltre2();


                currentFileStatus = "filtre2";

                if(btnAgrandirHandle.getNiveauAgrandissement() == 4){
                    btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 300);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 3){
                    btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 250);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 2){
                    btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 200);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 1){
                    btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 150);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 0){
                    btnFiltre2Handle.ActionAppuieSurBoutonFiltre2(hbox, event, file, 100);
                }

                boutonFiltre1.setDisable(false);
                boutonFiltre2.setDisable(true);
                boutonFiltre3.setDisable(false);
                boutonSansFiltre.setDisable(false);
                
                
            }
        });

        boutonFiltre3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                BoutonFiltre3 btnFiltre3Handle = new BoutonFiltre3();


                currentFileStatus = "filtre3";

                if(btnAgrandirHandle.getNiveauAgrandissement() == 4){
                    btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 300);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 3){
                    btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 250);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 2){
                    btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 200);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 1){
                    btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 150);
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 0){
                    btnFiltre3Handle.ActionAppuieSurBoutonFiltre3(hbox, event, file, 100);
                }

                boutonFiltre1.setDisable(false);
                boutonFiltre2.setDisable(false);
                boutonFiltre3.setDisable(true);
                boutonSansFiltre.setDisable(false);
                
                
            }
        });

        boutonSansFiltre.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                currentFileStatus = "sans filtre";

                if(btnAgrandirHandle.getNiveauAgrandissement() == 4){
                    btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 300);

                    btnAgrandirHandle.diminueNiveauAgrandissement();
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 3){
                    btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 250);
                    btnAgrandirHandle.diminueNiveauAgrandissement();
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 2){
                    btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 200);
                    btnAgrandirHandle.diminueNiveauAgrandissement();
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 1){
                    btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 150);
                    btnAgrandirHandle.diminueNiveauAgrandissement();
                }

                if(btnAgrandirHandle.getNiveauAgrandissement() == 0){
                    btnAgrandirHandle.ActionAppuieSurBoutonAgrandir(hbox, event, file, 100);
                    btnAgrandirHandle.diminueNiveauAgrandissement();
                }

                boutonFiltre1.setDisable(false);
                boutonFiltre2.setDisable(false);
                boutonFiltre3.setDisable(false);
                boutonSansFiltre.setDisable(true);


            }

        });



        //hbox.setSpacing(10);

        BackgroundFill background_fill = new BackgroundFill(Color.WHITE,
                                          CornerRadii.EMPTY, Insets.EMPTY);

        Background background = new Background(background_fill);

        hbox.setBackground(background);

        primaryStage.setScene(scene);

        primaryStage.show();

        final KeyCombination combinationW = new KeyCodeCombination(KeyCode.W, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationA = new KeyCodeCombination(KeyCode.A, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationT = new KeyCodeCombination(KeyCode.T, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationR = new KeyCodeCombination(KeyCode.R, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationG = new KeyCodeCombination(KeyCode.G, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationB = new KeyCodeCombination(KeyCode.B, KeyCodeCombination.CONTROL_DOWN);

        final KeyCombination combinationS = new KeyCodeCombination(KeyCode.S, KeyCodeCombination.CONTROL_DOWN);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if (combinationW.match(event)){
                    //text.setText("CONTROL + W");
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    btn.fire();
                    
                }
                else if (combinationA.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonAgrandir.fire();
                }
                else if (combinationT.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonRetrecir.fire();
                }
                else if (combinationR.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonFiltre1.fire();
                }
                else if (combinationG.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonFiltre2.fire();
                }
                else if (combinationB.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonFiltre3.fire();
                }
                else if (combinationS.match(event)){
                    exposeHKShortcutsIndicationDisappear(hbox, pane, root);
                    boutonSansFiltre.fire();
                }
                else if(event.getCode().toString().equals("CONTROL")){

                    //raccourcis +W
                    Text texteW = new Text(20, 20, "+W");
                    Rectangle rectangleW = new Rectangle(18, 3, texteW.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleW.setFill(Color.CORAL);

                    rectangleW.getStyleClass().add("rectW");
                    texteW.getStyleClass().add("textW");
                    pane.getChildren().addAll(rectangleW, texteW);

                    //raccourcis +A
                    Text texteA = new Text(120, 20, "+A");
                    Rectangle rectangleA = new Rectangle(118, 3, texteA.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleA.setFill(Color.YELLOW);

                    rectangleA.getStyleClass().add("rectA");
                    texteA.getStyleClass().add("textA");
                    pane.getChildren().addAll(rectangleA, texteA);


                    //raccourcis +T
                    Text texteT = new Text(240, 20, "+T");
                    Rectangle rectangleT = new Rectangle(238, 3, texteT.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleT.setFill(Color.YELLOW);

                    rectangleT.getStyleClass().add("rectT");
                    texteT.getStyleClass().add("textT");
                    pane.getChildren().addAll(rectangleT, texteT);

                    //raccourcis +R
                    Text texteR = new Text(330, 20, "+R");
                    Rectangle rectangleR = new Rectangle(328, 3, texteR.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleR.setFill(Color.RED);

                    rectangleR.getStyleClass().add("rectR");
                    texteR.getStyleClass().add("textR");
                    pane.getChildren().addAll(rectangleR, texteR);


                    //raccourcis +G
                    Text texteG = new Text(389, 20, "+G");
                    Rectangle rectangleG = new Rectangle(387, 3, texteR.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleG.setFill(Color.GREEN);

                    rectangleG.getStyleClass().add("rectG");
                    texteG.getStyleClass().add("textG");
                    pane.getChildren().addAll(rectangleG, texteG);


                    //raccourcis +B
                    Text texteB = new Text(449, 20, "+B");
                    Rectangle rectangleB = new Rectangle(447, 3, texteB.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleB.setFill(Color.BLUE);

                    rectangleB.getStyleClass().add("rectB");
                    texteB.getStyleClass().add("textB");
                    pane.getChildren().addAll(rectangleB, texteB);

                    //raccourcis +S
                    Text texteS = new Text(520, 20, "+S");
                    Rectangle rectangleS = new Rectangle(518, 3, texteS.getBoundsInLocal().getWidth() + 7, 30);
                    rectangleS.setFill(Color.YELLOW);

                    rectangleS.getStyleClass().add("rectS");
                    texteS.getStyleClass().add("textS");
                    pane.getChildren().addAll(rectangleS, texteS);




                }
                else{
                    //text.setText(event.getCode().toString());
                    //System.out.println(event.getCode().toString());
                }
                    
            }
        });
        scene.setOnKeyReleased(event -> exposeHKShortcutsIndicationDisappear(hbox, pane, root));
        //scene.setOnKeyReleased(event -> 
    }

    public void exposeHKShortcutsIndicationDisappear(HBox hbox, Pane pane, Group root){
        text.setText("");
        hbox.getChildren().remove(hbox.lookup(".rect1Raccourci"));

        pane.getChildren().remove(pane.lookup(".rectW"));
        pane.getChildren().remove(pane.lookup(".textW"));

        pane.getChildren().remove(pane.lookup(".rectA"));
        pane.getChildren().remove(pane.lookup(".textA"));

        pane.getChildren().remove(pane.lookup(".rectT"));
        pane.getChildren().remove(pane.lookup(".textT"));

        pane.getChildren().remove(pane.lookup(".rectR"));
        pane.getChildren().remove(pane.lookup(".textR"));

        pane.getChildren().remove(pane.lookup(".rectG"));
        pane.getChildren().remove(pane.lookup(".textG"));

        pane.getChildren().remove(pane.lookup(".rectB"));
        pane.getChildren().remove(pane.lookup(".textB"));

        pane.getChildren().remove(pane.lookup(".rectS"));
        pane.getChildren().remove(pane.lookup(".textS"));
    }


    @Override
    public void handle(KeyEvent event){
        text.setText("A key has been pressed");
    }

}




