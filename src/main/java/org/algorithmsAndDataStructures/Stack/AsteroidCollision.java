package org.algorithmsAndDataStructures.Stack;
// https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;

public class AsteroidCollision
{
    public static int[] asteroidCollision(int[] asteroids)
    {
        var ans = new Stack<Integer>();

        for (int i = 0; i < asteroids.length; i++)
        {
            if (asteroids[i] < 0 && i > 0)
            {
                int ast = asteroids[i];

                while (true)
                {
                    if (ans.isEmpty())
                    {
                        ans.push(ast);
                        break;
                    }

                    int tmp = ans.pop();

                    if (tmp < 0)
                    {
                        ans.push(tmp);
                        ans.push(ast);
                        break;
                    }

                    if (tmp > ast * -1)
                    {
                        ans.push(tmp);
                        break;
                    }
                    else if (tmp == ast * -1)
                    {
                        break;
                    }
                }
            }
            else
            {
                ans.push(asteroids[i]);
            }
        }

        var ansarr = new int[ans.size()];

        for (int i = ansarr.length - 1; i >= 0; i--)
        {
            ansarr[i] = ans.pop();
        }

        return ansarr;
    }

    public static void main(String[] args)
    {
        System.out.println(asteroidCollision(new int[]{10,2, -7}));
    }
}
