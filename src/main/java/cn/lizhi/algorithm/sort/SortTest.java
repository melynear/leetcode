package cn.lizhi.algorithm.sort;

/**
 * @author 种花家的兔子
 * @version v1.0
 * @date 2020年06月01日
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {8, 5, 9, 3, 2, 1, 10, 7};
//        BubbleSort sort1 = new BubbleSort();
//        SelectionSort sort2= new SelectionSort();
//        MergeSort sort = new MergeSort();
        QuickSort sort = new QuickSort();
        int[] sort1 = sort.sort(arr);
        System.out.println(sort1);
    }
}
