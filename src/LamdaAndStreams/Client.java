package LamdaAndStreams;

public class Client {
    public static void main(String[] args) {
        SamMath adder = new AddOp();  //Normally we would have done this
        dosomething(1,2,adder);
        //using lamda we can do this, without making "Subractop" class that impleament SAM or functional
        //interface ,we simply have to do this
        //in () take same argument as SAM method take , user arrow sign then write logic inside{}

        SamMath subractor = (a,b) -> {
            return a-b;
        };
        dosomething(1,2,subractor);
        //OR
        //if logic is simple(one line) we can even do

        SamMath multiplyer = (a,b) -> a*b;
        dosomething(1,2,multiplyer);
        // We can even do this
        //since do something take SamMath as 1 argument

        dosomething(10,2,(a,b)-> a/b);

    }



    public static void dosomething(int a,int b,SamMath math){
        System.out.println(math.operation(a,b));
    }

}
