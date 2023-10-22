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

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

class BootstrapContextClosedEventTest {
	/**
	 * Method under test: {@link BootstrapContextClosedEvent#BootstrapContextClosedEvent(BootstrapContext, ConfigurableApplicationContext)}
	 */
	@Test
	void testConstructor() {
		DefaultBootstrapContext source = new DefaultBootstrapContext();
		AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
		BootstrapContextClosedEvent actualBootstrapContextClosedEvent = new BootstrapContextClosedEvent(source,
				applicationContext);

		assertSame(actualBootstrapContextClosedEvent.getSource(), source);
		assertSame(actualBootstrapContextClosedEvent.getApplicationContext(), applicationContext);
	}

	/**
	 * Method under test: {@link BootstrapContextClosedEvent#getBootstrapContext()}
	 */
	@Test
	void testGetBootstrapContext() {
		DefaultBootstrapContext source = new DefaultBootstrapContext();
		assertSame(source, (new BootstrapContextClosedEvent(source, new AnnotationConfigReactiveWebApplicationContext()))
				.getBootstrapContext());
	}

	/**
	 * Method under test: {@link BootstrapContextClosedEvent#getApplicationContext()}
	 */
	@Test
	void testGetApplicationContext() {
		DefaultBootstrapContext source = new DefaultBootstrapContext();
		AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
		assertSame(applicationContext,
				(new BootstrapContextClosedEvent(source, applicationContext)).getApplicationContext());
	}
}
