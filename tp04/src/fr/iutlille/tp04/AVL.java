package fr.iutlille.tp04;

public interface AVL {
    public Integer getValeur();
    public AVL getGauche();
    public void setGauche(AVL x);
    public AVL getDroite();
    public void setDroite(AVL fd);
    public Integer getHauteur();
    public void setHauteur(Integer hauteur);
    public boolean estVide();
    public int deseq();
    public boolean estAVL();
    public boolean cherche(Integer v);
    public AVL rotation_droite();
    public AVL rotation_gauche();
    public AVL insere(Integer v);
}
