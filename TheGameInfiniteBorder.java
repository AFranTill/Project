
/**
 * Write a description of class TheGameInfiniteBorder here.
 *
 * @author Frances
 * @version Verision Five, 16.5.22
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

public class TheGameInfiniteBorder 
{
    //VARIABLES
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

    int size;
    boolean going = true;
    int timeWaiting;
    int howManyGenerationsAreWeDoing;
    int selected = 1;
    int numberOfGenerations = 0; 
    int widthOfGrid = 10; //dictates grid width
    int heightOfGrid = 10; //dictates grid width
    int numberOfHistoriesRecorded = 5; //dictates number of histories (controls the 3D part of the 3D array)
    int smallerSize;
    int smallerWidthOfGrid;
    int smallerHeightOfGrid;

    /**
     * Constructor for objects of class TheGameInfiniteBorder
     */
    public TheGameInfiniteBorder()
    {
        Scanner keyboard = new Scanner(System.in);
        int goingThrough;
        boolean thisIsRunning = false;
        
        System.out.println("                Welcome to the menu");
        System.out.println("                There are a couple options to chose from");
        System.out.println("                1. Read from a file");
        System.out.println("                2. Input a grid and run");
        System.out.println("                3. Run the default");
        System.out.println("                4. Quit");

        int whatWeAreDoing = doingMenuOption(1);
        if(whatWeAreDoing == 1){
            System.out.println("reading from a file");
            //reading file stuff method calling
        }else if (whatWeAreDoing == 2){
            System.out.println("time to create a grid!!");
            changeCells(true);
            System.out.println("now I need to implement a run game function");
        }else if (whatWeAreDoing == 3){
            //System.out.println("Running the default");
            System.out.println("do you want to run the default game?");
            goingThrough = yesOrNoQuestionMethod(0);
            if(goingThrough == 1){
                numberOfGenerations = 0; //controls how many times the game loops/how many generations there are.
                timeWaiting = 2;
                size = 20;  
                smallerSize = size - 10;
                heightOfGrid = size;
                smallerHeightOfGrid = heightOfGrid - 5;
                widthOfGrid = size;
                smallerWidthOfGrid = widthOfGrid - 5;
                howManyGenerationsAreWeDoing = 4;
                numberOfHistoriesRecorded  = 5;
                
            }else{
                setup(goingThrough);
            }
            int mapThreeDime[][][] = new int[size][size][numberOfHistoriesRecorded];
            
            printIt(0, mapThreeDime); //prints grid
            populateBoard(mapThreeDime);//calls the method which handles yes or no questions, assigns the value to goingthrough
            thisIsRunning = true;
            runGame(thisIsRunning, numberOfGenerations, howManyGenerationsAreWeDoing, mapThreeDime);

            System.out.println("run history?");
            goingThrough = 1; //calls the method which handles yes or no questions, assigns the value to goingthrough
            if(goingThrough == 1){
                //the following is just five for loops which all print out the grid at different points
                //this one prints out the control grid of mapTwo
                System.out.println("what it became");
                System.out.println("remeber, this one (just below) is the most recent history, the fourth is the LEAST recent or FIRST iteration");
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
        }else if(whatWeAreDoing == 4){
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
    }


    //this method has an awful lot of comments, and I'm sorry, but even I find this confusing, and I wrote the code. 
    public void historyReplacer(int yCoord, int xCoord, int living, int[][][] mapThreeDime){ //this moves all the histories of a given point back one.
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
        userInput = userInput.toLowerCase(); //converts it to lowercase
        userInput = userInput.trim(); //removes whitespace

        if(userInput.equals("yes")||userInput.equals("y")){ //if it receives yes
            return 1;
        }else if (userInput.equals("no")||userInput.equals("n")){ //if it receives no
            return 2;
        }else { //if it gets an invalid answer
            return 3;
        }

    }

    public static void slowPrint(int timeWaiting) { //makes the computer pause for the given amount of time
        timeWaiting = timeWaiting*1000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }catch (Exception e) {
        }
    }


    public void runGame(boolean thisIsRunning, int numberOfGenerations, int howManyGenerationsAreWeDoing, int[][][] mapThreeDime){
        int beginning = 0;
        while(thisIsRunning == true && numberOfGenerations < howManyGenerationsAreWeDoing && going == true){ //this is the loop which actually runs the conway game 
            System.out.println('\u000c'); //clears the screen
            System.out.println("running " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); //bet you can't guess what this does

            //the main loop which actually runs game (one loop is one generation)
            for(int y = beginning ; y < size; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = beginning; x < size; x++){ // same as above but for x and width not height 
                    int notDead = isItAlive(y, x, mapThreeDime); //calls the isItAlive method, and asks if the point is alive 
                    int h = 0; //dealing with just history = 0, or the current history/working grid. 
                    //System.out.print(" " + mapThreeDime[x][y][h] + " ");
                }
                //System.out.println(); 
            }
            printIt(0, mapThreeDime);
            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }
    }

    public int doingMenuOption(int whichOption){
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();

        System.out.println("currently you have option " + selected + " selected");

        if (userInput.equals("1")){
            System.out.println("selected 1");
            return 1;
        }else if (userInput.equals("2")){
            System.out.println("selected 2");
            return 2;
        }else if (userInput.equals("3")){
            System.out.println("selected 3");
            return 3;
        }else if (userInput.equals("4")){
            System.out.println("selected 4");
            return 4;
        }else if (userInput.equals("up") || userInput.equals("u")){
            System.out.println("moved selection up");
            if (selected == 1){
                System.out.println("there are no further options this way");
            }else{
                selected--;
            }
            System.out.println("currently you have option " + selected + " selected");
            doingMenuOption(1);
        }else if (userInput.equals("down") || userInput.equals("d")){
            System.out.println("moved selection down");
            if (selected == 4){
                System.out.println("there are no further options this way");
            }else{
                selected++;
            }
            System.out.println("currently you have option " + selected + " selected");
            doingMenuOption(1);
        }else if (userInput.equals("enter") || userInput.equals("e")){
            return selected;
        }else{
            System.out.println("doesn't seem like a valid input, sorry");
            doingMenuOption(1);
        }
        return 0;
    }

    public void setup(int goingThrough){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("how many generations should I run?");
        howManyGenerationsAreWeDoing = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("what should be the pause time between them?");
        timeWaiting = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("how big do you want this grid to be");
        size = keyboard.nextInt();
        keyboard.nextLine();
        smallerSize = size - 10;
        heightOfGrid = size;
        smallerHeightOfGrid = heightOfGrid - 5;
        widthOfGrid = size;
        smallerWidthOfGrid = widthOfGrid - 5;
        
        System.out.println("how many histories should I record?");
        numberOfHistoriesRecorded = keyboard.nextInt();
        keyboard.nextLine();

        //int mapThreeDime[][][] = new int[size][size][numberOfHistoriesRecorded];

    }

    public void populateBoard(int[][][] mapThreeDime){
        int beginning = 5;
        System.out.println("you want to populate the thing?");
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            System.out.println("beginning at.."); //tells the user what's happening 
            for(int y = beginning; y < smallerHeightOfGrid; y++){ //nested loop, to go through the array
                for(int x = beginning; x < smallerWidthOfGrid; x++){
                    int h = 0; //only affect the first history, aka the working history, the current grid
                    mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                    System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
                }
                System.out.println(); //next line 
            }
        }else{ //if you recieved an invalid or a no answer
            System.out.println("ok"); // be ok with it 
            System.out.println("beginning at.."); //tells the user what's happening 
            printIt(0, mapThreeDime);
        }
    }

    public void changeCells(boolean selectionScreen){ //add comments 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("hey");

        printIt(0, mapThreeDime);
        while (selectionScreen == true){
            int h = 0;
            System.out.println("Please select row: ");
            int rowSelection = keyboard.nextInt();

            System.out.println("Please select column: ");
            int columnSelection = keyboard.nextInt();

            System.out.println("do you want it alive or dead?");
            int changeTo = keyboard.nextInt();

            if (mapThreeDime[rowSelection-1][columnSelection-1][h] == 0){
                mapThreeDime[rowSelection-1][columnSelection-1][h] = changeTo;
            }else{
                mapThreeDime[rowSelection-1][columnSelection-1][h] = changeTo;
            }

            printIt(0, mapThreeDime);
            System.out.println();
            selectionScreen=false;
        }
    }

    public void printIt(int h, int[][][] mapThreeDime){
        int beginning = 5; 
        for(int y = beginning; y < smallerHeightOfGrid; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
            for(int x = beginning; x < smallerWidthOfGrid; x++){
                System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
            }
            System.out.println(); //next line 
        }
        /*
        
                    if(notDead == 1){ //if it's living 
                        //System.out.print(" " + map[x][y] + " ");
                        //System.out.print(" " + mapThreeDime[y][x][h] + " ");
                        System.out.print(" " + "X" + " ");//prints out the value
                        //mapTwo[y][x] = notDead; // puts the value into the control group map 
                    }else if (notDead == 0){ //does literally the exact same thing as above why is this an if statement. 
                        //System.out.print(" " + mapThreeDime[y][x][h] + " ");
                        System.out.print(" " + " " + " ");
                        //mapTwo[y][x] = notDead;
                    }else{ //else do nothing. 
                    }*/
    }

    // public void writingToAFile(){
        // Scanner keyboardInput = new Scanner(System.in);

        // boolean areWeWriting = true;
        // try{
            // File workingFile = new File ("thisIWillWriteTo.txt");

            // FileWriter newWriterThing = new FileWriter(workingFile);

            // newWriterThing.write("It's the end of the world.\n");
            // newWriterThing.write("And honestly, it's not that bad\n");
            // newWriterThing.write("~begins every teen dystopia~\n");
            // newWriterThing.flush();
            // newWriterThing.close();

            // Scanner readingThisFile = new Scanner(workingFile);
            // while (readingThisFile.hasNextLine()){
                // System.out.println(readingThisFile.nextLine());
            // }
        // }catch(IOException e){
            // System.out.println("broken");
        // }

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
    // }

    // public void readingAFile(){
        // Scanner keyboardInput = new Scanner(System.in);
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
    // }

    // public void FileWritingSecondMightBeBetter()
    // {
        // Scanner keyboardInput = new Scanner(System.in);

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

        // boolean areWeWriting = true;
        // try{
            // File workingFile = new File ("thisIWillWriteTo.txt");

            // FileWriter newWriterThing = new FileWriter(workingFile);

            // newWriterThing.write("It's the end of the world.\n");
            // newWriterThing.write("And honestly, it's not that bad\n");
            // newWriterThing.write("~begins every teen dystopia~\n");
            // newWriterThing.flush();
            // newWriterThing.close();

            // Scanner readingThisFile = new Scanner(workingFile);
            // while (readingThisFile.hasNextLine()){
                // System.out.println(readingThisFile.nextLine());
            // }
        // }catch(IOException e){
            // System.out.println("broken");
        // }

        // System.out.println("And one last file");
        // System.out.println("btw, try 'youShouldSayPeekaboo.txt'");
        // String mightBeAFileName = keyboardInput.nextLine();
        // File nextWorkingFile = new File(mightBeAFileName);
        // boolean writingAndReading = true;
        // int numberOfLines = 0;
        // try {
            // while (writingAndReading == true){//trying something hopefull it works
                // Scanner readTheFile = new Scanner(nextWorkingFile);
                // while (readTheFile.hasNextLine()){
                    // System.out.println(readTheFile.nextLine());
                // }
                // System.out.println("Add anything? If not, say '.'");
                // String lineToAdd = keyboardInput.nextLine();
                // FileWriter currentWriterThing = new FileWriter(nextWorkingFile, true); //PASSES IT FILE NAME AND APPEND = TRUE, SO IT ADDS INSTEAD OF REWRITING (OMG IT TOOK SO LONG TO FIND OUT HOW TO DO THAT)
                // if (lineToAdd.equals(".")){
                    // //newWriterThing.flush();
                    // //newWriterThing.close();
                    // writingAndReading = false; 
                // }else{ 
                    // /*
                    // //currentWriterThing.write("hey");
                    // numberOfLines+= 1;
                    // System.out.println(numberOfLines);
                    // for(int x = 0; x >= numberOfLines; x++){
                    // currentWriterThing.write("\n");
                    // }*/
                    // currentWriterThing.write(lineToAdd+"\n");
                    // currentWriterThing.flush();

                    // while (readTheFile.hasNextLine()){
                        // System.out.println(readTheFile.nextLine());
                    // }               
                // }

            // }

        // }
        // catch(IOException e){
            // //and if it doesn't work
            // e.printStackTrace();
            // System.out.println(" failed ");
        // }

    // }

    // public void FileReadingSecondMightBeBetter(){
        // Scanner keyboardInput = new Scanner(System.in);
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
    // }
    
    public int isItAlive(int yCoord, int xCoord, int[][][] mapThreeDime)//pass it the coord of the point, so we know what point we're investigating
    {
        //this is the method that is called on every point to find out if it's alive or not alive. 
        int historyCurrent = 0; //this is semantics, but for most of this, are dealing with the history value of 0, or the current grid alyout. 
        int shallItBeAlive; //creates a value that will be passed to the history replacer, and become living. This will only be assigned a value at the very end, just before the return statement. 
        int boundedFence = 0;
        int oneBefore = xCoord - 1;
        int oneAfter = xCoord + 1;
        int oneAbove  = yCoord - 1;
        int oneBelow = yCoord + 1;
        int topLeft = 0;
        int topMiddle = 0;
        int topRight = 0;
        int left = 0;
        int right = 0;
        int bottomLeft = 0;
        int bottomMiddle = 0;
        int bottomRight = 0;
        int end = size - 1;
        int neighboursValue = 0;
        if(yCoord == 0 || xCoord == 0 || yCoord == end || xCoord == end){ //because the boundaries of the map are complicated in terms of arrays

            if(yCoord == 0 && xCoord == 0 ){
                //System.out.print(" C "); 

                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];

                topLeft = boundedFence;
                topMiddle = boundedFence;
                topRight = boundedFence;
                left = boundedFence;
                bottomLeft = boundedFence;
                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if(yCoord == end && xCoord == end){
                //System.out.print(" A "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];

                topRight = boundedFence;
                right = boundedFence;
                bottomLeft = boundedFence;
                bottomMiddle = boundedFence;
                bottomRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if(yCoord == 0 && xCoord == end){
                //System.out.print(" L "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];

                topRight = boundedFence;
                right = boundedFence;
                topMiddle = boundedFence;
                topLeft = boundedFence;
                bottomRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if(yCoord == end && xCoord == 0){
                //System.out.print(" B "); 

                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];

                topLeft = boundedFence;
                left = boundedFence;
                bottomLeft = boundedFence;
                bottomMiddle = boundedFence;
                bottomRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;

            }else if(yCoord == 0){
                // System.out.print(" Q "); 

                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];

                topLeft = boundedFence;
                topMiddle = boundedFence;
                topRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if (yCoord == end){
                //System.out.print(" Y "); 

                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];

                bottomLeft = boundedFence;
                bottomMiddle= boundedFence;
                bottomRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if(xCoord == 0){
                //System.out.print(" R "); 

                topLeft = boundedFence;
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                left = boundedFence;
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomLeft = boundedFence;
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else if(xCoord == end){
                //System.out.print(" J "); 

                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = boundedFence;
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = boundedFence;
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = boundedFence;

                // neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                // System.out.print(" " + neighboursValue + " ");
                // return 4;
            }else{
                System.out.println("broken");
            }

        }else{ //if it's not a boundary condition
            oneBefore = xCoord - 1;
            oneAfter = xCoord + 1;
            oneAbove  = yCoord - 1;
            oneBelow = yCoord + 1;

            //what the next, huge & ineffecient block of code is doing, is essentially get all the values of the surronding squares and adding them together
            //these are the top row, so they have a y value of one less, and varying x values to cover all three x values above the selected cell
            topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
            topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
            topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
            //for the two below, they have the same y value but different x values, as they are in the same row but not same column
            left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
            //for the four above, we have already been throguh and tested their aliveness, and add that to their history, so we are actuall drawing on the history one in the past
            right = mapThreeDime[yCoord][oneAfter][historyCurrent];
            //these are all in the row below, so they have vrying x values and all a y value of one more, for the row just below
            bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
            bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
            bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
        }
        //and then we add them all together 
        neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;

        //and now, below are the conway's rules. These are pretty much directly translated into code
        if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){ //if the selected cell is currently alive
            //System.out.println("Alive"); 
            if(neighboursValue < 2 || neighboursValue > 3){ // if the neighboursValue is less than two, the cell will die (underpopulation) or if it's more than three, the cell will die (overpopulation)
                //System.out.println("dead");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 0; //returns the 'dead' value
            }else if(neighboursValue == 2 || neighboursValue == 3){ //if it's 2 or three, the cell remains alive 
                //System.out.println("alive");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }

        }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){ //if the selected cell is currently dead
            //System.out.println("dead");
            if(neighboursValue == 3){ // and it has three live neighbours, it becomes alive 
                //System.out.println("becomes alive");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);//passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }else { //for every other value, it remains dead
                //System.out.println("stays dead");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive, mapThreeDime);//passes the dead/alvie info and the selected cell location info to the history replacer
                return 0; //returns the 'dead' value
            }
        }else{ //if the selected cell is neither dead nor alive, then the system prints an error 
            System.out.println("error");
            return 2; //returns an unreal value for this context (neither dead or alive, will break the code (hopefull) so the error is conveyed)
        }
        //this is a return statement for if none of the above options happen. It is an unreal statement (in context) and will break the code

        //return 3;

        return 3;
    }
}


