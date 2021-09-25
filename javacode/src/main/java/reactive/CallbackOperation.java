package reactive;

import java.util.function.Consumer;

public class CallbackOperation {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Main thread is running");
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				new CallbackOperation().runningAsync(System.out::println);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		Thread.sleep(2000);
		System.out.println("Main thread completed");
	}
	
	public void runningAsync(Consumer<String> call) {
		System.out.println("I am running a separate thread");
		sleep(1000);
		call.accept("callback called");
	}
	
	public void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
