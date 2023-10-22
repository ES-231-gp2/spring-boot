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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ResourceLoader;

class SpringApplicationTest {
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link SpringApplication.AbandonedRunException#AbandonedRunException()}
	 *   <li>{@link SpringApplication.AbandonedRunException#getApplicationContext()}
	 * </ul>
	 */
	@Test
	void testAbandonedRunExceptionConstructor() {
		assertNull((new SpringApplication.AbandonedRunException()).getApplicationContext());
	}

	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link SpringApplication.AbandonedRunException#AbandonedRunException(ConfigurableApplicationContext)}
	 *   <li>{@link SpringApplication.AbandonedRunException#getApplicationContext()}
	 * </ul>
	 */
	@Test
	void testAbandonedRunExceptionConstructor2() {
		AnnotationConfigReactiveWebApplicationContext applicationContext = new AnnotationConfigReactiveWebApplicationContext();
		assertSame(applicationContext,
				(new SpringApplication.AbandonedRunException(applicationContext)).getApplicationContext());
	}

	/**
	 * Method under test: {@link SpringApplication#configureEnvironment(ConfigurableEnvironment, String[])}
	 */
	@Test
	void testConfigureEnvironment() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		ApplicationEnvironment environment = new ApplicationEnvironment();
		springApplication.configureEnvironment(environment, new String[] { "Args" });
		assertTrue(environment.getConversionService() instanceof ApplicationConversionService);
		assertEquals(3, environment.getPropertySources().size());
	}

	/**
	 * Method under test: {@link SpringApplication#configurePropertySources(ConfigurableEnvironment, String[])}
	 */
	@Test
	void testConfigurePropertySources() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		ApplicationEnvironment environment = new ApplicationEnvironment();
		springApplication.configurePropertySources(environment, new String[] { "Args" });
		assertEquals(3, environment.getPropertySources().size());
	}

	/**
	 * Method under test: {@link SpringApplication#createApplicationContext()}
	 */
	@Test
	void testCreateApplicationContext() {
		Class<Object> forNameResult = Object.class;
		ConfigurableApplicationContext actualCreateApplicationContextResult = (new SpringApplication(forNameResult))
				.createApplicationContext();
		assertTrue(((AnnotationConfigServletWebServerApplicationContext) actualCreateApplicationContextResult)
				.getProtocolResolvers()
				.isEmpty());
		String[] expectedActiveProfiles = ((AnnotationConfigServletWebServerApplicationContext) actualCreateApplicationContextResult)
				.getDefaultListableBeanFactory()
				.getSingletonNames();
		ConfigurableEnvironment environment = actualCreateApplicationContextResult.getEnvironment();
		assertSame(expectedActiveProfiles, environment.getActiveProfiles());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertEquals(4, environment.getPropertySources().size());
	}

