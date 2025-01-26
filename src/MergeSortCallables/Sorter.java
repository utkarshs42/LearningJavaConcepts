package MergeSortCallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> ArrayToSort;
    private ExecutorService eS;

    public Sorter(List<Integer> ArrayToSort, ExecutorService eS) {
        this.ArrayToSort = ArrayToSort;
        this.eS = eS;
    }

    @Override
    public List<Integer> call() throws Exception {
         if(ArrayToSort.size()<=    1) {
             return ArrayToSort;
         }

         int mid = ArrayToSort.size() / 2;

         List<Integer> left = new ArrayList<>();
         for(int i = 0; i < mid; i++) {
             left.add(ArrayToSort.get(i));
         }
         List<Integer> right = new ArrayList<>();
         for(int i = mid; i < ArrayToSort.size(); i++) {
             right.add(ArrayToSort.get(i));
         }

        Sorter leftSorter = new Sorter(left,eS);
        Sorter rightSorter = new Sorter(right,eS);

        Future<List<Integer>> leftFuture = eS.submit(leftSorter);
        Future<List<Integer>> rightFuture = eS.submit(rightSorter);


        int i = 0,j=0;
        List<Integer> sorted = new ArrayList<>();

        List<Integer> leftSorted = leftFuture.get();
        List<Integer> rightSorted = rightFuture.get();

        while(i<leftSorted.size()&&j<rightSorted.size()){
            if(leftSorted.get(i)<rightSorted.get(j)){
                sorted.add(leftSorted.get(i));
                i++;
            }else{
                sorted.add(rightSorted.get(j));
                j++;
            }
        }
        while(i<leftSorted.size()){
            sorted.add(leftSorted.get(i));
            i++;
        }
        while(j<rightSorted.size()){
            sorted.add(rightSorted.get(j));
            j++;
        }

        return sorted;
    }
}
