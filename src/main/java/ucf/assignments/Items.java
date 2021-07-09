package ucf.assignments;

import java.util.ArrayList;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class Items {
    private static String name;

    public String addItem(String itemName){

        //check if the item already exists or if the list has 100 items
        //if both are false, add the item
        //else do not add the item
        //returns item that was added
        return "";
    }

    public String removeItem(String itemName){
        //loop through items to search for string itemName
        //if found, delete the item from the list
        //else, nothing happens
        //returns removed item
        return "";
    }

    public String itemsToString(){
        //converts a list of items into string and returns it
        return "";
    }

    public String completeItemsToString(){
        //loops through list to find complete items
        //  if complete, it is added to the string
        //  if not, continue until list is cycled completely
        //return the string of complete items
        return "";
    }
    public String incompleteItemsToString(){
        //loops through list to find complete items
        //  if incomplete, it is added to the string
        //  if not, continue until list is cycled completely
        //return the string of complete items
        return "";
    }
    public boolean isComplete(){
        //if an item is complete, it returns true
        //else, return false
        return false;
    }
}
