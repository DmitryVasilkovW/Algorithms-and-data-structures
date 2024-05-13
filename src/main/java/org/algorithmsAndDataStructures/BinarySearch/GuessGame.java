package org.algorithmsAndDataStructures.BinarySearch;

public class GuessGame
{
    int pick;

    public GuessGame(int pick)
    {
        this.pick = pick;
    }

    public int guess(int num)
    {
        if (num == pick)
        {
            return 0;
        }
        else if (num > pick)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
