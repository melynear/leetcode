package cn.lizhi.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 从一个给定的数组中构造出一个最大的整数
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月15日
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.println(largestNumber(nums));
    }
    
    /**
     * 组合排序
     *
     * @param nums
     * @return
     */
    private static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        
        return builder.toString();
    }
}
