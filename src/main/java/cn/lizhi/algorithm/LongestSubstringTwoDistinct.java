package cn.lizhi.algorithm;

import java.util.Collections;
import java.util.HashMap;

/**
 * 给定一个字符串s，找出至多包含两个不同字符的最长子串 t
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月13日
 */
public class LongestSubstringTwoDistinct {
    public static void main(String[] args) {
        String s = "bacbbcabcabbcc";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
        System.out.println(lengthOfLongestSubstringTwoDistinct2(s));
        System.out.println(lengthOfLongestSubstringTwoDistinct3(s));
    }
    
    private static int lengthOfLongestSubstringTwoDistinct3(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        
        int char1LastLocation = 0;
        int char2LastLocation = 0;
        
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(char1LastLocation)) {
                char1LastLocation = right;
            } else if (char2LastLocation == 0) {
                char2LastLocation = right;
            } else if (s.charAt(right) == s.charAt(char2LastLocation)) {
                char2LastLocation = right;
            } else {
                left = Math.min(char1LastLocation, char2LastLocation) + 1;
                char1LastLocation = Math.max(char1LastLocation, char2LastLocation);
                char2LastLocation = right;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            
            right++;
        }
        
        return maxLength;
    }
    
    /**
     * 滑动窗口--相当于队列，窗口左边先进先出，窗口右边不停的加元素
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstringTwoDistinct2(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            map.put(s.charAt(right), right);
            
            if (map.size() == 3) {
                left = map.remove(s.charAt(Collections.min(map.values()))) + 1;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        
        return maxLength;
    }
    
    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        
        if (chars.length <= 2) {
            return chars.length;
        }
        int maxLength = 0;
        
        for (int i = 0; i < chars.length - 1; i++) {
            char char1 = chars[i];
            char char2 = chars[i] == chars[i + 1] ? ' ' : chars[i + 1];
            int tempLength = 2;
            
            if (i != chars.length - 2) {
                for (int j = i + 2; j < chars.length; j++) {
                    if (char1 != chars[j] && char2 == ' ') {
                        char2 = chars[j];
                        tempLength++;
                    } else if (char1 == chars[j]) {
                        tempLength++;
                        continue;
                    } else if (chars[j] == char2) {
                        tempLength++;
                        continue;
                    } else {
                        break;
                    }
                }
            }
            
            maxLength = Math.max(maxLength, tempLength);
        }
        
        return maxLength;
    }
}
