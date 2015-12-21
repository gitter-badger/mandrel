package io.mandrel.frontier.store.impl;

import io.mandrel.frontier.store.FetchRequest;
import io.mandrel.frontier.store.impl.KafkaFrontierStore.KafkaFrontierStoreDefinition;

import java.net.URI;

import org.junit.Test;

public class KafkaFrontierStoreTest {

	@Test
	public void test() throws InterruptedException {

		KafkaFrontierStoreDefinition definition = new KafkaFrontierStoreDefinition();
		KafkaFrontierStore store = definition.build(null);

		store.create("queue");
		store.schedule("queue", URI.create("test://test"));
		Thread.sleep(500);

		store.pool(FetchRequest.of("queue", (uri) -> {
			System.err.println(uri);
		}));
	}
}
