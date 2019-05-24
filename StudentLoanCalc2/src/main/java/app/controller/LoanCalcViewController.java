package app.controller;

import app.StudentCalc;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import app.helper.TheLoan;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	@FXML

	private TextField InterestRate;
	
	@FXML
	
	private TextField TermLoan;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
//don't put commas in the loan amount.
		
		
		
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double dTermLoan = Double.parseDouble(TermLoan.getText());
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
			
		TheLoan myLoan = new TheLoan(dLoanAmount,dInterestRate,dTermLoan,0.0,false,dAdditionalPayment);
		
		
		lblTotalPayemnts.setText(Double.toString(myLoan.totalPaymentAmount()));
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
	}
}
