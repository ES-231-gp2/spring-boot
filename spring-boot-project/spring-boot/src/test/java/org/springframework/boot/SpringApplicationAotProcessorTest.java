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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.context.aot.AbstractAotProcessor;

class SpringApplicationAotProcessorTest {
	/**
	 * Method under test: {@link SpringApplicationAotProcessor#SpringApplicationAotProcessor(Class, AbstractAotProcessor.Settings, String[])}
	 */
	@Test
	void testConstructor() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringApplicationAotProcessor.applicationArgs
		//     ContextAotProcessor.applicationClass
		//     AbstractAotProcessor.settings

		Class<Object> application = Object.class;
		new SpringApplicationAotProcessor(application, null, new String[] { "Application Args" });

	}

	/**
	 * Method under test: {@link SpringApplicationAotProcessor#prepareApplicationContext(Class)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testPrepareApplicationContext() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.RuntimeException: java.lang.Object.main([Ljava.lang.String;)
		//   java.lang.NoSuchMethodException: java.lang.Object.main([Ljava.lang.String;)
		//       at java.lang.Class.getMethod(Class.java:2227)
		//   See https://diff.blue/R013 to resolve this issue.

		Class<Object> application = Object.class;
		SpringApplicationAotProcessor springApplicationAotProcessor = new SpringApplicationAotProcessor(application, null,
				new String[] { "Application Args" });
		Class<Object> application2 = Object.class;
		springApplicationAotProcessor.prepareApplicationContext(application2);
	}
}

