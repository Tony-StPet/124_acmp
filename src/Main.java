import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Получаем ввод от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите  M тоннелей : ");
        int M = scanner.nextInt();
        System.out.print("Введите  N перекрестков: ");
        int N = scanner.nextInt();

        // Создаем массивы
        int[][] numbers = new int[2][M];
        int[] counts = new int[N];

        // Заполняем массивы данными
        System.out.println("Заполните массив:: перекрестки i и j соединены тоннелем");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("numbers[%d][%d] = ", i, j);
                numbers[i][j] = scanner.nextInt();
            }
        };


        int[] uniqueValues = getUniqueValues(numbers);
        Arrays.sort(uniqueValues);
        counts = countOccurrences(numbers, uniqueValues);

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

/*1. Получение ввода от пользователя:
     - Программа запрашивает у пользователя значения для M (количество тоннелей) и N (количество перекрестков).

  2. Создание и заполнение массивов:
     - Создается двумерный массив numbers размером 2 на M для хранения пар перекрестков, связанных тоннелями.
     - Массив counts размером N будет хранить количество светофоров на каждом перекрестке.
     - Пользователь заполняет массив numbers парами перекрестков, соединенных тоннелями.

3. Обработка данных:
      - Вызывается метод getUniqueValues, который находит уникальные значения (перекрестки) из массива numbers 
        и возвращает их в виде одномерного массива uniqueValues.
      - Массив uniqueValues сортируется с помощью Arrays.sort.
      - Вызывается метод countOccurrences, который подсчитывает, сколько раз каждый уникальный перекресток 
        встречается в массиве numbers. Результат сохраняется в массиве counts.

4. Вывод результатов:
      - Программа выводит значения из массива counts, представляющие количество светофоров на каждом перекрестке.
*/
