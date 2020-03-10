package cn.lizhi.algorithm;

/**
 * 二分查找
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年03月02日
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1};
        System.out.println(searchPosition(arr, 0));
    }
    
    private static int searchPosition(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
