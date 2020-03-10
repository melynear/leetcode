package cn.lizhi.algorithm;

import java.util.Arrays;

/**
 * 实现一个栈结构
 *
 * @author 种花家的兔子
 * @version v1.0
 * @date 2019年11月12日
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        stack.pop();
        System.out.println(stack.getMin());
    }
    
    /**
     * 初始容量
     */
    private static final int DEFAULT_CAPACITY = 100;
    
    /**
     * 数组实现栈
     */
    private int[] arr;
    
    /**
     * 最小值栈
     */
    private int[] minArr;
    
    /**
     * 栈的大小
     */
    private int currentSize = 0;
    
    /**
     * 最小值栈的大小
     */
    private int minCurrentSize = 0;
    
    public MinStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public MinStack(int capacity) {
        arr = new int[capacity];
        minArr = new int[capacity];
    }
    
    /**
     * 入栈
     *
     * @param x
     */
    public void push(int x) {
        if (currentSize == arr.length) {
            enlargeArr();
        }
        
        arr[currentSize++] = x;
        
        if (minCurrentSize == 0) {
            minArr[minCurrentSize++] = x;
        } else if (x <= minArr[minCurrentSize - 1]) {
            minArr[minCurrentSize++] = x;
        }
    }
    
    /**
     * 出栈
     */
    public void pop() {
        if (currentSize == 0) {
            return;
        }
        
        int temp = arr[currentSize - 1];
        arr[--currentSize] = 0;
        
        if (minArr[minCurrentSize - 1] == temp) {
            minArr[--minCurrentSize] = 0;
        }
        
        if (arr.length > DEFAULT_CAPACITY && currentSize * 2 < arr.length) {
            shrinkArr();
        }
    }
    
    /**
     * 栈顶元素
     *
     * @return
     */
    public int top() {
        return arr[currentSize - 1];
    }
    
    /**
     * 常数时间返回栈中的最小值
     *
     * @return
     */
    public int getMin() {
        return minArr[minCurrentSize - 1];
    }
    
    /**
     * 栈的扩展
     */
    private void enlargeArr() {
        arr = Arrays.copyOf(arr, arr.length * 2);
        minArr = Arrays.copyOf(minArr, minArr.length * 2);
    }
    
    /**
     * 栈的收缩
     */
    private void shrinkArr() {
        arr = Arrays.copyOf(arr, arr.length / 2);
        minArr = Arrays.copyOf(minArr, minArr.length / 2);
    }
}
