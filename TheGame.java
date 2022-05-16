
/**
 * Write a description of class TheGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
public class TheGame
{
    // instance variables - replace the example below with your own
    private int x;
    //private int map[][] = new int[20][20]; 
    int[][] map =
        { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        // initialise instance variables
        System.out.println("you want this to run?");
        boolean thisIsRunning = false;
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            thisIsRunning = true;
        }else{
            thisIsRunning = false;
        }

        int bestie = 0;
        while(thisIsRunning == true && bestie < 5){
            //System.out.println('\u000c');
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            
            /*
            for(int justOnce = 0; justOnce < 0; justOnce++){
                for(int x = 0; x < 20; x++){
                    for(int y = 0; y< 20;y++){
                        int living = isItAlive(x, y);
                        //(int)(Math.floor(Math.random()*(1-0+1)+0));
                        //System.out.println(living);
                        map[x][y] = living;
                        //System.out.print(" " + map[x][y] + " ");
                    }
                    System.out.println();
                }
            }*/

            for(int x = 0; x < 10; x++){
                for(int y = 0; y< 10; y++){
                    int living = isItAlive(x, y);
                    //int living = (int)(Math.floor(Math.random()*(1-0+1)+0));
                    //System.out.println(living);
                    map[x][y] = living;
                    if(living == 1){
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" 1 ");
                    }else if (living == 0){
                        System.out.print(" 0 ");
                    }else{
                    }

                }
                System.out.println();
            }

            /*
            for(int a = 0; a < 20; a++){
            //System.out.print("x ");
            for(int b = 0; b < 20; b++){
            System.out.print(" x ");
            }
            System.out.println();
            }
             */

            //isItAlive(4,5);
            bestie++;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

    public int isItAlive(int xCoord, int yCoord)
    {
        if(xCoord == 0 || yCoord == 0 || xCoord == 9 || yCoord == 9){
            System.out.print("_");
            return 4;
        }else{
            //xCoord = xCoord + 1;
            //yCoord = yCoord + 1;
            //System.out.println(xCoord + " and " + yCoord);
            int xCoordOneLess = xCoord - 1;
            int topLeft = map[xCoord - 1][yCoord -1];
            int topMiddle = map[xCoord][yCoord -1];
            int topRight = map[xCoord + 1][yCoord -1];
            //System.out.println(topRight);
            int right = map[xCoord+1][yCoord];
            int left = map[xCoord-1][yCoord];
            int bottomLeft = map[xCoord - 1][yCoord + 1];
            int bottomMiddle = map[xCoord][yCoord + 1];
            int bottomRight = map[xCoord + 1][yCoord + 1];

            int neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
            //System.out.println(neighboursValue);

            if (map[xCoord][yCoord] == 1){
                if(neighboursValue < 2){
                    //System.out.println("dead");
                    return 0;
                }else if(neighboursValue == 2 || neighboursValue == 3){
                    //System.out.println("alive");
                    return 1;
                }else if (neighboursValue > 3){
                    //System.out.println("dead");
                    return 0;
                }

            }else if(map[xCoord][yCoord] == 0){
                if(neighboursValue == 3){
                    //System.out.println("becomes alive");
                    return 1;
                }else {
                    //System.out.println("stays dead");
                    return 0;
                }
            }else{
                System.out.println("error");
                return 2;
            }
            return 2;
        }
    }

    public int yesOrNoQuestionMethod(int yesOrNo){
        Scanner keyboard = new Scanner(System.in);

        String userInput = keyboard.nextLine();
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();

        if(userInput.equals("yes")||userInput.equals("y")){
            return 1;
        }else if (userInput.equals("no")||userInput.equals("n")){
            return 2;
        }else {
            return 3;
        }

    }

}
