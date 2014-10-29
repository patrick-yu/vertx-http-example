package org.patrickyu.example.http.webserver;

import org.patrickyu.example.http.common.VerticleRepo;
import org.patrickyu.util.StringUtils;
import org.patrickyu.vertx.http.BaseRequestHandler;
import org.vertx.java.core.Handler;
import org.vertx.java.core.logging.Logger;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;

public abstract class RequestHandler extends BaseRequestHandler {
	protected Logger logger = null;

	@Override
	public void run(YokeRequest request, Handler<Object> next) {
		if (logger == null) {
			logger = VerticleRepo.getInstance().getVerticle().getContainer().logger();
		}
		String remoteIp = request.getHeader("X-Real-Ip");
		if(StringUtils.isEmpty(remoteIp)) {
			remoteIp = request.getHeader("X-Forwarded-For");
			if (StringUtils.isEmpty(remoteIp))
				remoteIp = request.remoteAddress().toString();
		}

		logger.info(request.path() + ":" + remoteIp);
		request.response().setContentType("application/json", "UTF-8");
		start(request, next);
	}
	public abstract void start(YokeRequest request, Handler<Object> next);
}
