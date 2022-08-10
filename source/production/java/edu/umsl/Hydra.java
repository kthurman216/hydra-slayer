package edu.umsl;

public class Hydra {
    //private variables for number of heads and tails
    private int hnum;
    private int tnum;

    //empty constructor for Hydra class
    public Hydra() { }

    //constructor for Hydra with parameters for heads and tails
    public Hydra(int heads, int tails) {
        setHnum(heads);
        setTnum(tails);
    }

    //getter for number of heads
    public int getHnum() {
        return hnum;
    }

    //setter for number of heads
    public void setHnum(int hnum) {
        this.hnum = hnum;
    }

    //getter for number of tails
    public int getTnum() {
        return tnum;
    }

    //setter for number of tails
    public void setTnum(int tnum) {
        this.tnum = tnum;
    }

    /*method to calculate the minimum number of moves needed to kill the Hydra.
     * ~If ZERO tails remaining and the number of heads is ODD, sets moves to -1, indicating that the Hydra
     * cannot be killed
     * ~If the number of heads is ODD, calculates how many tails need to be added to reach a number
     * of tails where tails/2 is an ODD number
     * ~If number of heads is EVEN and tails is ODD, calculates how many tails need to be added to reach a number
     * of tails where tails/2 is an EVEN number
     * ~If number of heads and tails are EVEN, and tails/2 is EVEN, calculates how many times 2 tails and 2 heads
     * need to be cut off to win*/
    public int minMoves(){
        int moves = 0;
        int heads = hnum;
        int tails = tnum;
        //if there is an odd number of heads and no tails, cannot win
        if (tails == 0 && heads % 2 == 1)
        {
            moves = -1;
        }
        else
        {
            while (heads > 0 || tails > 0)
            {
                //if even heads and no tails
                if (heads % 2 == 0 && tails == 0)
                {
                    heads -= 2;
                    moves++;
                }
                //if even heads and even tails
                else if (heads % 2 == 0 && tails % 2 == 0)
                {
                    //if tails/2 is even
                    if ((tails/2) % 2 == 0)
                    {
                        tails -= 2;
                        heads++;
                    }
                    //if tails/2 is odd
                    else
                    {
                        tails++;
                    }
                    moves++;
                }
                //if even heads and odd tails
                else if (heads % 2 == 0 && tails % 2 == 1)
                {
                    tails++;
                    moves++;
                }
                //if odd heads and even tails
                else if (heads % 2 == 1 && tails % 2 == 0)
                {
                    //if tails/2 is ODD
                    if ((tails/2) % 2 == 1)
                    {
                        tails -= 2;
                        heads++;
                    }
                    else
                    {
                        tails++;
                    }
                    moves++;
                }
                //else if odd heads and odd tails
                else
                {
                    tails++;
                    moves++;
                }
            }
        }
        return moves;
    }

    //to String override method

    @Override
    public String toString() {
        String separator = "********************\n";
        String hydra = "HYDRA \n";
        String stats = "HEADS: " + hnum + "\tTAILS: " + tnum;
        String min = "\nMIN MOVES: " + minMoves() + "\n";
        return separator + hydra + stats + min + separator;
    }


}

