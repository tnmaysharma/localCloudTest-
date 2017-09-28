package com.rabbitmq.publisher.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String policyName;
	
	private String policyDetails;
	
	private String premiumAmount;
	
	private String maturityPeriod;
	
	private String policyPlan;

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getMaturityPeriod() {
		return maturityPeriod;
	}

	

	public void setMaturityPeriod(String maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public String getPolicyPlan() {
		return policyPlan;
	}

	public void setPolicyPlan(String policyPlan) {
		this.policyPlan = policyPlan;
	}

	public String getPolicyName() {
		return policyName;
	}

	
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(String policyDetails) {
		this.policyDetails = policyDetails;
	}
	
	
	public SystemPolicy() {
		super();
	}

	public SystemPolicy(Long id, String policyName, String policyDetails, String premiumAmount, String maturityPeriod,
			String policyPlan) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.policyDetails = policyDetails;
		this.premiumAmount = premiumAmount;
		this.maturityPeriod = maturityPeriod;
		this.policyPlan = policyPlan;
	}
	
	

	public SystemPolicy(String policyName, String policyDetails, String premiumAmount, String maturityPeriod,
			String policyPlan) {
		super();
		this.policyName = policyName;
		this.policyDetails = policyDetails;
		this.premiumAmount = premiumAmount;
		this.maturityPeriod = maturityPeriod;
		this.policyPlan = policyPlan;
	}

	@Override
	public String toString() {
		return "SystemPolicy [id=" + id + ", policyName=" + policyName + ", policyDetails=" + policyDetails
				+ ", premiumAmount=" + premiumAmount + ", maturityPeriod=" + maturityPeriod + ", policyPlan="
				+ policyPlan + "]";
	}
	
	
}
