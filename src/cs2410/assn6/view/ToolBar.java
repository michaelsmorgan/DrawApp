package cs2410.assn6.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * Created by Michael Morgan on 3/26/2017.
 * @version 1.0
 */
public class ToolBar extends HBox {
    /**
     * sets up a new ComboBox and togglebuttons for use in adding and viewing workers.
     */
    private ComboBox<String> combo = new ComboBox<>();
    private ToggleButton hourly = new ToggleButton("Hourly");
    private ToggleButton contract = new ToggleButton("Contract");
    private ToggleButton hobbit = new ToggleButton("Hobbit");


    /**
     * constructor for the toolBar, adds items to ComboBox, and adds the ComboBox and other buttons to the ToolBar
     */
    public ToolBar() {
        combo.getItems().addAll("Math", "Income", "Hours", "IQ", "Say", "Carrots", "Contracts");
        this.getChildren().addAll(combo, hourly, contract, hobbit);

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(hourly, contract,
                hobbit);


        this.setPadding(new Insets(10,10,10,10));
        this.setSpacing(5);
    }

    /**
     *
     * @return returns whether the hourly worker button is selected
     */
    public boolean hourlyBtnSelected() {
        return hourly.isSelected();
    }

    /**
     *
     * @return returns whether the contract worker button is selected
     */
    public boolean contractBtnSelected() {
        return contract.isSelected();
    }

    /**
     *
     * @return returns whether the hobbit button is selected
     */
    public boolean hobbitBtnSelected() { return hobbit.isSelected(); }

    /**
     *
     * @return returns the option selected on the ComboBox as a String
     */
    public String comboSel() { return combo.getValue();}

    /**
     *
     * @param event   allows for an action to take place when the hourly button is selected
     */
    public void setHourlyBtnAction(EventHandler<ActionEvent> event) {hourly.setOnAction(event);}

    /**
     *
     * @param event   allows for an action to take place when the contract button is selected
     */
    public void setContractBtnAction(EventHandler<ActionEvent> event) {contract.setOnAction(event);}

    /**
     *
     * @param event   allows for an action to take place when the hobbit button is selected
     */
    public void setHobbitBtnAction(EventHandler<ActionEvent> event) {hobbit.setOnAction(event);}

    /**
     *
     * @param event allows for an action to take place when an option from the ComboBox is selected
     */
    public void setComboAction(EventHandler<ActionEvent> event) {combo.setOnAction(event);}
}

