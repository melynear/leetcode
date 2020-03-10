package cn.lizhi.algorithm;

/**
 * 查找第一个bad version
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年03月02日
 */
public class BinarySearchBadVersion {
    /**
     * 使用二分查找解决
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // (left + right) / 2会出现溢出的情况
            int mid = left + (right - left) / 2;
            
            // 如果mid是bad version，则mid以后的版本不可能是first bad version，所以将搜索范围变成[left, mid]
            if (isBadVersion(mid)) {
                right = mid;
            }
            // 如果mid不是bad version，则mid之前，包括本身的版本都不可能是first bad version，所以将搜索范围变成[mid + 1, right]
            else {
                left = mid + 1;
            }
        }
        
        // 当循环结束时，即left = right时，left所指向的版本就是first bad version
        return left;
    }
    
    private boolean isBadVersion(int version) {
        return true;
    }
}
