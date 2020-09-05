import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] list){
        int current;
        int insertPointer;
        for (int i = 1; i < list.length; i++){
            current = list[i];
            insertPointer = i;
            while (insertPointer > 0 && current < list[insertPointer - 1]){
                list[insertPointer] = list[insertPointer - 1];
                insertPointer--;
            }
            list[insertPointer] = current;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] list = {7, 1, 9, 0, 4, 6, 7, 5, 10};
        System.out.println(Arrays.toString(insertionSort(list)));
    }

}
