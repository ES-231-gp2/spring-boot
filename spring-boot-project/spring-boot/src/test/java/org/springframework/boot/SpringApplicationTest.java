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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.util.function.ThrowingConsumer;
import org.springframework.util.function.ThrowingSupplier;

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
	 * Method under test: {@link SpringApplication.Augmented#Augmented(ThrowingConsumer, Set)}
	 */
	@Test
	void testAugmentedConstructor() {
		ThrowingConsumer<String[]> main = mock(ThrowingConsumer.class);
		HashSet<Class<?>> sources = new HashSet<>();
		new SpringApplication.Augmented(main, sources);

		assertTrue(sources.isEmpty());
	}

	/**
	 * Method under test: {@link SpringApplication.Augmented#Augmented(ThrowingConsumer, Set)}
	 */
	@Test
	void testAugmentedConstructor2() {
		ThrowingConsumer<String[]> main = mock(ThrowingConsumer.class);

		HashSet<Class<?>> sources = new HashSet<>();
		Class<Object> forNameResult = Object.class;
		sources.add(forNameResult);
		new SpringApplication.Augmented(main, sources);

		assertEquals(1, sources.size());
	}

	/**
	 * Method under test: {@link SpringApplication.Augmented#Augmented(ThrowingConsumer, Set)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAugmentedConstructor3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "Object.equals(Object)" because "e0" is null
		//       at java.util.ImmutableCollections$Set12.<init>(ImmutableCollections.java:790)
		//       at java.util.Set.of(Set.java:704)
		//       at java.util.Set.copyOf(Set.java:732)
		//   See https://diff.blue/R013 to resolve this issue.

		ThrowingConsumer<String[]> main = mock(ThrowingConsumer.class);

		HashSet<Class<?>> sources = new HashSet<>();
		sources.add(null);
		Class<Object> forNameResult = Object.class;
		sources.add(forNameResult);
		new SpringApplication.Augmented(main, sources);

	}

	/**
	 * Method under test: {@link SpringApplication.Augmented#run(String[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAugmentedRun() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalStateException: No root application context located
		//   See https://diff.blue/R013 to resolve this issue.

		ThrowingConsumer<String[]> main = mock(ThrowingConsumer.class);
		doNothing().when(main).accept(Mockito.<String[]>any());
		SpringApplication.from(main).run("Args").getApplicationContext();
	}

	/**
	 * Method under test: {@link SpringApplication.Augmented#with(Class[])}
	 */
	@Test
	void testAugmentedWith() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Augmented.main
		//     Augmented.sources
		//     Augmented.main
		//     Augmented.sources

		SpringApplication.Augmented fromResult = SpringApplication.from(mock(ThrowingConsumer.class));
		Class<Object> forNameResult = Object.class;
		fromResult.with(forNameResult);
	}

	/**
	 * Method under test: {@link SpringApplication#SpringApplication(ResourceLoader, Class[])}
	 */
	@Test
	void testConstructor() {
		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		Class<Object> forNameResult = Object.class;
		Class<?>[] primarySources = new Class[] { forNameResult };
		assertSame((new SpringApplication(resourceLoader, primarySources)).getResourceLoader(), resourceLoader);
		assertEquals(1, primarySources.length);
		Class<?> resultClass = primarySources[0];
		assertSame(forNameResult, resultClass);
		Class<Object> expectedResultClass = Object.class;
		assertSame(expectedResultClass, resultClass);
	}

	/**
	 * Method under test: {@link SpringApplication#SpringApplication(ResourceLoader, Class[])}
	 */
	@Test
	void testConstructor2() {
		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		resourceLoader.addApplicationListener(mock(ApplicationListener.class));
		Class<Object> forNameResult = Object.class;
		Class<?>[] primarySources = new Class[] { forNameResult };
		assertSame((new SpringApplication(resourceLoader, primarySources)).getResourceLoader(), resourceLoader);
		assertEquals(1, primarySources.length);
		Class<?> resultClass = primarySources[0];
		assertSame(forNameResult, resultClass);
		Class<Object> expectedResultClass = Object.class;
		assertSame(expectedResultClass, resultClass);
	}

	/**
	 * Method under test: {@link SpringApplication#SpringApplication(Class[])}
	 */
	@Test
	void testConstructor3() {
		Class<Object> forNameResult = Object.class;
		Class<?>[] primarySources = new Class[] { forNameResult };
		new SpringApplication(primarySources);
		assertEquals(1, primarySources.length);
		Class<?> resultClass = primarySources[0];
		assertSame(forNameResult, resultClass);
		Class<Object> expectedResultClass = Object.class;
		assertSame(expectedResultClass, resultClass);
	}

	/**
	 * Method under test: {@link SpringApplication#run(Class, String[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRun() {
		// TODO: Complete this test.
		//   Reason: R020 Temporary files were created but not deleted.
		//   The method under test created the following temporary files without deleting
		//   them:
		//     /tmp/byteBuddyAgent13618384113494056400.jar
		//   Please ensure that temporary files are deleted in the method under test.
		//   See https://diff.blue/R020

		Class<Object> primarySource = Object.class;
		SpringApplication.run(primarySource, "Args");
	}

	/**
	 * Method under test: {@link SpringApplication#run(Class[], String[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRun2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   org.springframework.context.ApplicationContextException: Unable to start web server
		//   org.springframework.boot.web.context.MissingWebServerFactoryBeanException: No qualifying bean of type 'org.springframework.boot.web.servlet.server.ServletWebServerFactory' available: Unable to start AnnotationConfigServletWebServerApplicationContext due to missing ServletWebServerFactory bean
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> forNameResult = Object.class;
		SpringApplication.run(new Class[] { forNameResult }, new String[] { "Args" });
	}

	/**
	 * Method under test: {@link SpringApplication#run(String[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRun3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   org.springframework.context.ApplicationContextException: Unable to start web server
		//   org.springframework.boot.web.context.MissingWebServerFactoryBeanException: No qualifying bean of type 'org.springframework.boot.web.servlet.server.ServletWebServerFactory' available: Unable to start AnnotationConfigServletWebServerApplicationContext due to missing ServletWebServerFactory bean
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).run("Args");
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
	 * Method under test: {@link SpringApplication#bindToSpringApplication(ConfigurableEnvironment)}
	 */
	@Test
	void testBindToSpringApplication() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.bindToSpringApplication(new ApplicationEnvironment());
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
	 * Method under test: {@link SpringApplication#applyInitializers(ConfigurableApplicationContext)}
	 */
	@Test
	void testApplyInitializers() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.applyInitializers(new AnnotationConfigReactiveWebApplicationContext());
	}

	/**
	 * Method under test: {@link SpringApplication#logStartupInfo(boolean)}
	 */
	@Test
	void testLogStartupInfo() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).logStartupInfo(true);
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
	 * Method under test: {@link SpringApplication#getApplicationLog()}
	 */
	@Test
	void testGetApplicationLog() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Log4jLog.logger

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).getApplicationLog();
	}

	/**
	 * Method under test: {@link SpringApplication#load(ApplicationContext, Object[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testLoad() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Invalid source 'Sources'
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.load(new AnnotationConfigReactiveWebApplicationContext(), new Object[] { "Sources" });
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
	 * Method under test: {@link SpringApplication#createBeanDefinitionLoader(BeanDefinitionRegistry, Object[])}
	 */
	@Test
	void testCreateBeanDefinitionLoader() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     BeanDefinitionLoader.annotatedReader
		//     BeanDefinitionLoader.groovyReader
		//     BeanDefinitionLoader.resourceLoader
		//     BeanDefinitionLoader.scanner
		//     BeanDefinitionLoader.sources
		//     BeanDefinitionLoader.xmlReader

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.createBeanDefinitionLoader(new AnnotationConfigReactiveWebApplicationContext(),
				new Object[] { "Sources" });
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
	 * Method under test: {@link SpringApplication#registerLoggedException(Throwable)}
	 */
	@Test
	void testRegisterLoggedException() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.registerLoggedException(new Throwable());
	}

	/**
	 * Method under test: {@link SpringApplication#getSpringBootExceptionHandler()}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetSpringBootExceptionHandler() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> forNameResult = Object.class;
		SpringBootExceptionHandler actualSpringBootExceptionHandler = (new SpringApplication(forNameResult))
				.getSpringBootExceptionHandler();
		Thread thread = new Thread();
		actualSpringBootExceptionHandler.uncaughtException(thread, new Throwable());
	}

	/**
	 * Method under test: {@link SpringApplication#setWebApplicationType(WebApplicationType)}
	 */
	@Test
	void testSetWebApplicationType() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).setWebApplicationType(WebApplicationType.NONE);
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
	 * Method under test: {@link SpringApplication#addBootstrapRegistryInitializer(BootstrapRegistryInitializer)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddBootstrapRegistryInitializer() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: BootstrapRegistryInitializer must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).addBootstrapRegistryInitializer(null);
	}

	/**
	 * Method under test: {@link SpringApplication#setDefaultProperties(Properties)}
	 */
	@Test
	void testSetDefaultProperties() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setDefaultProperties(new Properties());
	}

	/**
	 * Method under test: {@link SpringApplication#setAdditionalProfiles(String[])}
	 */
	@Test
	void testSetAdditionalProfiles() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).setAdditionalProfiles("Profiles");
	}

	/**
	 * Method under test: {@link SpringApplication#setEnvironment(ConfigurableEnvironment)}
	 */
	@Test
	void testSetEnvironment() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setEnvironment(new ApplicationEnvironment());
	}

	/**
	 * Method under test: {@link SpringApplication#addPrimarySources(Collection)}
	 */
	@Test
	void testAddPrimarySources() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.addPrimarySources(new ArrayList<>());
	}

	/**
	 * Method under test: {@link SpringApplication#setSources(Set)}
	 */
	@Test
	void testSetSources() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setSources(new HashSet<>());
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
	 * Method under test: {@link SpringApplication#setApplicationContextFactory(ApplicationContextFactory)}
	 */
	@Test
	void testSetApplicationContextFactory() throws IllegalStateException {
		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		DefaultApplicationContextFactory applicationContextFactory = new DefaultApplicationContextFactory();
		springApplication.setApplicationContextFactory(applicationContextFactory);
		ConfigurableApplicationContext createResult = applicationContextFactory.create(WebApplicationType.NONE);
		assertFalse(createResult.isRunning());
		assertFalse(createResult.isActive());
		assertEquals(0L, createResult.getStartupDate());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getProtocolResolvers().isEmpty());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getApplicationListeners().isEmpty());
		assertTrue(((AnnotationConfigApplicationContext) createResult).getBeanFactoryPostProcessors().isEmpty());
		assertEquals(6, createResult.getBeanDefinitionCount());
		assertEquals("", createResult.getApplicationName());
		assertArrayEquals(new String[] { "org.springframework.context.annotation.internalConfigurationAnnotationProcessor",
				"org.springframework.context.annotation.internalAutowiredAnnotationProcessor",
				"org.springframework.context.annotation.internalCommonAnnotationProcessor",
				"org.springframework.context.annotation.internalPersistenceAnnotationProcessor",
				"org.springframework.context.event.internalEventListenerProcessor",
				"org.springframework.context.event.internalEventListenerFactory" }, createResult.getBeanDefinitionNames());
		DefaultListableBeanFactory defaultListableBeanFactory = ((AnnotationConfigApplicationContext) createResult)
				.getDefaultListableBeanFactory();
		assertSame(defaultListableBeanFactory, createResult.getBeanFactory());
		String[] singletonNames = defaultListableBeanFactory.getSingletonNames();
		assertEquals(0, singletonNames.length);
		assertTrue(defaultListableBeanFactory.isAllowEagerClassLoading());
		assertTrue(((Map<Object, Object>) defaultListableBeanFactory.getSingletonMutex()).isEmpty());
		assertEquals(0, defaultListableBeanFactory.getSingletonCount());
		assertTrue(defaultListableBeanFactory.isCacheBeanMetadata());
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
		assertEquals(72, systemProperties.size());
		ApplicationStartup expectedApplicationStartup = createResult.getApplicationStartup();
		assertSame(expectedApplicationStartup, defaultListableBeanFactory.getApplicationStartup());
		assertFalse(defaultListableBeanFactory.isConfigurationFrozen());
		Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
		assertEquals(81, systemEnvironment.size());
		assertFalse(defaultListableBeanFactory.isAllowRawInjectionDespiteWrapping());
		assertSame(singletonNames, environment.getActiveProfiles());
		assertFalse(defaultListableBeanFactory.hasEmbeddedValueResolver());
		assertTrue(defaultListableBeanFactory.isAllowCircularReferences());
		assertArrayEquals(new String[] { "default" }, environment.getDefaultProfiles());
		assertTrue(defaultListableBeanFactory.isAllowBeanDefinitionOverriding());
		MutablePropertySources propertySources = environment.getPropertySources();
		assertEquals(2, propertySources.size());
		assertEquals("/run/user/1000/gdm/Xauthority", systemEnvironment.get("XAUTHORITY"));
		String expectedString = Paths
				.get(System.getProperty("user.home"), ".local", "share", "JetBrains", "IdeaIC2023.2", "diffblue-cover-ij",
						"META-INF", "cover-service-analyzer-2023.09.02.jar")
				.toString();
		assertEquals(expectedString, systemProperties.get("cover.jar.path"));
		assertEquals("off", systemProperties.get("kotlinx.coroutines.debug"));
		assertEquals("en_US.UTF-8", systemEnvironment.get("LC_MEASUREMENT"));
		String expectedString2 = String.join("", "/home/linuxbrew/.linuxbrew/bin:/home/linuxbrew/.linuxbrew/sbin:",
				Paths.get(System.getProperty("user.home"), ".local", "bin").toString(),
				":/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:"
						+ "/usr/local/go/bin");
		assertEquals(expectedString2, systemEnvironment.get("PATH"));
		assertEquals("17", systemProperties.get("java.specification.version"));
		assertEquals(2L, propertySources.spliterator().getExactSizeIfKnown());
	}

	/**
	 * Method under test: {@link SpringApplication#setInitializers(Collection)}
	 */
	@Test
	void testSetInitializers() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setInitializers(new ArrayList<>());
	}

	/**
	 * Method under test: {@link SpringApplication#addInitializers(ApplicationContextInitializer[])}
	 */
	@Test
	void testAddInitializers() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).addInitializers(mock(ApplicationContextInitializer.class));
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
	 * Method under test: {@link SpringApplication#setListeners(Collection)}
	 */
	@Test
	void testSetListeners() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		SpringApplication springApplication = new SpringApplication(forNameResult);
		springApplication.setListeners(new ArrayList<>());
	}

	/**
	 * Method under test: {@link SpringApplication#addListeners(ApplicationListener[])}
	 */
	@Test
	void testAddListeners() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).addListeners(mock(ApplicationListener.class));
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
	 * Method under test: {@link SpringApplication#setApplicationStartup(ApplicationStartup)}
	 */
	@Test
	void testSetApplicationStartup() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		Class<Object> forNameResult = Object.class;
		(new SpringApplication(forNameResult)).setApplicationStartup(mock(ApplicationStartup.class));
	}

	/**
	 * Method under test: {@link SpringApplication#getShutdownHandlers()}
	 */
	@Test
	void testGetShutdownHandlers() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Handlers.actions
		//     Handlers.this$0

		SpringApplication.getShutdownHandlers();
	}

	/**
	 * Method under test: {@link SpringApplication#exit(ApplicationContext, ExitCodeGenerator[])}
	 */
	@Test
	void testExit() {
		assertEquals(1, SpringApplication.exit(new AnnotationConfigReactiveWebApplicationContext(), null));
	}

	/**
	 * Method under test: {@link SpringApplication#exit(ApplicationContext, ExitCodeGenerator[])}
	 */
	@Test
	void testExit2() {
		AnnotationConfigReactiveWebApplicationContext context = new AnnotationConfigReactiveWebApplicationContext();
		context.addApplicationListener(mock(ApplicationListener.class));
		assertEquals(1, SpringApplication.exit(context, null));
	}

	/**
	 * Method under test: {@link SpringApplication#from(ThrowingConsumer)}
	 */
	@Test
	void testFrom() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Augmented.main
		//     Augmented.sources

		SpringApplication.from(mock(ThrowingConsumer.class));
	}

	/**
	 * Method under test: default or parameterless constructor of {@link SpringApplication.SpringApplicationRuntimeHints}
	 */
	@Test
	void testSpringApplicationRuntimeHintsConstructor() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     BindableRuntimeHintsRegistrar.bindables

		new SpringApplication.SpringApplicationRuntimeHints();
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

	/**
	 * Method under test: {@link SpringApplication#withHook(SpringApplicationHook, ThrowingSupplier)}
	 */
	@Test
	void testWithHook2() {
		ThrowingSupplier<Object> action = mock(ThrowingSupplier.class);
		when(action.get()).thenReturn("Get");
		assertEquals("Get", SpringApplication.withHook(null, action));
		verify(action).get();
	}
}

