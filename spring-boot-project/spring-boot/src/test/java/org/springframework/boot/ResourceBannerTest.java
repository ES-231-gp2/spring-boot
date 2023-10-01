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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.boot.origin.OriginTrackedResource;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.origin.TextResourceOrigin;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

class ResourceBannerTest {
	/**
	 * Method under test: {@link ResourceBanner#ResourceBanner(Resource)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access files (file 'foo', permission 'write').
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner actualResourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		actualResourceBanner.printBanner(environment, sourceClass, new PrintStream("foo"));
	}

	/**
	 * Method under test: {@link ResourceBanner#ResourceBanner(Resource)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor2() throws FileNotFoundException {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access files (file 'foo', permission 'write').
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		ResourceBanner actualResourceBanner = new ResourceBanner(null);
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		actualResourceBanner.printBanner(environment, sourceClass, new PrintStream("foo"));
	}

	/**
	 * Method under test: {@link ResourceBanner#printBanner(Environment, Class, PrintStream)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testPrintBanner() throws FileNotFoundException, UnsupportedEncodingException {
		// TODO: Complete this test.
		//   Reason: R011 Sandboxing policy violation.
		//   Diffblue Cover ran code in your project that tried
		//     to access files (file 'foo', permission 'write').
		//   Diffblue Cover's default sandboxing policy disallows this in order to prevent
		//   your code from damaging your system environment.
		//   See https://diff.blue/R011 to resolve this issue.

		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		resourceBanner.printBanner(environment, sourceClass, new PrintStream("foo"));
	}

	/**
	 * Method under test: {@link ResourceBanner#getPropertyResolvers(Environment, Class)}
	 */
	@Test
	void testGetPropertyResolvers() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		assertEquals(1, resourceBanner.getPropertyResolvers(environment, sourceClass).size());
	}

	/**
	 * Method under test: {@link ResourceBanner#getPropertyResolvers(Environment, Class)}
	 */
	@Test
	void testGetPropertyResolvers2() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		assertEquals(1, resourceBanner.getPropertyResolvers(new ApplicationEnvironment(), null).size());
	}

	/**
	 * Method under test: {@link ResourceBanner#getPropertyResolvers(Environment, Class)}
	 */
	@Test
	void testGetPropertyResolvers3() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		Resource resource2 = mock(Resource.class);
		OriginTrackedResource resource3 = OriginTrackedResource.of(resource2,
				new SystemEnvironmentOrigin("systemEnvironment"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new TextResourceOrigin(resource3, new TextResourceOrigin.Location(2, 1))));
		ApplicationEnvironment environment = new ApplicationEnvironment();
		Class<Object> sourceClass = Object.class;
		assertEquals(1, resourceBanner.getPropertyResolvers(environment, sourceClass).size());
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationTitle(Class)}
	 */
	@Test
	void testGetApplicationTitle() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		Class<Object> sourceClass = Object.class;
		assertNull(resourceBanner.getApplicationTitle(sourceClass));
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationTitle(Class)}
	 */
	@Test
	void testGetApplicationTitle2() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		assertNull((new ResourceBanner(OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property"))))
				.getApplicationTitle(null));
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationTitle(Class)}
	 */
	@Test
	void testGetApplicationTitle3() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		Resource resource2 = mock(Resource.class);
		OriginTrackedResource resource3 = OriginTrackedResource.of(resource2, new SystemEnvironmentOrigin("Property"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new TextResourceOrigin(resource3, new TextResourceOrigin.Location(2, 1))));
		Class<Object> sourceClass = Object.class;
		assertNull(resourceBanner.getApplicationTitle(sourceClass));
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationVersion(Class)}
	 */
	@Test
	void testGetApplicationVersion() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property")));
		Class<Object> sourceClass = Object.class;
		assertNull(resourceBanner.getApplicationVersion(sourceClass));
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationVersion(Class)}
	 */
	@Test
	void testGetApplicationVersion2() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		assertNull((new ResourceBanner(OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property"))))
				.getApplicationVersion(null));
	}

	/**
	 * Method under test: {@link ResourceBanner#getApplicationVersion(Class)}
	 */
	@Test
	void testGetApplicationVersion3() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		Resource resource2 = mock(Resource.class);
		OriginTrackedResource resource3 = OriginTrackedResource.of(resource2, new SystemEnvironmentOrigin("Property"));
		ResourceBanner resourceBanner = new ResourceBanner(
				OriginTrackedResource.of(resource, new TextResourceOrigin(resource3, new TextResourceOrigin.Location(2, 1))));
		Class<Object> sourceClass = Object.class;
		assertNull(resourceBanner.getApplicationVersion(sourceClass));
	}

	/**
	 * Method under test: {@link ResourceBanner#getBootVersion()}
	 */
	@Test
	void testGetBootVersion() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		assertEquals("3.2.0-SNAPSHOT",
				(new ResourceBanner(OriginTrackedResource.of(resource, new SystemEnvironmentOrigin("Property"))))
						.getBootVersion());
	}

	/**
	 * Method under test: {@link ResourceBanner#getBootVersion()}
	 */
	@Test
	void testGetBootVersion2() throws UnsupportedEncodingException {
		ByteArrayResource resource = new ByteArrayResource("AXAXAXAX".getBytes("UTF-8"));
		Resource resource2 = mock(Resource.class);
		OriginTrackedResource resource3 = OriginTrackedResource.of(resource2, new SystemEnvironmentOrigin("Property"));
		assertEquals("3.2.0-SNAPSHOT", (new ResourceBanner(
				OriginTrackedResource.of(resource, new TextResourceOrigin(resource3, new TextResourceOrigin.Location(2, 1)))))
				.getBootVersion());
	}
}

