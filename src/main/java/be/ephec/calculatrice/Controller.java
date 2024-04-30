package be.ephec.calculatrice;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;
    private Model model = new Model();

    private long number1 = 0;
    private String operator = "";
    private boolean newOperation = true;


    @FXML
    protected void processNumber(ActionEvent event) {
        // gestion de nombre

        String digit = ((Button) event.getSource()).getText();
        System.out.println("Bouton nombre " + digit);

        /*
        Si le output contient un ‘0’, on remplace le ‘0’ par le texte du Button enfoncé.
        Si output ne contient pas ‘0’, on peut y accoler le texte du Button (si la calculatrice
        affiche "56" et qu’on appuye sur "2", il faut qu’elle affiche "562").
         */
        if (newOperation) {
            output.setText("");
            newOperation = false;
        }
        if (output.getText().equals("0"))
            output.setText(digit);
        else
            output.setText(output.getText() + digit);
    }

    @FXML
    protected void processOperator(ActionEvent event) {
        // gestion des opérateurs
        String op = ((Button) event.getSource()).getText();

        if (op.equals("=")) {
            if (operator.equals("")) ;
            else {
                // on calcule le resultat,
                long res = model.compute(number1, Long.valueOf(output.getText()), operator);
                // on adapte le Text,
                output.setText(res + "");
                // on remet l'operateur à ""
                operator = "";
                // on enregistre une nouvelle operation
                newOperation = true;
            }
        } else {
            // Si operator est vide,
            if (operator.equals("")) {
            // operator = la touche enfoncée (op)
                operator = op ;
            // number1 = la valeur du nombre dans le Text
                number1 = Long.valueOf(output.getText());
            // on vide Text
                output.setText("0");
            }
        }

        System.out.println("Bouton opérateur " + op);

    }
}