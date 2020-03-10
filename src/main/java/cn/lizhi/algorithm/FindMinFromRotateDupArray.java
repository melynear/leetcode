package cn.lizhi.algorithm;

/**
 * 从旋转过的升序数组中查找最小值
 * 存在重复元素
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月11日
 */
public class FindMinFromRotateDupArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 6, 6, 6, 1, 6};
        System.out.println(findMin(arr));
    }
    
    private static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 1;
        
        while (right - left > 1) {
            int mid = (left + right) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}
