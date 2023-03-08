package priv.pront.code.leetcode.heap;

import priv.pront.code.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-08 17:52
 */
public class L230_KthSmallest {

    int target = -1;
    int count;
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        getArr(root);
        int[] heap = new int[k];

        for (int i = 0; i < k; i++) {
            heap[i] = list.get(i);
            heapInsert(heap, i);
        }
        for (int i = k; i < list.size(); i++) {
            if (heap[0] > list.get(i)) {
                heap[0] = list.get(i);
                heapify(heap, 0, k);
            }
        }
        return heap[0];
    }

    //  构建大根堆,向上的调整过程
    public void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            swapList(list, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 构建大根堆，向下的调整过程
    public void heapify(int[] heap, int index, int heapSize) {
        int leftSon = index * 2 + 1;
        while (leftSon < heapSize) {
            int largest = leftSon + 1 < heapSize && heap[leftSon + 1] < heap[leftSon] ? leftSon + 1 : leftSon;
            if (largest == index) {
                break;
            }
            swapArr(heap, largest, index);
            index = largest;
            leftSon = index * 2 + 1;
        }
    }

    public void swapList(List<Integer> list, int a, int b) {
        list.set(a, list.get(b));
        list.set(b, list.get(a));
    }

    public void swapArr(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public void getArr(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        getArr(curNode.left);
        list.add(curNode.val);
        getArr(curNode.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        InT(root);
        return target;
    }

    public void InT(TreeNode root) {
        if (root == null) {
            return;
        }
        InT(root.left);
        if (--count == 0) {
            target = root.val;
            return;
        }
        InT(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(new L230_KthSmallest().kthSmallest(root, 3));


    }
}
