package org.algorithmsAndDataStructures.arrayOrString;
// https://leetcode.com/problems/summary-ranges/description/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        var result = new ArrayList<String>();
        int last = -1;

        var n = new int[2];
        for (int l = 0; l < nums.length - 1; l++) {
            int r = l + 1;
            n[0] = nums[l];

            while (r < nums.length && l < nums.length && nums[l] == nums[r] - 1) {
                r++;
                l++;
            }

            last = r - 1;
            n[1] = nums[r - 1];
            insert(result, n);
            n = new int[2];
        }

        if (last != nums.length - 1) {
            insert(result, new int[]{nums[last + 1], nums[last + 1]});
        }

        return result;
    }

    public void insert(List<String> res, int[] n) {
        if (n.length == 2) {
            if (n[0] == n[1]) {
                res.add(n[0] + "");
            } else {
                res.add(n[0] + "->" + n[1]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
