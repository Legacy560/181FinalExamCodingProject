package app.helper;

import java.util.LinkedList;
import org.apache.poi.ss.formula.functions.FinanceLib;
 

public class TheLoan { 
	double loanAmount;
	double interestRate;
	double termOfLoan;
	double futureValue;
	boolean interestCalculation;
	double principalPayment;
	
	//LinkedLists store values by ordinal position.
	//private LinkedList<Payment> loanPayments = new LinkedList<Payment>();
//constructor
	public TheLoan(double loanAmount, double interestRate, double termOfLoan, double futureValue,
			boolean interestCalculation, double principalPayment) {
		super();  
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.termOfLoan = termOfLoan;
		this.futureValue = futureValue;
		this.interestCalculation = interestCalculation;
		this.principalPayment = principalPayment;
		
	}
	
	
	
	
	/*
	 * PMT fxn
	 * 
	 * r - rate
	 * n- number of payments
	 * p-present value
	 * f - future value
	 * t - how its calculated(beginning or end of period)
	 * 
	 * static method no need to create instance
	 * bring into scope, import the package
	 * 
	 * org.apache.pos.ss
	 * 
	 */
	
	
}
