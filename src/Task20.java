import java.util.Scanner;

public class Task20 {
    /*
            // Предоставить пользователю меню
        // 1. Добавить слово
        // 2. Найти слово
        // 3. Удалить слово
        // 4. Распечатать все слова
        // 5. Выход
     */
    public static void main(String[] args) {
        String[] words = new String[10];
        int count = 0;

        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

        while (isRun) {

            showMenu();

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    String word = scanner.nextLine();
                    count = addWord(words, word, count);
                    break;
                case 2:
                    word = scanner.nextLine();
                    findWord(words, word, count);
                    break;
                case 3:
                    word = scanner.nextLine();
                    count = deleteWord(words, word, count);
                    break;
                case 4:
                    printWords(words, count);
                    break;
                case 5:
                    isRun = false;
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("1. Добавить слово");
        System.out.println("2. Найти слово");
        System.out.println("3. Удалить слово");
        System.out.println("4. Распечатать все слова");
        System.out.println("5. Выход");
    }

    public static int addWord(String[] array, String word, int count) {
        if (array.length == count) {
            System.err.println("Массив переполнен");
            return count;
        }
        array[count] = word;
        count++;
        return count;
    }

    public static void findWord(String[] array, String word, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(word)){
                System.out.println("Слово " + word + " под индексом " + i);
                System.out.println();
            }
        }
    }

    public static int deleteWord(String[] array, String word, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i].equals(word)){
                for (int j = i; j < count - 1; j++) {
                    array[i] = array[j + 1];
                }
                count--;
            }
        }
        return count;
    }

    public static void printWords(String[] array, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}