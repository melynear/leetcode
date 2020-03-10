package cn.lizhi.algorithm;

/**
 * 从旋转过的升序数组中查找最小值
 * 不存在重复元素
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月11日
 */
public class FindMinFromRotateArray {
    public static void main(String[] args) {
        int[] ascendArr = new int[]{7,1, 5, 6};
//        System.out.println(findMin(ascendArr, 0, ascendArr.length - 1));
        System.out.println(findMin2(ascendArr));
    }
    
    private static int findMin2(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        
        if (arr[arr.length - 1] > arr[0]) {
            return arr[0];
        }
        
        int left = 0;
        int right = arr.length - 1;
        
        while (right - left > 1) {
            int mid = (left + right) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }
            
            if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            
            if (arr[mid] > arr[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return Math.min(arr[left], arr[right]);
    }
    
    private static int findMin(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return Math.min(arr[start], arr[end]);
        }
        
        int mid = (start + end) / 2;
        
        if (arr[mid] > arr[mid + 1]) {
            return arr[mid + 1];
        }
        
        if (arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        
        int leftMid = (start + mid - 1) / 2;
        if (arr[leftMid] > arr[mid - 1]) {
            return findMin(arr, leftMid, mid - 1);
        }
        
        int rightMid = (mid + 1 + end) / 2;
        if (arr[rightMid] < arr[mid + 1]) {
            return findMin(arr, mid + 1, rightMid);
        }
        
        return Math.min(findMin(arr, start, leftMid), findMin(arr, rightMid, end));
    }
}
