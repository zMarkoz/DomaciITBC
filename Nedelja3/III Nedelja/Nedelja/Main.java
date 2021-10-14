package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Integer> prostiBrojevi(List<Integer> arr) {
        System.out.println(arr);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            boolean isPrimitive = true;
            for (int y = current; y > 0; y--) {
                if (y != current & y != 1) {
                    if (current % y == 0) {
                        isPrimitive = false;
                    }
                }
            }
            if (isPrimitive) {
                result.add(current);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);
        arr1.add(7);
        arr1.add(8);
        arr1.add(9);
        arr1.add(10);
        arr1.add(11);


        List<Integer> result = prostiBrojevi(arr1);
        System.out.println(result);


    }


}

