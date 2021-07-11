package ucf.assignments;

import javafx.fxml.FXML;

import java.awt.*;
import java.util.ArrayList;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class ListFunctions {

    private static ArrayList<String> megaList;
    private static TextArea textArea;
    @FXML
    public String addItem(javafx.scene.control.TextField textItem){
        return textItem.getText();
    }

    public void removeList(String listName){
        /*Searches for the string given within the megaList using for loop
            if found, remove the list from megaList
                since there can be duplicates, do not stop at first list found
            if not, continue until all lists have been iterated through
         */
    }
    public void editListName(String listName){
        //search through megaList for the given string
        //when found, strcpy the listName to the original list to replace
        //do this for all identical name copies
    }
    public String getLists(String name){
        //calls the listToString function within a loop of megaList and returns the string
        //a /n will be needed so everything isnt on one line
        return "";
    }

    public String getListItems(String listName){
        //Search megaList for list name.
        //Make a String list of name's items by calling and returning listAsString
        return "";
    }
    public boolean listExistsFile(){
        //this function will be called to determine if a list is in a file
        //return true if it is, else return false
        return false;
    }
    public void saveList(String listName){
        //saves a single list into a file(likely json or txt)
        //file will be in it's own directory
        //the list will be converted to String using listToString
        //a /n will be appended so the lists can be differentiated from
        //we will have to count this lists in the file, as we don't want to have over 100 lists
        //to be later loaded
        //in this case, a file will not save
    }

    public void saveAllLists(){
        //saves all lists into a file
        //the lists will be converted to String using listToString
        //a /n will be appended so the lists can be differentiated from
    }

    public void loadList(String listName){
        //using string name, a file is searched until the list name is found
        //to search, some sort of string parser will have to be used (JSON may help with this more than txt)
        //once found, the list will be added to megaList and removed from the file(will have to determine if this is reasonable)
        //if not found, no list will be loaded :(
        //a list count check will also have to be tested for
    }

    public void loadAllLists(){
        //all lists within a file will be loaded into megaList,
        //wiping any lists that have not been saved to prevent an overload
    }
}
