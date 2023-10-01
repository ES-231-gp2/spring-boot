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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import org.springframework.core.env.ConfigurableEnvironment;

import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

class DefaultPropertiesPropertySourceTest {
	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#DefaultPropertiesPropertySource(Map)}
	 */
	@Test
	void testConstructor() {
		DefaultPropertiesPropertySource actualDefaultPropertiesPropertySource = new DefaultPropertiesPropertySource(
				new HashMap<>());
		assertEquals(DefaultPropertiesPropertySource.NAME, actualDefaultPropertiesPropertySource.getName());
		assertTrue(actualDefaultPropertiesPropertySource.getSource().isEmpty());
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#hasMatchingName(PropertySource)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testHasMatchingName() {
		// TODO: Complete this test.
		//   Reason: R005 Unable to load class.
		//   Class: joptsimple.OptionSet
		//   Please check that the class is available on your test runtime classpath.
		//   See https://diff.blue/R005 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		PropertySource<?> propertySource = null;

		// Act
		boolean actualHasMatchingNameResult = DefaultPropertiesPropertySource.hasMatchingName(propertySource);

		// Assert
		// TODO: Add assertions on result
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#ifNotEmpty(Map, Consumer)}
	 */
	@Test
	void testIfNotEmpty() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		DefaultPropertiesPropertySource.ifNotEmpty(new HashMap<>(), mock(Consumer.class));
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#ifNotEmpty(Map, Consumer)}
	 */
	@Test
	void testIfNotEmpty2() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		DefaultPropertiesPropertySource.ifNotEmpty(null, null);
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#ifNotEmpty(Map, Consumer)}
	 */
	@Test
	void testIfNotEmpty3() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		DefaultPropertiesPropertySource.ifNotEmpty(null, mock(Consumer.class));
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#ifNotEmpty(Map, Consumer)}
	 */
	@Test
	void testIfNotEmpty4() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		DefaultPropertiesPropertySource.ifNotEmpty(new HashMap<>(), null);
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#addOrMerge(Map, MutablePropertySources)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddOrMerge() {
		// TODO: Complete this test.
		//   Reason: R005 Unable to load class.
		//   Class: joptsimple.OptionSet
		//   Please check that the class is available on your test runtime classpath.
		//   See https://diff.blue/R005 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		Map<String, Object> source = null;
		MutablePropertySources sources = null;

		// Act
		DefaultPropertiesPropertySource.addOrMerge(source, sources);

		// Assert
		// TODO: Add assertions on result
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#moveToEnd(ConfigurableEnvironment)}
	 */
	@Test
	void testMoveToEnd() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		DefaultPropertiesPropertySource.moveToEnd(new ApplicationEnvironment());
	}

	/**
	 * Method under test: {@link DefaultPropertiesPropertySource#moveToEnd(MutablePropertySources)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testMoveToEnd2() {
		// TODO: Complete this test.
		//   Reason: R005 Unable to load class.
		//   Class: joptsimple.OptionSet
		//   Please check that the class is available on your test runtime classpath.
		//   See https://diff.blue/R005 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		MutablePropertySources propertySources = null;

		// Act
		DefaultPropertiesPropertySource.moveToEnd(propertySources);

		// Assert
		// TODO: Add assertions on result
	}
}

