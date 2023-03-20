package com.ljbdu.threaduse;

public class Thread01 {

    public static void main(String[] args) throws InterruptedException {
        //创建一个Cat对象,可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
        //说明:当main线程启动一个子线程Thread-0,主线程不会阻塞 会继续执行
        //这时主线程和子线程是交替执行.... 主线程结束不会造成应用结束

        System.out.println("主线程会继续执行" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 i=" + i);
            Thread.sleep(1000);
        }

    }
}

//1.当前一个类继承了Thread类 该类就可以当做线程使用
//2.我们会重写run方法 写上自己的业务代码
//3.run Thread继承了 Runnable 接口的run方法
class Cat extends Thread {

    /**
     * @Override public void run() {
     * if (target != null) {
     * target.run();
     * }
     * }
     */
    @Override
    public void run() {
        int times = 0;
        while (true) {
            //该线程每隔1秒,在控制台输出"喵喵,我是小猫咪"
            System.out.println("喵喵,我是小猫咪" + (++times) + "线程名称:" + Thread.currentThread().getName());
            //让该线程休眠1秒  ctrl+alt+t 异常快捷键
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80) {
                break;//当times 到80,,退出while 这个线程也就退出了
            }
        }
    }
}
