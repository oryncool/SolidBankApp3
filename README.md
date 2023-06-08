# Solid Bank App

### Launching a program
To launch this project on your computer, you need to download this project
on your computer, open it with an IDE(preferably Intellij IDEA)
and wait until all dependencies are downloaded and imported to the project
After that, run main SolidBankAppApplication class and input your data using console.
Alternatively, you can run this project using CLI.

### Getting Started
This is a prototype of banking application made for Java Backend
course by Jusan Singularity using Spring Boot.
Possible commands are shown below:

- 1 : Show all existing accounts
- 2 : Add a new account
- 3 : Deposit money to existing account
- 4 : Withdraw money from existing account
- 6 : Show a message with commands available
- 7 : Close application

### Notes: 
- There are three possible types of account : `CHECKING`, `SAVING`
and `FIXING`. The only difference is that there is no possibility to withdraw money from `FIXING` account.
- `props.xml` file with a path `src\main\resources\props.xml` contains all configurations needed to create objects
- `.gitignore` file which includes file names that should not be cloned to git repository

### Folder Structure
- `src\main\java` - folder containing all classes and interfaces
- `src\main\resources` - folder with configurations
- `src\test` - folder with testcases


