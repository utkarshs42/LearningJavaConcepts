package MergeSortCallables;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
          List<Integer> list = List.of(10,8,7,2,3,5,1,6,9,4);
        ExecutorService ex = Executors.newCachedThreadPool();
          Sorter sorter = new Sorter(list,ex);

        Future<List<Integer>> ff =ex.submit(sorter);
        System.out.println(ff.get());
    }
}
