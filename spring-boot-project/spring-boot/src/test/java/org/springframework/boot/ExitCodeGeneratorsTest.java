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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.MappingIterator;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExitCodeGeneratorsTest {
	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Iterable)}
	 */
	@Test
	void testAddAll() {
		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		Iterable<ExitCodeGenerator> generators = mock(Iterable.class);
		MappingIterator<ExitCodeGenerator> emptyIteratorResult = MappingIterator.emptyIterator();
		when(generators.iterator()).thenReturn(emptyIteratorResult);
		exitCodeGenerators.addAll(generators);
		verify(generators).iterator();
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, Iterable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Exception must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();

		LinkedHashSet<? extends ExitCodeExceptionMapper> mappers = new LinkedHashSet<>();
		mappers.add(null);
		exitCodeGenerators.addAll(null, mappers);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, Iterable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Exception must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll(null, (Iterable<? extends ExitCodeExceptionMapper>) null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, Iterable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Exception must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll(null, mock(Iterable.class));
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, Iterable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll5() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mapper must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		Throwable exception = new Throwable();

		LinkedHashSet<? extends ExitCodeExceptionMapper> mappers = new LinkedHashSet<>();
		mappers.add(null);
		exitCodeGenerators.addAll(exception, mappers);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, Iterable)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll6() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mappers must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), (Iterable<? extends ExitCodeExceptionMapper>) null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, ExitCodeExceptionMapper[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll7() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mapper must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, ExitCodeExceptionMapper[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll8() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Exception must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll(null, (ExitCodeExceptionMapper[]) null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, ExitCodeExceptionMapper[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll9() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Exception must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll(null, null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, ExitCodeExceptionMapper[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll10() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mappers must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), (ExitCodeExceptionMapper[]) null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(Throwable, ExitCodeExceptionMapper[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll11() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mapper must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		exitCodeGenerators.addAll(new Throwable(), null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(ExitCodeGenerator[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll12() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Generator must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll(null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(ExitCodeGenerator[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll13() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Generators must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).addAll((ExitCodeGenerator[]) null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#addAll(ExitCodeGenerator[])}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAddAll14() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Generator must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		exitCodeGenerators.addAll(null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#add(Throwable, ExitCodeExceptionMapper)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAdd() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mapper must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.add(new Throwable(), null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#add(Throwable, ExitCodeExceptionMapper)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAdd2() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Mapper must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		exitCodeGenerators.add(new Throwable(), null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#add(ExitCodeGenerator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAdd3() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Generator must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		(new ExitCodeGenerators()).add(null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#add(ExitCodeGenerator)}
	 */
	@Test
	@Disabled("TODO: Complete this test")
	void testAdd4() {
		// TODO: Complete this test.
		//   Reason: R013 No inputs found that don't throw a trivial exception.
		//   Diffblue Cover tried to run the arrange/act section, but the method under
		//   test threw
		//   java.lang.IllegalArgumentException: Generator must not be null
		//   See https://diff.blue/R013 to resolve this issue.

		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		exitCodeGenerators.add(null);
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#iterator()}
	 */
	@Test
	void testIterator() {
		// TODO: Complete this test.
		//   Reason: R002 Missing observers.
		//   Diffblue Cover was unable to create an assertion.
		//   Add getters for the following fields or make them package-private:
		//     Itr.cursor
		//     Itr.expectedModCount
		//     Itr.lastRet
		//     Itr.this$0

		(new ExitCodeGenerators()).iterator();
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#iterator()}
	 */
	@Test
	void testIterator2() {
		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		exitCodeGenerators.iterator();
		verify(mappers).iterator();
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#getExitCode()}
	 */
	@Test
	void testGetExitCode() {
		assertEquals(0, (new ExitCodeGenerators()).getExitCode());
	}

	/**
	 * Method under test: {@link ExitCodeGenerators#getExitCode()}
	 */
	@Test
	void testGetExitCode2() {
		Iterable<ExitCodeExceptionMapper> mappers = mock(Iterable.class);
		MappingIterator<ExitCodeExceptionMapper> emptyIteratorResult = MappingIterator.emptyIterator();
		when(mappers.iterator()).thenReturn(emptyIteratorResult);

		ExitCodeGenerators exitCodeGenerators = new ExitCodeGenerators();
		exitCodeGenerators.addAll(new Throwable(), mappers);
		assertEquals(0, exitCodeGenerators.getExitCode());
		verify(mappers).iterator();
	}
}

