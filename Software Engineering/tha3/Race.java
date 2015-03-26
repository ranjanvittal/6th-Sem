import java.util.concurrent.locks.*;
import java.util.*;
class Race {
	public static void main(String args[]) {
		Gen a = new Gen();
		RaceCondition t1 = new RaceCondition(1, a);
		RaceCondition t2 = new RaceCondition(2, a);
		t1.start();
		t2.start();

		System.out.println(a.b);
	}
}


class Gen {
	public int b;
}
class RaceCondition extends Thread {

	int thread_no;
	Gen a;

	public RaceCondition(int num, Gen a)
	{
		thread_no = num;
		this.a = a;
	}

	public void run()

	{
		if(thread_no == 1)
			a.b = 1;

		if(thread_no == 2)
			a.b = 2;
	}
}
// }

