package app.helper;

import java.util.Date;

import org.apache.poi.ss.formula.functions.Finance;

public class Payment{

	private int PaymentID; //counter for # payments
	
	private double IPMT; // IPMT for
	
	private double PPMT; //PPMT for a payment
	
	private double totalPrincipal;
	
	private double balance;
	
	private Date DueDate;
	
	private TheLoan L;
	

	public Payment(int paymentID, Date dueDate, double balance, TheLoan l) {
		super();
		PaymentID = paymentID;
		this.DueDate = dueDate;
		this.L = l;
		

		PPMT = Math.abs(this.getPPMT()); //principal payment
		IPMT = balance * ((this.L.getInterestRate()/100) / 12); //interest payment
		
		
		
		this.totalPrincipal = PPMT + this.L.getExtraPayment();
		
		this.balance = balance - this.totalPrincipal;
	}
	
	public double getPPMT()
	{
		return Finance.ppmt((this.L.getInterestRate()/100)/12, this.PaymentID, (int) (this.L.getTermOfLoan()*12), this.L.loanAmount);
		
	}

	public double getIPMT() {
		return  balance * ((this.L.getInterestRate()/100) / 12);
	}

	public double getTotalPrincipal() {
		return PPMT + this.L.getExtraPayment();
	}
}








