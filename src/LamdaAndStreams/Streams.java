package LamdaAndStreams;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        example9();
    }
    //print all the element of list using stream
    public static void example1(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);

        //step 1 : call stream on list
        // forEach method take a input and return void
        list    .stream()
                .forEach((ele)-> {
                    System.out.println(ele);
                });
    }
    //print the square of all element
    public static void example2(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        list    .stream()
                .forEach((ele)-> {
                    System.out.println(ele*ele);
                });
    }
    //print square of each element without writing squaring logic in forEach method
    //map method take a input and return data
    public static void example3(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        list    .stream()
                .map(ele->ele*ele)      //or we could (ele)-> {return ele*ele} (single return statement)
                .forEach(ele-> {
                    System.out.println(ele);
                });
    }
    // print square of all even number and ignore odd numbers
    //filter takes input and retun boolean , if boolean true data flows ahead else filtered out
    public static void example4(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        list    .stream()
                .filter((ele) ->{
                    if(ele%2==0){
                        return true;
                    }
                    return false;
                })
                .map(ele->ele*ele)
                .forEach(ele-> {
                    System.out.println(ele);
                });
    }
    //return sum of all number in list
    public static void example5(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        int sum = 0;

        list    .stream()
                .forEach((ele)->{
                   // sum = sum+ele;
                    // cannot take outside variable inside lamda and change it
                    System.out.println(sum);

                });
        //so we cant do this
    }
       //reduce method take bunch of data and reduce it to single data
       //like reduce list to int
       //reduce is a terminal method
    public static void example7(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        int a = list    .stream()
                .reduce(0,(sum,ele)->{
                    return sum+ele;
                });
        System.out.println(a);
    }
     //Sort the list
     //Stream does not change original List
     //sorted method sort the stream but return stream back
    ///collect method collec back data and make list of it again
    public static void example8(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        List<Integer> sortedlist =
                list    .stream()
                        .sorted()  //sorted returns stream(not terminal method)
                        .collect(Collectors.toList());
        System.out.println(sortedlist);
    }
    //LAZY EVALUATION --> if we dont use sorted in betweena nd just do for each then stream doesn't
    //                    go through whole list just check first list and then end stream since only first
    //                    element is required, but if used sorted then travel whole list.

    //findfirst is terminal method and it finds first element
    public static void example9(){
        List<Integer> list = List.of(4,1,2,6,8,9,3);
        Optional<Integer> abc =
                list    .stream()
                        .map((ele)->{
                            System.out.println(ele);
                            return ele*ele;
                        })
                        .sorted()
                        .findFirst();
         System.out.println(abc.get());
    }
  //TBR --> there is also something called  "ParallerStream" in which we can do operations on
  //        data concurrently.
}