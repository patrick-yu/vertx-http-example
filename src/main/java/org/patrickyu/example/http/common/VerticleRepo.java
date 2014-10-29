package org.patrickyu.example.http.common;

import httl.Engine;

import org.patrickyu.example.http.dao.BaseDao;
import org.patrickyu.util.ClassContainer;
import org.patrickyu.util.Messages;
import org.vertx.java.platform.Verticle;

public class VerticleRepo {
	private Verticle verticle;
	private Config config;
	private Messages messages;
	private ClassContainer<BaseDao> daoContainer;
	private Engine engine;

	private VerticleRepo() {

	}
	private static class LazyHolder {
		private static final VerticleRepo INSTANCE = new VerticleRepo();
	}

	public static VerticleRepo getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void setVerticle(Verticle verticle) {
		this.verticle = verticle;
	}

	public Verticle getVerticle() {
		return this.verticle;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public ClassContainer<BaseDao> getDaoContainer() {
		return daoContainer;
	}

	public void setDaoContainer(ClassContainer<BaseDao> daoContainer) {
		this.daoContainer = daoContainer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
