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

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SpringBootExceptionHandlerTest {
	/**
	 * Methods under test:
	 *
	 * <ul>
	 *   <li>{@link SpringBootExceptionHandler#SpringBootExceptionHandler(Thread.UncaughtExceptionHandler)}
	 *   <li>{@link SpringBootExceptionHandler#registerExitCode(int)}
	 * </ul>
	 */
	@Test
	void testConstructor() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent

		(new SpringBootExceptionHandler(new ThreadGroup("foo"))).registerExitCode(1);
	}

	/**
	 * Method under test: {@link SpringBootExceptionHandler#registerLoggedException(Throwable)}
	 */
	@Test
	void testRegisterLoggedException() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent

		SpringBootExceptionHandler springBootExceptionHandler = new SpringBootExceptionHandler(new ThreadGroup("foo"));
		springBootExceptionHandler.registerLoggedException(new Throwable());
	}

	/**
	 * Method under test: {@link SpringBootExceptionHandler#uncaughtException(Thread, Throwable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testUncaughtException() {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access the network.
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		SpringBootExceptionHandler springBootExceptionHandler = null;
		Thread thread = null;
		Throwable ex = null;

		// Act
		springBootExceptionHandler.uncaughtException(thread, ex);

		// Assert
		// TODO: Add assertions on result
	}

	/**
	 * Method under test: {@link SpringBootExceptionHandler#forCurrentThread()}
	 */
	@Test
	void testForCurrentThread() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent

		SpringBootExceptionHandler actualForCurrentThreadResult = SpringBootExceptionHandler.forCurrentThread();
		Thread thread = new Thread();
		actualForCurrentThreadResult.uncaughtException(thread, new Throwable());
	}

	/**
	 * Method under test: {@link SpringBootExceptionHandler#forCurrentThread()}
	 */
	@Test
	void testForCurrentThread2() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent
		//     SpringBootExceptionHandler.exitCode
		//     SpringBootExceptionHandler.loggedExceptions
		//     SpringBootExceptionHandler.parent

		SpringBootExceptionHandler actualForCurrentThreadResult = SpringBootExceptionHandler.forCurrentThread();
		Thread thread = new Thread(mock(Runnable.class), "foo");

		actualForCurrentThreadResult.uncaughtException(thread, new Throwable());
	}
}

