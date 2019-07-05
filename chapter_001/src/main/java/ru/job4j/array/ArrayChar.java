package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {

    /**
     * Проверяет, что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();

        for (int i = 0; i != pref.length - 1; i++) {

            char first = pref [i + 1];
            char second = wrd [i + 1];

            if (first != second) {
                result = false;
                break;
            }
        }
        return result;
    }
}

