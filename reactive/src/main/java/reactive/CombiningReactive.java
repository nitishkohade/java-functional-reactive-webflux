package reactive;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class CombiningReactive {

	public static void main(String[] args) throws InterruptedException {

//		Observable<String> src1 = Observable.just("ella", "alexa", "lily");
//		Observable<String> src2 = Observable.just("priya", "chloe");
		
		Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).take(5).map(e -> "src1:"+e);
		Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src2:"+e);
		
//		Observable<String> src3 = Observable.merge(src1, src2);
		Observable<String> src3 = Observable.concat(src1, src2);
		
//		src3.subscribe(System.out::println);
//		
//		Thread.sleep(10000);
		
		
		
		
		List<String> list = List.of("Hello", "Reactive", "Programming");
		
		Observable.fromIterable(list)
		.flatMap(e -> Observable.fromArray(e.split("")))
		.subscribe(System.out::println);
		
		
		
		
		
		
		
		
		
	}

}
