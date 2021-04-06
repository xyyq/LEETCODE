import java.util.Map;
import java.util.Scanner;

public  class SolutionBaidu02   {
     static SolutionBaidu02  s=new SolutionBaidu02();
     static SolutionBaidu02 s2=new SolutionBaidu02();
    static boolean flag = true;
    public void m1(){
        while (flag){
            flag = false;
            synchronized(s){
                System.out.println(Thread.currentThread().getName()+"  m1 start");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2){
                    System.out.println("m1 运行s2");
                }
                System.out.println(Thread.currentThread().getName()+"  m1 end");
            }
        }
    }
    public  void m2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!flag){
           flag = true;
            synchronized(s2){
                System.out.println(Thread.currentThread().getName()+"  m2 start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s){
                    System.out.println("m2 运行s");
                }
                System.out.println(Thread.currentThread().getName()+"  m1 end");
            }
        }
    }
    

    public static void main(String[] args) {






        Runnable r =new Runnable() {
            @Override
            public void run() {
                new SolutionBaidu02() .m1();
            }
        };
        new Thread(r,"t1").start();
       /* new Thread(()->{
            s.m1();
        },"t1").start();*/
        new Thread(new SolutionBaidu02()::m2,"t2").start();

    }

}
