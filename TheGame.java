
/**
 * CONWAYS GAME OF LIFE
 *
 * @author Frances Till
 * @version 3.4.2
 * (term 3, week 6, day 1 (monday))
 * 
 * The purpose of this code is to run Conway's Game of Life. 
 * It is for a term 2 & 3 project, for NCEA Computer Science (AS91896)
 * This code is written 100% in java. 
 * All credit for the rules of the game go to John Conway. 
 * Furhter information about Conway's game can be found here: 
 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 * 
 * This code is run in terminal, typically doesn't need any extra components or files to run, 
 * except for interactions between the game and external .txt files. 
 * if you want to read files and write to files;
 * you need to place those files in the same location as this code
 * Those files should be text files. (.txt suffixes)
 * 
 */

//IMPORTS
import java.util.concurrent.TimeUnit; //import for the timer between printing generations
import java.util.Random; //import to randomly populate the board 
import java.util.Scanner; //import to take input
import java.util.Timer; //another import for the timer between printing generations
import java.io.File; //import for handling files (to save and load grids from file)
import java.io.IOException; //import for handling exceptions (used when working with files and input)
import java.io.FileWriter; //import for writing grids into files (to save and load later)
//------ 

public class TheGame 
{
    //VARIABLES 

    //ARRAYS

    int mapThreeDime[][][];// = new int[10][10][5]; //makes the 3D grid when populating happens in a loop 

    //PRESETS BELOW
    //Note - both of these presets are prediscovered patterns widley known about. 
    // These are generally referred to as oscillators. 
    //A full list of osiclaltors, and those who discovered them, can be found here
    //https://conwaylife.com/wiki/Oscillator

    //pattern to apply for the glider pattern preset when loading a file
    //about this specifc oscillator:  https://conwaylife.com/wiki/Glider
    int[][] gliderPreset = {{1, 2, 0, 1, 2},{-2, -1, 0, 0, 0}}; 

    //pattern to apply for the pulsar pattern preset when loading a file
    //about this specifc oscillator:  https://conwaylife.com/wiki/Pulsar
    int[][] pulsarPreset = {{-4, -3, -2, 2, 3, 4, -6, -1, 1, 6, -6, -1, 1, 6, -6, -1, 1, 6, -4, -3, -2, 2, 3, 4, -4, -3, -2, 2, 3, 4, -6, -1, 1, 6, -6, -1, 1, 6, -6, -1, 1, 6, -4, -3, -2, 2, 3, 4},{6, 6, 6, 6, 6, 6, 4, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -3, -3, -3, -3, -4, -4, -4, -4, -6, -6, -6, -6, -6, -6}}; 
    //---------

    //INTEGER VARIABLES

    //NON-SETUP SINGULAR VARIABLES
    int selected = 1; //refers to menu option selected
    int numberOfGenerations = 0; // run so far (counts up in running the game)
    int placeHolder = 0; //used when passing place holder values through methods, when these methods sometimes need input there but not for that current thing
    int border = 10;
    //------

    //SINGULAR SETUP INTEGER VARIABLES
    int size; //of the grid 
    int timeWaiting; //between generations 
    int howManyGenerationsAreWeDoing; 
    int widthOfGrid = 10; 
    int heightOfGrid = 10; 
    int numberOfHistoriesRecorded = 5; 
    int heightOfGridPrinting;
    int widthOfGridPrinting;
    int beginning;
    //-----

    //BOUNDARYTYPE INTEGERS
    //intialised in the setup method, reference what boundary the grid will run
    int boundaryType; 
    final int FINITEBOUNDARYTYPE = 1; 
    final int WRAPPINGBOUNDARYTYPE = 2;
    final int INFINITEBOUNDARYTYPE = 3; 
    //----

