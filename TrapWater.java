import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TrapWater {
    int[] height;
    int sum;
    List<Pair> maximas = new ArrayList<>();

    class Pair{
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }



    public int trap(int[] height) {
        this.height = height;
        int leftMax = 0, rightMax = 0, sum = 0, minMax = 0;

        int max = 0;
        while ((max = findNextMaxima(max)) != -1){
            Pair pair = new Pair(height[max], max);
            maximas.add(pair);
            max++;
        }

        maximas.sort(Comparator.comparing(Pair::getValue).reversed());
        fill(0, height.length - 1);

        return sum;
    }


    public void fill(int leftIdx, int rightIdx){
        for (Pair maxima : maximas) {
            if (maxima.index >= leftIdx && maxima.index <= rightIdx){

            }
        }

        int minMax = Math.min(height[leftIdx], height[rightIdx]);
        for (int i = (leftIdx + 1); i < rightIdx; i++){
            if (minMax > height[i])
                sum += minMax - height[i];
        }

    }

    public int findNextMaxima(int p1){
        int prev, current, next;
        for(p1 = p1 ;p1 < height.length; p1++){
            prev = p1 - 1 < 0 ? 0 : height[p1 - 1];
            next = p1 + 1 >= height.length ? 0 : height[p1 + 1];
            current = height[p1];
            if((current > prev && current >= next)){
                while(current == next){
                    p1++;
                    current = height[p1];
                    next = p1 + 1 >= height.length ? 0 : height[p1 + 1];
                }
                return p1;

            }

        }
        return -1;

    }




}