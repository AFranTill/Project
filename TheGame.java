
/**
 * Write a description of class TheGame here. // HELP (write up this title)
 *
 * @author Frances
 * @version Verision I'm not even sure, 1.8.22
 * 
 * The scope of the array is messed up, and the different options for the user preloaded files aren't working, and need to be edited.
 */

//IMPORTS
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
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

    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        Scanner keyboard = new Scanner(System.in); // intialises the scanner
        int goingThrough;

        //MENU/START-UP TEXT
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

                setup(goingThrough, fromAGrid); //HELP
                fileType = 0; 
            }else if (whatWeAreDoing == 2){ // if you are loading a file 

                System.out.println("                Welcome to the menu of grid options to load");
                System.out.println("                There are a couple options to chose from");
                System.out.println("                1. Default (for trialling/testing)");
                System.out.println("                2. Random grid of ones and zeroes");
                System.out.println("                3. Glider ");
                System.out.println("                4. something Else ");

                fileType = doingMenuOption(1, 2); 

                System.out.println("do you want to run the default game?");
                goingThrough = yesOrNoQuestionMethod(0);
                if(goingThrough == 1){
                    numberOfGenerations = 0; //controls how many times the game loops/how many generations there are.
                    timeWaiting = 2;
                    size = 5;
                    heightOfGrid = size;
                    widthOfGrid = size;
                    howManyGenerationsAreWeDoing = 1;
                    numberOfHistoriesRecorded  = 5;
                    boundaryType = 1;
                    //int mapThreeDime[][][] = new int[size][size][numberOfHistoriesRecorded];
                }else{
                    setup(goingThrough, false);
                }           
            }
        }else if(whatWeAreDoing == 3){
            System.out.println("Quitting... ");

            System.out.println("Just checking, do you want to quit?");
            thisIsRunning = false;
            goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
            if(goingThrough == 1){ //if it's one, thats a yes, and do 
                thisIsRunning = false; //so they want to quit and it stops
            }else{
                System.out.println("I've receieved you don't know what to quit, but the next bit isn't coded yet");
                thisIsRunning = true; //they don't want to quit or its invalid, deal with

            }
        }

        int mapThreeDime[][][] = new int[size][size][numberOfHistoriesRecorded];
        boolean doingThis = true;

        switch (fileType){
            case 0:
                populateBoardFromAFile(mapThreeDime);
                break;
            case 1:
                break;
            case 2:
                populateBoardWithRandom(mapThreeDime);
                break;
            case 3:
                break;
            case 4:
                break;
        }

        changeCells(doingThis, mapThreeDime); 
        // printIt(0, mapThreeDime); //prints grid
        // populateBoardWithRandom(mapThreeDime);//calls the method which handles yes or no questions, assigns the value to goingthrough
        // System.out.println();
        // printIt(0, mapThreeDime);

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
        System.out.println("Do you want to save your game to a file?");
    }

    public int finiteBoundary(int yCoord, int xCoord, int[][][] mapThreeDime){
        int end = size - 1;
        historyCurrent = 0;
        int toAdd;
        int historyPrevious = historyCurrent + 1;
        neighboursValue = 0;
        //if(yCoord == 0 || xCoord == 0 || yCoord == end || xCoord == end){ 
            for(int yCoordModifier = -1; yCoordModifier < 1; yCoordModifier++){
                for(int xCoordModifier = -1; xCoordModifier < 1; xCoordModifier++){
                    int newYCoord = yCoordModifier + yCoord;
                    int newXCoord = xCoordModifier + xCoord;
                    // System.out.println("newYCoord " + newYCoord);
                    // System.out.println("newxCoord " + newXCoord);
                    if(newYCoord < 0 || newXCoord  < 0){
                        neighboursValue = neighboursValue + boundedFence;
                    }else{
                        if(yCoordModifier == -1 || (yCoordModifier == 0 && xCoordModifier == -1)){
                            toAdd = mapThreeDime[newYCoord][newXCoord][historyPrevious];
                            neighboursValue = neighboursValue + toAdd;
                        }else {
                            toAdd = mapThreeDime[newYCoord][newXCoord][historyPrevious];
                            neighboursValue = neighboursValue + toAdd;
                        }
                    }
                }
            }
            System.out.print(neighboursValue);
        // }else{ //if it's not a boundary condition
            // neighboursValue = notABoundaryCell(yCoord, xCoord, mapThreeDime);
        // }
        shallItBeAlive = applyGameRules(yCoord, xCoord, neighboursValue, mapThreeDime, historyCurrent);
        System.out.println(shallItBeAlive); 
        return shallItBeAlive;
    }

    public int notABoundaryCell(int yCoord, int xCoord, int[][][] mapThreeDime){
        int oneBefore = xCoord - 1;
        int oneAfter = xCoord + 1;
        int oneAbove  = yCoord - 1;
        int oneBelow = yCoord + 1;
        int end = size - 1;
        int historyPrevious = historyCurrent + 1;
        neighboursValue = 0;
        //System.out.println("here");
        for(int yCoordModifier = -1; yCoordModifier < 1; yCoordModifier++){
            //System.out.println("for loop");
            for(int xCoordModifier = -1; xCoordModifier < 1; xCoordModifier++){
                int newYCoord = yCoordModifier + yCoord;
                int newXCoord = xCoordModifier + xCoord;

                // System.out.print("yCoordModifier" + yCoordModifier);
                // System.out.print("newYCoord" + newYCoord);
                // System.out.print("xCoordModifier" + xCoordModifier);
                // System.out.print("newXCoord" + newXCoord);
                if(newYCoord < 0 || newXCoord  < 0){
                    neighboursValue = neighboursValue + boundedFence;
                }else{
                    if(yCoordModifier == -1 || (yCoordModifier == 0 && xCoordModifier == -1)){
                        neighboursValue = neighboursValue + mapThreeDime[newYCoord][newXCoord][historyPrevious];
                    }else {
                        neighboursValue = neighboursValue + mapThreeDime[newYCoord][newXCoord][historyCurrent];
                    }
                }
            }
        }
        // System.out.println("neighboursValue Before " + neighboursValue);
        // neighboursValue = neighboursValue - mapThreeDime[yCoord][xCoord][historyCurrent];
        // System.out.println("neighboursValue After " + neighboursValue);
        //System.out.print("neighboursValue" + neighboursValue);
        System.out.print(neighboursValue);
        return neighboursValue;

    }

    public int wrappingBoundary(int yCoord, int xCoord, int[][][] mapThreeDime){//pass it the coord of the point, so we know what point we're investigating{
        //this is the method that is called on every point to find out if it's alive or not alive. 

        int oneBefore = xCoord - 1;
        int oneAfter = xCoord + 1;
        int oneAbove  = yCoord - 1;
        int oneBelow = yCoord + 1;
        int end = size - 1;
        if(yCoord == 0 || xCoord == 0 || yCoord == end || xCoord == end){ //because the boundaries of the map are complicated in terms of arrays

            if(yCoord == 0 && xCoord == 0 ){
                //System.out.print(" C "); 

                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                //weird conditions
                topLeft = mapThreeDime[end][end][historyCurrent];
                topMiddle = mapThreeDime[end][xCoord][historyCurrent];
                topRight = mapThreeDime[end][oneAfter][historyCurrent];
                left = mapThreeDime[yCoord][end][historyCurrent];
                bottomLeft = mapThreeDime[oneBelow][end][historyCurrent];
            }else if(yCoord == end && xCoord == end){
                //System.out.print(" A "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                //weird conditons
                bottomRight = mapThreeDime[0][0][historyCurrent+1];
                topRight = mapThreeDime[oneAbove][0][historyCurrent + 1];
                right = mapThreeDime[yCoord][0][historyCurrent + 1];
                bottomLeft = mapThreeDime[0][oneBefore][historyCurrent + 1];
                bottomMiddle = mapThreeDime[0][xCoord ][historyCurrent + 1];

            }else if(yCoord == 0 && xCoord == end){
                //System.out.print(" L "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                //weird conditons
                topLeft = mapThreeDime[end][oneBefore][historyCurrent];
                topMiddle = mapThreeDime[end][xCoord][historyCurrent];
                topRight = mapThreeDime[end][0][historyCurrent];
                right = mapThreeDime[yCoord][0][historyCurrent + 1];
                bottomRight = mapThreeDime[oneBelow][0][historyCurrent];

            }else if(yCoord == end && xCoord == 0){
                //System.out.print(" B "); 

                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                //weird conditons

                topLeft = mapThreeDime[oneAbove][end][historyCurrent + 1];
                left = mapThreeDime[yCoord][end][historyCurrent];
                bottomLeft = mapThreeDime[0][end][historyCurrent + 1];
                bottomMiddle = mapThreeDime[0][xCoord ][historyCurrent + 1];
                bottomRight = mapThreeDime[0][oneAfter][historyCurrent + 1];

            }else if(yCoord == 0){
                // System.out.print(" Q "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                //weird conditons
                topLeft = mapThreeDime[end][oneBefore][historyCurrent];
                topMiddle = mapThreeDime[end][xCoord][historyCurrent];
                topRight = mapThreeDime[end][oneAfter][historyCurrent];

            }else if (yCoord == end){
                //System.out.print(" Y "); 

                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                //weird conditons
                bottomLeft = mapThreeDime[0][oneBefore][historyCurrent + 1];
                bottomMiddle = mapThreeDime[0][xCoord ][historyCurrent + 1];
                bottomRight = mapThreeDime[0][oneAfter][historyCurrent + 1];
            }else if(xCoord == 0){
                //System.out.print(" R "); 

                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                //weird conditons
                topLeft = mapThreeDime[oneAbove][end][historyCurrent + 1];
                left = mapThreeDime[yCoord][end][historyCurrent];
                bottomLeft = mapThreeDime[oneBelow][end][historyCurrent];

            }else if(xCoord == end){
                //System.out.print(" J "); 

                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                //weird conditons
                bottomRight = mapThreeDime[oneBelow][0][historyCurrent];
                right = mapThreeDime[yCoord][0][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][0][historyCurrent + 1];
            }else{
                System.out.println("broken");
            }
            neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
        }else{ //if it's not a boundary condition
            neighboursValue = notABoundaryCell(yCoord, xCoord, mapThreeDime);
        }
        shallItBeAlive = applyGameRules(yCoord, xCoord, neighboursValue, mapThreeDime, historyCurrent);
        return shallItBeAlive;
    }

    public int applyGameRules(int yCoord, int xCoord, int neighboursValue, int[][][] mapThreeDime, int historyCurrent){
        int shallItBeAlive = 2;

        //and now, below are the conway's rules. These are pretty much directly translated into code
        if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){ //if the selected cell is currently alive
            //System.out.println("Alive");
            if(neighboursValue < 2 || neighboursValue > 3){ // if the neighboursValue is less than two, the cell will die (underpopulation) or if it's more than three, the cell will die (overpopulation)
                //System.out.println("dead");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
            }else if(neighboursValue == 2 || neighboursValue == 3){ //if it's 2 or three, the cell remains alive 
                //System.out.println("alive");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
            }
        }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){ //if the selected cell is currently dead
            //System.out.println("dead");
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

    //this method has an awful lot of comments, and I'm sorry, but even I find this confusing, and I wrote the code. 
    public void historyReplacer(int yCoord, int xCoord, int living, int[][][] mapThreeDime){ //this moves all the histories of a given point back one.  //HELP (wayyy overcommented)
        //the histories are c if the array is defined as int array[a][b][c]
        //they keep a record of everything a given point has been for the last few iterations
        //the var numberOfHistoriesRecorded dictates how many iteration back the histories are kept
        //this takes the new alive or dead value and moves it back one, and all the subsquent histories back one
        // and the last history gets deleted/written over and not kept 

        //it begins with getting the passed value of living, which is the most recent value of if the point is alive or not
        // and assigns it to the var toMove
        //which controls what is being moved
        int toMove = living; //above happens here. For example, if living = 1, cell is alive, and toMove now = 1
        int assign; //then we just intialize assign to be used later.
        int lastOne = numberOfHistoriesRecorded - 1; //this is a var set up to have a flexible history, and represents the actual position of the last history
        //eg, if you record 5 history iterations, 4 is the position of the last history in the array. 
        for(int h = 0; h < numberOfHistoriesRecorded; h++){ //here, h represents history. it cycles through h until it gets to the end of the histories
            //when h = 0, toMove is the newest given value, living.
            //if a= 1 and b =1, and the histories are 1,0,0,1,0
            // the program collects the first one, and then writes over it with the living value
            // that collected one is then moved to a different var, and the net value, the 0 is collected
            // then written over, by the one, and the cycle repeats
            //until the last one, when we don't collect the value,
            // and in the first one, the collected value that will be using for writing over is the living value. 
            if(h == lastOne){ //if this is the last history
                assign = toMove; //the assign variable is the thing you are moving
                mapThreeDime[yCoord][xCoord][h] = assign; //and that value is now in the next posiiton along
                //we don't assign toMove a new value because this is the last one, so there is no value after it, no value to be moved.
            }else{
                assign = toMove; //assign is equal to the value we are moving around.
                toMove = mapThreeDime[yCoord][xCoord][h]; //now we get the next value that we'll move around, and assign that to toMove
                mapThreeDime[yCoord][xCoord][h] = assign; //and we write over that just-collected value with assign value. 
            }
        }
    }

    public int yesOrNoQuestionMethod(int yesOrNo){ //method to ask the user a question, returns different values for yes and no and invalid answers
        Scanner keyboard = new Scanner(System.in); //initializes scanner
        //takes userInput, mainuplates it into the simplest form, so it can compare to the simplest form in the if statement
        String userInput = keyboard.nextLine(); //creates 'userInput' as a string variable, assigns it the just receieved input
        userInput = userInput.toLowerCase().trim(); //converts it to lowercase
        //userInput = userInput.trim(); //removes whitespace

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
            //System.out.println('\u000c'); //clears the screen
            int notDead = 0;
            System.out.println("running " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); 
            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    if(boundaryType == 1){
                        notDead = finiteBoundary(y, x, mapThreeDime); //calls the isItAlive method, and asks if the point is alive 
                    }else if(boundaryType == 2){
                        notDead = wrappingBoundary(y, x, mapThreeDime);
                    }
                    int h = 0; //dealing with just history = 0, or the current history/working grid. 
                    if(notDead == 1){ //if it's living 
                        System.out.print(" " + "X" + " ");//prints out the value
                    }else if (notDead == 0){ //does literally the exact same thing as above why is this an if statement. 
                        System.out.print(" " + " " + " ");
                    }else{ //else do nothing. 
                        //HELP
                    }
                }
                System.out.println(); 
            }
            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }
    }

    public int doingMenuOption(int whichOption, int whichMenu){
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();
        selected = whichOption;
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

    public void setup(int goingThrough, boolean fromAGrid){
        Scanner keyboard = new Scanner(System.in);

        howManyGenerationsAreWeDoing = returnInteger("how many generations should I run? (max = 1000, min = 1)", 1, 1000);

        timeWaiting = returnInteger("what should be the pause time between them? It's in seconds. Min is 0 seconds and the max is 60s (one min)", 0, 60);

        boundaryType = returnInteger("what bounary do you want? Type 1 for finite, 2 for wrapping, and 3 for infinite", 1, 3);
        if(fromAGrid == false){
            size = returnInteger("how big do you want this grid to be. min is 5 x 5 and max is 100 x 100", 5, 100);
            keyboard.nextLine();
            heightOfGrid = size;
            widthOfGrid = size;
        }else if (fromAGrid == true){
            size = readingAFile(); 
            heightOfGrid = size;
            widthOfGrid = size;
        }
        numberOfHistoriesRecorded = returnInteger("how many histories should I record? Min = 5, Max = 20", 5, 20);
    }

    public void populateBoardWithRandom(int[][][] mapThreeDime){
        System.out.println("you want to populate the thing?"); //HELP (either provide a no option or remove the question)
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            System.out.println("beginning at.."); //tells the user what's happening 
            for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
                for(int x = 0; x < widthOfGrid; x++){
                    int h = 0; //only affect the first history, aka the working history, the current grid
                    mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                    System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
                }
                System.out.println(); //next line 
            }
        }else{ //if you recieved a no answer

        }
    }

    public void populateBoardWithThings(int[][][] mapThreeDime,int xToChange, int yToChange){
        int h = 0;
        for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
            for(int x = 0; x < widthOfGrid; x++){
                if(x == xToChange && y == yToChange){
                    mapThreeDime[y][x][h] = 1;
                }
            }
        }
    }

    public void changeCells(boolean selectionScreen, int[][][] mapThreeDime){ //add comments 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("running change cells");
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
        for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
            for(int x = 0; x < widthOfGrid; x++){
                System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
            }
            System.out.println(); //next line 
        }
    }

    public int readingAFile(){ //gets the size of the file so the array for the grid can be intialised
        Scanner keyboardInput = new Scanner(System.in);
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

    public void populateBoardFromAFile(int[][][] mapThreeDime){
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("populating board from a file");
        File myFile = new File("hasAGrid.txt");
        keyboardInput.nextLine();

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
        }catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }
    }

    public void runHistories(int[][][] mapThreeDime){
        System.out.println("run history?");
        System.out.println("remeber, this one (just below) is the most recent history, the fourth is the LEAST recent or FIRST iteration");//the following is just five for loops which all print out the grid at different points
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

    public int returnInteger(String question, int minParameter, int maxParameter){
        Scanner keyboard = new Scanner(System.in);
        int intReceived = 0;
        try {
            System.out.println(question);
            intReceived = keyboard.nextInt();
            if(intReceived >= minParameter && intReceived <= maxParameter){
                return intReceived;
            }else{
                System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
                intReceived = returnInteger(question, minParameter, maxParameter);
                return intReceived;
            }
        }catch(Exception e){
            System.out.println("Sorry, that doesn't seem quite right? Check you inputted a number that fits the parameters.");
            intReceived = returnInteger(question, minParameter, maxParameter);
            return intReceived;
        }
    }
}

