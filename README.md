# ENSF 480 Term Project: Rental Management System - Rental.jar

## Group 15: Amanda Nguyen, Liam Parmar, Vrund Patel, Kaumil Patel

### INSTRUCTIONS

1. Ensure you have a MySQL connection with the following criteria:

    - username: ensf480
    - password: ensf480password
    - host: 127.0.0.1
    - port: 3306

#### This must match the information in ./src/Database/account.properties, otherwise MySQL errors will occur.

2. Ensure you have a properly initialized database.

    - You can run the one provided titled "database.sql".

3. Run the program using the following line in the command prompt or execute the jar file:

    - "java -jar ENSF480TermProjectGroup15.jar"

4. Use the program as instructed.

### Notes

-   The manager report is made based on the statuses update date. Properties rented within the period include properties that have had their status changed to occupied within the period.

    -   Property history (logs) are automatically initialized with the database property statuses.

    -   Properties that begin with the occupied status will be added to the list of properties rented in the current period and logged as rented starting on the current date. See the logs table for more clarification.

-   An account may only have one type and cannot be used for multiple account functions (i.e. cannot be a renter and landlord type at the same time).
