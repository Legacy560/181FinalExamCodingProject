package pkgUT;

import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

import app.helper.TheLoan;

public class TestPMT {

	@Test
	public void test() {
		double PMT;
		double r = 0.07 / 12;
		double n = 20 * 12;
		double p = 150000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1162.95;
		
		assertEquals(PMTExpected, PMT, 0.01);
		
		
		
	}
	
	@Test
	
	public void testTotalPayments() {
		double PMT2;
		double r = 7;
		double n = 20;
		double p = 200000;
		double f = 0;
		boolean t = false;
		PMT2 = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		TheLoan loan = new TheLoan(p,r,n,f,t,500);
		
		int tp = loan.totalPaymentCalculation();
		
		//System.out.println(PMT2);
		
		int tpExpected = 145;
		
		assertEquals(tpExpected, tp, 0.01);
		
	}

}

 

