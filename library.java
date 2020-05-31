package librarySimulation;
/*
图书馆类
 */
public class library {
    private int bookNum = 1;//图书数量
    private boolean isRun = true;//布尔标记，用于结束线程

    //借书方法
    public synchronized void rentBook(){
        try {
            //当书的库存数量为0时，让借书线程等待
            while (this.bookNum == 0){
                System.out.println("----------------------------------------");
                System.out.println("当前书的库存为0，暂时无书本可以借出");
                this.wait();
            }
            //否则借书
            this.bookNum--;//书的库存数量减1
            //打印结果
            System.out.println("----------------------------------------");
            System.out.println(Thread.currentThread().getName() + "借出了一本书");
            System.out.println("剩余书的库存：" + this.bookNum + "本");
            //唤醒线程
            this.notifyAll();
        }catch (Exception e){
        }
    }

    //还书方法
    public synchronized void returnBook(){
        try {
            //当书的库存数量为3时，停止还书线程
            while (this.bookNum == 3){
                this.isRun = false;
                if (!this.isRun){
                    return;
                }
            }
            //否则还书
            this.bookNum++;//书的数量加1
            //打印结果
            System.out.println("----------------------------------------");
            System.out.println(Thread.currentThread().getName() + "还了一本书");
            System.out.println("剩余书的库存：" + this.bookNum + "本");
            //唤醒线程
            this.notifyAll();
        }catch (Exception e){
        }
    }
}
