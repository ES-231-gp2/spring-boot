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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

class ClearCachesApplicationListenerTest {
	/**
	 * Method under test: {@link ClearCachesApplicationListener#onApplicationEvent(ContextRefreshedEvent)}
	 */
	@Test
	void testOnApplicationEvent() {
		ClearCachesApplicationListener clearCachesApplicationListener = new ClearCachesApplicationListener();
		clearCachesApplicationListener
				.onApplicationEvent(new ContextRefreshedEvent(new AnnotationConfigReactiveWebApplicationContext()));
		assertTrue(clearCachesApplicationListener.supportsAsyncExecution());
	}

	/**
	 * Method under test: {@link ClearCachesApplicationListener#onApplicationEvent(ContextRefreshedEvent)}
	 */
	@Test
	void testOnApplicationEvent2() {
		ClearCachesApplicationListener clearCachesApplicationListener = new ClearCachesApplicationListener();

		AnnotationConfigReactiveWebApplicationContext source = new AnnotationConfigReactiveWebApplicationContext();
		source.addApplicationListener(mock(ApplicationListener.class));
		clearCachesApplicationListener.onApplicationEvent(new ContextRefreshedEvent(source));
		assertTrue(clearCachesApplicationListener.supportsAsyncExecution());
	}
}

