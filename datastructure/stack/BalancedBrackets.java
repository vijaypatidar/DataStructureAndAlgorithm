package datastructure.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * <p>
 * Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {)
 * occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are
 * three types of matched pairs of brackets: [], {},and ().
 * <p>
 * A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 * For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 * The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of
 * parentheses encloses a single, unbalanced closing square bracket, ].
 * <p>
 * By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 * <p>
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of brackets is also a
 * matched pair of brackets.
 * <p>
 * Given n strings of brackets, determine whether each sequence of
 * brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 * <p>
 * INPUT:
 * The first line contains a single integer n, the number of strings.
 * Each of the next n lines contains a single string s, a sequence of brackets.
 * <p>
 * CONSTRAINTS:
 * <p>
 * 1<=n<=10^3
 * 1<=|s|<=10^3, where  is the length of the sequence.
 * All chracters in the sequences ? { {, }, (, ), [, ] }.
 * <p>
 * OUTPUT:
 * <p>
 * For each string, return YES or NO.
 * <p>
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/balanced-brackets-3-4fc590c6/description/
 */
public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(
                new BufferedReader(
                        new InputStreamReader(System.in)
                )
        );
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            char[] chars = sc.next().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char ch : chars) {

                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else if (!stack.empty()) {

                    char peek = stack.peek();

                    if (ch == ')' && peek == '(' ||
                            ch == ']' && peek == '[' ||
                            ch == '}' && peek == '{') {
                        stack.pop();
                    } else {
                        break;
                    }

                } else {
                    stack.push(ch);//make stack non empty
                    break;
                }
            }

            sb.append(stack.empty() ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
