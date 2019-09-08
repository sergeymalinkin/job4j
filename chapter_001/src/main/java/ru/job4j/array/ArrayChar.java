package ru.job4j.array;

/**
 * Обертка над строкой.
 */
class ArrayChar {

    /**
     * Проверяет, что слово начинается с префикса.
     * @param word слово.
     * @param prefix префикс.
     * @return result если слово начинается с префикса.
     */
    boolean startsWith(String word, String prefix) {
        boolean result = true;
        char[] pref = prefix.toCharArray();
        char[] wrd = word.toCharArray();

        for (int i = 0; i < pref.length; i++) {

            if (pref[i] != wrd[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

