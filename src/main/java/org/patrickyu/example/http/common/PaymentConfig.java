package org.patrickyu.example.http.common;


public class PaymentConfig {
	private String local_address;
	private String paysbuy_url;
	private String mol_redirect_url;
	private String mol_check_url;
	private String mpay_request_url;

	public String getLocal_address() {
		return local_address;
	}
	public void setLocal_address(String local_address) {
		this.local_address = local_address;
	}
	public String getPaysbuy_url() {
		return paysbuy_url;
	}
	public void setPaysbuy_url(String paysbuy_url) {
		this.paysbuy_url = paysbuy_url;
	}
	public String getMol_redirect_url() {
		return mol_redirect_url;
	}
	public void setMol_redirect_url(String mol_redirect_url) {
		this.mol_redirect_url = mol_redirect_url;
	}
	public String getMol_check_url() {
		return mol_check_url;
	}
	public void setMol_check_url(String mol_check_url) {
		this.mol_check_url = mol_check_url;
	}
	public String getMpay_request_url() {
		return mpay_request_url;
	}
	public void setMpay_request_url(String mpay_request_url) {
		this.mpay_request_url = mpay_request_url;
	}
}
