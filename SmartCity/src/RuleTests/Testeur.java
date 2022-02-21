package RuleTests;
import java.time.LocalTime;

public class Testeur {
	public static void main(String[] args) {
		LocalTime t1 = LocalTime.of(10, 7);
		LocalTime t2 = LocalTime.of(10, 17);
		LocalTime tres = t1.minusNanos(t2.toNanoOfDay());
		System.out.println(tres);
	}
}
