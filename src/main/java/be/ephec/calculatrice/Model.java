package be.ephec.calculatrice;

public class Model {
    public long compute(long n1, long n2, String op) {
        /*
        Si l’opérateur est "+", la méthode retourne n1 + n2
        Pour "-", la méthode retourne n1 - n2
        Pour "x", elle retourne n1 * n2
        Pour ":", elle renvoie n1 / n2, mais en ayant d’abord vérifié si n2 n’était pas égal à 0
          (auquel cas elle renvoie 0).
        Sinon, elle sort une erreur à la console et renvoie 0.
         */

        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "x":
                return n1 * n2;
            case ":":
                if (n2 == 0) {
                    System.out.println("Erreur : division par 0");
                    return 0;
                } else return n1 / n2;
            default:
                System.out.println("Erreur : opérateur invalide");
                return -9999999;
        }
    }
}
