package org.patrickyu.example.http.common;

import org.patrickyu.vertx.pgmysql.PgMySqlConfig;

public class Config {
	private PgMySqlConfig pg_conf;
	private Integer port;
	private String[] handler_packages;
	private String httl_config_path;
	private PaymentConfig payment_conf;

	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String[] getHandler_packages() {
		return handler_packages;
	}
	public void setHandler_packages(String[] handler_packages) {
		this.handler_packages = handler_packages;
	}
	public PgMySqlConfig getPg_conf() {
		return pg_conf;
	}
	public void setPg_conf(PgMySqlConfig pg_conf) {
		this.pg_conf = pg_conf;
	}
	public String getHttl_config_path() {
		return httl_config_path;
	}
	public void setHttl_config_path(String httl_config_path) {
		this.httl_config_path = httl_config_path;
	}
	public PaymentConfig getPayment_conf() {
		return payment_conf;
	}
	public void setPayment_conf(PaymentConfig payment_conf) {
		this.payment_conf = payment_conf;
	}
}
