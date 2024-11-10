package threading.part4.src.threading.part2;

import java.util.LinkedList;
import java.util.List;

public class ThreadingApp {
    private List<Integer> theList;
    private final int COUNT = 10000;

    public ThreadingApp(){
        theList = new LinkedList<>();
        Thread thread = new Thread(() -> addElement(COUNT));
        thread.start();
        addElement(COUNT);
        try {
            thread.join();
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
        System.out.println(theList.size());
        for(int i = 0; i < theList.size();i++){
            System.out.println(theList.get(i));
        }
    }

    public void addElement(int count){
        for(int i = 0; i < count; i++){
            theList.add(i);
        }
    }

    public static void main(String[] args){
        ThreadingApp threadingApp = new ThreadingApp();
        threadingApp.addElement(10000);
    }

}
