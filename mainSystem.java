package librarySimulation;

public class mainSystem {
    public static void main(String[] args) {
        library L = new library();

        rentThread rent_thread = new rentThread(L);
        returnThread return_thread = new returnThread(L);

        //创建借书线程
        Thread t1 = new Thread(rent_thread);
        t1.setName("借书线程一");
        Thread t2 = new Thread(rent_thread);
        t2.setName("借书线程二");

        //创建还书线程
        Thread t3 = new Thread(return_thread);
        t3.setName("还书线程一");
        Thread t4 = new Thread(return_thread);
        t4.setName("还书线程二");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
