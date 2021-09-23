import java.util.*;

class TakeSkip {
    public static void main(String[] args) {
        int[] intArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString(takeSkip(intArray, 2, 2)));
    }


    public static int[] takeSkip(int[] array, int take, int skip) {
        int[] out = new int[outLength(array, take, skip)];
        int j = 0;
        int i = 0;
        Boolean boolTake = true;
        while (i < array.length) {
            int count = 0;
            if (boolTake) {
                while (count < take) {
                    out[j] = array[i];
                    j++;
                    i++;
                    count++;
                }
                boolTake = false;
            }
            else {
                i += skip;
                boolTake = true;
            }
        }
        return out;
    }
    
    private static int outLength(int[] array, int take, int skip) {
        int remainder = array.length % (take + skip);
        int len = array.length / (take + skip);
        int finalLen = take * len + (remainder > take ? take : remainder);
        return finalLen;
    }
}
