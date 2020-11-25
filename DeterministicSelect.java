/*
* Deterministic Linear-Time Select
* Input: Unsorted array
* Goal: Output the kth smallest element in array using non-random means.
* */

import java.util.Arrays;

public class DeterministicSelect {


    public int findElement(int[] arr, int k){
        int pivot = findPivot(arr);

        return 0;

    }

    public int findPivot(int[] arr){
        if (arr.length == 1) return arr[0];
        int[] medians = new int[arr.length / 5 + 1];

        int median = 0, right = 0, j = 0;
        for(int i = 0; i < arr.length; i += 5){
            right = Math.min(i + 5, arr.length);
            median = findMedians(arr, i, right);
            medians[j++] = median;
        }


        return findPivot(medians);
    }

    public int findMedians(int[] arr, int left, int right){
        int width = right - left;
        int[] temp;
        temp = Arrays.copyOfRange(arr, left, right);
        Arrays.sort(temp);
        return temp[(width) / 2];
    }


    public static void main(String[] args) {
        int[] test1 = {1, 3, 6, -2, 2, 4, 20, 10, 11, 1, 15, 8, 21, 0, 50, 51};
        DeterministicSelect ds = new DeterministicSelect();

        System.out.println(ds.findElement(test1, 5));


    }
}
