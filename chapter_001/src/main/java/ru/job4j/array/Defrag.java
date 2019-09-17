package ru.job4j.array;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @since 17.09.2019.
 */
class Defrag {
    /**
     * Метод перемещает заполненные ячейки массива в начало, а пустые в конец.
     * @param array - массив.
     * @return - возвращает отсоритрованный массив.
     */
    static String[] compress(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String cell = array[i];
            if (cell == null) {
                int j = i + 1;
                while (j < array.length && array[j] == null) {
                    j++; }
                if (j < array.length) {
                    array[i] = array[j];
                    array[j] = null;
                }
            }
            System.out.print(array[i] + " ");
        }
        return array;
    }
    public static void main(String[]args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (String s : compressed) {
            System.out.print(s + " ");
        }
    }
}