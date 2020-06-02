package cn.lizhi.algorithm.sort;

/**
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年06月01日
 */
public class QuickSort {
    public int[] sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        return quickSort(arr, start, end);
    }
    
    private int[] quickSort(int[] arr, int left, int right) {
        int basic = partition(arr, left, right);
        
        if (left < basic) {
            quickSort(arr, left, basic - 1);
        }
        
        if (basic < right) {
            quickSort(arr, basic + 1, right);
        }
        
        return arr;
    }
    
    private int partition(int[] arr, int left, int right) {
        int basic = right;
        int lp = left;
        int rp = right - 1;
        
        if (lp == rp && arr[lp] < arr[basic]) {
            return basic;
        } else {
            swap(arr, lp, basic);
        }
        
        while (lp < rp) {
            while (lp < rp && arr[lp] < arr[basic]) {
                lp++;
            }
            
            while (lp < rp && arr[rp] > arr[basic]) {
                rp--;
            }
            
            if (lp == rp) {
                if (lp == basic - 1 && arr[lp] < arr[basic]) {
                    return basic;
                } else {
                    swap(arr, lp, basic);
                }
            } else {
                swap(arr, lp, rp);
            }
        }
        
        return lp;
    }
    
    private void swap(int[] arr, int lp, int rp) {
        int temp = arr[lp];
        arr[lp] = arr[rp];
        arr[rp] = temp;
    }
}
