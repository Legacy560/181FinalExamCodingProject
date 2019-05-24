package app.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.apache.poi.ss.formula.functions.*;

 

public class TheLoan { 
	double loanAmount;
	double interestRate;
	double termOfLoan;
	double futureValue;
	boolean interestCalculation;
	double extraPayment;
	
	
	//LinkedLists store values by ordinal position.
	private LinkedList<Payment> loanPayments = new LinkedList<Payment>();
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
		int iPaymentNbr = 0;
		Date dStartDate = null; {
		try {
			dStartDate = new SimpleDateFormat("yyyy-mm-dd").parse("2019-06-01");
		} catch (ParseException e) {
		}
		
		
		
		Payment p = new Payment(++iPaymentNbr,dStartDate,this.loanAmount, this);
		this.loanPayments.add(p);
		
		double currentAmount = loanAmount;
		double monthlyPaymentAmount = FinanceLib.pmt((interestRate/100)/12,termOfLoan*12,loanAmount,futureValue,interestCalculation);
	

	

		int counter = 0;

		do {
			
			this.loanPayments.add(p);
			counter+=1;
			System.out.println(counter);
			
		}while(loanAmount > Math.abs(monthlyPaymentAmount));
		
		}
		
		public double totalPaymentAmount() {
			double total = 0;
			for(Payment i: loanPayments) {
				total += i.getTotalPrincipal() + i.getIPMT();
				
			}
			return total;
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

	public double getLoanAmount() {
		return loanAmount;
	}



	public double getInterestRate() {
		return interestRate;
	}



	public double getTermOfLoan() {
		return termOfLoan;
	}



	public double getFutureValue() {
		return futureValue;
	}



	public boolean isInterestCalculation() {
		return interestCalculation;
	}



	public double getExtraPayment() {
		return extraPayment;
	}


/*
	public double totalPaymentCalculation() {
		//monthlyPayment is supposed to be negative.
		double monthlyPaymentAmount = FinanceLib.pmt((interestRate/100)/12,termOfLoan*12,loanAmount,futureValue,interestCalculation);
		
	
		
		int paymentCounter = 0;
		double currentAmount = loanAmount;
		double totalPayment =0;
		double interestPay = (interestRate/100)*currentAmount;
		
		double totalPrincipal = 0;
		
		double payment = monthlyPaymentAmount - extraPayment;//what is being paid each month
		
		
		do {
			paymentCounter+=1;
			currentAmount += payment;
			totalPayment -= payment;
			totalPrincipal += Finance.ppmt((interestRate/100)/12, paymentCounter, paymentCounter ,currentAmount, 0);
			System.out.println("Current Balance: " + paymentCounter + " " + Math.round(currentAmount/100)*100);
		}while(currentAmount > ((-1)*monthlyPaymentAmount));
		
		System.out.println(Math.round(((-1)*totalPrincipal)/100)*100);
		
		
		if(currentAmount > ((-1)*monthlyPaymentAmount)){
			currentAmount-=currentAmount;
			paymentCounter += 1;
			totalPayment += currentAmount;
		}
		
		return Math.round(totalPayment/100.0)*100.0;
	}
	

	
*/


		}

