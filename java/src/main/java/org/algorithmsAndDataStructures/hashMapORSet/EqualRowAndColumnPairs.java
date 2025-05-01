package org.algorithmsAndDataStructures.hashMapORSet;
// https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EqualRowAndColumnPairs
{
    public static int equalPairs(int[][] grid)
    {
        var rows = new HashMap<Integer, List<int[]>>();
        var columns = new HashMap<Integer, List<int[]>>();

        for (int[] row : grid)
        {
            if (rows.containsKey(row[0]))
            {
                rows.get(row[0]).add(row);
            }
            else
            {
                var tmparr = new ArrayList<int[]>();
                tmparr.add(row);

                rows.put(row[0], tmparr);
            }
        }

        for (int i = 0; i < grid.length; i++)
        {
            var tmp = new int[grid.length];

            for (int j = 0; j < grid.length; j++)
            {
                tmp[j] = grid[j][i];
            }

            if (columns.containsKey(grid[0][i]))
            {
                columns.get(grid[0][i]).add(tmp);
            }
            else
            {
                var tmparr = new ArrayList<int[]>();
                tmparr.add(tmp);

                columns.put(grid[0][i], tmparr);
            }
        }

        int count  = 0;

        for (int i : rows.keySet())
        {
            if (columns.containsKey(i))
            {
                boolean check = true;

                var t1 = columns.get(i);
                var t2 = rows.get(i);

                for (int[] arr1 : t1)
                {
                    check = true;

                    for (int[] arr2 : t2)
                    {
                        check = true;

                        for (int j = 0; j < grid.length; j++)
                        {
                            if (arr1[j] != arr2[j])
                            {
                                check = false;
                                break;
                            }
                        }

                        count += check ? 1 : 0;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2}, {2,4,2,2}}));
    }
}
