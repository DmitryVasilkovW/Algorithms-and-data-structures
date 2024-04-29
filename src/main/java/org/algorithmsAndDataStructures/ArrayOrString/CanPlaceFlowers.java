package org.algorithmsAndDataStructures.ArrayOrString;
// https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75

public class CanPlaceFlowers
{
    public boolean canPlaceFlowers(int[] flowerbed, int n)
    {
        int i = 1;

        if (flowerbed[0] == 0 && flowerbed.length == 1) return true;
        if ((i - 1 == 0 && flowerbed[0] == 0 && flowerbed[i] == 0) && n > 0)
        {
            n--;
            i++;
        }

        for (; i < flowerbed.length - 1; i++)
        {
            if (n == 0) break;
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
            {
                n--;
                i++;
            }
        }

        if ((i == flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) && n > 0) n--;

        return n == 0;
    }

    public static void main(String[] args)
    {
        System.out.println((new CanPlaceFlowers().canPlaceFlowers(new int[]{0,0,0}, 1)));
    }
}
