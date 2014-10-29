package org.patrickyu.example.http.common;

import org.patrickyu.vertx.daohandler.BaseDaoHandler;
import org.patrickyu.vertx.pgmysql.handler.PreparedHandler;
import org.vertx.java.core.logging.Logger;

public abstract class MyPreparedHandler extends PreparedHandler {

	public MyPreparedHandler(BaseDaoHandler callbackHandler) {
		super(callbackHandler);
	}

	@Override
	public Logger getLogger() {
		return VerticleRepo.getInstance().getVerticle().getContainer().logger();
	}

}
