package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Joshua Federman
 */
public class SetGetItem {
    private static String description;
    private static boolean isComplete;

    public static java.lang.String getDescription() {
        return description;
    }

    public static String getDate(String date) {
        return date;
    }

    public static String setDescription(String description) {
        SetGetItem.description = description;
        return SetGetItem.description;
    }

    public static boolean isIsComplete() {
        return isComplete;
    }

    public static void setIsComplete(boolean isComplete) {
        SetGetItem.isComplete = isComplete;
    }
}
