package ucf.assignments;

import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFunctionsTest {

    @Test
    void isWithinLimit_true() {
        //create ListFunction class and boolean cases
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = true;
        //string will be within limit
        String text = "Legal!";
        //pass text through function and assert equals
        boolean actual = listFunctions.isWithinLimit(text);
        assertEquals(expected, actual);
    }
    @Test
    void isWithinLimit_false_zero() {
        //create ListFunction class and boolean cases
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = false;
        //no text
        String text = "";
        //pass text through function and assert equals
        boolean actual = listFunctions.isWithinLimit(text);
        assertEquals(expected, actual);
    }
    @Test
    void isWithinLimit_false_256() {
        //create ListFunction class and boolean cases
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = false;
        //choose the lyrics for the last song you listened to on spotify
        String text = "Cheers\n" +
                "Sippin' codeine like it's beer\n" +
                "I'm in London, so I'm screaming cheers\n" +
                "Man of the year, still got problems\n" +
                "Lookin' in the mirror, you look awful\n" +
                "Talkin' to myself, do it too often\n" +
                "JK, Juice WRLD, you're so awesome\n" +
                "I'm running up funds\n" +
                "Bottle full of pills, let's have fun\n" +
                "No cheap thrills, only rich ones\n" +
                "Fire drills, hotter than the sun\n" +
                "My ups and downs\n" +
                "I'll jot them down\n" +
                "In London town\n" +
                "Cheers to the golden years\n" +
                "Let's raise our hands, let's sing and dance\n" +
                "I know my lyrics saved you, I know my lyrics saved you\n" +
                "Let's raise our hands and sing and dance\n" +
                "I know my lyrics saved you, I know I helped you break through\n" +
                "They say life's a puzzle, all my pieces together\n" +
                "But from the way I'm movin' up\n" +
                "I'll prolly be piecing forever\n" +
                "I date a bad bitch, she'll be young and decent forever\n" +
                "Even with fake tits, these other hoes, she's decent forever\n" +
                "My lady said she saw a baddie in the hotel lobby\n" +
                "Well love, let's fuck her together\n" +
                "We got the world to our backs, give a fuck\n" +
                "Never have, middle fingers up, we screaming fuck 'em forever\n" +
                "My ups and downs\n" +
                "I'll jot them down\n" +
                "In London town\n" +
                "Cheers to the golden years\n" +
                "My ups and downs\n" +
                "I'll jot them down\n" +
                "In London town\n" +
                "Cheers to the golden years\n" +
                "Let's raise our hands, let's sing and dance\n" +
                "I know my lyrics saved you, I know my lyrics saved you\n" +
                "Let's raise our hands and sing and dance\n" +
                "I know my lyrics saved you, I know I helped you break through";
        //pass text through function and assert equals
        boolean actual = listFunctions.isWithinLimit(text);
        assertEquals(expected, actual);
    }

    @Test
    void isValidDate_true() {
        //create listFunctions and boolean
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = true;
        //text will be a date and assertequals
        boolean actual = listFunctions.isValidDate("2002-08-11");
        assertEquals(expected, actual);
    }
    @Test
    void isValidDate_false() {
        //create listFunctions and boolean
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = false;
        //give invalid date at assertEquals
        boolean actual = listFunctions.isValidDate("11-08-2002");
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        //create listFunction and boolean values
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = true;
        //list will be empty and assert equals
        boolean actual = listFunctions.isEmpty(0);
        assertEquals(expected, actual);
    }
    @Test
    void isNotEmpty() {
        //create listFunction and boolean values
        ListFunctions listFunctions = new ListFunctions();
        boolean expected = false;
        //list will not be empty and assert equals
        boolean actual = listFunctions.isEmpty(23749);
        assertEquals(expected, actual);
    }
}