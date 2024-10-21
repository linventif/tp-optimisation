package fr.iutlille.tp04.gui;

import fr.iutlille.tp04.AVLVide;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import fr.iutlille.tp04.AVL;

import java.util.ArrayList;

public class AVLVisualiser extends Application {
    private static ArrayList<Integer> nodes = new ArrayList<>();
    @Override
    public void start(Stage primaryStage){
        AVL tree = AVLVide.getInstance();
        BorderPane pane = new BorderPane();
        AVLPane view = new AVLPane(tree);
        setPane(pane, view, tree);
        setStage(pane, primaryStage, "Affichage d'arbre rouge-noir");
    }

    public void setStage(BorderPane pane, Stage primaryStage, String title){
        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setPane(BorderPane pane, AVLPane view, AVL tree){
        pane.setCenter(view);
        TextField textField = new TextField();
        textField.setPrefColumnCount(3);
        textField.setAlignment(Pos.BASELINE_RIGHT);
        Button insert = new Button("Insere");
        Button delete = new Button("Supprime");
        Button rotation_gauche = new Button("Rotation G");
        Button rotation_droite = new Button("Rotation D");
        Button arbreTest = new Button("Arbre Test");
        Button recherche = new Button("Recherche");
        Button AVL = new Button("Arbre AVL ?");
        Button raz = new Button("RAZ");
        Button hauteur = new Button("Hauteur");
        Button exit = new Button("Quitter");

        addFunctionalities(textField, insert, delete, recherche, hauteur, AVL, raz, arbreTest, rotation_gauche, rotation_droite, exit, tree, view);
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a value"), textField, insert, delete, recherche, hauteur, AVL, raz, arbreTest, rotation_gauche, rotation_droite, exit);
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        pane.setBottom(hBox);
    }

    public void addFunctionalities(TextField textField, Button insert, Button delete, Button recherche, Button hauteur, Button AVL, Button raz, Button arbreTest, Button rotation_gauche, Button rotation_droite, Button exit, AVL tree, AVLPane view){
        insert.setOnAction(e->{
            if(textField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Il faut saisir une valeur!", ButtonType.OK);
                alert.getDialogPane().setMinHeight(80);
                alert.show();
            }
            else {
                int key = Integer.parseInt(textField.getText());
                nodes.add(key);
                if (view.cherche(key)) {
                    view.displayTree();
                    view.setStatus(key + " est déjà présent!");
                } else {
                    view.insere(key);
                    view.displayTree();
                    view.setStatus(key + " est inséré!");
                }
                textField.clear();
            }
        });

        delete.setOnAction(e->{
            view.displayTree();
            view.setStatus("Non implémenté...");
/*            int key = Integer.parseInt(textField.getText());
            if(!view.cherche(key)){
                view.displayTree();
                view.setStatus(key +" n'est pas présent!");
            }
            else{
                view.supprime(key);
                view.displayTree();
                view.setStatus(key+" est remplacé par son successeur immédiat!");
            }
            textField.clear();*/
        });

        raz.setOnAction(e->{
            view.raz();
        });

        arbreTest.setOnAction(e ->{
            view.arbreTest();
            view.displayTree();
        });

        rotation_gauche.setOnAction(e->{
            view.rotation_gauche();
            view.displayTree();
        });

        rotation_droite.setOnAction(e->{
            view.rotation_droite();
            view.displayTree();
        });

        exit.setOnAction(e->{
            Platform.exit();
        });

        recherche.setOnAction(e->{
            int cle = Integer.parseInt(textField.getText());
            view.displayTree();
            if (view.cherche(cle))
                view.setStatus("j'ai trouvé " + cle + "!");
            else
                view.setStatus("je n'ai pas trouvé cette clé!");

        });

        hauteur.setOnAction(e->{
            int ht = view.hauteur();
            view.displayTree();
            view.setStatus("hauteur = " + ht);
        });

        AVL.setOnAction(e->{
            view.displayTree();
            boolean estAVL = view.estAVL();
            view.displayTree();
            if (estAVL)
                view.setStatus("cet arbre est AVL");
            else view.setStatus("cet arbre n'est pas AVL!");
        });
    }
}