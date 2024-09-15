import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[][] numbers = {
                {5, 1},
                {3, 2},
                {7, 1},
                {5, 2},
                {7, 4},
                {6, 5},
                {6, 4},
                {7, 5},
                {2, 1},
                {5, 3}
        };

        int[] uniqueValues = getUniqueValues(numbers);
        Arrays.sort(uniqueValues);
        int[] counts = countOccurrences(numbers, uniqueValues);

        System.out.print("Счетчики: ");
        for (int count : counts) {
            System.out.print(count + ", ");
        }
        System.out.println();
    }

    public static int[] getUniqueValues(int[][] numbers) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int[] row : numbers) {
            for (int value : row) {
                uniqueSet.add(value);
            }
        }
        int[] uniqueValues = new int[uniqueSet.size()];
        int index = 0;
        for (int value : uniqueSet) {
            uniqueValues[index++] = value;
        }
        return uniqueValues;
    }

    public static int[] countOccurrences(int[][] numbers, int[] uniqueValues) {
        int[] counts = new int[uniqueValues.length];
        for (int[] row : numbers) {
            for (int value : row) {
                for (int i = 0; i < uniqueValues.length; i++) {
                    if (value == uniqueValues[i]) {
                        counts[i]++;
                        break;
                    }
                }
            }
        }
        return counts;
    }
}
