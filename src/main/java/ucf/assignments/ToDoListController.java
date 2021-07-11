package ucf.assignments;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;

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
    public ListFunctions listFunctions = new ListFunctions();
    @FXML
    public void initialize(){
        itemDisplay.setItems(filteredList);
    }
    @FXML
    public void addItemButton(ActionEvent actionEvent) {
        //call textToStringButton to grab the text
        String s = textToStringButton(actionEvent);
        //add the string to the arrayList
        arrayList.add(new Item(s));

    }
    @FXML
    public void removeItemButton(ActionEvent actionEvent) {
        //the focusedIndex allows us to know an item has been selected from itemDisplay
        int focusedIndex = itemDisplay.getFocusModel().getFocusedIndex();
        //if focus is selected
        if(focusedIndex > -1)
        {
            //sourceIndex is where we will be removing from
            int sourceIndex = filteredList.getSourceIndex(focusedIndex);
            arrayList.remove(sourceIndex);
        }

    }
    @FXML
    public void displayIncompleteListButton(ActionEvent actionEvent) {
        //the filtered list will go through item.isComplete and display all incomplete items
        filteredList.setPredicate(item -> !item.isComplete());

    }
    @FXML
    public void displayCompleteItemsButton(ActionEvent actionEvent) {
        // //the filtered list will go through item.isComplete and display all complete items
        filteredList.setPredicate(item -> item.isComplete());
    }
    @FXML
    public void displayListItemsButton(ActionEvent actionEvent) {
        //defaults to all lists regardless of status
        filteredList.setPredicate(item -> true);
    }

    @FXML
    public void editItemDescriptionButton(ActionEvent actionEvent) {
        //gets the selected item we want to edit
        Item item = getCurrentItem();
        //sets the description from the textToStringButton
        item.setDescription(textToStringButton(actionEvent));
        //refreshes display so the item doesn't need to be clicked off
        //to see updated item
        itemDisplay.refresh();

    }
    @FXML
    public void editItemDateButton(ActionEvent actionEvent) {
        //gets the current item selected
        Item item = getCurrentItem();
        //grabs the due date
        item.setDueDate(textToStringButton(actionEvent));
        //refreshes display so the item doesn't need to be clicked off
        //to see updated item
        itemDisplay.refresh();
    }
    @FXML
    public void markItemCompleteButton(ActionEvent actionEvent) {
        //gets the item selected from itemDisplay
        Item item = getCurrentItem();
        //changes boolean value of isCompelte to true
        item.setComplete(true);
        //refreshes display so the item doesn't need to be clicked off
        //to see updated item
        itemDisplay.refresh();
    }
    @FXML
    public void saveListButton(ActionEvent actionEvent) {
        JsonObject object = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for(int i = 0; i < arrayList.size(); i++){
            object.addProperty("Item " + (i + 1), arrayList.get(i).toString());
        }
        jsonArray.add(object);
        try {
            FileWriter writer = new FileWriter("resources/SaveItemData.json");
            writer.write(object + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void loadListButton(ActionEvent actionEvent) throws FileNotFoundException {
        File reader = new File("resources/SaveItemData.json");
        JsonElement file = JsonParser.parseReader(new FileReader(reader));
        JsonArray object = file.getAsJsonArray();
        arrayList.add(new Item(object.toString()));



    }
    @FXML
    public String textToStringButton(ActionEvent actionEvent) {
        //returns whatever text is in the text box
        return listFunctions.addItem(textItem);
    }
    public Item getCurrentItem(){
        //grabs index within listView
        int focusedIndex = itemDisplay.getFocusModel().getFocusedIndex();
        //sends index of the item and retuns
        Item item = arrayList.get(focusedIndex);
        return item;
    }
}