    //FILETYPE INTEGERS 
    //intialised in first & second menu, reference how the grid will be populated
    int fileType; 
    final int POPULATEFROMAGRIDFILETYPE = 0;
    final int LEAVEBLANKFILETYPE = 1;
    final int POPULATEWITHRANDOMFILETYPE = 2; 
    final int POPULATEWITHAGLIDERFILETYPE = 3;
    final int POPULATEWITHAPULSARFILETYPE = 4;

    //PRESETS FOR FILETYPES 3 & 4
    final int GLIDERPRESETTYPE = 1;
    final int PULSARPRESETTYPE = 2;
    //------

    //INTERGER VALUES FOR RULES
    int historyCurrent = 0; 
    int shallItBeAlive;  
    int boundedFence = 0;
    int topLeft = 0;
    int topMiddle = 0;
    int topRight = 0;
    int left = 0;
    int right = 0;
    int bottomLeft = 0;
    int bottomMiddle = 0;
    int bottomRight = 0;
    int neighboursValue = 0;
    //------

    //BOOLEAN VARIABLES
    boolean thisIsRunning = true; //this is turned to true if the user chooses not to quit
    boolean selectionScreen; 
    //----

    //STRING VARIABLES
    //intialised in setup
    String deadCellSymbol;
    String aliveCellSymbol;
    String fileNameAsAString;
    //-----

    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        Scanner keyboard = new Scanner(System.in);
        int goingThrough; //used when asking yes or no questions 

        //MENU START-UP TEXT
        System.out.println("HI! This is my AS91896 project, Conway's Game Of Life");
        System.out.println("All credit for the rules and idea to Jonh Conway.");
        System.out.println("More information can be found here: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life");
        System.out.println("                Welcome to the menu");
        System.out.println("                There are a couple options to chose from");
        System.out.println("                1. Read from a file");
        System.out.println("                2. Load a grid");
        System.out.println("                3. Quit");

        //DECIDE
        int whatWeAreDoing = doingMenuOption(1, 1); // deciding which menu option you've selected 
        System.out.println(whatWeAreDoing);

