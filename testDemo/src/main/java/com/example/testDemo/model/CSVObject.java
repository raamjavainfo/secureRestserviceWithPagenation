package com.example.testDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class CSVObject {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 	
	 	@Column(name = "accountNumber")
	    private String accountNumber;
	    
	 	@Column(name = "trxAmount")
	    private String trxAmount;
	    
	 	@Column(name = "desc")
	    private String desc;
	    
	 	@Column(name = "trxDate")
	    private String trxDate;
	    
	 	@Column(name = "trxTime")
	    private String trxTime;
	    
	 	@Column(name = "customerId")
	    private String customerId;

	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getTrxAmount() {
			return trxAmount;
		}

		public void setTrxAmount(String trxAmount) {
			this.trxAmount = trxAmount;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getTrxDate() {
			return trxDate;
		}

		public void setTrxDate(String trxDate) {
			this.trxDate = trxDate;
		}

		public String getTrxTime() {
			return trxTime;
		}

		public void setTrxTime(String trxTime) {
			this.trxTime = trxTime;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
	    
	    

}
