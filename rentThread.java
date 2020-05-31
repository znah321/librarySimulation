package librarySimulation;

public class rentThread implements Runnable{
    private library L;//图书馆类

    //构造方法
    public rentThread(library L){
        this.L = L;
    }
    @Override
    public void run() {
        //执行10次
        while (true){
            L.rentBook();
        }
    }
}
