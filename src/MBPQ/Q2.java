package MBPQ;

import java.util.PriorityQueue;

public class Q2 {
    public static int
    minimizeSum(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((c,d)->d-c);
        int sum = 0;//make sure data doesnt overflow
        if(arr.length < k) return -1;
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            sum+=arr[i];
        }
        for(int i =0;i<k;i++){
            int max = pq.poll();
            int newn = max/2;
            sum -= max;
            sum += newn;
            pq.add(newn);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90};
        int k = minimizeSum(arr,5);
        System.out.println(k);
    }
}
