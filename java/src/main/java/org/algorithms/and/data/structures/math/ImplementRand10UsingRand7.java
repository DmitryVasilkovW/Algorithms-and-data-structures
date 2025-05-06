package org.algorithms.and.data.structures.math;
// https://leetcode.com/problems/implement-rand10-using-rand7/description/

import java.util.Random;

public class ImplementRand10UsingRand7 {
    private final Random rand = new Random();

    public int rand10() {
        int result = 40;

        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }

        return result % 10 + 1;
    }

    private int rand7() {
        return rand.nextInt(7) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementRand10UsingRand7().rand10());
    }
}
