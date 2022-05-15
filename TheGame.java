
/**
 * Write a description of class TheGame here.
 *
 * @author Frances
 * @version Verision Five, 15.5.22
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
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
            { {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0} },
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
       
    
     
    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        
        System.out.println("you want this to run?");
        boolean thisIsRunning = false;
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            thisIsRunning = true; //allows the thing to run
        }else{
            thisIsRunning = false; //prevents the thing from running (the thign is the conway game btw)
        }
        
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
        }
        
        
                
        int numberOfGenerations = 0; //controls how many times the game loops/how many generations there are. 
        while(thisIsRunning == true && numberOfGenerations < 10){ //this is the loop which actually runs the conway game 
            System.out.println("running" + numberOfGenerations); //tells user what generation they are on
            //System.out.println('\u000c');
            System.out.println(); //bet you can't guess what this does

            //the main loop which actually runs game (one loop is one generation)
            for(int y = 0; y < heightOfGrid; y++){ //this runs through the y values (and stops when reached height of the grid)
                for(int x = 0; x < widthOfGrid; x++){ // same as above but for x and width not height 
                    int living = isItAlive(y, x); //calls the isItAlive method, and asks if the point is alive 
                    int h = 0; //dealing with just history = 0, or the current history/working grid. 

                    if(living == 1){ //if it's living 
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" " + mapThreeDime[y][x][h] + " "); //prints out the value
                        mapTwo[y][x] = living; // puts the value into the control group map 
                    }else if (living == 0){ //does literally the exact same thing as above why is this an if statement. 
                        System.out.print(" " + mapThreeDime[y][x][h] + " ");
                        mapTwo[y][x] = living;
                    }else{ //else do nothing. 
                    }

                }
                System.out.println(); 
            }

            numberOfGenerations++; //adds one to the generation number, lets us know one full generation has been done. 
        }
        
        
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
        
    }

    public int isItAlive(int yCoord, int xCoord)//pass it the coord of the point, so we know what point we're investigating
    {
        //this is the method that is called on every point to find out if it's alive or not alive. 
        int historyCurrent = 0; //this is semantics, but for most of this, are dealing with the history value of 0, or the current grid alyout. 
        int shallItBeAlive; //creates a value that will be passed to the history replacer, and become living. This will only be assigned a value at the very end, just before the return statement. 
        if(yCoord == 0 || xCoord == 0 || yCoord == 9 || xCoord == 9){ //because the boundaries of the map are complicated in terms of arrays
            // this just says ignore then and print a nice little border instead
            //will eventually be fixed 
            System.out.print(" _ ");
            return 4; //returns a non-real value (in this context)
        }else{ //if it's not a boundary condition
            //what the next, huge & ineffecient block of code is doing, is essentially get all the values of the surronding squares and adding them together
            //these are the top row, so they have a y value of one less, and varying x values to cover all three x values above the selected cell
            int topLeft = mapThreeDime[yCoord - 1][xCoord -1][historyCurrent + 1];
            int topMiddle = mapThreeDime[yCoord - 1][xCoord][historyCurrent + 1];
            int topRight = mapThreeDime[yCoord - 1][xCoord + 1][historyCurrent + 1];
            //for the two below, they have the same y value but different x values, as they are in the same row but not same column
            int left = mapThreeDime[yCoord][xCoord - 1][historyCurrent + 1];
            //for the four above, we have already been throguh and tested their aliveness, and add that to their history, so we are actuall drawing on the history one in the past
            int right = mapThreeDime[yCoord][xCoord + 1][historyCurrent];
            //these are all in the row below, so they have vrying x values and all a y value of one more, for the row just below
            int bottomLeft = mapThreeDime[yCoord + 1][xCoord - 1][historyCurrent];
            int bottomMiddle = mapThreeDime[yCoord + 1][xCoord ][historyCurrent];
            int bottomRight = mapThreeDime[yCoord + 1][xCoord + 1][historyCurrent];
            
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
            
            return 3;
        }
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

 

*/
 
