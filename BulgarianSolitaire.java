import java.util.ArrayList;

public class BulgarianSolitaire
{
    private ArrayList<Integer> board;

    /**
     * No args constructor random card configuration
     */
    public BulgarianSolitaire()
    {
        board = new ArrayList<Integer>();
        int total = 45;
        int counter = 0;
        int placeHolder = 0;
        while(total != 0)
        {
            placeHolder = (int) (Math.random() * total + 1);
            board.add(counter, placeHolder);
            total = total - placeHolder;
            counter++;
        }
    }

    /**
     * [20, 5, 1, 9, 10] Bulgarian Solitare configuration
     * @param board
     */
    public BulgarianSolitaire(ArrayList<Integer> board)
    {
        this.board = board;
    }

    /**
     * Move method
     * Subtracts 1 from each index/pile and add subtracted cards to the end
     * Also deletes piles with 0 cards in them
     */
    public void move()
    {
        for (int i = 0; i < board.size(); i++)
        {
            int replace = board.get(i);
            replace--; // subtracts 1 from each pile
            board.remove(i);
            board.add(i, replace);
        }
        board.add(board.size()); //adds size to the end of array
        int counter = 0; //counter variable
        while(counter < board.size()) //while loop that deletes piles with 0 cards in them
        {
            if(board.get(counter) == 0)
            {
                board.remove(counter);
            }
            else
            {
                counter++;
            }
        }

    }

    /**
     * Checks if the game is over and cards are in this order -> [1, 2, 3, 4, 5, 6, 7, 8, 9]
     *
     * @return true if game is over and all cards are in the right order
     *          false if game is not over and cards are not in the right order
     */
    public boolean gameOver()
    {
        boolean check = false;
        for (int i = 0; i < this.board.size(); i++)
        {
            if(this.board.get(i) == i + 1)
            {
                check = true;
            }
            else
            {
                check = false;
                break; // leaves loop if cards are not in right order
            }
        }
        return check;
    }

    /**
     * @return toString output of board
     */
    public String toString()
    {
        String rtn = "BulgarianSolitaire: [";
        for (int i = 0; i < board.size() - 1; i++)
        {
            int current = board.get(i);
            rtn += current;
            rtn += ", ";
        }
        int last = board.get(board.size() - 1);
        rtn += last;
        rtn += "]";

        return rtn; //returns board
    }
}
