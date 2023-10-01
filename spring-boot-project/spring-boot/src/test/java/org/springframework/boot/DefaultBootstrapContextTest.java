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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

class DefaultBootstrapContextTest {
	/**
	 * Method under test: {@link DefaultBootstrapContext#register(Class, BootstrapRegistry.InstanceSupplier)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRegister() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: InstanceSupplier must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		defaultBootstrapContext.register(type, null);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#register(Class, BootstrapRegistry.InstanceSupplier)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRegister2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: InstanceSupplier must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		Class<Object> type = Object.class;
		defaultBootstrapContext.register(type, null);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#registerIfAbsent(Class, BootstrapRegistry.InstanceSupplier)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRegisterIfAbsent() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: InstanceSupplier must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		defaultBootstrapContext.registerIfAbsent(type, null);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#registerIfAbsent(Class, BootstrapRegistry.InstanceSupplier)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testRegisterIfAbsent2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: InstanceSupplier must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		Class<Object> type = Object.class;
		defaultBootstrapContext.registerIfAbsent(type, null);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#isRegistered(Class)}
	 */
	@Test
	void testIsRegistered() {
		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		assertFalse(defaultBootstrapContext.isRegistered(type));
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#isRegistered(Class)}
	 */
	@Test
	void testIsRegistered2() {
		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		Class<Object> type = Object.class;
		assertFalse(defaultBootstrapContext.isRegistered(type));
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getRegisteredInstanceSupplier(Class)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetRegisteredInstanceSupplier() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		BootstrapRegistry.InstanceSupplier<Object> actualRegisteredInstanceSupplier = defaultBootstrapContext
				.getRegisteredInstanceSupplier(type);
		actualRegisteredInstanceSupplier.get(new DefaultBootstrapContext());
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getRegisteredInstanceSupplier(Class)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetRegisteredInstanceSupplier2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		Class<Object> type = Object.class;
		BootstrapRegistry.InstanceSupplier<Object> actualRegisteredInstanceSupplier = defaultBootstrapContext
				.getRegisteredInstanceSupplier(type);
		actualRegisteredInstanceSupplier.get(new DefaultBootstrapContext());
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#addCloseListener(ApplicationListener)}
	 */
	@Test
	void testAddCloseListener() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     DefaultBootstrapContext.events
		//     DefaultBootstrapContext.instanceSuppliers
		//     DefaultBootstrapContext.instances

		(new DefaultBootstrapContext()).addCloseListener(mock(ApplicationListener.class));
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#get(Class)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGet() throws IllegalStateException {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "java.lang.Class.getName()" because "type" is null
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		defaultBootstrapContext.get(null);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getOrElse(Class, Object)}
	 */
	@Test
	void testGetOrElse() {
		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		assertEquals("Other", defaultBootstrapContext.getOrElse(type, "Other"));
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getOrElse(Class, Object)}
	 */
	@Test
	void testGetOrElse2() {
		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(mock(ApplicationListener.class));
		Class<Object> type = Object.class;
		assertEquals("Other", defaultBootstrapContext.getOrElse(type, "Other"));
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getOrElseSupply(Class, Supplier)}
	 */
	@Test
	void testGetOrElseSupply() {
		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		Supplier<Object> other = mock(Supplier.class);
		when(other.get()).thenReturn("Get");
		assertEquals("Get", defaultBootstrapContext.getOrElseSupply(type, other));
		verify(other).get();
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#getOrElseThrow(Class, Supplier)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testGetOrElseThrow() throws Throwable {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.Throwable
		//   See https://diff.blue/R013 to resolve this issue.

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		Class<Object> type = Object.class;
		Supplier<Throwable> exceptionSupplier = mock(Supplier.class);
		when(exceptionSupplier.get()).thenReturn(new Throwable());
		defaultBootstrapContext.getOrElseThrow(type, exceptionSupplier);
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#close(ConfigurableApplicationContext)}
	 */
	@Test
	void testClose() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     DefaultBootstrapContext.events
		//     DefaultBootstrapContext.instanceSuppliers
		//     DefaultBootstrapContext.instances

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.close(new AnnotationConfigReactiveWebApplicationContext());
	}

	/**
	 * Method under test: {@link DefaultBootstrapContext#close(ConfigurableApplicationContext)}
	 */
	@Test
	void testClose2() {
		ApplicationListener<BootstrapContextClosedEvent> listener = mock(ApplicationListener.class);
		doNothing().when(listener).onApplicationEvent(Mockito.<BootstrapContextClosedEvent>any());

		DefaultBootstrapContext defaultBootstrapContext = new DefaultBootstrapContext();
		defaultBootstrapContext.addCloseListener(listener);
		defaultBootstrapContext.close(new AnnotationConfigReactiveWebApplicationContext());
		verify(listener).onApplicationEvent(Mockito.<BootstrapContextClosedEvent>any());
	}
}

