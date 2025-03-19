package MBPQ;

import java.util.HashMap;
import java.util.PriorityQueue;

public class DualHeap {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private HashMap<Integer,Integer> countmap;

    public DualHeap() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,d)->d-a);
        countmap = new HashMap<>();
    }
    public void insert(int value) {
        minHeap.add(value);
        maxHeap.add(value);
        countmap.put(value,countmap.getOrDefault(value,0)+1);
    }
    public int getmin(){
        cleanup(minHeap);
        return minHeap.peek();
    }
    public int getmax(){
        cleanup(maxHeap);
        return maxHeap.peek();
    }
    public int removeMin(){
         cleanup(minHeap);
         int min = minHeap.poll();
         updatecount(min);
         return min;
    }
    public int removeMax(){
         cleanup(maxHeap);
         int max = maxHeap.poll();
         updatecount(max);
         return max;
    }
    //ensure removed the element from otherHeap
    public void cleanup(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()&& countmap.getOrDefault(heap.peek(),0)==0){
            heap.poll();
        }
    }
    public void updatecount(int value){
        countmap.put(value,countmap.get(value)-1);
    }

}
