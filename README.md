# ENSF 480 Term Project: Rental Management System - Rental.jar

#### Group 15: Amanda Nguyen

## REQUIREMENTS

1. Ensure you have a MySQL connection with the following criteria:
   username: ensf480
   password: ensf480password
   host and port: 127.0.0.1:3306
   This must match the information in ./src/Database/account.properties, otherwise MySQL errors will occur.
2. Ensure you have a properly initialized database. You can run the one provided in "database.sql".

## INSTRUCTIONS

1. Run the program using the following line in the command prompt:
   "java -jar Rental.jar"

2. The panel shows "Please Enter a Username"
   -Enter your MySQL username (eg. "scm"). This is case-sensitive.
   -Hit "Enter".

3. The panel shows "Please Enter a Password"
   -Enter your MySQL password (eg. "ensf480"). This is case-sensitive.
   -Hit "Enter".
   If either the username or password are invalid, the panel will show
   "Invalid Username or Password, Try Again?"
   -Click "Repeat" to return to step (2).
   If the username and password are valid, the program will continue to step (4).
