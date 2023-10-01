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

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.boot.logging.DeferredLog;

class StartupInfoLoggerTest {
	/**
	 * Method under test: {@link StartupInfoLogger#StartupInfoLogger(Class)}
	 */
	@Test
	void testConstructor() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     StartupInfoLogger.sourceClass

		Class<Object> sourceClass = Object.class;
		new StartupInfoLogger(sourceClass);
	}

	/**
	 * Method under test: {@link StartupInfoLogger#logStarting(Log)}
	 */
	@Test
	void testLogStarting() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     StartupInfoLogger.sourceClass

		Class<Object> sourceClass = Object.class;
		StartupInfoLogger startupInfoLogger = new StartupInfoLogger(sourceClass);
		startupInfoLogger.logStarting(new DeferredLog());
	}

	/**
	 * Method under test: {@link StartupInfoLogger#logStarted(Log, Duration)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testLogStarted() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.NullPointerException: Cannot invoke "java.time.Duration.toMillis()" because "timeTakenToStartup" is null
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> sourceClass = Object.class;
		StartupInfoLogger startupInfoLogger = new StartupInfoLogger(sourceClass);
		startupInfoLogger.logStarted(new DeferredLog(), null);
	}
}

