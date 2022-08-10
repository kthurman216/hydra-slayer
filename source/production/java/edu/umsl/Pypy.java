package edu.umsl;

public class Pypy {
    /*method for PyPy to cut off one tail; if the hydra has no tails, informs the player that the hydra has no
    tails to cut. Otherwise, adds 1 to the number of tails on the hydra (PyPy cuts one tail and two grow in
    its place)*/
    public void cutOneTail(Hydra hydra){
        int tails = hydra.getTnum();
        if (hydra.getTnum()==0)
        {
            System.out.println("------------------------------");
            System.out.println("There are no tails left to cut!");
            System.out.println("------------------------------");
        }
        else
        {
            hydra.setTnum(tails + 1);
            System.out.println("------------------------------");
            System.out.println("PyPy cuts off one tail!");
            System.out.println("Two tails grow in its place!");
            System.out.println("------------------------------");
        }
    }

    /*method for PyPy to cut off two tails; if the Hydra has less than two tails, informs the player there are
    * less than two tails to cut. Otherwise, adds 1 to the number of heads on the hydra (PyPy cuts two tails
    * and one head grows in their place*/
    public void cutTwoTails(Hydra hydra){
        int tails = hydra.getTnum();
        int heads = hydra.getHnum();
        if (tails < 2)
        {
            System.out.println("------------------------------");
            System.out.println("The hydra has less than two tails. Please select a different move.");
            System.out.println("------------------------------");
        }
        else
        {
            hydra.setTnum(tails - 2);
            hydra.setHnum(heads + 1);
            System.out.println("------------------------------");
            System.out.println("PyPy cuts off two tails!");
            System.out.println("One head grows in their place!");
            System.out.println("------------------------------");
        }
    }

    /*method for PyPy to cut off one head; if the Hydra has no heads, inform the player that the Hydra has no
    * heads to cut. Otherwise, leaves number of heads unchanged (PyPy cuts one head and one head grows in its
    * place*/
    public void cutOneHead(Hydra hydra){
        int heads = hydra.getHnum();
        if (heads < 1)
        {
            System.out.println("------------------------------");
            System.out.println("There are no heads left to cut!");
            System.out.println("------------------------------");
        }
        else
        {
            System.out.println("------------------------------");
            System.out.println("PyPy cuts off one head!");
            System.out.println("One head grows in its place!");
            System.out.println("------------------------------");
        }
    }

    /*method for PyPy to cut off two heads; if the Hydra has less than two heads, inform the player that there
    * are less than two heads to cut. Otherwise, subtract two from the number of heads (PyPy cuts off two
    * heads, the Hydra does not do anything else*/
    public void cutTwoHeads(Hydra hydra){
        int heads = hydra.getHnum();
        if (heads < 2)
        {
            System.out.println("------------------------------");
            System.out.println("The Hydra has less than two heads left. Please select another move.");
            System.out.println("------------------------------");
        }
        else
        {
            hydra.setHnum(heads - 2);
            System.out.println("------------------------------");
            System.out.println("PyPy cuts off two heads!");
            System.out.println("The Hydra is too injured to react!");
            System.out.println("------------------------------");
        }

    }

    /*method to display PyPy's moves*/
    public void pypyMoves() {
        System.out.println("**********PYPY'S MOVES**********");
        System.out.println("1: CUT ONE HEAD");
        System.out.println("Description: PyPy cuts off one head; the Hydra grows back one head.");
        System.out.println("2: CUT TWO HEADS");
        System.out.println("Description: PyPy cuts off two heads; the Hydra does nothing.");
        System.out.println("3: CUT ONE TAIL");
        System.out.println("Description: PyPy cuts off one tail; the Hydra grows back two tails.");
        System.out.println("4: CUT TWO TAILS");
        System.out.println("Description: PyPy cuts off two tails; the Hydra grows back one head.");
        System.out.println("5: QUIT");
        System.out.println("Description: Give up and exit game.");
        System.out.println("********************************");
    }
}
