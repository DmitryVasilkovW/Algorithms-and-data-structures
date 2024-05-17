package org.algorithmsAndDataStructures.BinarySearch;
// https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75

public class GuessNumberHigherOrLower extends GuessGame
{
    public GuessNumberHigherOrLower(int pick)
    {
        super(pick);
    }

    public int guessNumber(int n)
    {
        long l = -1, r = n;
        long mid = 0;

        while(l + 1 <= r)
        {
            mid = (r + l + 1) / 2;

            if (super.guess((int) mid) == -1)
            {
                r = mid;
            }
            else if (super.guess((int) mid) == 1)
            {
                l = mid;
            }

            if (super.guess((int)mid) == 0)
            {
                return (int) mid;
            }
        }

        return 1;
    }

    public static void main(String[] args)
    {
        var g = new GuessNumberHigherOrLower(1702766719);

        System.out.println(g.guessNumber(2126753390));
    }
}
