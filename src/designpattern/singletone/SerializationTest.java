package designpattern.singletone;


import java.io.*;

public class SerializationTest {

    public static void main(String[] args) throws Exception {

        Singleton instanceOne = Singleton.getInstance();
        instanceOne.setValue(10);

        FileOutputStream fos = new FileOutputStream("filename.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(instanceOne);
        out.close();

        instanceOne.setValue(20);

        FileInputStream fis = new FileInputStream("filename.txt");
        ObjectInputStream in = new ObjectInputStream(fis);
        Singleton instanceTwo = (Singleton) in.readObject();
        in.close();

        System.out.println(instanceOne.hashCode() + " : Instance1 Value= " + instanceOne.getValue());
        System.out.println(instanceOne.hashCode() + " : Instance2 Value= " + instanceTwo.getValue());
    }
}

//
