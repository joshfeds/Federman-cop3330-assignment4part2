package ucf.assignments;

import com.github.cliftonlabs.json_simple.JsonObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.FileWriter;
import java.io.IOException;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class ToDoListController{
    @FXML
    public javafx.scene.control.TextField textItem;
    @FXML
    public javafx.scene.control.ListView itemDisplay;

    public ObservableList<Item> arrayList = FXCollections.observableArrayList();

    public FilteredList<Item> filteredList = new FilteredList<Item>(arrayList);
    @FXML
    public void initialize(){
        itemDisplay.setItems(filteredList);
    }
    @FXML
    public void addItemButton(ActionEvent actionEvent) {
        String s = textToStringButton(actionEvent);
        arrayList.add(new Item(s));
        //list has to be selected
        //this button adds a single item to a list given by the TextArea
        //we will call addItem in Items to act this button out
    }
    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
        var focusedIndex = itemDisplay.getFocusModel().getFocusedIndex();
        if(focusedIndex > -1)
        {
            var sourceIndex = filteredList.getSourceIndex(focusedIndex);
            arrayList.remove(sourceIndex);
        }
        //An item have to be selected
        //This button will remove the selected item from the selected list
        //to do this, we call removeItem in the Items class given a list
    }
    @FXML
    public void displayIncompleteListButton(ActionEvent actionEvent) {
        filteredList.setPredicate(item -> !item.isComplete());
        //this button shows all incomplete items in a to-do list
        //in order for this to work, we need to call getIncompleteItems, which will
        //return the incomplete lists as a string to display
        //it will display in the TextArea
    }
    @FXML
    public void displayCompleteItemsButton(ActionEvent actionEvent) {
        filteredList.setPredicate(item -> item.isComplete());
        //this button shows all complete items in a to-do list
        //in order for t
        // his to work, we need to call getCompleteItems, which will
        //return the complete lists as a string to display
        //it will display in the TextArea
    }
    @FXML
    public void displayListItemsButton(ActionEvent actionEvent) {
        filteredList.setPredicate(item -> true);
        //shows all items from a list that has been selected
        //to get this to work, we call itemsToString with the parameter of the list selected
        //
        //it will display in the TextArea
    }

    @FXML
    public void editItemDescriptionButton(ActionEvent actionEvent) {
        var item = getCurrentItem();
        item.setDescription(textToStringButton(actionEvent));
        itemDisplay.refresh();
        //list and item have to be selected.
        //this button will give an item a new description
        //we call
    }
    @FXML
    public void editItemDateButton(ActionEvent actionEvent) {
        var item = getCurrentItem();
        item.setDueDate(textToStringButton(actionEvent));
        itemDisplay.refresh();
        //Make sure a list and item has been selected.
        //Updates an items with a new due date
    }
    @FXML
    public void markItemCompleteButton(ActionEvent actionEvent) {
        var item = getCurrentItem();
        item.setComplete(true);
        itemDisplay.refresh();
        //this button will change an item to be marked as complete
    }
    @FXML
    public void saveListButton(ActionEvent actionEvent) {
        JsonObject object = new JsonObject();

        try {
            FileWriter writer = new FileWriter("resources/SaveItemData.json");
            for(int i = 0; i < arrayList.size(); i++){
                object.put("Item " + i, arrayList.get(i).toString());
                writer.write("\n");
            }
            writer.write(object.toJson());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void loadListButton(ActionEvent actionEvent) {

    }
    @FXML
    public String textToStringButton(ActionEvent actionEvent) {
        return textItem.getText();
    }
    public Item getCurrentItem(){
        var focusedIndex = itemDisplay.getFocusModel().getFocusedIndex();
        var item = arrayList.get(focusedIndex);
        return item;
    }
}
