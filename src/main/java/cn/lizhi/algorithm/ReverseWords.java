package cn.lizhi.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 题目：反转单词
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月06日
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords1(s));
    }
    
    private static String reverseWords1(String words) {
        String trimWords = words.trim();
        
        String[] singleWords = trimWords.split("\\s+", -1);
        
        if (singleWords.length == 1) {
            return trimWords;
        }
        
        // ArrayList底层是基于数组实现的线性表，此处的操作一直是针对这个数组的，所以反转操作也是针对传入的数组进行的
        Collections.reverse(Arrays.asList(singleWords));
        
        return String.join(" ", singleWords);
    }
    
    public static String reverseWords2(String s) {
        String trimWords = s.trim();
        
        String[] singleWords = trimWords.split("\\s+", -1);
        
        if (singleWords.length == 1) {
            return trimWords;
        }
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = singleWords.length - 1; i >= 0; i--) {
            builder.append(singleWords[i]);
            builder.append(" ");
        }
        
        return builder.toString().trim();
    }
    
    private static String reverseWords3(String words) {
        char[] chars = words.toCharArray();
        
        Stack stack = new Stack();
        
        String word = "";
        
        for (int i = 0; i < chars.length; i++) {
            if (word != "" && chars[i] == ' ') {
                stack.push(word);
                word = "";
            }
            
            if (chars[i] != ' ') {
                word += chars[i];
                if (i == chars.length - 1) {
                    stack.push(word);
                }
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            builder.append(" ");
        }
        
        return builder.toString().trim();
    }
}
