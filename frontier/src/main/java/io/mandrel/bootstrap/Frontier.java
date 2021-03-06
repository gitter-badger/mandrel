/*
 * Licensed to Mandrel under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Mandrel licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.mandrel.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class, MongoAutoConfiguration.class, JacksonAutoConfiguration.class })
@ComponentScan(basePackages = "io.mandrel", excludeFilters = { @Filter(type = FilterType.ASSIGNABLE_TYPE, value = {}) })
public class Frontier extends Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.location", "classpath:/version.yml,classpath:/frontier.yml");
		new Frontier().start(args);
	}

	@Override
	public void configure(SpringApplicationBuilder builder) {
		builder.web(false);
	}
}
