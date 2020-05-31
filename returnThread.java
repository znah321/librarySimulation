package librarySimulation;

public class returnThread implements Runnable{
    private library L;//图书馆对象
    //构造方法
    public returnThread(library L){
        this.L = L;
    }
    @Override
    public void run() {
        //执行10次
        while (true){
            L.returnBook();
        }
    }
}
