package io.mandrel.data.content.selector;

import static org.junit.Assert.*;
import io.mandrel.data.content.selector.Selector;
import io.mandrel.data.content.selector.SelectorService;

import java.util.Map;

import org.junit.Test;

public class SelectorServiceTest {

	@Test
	public void test() {

		SelectorService selectorService = new SelectorService();
		Map<String, Selector<?>> selectorsByName = selectorService
				.getSelectorsByName();
		System.err.println(selectorsByName);

		assertEquals(2, selectorsByName.size());
		assertNotNull(selectorsByName.get("xpath"));
		assertNotNull(selectorsByName.get("static"));

		assertNotNull(selectorService.getSelectorByName("xpath"));
		assertNotNull(selectorService.getSelectorByName("static"));
	}
}
