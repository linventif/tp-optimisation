public class script {
    // Autour du tri par insertion
    //
    //Implanter une méthode tri_insertion pour trier dans l’ordre croissant un tableau d’entiers en suivant l’algorithme
    //de tri par insertion. On fera en sorte que le tableau à trier soit initialisé avec des entiers pris dans de façon
    //aléatoire.

    public static int[] tri_insertion(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int x = tab[i];
            int j = i - 1;
            while (j >= 0 && tab[j] > x) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = x;
        }
        return tab;
    }

    //Implanter la méthode tri_insertion_dec qui trie dans l’ordre décroissant.

    public static int[] tri_insertion_dec(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int x = tab[i];
            int j = i - 1;
            while (j >= 0 && tab[j] < x) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = x;
        }
        return tab;
    }

    //Implanter la méthode tri_insertion_dic qui améliore l’efficacité de la méthode tri_insertion en utilisant une méthode
    //recherche_rang qui procède comme une recherche dichotomique pour trouver la position dans la partie triée du tableau où
    //chaque nouvel entier doit être inséré.

    public static int recherche_rang(int[] tab, int x, int n) {
        int g = 0;
        int d = n - 1;
        while (g <= d) {
            int m = (g + d) / 2;
            if (tab[m] < x) {
                g = m + 1;
            } else {
                d = m - 1;
            }
        }
        return g;
    }

    public static int[] tri_insertion_dic(int[] tab) {
        for (int i = 1; i < tab.length; i++) {
            int x = tab[i];
            int j = recherche_rang(tab, x, i);
            for (int k = i; k > j; k--) {
                tab[k] = tab[k - 1];
            }
            tab[j] = x;
        }
        return tab;
    }

    //Quelle est la complexité (dans le pire cas) de cette nouvelle version du tri par insertion ?
    //
    //## Tri par sélection
    //
    //Le tri par sélection consiste à trouver le plus petit élément du tableau et à le permuter avec l’élément se trouvant à
    //la première position. On recommence avec le 2ème plus petit élément qu’on permute avec la deuxième position et ainsi de
    //suite avec les éléments suivants. Ainsi, au départ la partie non triée du tableau correspond au tableau entier puis elle
    //se rétrécie jusqu’à ne contenir que la dernière case du tableau. Implémentez en java la méthode tri_selection.
    //Donnez la complexité de cet algorithme dans le pire des cas et dans le meilleur des cas.
    //
    //## Tri à bulles
    //
    //Implantez les deux algorithmes de tri à bulle vus en td: void bubbleSort(int [] tab) et la version optimisée static void
    //bubbleSortOpt(int [] tab).
    //Comparaison des algorithmes
    //
    //Ajoutez aux méthodes précédemment implantées des compteurs permettant de calculer le nombre total de comparaisons et
    //d’affectations réalisées à chaque tri. Pour obtenir le coût maximale, générez des tableaux triés par ordre décroissants
    //de tailles 10, 100, 1000 et 10000, et triez-les avec les algorithmes implantés. Remplissez un tableau avec les valeurs
    //des compteurs obtenus pour les différents algorithmes et tailles de tableaux.
    //Pour évaluer le coût moyen, générez 1000 tableaux aléatoires pour chaque taille prédéfinie, puis calculez le nombre
    //moyen d’opérations effectuées à chaque fois. Récapitulez vos résultats sous forme de tableaux comme à la question
    //précédente.

    public static void printArray(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static int[] randomArray(int size) {
        System.out.println("\nTableau aléatoire: ");
        int[] tab = new int[size];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (Math.random() * 100);
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        return tab;
    }

    public static void main(String[] args) {
        int[] tab = randomArray(10);

        System.out.println("\nTri par insertion: ");
        printArray(tri_insertion(tab));

        System.out.println("\nTri par insertion décroissant: ");
        printArray(tri_insertion_dec(tab));

        System.out.println("\nTri par insertion dichotomique: ");
        printArray(tri_insertion_dic(tab));

        System.out.println();
    }
}