	/**
	 * Method under test: {@link SpringApplication#postProcessApplicationContext(ConfigurableApplicationContext)}
	 */
	@Test
	void testPostProcessApplicationContext() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		AnnotationConfigReactiveWebApplicationContext context = new AnnotationConfigReactiveWebApplicationContext();
		springApplication.postProcessApplicationContext(context);
		assertSame(context.getDefaultListableBeanFactory().getConversionService(),
				context.getEnvironment().getConversionService());
	}

	/**
	 * Method under test: {@link SpringApplication#logStartupProfileInfo(ConfigurableApplicationContext)}
	 */
	@Test
	void testLogStartupProfileInfo() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		AnnotationConfigReactiveWebApplicationContext context = new AnnotationConfigReactiveWebApplicationContext();
		springApplication.logStartupProfileInfo(context);
		assertNotNull(context.getClassLoader());
	}

	/**
	 * Method under test: {@link SpringApplication#getClassLoader()}
	 */
	@Test
	void testGetClassLoader() {
		Class<Object> forNameResult = Object.class;
		assertNotNull((new SpringApplication(forNameResult)).getClassLoader());
	}

	/**
	 * Method under test: {@link SpringApplication#refresh(ConfigurableApplicationContext)}
	 */
	@Test
	void testRefresh() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.refresh(new AnnotationConfigReactiveWebApplicationContext());
		assertEquals(7, springApplication.getListeners().size());
		assertEquals(5, springApplication.getInitializers().size());
	}

	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link SpringApplication#setAddCommandLineProperties(boolean)}
	 *   <li>{@link SpringApplication#setAddConversionService(boolean)}
	 *   <li>{@link SpringApplication#setAllowBeanDefinitionOverriding(boolean)}
	 *   <li>{@link SpringApplication#setAllowCircularReferences(boolean)}
	 *   <li>{@link SpringApplication#setBanner(Banner)}
	 *   <li>{@link SpringApplication#setBannerMode(Banner.Mode)}
	 *   <li>{@link SpringApplication#setBeanNameGenerator(BeanNameGenerator)}
	 *   <li>{@link SpringApplication#setDefaultProperties(Map)}
	 *   <li>{@link SpringApplication#setEnvironmentPrefix(String)}
	 *   <li>{@link SpringApplication#setHeadless(boolean)}
	 *   <li>{@link SpringApplication#setLazyInitialization(boolean)}
	 *   <li>{@link SpringApplication#setLogStartupInfo(boolean)}
	 *   <li>{@link SpringApplication#setMainApplicationClass(Class)}
	 *   <li>{@link SpringApplication#setRegisterShutdownHook(boolean)}
	 *   <li>{@link SpringApplication#afterRefresh(ConfigurableApplicationContext, ApplicationArguments)}
	 *   <li>{@link SpringApplication#configureProfiles(ConfigurableEnvironment, String[])}
	 *   <li>{@link SpringApplication#getAdditionalProfiles()}
	 *   <li>{@link SpringApplication#getApplicationStartup()}
	 *   <li>{@link SpringApplication#getEnvironmentPrefix()}
	 *   <li>{@link SpringApplication#getMainApplicationClass()}
	 *   <li>{@link SpringApplication#getResourceLoader()}
	 *   <li>{@link SpringApplication#getSources()}
	 *   <li>{@link SpringApplication#getWebApplicationType()}
	 * </ul>
	 */
	@Test
	void testSetAddCommandLineProperties() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setAddCommandLineProperties(true);
		springApplication.setAddConversionService(true);
		springApplication.setAllowBeanDefinitionOverriding(true);
		springApplication.setAllowCircularReferences(true);
		springApplication.setBanner(new SpringBootBanner());
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.setBeanNameGenerator(new DefaultBeanNameGenerator());
		springApplication.setDefaultProperties(new HashMap<>());
		springApplication.setEnvironmentPrefix("Environment Prefix");
		springApplication.setHeadless(true);
		springApplication.setLazyInitialization(true);
		springApplication.setLogStartupInfo(true);
		Class<Object> mainApplicationClass = Object.class;
		springApplication.setMainApplicationClass(mainApplicationClass);
		springApplication.setRegisterShutdownHook(true);
		AnnotationConfigReactiveWebApplicationContext context = new AnnotationConfigReactiveWebApplicationContext();
		springApplication.afterRefresh(context, new DefaultApplicationArguments("Args"));
		springApplication.configureProfiles(new ApplicationEnvironment(), new String[] { "Args" });
		springApplication.getAdditionalProfiles();
		springApplication.getApplicationStartup();
		String actualEnvironmentPrefix = springApplication.getEnvironmentPrefix();
		Class<?> actualMainApplicationClass = springApplication.getMainApplicationClass();
		springApplication.getResourceLoader();
		springApplication.getSources();
		WebApplicationType actualWebApplicationType = springApplication.getWebApplicationType();
		assertEquals("Environment Prefix", actualEnvironmentPrefix);
		assertSame(mainApplicationClass, actualMainApplicationClass);
		Class<Object> expectedMainApplicationClass = Object.class;
		assertSame(expectedMainApplicationClass, actualMainApplicationClass);
		assertEquals(WebApplicationType.SERVLET, actualWebApplicationType);
	}

	/**
	 * Method under test: {@link SpringApplication#getAllSources()}
	 */
	@Test
	void testGetAllSources() {
		Class<Object> forNameResult = Object.class;
		assertEquals(1, (new SpringApplication(forNameResult)).getAllSources().size());
	}

	/**
	 * Method under test: {@link SpringApplication#setResourceLoader(ResourceLoader)}
	 */
	@Test
	void testSetResourceLoader() {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		springApplication.setResourceLoader(resourceLoader);
		assertNotNull(resourceLoader.getClassLoader());
	}

	/**
	 * Method under test: {@link SpringApplication#getInitializers()}
	 */
	@Test
	void testGetInitializers() {
		Class<Object> forNameResult = Object.class;
		assertEquals(5, (new SpringApplication(forNameResult)).getInitializers().size());
	}

	/**
	 * Method under test: {@link SpringApplication#getListeners()}
	 */
	@Test
	void testGetListeners() {
		Class<Object> forNameResult = Object.class;
		assertEquals(7, (new SpringApplication(forNameResult)).getListeners().size());
	}

	/**
	 * Method under test: {@link SpringApplication#withHook(SpringApplicationHook, Runnable)}
	 */
	@Test
	void testWithHook() {
		Runnable action = mock(Runnable.class);
		doNothing().when(action).run();
		SpringApplication.withHook(null, action);
		verify(action).run();
	}
}
