package cs2410.assn6.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import cs2410.assn6.control.PersonArray;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public class MainApp extends Application {
    /**
     * cancelBtn is used to erase the fields when adding a new worker.
     * saveBtn allows the user to save their worker
     * toolBar is used to display the various button at the top of the window
     * mainPane is used to organize the program
     * addPane is used to display textfields and other information when adding a worker.
     * displayPane is used to display information pulled up by the combobox inside the toolBar.
     *
     * The list of TextFields are all of the fields that can be displayed on the addPane, and are put there
     * so they can be passed around to different methods.
     */
    Button cancelBtn = new Button("Cancel");
    Button saveBtn = new Button("Save");
    ToolBar toolBar;
    BorderPane mainPane;
    Pane addPane;
    Pane displayPane;

    TextField nameSpace;
    TextField mathSpace;
    TextField saySpace;
    TextField IQSpace;
    TextField hoursSpace;
    TextField wageSpace;
    TextField carrotSpace;

    @Override
    public void start(Stage primaryStage) {
        /**
         * defining some characteristics of the mainPane as well as setting up displayPane
         */
        mainPane = new BorderPane();
        mainPane.setPrefHeight(300);
        mainPane.setPrefWidth(400);
        displayPane = new Pane();

        /**
         * personArray is the ArrayList used to hold all of the saved workers.
         */
        PersonArray personArray = new PersonArray();

        /*
        setting up toolBar
         */
        toolBar = new ToolBar();
        toolBar.setAlignment(Pos.CENTER);

        /*
        setting up the alignment of the cancel and save buttons
         */
        cancelBtn.setAlignment(Pos.BOTTOM_RIGHT);
        saveBtn.setAlignment(Pos.BOTTOM_RIGHT);

        /**
         * hBox is used to hold the save and cancel buttons, and will be added to the bottom of mainPane later
         */
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(10,5,5,10));
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(cancelBtn, saveBtn);

        /**
         * setting up some of the layout of mainPane
         */
        mainPane.setTop(toolBar);
        mainPane.setCenter(displayPane);


        /**
         * displays primaryStage
         */
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        /**
         * displays labels and textfields associated with creating an hourly worker
         */
        toolBar.setHourlyBtnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox col = fillPane();
                addPane = new Pane();
                addPane.getChildren().add(col);
                setupAdd(addPane, hBox);
            }
        });

        /**
         * displays labels and textfields associated with creating a contract worker
         */
        toolBar.setContractBtnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox col = fillPane();
                addPane = new Pane();
                addPane.getChildren().add(col);
                setupAdd(addPane, hBox);
            }
        });

        /**
         * displays labels and textfields associated with creating a hobbit
         */
        toolBar.setHobbitBtnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox col = fillPane();
                addPane = new Pane();
                addPane.getChildren().add(col);
                setupAdd(addPane, hBox);
            }
        });

        /**
         * displays information about saved workers based on the option selected
         *
         * fromCombo gets the option selected in the combobox
         *
         * comboConvert is a label that takes a String as its content text that is a list of workers
         *
         */
        toolBar.setComboAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String fromCombo = toolBar.comboSel();
                Label comboConvert = new Label();
                displayPane = new Pane();

                if (fromCombo == "Math") {
                    comboConvert.setText(personArray.getMathList());
                }
                else if (fromCombo == "Income") {
                    comboConvert.setText(personArray.getIncomeList());
                }
                else if (fromCombo == "Hours") {
                    comboConvert.setText(personArray.getHoursList());
                }
                else if (fromCombo == "IQ") {
                    comboConvert.setText(personArray.getIQList());
                }
                else if (fromCombo == "Say") {
                    comboConvert.setText(personArray.getSayList());
                }
                else if (fromCombo == "Carrots") {
                    comboConvert.setText(personArray.getCarrotList());
                }
                else {
                    comboConvert.setText(personArray.getContractsList());
                }
                displayPane.getChildren().add(comboConvert);
                setupAdd(displayPane, null);
            }
        });


        /**
         * this method clears all of the textfields onscreen
         */
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameSpace.clear();
                mathSpace.clear();
                saySpace.clear();
                if (toolBar.hobbitBtnSelected()) {
                    carrotSpace.clear();
                }
                else {
                    IQSpace.clear();
                    hoursSpace.clear();
                    wageSpace.clear();
                }
            }
        });

        /**
         * saves the worker the user has just created, and adds them to the Arraylist of saved workers.
         */
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameSpace.getText();
                String math = mathSpace.getText();
                String say = saySpace.getText();
                showBeforeSave(nameSpace.getText());
                nameSpace.clear();
                mathSpace.clear();
                saySpace.clear();
                if (toolBar.hobbitBtnSelected()) {
                    int carrots = Integer.parseInt(carrotSpace.getText());
                    personArray.createHobbit(name, math, say, carrots);
                    carrotSpace.clear();
                }
                else {
                    int IQ = Integer.parseInt(IQSpace.getText());
                    int hours = Integer.parseInt(hoursSpace.getText());
                    int wage = Integer.parseInt(wageSpace.getText());
                    hoursSpace.clear();
                    IQSpace.clear();
                    wageSpace.clear();
                    if (toolBar.hourlyBtnSelected()) {
                        personArray.createHourlyWorker(name, math, say, IQ, hours, wage);
                    }
                    else {
                        personArray.createContractWorker(name, math, say, IQ, hours, wage);
                    }
                }
            }
        });

    }

    /**
     * fills mainPane with the textfields and labels associated with creating a new person.
     */
    public VBox fillPane() {
        double setSpacing = 20;
        Label name = new Label("   Name:");
        nameSpace = new TextField();
        HBox row1 = new HBox(name, nameSpace);
        row1.setSpacing(setSpacing);
        Label math = new Label("   Math:");
        mathSpace = new TextField();
        HBox row2 = new HBox(math, mathSpace);
        row2.setSpacing(setSpacing + 4);
        Label say = new Label("   Say:");
        saySpace = new TextField();
        HBox row3 = new HBox(say, saySpace);
        row3.setSpacing(setSpacing + 14);
        VBox col = new VBox(row1, row2, row3);
        if (!toolBar.hobbitBtnSelected()) {
            Label IQ = new Label("   IQ:");
            IQSpace = new TextField();
            HBox row4 = new HBox(IQ, IQSpace);
            row4.setSpacing(setSpacing + 20);
            Label hours;
            Label wage;
            HBox row5 = new HBox();
            HBox row6 = new HBox();
            if (toolBar.hourlyBtnSelected()) {
                hours = new Label("   Hours:");
                wage = new Label("   Wage:");
                row5.setSpacing(setSpacing);
                row6.setSpacing(setSpacing + 1);
            }
            else {
                setSpacing = 70;
                hours = new Label("   Contracts");
                wage = new Label("   Pay Per Contract:");
                row1.setSpacing(setSpacing);
                row2.setSpacing(setSpacing + 4);
                row3.setSpacing(setSpacing + 14);
                row4.setSpacing(setSpacing + 20);
                row5.setSpacing(setSpacing - 16);
                row6.setSpacing(setSpacing - 56);
            }
            hoursSpace = new TextField();
            wageSpace = new TextField();
            row5.getChildren().addAll(hours, hoursSpace);
            row6.getChildren().addAll(wage, wageSpace);
            col.getChildren().addAll(row4, row5, row6);
        }
        else {
            Label carrots = new Label("   Carrots:");
            carrotSpace = new TextField();
            HBox row4 = new HBox(carrots, carrotSpace);
            row4.setSpacing(setSpacing - 6);
            col.getChildren().add(row4);
        }
        return col;
    }

    /**
     * fills mainPane with panes passed in from other methods
     *
     * @param center gets the pane that should be used for the center of mainPane
     * @param bottom gets the node that should be used for the bottom of mainPane
     */
    public void setupAdd(Pane center, Pane bottom) {
        Pane temp = new Pane();
        temp.setMinWidth(50);
        center.setMinWidth(25);
        mainPane.setCenter(center);
        mainPane.setBottom(bottom);
        mainPane.setLeft(temp);
    }

    /**
     * shows an alert letting the user know that their worker has been saved. Displays the name of the worker.
     *
     * @param name the name of the worker being saved to the ArrayList
     */
    public void showBeforeSave(String name) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You saved: " + name);
        alert.showAndWait();
    }
}
