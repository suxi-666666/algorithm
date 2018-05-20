package com.algorithm.sort;

import com.algorithm.utils.SortUtils;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Heap {

    private static int heapsize;

    public static void change(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void heapify(int[] ints, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest;
        if (leftChild < heapsize && ints[leftChild] > ints[i]) {
            largest = leftChild;
        } else {
            largest = i;
        }
        if (rightChild < heapsize && ints[rightChild] > ints[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            change(ints, i, largest);
            heapify(ints, largest);
        }
    }

    public static void buildheap(int[] ints, int len) {
        heapsize = len;
        for (int i = heapsize /2 - 1; i >= 0; i --) {
            heapify(ints, i);
        }
    }

    public static void sort(int[] ints, int len) {
        buildheap(ints, len);
        for (int i = len - 1; i >= 1; i--) {
            change(ints, 0, i);
            heapsize--;
            heapify(ints, 0);
        }

        SortUtils.writeTerminalResult("堆", ints);

    }

    public static void sort(int[] ints) {
        buildheap(ints, ints.length);
    }

}
