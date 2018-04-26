/*
 * Wallis Product Test
 *
 * To test the efficiency of the Wallis Product method of estimating pi
 */
package wallisproducttest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * @author sweylo
 */
public class WallisProductTest {
	
	public static void main(String[] args) {
		
		// number of terms of the wallace product to calculate
		BigDecimal n = new BigDecimal("5000000");
		
		// setup precision and rounding mode
		MathContext mc = new MathContext(20, RoundingMode.HALF_UP);
		
		ThreadGroup tg = new ThreadGroup("Wallis Product ThreadGroup");
		ArrayList<Thread> threadList = new ArrayList<>();
		
		BigDecimal product = BigDecimal.ONE;
		
		long initTime = System.nanoTime();
		
		for (BigDecimal i = BigDecimal.ONE; i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
			product = product.multiply(WallisProductTerm.getWallisProductTerm(i, mc), mc);
			//threadList.add(new WallisProductThread(tg, String.format("", args)));
		}
		
		System.out.println("pi ~= " + product.multiply(WallisProductTerm.TWO, mc));
		
		long finalTime = System.nanoTime();
		
		System.out.println((finalTime - initTime) / 1000000.0 + " ms elapsed");
		
	}
	
}
