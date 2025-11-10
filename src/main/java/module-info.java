module taskmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires java.desktop;
    requires java.prefs;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    // Mở cả hai package cho FXMLLoader
    opens taskmanagement to javafx.fxml;
    opens taskmanagement.controllers to javafx.fxml;
    opens taskmanagement.models to javafx.fxml;

    // Xuất các package để dùng từ bên ngoài module
    exports taskmanagement;
    exports taskmanagement.controllers;
    exports taskmanagement.models;
}
