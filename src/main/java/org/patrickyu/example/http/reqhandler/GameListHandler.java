package org.patrickyu.example.http.reqhandler;

import java.util.List;

import org.patrickyu.example.http.common.VerticleRepo;
import org.patrickyu.example.http.dao.MasterDao;
import org.patrickyu.example.http.domain.Game;
import org.patrickyu.example.http.webserver.RequestHandler;
import org.patrickyu.util.ClassUtils;
import org.patrickyu.vertx.daohandler.ListDaoHandler;
import org.patrickyu.vertx.http.RequestHandlerMapping;
import org.patrickyu.vertx.http.RequestMethod;
import org.vertx.java.core.Handler;
import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonObject;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;

@RequestHandlerMapping(value="/games", method={RequestMethod.GET})
public class GameListHandler extends RequestHandler {

	@Override
	public void start(final YokeRequest request, Handler<Object> next) {

		VerticleRepo vr = VerticleRepo.getInstance();
		MasterDao dao = vr.getDaoContainer().load(MasterDao.class);
		dao.getGameList(new ListDaoHandler<Game>(next) {
			@Override
			public void onSuccess(List<Game> result) {
				JsonArray arr = new JsonArray();
				for (Game game: result) {
					JsonObject json = ClassUtils.objectToJsonObject(game);
					arr.addObject(json);
				}
				JsonObject j = new JsonObject();
				j.putArray("list", arr);
				request.response().end(j.toString());
			}
		});
	}

}
