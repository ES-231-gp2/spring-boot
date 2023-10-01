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

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.MutablePropertySources;

class ApplicationEnvironmentTest {
	/**
	 * Method under test: {@link ApplicationEnvironment#doGetActiveProfilesProperty()}
	 */
	@Test
	void testDoGetActiveProfilesProperty() {
		assertNull((new ApplicationEnvironment()).doGetActiveProfilesProperty());
	}

	/**
	 * Method under test: {@link ApplicationEnvironment#doGetDefaultProfilesProperty()}
	 */
	@Test
	void testDoGetDefaultProfilesProperty() {
		assertNull((new ApplicationEnvironment()).doGetDefaultProfilesProperty());
	}

	/**
	 * Method under test: {@link ApplicationEnvironment#createPropertyResolver(MutablePropertySources)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testCreatePropertyResolver() {
		// TODO: Complete this test.
		//   Reason: R005 Unable to load class.
		//   Class: joptsimple.OptionSet
		//   Please check that the class is available on your test runtime classpath.
		//   See https://diff.blue/R005 to resolve this issue.

		// Arrange
		// TODO: Populate arranged inputs
		ApplicationEnvironment applicationEnvironment = null;
		MutablePropertySources propertySources = null;

		// Act
		ConfigurablePropertyResolver actualCreatePropertyResolverResult = applicationEnvironment
				.createPropertyResolver(propertySources);

		// Assert
		// TODO: Add assertions on result
	}
}

