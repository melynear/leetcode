package cn.lizhi.algorithm.dp;

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
     * 我们先定义一个数组dpMax,用dpMax[i]表示以第i个元素的结尾的子序列乘积最大的值
     * 也就是这个数组必须包含第i个元素。
     * <p>
     * 那么dpMax[i]的话有几种取值?
     * <p>
     * 当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
     * 当 nums[i] >= 0 并且dpMax[i-1] <= 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
     * 当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。
     * 所以我们还需要一个数组dpMin来记录以第i个元素结尾的子序列乘积最小的值。
     *      当dpMin[i-1] <= 0，dpMax[i] = dpMin[i-1] * nums[i]
     *      当dpMin[i-1] > 0，dpMax[i] = nums[i]
     * 当然，上边引入了 dpMin 数组，怎么求 dpMin 其实和上边求 dpMax 的过程其实是一样的。
     * <p>
     * 按上边的分析，我们就需要加很多的 if else来判断不同的情况，这里可以用个技巧。
     * <p>
     * 我们注意到上边dpMax[i] 的取值无非就是三种，dpMax[i-1] * nums[i]、dpMin[i-1] * nums[i] 以及 nums[i]。
     * <p>
     * 所以我们更新的时候，无需去区分当前是哪种情况，只需要从三个取值中选一个最大的即可。
     * <p>
     * dpMax[i] = max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
     * 求 dpMin[i] 同理。
     * <p>
     * dpMin[i] = min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i]);
     *
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
