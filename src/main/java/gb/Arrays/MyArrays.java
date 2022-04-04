package gb.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyArrays {
    public static void main(String[] args) {

    }

    public int[] task1(int[] input) throws RuntimeException {

        int lastPos = -1;
        for (int i = input.length-1; i>=0; i--) {
            if (input[i]==4) {
                lastPos = i;
                break;
            }
        }

        if (lastPos==-1) throw new RuntimeException("нет четвёрок в массиве");

        int result[] = Arrays.copyOfRange(input,lastPos+1,input.length);

        return result;
    }

    public boolean task2(int[] input) {
        boolean containsOne = false;
        boolean containsFour = false;

        for (int current : input) {
            if (current != 1 && current != 4) return false;

            if (current == 1) {
                containsOne = true;
                continue;
            }

            containsFour = true;
        }

        return  (containsOne && containsFour);
    }
}
