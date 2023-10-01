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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.reactive.context.ApplicationReactiveWebEnvironment;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ApplicationServletEnvironment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.metrics.ApplicationStartup;

class DefaultApplicationContextFactoryTest {
	/**
	 * Method under test: {@link DefaultApplicationContextFactory#getEnvironmentType(WebApplicationType)}
	 */
	@Test
	void testGetEnvironmentType() {
		assertNull((new DefaultApplicationContextFactory()).getEnvironmentType(WebApplicationType.NONE));
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#getEnvironmentType(WebApplicationType)}
	 */
	@Test
	void testGetEnvironmentType2() {
		Class<? extends ConfigurableEnvironment> actualEnvironmentType = (new DefaultApplicationContextFactory())
				.getEnvironmentType(WebApplicationType.SERVLET);
		Class<ApplicationServletEnvironment> expectedEnvironmentType = ApplicationServletEnvironment.class;
		assertSame(expectedEnvironmentType, actualEnvironmentType);
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#getEnvironmentType(WebApplicationType)}
	 */
	@Test
	void testGetEnvironmentType3() {
		Class<? extends ConfigurableEnvironment> actualEnvironmentType = (new DefaultApplicationContextFactory())
				.getEnvironmentType(WebApplicationType.REACTIVE);
		Class<ApplicationReactiveWebEnvironment> expectedEnvironmentType = ApplicationReactiveWebEnvironment.class;
		assertSame(expectedEnvironmentType, actualEnvironmentType);
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#createEnvironment(WebApplicationType)}
	 */
	@Test
	void testCreateEnvironment() {
		assertNull((new DefaultApplicationContextFactory()).createEnvironment(WebApplicationType.NONE));
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#createEnvironment(WebApplicationType)}
	 */
	@Test
	void testCreateEnvironment2() throws IllegalStateException {
		DefaultApplicationContextFactory defaultApplicationContextFactory = new DefaultApplicationContextFactory();
		defaultApplicationContextFactory.createEnvironment(WebApplicationType.SERVLET);
		ConfigurableApplicationContext createResult = defaultApplicationContextFactory.create(WebApplicationType.NONE);
		assertTrue(((AnnotationConfigApplicationContext) createResult).getApplicationListeners().isEmpty());
		assertFalse(createResult.isRunning());
		assertFalse(createResult.isActive());
		assertEquals(0L, createResult.getStartupDate());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getProtocolResolvers().isEmpty());
		assertEquals("", createResult.getApplicationName());
		assertEquals(6, createResult.getBeanDefinitionCount());
		assertArrayEquals(new String[] { "org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
				"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
				"org.springframework.context.annotation.internalCommonAnnotationProcessor",
				"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
				"org.springframework.context.event.internalEventListenerProcessor",
				"org.springframework.context.event.internalEventListenerFactory" }, createResult.getBeanDefinitionNames());
		DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) createResult)
				.getDefaultListableBeanFactory();
		assertSame(defaultListableBeanFactory, createResult.getBeanFactory());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getBeanFactoryPostProcessors().isEmpty());
		assertFalse(defaultListableBeanFactory.hasEmbeddedValueResolver());
		String[] singletonNames = defaultListableBeanFactory.getSingletonNames();
		assertEquals(0, singletonNames.length);
		assertFalse(defaultListableBeanFactory.isAllowRawInjectionDespiteWrapping());
		assertTrue(((Map<Object, Object>) defaultListableBeanFactory.getSingletonMutex()).isEmpty());
		assertFalse(defaultListableBeanFactory.isConfigurationFrozen());
		assertSame(singletonNames, defaultListableBeanFactory.getRegisteredScopeNames());
		assertTrue(defaultListableBeanFactory.getPropertyEditorRegistrars().isEmpty());
		assertTrue(defaultListableBeanFactory.getCustomEditors().isEmpty());
		assertTrue(defaultListableBeanFactory.getBeanPostProcessors().isEmpty());
		assertEquals(0, defaultListableBeanFactory.getBeanPostProcessorCount());
		assertArrayEquals(
				new String[] { "org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
						"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
						"org.springframework.context.annotation.internalCommonAnnotationProcessor",
						"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
						"org.springframework.context.event.internalEventListenerProcessor",
						"org.springframework.context.event.internalEventListenerFactory" },
				defaultListableBeanFactory.getBeanDefinitionNames());
		assertEquals(6, defaultListableBeanFactory.getBeanDefinitionCount());
		ConfigurableEnvironment environment = createResult.getEnvironment();
		Map<String, Object> systemProperties = environment.getSystemProperties();
		assertEquals(69, systemProperties.size());
		assertEquals(0, defaultListableBeanFactory.getSingletonCount());
		assertSame(singletonNames, environment.getActiveProfiles());
		ApplicationStartup expectedApplicationStartup = createResult.getApplicationStartup();
		assertSame(expectedApplicationStartup, defaultListableBeanFactory.getApplicationStartup());
		Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
		assertEquals(81, systemEnvironment.size());
		assertTrue(defaultListableBeanFactory.isCacheBeanMetadata());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertTrue(defaultListableBeanFactory.isAllowBeanDefinitionOverriding());
		assertTrue(defaultListableBeanFactory.isAllowEagerClassLoading());
		assertTrue(defaultListableBeanFactory.isAllowCircularReferences());
		String expectedString = String.join("", "/home/linuxbrew/.linuxbrew/bin:/home/linuxbrew/.linuxbrew/sbin:",
				Paths.get(System.getProperty("user.home"), ".local", "bin").toString(),
				":/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:"
						+ "/usr/local/go/bin");
		assertEquals(expectedString, systemEnvironment.get("PATH"));
		assertEquals("/run/user/1000/gdm/Xauthority", systemEnvironment.get("XAUTHORITY"));
		String expectedString2 = Paths
				.get(System.getProperty("user.home"), ".local", "share", "JetBrains", "IdeaIC2023.2", "diffblue-cover-ij",
						"META-INF", "cover-service-analyzer-2023.09.02.jar")
				.toString();
		assertEquals(expectedString2, systemProperties.get("cover.jar.path"));
		assertEquals("off", systemProperties.get("kotlinx.coroutines.debug"));
		assertEquals("17", systemProperties.get("java.specification.version"));
		MutablePropertySources propertySources = environment.getPropertySources();
		assertEquals(2, propertySources.size());
		assertEquals("en_US.UTF-8", systemEnvironment.get("LC_MEASUREMENT"));
		assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
	}

