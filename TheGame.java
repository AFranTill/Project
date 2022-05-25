
/**
 * Write a description of class TheGame here.
 *
 * @author Frances
 * @version Verision Five, 16.5.22
 */
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.awt.*;

public class TheGame 
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

    int widthOfGrid = 10; //dictates grid width
    int heightOfGrid = 10; //dictates grid width
    int numberOfHistoriesRecorded = 5; //dictates number of histories (controls the 3D part of the 3D array)
    //private int mapThreeDime[][][] = new int[10][10][5]; //makes the 3D grid when populating happens in a loop

    int[][][] mapThreeDime= //makes the 3D grid when we want to hand-populate for control and testing purposes
        { 
            { {5,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {6,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {4,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {8,0,0,0,0} },
        };  
    int size;
    boolean going = true;
    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        Scanner keyboard = new Scanner(System.in);

        screenSize();

        System.out.println("you want this to run?");
        boolean thisIsRunning = false;
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            thisIsRunning = true; //allows the thing to run
        }else{
            thisIsRunning = false; //prevents the thing from running (the thign is the conway game btw)
        }

        int numberOfGenerations = 0; //controls how many times the game loops/how many generations there are. 

        System.out.println("how many generations should I run?");
        int howManyGenerationsAreWeDoing = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("what should be the pause time between them?");
        int timeWaiting = keyboard.nextInt();
        int timeToWaitFor = (timeWaiting/4)*3;
        timeWaiting = timeWaiting - timeToWaitFor;
        keyboard.nextLine();

        System.out.println("how big do you want this grid to be");
        size = keyboard.nextInt();
        keyboard.nextLine();
        heightOfGrid = size;
        widthOfGrid = size;

        System.out.println("how many histories should I record?");
        int numberOfHistoriesRecorded = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("you want to populate the thing?");
        goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            System.out.println("beginning at.."); //tells the user what's happening 
            for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
                for(int x = 0; x < widthOfGrid; x++){
                    int h = 0; //only affect the first history, aka the working history, the current grid
                    mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                    System.out.print(" " + mapThreeDime[x][y][h] + " "); //print it out nicely. 
                }
                System.out.println(); //next line 
            }
        }else{ //if you recieved an invalid or a no answer
            System.out.println("ok"); // be ok with it 
            System.out.println("beginning at.."); //tells the user what's happening 
            for(int x = 0; x < widthOfGrid; x++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
                for(int y = 0; y < heightOfGrid; y++){
                    int h = 0; //only affect the first history, aka the working history, the current grid
                    //mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                    System.out.print(" " + mapThreeDime[x][y][h] + " "); //print it out nicely. 
                }
                System.out.println(); //next line 
            }
        }

        //MAIN GAME
        //this is the block which runs the printing of the game itself. It constantly calls and asks if the cell is alive, as it prints the new gen
        //it runs when user has specified it should and for the amount of generations specified

        while(thisIsRunning == true && numberOfGenerations < howManyGenerationsAreWeDoing && going == true){ //this is the loop which actually runs the conway game 
            //System.out.println('\u000c'); //clears the screen
            System.out.println("running " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); //bet you can't guess what this does
            //listeningMethod(timeToWaitFor);

            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    int living = isItAlive(y, x); //calls the isItAlive method, and asks if the point is alive 
                    int h = 0; //dealing with just history = 0, or the current history/working grid. 

                    if(living == 1){ //if it's living 
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" x "); //prints out the value
                        mapTwo[y][x] = living; // puts the value into the control group map 
                    }else if (living == 0){ //does literally the exact same thing as above why is this an if statement. 
                        System.out.print(" 0 ");
                        mapTwo[y][x] = living;
                    }else{ //else do nothing. 
                    }

                }
                System.out.println(); 
            }

            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }


        System.out.println("run history?");

        goingThrough = 1; //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){
            //the following is just five for loops which all print out the grid at different points
            //this one prints out the control grid of mapTwo
            System.out.println("what it became");
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapTwo[a][b] + " ");
                }
                System.out.println();
            }

            //this prints out history at position one (eg int map[a][b][0,1,0,0,0]
            // where the 1 is what it's printing for everything
            System.out.println("history just happened (point 1)");
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][1] + " ");
                }
                System.out.println();
            }

            //this prints out history at position two (eg int map[a][b][0,0,1,0,0]
            // where the 1 is what it's printing for everything
            System.out.println("history just before just happened (point 2)");
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][2] + " ");
                }
                System.out.println();
            }

            //this prints out history at position three (eg int map[a][b][0,0,0,1,0]
            // where the 1 is what it's printing for everything
            System.out.println("history (point 3)");
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][3] + " ");
                }
                System.out.println();
            }

            //this prints out history at position four (eg int map[a][b][0,0,0,0,1]
            // where the 1 is what it's printing for everything
            System.out.println("history (point 4)");
            for(int a = 0; a < heightOfGrid; a++){
                for(int b = 0; b < widthOfGrid; b++){
                    System.out.print(" " + mapThreeDime[a][b][4] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("cooool");
        }

    }

    public int isItAlive(int yCoord, int xCoord)//pass it the coord of the point, so we know what point we're investigating
    {
        //this is the method that is called on every point to find out if it's alive or not alive. 
        int historyCurrent = 0; //this is semantics, but for most of this, are dealing with the history value of 0, or the current grid alyout. 
        int shallItBeAlive; //creates a value that will be passed to the history replacer, and become living. This will only be assigned a value at the very end, just before the return statement. 
        int boundedFence = 0;
        int oneBefore = 0;
        int oneAfter = 0;
        int oneAbove = 0;
        int oneBelow = 0;
        int topLeft = 0;
        int topMiddle = 0;
        int topRight = 0;
        int left = 0;
        int right = 0;
        int bottomLeft = 0;
        int bottomMiddle = 0;
        int bottomRight = 0;
        int end = size - 1;
        if(yCoord == 0 || xCoord == 0 || yCoord == end || xCoord == end){ //because the boundaries of the map are complicated in terms of arrays
            if(yCoord == 0 && xCoord == 0 ){

                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];

                topLeft = boundedFence;
                topMiddle = boundedFence;
                topRight = boundedFence;
                left = boundedFence;
                bottomLeft = boundedFence;
            }else if(yCoord == end && xCoord == end){
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];

                topRight = boundedFence;
                right = boundedFence;
                bottomLeft = boundedFence;
                bottomMiddle = boundedFence;
                bottomRight= boundedFence;
            }else if(yCoord == 0){
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];

                topLeft = boundedFence;
                topMiddle = boundedFence;
                topRight = boundedFence;
            }else if (yCoord == end){
                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];

                bottomLeft = boundedFence;
                bottomMiddle= boundedFence;
                bottomRight = boundedFence;
            }else if(xCoord == 0){
                topLeft = boundedFence;
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent + 1];
                left = boundedFence;
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                bottomLeft = boundedFence;
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
            }else if(xCoord == end){
                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = boundedFence;
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = boundedFence;
                bottomLeft = mapThreeDime[oneBelow][oneBefore][historyCurrent];
                bottomMiddle = mapThreeDime[oneBelow][xCoord ][historyCurrent];
                bottomRight = boundedFence;
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
        int neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;

        //and now, below are the conway's rules. These are pretty much directly translated into code
        if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){ //if the selected cell is currently alive
            //System.out.println("Alive");
            if(neighboursValue < 2 || neighboursValue > 3){ // if the neighboursValue is less than two, the cell will die (underpopulation) or if it's more than three, the cell will die (overpopulation)
                //System.out.println("dead");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 0; //returns the 'dead' value
            }else if(neighboursValue == 2 || neighboursValue == 3){ //if it's 2 or three, the cell remains alive 
                //System.out.println("alive");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }

        }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){ //if the selected cell is currently dead
            //System.out.println("dead");
            if(neighboursValue == 3){ // and it has three live neighbours, it becomes alive 
                //System.out.println("becomes alive");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive);//passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }else { //for every other value, it remains dead
                //System.out.println("stays dead");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive);//passes the dead/alvie info and the selected cell location info to the history replacer
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

    //this method has an awful lot of comments, and I'm sorry, but even I find this confusing, and I wrote the code. 
    public void historyReplacer(int yCoord, int xCoord, int living){ //this moves all the histories of a given point back one.
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

    public static void slowPrint(int timeWaiting) {

        try {
            TimeUnit.MILLISECONDS.sleep(timeWaiting);
        }
        catch (Exception e) {

        }

    }

    public static void screenSize()
    {
        // getScreenSize() returns the size
        // of the screen in pixels
        Dimension size
        = Toolkit.getDefaultToolkit().getScreenSize();

        // width will store the width of the screen
        int width = (int)size.getWidth();

        // height will store the height of the screen
        int height = (int)size.getHeight();

        System.out.println("Current Screen resolution : "
            + "width : " + width
            + " height : " + height);
    }

}

/*
//CODE BANK
//Prints out a 2D array (nested loop)
-------
System.out.println("prints a 2D array, currently prints the orginal map");
for(int a = 0; a < 10; a++){
for(int b = 0; b < 10; b++){
System.out.print(map[a][b]);
}
System.out.println();
}
--------

// public void listeningMethod(int timeToWaitFor){
// Scanner keyboard = new Scanner(System.in);
// int end = timeToWaitFor - 1;
// for(int l = 0; l < timeToWaitFor; l++){
// slowPrint(1);
// l++;
// if(l == end){
// }
// }

// }

 */

