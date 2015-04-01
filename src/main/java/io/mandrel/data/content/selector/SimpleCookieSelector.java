package io.mandrel.data.content.selector;

import io.mandrel.http.Cookie;
import io.mandrel.http.WebPage;

import java.util.List;

public class SimpleCookieSelector extends CookieSelector {

	public Instance init(WebPage webpage, List<Cookie> cookies) {
		return new Instance() {

			@Override
			public List<String> select(String value) {
				cookies.stream().filter(cookie -> cookie.getName().equals(value)).map(cookie -> cookie.getValue());
				return null;
			}
		};
	}

	@Override
	public String getName() {
		return "cookie";
	}
}