        //GAME IF STATEMENT
        if(whatWeAreDoing == 1 || whatWeAreDoing == 2){ // IF YOU WANT TO PLAY THE GAME

            if(whatWeAreDoing == 1){ // if we are loading a file specifcally from a file
                System.out.println("Now, the grid will be populated from a gien text file");
                fileNameAsAString = getFileName("Please input the text file name. Remeber .txt at the end!", true);
                fileType = POPULATEFROMAGRIDFILETYPE; 
                setup(fileType); 
            }else if (whatWeAreDoing == 2){ // if you are loading a file 
                // MENU FOR LOADING A GRID 
                System.out.println("                Welcome to the menu of grid options to load");
                System.out.println("                There are a couple options to chose from");
                System.out.println("                1. A Blank grid (for new creations)");
                System.out.println("                2. Random grid of ones and zeroes");
                System.out.println("                3. Populate with a Glider ");
                System.out.println("                4. Populate with a pulsar ");

                fileType = doingMenuOption(placeHolder, 2); //deciding which filetype to run
                setup(fileType); 
            }
        }else if(whatWeAreDoing == 3){ //this means if the user chooses to quit 
            System.out.println("You've chosen to quit, so thanks for opening the game, have a great day!");
            System.out.println("~ Game Over ~");
            thisIsRunning = false;  
        }
        int mapThreeDime[][][] = new int[heightOfGrid][widthOfGrid][numberOfHistoriesRecorded];//initialises array for grid. Occurs here, because set up was executed above
        if(thisIsRunning == true){
            switch (fileType){ //does different population methods based on the filetype
                case POPULATEFROMAGRIDFILETYPE: 
                    populateBoardFromAFile(mapThreeDime);
                    break;
                case LEAVEBLANKFILETYPE: 
                    break;
                case POPULATEWITHRANDOMFILETYPE: 
                    populateBoardWithRandom(mapThreeDime);
                    break;
                case POPULATEWITHAGLIDERFILETYPE: 
                    populateBoardWithAGlider(mapThreeDime, placeHolder, placeHolder, 1);
                    printIt(0, mapThreeDime);
                    break;
                case POPULATEWITHAPULSARFILETYPE: 
                    populateBoardWithAGlider(mapThreeDime, placeHolder, placeHolder, 2);
                    printIt(0, mapThreeDime);
                    break;
            }

            changeCells(mapThreeDime); // allows the user to edit indivual cells
            runGame(thisIsRunning, numberOfGenerations, howManyGenerationsAreWeDoing, mapThreeDime, boundaryType);
            
            System.out.println("Do you want to save your game to a file?");
            goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
            if(goingThrough == 1){ //if it's one, thats a yes, and do 
                fileNameAsAString = getFileName("Please input the text file name. Remeber .txt at the end!", false);
                System.out.println("Do you wan to save the end of the game, or the start?");
                System.out.println("Do you wan to save the end of the game? (saying no means the start will be saved)");
                goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
                if(goingThrough == 1){
                    writingToAFile(mapThreeDime, 0);
                }else{
                    int history = numberOfHistoriesRecorded - 1;
                    writingToAFile(mapThreeDime, history);
                }
            }else{
                System.out.println("All goods! Thanks for playing!");
            }

            System.out.println("Thanks for playing! The game is over now, unless you would like to run a few more generations of your game?"); 
            System.out.println("Do you want to run a few more generations?");
            goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
            if(goingThrough == 1){ //if it's one, thats a yes, and do 
                howManyGenerationsAreWeDoing = returnInteger("how many more generations should I run? (max = 1000, min = 1)", 1, 1000);
                runGame(thisIsRunning, numberOfGenerations, howManyGenerationsAreWeDoing, mapThreeDime, boundaryType);
            }else{
                System.out.println("Alrighty, we won't run the game anymore");
            }
        }
    }

    //This method collates the neighbourValues which decide if the cell should live or die
    public int finiteBoundary(int yCoord, int xCoord, int[][][] mapThreeDime){
        int end = size - 1; 
        historyCurrent = 0;
        int toAdd = 0;
        int historyPrevious = historyCurrent + 1; // if used for getting values of enighbours which have alrerady been updated to the next gen
        neighboursValue = 0; //will be changed/formed
        for(int yCoordModifier = -1; yCoordModifier < 2; yCoordModifier++){
            for(int xCoordModifier = -1; xCoordModifier < 2; xCoordModifier++){
                int newYCoord = yCoordModifier + yCoord;
                int newXCoord = xCoordModifier + xCoord;
                if(newYCoord < 0 || newXCoord  < 0 || newYCoord > end || newXCoord > end){
                    if(boundaryType == WRAPPINGBOUNDARYTYPE){
                        toAdd = wrappingBoundary(yCoord, xCoord, newYCoord, newXCoord, yCoordModifier, xCoordModifier, mapThreeDime); //if the boundary is wrapping, call a specifal method for edge cases
                        neighboursValue += toAdd; // and add that to the neighbours value
                    }else if (boundaryType == FINITEBOUNDARYTYPE || boundaryType == INFINITEBOUNDARYTYPE){ //if the boundary types are infinite or finite 
                        //infinite boundaries are the same as finite, but with a buffer of cells around, to create a pseudo-infinite boundary
                        neighboursValue += boundedFence; // add the bounded fence
                    }
                }else{
                    if(yCoordModifier == -1 || (yCoordModifier == 0 && xCoordModifier == -1)){ // if the cell has already been written over
                        neighboursValue += mapThreeDime[newYCoord][newXCoord][historyPrevious];
                    }else { // ad if it has not
                        neighboursValue += mapThreeDime[newYCoord][newXCoord][historyCurrent];
                    }
                }
            }
        }
        neighboursValue -= mapThreeDime[yCoord][xCoord][historyCurrent]; // remove the value of the selected cell itself
        shallItBeAlive = applyGameRules(yCoord, xCoord, neighboursValue, mapThreeDime, historyCurrent); // calls the method which asks if the nieghboursvalue means the cell will live or die
        return shallItBeAlive;
    }

    //method which calls the boundary on just edge cases, used just for the wrapping boundary cells
    public int wrappingBoundary(int yCoord, int xCoord,int newYCoord, int newXCoord,int yCoordModifier, int xCoordModifier, int[][][] mapThreeDime){//pass it the coord of the point, so we know what point we're investigating{
        // interrogates just one cell at a time 
        int end = size - 1;
        historyCurrent = 0;
        int historyPrevious = historyCurrent + 1;
        int length = size;
        int boundaryNeighbour = 0;
        // if the y coord is off the grid, it flips to the other side
        if(newYCoord < 0){ 
            newYCoord = end;            
        }else if (newYCoord > end){
            newYCoord = 0;
        }
        //and same for the x values
        if (newXCoord > end){
            newXCoord = 0;
        }else if (newXCoord < 0){
            newXCoord = end;
        }

        if(newYCoord < yCoord || (newYCoord == yCoord && newXCoord < xCoord)){ //once again. changes whether you need a cell that's already bee updated or not                                                                            
            boundaryNeighbour += mapThreeDime[newYCoord][newXCoord][historyPrevious];
        }else {
            boundaryNeighbour += mapThreeDime[newYCoord][newXCoord][historyCurrent];
        }
        return boundaryNeighbour; // returns the one cell value
    }

    public int applyGameRules(int yCoord, int xCoord, int neighboursValue, int[][][] mapThreeDime, int historyCurrent){
        int shallItBeAlive = 2;
        //and now, below are the conway's rules. These are pretty much directly translated into code
        if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){ //if the selected cell is currently alive
            //System.out.println("Alive");
            if(neighboursValue < 2 || neighboursValue > 3){ // if the neighboursValue is less than two, the cell will die (underpopulation) or if it's more than three, the cell will die (overpopulation)
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
            }else if(neighboursValue == 2 || neighboursValue == 3){ //if it's 2 or three, the cell remains alive 
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
            }
        }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){ //if the selected cell is currently dead
            if(neighboursValue == 3){ // and it has three live neighbours, it becomes alive 
                shallItBeAlive = 1;  //works similarly as above
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);
            }else { //for every other value, it remains dead
                shallItBeAlive = 0; 
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);
            }
        }else{ //if the selected cell is neither dead nor alive, then the system prints an error 
            System.out.println("error");
            shallItBeAlive = 2; //returns an unreal value for this context (neither dead or alive, will break the code (hopefull) so the error is conveyed)
        }
        //this is a return statement for if none of the above options happen. It is an unreal statement (in context) and will break the code
        return shallItBeAlive;
    }

    //this history replacer moves the genration back one in the 3D array 
    public void historyReplacer(int yCoord, int xCoord, int living, int[][][] mapThreeDime){ 
        int toMove = living; // gets the new, updated value
        int assign; 
        int lastOne = numberOfHistoriesRecorded - 1; 
        for(int h = 0; h < numberOfHistoriesRecorded; h++){ 
            if(h == lastOne){ // if this is the last/end of the history row
                assign = toMove; 
                mapThreeDime[yCoord][xCoord][h] = assign;  // just doesn't get a new valiue
            }else{
                assign = toMove; // gives moving value to assign
                toMove = mapThreeDime[yCoord][xCoord][h]; //gets a new value to move 
                mapThreeDime[yCoord][xCoord][h] = assign; // puts the value in the updated place
            }
        }
    }

    //method to ask the user a question, returns different values for yes and no and invalid answers
    public int yesOrNoQuestionMethod(int yesOrNo){ 
        Scanner keyboard = new Scanner(System.in); 
        //takes userInput, mainuplates it into the simplest form, so it can compare to the simplest form in the if statement
        String userInput = keyboard.nextLine(); //creates 'userInput' as a string variable, assigns it the just receieved input
        userInput = userInput.toLowerCase().trim(); //converts it to lowercase and trims it 

        if(userInput.equals("yes")||userInput.equals("y")){ //if it receives yes
            yesOrNo = 1;
        }else if (userInput.equals("no")||userInput.equals("n")){ //if it receives no
            yesOrNo = 2;
        }else{ //if it gets an invalid answer
            System.out.println("sorry that was an invalid input. Try yes or no, or y/n");
            yesOrNo = yesOrNoQuestionMethod(1); //calls method again until it gets a valid answer
        }
        return yesOrNo;
    }

    public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000; //converts from milliseconds to seconds 
        try{
            TimeUnit.MILLISECONDS.sleep(timeWaiting); //makes the program wait a given amount of time
        }catch (Exception e){
            System.out.println("sorry the timer isn't working");
        }
    }

    public void runGame(boolean thisIsRunning, int numberOfGenerations, int howManyGenerationsAreWeDoing, int[][][] mapThreeDime, int boundaryType){
        while(thisIsRunning == true && numberOfGenerations < howManyGenerationsAreWeDoing){ //this is the loop which actually runs the conway game 
            System.out.println('\u000c'); // clears the terminal screen
            int notDead = 0;
            System.out.println("Generation number: " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); 
            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    notDead = finiteBoundary(y, x, mapThreeDime); //calls the isItAlive method, and asks if the point is alive 
                }
            }
            printIt(0, mapThreeDime);
            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }
    }

    //method for dealing with menus 
    public int doingMenuOption(int selected, int whichMenu){
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        userInput = userInput.toLowerCase().trim();
        System.out.println("currently you have option " + selected + " selected");
        if (userInput.equals("1")){
            System.out.println("selected option" + selected);
            selected = 1;
        }else if (userInput.equals("2")){
            System.out.println("selected option" + selected);
            selected = 2;
        }else if (userInput.equals("3")){
            System.out.println("selected option" + selected);
            selected = 3;
        }else if (userInput.equals("4") &&  whichMenu == 2){
            System.out.println("selected option" + selected);
            selected = 4;
        }else if (userInput.equals("up") || userInput.equals("u")){ // moves selection up one 
            System.out.println("moved selection up");
            if (selected == 1){
                System.out.println("there are no further options this way");
            }else{
                selected--;
                System.out.println("selected option" + selected);
            }
            System.out.println("currently you have option " + selected + " selected");
            selected = doingMenuOption(selected, whichMenu);
        }else if (userInput.equals("down") || userInput.equals("d")){ //moves it down one
            System.out.println("moved selection down");
            if ((selected == 4 && whichMenu == 2) || (selected == 3 && whichMenu == 1)){
                System.out.println("there are no further options this way");
            }else{
                selected++;
                System.out.println("selected option" + selected);
            }
            System.out.println("currently you have option " + selected + " selected");
            selected = doingMenuOption(selected, whichMenu);
        }else if (userInput.equals("enter") || userInput.equals("e")){ //inputs selected menu
            System.out.println("Doing option " + selected + " ");
        }else{
            System.out.println("doesn't seem like a valid input, sorry");
            selected = doingMenuOption(selected, whichMenu); // keeps calling the array if the input is invalid until it gets valid input
        }
        return selected;
    }

    public void setup(int fileType){ // 
        Scanner keyboard = new Scanner(System.in);
        howManyGenerationsAreWeDoing = returnInteger("how many generations should I run? (max = 1000, min = 1)", 1, 1000);
        timeWaiting = returnInteger("what should be the pause time between them? It's in seconds. Min is 0 seconds and the max is 60s (one min)", 0, 60);
        boundaryType = returnInteger("what boundary do you want? Type 1 for finite, 2 for wrapping, and 3 for infinite", 1, 3);
        System.out.println("and what would you like to represent the alive cells? I recommend ' X '");
        aliveCellSymbol = keyboard.nextLine();
        System.out.println("and what would you like to represent the alive cells? I recommend '   ' (AKA three spaces)");
        deadCellSymbol = keyboard.nextLine();
        if(fileType == POPULATEFROMAGRIDFILETYPE){
            size = readingAFile(fileNameAsAString, 1); 
        }else if (fileType != POPULATEFROMAGRIDFILETYPE){
            if(fileType == POPULATEWITHAGLIDERFILETYPE){ // size paramters change depending on how the grid will be populated 
                size = returnInteger("how big do you want this grid to be. min is 10 x 10 and max is 100 x 100  (because you chose a glider preset)", 10, 100);
            }else if(fileType == POPULATEWITHAPULSARFILETYPE){
                size = returnInteger("how big do you want this grid to be. min is 20 x 20 and max is 100 x 100  (because you chose a glider preset)", 20, 100);
            }else{
                size = returnInteger("how big do you want this grid to be. min is 5 x 5 and max is 100 x 100", 5, 100);
            }
        }
        if(boundaryType == INFINITEBOUNDARYTYPE){ // infinite boundaries is actually a pseudo-infinite boundary, and does this by creating a buffer of cells around the middle, printed and edited grid 
            int sizeWithBorder = size + border + border; // the following variables help set up infinite border
            int smallerSize = size;
            heightOfGrid = sizeWithBorder;
            widthOfGrid = sizeWithBorder; 
            size = sizeWithBorder;
            beginning = border; // border is intialised at the beginng. It's 10, as this seemed the best buffer (found through testing) 
            heightOfGridPrinting = heightOfGrid - border;
            widthOfGridPrinting = widthOfGrid - border;
        }else { // if it's not an infinite boundar, size is normal 
            heightOfGrid = size;
            widthOfGrid = size; 
            beginning = 0;
            heightOfGridPrinting = heightOfGrid; // these are important to differeniate between for the infinite, but for the other two not so much 
            widthOfGridPrinting = widthOfGrid;
        }
        numberOfHistoriesRecorded = howManyGenerationsAreWeDoing + 1;
    }

    //method to populate a board with a random assortment of ones and zeroes
    public void populateBoardWithRandom(int[][][] mapThreeDime){
        System.out.println("Populating the board with random"); 
        System.out.println("beginning at.."); //tells the user what's happening 
        for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array
            for(int x = beginning; x < widthOfGridPrinting; x++){
                int h = 0; //only affect the first history, aka the working history, the current grid
                mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
            }
            System.out.println(); //next line 
        }
        printIt(0, mapThreeDime);

    }

    //method to populate a board with presets, either a glider or a pulsar
    public void populateBoardWithAGlider(int[][][] mapThreeDime,int xToChange, int yToChange, int presetType){ //this is the method for both presets  
        int h = 0;
        int length = 0;
        int xCoords = 0;
        int yCoords = 1;
        if(presetType == GLIDERPRESETTYPE){ 
            length = 5; //number of cells and oordinates in the preset array
        }else if (presetType == PULSARPRESETTYPE){
            length = 48;//number of cells and oordinates in the preset array
        }
        int locale = Math.floorDiv(size, 2); //finds the middle point, to apply the preset to, allows the program to be flexible
        for(int cellNumber = 0; cellNumber < length; cellNumber++){ //nested loop, to go through the array
            if(presetType == 1){ //runs the two different presets
                xToChange = locale + gliderPreset[xCoords][cellNumber];  //finds the coordinates of the points to change 
                yToChange = locale + gliderPreset[yCoords][cellNumber];
            }else if (presetType == 2){
                xToChange = locale + pulsarPreset[xCoords][cellNumber];
                yToChange = locale + pulsarPreset[yCoords][cellNumber];
            }
            mapThreeDime[yToChange][xToChange][h] = 1; // turns those cells to alive 
        }
    }

    //this method allows for singular editing of cells 
    public void changeCells(int[][][] mapThreeDime){ 
        Scanner keyboard = new Scanner(System.in);
        int lastRow = 1;
        System.out.println("would you like to edit the grid?");
        int editingStill = yesOrNoQuestionMethod(1);
        printIt(0, mapThreeDime);
        while (editingStill == 1){
            int h = 0;

            int rowSelection = returnInteger("Please select row: ", lastRow, size);
            int columnSelection = returnInteger("Please select column: ", lastRow, size);
            int changeTo = returnInteger("do you want it alive (1) or dead (0)?", 0, 1) ;
            if(boundaryType == INFINITEBOUNDARYTYPE){ //bypasses buffer
                mapThreeDime[rowSelection-1+border][columnSelection-1+border][h] = changeTo; // actually changes the cell value
            }else { // if it's not an infinite boundar, size is normal 
                mapThreeDime[rowSelection-1][columnSelection-1][h] = changeTo; // actually changes the cell value
            }

            printIt(0, mapThreeDime);
            System.out.println();

            System.out.println("would you like to keep editing the grid?");
            editingStill = yesOrNoQuestionMethod(1); // keeps going if you say yes 

        }
    }

    //just prints the grid
    public void printIt(int h, int[][][] mapThreeDime){
        for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
            for(int x = beginning; x < widthOfGridPrinting; x++){
                int cellValue = mapThreeDime[y][x][h];
                if(cellValue == 1){ //if it's living 
                    System.out.print(aliveCellSymbol);//prints out the prechosen symbol 
                }else if (cellValue == 0){  
                    System.out.print(deadCellSymbol);
                }
            }
            System.out.println(); //next line 
        }
    }

    //finds the number of integers or lines ina  given file 
    public int readingAFile(String fileNameAsAString, int intsOrLines){ //gets the size of the file so the array for the grid can be intialised 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("We've received your file....");
        File myFile = new File(fileNameAsAString);
        int numberOfLines = 0;
        int numberOfInts = 0;

        try {
            if(intsOrLines == 1){ // reads ints or lines depending on what was passed
                Scanner readTheFileLines = new Scanner(myFile);
                while (readTheFileLines.hasNextLine()){
                    System.out.println(readTheFileLines.nextLine()); // counts the lines up 
                    System.out.println('\u000c'); // clears the creen each time 
                    numberOfLines++;
                }
                System.out.println('\u000c'); // and again for good measure
                return numberOfLines;
            }else if (intsOrLines == 2){ // same as above but for ints
                Scanner readTheFileInts = new Scanner(myFile);
                while (readTheFileInts.hasNextInt()){
                    System.out.print(readTheFileInts.nextInt()); 
                    System.out.println('\u000c');
                    numberOfInts++;
                }
                System.out.println('\u000c');
                return numberOfInts;
            }
            return numberOfLines; // if unspecifcedd, return lines
        }catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
            return -1;
        }
    }

    //this populates the board using file input 
    public void populateBoardFromAFile(int[][][] mapThreeDime){ 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("populating board from a file");
        File myFile = new File(fileNameAsAString);
        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextInt()){
                for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array, the printing means it works for any boundary type 
                    for(int x = beginning; x < widthOfGridPrinting; x++){
                        int h = 0; //only affect the first history, aka the working history, the current grid
                        mapThreeDime[y][x][h] = readTheFile.nextInt();
                        System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out as ones and zeroes, so you can see it as it is in the file first 
                    }
                    System.out.println(); //next line 
                }
            }
        }catch(IOException e){//and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }
    }

    //This method pritns out all the 'histories' and is very useful/predomindantly used for debugging
    //is not currently implemented, but kept if you would like to use it
    public void runHistories(int[][][] mapThreeDime){
        System.out.println("run history?");
        System.out.println("remeber, this one (just below) is the most recent history, the last one is the LEAST recent or FIRST iteration");// this is slightly 
        for(int c = 0; c < numberOfHistoriesRecorded; c++){ // cycles through the histories 
            System.out.println("history just happned " + c);
            for(int a = 0; a < heightOfGrid; a++){ // cycles through the grid 
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][c] + " "); // prints actual values instead of symbols, as its for debugging 
                }
                System.out.println();
            }
        }
    }

    //Method used when asking for an int input
    public int returnInteger(String question, int minParameter, int maxParameter){//allows for flexbility/games doesn't crash if a question recieves a non-int input
        Scanner keyboard = new Scanner(System.in);
        int intReceived = 0;
        try {
            System.out.println(question); //it will reprint the question everytime so the user is reminded of what to input
            intReceived = keyboard.nextInt();
            if(intReceived >= minParameter && intReceived <= maxParameter){ //this means I can just have one method for validity & within parameters
                return intReceived; //will only return the inputted int if it is both within the Parameters and is valid
            }else{
                System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
                intReceived = returnInteger(question, minParameter, maxParameter); //calls method again until it receives a valid input
                return intReceived;
            }
        }catch(Exception e){ 
            System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
            intReceived = returnInteger(question, minParameter, maxParameter);//calls method again until it receives a valid input
            return intReceived; 
        }
    }

    //saves a grid to the file  
    public void writingToAFile(int [][][] mapThreeDime, int history){
        Scanner keyboard = new Scanner(System.in);
        try{
            File workingFile = new File (fileNameAsAString);
            FileWriter newWriterThing = new FileWriter(workingFile); // sets up the file to be written into 

            for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
                for(int x = beginning; x < widthOfGridPrinting; x++){
                    int cellValue = mapThreeDime[y][x][history];
                    if(cellValue == 1){ //writes depending on cell value instead of array value itself, as otherwise it adds strange symbols 
                        newWriterThing.write("1");
                    }else if (cellValue == 0){
                        newWriterThing.write("0");
                    }
                    newWriterThing.write(" ");
                }
                newWriterThing.write("\n"); // next line 
            }
            newWriterThing.flush();
            newWriterThing.close(); // closes out of the file, after everythign is saved
        }catch(IOException e){
            System.out.println("Unfornutately we were unable to save your grid to a file");
        }
        System.out.println("All saved!");
    }

    //checks whether a file name is valid, and whether the file contents are valid
    public String getFileName(String parametersStatement, boolean forPopulatingAGrid){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(parametersStatement);
        System.out.println("For any markers = the files supplied are 'hasAGrid.txt' which can be used to populate a file" );
        System.out.println("and 'thisIWillWriteTo.txt' which can be used to populate with a grid to save it" );
        System.out.println("but of course any supplied grid will also work!" );
        String fileNameString = keyboard.nextLine();
        File namedFile = new File(fileNameString);
        if(namedFile.exists()){
            if(forPopulatingAGrid == false){ // the grid we write over can have anything in it, it doesn't matter as it gets written over
                return fileNameString;
            }else{ // but if you want to read a grid, it needs to have valid contens 
                int areThereAnyLines = readingAFile(fileNameString, 1);
                if(areThereAnyLines < 5){ // if the grid isn't big enough 
                    System.out.println("I'm sorry, that file doesn't have enough lines in it. Either add some more lines or find another file");
                    fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
                    return fileNameString;
                }
                int areThereAnyInts = readingAFile(fileNameString, 2);
                if( areThereAnyInts/areThereAnyLines == areThereAnyLines){ // if there are full lines/and it has enough ints per line
                    return fileNameString;
                }else{
                    System.out.println("I'm sorry, that file doesn't have enough cell values in it. It needs to be a square grid, with as many cells per line as there are lines");
                    fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
                    return fileNameString;
                }
            }
        }else {
            System.out.println("I'm sorry, that doesn't seem to have worked. Please check the parameters and your spelling and try again");
            fileNameString = getFileName(parametersStatement, forPopulatingAGrid); //keeps calling the method until a vsalid file is given 
            return fileNameString;
        }
    }

}

