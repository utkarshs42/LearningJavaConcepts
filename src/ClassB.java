public class ClassB extends ClassA{
    String name;

    public ClassB(String name){
        super(25);
        this.name = name;
    }

    public void makesound(){
        System.out.println("I'm ClassB");
    }
}
