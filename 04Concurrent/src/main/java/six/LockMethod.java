package six;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockMethod {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        long start=System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            System.out.println("1111");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.notifyAll();
        });
        o.wait();

        System.out.println("2222");

//        System.out.println("异步计算结果为："+lockMethodSum.getResult());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }

    static class LockMethodSum implements Runnable{
        Integer result;
        Condition condition;
        @Override
        public void run() {
                result = fibo(36);
                condition.signalAll();
        }

        public LockMethodSum(Condition condition) {
            this.condition = condition;
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }



        private static int fibo(int a) {
            if ( a < 2)
                return 1;
            return fibo(a-1) + fibo(a-2);
        }
    }
}
