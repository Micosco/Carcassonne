package com.mcsc.carcassonne.utility;


import java.util.ArrayList;

public class Shifter {
    public static <T> ArrayList<T> shiftArrayRight(ArrayList<T> array, int shiftLength) {
        ArrayList<T> clone = new ArrayList<>(array);
        int lastIndex = array.size() - 1;
        for (int i = 0; i < shiftLength; i++) {
            var last = array.get(lastIndex);
            for (int j = 1; j < array.size(); j++) {
                clone.set(j, array.get(j - 1));
            }
            clone.set(0, last);
        }
        return clone;
    }

    public static boolean[] shiftArrayRight(boolean[] array, int shiftLength){
        boolean[] clone = new boolean[array.length];
        int lastIndex = array.length - 1;
        for (int i = 0; i < shiftLength; i++) {
            var last = clone[lastIndex];
            System.arraycopy(array, 0, clone, 1, array.length - 1);
            clone[0] = last;
        }
        return clone;
    }
}
