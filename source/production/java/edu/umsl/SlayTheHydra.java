package edu.umsl;

import java.util.Scanner;

public class SlayTheHydra {
    public static void main(String[] args) {
        //scanner object for input
        Scanner input = new Scanner(System.in);
        //variables to hold number of heads and tails for Hydra
        //instance of Hydra object
        Hydra hydie = new Hydra();
        //instance of PyPy object
        Pypy pypy = new Pypy();

        //game intro
        System.out.println("(Game visibility is best in a maximized window)");
        System.out.println();
        System.out.println("**********SLAY THE HYDRA**********");
        System.out.println("Princess Perly has been kidnapped by the magical Hydra!");
        System.out.println("It's up to PyPy to defeat the Hydra and save the day!");
        System.out.println("Make strategic choices about how many heads or tails to cut.");
        System.out.println("A min move value of -1 indicates the Hydra cannot be defeated.");
        System.out.println("Can you defeat the Hydra in the minimum number of moves?");
        System.out.println("**********************************");
        System.out.println();
        //starts game loop
        playGame(input, hydie, pypy);

    }

    //takes user input and validates that it is an integer
    public static int userInt(Scanner myScanner) {
        int num = 0;
        //checks that user is entering an integer and validates input
        do {
            //displays error message if user inputs negative int
            if (num < 0)
            {
                System.out.println("Please enter positive integers only.");
            }

            //checks that user is entering ONLY integers; if not prompts user to try again
            while (!myScanner.hasNextInt())
            {
                System.out.println("Please enter positive integers only.");
                myScanner.next();
            }

            //takes user input; if input is valid, exits do-while loop
            num = myScanner.nextInt();


        } while (num < 0);
        return num;
    }

    public static void initializeHydra(Hydra hydra, Scanner scanner) {
        //prompts user for number of heads for Hydra
        System.out.println("Please enter a number of heads for the Hydra: ");
        int heads = userInt(scanner);
        System.out.println("Please enter a number of tails for the Hydra: ");
        int tails = userInt(scanner);
        while (heads < 1 && tails < 1)
        {
            System.out.println("Hydra must have at least one head or one tail.");
            System.out.println("Please enter a number of heads for the Hydra: ");
            heads = userInt(scanner);
            System.out.println("Please enter a number of tails for the Hydra: ");
            tails = userInt(scanner);
        }
        hydra.setHnum(heads);
        hydra.setTnum(tails);
    }

    public static void playGame(Scanner scanner, Hydra hydra, Pypy pypy) {
        boolean play = true;
        boolean isDead = false;
        int playerChoice;
        int turnCount = 0;
        //initialize hydra
        initializeHydra(hydra, scanner);
        int minTurns = hydra.minMoves();
        do {
            ++turnCount;
            System.out.println("TURN: " + turnCount);
            //display hydra stats
            System.out.println(hydra);
            //display PyPy's moves
            pypy.pypyMoves();
            //prompt user to select a move, checks that input is a valid choice
            System.out.println("Make a selection: ");
            playerChoice = userInt(scanner);
            while (playerChoice < 1 || playerChoice > 5)
            {
                System.out.println(hydra);
                pypy.pypyMoves();
                System.out.println("Please make a valid selection (1-5): ");
                playerChoice = userInt(scanner);
            }
            //switch case block for each selection
            switch (playerChoice) {
                case 1:
                    pypy.cutOneHead(hydra);
                    break;
                case 2:
                    pypy.cutTwoHeads(hydra);
                    break;
                case 3:
                    pypy.cutOneTail(hydra);
                    break;
                case 4:
                    pypy.cutTwoTails(hydra);
                    break;
                case 5:
                    System.out.println("------------------------------");
                    System.out.println("PyPy surrenders! The Hydra's rampage continues...");
                    System.out.println("------------------------------");
                    play = false;
                    break;
                default:
                    System.out.println("Invalid move. Try again.");
                    break;
            }
            //checks if Hydra is still alive, if not, displays victory message
            if (hydra.getTnum() > 0 || hydra.getHnum() > 0)
            {
                continue;
            }
            else
            {
                System.out.println("------------------------------");
                if (turnCount == minTurns)
                {
                    System.out.println("✧･ﾟ:*✧･ﾟ:*");
                    System.out.println("PyPy has slain the Hydra!");
                    System.out.println("Minimum moves achieved!");
                    System.out.println("Congratulations!");
                    System.out.println("✧･ﾟ:*✧･ﾟ:*");
                }
                else
                {
                    System.out.println("PyPy has slain the Hydra!\nCongratulations!");
                }
                System.out.println("------------------------------");
                isDead = true;
            }
        } while (play && !isDead);
        again(scanner, hydra, pypy);
    }

    public static void again (Scanner scanner, Hydra hydra, Pypy pypy) {
        int restart;
        System.out.println("Play again?");
        System.out.println("1: YES");
        System.out.println("2: NO");
        restart = userInt(scanner);
        while (restart < 1 || restart > 2)
        {
            System.out.println("Please make a valid selection: ");
            System.out.println("Play again?");
            System.out.println("1: YES");
            System.out.println("2: NO");
            restart = userInt(scanner);
        }
        if (restart == 1)
        {
            playGame(scanner, hydra, pypy);
        }
        else
        {
            System.out.println("Thanks for playing!");
            System.out.println("Exiting...");
        }
    }
}


