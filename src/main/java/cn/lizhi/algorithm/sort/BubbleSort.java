package cn.lizhi.algorithm.sort;

/**
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年06月01日
 */
public class BubbleSort {
    public int[] sort(int[] arr) {
        int length = arr.length;
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        return arr;
    }
}
