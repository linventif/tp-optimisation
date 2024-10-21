Pour compiler en ligne de commande:

``` shell
javac --module-path <path/to/openjfx/lib> --add-modules javafx.controls -d bin -cp bin -sourcepath src src/fr/iutlille/tp4/gui/*.java
```

Pour exécuter:

``` shell
java --module-path <path/to/openjfx/lib> --add-modules javafx.controls -cp bin fr.iutlille.tp04.gui.AVLVisualiser
```

