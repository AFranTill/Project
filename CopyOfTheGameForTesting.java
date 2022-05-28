
/**
 * Write a description of class CopyOfTheGameForTesting here.
 *
 * @author Frances
 * @version Verision Five, 16.5.22
 */
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.awt.*;

public class CopyOfTheGameForTesting 
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
            { {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {1,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
        };  
    int size;
    boolean going = true;

    int timeToWaitFor;
    int timeWaiting;
    int howManyGenerationsAreWeDoing;

    /**
     * Constructor for objects of class CopyOfTheGameForTesting
     */
    public CopyOfTheGameForTesting()
    {
        Scanner keyboard = new Scanner(System.in);

        screenSize();
        timeToWaitFor = 20;
        timeToWaitFor = (timeWaiting/4)*3;
        timeWaiting = timeWaiting - timeToWaitFor; 
        size = 10;
        heightOfGrid = size;
        widthOfGrid = size;
        howManyGenerationsAreWeDoing = 1;
        numberOfHistoriesRecorded  = 5;
        int numberOfGenerations = 0;
        boolean thisIsRunning = true;

        System.out.println("beginning at.."); //tells the user what's happening 
        for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
            for(int x = 0; x < widthOfGrid; x++){
                int h = 0; //only affect the first history, aka the working history, the current grid
                //mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
            }
            System.out.println(); //next line 
        }

        // System.out.println("beginning at.."); //tells the user what's happening 
        // for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
            // for(int x = 0; x < widthOfGrid; x++){
                // int h = 0; //only affect the first history, aka the working history, the current grid
                // mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                // System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
            // }
            // System.out.println(); //next line 
        // }

        while(thisIsRunning == true && numberOfGenerations < howManyGenerationsAreWeDoing && going == true){ //this is the loop which actually runs the conway game 
            //System.out.println('\u000c'); //clears the screen
            System.out.println("running " + numberOfGenerations); //tells user what generation they are on
            System.out.println(); //bet you can't guess what this does
            //listeningMethod(timeToWaitFor);

            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    int living = isItAlive(y, x); //calls the isItAlive method, and asks if the point is alive 
                    int h = 1; //dealing with just history = 0, or the current history/working grid. 
                    //System.out.print(" " + mapThreeDime[x][y][h] + " ");

                    if(living == 1){ //if it's living 
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" " + mapThreeDime[x][y][h] + " "); //prints out the value
                        mapTwo[y][x] = living; // puts the value into the control group map 
                    }else if (living == 0){ //does literally the exact same thing as above why is this an if statement. 
                        System.out.print(" " + mapThreeDime[x][y][h] + " ");
                        mapTwo[y][x] = living;
                    }else{ //else do nothing. 
                    }

                }
                System.out.println(); 
            }

            slowPrint(timeWaiting);
            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }

        for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array
            for(int x = 0; x < widthOfGrid; x++){
                int h = 0; //only affect the first history, aka the working history, the current grid
                //mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));; //assign it a random number (either one or zero)
                //System.out.print(" " + mapThreeDime[x][y][h] + " "); //print it out nicely. 
            }
            System.out.println(); //next line 
        }

    }
    public int isItAlive(int yCoord, int xCoord)//pass it the coord of the point, so we know what point we're investigating
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

        // System.out.println(historyCurrent);
        // System.out.println(shallItBeAlive);
        // System.out.println(oneBefore);
        // System.out.println(oneAfter);
        // System.out.println(oneBelow);
        // System.out.println(oneAbove);
        // System.out.println(oneBefore);
        // System.out.println(topLeft);
        // System.out.println(topMiddle);
        // System.out.println(topRight);
        // System.out.println(left);
        // System.out.println(right);
        // System.out.println(bottomLeft);
        // System.out.println(bottomMiddle);
        // System.out.println(bottomRight);
        // System.out.println(end);
        // System.out.println(size);
        // System.out.println(neighboursValue);

        if(yCoord == 0 || xCoord == 0 || yCoord == end || xCoord == end){ //because the boundaries of the map are complicated in terms of arrays
            if(yCoord == 0 && xCoord == 0 ){
                //System.out.print(" C "); 
                System.out.println("bottomRight");
                System.out.println(mapThreeDime[oneBelow][oneAfter][historyCurrent]);
                bottomRight = mapThreeDime[oneBelow][oneAfter][historyCurrent];
                System.out.println(bottomRight);
                System.out.println("---");

                System.out.println("right");
                System.out.println(mapThreeDime[yCoord][oneAfter][historyCurrent]);
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];
                System.out.println(right);
                System.out.println("---");

                System.out.println("bottomMiddle");
                System.out.println(mapThreeDime[oneBelow][xCoord ][historyCurrent]);
                bottomMiddle = mapThreeDime[oneBelow][xCoord][historyCurrent];
                System.out.println(bottomMiddle);
                System.out.println("---");

                topLeft = boundedFence;
                topMiddle = boundedFence;
                topRight = boundedFence;
                left = boundedFence;
                bottomLeft = boundedFence;
                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

            }else if (yCoord == end){
                //System.out.print(" Y "); 

                topLeft = mapThreeDime[oneAbove][oneBefore][historyCurrent + 1];
                topMiddle = mapThreeDime[oneAbove][xCoord][historyCurrent + 1];
                topRight = mapThreeDime[oneAbove][oneAfter][historyCurrent] + 1;
                left = mapThreeDime[yCoord][oneBefore][historyCurrent + 1];
                right = mapThreeDime[yCoord][oneAfter][historyCurrent];

                bottomLeft = boundedFence;
                bottomMiddle= boundedFence;
                bottomRight = boundedFence;

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                 //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ",       ");

                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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

                neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
                //System.out.print(" " + neighboursValue + " ");
                // System.out.print("values");
                // System.out.print(historyCurrent + ", ");
                // //System.out.println(shallItBeAlive);
                // System.out.print(oneBefore + ", ");
                // System.out.print(oneAfter + ", ");
                // System.out.print(oneBelow + ", ");
                // System.out.print(oneAbove + ", ");
                // System.out.print(oneBefore + ", ");
                // System.out.print(topLeft + ", ");
                // System.out.print(topMiddle + ", ");
                // System.out.print(topRight + ", ");
                // System.out.print(left + ", ");
                // System.out.print(right + ", ");
                // System.out.print(bottomLeft + ", ");
                // System.out.print(bottomMiddle + ", ");
                // System.out.print(bottomRight + ", ");
                // System.out.print(end + ", ");
                // System.out.print(size + ", ");
                // System.out.print(neighboursValue + ", ");
                // System.out.println("end of values");

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
            
            //System.out.print(" " + neighboursValue + " ");
            
            neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
        }
        //and then we add them all together 

        //and now, below are the conway's rules. These are pretty much directly translated into code
        if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){ //if the selected cell is currently alive
            //System.out.println("Alive");
            if(neighboursValue < 2 || neighboursValue > 3){ // if the neighboursValue is less than two, the cell will die (underpopulation) or if it's more than three, the cell will die (overpopulation)
                //System.out.print(" d ");
                shallItBeAlive = 0; //assigns the shallItBeAlive the 'dead' value
                historyReplacer(yCoord, xCoord, shallItBeAlive); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 0; //returns the 'dead' value
            }else if(neighboursValue == 2 || neighboursValue == 3){ //if it's 2 or three, the cell remains alive 
                //System.out.print(" a ");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive); //passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }

        }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){ //if the selected cell is currently dead
            //System.out.println("dead");
            if(neighboursValue == 3){ // and it has three live neighbours, it becomes alive 
                //System.out.print(" A ");
                shallItBeAlive = 1; //assigns the shallItBeAlive the 'living' value
                historyReplacer(yCoord, xCoord, shallItBeAlive);//passes the dead/alvie info and the selected cell location info to the history replacer
                return 1; //returns the 'alive' value 
            }else { //for every other value, it remains dead
                //System.out.print(" D ");
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

