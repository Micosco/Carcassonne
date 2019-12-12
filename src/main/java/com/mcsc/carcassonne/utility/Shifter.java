package com.mcsc.carcassonne.utility;


import java.util.ArrayList;
import java.util.Arrays;

public class Shifter {
    public static <T> ArrayList<T> shiftArrayRight(ArrayList<T> array, int shiftLength) {
        int lastIndex = array.size() - 1;
        ArrayList<T> clone = new ArrayList<>(array);
        for (int i = 0; i < shiftLength; i++) {
            clone = new ArrayList<>(array);
            var last = array.get(lastIndex);
            for (int j = 1; j < array.size(); j++) {
                clone.set(j, array.get(j - 1));
            }
            clone.set(0, last);
            array = clone;
        }
        return clone;
    }

    public static boolean[] shiftArrayRight(boolean[] array, int shiftLength) {
        boolean[] clone = Arrays.copyOf(array, array.length);
        int lastIndex = array.length - 1;
        for (int i = 0; i < shiftLength; i++) {
            clone = new boolean[array.length];
            var last = array[lastIndex];
            System.arraycopy(array, 0, clone, 1, array.length - 1);
            clone[0] = last;
            array = clone;
        }
        return clone;
    }
}
