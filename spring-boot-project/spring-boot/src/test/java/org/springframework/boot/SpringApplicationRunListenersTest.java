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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.logging.DeferredLog;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.StartupStep;

class SpringApplicationRunListenersTest {
	/**
	 * Method under test: {@link SpringApplicationRunListeners#SpringApplicationRunListeners(Log, List, ApplicationStartup)}
	 */
	@Test
	void testConstructor() {
		DeferredLog log = new DeferredLog();
		ArrayList<SpringApplicationRunListener> listeners = new ArrayList<>();
		new SpringApplicationRunListeners(log, listeners, mock(ApplicationStartup.class));

		assertTrue(listeners.isEmpty());
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#starting(ConfigurableBootstrapContext, Class)}
	 */
	@Test
	void testStarting() {
		StartupStep startupStep = mock(StartupStep.class);
		when(startupStep.tag(Mockito.<String>any(), Mockito.<String>any())).thenReturn(mock(StartupStep.class));
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		DefaultBootstrapContext bootstrapContext = new DefaultBootstrapContext();
		Class<Object> mainApplicationClass = Object.class;
		springApplicationRunListeners.starting(bootstrapContext, mainApplicationClass);
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).tag(Mockito.<String>any(), Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#environmentPrepared(ConfigurableBootstrapContext, ConfigurableEnvironment)}
	 */
	@Test
	void testEnvironmentPrepared() {
		StartupStep startupStep = mock(StartupStep.class);
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		DefaultBootstrapContext bootstrapContext = new DefaultBootstrapContext();
		springApplicationRunListeners.environmentPrepared(bootstrapContext, new ApplicationEnvironment());
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#contextPrepared(ConfigurableApplicationContext)}
	 */
	@Test
	void testContextPrepared() {
		StartupStep startupStep = mock(StartupStep.class);
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		springApplicationRunListeners.contextPrepared(new AnnotationConfigReactiveWebApplicationContext());
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#contextLoaded(ConfigurableApplicationContext)}
	 */
	@Test
	void testContextLoaded() {
		StartupStep startupStep = mock(StartupStep.class);
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		springApplicationRunListeners.contextLoaded(new AnnotationConfigReactiveWebApplicationContext());
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#started(ConfigurableApplicationContext, Duration)}
	 */
	@Test
	void testStarted() {
		StartupStep startupStep = mock(StartupStep.class);
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		springApplicationRunListeners.started(new AnnotationConfigReactiveWebApplicationContext(), null);
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#ready(ConfigurableApplicationContext, Duration)}
	 */
	@Test
	void testReady() {
		StartupStep startupStep = mock(StartupStep.class);
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		springApplicationRunListeners.ready(new AnnotationConfigReactiveWebApplicationContext(), null);
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep).end();
	}

	/**
	 * Method under test: {@link SpringApplicationRunListeners#failed(ConfigurableApplicationContext, Throwable)}
	 */
	@Test
	void testFailed() {
		StartupStep startupStep = mock(StartupStep.class);
		when(startupStep.tag(Mockito.<String>any(), Mockito.<String>any())).thenReturn(mock(StartupStep.class));
		doNothing().when(startupStep).end();
		ApplicationStartup applicationStartup = mock(ApplicationStartup.class);
		when(applicationStartup.start(Mockito.<String>any())).thenReturn(startupStep);
		DeferredLog log = new DeferredLog();
		SpringApplicationRunListeners springApplicationRunListeners = new SpringApplicationRunListeners(log,
				new ArrayList<>(), applicationStartup);
		AnnotationConfigReactiveWebApplicationContext context = new AnnotationConfigReactiveWebApplicationContext();
		springApplicationRunListeners.failed(context, new Throwable());
		verify(applicationStartup).start(Mockito.<String>any());
		verify(startupStep, atLeast(1)).tag(Mockito.<String>any(), Mockito.<String>any());
		verify(startupStep).end();
	}
}

