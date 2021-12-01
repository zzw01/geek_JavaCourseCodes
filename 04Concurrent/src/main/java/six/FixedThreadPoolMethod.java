package six;

import java.util.concurrent.*;

/**
 * 方法1：使用固定大小的线程池，task使用Callable，通过调用get方法获取执行结果
 */
public class FixedThreadPoolMethod {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Integer result = null;

        // 在这里创建一个线程池，
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //异步执行 获取结果
        try {
            result = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return sum();
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");



    }


    private static String lock = "lock";
    private static int sum() {
        return fibo(36);
    }


    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
