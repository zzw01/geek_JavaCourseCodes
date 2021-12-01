package six;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 方法3：使用CyclicBarrier，等所有的子线程执行后，再去调用别的方法，最后关闭主线程
 */
public class CyclicBarrierMethod {
     static Integer result = null;
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1,()->{
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        });
        CyclicBarrierSum cyclicBarrierSum = new CyclicBarrierSum(cyclicBarrier);
        new Thread(cyclicBarrierSum).start();
    }

    static class CyclicBarrierSum implements Runnable{
        CyclicBarrier cyclicBarrier;

        @Override
        public void run() {
            result = fibo(36);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private static int fibo(int a) {
            if ( a < 2)
                return 1;
            return fibo(a-1) + fibo(a-2);
        }

        CyclicBarrierSum(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        //getter  setter

        public CyclicBarrier getCyclicBarrier() {
            return cyclicBarrier;
        }

        public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

    }
}
