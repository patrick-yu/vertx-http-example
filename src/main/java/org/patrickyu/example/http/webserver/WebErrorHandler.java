package org.patrickyu.example.http.webserver;

import java.util.List;

import org.patrickyu.vertx.handler.ErrorHandler;
import org.vertx.java.core.json.JsonObject;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;

public class WebErrorHandler extends ErrorHandler {

	@Override
	public boolean sendError(YokeRequest request, String mime, int errorCode,
			String errorMessage, List<String> stackTrace) {
		JsonObject json = new JsonObject();
		json.putNumber("code", errorCode);
		json.putString("message", errorMessage);
		request.response().end(json.toString());
		return true;
	}

	@Override
	public String getExceptionMessage(Throwable error) {
		return error.getClass().getCanonicalName() + ":" + error.getMessage();
	}

}
