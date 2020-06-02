package cn.lizhi.algorithm.sort;

/**
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年06月01日
 */
public class SelectionSort {
    public int[] sort(int[] arr) {
        int length = arr.length;
        int minIndex;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
        return arr;
    }
}
