package MBPQ;


public class DesignDSMinHeapMaxHeap {
    public static void main(String[] args) {
         DualHeap dh = new DualHeap();

         dh.insert(10);
         dh.insert(20);
         dh.insert(30);
         dh.insert(40);
         dh.insert(50);
         dh.insert(5);
         dh.insert(6);
         dh.insert(45);
         dh.insert(68);

         dh.removeMax();
         dh.removeMin();
         dh.removeMax();
         dh.removeMax();
         dh.removeMax();

         int max = dh.getmax();
         System.out.println(max);
         dh.insert(46);

         dh.removeMin();
         dh.removeMin();
         dh.removeMin();

         dh.removeMin();

         System.out.println(dh.getmin());


    }
}
