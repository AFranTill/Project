
/**
 * Write a description of class readingandwritingjust here.
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

public class readingandwritingjust 
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

    /**
     * Constructor for objects of class readingandwritingjust
     */
    public readingandwritingjust()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println('\u000c');
        int hi = 0;
        int goingThrough;
        boolean thisIsRunning = false;

        System.out.println(" Hi ");

        int whatWeAreDoing = 1;
        if(whatWeAreDoing == 1){
            size = readingAFile();
            
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

    public void printIt(int h, int[][][] mapThreeDime){
        for(int y = 0; y < heightOfGrid; y++){ //nested loop, to go through the array int x = 0; x < widthOfGrid; x++
            for(int x = 0; x < widthOfGrid; x++){
                System.out.print(" " + mapThreeDime[y][x][h] + " "); //print it out nicely. 
            }
            System.out.println(); //next line 
        }
    }

    public int readingAFile(){
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("reading a file");
        File myFile = new File("hasAGrid.txt");
        int awesome = 0;
        int epic = 0;

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
    
    public int gettingTheString(){
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("reading a file");
        File myFile = new File("hasAGrid.txt");
        int awesome = 0;
        int epic = 0;
        String thing;
        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                thing = readTheFile.nextLine();
                System.out.println(thing);
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

    public void FileWritingSecondMightBeBetter()
    {
        Scanner keyboardInput = new Scanner(System.in);

        System.out.println("please type a full file name (with the type also)");
        System.out.println("hint = try test.txt");
        String fileName = keyboardInput.nextLine();
        File myFile = new File(fileName);
        try {
            //trying something hopefull it works
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());
            }
        }
        catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }

        boolean areWeWriting = true;
        try{
            File workingFile = new File ("thisIWillWriteTo.txt");

            FileWriter newWriterThing = new FileWriter(workingFile);

            newWriterThing.write("It's the end of the world.\n");
            newWriterThing.write("And honestly, it's not that bad\n");
            newWriterThing.write("~begins every teen dystopia~\n");
            newWriterThing.flush();
            newWriterThing.close();

            Scanner readingThisFile = new Scanner(workingFile);
            while (readingThisFile.hasNextLine()){
                System.out.println(readingThisFile.nextLine());
            }
        }catch(IOException e){
            System.out.println("broken");
        }

        System.out.println("And one last file");
        System.out.println("btw, try 'youShouldSayPeekaboo.txt'");
        String mightBeAFileName = keyboardInput.nextLine();
        File nextWorkingFile = new File(mightBeAFileName);
        boolean writingAndReading = true;
        int numberOfLines = 0;
        try {
            while (writingAndReading == true){//trying something hopefull it works
                Scanner readTheFile = new Scanner(nextWorkingFile);
                while (readTheFile.hasNextLine()){
                    System.out.println(readTheFile.nextLine());
                }
                System.out.println("Add anything? If not, say '.'");
                String lineToAdd = keyboardInput.nextLine();
                FileWriter currentWriterThing = new FileWriter(nextWorkingFile, true); //PASSES IT FILE NAME AND APPEND = TRUE, SO IT ADDS INSTEAD OF REWRITING (OMG IT TOOK SO LONG TO FIND OUT HOW TO DO THAT)
                if (lineToAdd.equals(".")){
                    //newWriterThing.flush();
                    //newWriterThing.close();
                    writingAndReading = false; 
                }else{ 
                    /*
                    //currentWriterThing.write("hey");
                    numberOfLines+= 1;
                    System.out.println(numberOfLines);
                    for(int x = 0; x >= numberOfLines; x++){
                    currentWriterThing.write("\n");
                    }*/
                    currentWriterThing.write(lineToAdd+"\n");
                    currentWriterThing.flush();

                    while (readTheFile.hasNextLine()){
                        System.out.println(readTheFile.nextLine());
                    }               
                }

            }

        }
        catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println(" failed ");
        }

    }

    public void FileReadingSecondMightBeBetter(){
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("please type a full file name (with the type also)");
        System.out.println("hint = try test.txt");
        String fileName = keyboardInput.nextLine();
        File myFile = new File(fileName);
        try {
            //trying something hopefull it works
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());
            }
        }
        catch(IOException e){
            //and if it doesn't work
            e.printStackTrace();
            System.out.println("yeah, that didn't work. Maybe you typed it wrong, maybe that file does't exist, or maybe I ust don't have it. Sorry. ");
        }
    }
}

