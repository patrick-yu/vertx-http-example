package org.patrickyu.example.http.common;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.codec.binary.Base64;
import org.patrickyu.util.StringUtils;
import org.vertx.java.core.json.JsonObject;

import com.jetdrone.vertx.yoke.middleware.YokeRequest;


public class Utils {

	public static void sendOk(YokeRequest request) {
		request.response().setStatusCode(200);
		request.response().setContentType("application/json", "utf-8");
		JsonObject json = new JsonObject()
			.putString("status", "ok")
			.putNumber("code", 200)
			.putString("message", "ok");
		request.response().end( json.toString() );
	}

	public static void sendError(YokeRequest request, int status, String message) {
		request.response().setStatusCode(status);
		request.response().setContentType("application/json", "utf-8");
		JsonObject json = new JsonObject()
			.putString("status", "error")
			.putNumber("code", status)
			.putString("message", message);
		request.response().end( json.toString() );
	}

	public static void send(YokeRequest request, JsonObject json) {
		request.response().setStatusCode(200);
		request.response().setContentType("application/json", "utf-8");
		request.response().end( json.toString() );
	}

	public static void sendHtml(YokeRequest request, String html) {
		request.response().setStatusCode(200);
		request.response().setContentType("text/html", "utf-8");
		request.response().end( html );
	}

	public static String toFormatArCode(String arCode) {
		arCode = StringUtils.digitOnly(arCode);
		if (StringUtils.isEmpty(arCode))
			return "";
		return String.format("%s-%s-%s",
				arCode.subSequence(0,3),
				arCode.subSequence(3,6),
				arCode.subSequence(6,9)
				);
	}

	public static boolean isSameDay(long millis1, long millis2) {
		TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
		Calendar c = Calendar.getInstance();
		c.setTimeZone(tz);

		c.setTimeInMillis(millis1);
		int y1 = c.get(Calendar.YEAR);
		int m1 = c.get(Calendar.MONTH);
		int d1 = c.get(Calendar.DAY_OF_MONTH);

		c.setTimeInMillis(millis2);
		int y2 = c.get(Calendar.YEAR);
		int m2 = c.get(Calendar.MONTH);
		int d2 = c.get(Calendar.DAY_OF_MONTH);

		if (y1 == y2 && m1 == m2 && d1 == d2) {
			return true;
		}
		return false;
	}

	public static String encodeItemData(String data) {
		if (StringUtils.isEmpty(data))
			return data;
	    String key="eoqkr^&*qnfaufdmlwjstk!$#";
	    byte[] keyBytes = key.getBytes();
	    byte[] dataBytes = data.getBytes();
	    byte[] result = new byte[dataBytes.length];
	    for(int i = 0; i < dataBytes.length; i++) {
	    	int b = dataBytes[i] & 0xFF;
	    	int idx = (i % keyBytes.length)-1;
	    	if (idx < 0)
	    		idx = keyBytes.length-1;
	        int kb = keyBytes[idx] & 0xFF;
	        byte c = (byte)((b+kb)%256);
	        result[i] = c;
	    }
	    return Base64.encodeBase64String(result);
	}

	public static String decodeItemData(String data) {
		if (StringUtils.isEmpty(data))
			return data;

	    String key="eoqkr^&*qnfaufdmlwjstk!$#";
	    byte[] keyBytes = key.getBytes();
	    byte[] dataBytes = Base64.decodeBase64(data);
	    byte[] result = new byte[dataBytes.length];
	    for( int i = 0; i < dataBytes.length; i++)
	    {
	        int b = dataBytes[i] & 0xFF;
	        int idx = (i % keyBytes.length)-1;
	        if (idx < 0)
	        	idx = keyBytes.length-1;
	        int kb = keyBytes[idx] & 0xFF;
	        int c = b-kb;
	        if (c < 0)
	        	c = 256 + c;
	        result[i] = (byte)c;
	    }
	    return new String(result);
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(Utils.encodeItemData("{성공을 원한다면, 사람을 포용할 수 있나요?}"));
		System.out.println(Utils.decodeItemData("nlHzIlUlExLH9Y5S/AVT+QlXAg5eHR9NRA/nG1wJ/krDrpFb9Q1hAA1aAReKX/wDQRDB7VrzA174umnu"));
	}

}
