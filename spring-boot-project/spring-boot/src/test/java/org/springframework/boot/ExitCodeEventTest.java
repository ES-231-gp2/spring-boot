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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExitCodeEventTest {
	/**
	 * Method under test: {@link ExitCodeEvent#ExitCodeEvent(Object, int)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testConstructor() {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		// Arrange
		// TODO: Populate arranged inputs
		Object object = null;
		int exitCode = 0;

		// Act
		ExitCodeEvent actualExitCodeEvent = new ExitCodeEvent(object, exitCode);

		// Assert
		// TODO: Add assertions on result
	}

	/**
	 * Method under test: {@link ExitCodeEvent#getExitCode()}
	 */
	@Test
	void testGetExitCode() {
		assertEquals(1, (new ExitCodeEvent("Source", 1)).getExitCode());
	}
}

