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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

class DefaultApplicationContextFactoryTest {
	/**
	 * Method under test: {@link DefaultApplicationContextFactory#getEnvironmentType(WebApplicationType)}
	 */
	@Test
	void testGetEnvironmentType() {
		assertNull((new DefaultApplicationContextFactory()).getEnvironmentType(WebApplicationType.NONE));
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#createEnvironment(WebApplicationType)}
	 */
	@Test
	void testCreateEnvironment() {
		assertNull((new DefaultApplicationContextFactory()).createEnvironment(WebApplicationType.NONE));
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#create(WebApplicationType)}
	 */
	@Test
	void testCreate() {
		ConfigurableApplicationContext actualCreateResult = (new DefaultApplicationContextFactory())
				.create(WebApplicationType.NONE);
		assertTrue(((AnnotationConfigApplicationContext) actualCreateResult).getProtocolResolvers().isEmpty());
		String[] expectedActiveProfiles = ((AnnotationConfigApplicationContext) actualCreateResult)
				.getDefaultListableBeanFactory()
				.getSingletonNames();
		ConfigurableEnvironment environment = actualCreateResult.getEnvironment();
		assertSame(expectedActiveProfiles, environment.getActiveProfiles());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertEquals(2, environment.getPropertySources().size());
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#create(WebApplicationType)}
	 */
	@Test
	void testCreate2() {
		ConfigurableApplicationContext actualCreateResult = (new DefaultApplicationContextFactory())
				.create(WebApplicationType.SERVLET);
		assertTrue(
				((AnnotationConfigServletWebServerApplicationContext) actualCreateResult).getProtocolResolvers().isEmpty());
		String[] expectedActiveProfiles = ((AnnotationConfigServletWebServerApplicationContext) actualCreateResult)
				.getDefaultListableBeanFactory()
				.getSingletonNames();
		ConfigurableEnvironment environment = actualCreateResult.getEnvironment();
		assertSame(expectedActiveProfiles, environment.getActiveProfiles());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertEquals(4, environment.getPropertySources().size());
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#create(WebApplicationType)}
	 */
	@Test
	void testCreate3() {
		ConfigurableApplicationContext actualCreateResult = (new DefaultApplicationContextFactory())
				.create(WebApplicationType.REACTIVE);
		assertTrue(
				((AnnotationConfigReactiveWebServerApplicationContext) actualCreateResult).getProtocolResolvers().isEmpty());
		String[] expectedActiveProfiles = ((AnnotationConfigReactiveWebServerApplicationContext) actualCreateResult)
				.getDefaultListableBeanFactory()
				.getSingletonNames();
		ConfigurableEnvironment environment = actualCreateResult.getEnvironment();
		assertSame(expectedActiveProfiles, environment.getActiveProfiles());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertEquals(2, environment.getPropertySources().size());
	}
}
