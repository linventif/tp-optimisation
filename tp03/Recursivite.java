package tp03;

public class Recursivite {
  /*
   * Écrire un algorithme récursif de calcul de la somme de deux entiers naturels
   * a et b en supposant que les seules opérations de base dont vous disposez sont
   *
   * l’ajout de 1 à un entier x: x+1
   * le retrait de 1 à un entier x: x-1
   * et la comparaison à 0 d’un entier x: a==0.
   *
   * où add ne peut donc utiliser aucun opérateur arithmétique en dehors de
   * fonctions inc et dec.
   *
   */

  static public int inc(int x) {
    return x + 1;
  }

  static public int dec(int x) {
    return x - 1;
  }

  static public boolean isZero(int x) {
    return x == 0;
  }

  static public int add(int a, int b) {
    if (isZero(b)) {
      return a;
    } else {
      return add(inc(a), dec(b));
    }
  }

  /*
   * 1.2. Produit
   *
   * Écrire un algorithme récursif de calcul du produit de deux entiers naturels a
   * et b en supposant que les seules opérations de base dont vous disposez sont
   *
   * la somme de deux entiers a et b: a+b
   * le retrait de 1 à un entier a: a-1
   * et la comparaison à 0 d’un entier a: a==0.
   *
   * Vous devez donc implémenter la méthode:
   *
   * static public int mult(int a, int b);
   */

  static public int mult(int a, int b) {
    if (isZero(a)) {
      return 0;
    } else {
      return add(b, mult(dec(a), b));
    }
  }

  /*
   *
   * 1.3. Puissance entière
   *
   * Écrire un algorithme récursif de calcul de la puissance n-ième (n entier > 0)
   * d’un nombre réel a en supposant que les seules opérations de base dont vous
   * disposez sont
   *
   * le produit de deux réels a et b: a*b
   * le retrait de 1 à un entier a: a-1
   * et la comparaison à 0 d’un entier a: a==0.
   *
   * Vous devez donc implémenter la méthode:
   *
   * static public int puis(int a, int b);
   */

  static public int puis(int a, int b) {
    if (isZero(b)) {
      return 1;
    } else {
      return mult(a, puis(a, dec(b)));
    }
  }

  /*
   * 2. Fibonacci récursif vs. itératif
   *
   * La suite de Fibonacci, pour
   * est définie par l’équation n>=0 est définie par l’équation de récurrence
   * suivante:
   * F(n) = F(n-1) + F(n-2) avec F(0) = 0 et F(1) = 1
   *
   */

  /*
   * 2.1. Question 1
   *
   * Implémentez une méthode récursive
   *
   * public static int fibo_rec_naif(int n);
   *
   * qui calcule le terme de rang
   * en suivant explicitement la définition précédente. Vous inclurez un compteur
   * qui calcule le nombre d’additions réalisées par cette méthode.
   */

  static public int fibo_rec_naif(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return fibo_rec_naif(n - 1) + fibo_rec_naif(n - 2);
    }
  }

  /*
   *
   * 2.2. Question 2
   *
   * Implémentez la même fonction mais de manière itérative:
   *
   * public static int fibo_iter(int n);
   *
   * Utilisez également un compteur pour compter le nombre d’additions réalisées
   * (on ne tiendra pas compte des additions effectuées sur l’indice de boucle
   * pour réaliser les itérations). Comparez les performances des deux méthodes.
   * Que constatez-vous ? Pourquoi la méthode récursive est-elle aussi inefficace
   * ?
   *
   */

  static public int fibo_iter(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;

    int a = 0;
    int b = 1;
    int c = 0;
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }

  /*
   * 2.3. Question 3
   *
   * Implémentez une méthode récursive
   *
   * public static int fibo_rec(int n);
   *
   * qui calcule le n-ième terme de la suite de Fibonacci avec le même nombre
   * d’additions que la méthode itérativ et sans utiliser fibo_rec_naif.
   */

  static public int fibo_rec(int n) {
    return fibo_rec_helper(n, 0, 1);
  }

  static private int fibo_rec_helper(int n, int a, int b) {
    if (n == 0) {
      return a;
    } else if (n == 1) {
      return b;
    } else {
      return fibo_rec_helper(n - 1, b, a + b);
    }
  }
}
