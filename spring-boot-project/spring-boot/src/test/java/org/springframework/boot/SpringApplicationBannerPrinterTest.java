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

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.apache.commons.logging.Log;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.aot.hint.RuntimeHints;

import org.springframework.boot.logging.DeferredLog;
import org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedWebappClassLoader;

import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

class SpringApplicationBannerPrinterTest {
	/**
	 * Method under test: {@link SpringApplicationBannerPrinter#SpringApplicationBannerPrinter(ResourceLoader, Banner)}
	 */
	@Test
	void testConstructor() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     SpringApplicationBannerPrinter.fallbackBanner
		//     SpringApplicationBannerPrinter.resourceLoader

		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		new SpringApplicationBannerPrinter(resourceLoader, new SpringBootBanner());

	}

	/**
	 * Method under test: {@link SpringApplicationBannerPrinter#print(Environment, Class, PrintStream)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testPrint() throws FileNotFoundException {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access files (file 'foo', permission 'write').
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		SpringApplicationBannerPrinter springApplicationBannerPrinter = new SpringApplicationBannerPrinter(resourceLoader,
				new SpringBootBanner());
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		Banner actualPrintResult = springApplicationBannerPrinter.print(environment, sourceClass, new PrintStream("foo"));
		ApplicationEnvironment environment2 = new ApplicationEnvironment();
		Class<Object> sourceClass2 = Object.class;
		actualPrintResult.printBanner(environment2, sourceClass2, new PrintStream("foo"));
	}

	/**
	 * Method under test: {@link SpringApplicationBannerPrinter#print(Environment, Class, Log)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testPrint2() throws FileNotFoundException {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access files (file 'foo', permission 'write').
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		AnnotationConfigReactiveWebApplicationContext resourceLoader = new AnnotationConfigReactiveWebApplicationContext();
		SpringApplicationBannerPrinter springApplicationBannerPrinter = new SpringApplicationBannerPrinter(resourceLoader,
				new SpringBootBanner());
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		Banner actualPrintResult = springApplicationBannerPrinter.print(environment, sourceClass, new DeferredLog());
		ApplicationEnvironment environment2 = new ApplicationEnvironment();
		Class<Object> sourceClass2 = Object.class;
		actualPrintResult.printBanner(environment2, sourceClass2, new PrintStream("foo"));
	}

	/**
	 * Method under test: {@link SpringApplicationBannerPrinter.SpringApplicationBannerPrinterRuntimeHints#registerHints(RuntimeHints, ClassLoader)}
	 */
	@Test
	void testSpringApplicationBannerPrinterRuntimeHintsRegisterHints() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		SpringApplicationBannerPrinter.SpringApplicationBannerPrinterRuntimeHints springApplicationBannerPrinterRuntimeHints = new SpringApplicationBannerPrinter.SpringApplicationBannerPrinterRuntimeHints();
		RuntimeHints hints = new RuntimeHints();
		springApplicationBannerPrinterRuntimeHints.registerHints(hints, new TomcatEmbeddedWebappClassLoader());
	}
}

