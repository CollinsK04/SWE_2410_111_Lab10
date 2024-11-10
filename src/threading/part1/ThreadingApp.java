package threading.part4.src.threading.part1;

import java.util.ArrayList;
import java.util.List;

public class ThreadingApp {
    private List<Integer> theList;
    private final int COUNT = 10000;

    public ThreadingApp(){
        theList = new ArrayList<>();
        Thread thread = new Thread(() -> addElement(COUNT));
        thread.start();
        addElement(COUNT);
        try {
            thread.join();
            System.out.println(theList.size());
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
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
