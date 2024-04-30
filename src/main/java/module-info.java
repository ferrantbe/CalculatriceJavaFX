module be.ephec.calculatrice {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ephec.calculatrice to javafx.fxml;
    exports be.ephec.calculatrice;
}