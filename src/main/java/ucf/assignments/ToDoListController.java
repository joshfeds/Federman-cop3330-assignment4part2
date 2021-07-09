package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class ToDoListController{
    @FXML
    public javafx.scene.control.TextField textItem;
    @FXML
    public javafx.scene.control.ListView itemDisplay;

    @FXML
    public void selectItemButton(ActionEvent actionEvent) {

        //this button allows an item to be modified, saved, etc.
        //in order for this to work, we call getItemAsString to get the lists we want
        // then display in our ListView
        //unless specified, the lists shall all appear
    }
    @FXML
    public void displayIncompleteListButton(ActionEvent actionEvent) {
        //this button shows all incomplete items in a to-do list
        //in order for this to work, we need to call getIncompleteItems, which will
        //return the incomplete lists as a string to display
        //it will display in the TextArea
    }
    @FXML
    public void displayCompleteItemsButton(ActionEvent actionEvent) {
        //this button shows all complete items in a to-do list
        //in order for this to work, we need to call getCompleteItems, which will
        //return the complete lists as a string to display
        //it will display in the TextArea
    }
    @FXML
    public void displayListItemsButton(ActionEvent actionEvent) {
        //shows all items from a list that has been selected
        //to get this to work, we call itemsToString with the parameter of the list selected
        //
        //it will display in the TextArea
    }
    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
        //An item have to be selected
        //This button will remove the selected item from the selected list
        //to do this, we call removeItem in the Items class given a list
    }
    @FXML
    public void addItemButton(ActionEvent actionEvent) {
        String s = textToStringButton(actionEvent);
        itemDisplay.getItems().add(s);
        //list has to be selected
        //this button adds a single item to a list given by the TextArea
        //we will call addItem in Items to act this button out
    }
    @FXML
    public void editItemDescriptionButton(ActionEvent actionEvent) {
        //list and item have to be selected.
        //this button will give an item a new description
        //we call
    }
    @FXML
    public void editItemDateButton(ActionEvent actionEvent) {
        //Make sure a list and item has been selected.
        //Updates an items with a new due date
    }
    @FXML
    public void markItemCompleteButton(ActionEvent actionEvent) {
        //this button will change an item to be marked as complete
    }
    @FXML
    public void saveListButton(ActionEvent actionEvent) {
        //this button will load a list that has been selected
    }
    @FXML
    public void loadListButton(ActionEvent actionEvent) {
        //this button will load a single list from file
    }
    @FXML
    public String textToStringButton(ActionEvent actionEvent) {
        String test = textItem.getText();
        return test;
    }
}
