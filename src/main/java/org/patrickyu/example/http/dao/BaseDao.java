package org.patrickyu.example.http.dao;

import org.patrickyu.example.http.common.VerticleRepo;
import org.patrickyu.vertx.pgmysql.PgMySqlUtils;
import org.vertx.java.core.logging.Logger;

public class BaseDao {

	protected PgMySqlUtils pg = PgMySqlUtils.getInstance();
	protected Logger logger = VerticleRepo.getInstance().getVerticle().getContainer().logger();

}
