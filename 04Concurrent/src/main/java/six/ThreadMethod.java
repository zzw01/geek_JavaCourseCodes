package six;

/**
 * Thread
 */
public class ThreadMethod {

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        ThreadMethodSum threadMethodSum = new ThreadMethodSum();
        Thread thread = new Thread(() -> threadMethodSum.sum());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步计算结果为："+threadMethodSum.getResult());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }


    static class ThreadMethodSum{
        Integer result;

        synchronized public void sum() {
            result = fibo(36);
        }

        private static int fibo(int a) {
            if ( a < 2)
                return 1;
            return fibo(a-1) + fibo(a-2);
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }
    }

}
