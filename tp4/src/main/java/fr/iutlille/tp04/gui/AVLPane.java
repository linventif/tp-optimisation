package fr.iutlille.tp04.gui;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import fr.iutlille.tp04.AVL;
import fr.iutlille.tp04.AVLNoeud;
import fr.iutlille.tp04.AVLVide;

public class AVLPane extends Pane {
    private final double radius = 15;
    private final double vGap = 50;
    private AVL tree;

    AVLPane(AVL tree){
        this.tree = tree;
        setStatus("Potato");
    setBackground(new Background(new BackgroundFill(Color.web("#707690"), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void setStatus(String msg){
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree(){
        this.getChildren().clear();
        if(!tree.estVide()){
            displayTree(tree, getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    private void displayTree(AVL racine, double x, double y, double hGap){
        if (racine.estVide()) return;
        if (!racine.getGauche().estVide()){
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
            displayTree(racine.getGauche(), x - hGap, y + vGap, hGap / 2);
        }

        if (!racine.getDroite().estVide()){
                getChildren().add(new Line(x + hGap, y + vGap, x, y));
            displayTree(racine.getDroite(), x + hGap, y + vGap, hGap / 2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.CORNFLOWERBLUE);
        getChildren().addAll(circle, new Text(x - 4, y + 4, racine.getValeur() + ""));
    }

    public void raz(){
        this.getChildren().clear();
        this.tree = AVLVide.getInstance();
    }

    public void arbreTest(){
        this.tree = new AVLNoeud(5,new AVLNoeud(3, new AVLNoeud(2), new AVLNoeud(4)), new AVLNoeud(7));
        //this.tree = new AVLNoeud(10, new AVLNoeud(7, new AVLNoeud(5), AVLVide.getInstance()), AVLVide.getInstance());
    }

    public void rotation_gauche(){
        this.tree = this.tree.rotation_gauche();
    }

    public void rotation_droite(){
        this.tree = this.tree.rotation_droite();
    }

    public void insere(Integer v){
        tree = this.tree.insere(v);
    }

    public boolean cherche(Integer v) { return this.tree.cherche(v); }


    public void supprime(Integer v){
        // this.tree.supprime(v);
    }

    public int hauteur(){
        return this.tree.getHauteur();
    }

    public boolean estAVL(){
        return this.tree.estAVL();
    }
}
