import java.util.Arrays;
import java.util.Random;

public class Task20Star {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[100_000];
        int rangeArray = 1_000_000;

        array = createArray(array, random, 1_000_000);

        int[] numbersForSearch = new int[100_000];
        int rangeNumbersForSearch = 2_000_000;

       numbersForSearch = createArray(numbersForSearch, random, 2_000_000);

        array = getSortedArray(array);

        searchForMatchesInArray(array, numbersForSearch);

    }

    public static int[] createArray(int[] array, Random random, int range) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    public static int[] getSortedArray(int[] array) {
        System.out.println("Запущена сортировка: ");

        long before, after;
        int min, indexOfMin, temp;

        before = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            min = array[i];
            indexOfMin = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    indexOfMin = j;
                }
            }

            temp = array[i];
            array[i] = array[indexOfMin];
            array[indexOfMin] = temp;
        }
        after = System.currentTimeMillis();

        System.out.println("Сортировка заняла - " + ((after - before) / 1000.0));

        return array;
    }

    public  static void searchForMatchesInArray(int[] array, int[] numbersForSearch) {
        System.out.println("Запущен поиск...");

        long before, after;
        int count = 0;

        before = System.currentTimeMillis();

        for (int j = 0; j < numbersForSearch.length; j++) {
            int currentNumber = numbersForSearch[j];

            int left = 0;
            int right = array.length - 1;

            int middle = left + (right - left) / 2;

            while (left <= right) {
                if (currentNumber < array[middle]) {
                    right = middle - 1;
                } else if (currentNumber > array[middle]) {
                    left = middle + 1;
                } else {
                    count++;
                    break;
                }

                middle = left + (right - left) / 2;
            }
        }
        System.out.println("Поиск завершен");

        after = System.currentTimeMillis();
        System.out.println("Поиск занял - " + ((after - before) / 1000.0));
        System.out.println("Всего совпадений: " + count);
    }

}
