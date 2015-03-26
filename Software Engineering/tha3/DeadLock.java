import java.util.concurrent.locks.*;
import java.util.*;
class DeadLock {





     Lock m1 = new ReentrantLock();
     Lock m2 = new ReentrantLock();
     Lock m3 = new ReentrantLock();
     int flag1=1,flag2=1,flag3=1;

    class Thread1 extends Thread{

        int thread_no;


        public Thread1(int num){
                    thread_no = num;

        }

        public void run()

        {
            if(thread_no == 1)
            {
                m1.lock();
                flag1=1;
                System.out.println("Thread1 put lock over m1");
                System.out.println("Thread1 waiting over m2");

                while(!(flag1==1 && flag2==1 && flag3==1));
                m2.lock();

                m3.lock();

                m1.unlock();
                m2.unlock();
                m3.unlock();

            }
            if(thread_no == 2)
            {
                m2.lock();
                flag2=1;
                System.out.println("Thread2 put lock over m2");
                System.out.println("Thread2 waiting over m3");
                while(!(flag1==1 && flag2==1 && flag3==1));
                m3.lock();

                m1.lock();

                m2.unlock();
                m3.unlock();
                m1.unlock();

            }

            if(thread_no == 3)
            {
                m3.lock();
                flag3=1;
                System.out.println("Thread3 put lock over m3");
                System.out.println("Thread3 waiting over m1");

                while(!(flag1==1 && flag2==1 && flag3==1));
                m1.lock();

                m2.lock();

                m3.unlock();
                m1.unlock();
                m2.unlock();

            }
        }
    }

        public static void main(String args[])
    {
        // ReentrantLock m1 = new ReentrantLock();
        // ReentrantLock m2 = new ReentrantLock();
        DeadLock dead = new DeadLock();
        //Vector<Integer> a = new Vector<Integer>();
        Thread1 t1 = dead.new Thread1(1);
        Thread1 t2 = dead.new Thread1(2);
        Thread1 t3 = dead.new Thread1(3);
        t1.start();
        t2.start();
        t3.start();
        //System.out.println(a.elementAt(1));
    }


    }
// }

