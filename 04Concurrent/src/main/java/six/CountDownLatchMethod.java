package six;

import java.util.concurrent.CountDownLatch;

/**
 * 方法2：使用CountDownLatch
 */
public class CountDownLatchMethod {
    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        //创建CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchSum countDownLatchSum = new CountDownLatchSum(countDownLatch);
        new Thread(countDownLatchSum).start();
        //注意这里使用的是await，并不是wait
        countDownLatch.await();
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+countDownLatchSum.getResult());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
    }


    static class CountDownLatchSum implements Runnable{
        private CountDownLatch countDownLatch;
        private Integer result;

        public int fibo(int a) {
            if ( a < 2)
                return 1;
            return fibo(a-1) + fibo(a-2);
        }

        public CountDownLatchSum(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public CountDownLatch getCountDownLatch() {
            return countDownLatch;
        }

        @Override
        public void run() {
            result = fibo(36);
            countDownLatch.countDown();
        }
    }
}
