package org.patrickyu.example.http.webserver;

import httl.Engine;

import org.patrickyu.example.http.common.Config;
import org.patrickyu.example.http.common.VerticleRepo;
import org.patrickyu.example.http.dao.BaseDao;
import org.patrickyu.util.ClassContainer;
import org.patrickyu.util.ClassUtils;
import org.patrickyu.vertx.http.HandlerMappingScanner;
import org.patrickyu.vertx.pgmysql.PgMySqlUtils;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Verticle;

import com.jetdrone.vertx.yoke.Yoke;
import com.jetdrone.vertx.yoke.middleware.BodyParser;
import com.jetdrone.vertx.yoke.middleware.Router;

public class WebServer extends Verticle {

	@Override
	public void start() {
		Logger logger = this.container.logger();
		// save Verticle
		VerticleRepo verticleRepo = VerticleRepo.getInstance();
		verticleRepo.setVerticle(this);

		// Read config
		JsonObject json = container.config();
		final Config conf = ClassUtils.jsonObjectToObject(json, Config.class);
		verticleRepo.setConfig(conf);

		// HTTL
		Engine engine = Engine.getEngine(conf.getHttl_config_path());
		verticleRepo.setEngine(engine);

		// Load postgresql
		PgMySqlUtils.getInstance().load(container, vertx, conf.getPg_conf());

		// Dao container
		verticleRepo.setDaoContainer(new ClassContainer<BaseDao>());

		// HTTP
		Yoke app = new Yoke(WebServer.this);
		app.set("x-powered-by", false);

		// START
		Router router = HandlerMappingScanner.scan(conf.getHandler_packages());
		app
//			.use(new ErrorHandler(true))
			.use(new WebErrorHandler())
//			.use(new ResponseTime())
			.use(new BodyParser())
			.use(router).listen(conf.getPort());

		logger.info(String.format("STARTED: localhost:%d", conf.getPort()));
	}

}
