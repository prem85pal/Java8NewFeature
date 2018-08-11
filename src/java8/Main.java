package java8;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      /*
        integerList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/



        integerList.forEach((value)->System.out.println(value));

        integerList.forEach(value->System.out.println(value));

        integerList.forEach(System.out::println);

        integerList.forEach(Main::m1);


       /* Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task of Thread-1");
            }
        });

        thread1.start();*/


       /* Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task of Thread-1");
            }
        };*/

/*
        // Lambda Runnable
        Runnable runnable = () -> { System.out.println("Task #2 is running"); };

        // start the thread
        Thread thread = new Thread();
        thread.start();*/

       /* Thread thread = new Thread(() -> {
            System.out.println("I am in Another Thread");
            System.out.println("I am in Another Thread");
            System.out.println("I am in Another Thread");
            System.out.println("I am in Another Thread");
            System.out.println("I am in Another Thread");
        });*/

        /*thread = new Thread(() -> {
            System.out.println("Job of Run Method means Task");
            System.out.println("Job of Run Method means Task");
            System.out.println("Job of Run Method means Task");
            System.out.println("Job of Run Method means Task");
        });*/

       // thread.start();


    }

    public static void m1(Integer integer) {
        System.out.println(integer);
    }
}
