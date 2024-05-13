package org.algorithmsAndDataStructures.Queue;
// https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate
{
    public static String predictPartyVictory(String senate)
    {
        Queue<Character> act = new LinkedList<>();
        Queue<Character> sleep = new LinkedList<>();
        var tmp = new StringBuilder(senate);

        boolean d = true;
        boolean r = true;

        for (char c : senate.toCharArray())
        {
            if (d && c == 'R') d = false;
            else if (r && c == 'D') r = false;

            if (!d && !r) break;
        }

        if (d) return "Dire";
        else if (r)  return "Radiant";

        for (int i = 0; i < tmp.length(); i++)
        {
            if (act.isEmpty()) act.add(tmp.charAt(i));
            else
            {
                if (act.peek() != tmp.charAt(i))
                {
                    sleep.add(act.poll());
                    tmp.deleteCharAt(i);
                    i--;
                }
                else
                {
                    act.add(tmp.charAt(i));
                }
            }
        }

        Queue<Character> first = new LinkedList<>();

        if (!act.isEmpty())
        {
            for (char c : act)
            {
                if (!sleep.isEmpty())
                {
                    for (int i = 0; i < sleep.size(); i++)
                    {
                        if (c != sleep.peek())
                        {
                            sleep.poll();
                            sleep.add(c);
                            break;
                        }
                        else
                        {
                            first.add(sleep.poll());
                        }
                    }
                }
            }
        }

        tmp = new StringBuilder();

        for (char c : first)
        {
            tmp.append(c);
        }

        for (char c : sleep)
        {
            tmp.append(c);
        }

        return predictPartyVictory(tmp.toString());
    }

    public static void main(String[] args)
    {
        System.out.println(predictPartyVictory("DRRDRDRDRDDRDRDRD"));
    }
}
