package org.patrickyu.example.http.common;

import httl.Engine;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateUtils {

	public static String renderHtml(String htmlFileName) {
		return renderHtml(htmlFileName, new HashMap<String, Object>());
	}

	public static String renderHtml(String htmlFileName, Map<String, Object> map) {
		try {
			VerticleRepo repo = VerticleRepo.getInstance();
			Engine engine = repo.getEngine();
			httl.Template httlTemplate = engine.getTemplate(htmlFileName);
			StringWriter writer = new StringWriter();
			httlTemplate.render(map, writer);
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
