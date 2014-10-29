/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Build min heap
    // Larger or null node goes all the way to the bottom
    private void heapDown(ListNode[] heap, int i, int k){
        // Leaf node: has no children
        if(2 * i > k){
            return;
        }
        // Only has one child
        else if(2 * i == k){
            int index = i - 1;
            int childIndex = k - 1;
            if((heap[childIndex] != null) && (heap[index] == null || heap[index].val > heap[childIndex].val)){
                ListNode temp = heap[index];
                heap[index] = heap[childIndex];
                heap[childIndex] = temp;
            }
            return;
        }
        // Has two children
        else{
            int index = i - 1;
            int leftChildIndex = 2 * i - 1;
            int rightChildIndex = 2 * i;
            
            // Both children are null
            if(heap[leftChildIndex] == null && heap[rightChildIndex] == null){
                return;
            }
            // left child is null
            else if(heap[leftChildIndex] == null){
                if((heap[rightChildIndex] != null) && heap[index] == null || heap[index].val > heap[rightChildIndex].val){
                    ListNode temp = heap[index];
                    heap[index] = heap[rightChildIndex];
                    heap[rightChildIndex] = temp;
                    heapDown(heap, rightChildIndex + 1, k);
                }
            }
            // right child is null
            else if(heap[rightChildIndex] == null){
                if((heap[leftChildIndex] != null) && heap[index] == null || heap[index].val > heap[leftChildIndex].val){
                    ListNode temp = heap[index];
                    heap[index] = heap[leftChildIndex];
                    heap[leftChildIndex] = temp;
                    heapDown(heap, leftChildIndex + 1, k);
                }
            }
            // none of the children is null
            // need to decide which child is going to be swapped with current node
            else{
                
                int smallerChildIndex = (heap[leftChildIndex].val < heap[rightChildIndex].val) ? leftChildIndex : rightChildIndex;
                int largerChildIndex = (smallerChildIndex == leftChildIndex) ? rightChildIndex : leftChildIndex;
                
                // swap with the child w/ smaller val
                if(heap[index] == null || heap[index].val > heap[smallerChildIndex].val){
                    ListNode temp = heap[index];
                    heap[index] = heap[smallerChildIndex];
                    heap[smallerChildIndex] = temp;
                    // Keep going down the heap
                    heapDown(heap, smallerChildIndex + 1, k);
                }
                // swap with the child w/ larger val
                else if(heap[index] == null || heap[index].val > heap[largerChildIndex].val){
                    ListNode temp = heap[index];
                    heap[index] = heap[largerChildIndex];
                    heap[largerChildIndex] = temp;
                    heapDown(heap, largerChildIndex + 1, k);
                }
                // no swap
                else{
                    // Do nothing
                }
            }
        }
        
        return;
    }
    
    
    public ListNode mergeKLists(List<ListNode> lists) {
        
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode prev = fakeHead;
        
        int k = lists.size();
        if(k == 0){
            return null;
        }
        ListNode[] heap = new ListNode[k];
        
        for(int i = 0; i < k; ++i){
            heap[i] = lists.get(i);
        }
        
        // Build a minimum heap
        for(int i = k / 2; i > 0; --i){
            heapDown(heap, i, k);
        }
        
        // O(n * k^2) time
        // O(k) time to find minimal node
        // O(n * k) time to process all nodes
        // This should be reduced
        // It only costs O(klogk) ~ O(k^2) time to sort all first nodes of all lists for one time
        // After that, every time the head of this first-node list is removed
        // A new element (the head node's next node) will be inserted in the list, if it's not null
        // This insertion costs O(logk) time
        // So the time complexity shall be O(n * klogk) + O(k^2) => O(n * klogk)
        // It can be done by using priorityqueue, which is implemented by using minimum heap
        
        ListNode minNode = heap[0];
        
        while(minNode != null){
            // Build new link
            prev.next = minNode;
            // Record previous node
            // That's also why a fakeNode is introduced
            prev = minNode;
            // Update heap[0]
            heap[0] = minNode.next;
            // Maintain minimum heap
            heapDown(heap, 1, k);
            // Acquire minimum value of the heap (the rootNode of heap)
            minNode = heap[0];
        }
        
        return fakeHead.next;
    }
}
