package org.patrickyu.example.http.reqhandler;

import org.patrickyu.example.http.common.Constants;
import org.patrickyu.example.http.common.Utils;
import org.patrickyu.example.http.common.VerticleRepo;
import org.patrickyu.example.http.dao.MasterDao;
import org.patrickyu.example.http.domain.Game;
import org.patrickyu.example.http.webserver.RequestHandler;
import org.patrickyu.util.ClassUtils;
import org.patrickyu.util.StringUtils;
import org.patrickyu.vertx.daohandler.ObjectDaoHandler;
import org.patrickyu.vertx.http.HttpUtils;
import org.patrickyu.vertx.http.RequestHandlerMapping;
import org.patrickyu.vertx.http.RequestMethod;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonObject;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;

@RequestHandlerMapping(value="/games/:gameId", method={RequestMethod.GET})
public class GameHandler extends RequestHandler {

	@Override
	public void start(final YokeRequest request, Handler<Object> next) {
		String gameId = HttpUtils.getParamString(request, "gameId");
		if (StringUtils.isEmpty(gameId)) {
			//TODO 다국어
			Utils.sendError(request, Constants.status.INVALID_REQUEST, "Game ID를 입력하세요.");
			return;
		}
		VerticleRepo vr = VerticleRepo.getInstance();
		MasterDao dao = vr.getDaoContainer().load(MasterDao.class);
		dao.getGame(gameId, new ObjectDaoHandler<Game>(next) {
			@Override
			public void onSuccess(Game result) {
				JsonObject json = ClassUtils.objectToJsonObject(result);
				request.response().end(json.toString());
			}
		});
	}

}
