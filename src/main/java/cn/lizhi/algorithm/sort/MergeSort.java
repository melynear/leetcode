package cn.lizhi.algorithm.sort;

import java.util.Arrays;

/**
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年06月01日
 */
public class MergeSort {
    public int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
        
        return merge(sort(leftArr), sort(rightArr));
    }
    
    private int[] merge(int[] leftArr, int[] rightArr) {
        int[] result = new int[leftArr.length + rightArr.length];
        
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= leftArr.length) {
                result[index] = rightArr[j++];
            } else if (j >= rightArr.length) {
                result[index] = leftArr[i++];
            } else if (leftArr[i] < rightArr[j]) {
                result[index] = leftArr[i++];
            } else {
                result[index] = rightArr[j++];
            }
        }
        
        return result;
    }
}
