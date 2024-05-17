package org.algorithmsAndDataStructures.BinarySearch;
// https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75

public class KokoEatingBananas
{
    public static boolean check(int[] piles, int h, int k)
    {
        if(k ==0) return false;
        int i = 0;

        while(h >= 0 && i < piles.length)
        {
            h -= Math.ceil((double)piles[i]/k);
            i++;
        }

        return (h >= 0 && i == piles.length);
    }

    public static int minEatingSpeed(int[] piles, int h)
    {
        int r, l = 1, mid;

        r = piles[0];

        for (int i : piles)
        {
            r = Math.max(r, i);
        }

        while (r > l)
        {
            mid = (l + r) / 2;

            if (check(piles, h, mid))
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args)
    {
        System.out.println(minEatingSpeed(new int[]{34392671,891616382,813261297}, 712127987));
    }
}
