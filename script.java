public class script {
    // Autour du tri par insertion
    //
    //Implanter une méthode tri_insertion pour trier dans l’ordre croissant un tableau d’entiers en suivant l’algorithme
    //de tri par insertion. On fera en sorte que le tableau à trier soit initialisé avec des entiers pris dans de façon
    //aléatoire.

    //Implanter la méthode tri_insertion_dic qui améliore l’efficacité de la méthode tri_insertion en utilisant une méthode
    //recherche_rang qui procède comme une recherche dichotomique pour trouver la position dans la partie triée du tableau où
    //chaque nouvel entier doit être inséré.

    //Quelle est la complexité (dans le pire cas) de cette nouvelle version du tri par insertion ?
    // La complexité est de O(n^2) dans le pire cas.
    // Pourquoi est-elle plus efficace que la première version ?

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

    public static void printArray(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static int[] randomArray(int size) {
//        System.out.println("\nTableau aléatoire: ");
        int[] tab = new int[size];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (Math.random() * size);
//            System.out.print(tab[i] + " ");
        }
//        System.out.println();
        return tab;
    }

    //    public static void main(String[] args) {
//        int[] tab = randomArray(100000);
//        int[] rtn = new int[tab.length];
//
//        long startTime = System.nanoTime();
//        System.out.println("\nTri par insertion: ");
//        rtn = tri_insertion(tab);
//        System.out.println("Duration: " + (System.nanoTime() - startTime) * 1.0 / 1000000 + " ms");
////        printArray(rtn);
//
//        startTime = System.nanoTime();
//        System.out.println("\nTri par insertion décroissant: ");
//        rtn = tri_insertion_dec(tab);
//        System.out.println("Duration: " + (System.nanoTime() - startTime) * 1.0 / 1000000 + " ms");
////        printArray(rtn);
//
//        startTime = System.nanoTime();
//        System.out.println("\nTri par insertion dichotomique: ");
//        rtn = tri_insertion_dic(tab);
//        System.out.println("Duration: " + (System.nanoTime() - startTime) * 1.0 / 1000000 + " ms");
////        printArray(rtn);
//
//        System.out.println();
//    }
    public static long[] testTri(int size) {
        int[] tab = randomArray(size);
        int[] rtn = new int[tab.length];
        long[] stat = new long[3];

        long startTime = System.nanoTime();
        rtn = tri_insertion(tab);
        stat[0] = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        rtn = tri_insertion_dec(tab);
        stat[1] = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        rtn = tri_insertion_dic(tab);
        stat[2] = (System.nanoTime() - startTime);

        return stat;
    }


    //    [nombre de comparaisons, temps d'exécution tri_insertion, temps d'exécution tri_insertion_dec, temps d'exécution tri_insertion_dic]
    public static int execUntil = 10000;
    public static long[][] chartStat = new long[execUntil][3];

    public static void printPerct(int perct, int size) {
        System.out.print("\r" + perct + "% [" + new String(new char[(int) (perct * 50 / 100)]).replace("\0", "#") + new String(new char[50 - (perct * 50 / 100)]).replace("\0", " ") + "]");
    }

    public static String nanoSecToMs(long nanoSec) {
        return String.format("%.4f", nanoSec * 1.0 / 1000000) + " ms";
    }


    public static void main(String[] args) {
        for (int i = 0; i < execUntil; i++) {
            chartStat[i] = testTri(i);
            printPerct(i * 100 / execUntil, execUntil);
        }

        System.out.println();
        System.out.println("Statistiques: ");
        for (int i = 0; i < execUntil; i++) {
            System.out.println(i + ": [" + nanoSecToMs(chartStat[i][0]) + ", " + nanoSecToMs(chartStat[i][1]) + ", " + nanoSecToMs(chartStat[i][2]) + "]");
        }
    }
}
