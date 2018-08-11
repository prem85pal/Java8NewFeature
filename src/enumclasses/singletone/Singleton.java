package enumclasses.singletone;


/*public class Singleton {

    private volatile Singleton instance;

    private Singleton() {
    }

    public Singleton getInstance() {

        if (instance == null) {

            synchronized (Singleton.class) {

                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}*/

public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        return INSTANCE;
    }


    //readResolve to prevent another instance of Singleton
    private Object readResolve(){
        return INSTANCE;
    }

}





