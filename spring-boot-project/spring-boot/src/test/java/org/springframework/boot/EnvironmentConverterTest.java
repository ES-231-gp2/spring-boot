/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.ConfigurableEnvironment;

class EnvironmentConverterTest {
	/**
	 * Method under test: {@link EnvironmentConverter#convertEnvironmentIfNecessary(ConfigurableEnvironment, Class)}
	 */
	@Test
	void testConvertEnvironmentIfNecessary() {
		EnvironmentConverter environmentConverter = new EnvironmentConverter(new TomcatEmbeddedWebappClassLoader());
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<ConfigurableEnvironment> type = ConfigurableEnvironment.class;
		ConfigurableEnvironment actualConvertEnvironmentIfNecessaryResult = environmentConverter
				.convertEnvironmentIfNecessary(environment, type);
		assertEquals(0, actualConvertEnvironmentIfNecessaryResult.getActiveProfiles().length);
		ConfigurableConversionService conversionService = actualConvertEnvironmentIfNecessaryResult
				.getConversionService();
		assertTrue(conversionService instanceof DefaultConversionService);
		assertArrayEquals(new String[] { "default" }, actualConvertEnvironmentIfNecessaryResult.getDefaultProfiles());
		assertEquals(2, actualConvertEnvironmentIfNecessaryResult.getPropertySources().size());
		assertSame(conversionService, environment.getConversionService());
	}
}
