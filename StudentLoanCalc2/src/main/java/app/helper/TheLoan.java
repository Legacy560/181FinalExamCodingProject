package app.helper;

import java.util.LinkedList;
import org.apache.poi.ss.formula.functions.FinanceLib;
 

public class TheLoan { 
	double loanAmount;
	double interestRate;
	double termOfLoan;
	double futureValue;
	boolean interestCalculation;
	double extraPayment;
	
	//LinkedLists store values by ordinal position.
	//private LinkedList<Payment> loanPayments = new LinkedList<Payment>();
//constructor
	public TheLoan(double loanAmount, double interestRate, double termOfLoan, double futureValue,
			boolean interestCalculation, double extraPayment) {
		super();  
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.termOfLoan = termOfLoan;
		this.futureValue = futureValue;
		this.interestCalculation = interestCalculation;
		this.extraPayment = extraPayment;
		
	}
	
	/*
	 *Payment
	 * Present value
	 * Future value
	 * Number Payments
	 * 
	 * Principal = TotalMonthlyPayment(=TotalPay+AdditionalPay) - InterestPayment
	 */
	
	
	
	/*
	 * PMT fxn 
	 * 
	 * r - interest rate
	 * n- number of payments
	 * p-present value(principal)
	 * f - future value (how much money do you still owe on the loan after the loan is done.)
	 * t - how its calculated(beginning or end of period)
	 * 
	 * static method no need to create instance
	 * bring into scope, import the package
	 * 
	 * org.apache.pos.ss
	 * 
	 */
	
	/*
	public double monthlyPayment() {
		
		double paymentAmount = FinanceLib.pmt(interestRate/12,termOfLoan*12,loanAmount,futureValue,interestCalculation);
		
		return paymentAmount;
	}
	
	
	
	public double interestPaymentPerMonth() {
		double interestPerMonth = interestRate/12;
		double interestPaymentPerMonth = interestPerMonth*loanAmount;
	}
	*/
	public int totalPaymentCalculation() {
		
		double monthlyPaymentAmount = FinanceLib.pmt((interestRate/100)/12,termOfLoan*12,loanAmount,futureValue,interestCalculation);
		int paymentCounter = 0;
		double currentAmount = loanAmount;
		do {
			currentAmount = currentAmount -(monthlyPaymentAmount + extraPayment);
			paymentCounter += 1;
		}while(currentAmount > monthlyPaymentAmount);
		
		return paymentCounter;
	}
	
}
	