	/**
	 * Method under test: {@link DefaultApplicationContextFactory#createEnvironment(WebApplicationType)}
	 */
	@Test
	void testCreateEnvironment3() throws IllegalStateException {
		DefaultApplicationContextFactory defaultApplicationContextFactory = new DefaultApplicationContextFactory();
		defaultApplicationContextFactory.createEnvironment(WebApplicationType.REACTIVE);
		ConfigurableApplicationContext createResult = defaultApplicationContextFactory.create(WebApplicationType.NONE);
		assertTrue(((AnnotationConfigApplicationContext) createResult).getApplicationListeners().isEmpty());
		assertFalse(createResult.isRunning());
		assertFalse(createResult.isActive());
		assertEquals(0L, createResult.getStartupDate());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getProtocolResolvers().isEmpty());
		assertEquals("", createResult.getApplicationName());
		assertEquals(6, createResult.getBeanDefinitionCount());
		assertArrayEquals(new String[] { "org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
				"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
				"org.springframework.context.annotation.internalCommonAnnotationProcessor",
				"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
				"org.springframework.context.event.internalEventListenerProcessor",
				"org.springframework.context.event.internalEventListenerFactory" }, createResult.getBeanDefinitionNames());
		DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) createResult)
				.getDefaultListableBeanFactory();
		assertSame(defaultListableBeanFactory, createResult.getBeanFactory());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getBeanFactoryPostProcessors().isEmpty());
		assertFalse(defaultListableBeanFactory.hasEmbeddedValueResolver());
		String[] singletonNames = defaultListableBeanFactory.getSingletonNames();
		assertEquals(0, singletonNames.length);
		assertFalse(defaultListableBeanFactory.isAllowRawInjectionDespiteWrapping());
		assertTrue(((Map<Object, Object>) defaultListableBeanFactory.getSingletonMutex()).isEmpty());
		assertFalse(defaultListableBeanFactory.isConfigurationFrozen());
		assertSame(singletonNames, defaultListableBeanFactory.getRegisteredScopeNames());
		assertTrue(defaultListableBeanFactory.getPropertyEditorRegistrars().isEmpty());
		assertTrue(defaultListableBeanFactory.getCustomEditors().isEmpty());
		assertTrue(defaultListableBeanFactory.getBeanPostProcessors().isEmpty());
		assertEquals(0, defaultListableBeanFactory.getBeanPostProcessorCount());
		assertArrayEquals(
				new String[] { "org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
						"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
						"org.springframework.context.annotation.internalCommonAnnotationProcessor",
						"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
						"org.springframework.context.event.internalEventListenerProcessor",
						"org.springframework.context.event.internalEventListenerFactory" },
				defaultListableBeanFactory.getBeanDefinitionNames());
		assertEquals(6, defaultListableBeanFactory.getBeanDefinitionCount());
		ConfigurableEnvironment environment = createResult.getEnvironment();
		Map<String, Object> systemProperties = environment.getSystemProperties();
		assertEquals(69, systemProperties.size());
		assertEquals(0, defaultListableBeanFactory.getSingletonCount());
		assertSame(singletonNames, environment.getActiveProfiles());
		ApplicationStartup expectedApplicationStartup = createResult.getApplicationStartup();
		assertSame(expectedApplicationStartup, defaultListableBeanFactory.getApplicationStartup());
		Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
		assertEquals(81, systemEnvironment.size());
		assertTrue(defaultListableBeanFactory.isCacheBeanMetadata());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertTrue(defaultListableBeanFactory.isAllowBeanDefinitionOverriding());
		assertTrue(defaultListableBeanFactory.isAllowEagerClassLoading());
		assertTrue(defaultListableBeanFactory.isAllowCircularReferences());
		String expectedString = String.join("", "/home/linuxbrew/.linuxbrew/bin:/home/linuxbrew/.linuxbrew/sbin:",
				Paths.get(System.getProperty("user.home"), ".local", "bin").toString(),
				":/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:"
						+ "/usr/local/go/bin");
		assertEquals(expectedString, systemEnvironment.get("PATH"));
		assertEquals("/run/user/1000/gdm/Xauthority", systemEnvironment.get("XAUTHORITY"));
		String expectedString2 = Paths
				.get(System.getProperty("user.home"), ".local", "share", "JetBrains", "IdeaIC2023.2", "diffblue-cover-ij",
						"META-INF", "cover-service-analyzer-2023.09.02.jar")
				.toString();
		assertEquals(expectedString2, systemProperties.get("cover.jar.path"));
		assertEquals("off", systemProperties.get("kotlinx.coroutines.debug"));
		assertEquals("17", systemProperties.get("java.specification.version"));
		MutablePropertySources propertySources = environment.getPropertySources();
		assertEquals(2, propertySources.size());
		assertEquals("en_US.UTF-8", systemEnvironment.get("LC_MEASUREMENT"));
		assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
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

