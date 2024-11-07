package com.example.juanbarrero_comp228lab4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane mainPane = new BorderPane();
        mainPane.setPadding(new Insets(15));

        GridPane formPane = new GridPane();
        formPane.setPadding(new Insets(10));
        formPane.setHgap(10);
        formPane.setVgap(10);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        formPane.add(nameLabel, 0, 0);
        formPane.add(nameField, 1, 0);

        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        formPane.add(addressLabel, 0, 1);
        formPane.add(addressField, 1, 1);

        CheckBox councilCheckBox = new CheckBox("Student Council");
        formPane.add(councilCheckBox, 2, 1);

        Label provinceLabel = new Label("Province:");
        TextField provinceField = new TextField();
        formPane.add(provinceLabel, 0, 2);
        formPane.add(provinceField, 1, 2);

        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();
        formPane.add(cityLabel, 0, 3);
        formPane.add(cityField, 1, 3);

        Label postalCodeLabel = new Label("Postal Code:");
        TextField postalCodeField = new TextField();
        formPane.add(postalCodeLabel, 0, 4);
        formPane.add(postalCodeField, 1, 4);

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneNumberField = new TextField();
        formPane.add(phoneLabel, 0, 5);
        formPane.add(phoneNumberField, 1, 5);

        CheckBox volunteerWorkCheckBox = new CheckBox("Volunteer Work");
        formPane.add(volunteerWorkCheckBox, 2, 5);

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        formPane.add(emailLabel, 0, 6);
        formPane.add(emailField, 1, 6);

        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(10));

        RadioButton ComputerScience = new RadioButton("Computer Science");
        RadioButton Business = new RadioButton("Business");
        HBox ComputerBusiness = new HBox(ComputerScience, Business);
        ComputerBusiness.setSpacing(10);
        ComboBox<String> courses = new ComboBox<>();
        courses.setMinHeight(80);
        courses.setMaxWidth(200);
        courses.setPromptText("Select a course");

        ToggleGroup courseGroup = new ToggleGroup();
        ComputerScience.setToggleGroup(courseGroup);
        Business.setToggleGroup(courseGroup);

        ListView<String> selectedList = new ListView<>();
        selectedList.setPrefHeight(100);
        selectedList.setPrefWidth(200);

        courses.setOnAction(e -> {
            if (courses.getValue() != null) {
                selectedList.getItems().add(courses.getValue());
            }
        });

        rightPane.getChildren().addAll(ComputerBusiness, courses, new Label("Selected Courses"), selectedList);

        ComputerScience.setOnAction(e -> loadCourses(courses, "Computer Science"));
        Business.setOnAction(e -> loadCourses(courses, "Business"));

        Button Display = new Button("Display");
        mainPane.setBottom(Display);
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(10);

        mainPane.setLeft(formPane);
        mainPane.setRight(rightPane);

        VBox bottomPane = new VBox(10, Display, textArea);
        bottomPane.setPadding(new Insets(10));
        mainPane.setBottom(bottomPane);

        Display.setOnAction(e -> {
            textArea.setText("Name: " + nameField.getText() + "\n" +
                    "Address: " + addressField.getText() + "\n" +
                    "Province: " + provinceField.getText() + "\n" +
                    "City: " + cityField.getText() + "\n" +
                    "Postal Code: " + postalCodeField.getText() + "\n" +
                    "Phone Number: " + phoneNumberField.getText() + "\n" +
                    "Email: " + emailField.getText() + "\n" +
                    "Selected Course: " + selectedList.getItems() + "\n" +
                    "Student Council: " + councilCheckBox.isSelected() + "\n" +
                    "Volunteer Work: " + volunteerWorkCheckBox.isSelected());
        });

        Scene scene = new Scene(mainPane, 650, 550);
        primaryStage.setTitle("Student Information Form");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void loadCourses(ComboBox<String> courses, String course) {
        courses.getItems().clear();
        if (course.contains("Computer Science")) {
            courses.getItems().addAll("Java", "JavaScript", "Python", "C++", "C#");
        } else if (course.contains("Business")) {
            courses.getItems().addAll("Management", "Marketing", "Analytics", "Finance", "Accounting");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
