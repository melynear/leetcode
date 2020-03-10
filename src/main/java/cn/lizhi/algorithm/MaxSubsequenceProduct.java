package cn.lizhi.algorithm;

/**
 * 最大子列积
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月07日
 */
public class MaxSubsequenceProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, -7, 0, 8, -5};
        System.out.println(maxProduct1(nums));
        System.out.println(maxProduct2(nums));
        System.out.println(maxProduct3(nums));
    }
    
    /**
     * 动态规划
     * 求解n个数的子序列乘积最大值，可以分解为小问题求解，即可以通过小问题的求解递推到大问题的求解
     * 我们从n=1的情况分析，此时最大乘积就是arr[0],
     * n=2,最大乘积就是maxProduct=max{arr[0],arr[0]*arr[1],arr[1]}，同时记录包含arr[1]该点的子序列的最大值max和最小值min
     * n=3,由于乘法的特殊性，负负可以得正，因此我们需要计算max=max{max*arr[2],min*arr[2],arr[2]},
     *                                                 min=min{max*arr[2],min*arr[2],arr[2]}
     *                                  同时更新最大乘积maxPrdouct=max{maxProduct,max}
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    private static int maxProduct3(int[] nums) {
        int maxProduct = nums[0];
        int max = nums[0];
        int min = nums[0];
    
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            int tempMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
    
            max = tempMax;
            min = tempMin;
            
            maxProduct = Math.max(maxProduct, max);
        }
        
        return maxProduct;
    }
    
    /**
     * 暴力求解，算出所有的子序列积
     * 时间复杂度：O(n2)
     *
     * @param nums
     * @return
     */
    private static int maxProduct1(int[] nums) {
        int maxProduct = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int thisProduct = 1;
            for (int j = i; j < nums.length; j++) {
                thisProduct *= nums[j];
                if (thisProduct > maxProduct) {
                    maxProduct = thisProduct;
                }
            }
        }
        return maxProduct;
    }
    
    /**
     * 分而治之
     * 时间复杂度：O(nlogn)
     *
     * @param nums
     * @return
     */
    private static int maxProduct2(int[] nums) {
        return divideAndRule(nums, 0, nums.length - 1);
    }
    
    private static int divideAndRule(int[] nums, int fromIndex, int toIndex) {
        if (toIndex - fromIndex == 0) {
            return nums[fromIndex];
        }
        
        int mid = (fromIndex + toIndex) / 2;
        
        int leftMax = divideAndRule(nums, fromIndex, mid);
        int rightMax = divideAndRule(nums, mid + 1, toIndex);
        
        int leftNegativeMax = nums[mid];
        int leftPositiveMax = nums[mid];
        int leftCoutinuousProduct = nums[mid];
        
        for (int i = mid - 1; i >= fromIndex; i--) {
            if (nums[mid] == 0) {
                break;
            }
            
            if (nums[i] == 0) {
                break;
            }
            
            if ((leftCoutinuousProduct *= nums[i]) > 0) {
                leftPositiveMax = leftCoutinuousProduct;
            } else {
                leftNegativeMax = leftCoutinuousProduct;
            }
        }
        
        int rightNegativeMax = nums[mid + 1];
        int rightPositiveMax = nums[mid + 1];
        int rightCoutinuousProduct = nums[mid + 1];
        
        for (int i = mid + 2; i <= toIndex; i++) {
            if (nums[mid + 1] == 0) {
                break;
            }
            
            if (nums[i] == 0) {
                break;
            }
            
            if ((rightCoutinuousProduct *= nums[i]) > 0) {
                rightPositiveMax = rightCoutinuousProduct;
            } else {
                rightNegativeMax = rightCoutinuousProduct;
            }
        }
        
        return Math.max(Math.max(Math.max(leftNegativeMax * rightNegativeMax, leftPositiveMax * rightPositiveMax), leftMax), rightMax);
    }
}
