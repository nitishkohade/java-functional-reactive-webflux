package reactive;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureOperation {

	public static void main(String[] args) throws InterruptedException {
		
		CompletableFuture future1 = CompletableFuture.supplyAsync(() -> {
			sleep(4000); 
			System.out.println("thread1");
			return 4;
		});
		
		CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
			sleep(4000); 
			System.out.println("thread2");
			return 4;
		});
		
		CompletableFuture future3 = CompletableFuture.supplyAsync(() -> {
			sleep(4000); 
			System.out.println("thread3");
			return 4;
		});
		
		System.out.println("hi main thread reached");
		
		Thread.currentThread().join();

	}

	private static void sleep(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
		
}
	
	

