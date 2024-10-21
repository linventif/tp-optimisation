package fr.iutlille.tp04;

public class AVLVide implements AVL {
    private static final AVLVide instance = new AVLVide();

    private AVLVide(){}

    public static AVLVide getInstance(){
        return instance;
    }

    @Override
    public Integer getValeur() {
        throw new UnsupportedOperationException("L'arbre vide n'a pas de valeur.");
    }

    @Override
    public AVL getGauche() {
        throw new UnsupportedOperationException("L'arbre vide n'a pas de fils gauche.");
    }

    @Override
    public AVL getDroite() {
        throw new UnsupportedOperationException("L'arbre vide n'a pas de fils droit.");
    }

    @Override
    public void setDroite(AVL fd) {
        throw new UnsupportedOperationException("L'arbre vide ne peut avoir de fils droit.");
    }

    @Override
    public void setGauche(AVL fg) {
        throw new UnsupportedOperationException("L'arbre vide ne peut avoir de fils gauche.");
    }

    @Override
    public Integer getHauteur() {
        return -1;
    }

    @Override
    public void setHauteur(Integer hauteur) {
        throw new UnsupportedOperationException("L'arbre vide a toujours une hauteur de -1.");
    }

    @Override
    public boolean estVide() {
        return true;
    }

    @Override
    public int deseq() {
        return 0;
    }

    @Override
    public boolean estAVL() {
        return true;
    }

    @Override
    public boolean cherche(Integer v) {
        return false;
    }

    @Override
    public AVL rotation_droite() {
        return this;
    }

    @Override
    public AVL rotation_gauche() {
        return this;
    }

    @Override
    public AVL insere(Integer v) {
        // TODO
        return null;
    }
}
