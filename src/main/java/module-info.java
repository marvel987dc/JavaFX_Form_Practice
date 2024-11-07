module com.example.juanbarrero_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.juanbarrero_comp228lab4 to javafx.fxml;
    exports com.example.juanbarrero_comp228lab4;
}