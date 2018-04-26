/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wallisproducttest;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author sweylo
 */
public class WallisProductTerm implements Runnable {
	
	public static final BigDecimal ONE = BigDecimal.ONE;
	public static final BigDecimal TWO = new BigDecimal("2");
	private static BigDecimal product = ONE;
	
	@Override
	public void run() {
	
		
		
	}
	
	public static BigDecimal getWallisProductTerm(BigDecimal i, MathContext mc) {
		
		BigDecimal fourISquared = i.pow(2, mc).multiply(TWO, mc).multiply(TWO, mc);
		
		return fourISquared.divide(fourISquared.subtract(ONE, mc), mc);
		
	}
	
}
