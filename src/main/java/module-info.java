module co.edu.java.productmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires com.h2database;

    opens co.edu.java.productmanagement to javafx.fxml;
    opens co.edu.java.productmanagement.controller to javafx.fxml;
    exports co.edu.java.productmanagement;



}