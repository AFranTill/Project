

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
    private int mapTwo[][] = new int[10][10]; 
    int[][] map =
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
        
    private int mapThreeDime[][][] = new int[10][10][5]; 
    /**
     * Constructor for objects of class TheGame
     */
    public TheGame()
    {
        // initialise instance variables
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(map[a][b]);
            }
            System.out.println();
            }
        System.out.println("you want this to run?");
        boolean thisIsRunning = false;
        int goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            thisIsRunning = true;
        }else{
            thisIsRunning = false;
        }

        int bestie = 0;
        while(thisIsRunning == true && bestie < 1){
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

            for(int y = 0; y < 10; y++){
                for(int x = 0; x < 10; x++){
                    int living = isItAlive(y, x);
                    //int living = (int)(Math.floor(Math.random()*(1-0+1)+0));
                    //System.out.println(living);
                    
                    if(living == 1){
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" 1 ");
                        mapTwo[y][x] = living;
                    }else if (living == 0){
                        System.out.print(" 0 ");
                        mapTwo[y][x] = living;
                    }else{
                    }
                
                }
                System.out.println();
            }


            //isItAlive(4,5);
            bestie++;
        }
        
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(mapTwo[a][b]);
            }
            System.out.println();
            }
    }

    public int isItAlive(int yCoord, int xCoord)
    {
        if(yCoord == 0 || xCoord == 0 || yCoord == 9 || xCoord == 9){
            System.out.print(" _ ");
            return 4;
        }else{
            //System.out.println(yCoord + " and " + xCoord);
            int topLeft = map[yCoord - 1][xCoord -1];
            int topMiddle = map[yCoord - 1][xCoord];
            int topRight = map[yCoord - 1][xCoord + 1];
            int right = map[yCoord][xCoord + 1];
            int left = map[yCoord][xCoord - 1];
            int bottomLeft = map[yCoord + 1][xCoord - 1];
            int bottomMiddle = map[yCoord + 1][xCoord ];
            int bottomRight = map[yCoord + 1][xCoord + 1];

            int neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
            //System.out.println(neighboursValue);

            if (map[yCoord][xCoord] == 1){
                //System.out.println("Alive");
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

            }else if(map[yCoord][xCoord] == 0){
                //System.out.println("dead");
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
