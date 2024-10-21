package fr.iutlille.tp04;

public class AVLNoeud implements AVL {
    private Integer valeur;
    private AVL fg;
    private AVL fd;
    private Integer hauteur;

    /* AVL feuille */

    public AVLNoeud(Integer v){
        this.valeur = v;
        this.hauteur = 0;
        this.fg = AVLVide.getInstance();
        this.fd = AVLVide.getInstance();
    }

    public AVLNoeud(Integer valeur, AVL fg, AVL fd) {
        this.valeur = valeur;
        this.fg = fg;
        this.fd = fd;
        this.hauteur = 1+Math.max(fg.getHauteur(),fd.getHauteur());
    }

    public Integer getValeur() {
        return valeur;
    }

    public AVL getGauche() {
        return fg;
    }

    public void setGauche(AVL fg) {
        this.fg = fg;
    }

    public AVL getDroite() {
        return fd;
    }

    public void setDroite(AVL fd) {
        this.fd = fd;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public boolean estVide(){
        return false;
    }

    public int deseq(){
        // TODO
        return 0;
    }

    @Override
    public boolean estAVL() {
        return false;
    }

    public boolean cherche(Integer v){
        // TODO
        return false;
    }

    public AVL rotation_droite(){
        // TODO
        return null;
    }

    public AVL rotation_gauche(){
        // TODO
        return null;
    }

    public AVL insere(Integer v){
        // TODO
        return null;
    }
}
