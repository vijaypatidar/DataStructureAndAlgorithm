import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h>
 * KMP - Knuth Morris Pratt algorithm
 * </h>
 * <p>
 * In computer science, the Knuth–Morris–Pratt string-searching algorithm
 * searches for occurrences of a "word" W within a main "text string" S by
 * employing the observation that when a mismatch occurs,the word itself
 * embodies sufficient information to determine where the next match could
 * begin, thus bypassing re-examination of previously matched characters.
 * <p>
 * Worst-case space complexity: Θ(m)
 * Worst-case performance: Θ(m) preprocessing + Θ(n) matching
 * Data structure: String
 * Class: String search
 * <p>
 * Source
 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
 **/
public class KMP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        System.out.println("enter text");
        char[] text = scanner.nextLine().toCharArray();

        System.out.println("enter pattern to search");
        char[] pattern = scanner.nextLine().toCharArray();

        int[] partialMatchTable = getPartialMatchTable(pattern);

        System.out.println("partialMatchTable = " + Arrays.toString(partialMatchTable));

        List<Integer> result = kmpSearch(text, pattern, partialMatchTable);
        if (result.size() == 0) {
            System.out.println("pattern not found");
        } else {
            System.out.println("pattern found at " + result.toString());
        }
    }

    private static List<Integer> kmpSearch(char[] text, char[] pattern, int[] partialMatchTable) {
        List<Integer> result = new ArrayList<>();

        int j = 0;
        int k = 0;

        while (j < text.length) {
            if (text[j] == pattern[k]) {
                j++;
                k++;
                if (k == pattern.length) {
                    result.add(j - k);
                    k = partialMatchTable[k];
                }
            } else {
                k = partialMatchTable[k];
                if (k < 0) {
                    j++;
                    k++;
                }
            }
        }
        return result;
    }

    /**
     * <h>
     * Partial match table (also known as "failure function")
     * </h>
     * <p>
     * The goal of the table is to allow the algorithm not to match any character of S more than once.
     * </p>
     *
     * @param pattern pattern that need to be searched in given text
     * @return partialMatchTable
     */
    public static int[] getPartialMatchTable(char[] pattern) {
        int[] partialMatchTable = new int[pattern.length + 1];

        int pos = 1; //the current position we are computing in partialMatchTable
        int cnd = 0; //the zero-based index in pattern of the next character of the current candidate substring

        partialMatchTable[0] = -1;

        while (pos < pattern.length) {
            if (pattern[pos] == pattern[cnd]) {
                partialMatchTable[pos] = partialMatchTable[cnd];
            } else {
                partialMatchTable[pos] = cnd;
                cnd = partialMatchTable[cnd];//to increase performance
                while (cnd >= 0 && pattern[pos] != pattern[cnd]) {
                    cnd = partialMatchTable[cnd];
                }
            }
            pos++;
            cnd++;
        }

        partialMatchTable[pos] = cnd;//only needed when all word occurrences are searched

        return partialMatchTable;
    }

}
