package ucf.assignments;

import javafx.fxml.FXML;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class ListFunctions {

    @FXML
    public String editItem(javafx.scene.control.TextField textItem){
        return textItem.getText();
    }

    public boolean isWithinLimit(String text){
        if(text.length() < 1 || text.length() > 256)
            return false;
        return true;

    }
    public boolean isValidDate(String text){

        //try-catch to return false if the text is not valid date
        try{
            LocalDate.parse(text, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }
    public boolean isEmpty(int number) {
        if (number == 0)
            return true;
        else
            return false;
    }
}
