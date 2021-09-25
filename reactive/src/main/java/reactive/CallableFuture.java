package reactive;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		Future<Integer> future = service.submit(new CallableFuture.Task());
		
		try {
			
			Integer result = future.get();
			System.out.println("Result from the task is " + result);
			
		} catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			Thread.sleep(4000);
		   return new Random().nextInt();
		}
		
	}
	
}