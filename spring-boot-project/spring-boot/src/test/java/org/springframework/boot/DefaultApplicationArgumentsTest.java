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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class DefaultApplicationArgumentsTest {
	/**
	 * Method under test: {@link DefaultApplicationArguments#DefaultApplicationArguments(String[])}
	 */
	@Test
	void testConstructor() {
		DefaultApplicationArguments actualDefaultApplicationArguments = new DefaultApplicationArguments("Args");
		assertEquals(1, actualDefaultApplicationArguments.getNonOptionArgs().size());
		assertTrue(actualDefaultApplicationArguments.getOptionNames().isEmpty());
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#DefaultApplicationArguments(String[])}
	 */
	@Test
	void testConstructor3() {
		DefaultApplicationArguments actualDefaultApplicationArguments = new DefaultApplicationArguments("foo");
		assertEquals(1, actualDefaultApplicationArguments.getNonOptionArgs().size());
		assertTrue(actualDefaultApplicationArguments.getOptionNames().isEmpty());
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#getSourceArgs()}
	 */
	@Test
	void testGetSourceArgs() {
		assertArrayEquals(new String[] { "Args" }, (new DefaultApplicationArguments("Args")).getSourceArgs());
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#getOptionNames()}
	 */
	@Test
	void testGetOptionNames() {
		assertTrue((new DefaultApplicationArguments("Args")).getOptionNames().isEmpty());
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#containsOption(String)}
	 */
	@Test
	void testContainsOption() {
		assertFalse((new DefaultApplicationArguments("Args")).containsOption("Name"));
		assertTrue((new DefaultApplicationArguments("Args")).containsOption("nonOptionArgs"));
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#getOptionValues(String)}
	 */
	@Test
	void testGetOptionValues() {
		assertNull((new DefaultApplicationArguments("Args")).getOptionValues("Name"));
		assertNull((new DefaultApplicationArguments("Args")).getOptionValues("foo"));
	}

	/**
	 * Method under test: {@link DefaultApplicationArguments#getNonOptionArgs()}
	 */
	@Test
	void testGetNonOptionArgs() {
		List<String> actualNonOptionArgs = (new DefaultApplicationArguments("Args")).getNonOptionArgs();
		assertEquals(1, actualNonOptionArgs.size());
		assertEquals("Args", actualNonOptionArgs.get(0));
	}
}
