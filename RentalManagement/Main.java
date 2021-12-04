/**
 * ENSF 480: Term Project - Rental.jar
 * Group 15: Amanda Nguyen, 
 * 
 * @author Amanda <a href="mailto:amanda.nguyen1@ucalgary.ca"> amanda.nguyen1@ucalgary.ca</a>
 * @author 
 * @author 
 * @author 
 * @version 1.6
 * @since 1.0
 */

/*
<!--INSTRUCTIONS-->


(1)Run the program using the following line in the command prompt:
"java -jar Furniture.jar"

(2)The panel shows "Please Enter a Username"
-Enter your MySQL username (eg. "scm"). This is case-sensitive.
-Hit "Enter".

(3)The panel shows "Please Enter a Password"
-Enter your MySQL password (eg. "ensf409"). This is case-sensitive.
-Hit "Enter".

If either the unsername or password are invalid, the panel will show
"Invalid Username or Password, Try Again?"
-Click "Repeat" to return to step (2).

If the username and password are valid, the program will continue to step (4).

*/

package RentalManagement;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * The Main class house the main method that is use to run the program
 */
public class Main{
    /**
     * The main method is use to run the program First, it makes a connection to the
     * database using the promted user input. Then it tries to find the lowest
     * priced combination for the requested item (Which is also taken in through a
     * promted input). An output is produced detailed the success/fail of the order
     * and process can be repeated.
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.exit(0);
    }
}