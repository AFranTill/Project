
/**
 *CONWAYS GAME OF LIFE
 *
 * @author Frances
 * @version 3.4.2
 * (term 3, week 6, day 2 (tuesday))
 * 
 * This is a project. The purpose of this code is to run Conway's game of life. 
 * It is for a term 2 & 3 project, for NCEA & whs computer science
 * 
 * This code //HELP
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
    private int mapTwo[][] = new int[10][10]; //control-type 2d array for a map to be used while testing.  

    int[][] map = //previous map used, 2D, array creator
        { 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

    int mapThreeDime[][][];// = new int[10][10][5]; //makes the 3D grid when populating happens in a loop

    int[][][] mapThreeDimeMade= //makes the 3D grid when we want to hand-populate for control and testing purposes

        { 
            { {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
        };  

    int[][] gliderPreset = {{1, 2, 0, 1, 2},{-2, -1, 0, 0, 0}}; 
    int[][] pulsarPreset = {{-4, -3, -2, 2, 3, 4, -6, -1, 1, 6, -6, -1, 1, 6, -6, -1, 1, 6, -4, -3, -2, 2, 3, 4, -4, -3, -2, 2, 3, 4, -6, -1, 1, 6, -6, -1, 1, 6, -6, -1, 1, 6, -4, -3, -2, 2, 3, 4},{6, 6, 6, 6, 6, 6, 4, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -3, -3, -3, -3, -4, -4, -4, -4, -6, -6, -6, -6, -6, -6}}; 
    //---------

    //INTERGER VARIABLES
    int size;
    int timeWaiting;
    int howManyGenerationsAreWeDoing;
    int selected = 1;
    int numberOfGenerations = 0; 
    int widthOfGrid = 10; //dictates grid width
    int heightOfGrid = 10; //dictates grid width
    int numberOfHistoriesRecorded = 5; //dictates number of histories (controls the 3D part of the 3D array)
    int fileType;
    int boundaryType;
    //------

    //INTERGER VALUES FOR RULES
    int historyCurrent = 0; //this is semantics, but for most of this, are dealing with the history value of 0, or the current grid alyout. 
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
    //-------

    //BOOLEAN VARIABLES
    boolean going = true;
    boolean thisIsRunning = false;
    boolean fromAGrid = false;
    boolean selectionScreen;
    //----

    //STRING VARIABLES
    String deadCellSymbol;
    String aliveCellSymbol;
    //-----

    int finiteBoundaryType = 1; 
    int wrappingBoundaryType = 2;
    int infiniteBoundaryType = 3; 
    int heightOfGridPrinting;
    int widthOfGridPrinting;
    int beginning;
    int border = 10;

    int count = 0; //HELP (remove when testing done)
    int workingTho = 0;
    int workingThoSecondary = 0;
    int otherCount = 0;

    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        Scanner keyboard = new Scanner(System.in);
        int goingThrough; //used when asking yes or no questions 

        //MENU START-UP TEXT
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
                System.out.println("reading from a file");
                fromAGrid = true; // lets the game know it's from a grid
                System.out.println("do you want to load a game from a file");
                goingThrough = yesOrNoQuestionMethod(0);
                fileType = 0; 
                setup(goingThrough, fileType); //HELP maybe ab from a gri dint?

            }else if (whatWeAreDoing == 2){ // if you are loading a file 
                // MENU FOR LOADING A GRID 
                System.out.println("                Welcome to the menu of grid options to load");
                System.out.println("                There are a couple options to chose from");
                System.out.println("                1. Default (for trialling/testing)");
                System.out.println("                2. Random grid of ones and zeroes");
                System.out.println("                3. Populate with a Glider ");
                System.out.println("                4. Populate with a pulsar ");

                fileType = doingMenuOption(1, 2); //deciding which filetype to run

                System.out.println("do you want to run the default game?"); //gives an option to set all values to a set default, useful in debugging //HELP (probs remove default)
                goingThrough = yesOrNoQuestionMethod(0);
                if(goingThrough == 1){
                    numberOfGenerations = 0; //controls how many times the game loops/how many generations there are.
                    timeWaiting = 2;
                    size = 10;
                    heightOfGrid = size;
                    widthOfGrid = size;
                    howManyGenerationsAreWeDoing = 5;
                    numberOfHistoriesRecorded  = 5;
                    boundaryType = 3;
                }else{
                    setup(goingThrough, fileType);
                }           
            }
        }else if(whatWeAreDoing == 3){ //this means if the user chooses to quit 
            System.out.println("Just checking, do you want to quit?");
            thisIsRunning = false;
            goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough //HELP
            if(goingThrough == 1){ //if it's one, thats a yes, and do 
                thisIsRunning = false; //so they want to quit and it stops
            }else{
                System.out.println("I've receieved you don't know what to quit, but the next bit isn't coded yet");
                thisIsRunning = true; //they don't want to quit or its invalid, deal with

            }
        }

        int mapThreeDime[][][] = new int[heightOfGrid][widthOfGrid][numberOfHistoriesRecorded];//initialises array for grid. Occurs here, because set up was executed above
        boolean doingThis = true;

        switch (fileType){ //HELP (write comment)
            case 0:
                populateBoardFromAFile(mapThreeDime);
                break;
            case 1:
                break;
            case 2:
                populateBoardWithRandom(mapThreeDime);
                break;
            case 3:
                populateBoardWithAGlider(mapThreeDime, 0, 0, 1);
                printIt(0, mapThreeDime);
                break;
            case 4:
                populateBoardWithAGlider(mapThreeDime, 0, 0, 2);
                printIt(0, mapThreeDime);
                break;
        }
        changeCells(doingThis, mapThreeDime); 

        thisIsRunning = true;
        runGame(thisIsRunning, numberOfGenerations, howManyGenerationsAreWeDoing, mapThreeDime, boundaryType);
        runHistories(mapThreeDime);

        System.out.println("Thanks for playing! The game is over now, unless you would like to run a few more generations of your game?");
        System.out.println("Do you want to run a few more generations?");
        goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            howManyGenerationsAreWeDoing = returnInteger("how many more generations should I run? (max = 1000, min = 1)", 1, 1000);
            runGame(thisIsRunning, numberOfGenerations, howManyGenerationsAreWeDoing, mapThreeDime, boundaryType);
        }else{
            System.out.println("Alrighty, we won't run the game anymore");
        }
        System.out.println("CODE THIS");
        runHistories(mapThreeDime);
        System.out.println("Do you want to save your game to a file?");
        goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            writingToAFile(mapThreeDime);
        }else{
            System.out.println("All goods! Thanks for playing!");
        }
    }

    public int finiteBoundary(int yCoord, int xCoord, int[][][] mapThreeDime){
        int end = size - 1;
        historyCurrent = 0;
        int toAdd = 0;
        int historyPrevious = historyCurrent + 1;
        neighboursValue = 0;
        int round = 0;
        for(int yCoordModifier = -1; yCoordModifier < 2; yCoordModifier++){
            for(int xCoordModifier = -1; xCoordModifier < 2; xCoordModifier++){
                int newYCoord = yCoordModifier + yCoord;
                int newXCoord = xCoordModifier + xCoord;
                otherCount++;
                if(newYCoord < 0 || newXCoord  < 0 || newYCoord > end || newXCoord > end){
                    if(boundaryType == wrappingBoundaryType){
                        toAdd = wrappingBoundary(yCoord, xCoord, newYCoord, newXCoord, yCoordModifier, xCoordModifier, mapThreeDime);
                        neighboursValue += toAdd;
                    }else if (boundaryType == finiteBoundaryType || boundaryType == infiniteBoundaryType){ //HELP (unless this does help, remove
                        neighboursValue += boundedFence;
                    }
                }else{
                    if(yCoordModifier == -1 || (yCoordModifier == 0 && xCoordModifier == -1)){
                        neighboursValue += mapThreeDime[newYCoord][newXCoord][historyPrevious];
                    }else {
                        neighboursValue += mapThreeDime[newYCoord][newXCoord][historyCurrent];
                    }
                }
                round++;
            }
        }
        neighboursValue -= mapThreeDime[yCoord][xCoord][historyCurrent];
        workingThoSecondary += neighboursValue;
        shallItBeAlive = applyGameRules(yCoord, xCoord, neighboursValue, mapThreeDime, historyCurrent);
        count++;
        workingTho += shallItBeAlive;
        return shallItBeAlive;
    }

    public int wrappingBoundary(int yCoord, int xCoord,int newYCoord, int newXCoord,int yCoordModifier, int xCoordModifier, int[][][] mapThreeDime){//pass it the coord of the point, so we know what point we're investigating{
        int end = size - 1;
        historyCurrent = 0;
        int toAdd = 0;
        int historyPrevious = historyCurrent + 1;
        int round = 0;
        int length = size;
        int boundaryNeighbour = 0;
        //turn into a switch statement, which checks through all options
        if(newYCoord < 0){
            newYCoord = end;            
        }else if (newYCoord > end){
            newYCoord = 0;
        }
        if (newXCoord > end){
            newXCoord = 0;
        }else if (newXCoord < 0){
            newXCoord = end;
        }
        if(newYCoord < yCoord || (newYCoord == yCoord && newXCoord < xCoord)){
            boundaryNeighbour += mapThreeDime[newYCoord][newXCoord][historyPrevious];
        }else {
            boundaryNeighbour += mapThreeDime[newYCoord][newXCoord][historyCurrent];
        }
        return boundaryNeighbour;
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
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);//passes the dead/alvie info and the selected cell location info to the history replacer
            }else { //for every other value, it remains dead
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);//passes the dead/alvie info and the selected cell location info to the history replacer
            }
        }else{ //if the selected cell is neither dead nor alive, then the system prints an error 
            System.out.println("error");
            shallItBeAlive = 2; //returns an unreal value for this context (neither dead or alive, will break the code (hopefull) so the error is conveyed)
        }
        //this is a return statement for if none of the above options happen. It is an unreal statement (in context) and will break the code
        return shallItBeAlive;
    }

    public void historyReplacer(int yCoord, int xCoord, int living, int[][][] mapThreeDime){ 
        int toMove = living;
        int assign; 
        int lastOne = numberOfHistoriesRecorded - 1; 
        for(int h = 0; h < numberOfHistoriesRecorded; h++){ 
            if(h == lastOne){ 
                assign = toMove; 
                mapThreeDime[yCoord][xCoord][h] = assign; 
            }else{
                assign = toMove; 
                toMove = mapThreeDime[yCoord][xCoord][h]; 
                mapThreeDime[yCoord][xCoord][h] = assign; 
            }
        }
    }

    public int yesOrNoQuestionMethod(int yesOrNo){ //method to ask the user a question, returns different values for yes and no and invalid answers
        Scanner keyboard = new Scanner(System.in); //initializes scanner
        //takes userInput, mainuplates it into the simplest form, so it can compare to the simplest form in the if statement
        String userInput = keyboard.nextLine(); //creates 'userInput' as a string variable, assigns it the just receieved input
        userInput = userInput.toLowerCase().trim(); //converts it to lowercase and trims it 

        if(userInput.equals("yes")||userInput.equals("y")){ //if it receives yes
            yesOrNo = 1;
        }else if (userInput.equals("no")||userInput.equals("n")){ //if it receives no
            yesOrNo = 2;
        }else{ //if it gets an invalid answer
            System.out.println("sorry that was an invalid input. Try yes or no, or y/n");
            yesOrNo = yesOrNoQuestionMethod(1);
        }
        return yesOrNo;
    }

    public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000;
        try{
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }catch (Exception e){
            System.out.println("sorry the timer isn't working");
        }
    }

    public void runGame(boolean thisIsRunning, int numberOfGenerations, int howManyGenerationsAreWeDoing, int[][][] mapThreeDime, int boundaryType){
        while(thisIsRunning == true && numberOfGenerations < howManyGenerationsAreWeDoing && going == true){ //this is the loop which actually runs the conway game 
            //System.out.println('\u000c'); //clears the screen /HELP (should probablty reinstate)
            int notDead = 0;
            System.out.println("running " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); 
            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    notDead = finiteBoundary(y, x, mapThreeDime); //calls the isItAlive method, and asks if the point is alive 

                }
                //ystem.out.println(); 
            }
            printIt(0, mapThreeDime);
            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }
    }

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
        }else if (userInput.equals("up") || userInput.equals("u")){
            System.out.println("moved selection up");
            if (selected == 1){
                System.out.println("there are no further options this way");
            }else{
                selected--;
                System.out.println("selected option" + selected);
            }
            System.out.println("currently you have option " + selected + " selected");
            selected = doingMenuOption(selected, whichMenu);
        }else if (userInput.equals("down") || userInput.equals("d")){
            System.out.println("moved selection down");
            if ((selected == 4 && whichMenu == 2) || (selected == 3 && whichMenu == 1)){
                System.out.println("there are no further options this way");
            }else{
                selected++;
                System.out.println("selected option" + selected);
            }
            System.out.println("currently you have option " + selected + " selected");
            selected = doingMenuOption(selected, whichMenu);
        }else if (userInput.equals("enter") || userInput.equals("e")){
            System.out.println("Doing option " + selected + " ");
        }else{
            System.out.println("doesn't seem like a valid input, sorry");
            selected = doingMenuOption(selected, whichMenu);
        }
        return selected;
    }

    public void setup(int goingThrough, int fileType){
        Scanner keyboard = new Scanner(System.in);
        howManyGenerationsAreWeDoing = returnInteger("how many generations should I run? (max = 1000, min = 1)", 1, 1000);
        timeWaiting = returnInteger("what should be the pause time between them? It's in seconds. Min is 0 seconds and the max is 60s (one min)", 0, 60);
        boundaryType = returnInteger("what bounary do you want? Type 1 for finite, 2 for wrapping, and 3 for infinite", 1, 3);
        if(fileType == 0){
            size = readingAFile(); 
        }else if (fileType != 0){
            if(fileType == 3){
                size = returnInteger("how big do you want this grid to be. min is 10 x 10 and max is 100 x 100  (because you chose a glider preset)", 10, 100);
            }else if(fileType == 4){
                size = returnInteger("how big do you want this grid to be. min is 20 x 20 and max is 100 x 100  (because you chose a glider preset)", 20, 100);
            }else {
                size = returnInteger("how big do you want this grid to be. min is 5 x 5 and max is 100 x 100", 5, 100);
            }

        }
        if(boundaryType == infiniteBoundaryType){
            int sizeWithBorder = size + border + border;
            int smallerSize = size;
            heightOfGrid = sizeWithBorder;
            widthOfGrid = sizeWithBorder; 
            size = sizeWithBorder;
        }else {
            heightOfGrid = size;
            widthOfGrid = size; 
        }
        numberOfHistoriesRecorded = returnInteger("how many histories should I record? Min = 5, Max = 20", 5, 20);
        if(boundaryType == infiniteBoundaryType){//HELP
            beginning = border;
            heightOfGridPrinting = heightOfGrid - border;
            widthOfGridPrinting = widthOfGrid - border;
        }else{
            beginning = 0;
            heightOfGridPrinting = heightOfGrid;
            widthOfGridPrinting = widthOfGrid;
        }
        System.out.println("and what would you like to represent the alive cells? I recommend ' X '");
        aliveCellSymbol = keyboard.nextLine();
        System.out.println("and what would you like to represent the alive cells? I recommend '   ' (AKA three spaces)");
        deadCellSymbol = keyboard.nextLine();
    }

    public void populateBoardWithRandom(int[][][] mapThreeDime){
        System.out.println("you want to populate the thing?"); //HELP (either provide a no option or remove the question)
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            System.out.println("beginning at.."); //tells the user what's happening 
            for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array
                for(int x = beginning; x < widthOfGridPrinting; x++){
                    int h = 0; //only affect the first history, aka the working history, the current grid
                    mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                    System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
                }
                System.out.println(); //next line 
            }
        }else{ //if you recieved a no answer /HELP

        }
    }

    public void populateBoardWithAGlider(int[][][] mapThreeDime,int xToChange, int yToChange, int presetType){
        int h = 0;
        int length = 0;
        if(presetType == 1){
            length = 5;
        }else if (presetType == 2){
            length = 48;
        }
        int locale = Math.floorDiv(size, 2);
        for(int y = 0; y < length; y++){ //nested loop, to go through the array
            //for(int x = 0; x < 1; x++){
            if(presetType == 1){
                xToChange = locale + gliderPreset[0][y];
                yToChange = locale + gliderPreset[1][y];
            }else if (presetType == 2){
                xToChange = locale + pulsarPreset[0][y];
                yToChange = locale + pulsarPreset[1][y];
            }
            mapThreeDime[yToChange][xToChange][h] = 1;
        }
    }

    public void changeCells(boolean selectionScreen, int[][][] mapThreeDime){ //add comments 
        Scanner keyboard = new Scanner(System.in);
        int lastRow = 1;

        System.out.println("would you like to edit the grid?");
        int editingStill = yesOrNoQuestionMethod(1);

        printIt(0, mapThreeDime);
        while (editingStill == 1){
            selectionScreen = true;
            int h = 0;
            if(editingStill == 1){     
                int rowSelection = returnInteger("Please select row: ", lastRow, size);
                int columnSelection = returnInteger("Please select column: ", lastRow, size);
                int changeTo = returnInteger("do you want it alive (1) or dead (0)?", 0, 1) ;

                mapThreeDime[rowSelection-1][columnSelection-1][h] = changeTo;
                printIt(0, mapThreeDime);
                System.out.println();

                System.out.println("would you like to keep editing the grid?");
                editingStill = yesOrNoQuestionMethod(1);
            }else if (editingStill == 0){
                selectionScreen = false;
            }
        }
    }

    public void printIt(int h, int[][][] mapThreeDime){
        for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
            for(int x = beginning; x < widthOfGridPrinting; x++){
                int cellValue = mapThreeDime[y][x][h];
                if(cellValue == 1){ //if it's living 
                    System.out.print(aliveCellSymbol);//prints out the value
                }else if (cellValue == 0){ //does literally the exact same thing as above why is this an if statement. 
                    System.out.print(deadCellSymbol);
                }
            }
            System.out.println(); //next line 
        }
    }

    public int readingAFile(){ //gets the size of the file so the array for the grid can be intialised //HELP DO I use this method? If so, why is the file name hardcoded? 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("reading a file");
        File myFile = new File("hasAGrid.txt");
        int awesome = 0;

        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());
                awesome++;
                System.out.println(awesome);
            }
            return awesome;
        }catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
            return -1;
        }
    }

    public void populateBoardFromAFile(int[][][] mapThreeDime){ // HELP need this to be a bit diff if for infinte
        Scanner keyboard = new Scanner(System.in);
        System.out.println("populating board from a file");
        File myFile = new File("hasAGrid.txt");
        keyboard.nextLine();

        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNext()){
                //System.out.println(readTheFile.nextInt());
                for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
                    for(int x = 0; x < widthOfGrid; x++){
                        int h = 0; //only affect the first history, aka the working history, the current grid
                        mapThreeDime[y][x][h] = readTheFile.nextInt();
                        System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
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
    public void runHistories(int[][][] mapThreeDime){
        System.out.println("run history?");
        System.out.println("remeber, this one (just below) is the most recent history, the last one is the LEAST recent or FIRST iteration");// this is slightly 
        for(int c = 0; c < numberOfHistoriesRecorded; c++){
            System.out.println("history just happned " + c);
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][c] + " ");
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
            intReceived = returnInteger(question, minParameter, maxParameter);
            return intReceived;
        }
    }

    public void saveGridToAFile(int[][][] mapThreeDime){ // HELP need this to be a bit diff if for infinte
        Scanner keyboard = new Scanner(System.in);
        System.out.println("populating board from a file");
        File myFile = new File("hasAGrid.txt");
        keyboard.nextLine();

        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNext()){
                //System.out.println(readTheFile.nextInt());
                for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
                    for(int x = 0; x < widthOfGrid; x++){
                        int h = 0; //only affect the first history, aka the working history, the current grid
                        mapThreeDime[y][x][h] = readTheFile.nextInt();
                        System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
                    }
                    System.out.println(); //next line 
                }
            }
        }catch(IOException e){//and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }
    }

    public void writingToAFile(int [][][] mapThreeDime){
        Scanner keyboardInput = new Scanner(System.in);
        int awesome = 0;
        boolean areWeWriting = true;
        int h = 0;
        try{
            File workingFile = new File ("thisIWillWriteTo.txt");
            FileWriter newWriterThing = new FileWriter(workingFile);

            for(int y = beginning; y < heightOfGridPrinting; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
                for(int x = beginning; x < widthOfGridPrinting; x++){
                    int cellValue = mapThreeDime[y][x][h];
                    newWriterThing.write(" ");
                    if(cellValue == 1){
                        newWriterThing.write("1");
                    }else if (cellValue == 0){
                        newWriterThing.write("0");
                    }
                    newWriterThing.write(" ");
                }
                newWriterThing.write("\n");
            }
            newWriterThing.flush();
            newWriterThing.close();
        }catch(IOException e){
            System.out.println("broken");
        }

        // System.out.println("please type a full file name (with the type also)");
        // System.out.println("hint = try test.txt");
        // String fileName = keyboardInput.nextLine();
        // File myFile = new File(fileName);
        // try {
            // //trying something hopefull it works
            // Scanner readTheFile = new Scanner(myFile);
            // while (readTheFile.hasNextLine()){
                // System.out.println(readTheFile.nextLine());
            // }
        // }
        // catch(IOException e){
            // //and if it doesn't work
            // e.printStackTrace();
            // System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        // }
    }
}

