
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

    //private int mapThreeDime[][][] = new int[10][10][5]; 
    
      int[][][] mapThreeDime=
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
        
        System.out.println("you want to populate the thing?");
        goingThrough = yesOrNoQuestionMethod(0); //calls the method which handles yes or no questions, assigns the value to goingthrough
        if(goingThrough == 1){ //if it's one, thats a yes, and do 
            System.out.println("beginning at..");
                for(int y = 0; y < 10; y++){
                    for(int x = 0; x < 10; x++){
                        int h = 0;
                        //System.out.println(living);
                        mapThreeDime[y][x][h] = (int)(Math.floor(Math.random()*(1-0+1)+0));;
                        System.out.print(" " + mapThreeDime[x][y][h] + " ");
                    }
                    System.out.println();
                }
        }else{
            System.out.println("ok");
        }
        
        
                
        int bestie = 0;
        while(thisIsRunning == true && bestie < 10){
            System.out.println("running" + bestie);
            //System.out.println('\u000c');
            System.out.println();


            for(int y = 0; y < 10; y++){
                for(int x = 0; x < 10; x++){
                    int living = isItAlive(y, x);
                    int h = 0;
                    //int living = (int)(Math.floor(Math.random()*(1-0+1)+0));
                    //System.out.println(living);

                    if(living == 1){
                        //System.out.print(" " + map[x][y] + " ");
                        System.out.print(" " + mapThreeDime[y][x][h] + " ");
                        mapTwo[y][x] = living;
                    }else if (living == 0){
                        System.out.print(" " + mapThreeDime[y][x][h] + " ");
                        mapTwo[y][x] = living;
                    }else{
                    }

                }
                System.out.println();
            }

            //isItAlive(4,5);
            bestie++;
        }
        
        System.out.println("what it became");
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(" " + mapTwo[a][b] + " ");
            }
            System.out.println();
        }
        
        System.out.println("history just happened");
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(" " + mapThreeDime[a][b][1] + " ");
            }
            System.out.println();
        }
    
        System.out.println("history just before just happened");
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(" " + mapThreeDime[a][b][2] + " ");
            }
            System.out.println();
        }
        
        System.out.println("history just before just happened");
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(" " + mapThreeDime[a][b][3] + " ");
            }
            System.out.println();
        }
        
        System.out.println("history just before just happened");
        for(int a = 0; a < 10; a++){
            for(int b = 0; b < 10; b++){
                System.out.print(" " + mapThreeDime[a][b][4] + " ");
            }
            System.out.println();
        }
        
    }

    public int isItAlive(int yCoord, int xCoord)
    {
        int historyCurrent = 0;
        int shallItBeAlive;
        if(yCoord == 0 || xCoord == 0 || yCoord == 9 || xCoord == 9){
            System.out.print(" _ ");
            return 4;
        }else{
            //System.out.println(yCoord + " and " + xCoord);
            int topLeft = mapThreeDime[yCoord - 1][xCoord -1][historyCurrent + 1];
            int topMiddle = mapThreeDime[yCoord - 1][xCoord][historyCurrent + 1];
            int topRight = mapThreeDime[yCoord - 1][xCoord + 1][historyCurrent + 1];
            int left = mapThreeDime[yCoord][xCoord - 1][historyCurrent + 1];
            int right = mapThreeDime[yCoord][xCoord + 1][historyCurrent];
            int bottomLeft = mapThreeDime[yCoord + 1][xCoord - 1][historyCurrent];
            int bottomMiddle = mapThreeDime[yCoord + 1][xCoord ][historyCurrent];
            int bottomRight = mapThreeDime[yCoord + 1][xCoord + 1][historyCurrent];

            int neighboursValue = bottomRight + bottomMiddle + bottomLeft + left + right + topLeft + topMiddle + topRight;
            //System.out.println(neighboursValue);

            if (mapThreeDime[yCoord][xCoord][historyCurrent] == 1){
                //System.out.println("Alive");
                if(neighboursValue < 2){
                    //System.out.println("dead");
                    shallItBeAlive = 0;
                    historyReplacer(yCoord, xCoord, shallItBeAlive);
                    return 0;
                }else if(neighboursValue == 2 || neighboursValue == 3){
                    //System.out.println("alive");
                    shallItBeAlive = 1;
                    historyReplacer(yCoord, xCoord, shallItBeAlive);
                    return 1;
                }else if (neighboursValue > 3){
                    //System.out.println("dead");
                    shallItBeAlive = 0;
                    historyReplacer(yCoord, xCoord, shallItBeAlive);
                    return 0;
                }

            }else if(mapThreeDime[yCoord][xCoord][historyCurrent] == 0){
                //System.out.println("dead");
                if(neighboursValue == 3){
                    //System.out.println("becomes alive");
                    shallItBeAlive = 1;
                    historyReplacer(yCoord, xCoord, shallItBeAlive);
                    return 1;
                }else {
                    //System.out.println("stays dead");
                    shallItBeAlive = 0;
                    historyReplacer(yCoord, xCoord, shallItBeAlive);
                    return 0;
                }
            }else{
                System.out.println("error");
                return 2;
            }
            return 2;
        }
    }

    public void historyReplacer(int yCoord, int xCoord, int living){
        int toMove = living;
        int assign;
        for(int h = 0; h < 5; h++){
            if(h == 4){
                assign = toMove;
                mapThreeDime[yCoord][xCoord][h] = assign;
            }else{
                assign = toMove;
                toMove = mapThreeDime[yCoord][xCoord][h];
                mapThreeDime[yCoord][xCoord][h] = assign;

            }
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
