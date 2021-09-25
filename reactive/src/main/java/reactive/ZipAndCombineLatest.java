package reactive;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class ZipAndCombineLatest {

	public static void main(String[] args) throws InterruptedException {
		
		Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
		Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);
		
		Observable.zip(src1, src2, (e1, e2) -> e1+e2).subscribe(System.out::println);

		
		Thread.sleep(10000);
	}

}
