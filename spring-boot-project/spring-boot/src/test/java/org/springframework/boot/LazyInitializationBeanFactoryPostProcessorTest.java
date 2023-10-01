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

import org.junit.jupiter.api.Test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.StringValueResolver;

class LazyInitializationBeanFactoryPostProcessorTest {
	/**
	 * Method under test: {@link LazyInitializationBeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)}
	 */
	@Test
	void testPostProcessBeanFactory() throws BeansException {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		LazyInitializationBeanFactoryPostProcessor lazyInitializationBeanFactoryPostProcessor = new LazyInitializationBeanFactoryPostProcessor();
		lazyInitializationBeanFactoryPostProcessor.postProcessBeanFactory(new DefaultListableBeanFactory());
	}

	/**
	 * Method under test: {@link LazyInitializationBeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)}
	 */
	@Test
	void testPostProcessBeanFactory2() throws BeansException {
		// TODO: Complete this test.
		//   Diffblue AI was unable to find a test

		LazyInitializationBeanFactoryPostProcessor lazyInitializationBeanFactoryPostProcessor = new LazyInitializationBeanFactoryPostProcessor();

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.addEmbeddedValueResolver(mock(StringValueResolver.class));
		lazyInitializationBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
	}

	/**
	 * Method under test: {@link LazyInitializationBeanFactoryPostProcessor#getOrder()}
	 */
	@Test
	void testGetOrder() {
		assertEquals(Integer.MIN_VALUE, (new LazyInitializationBeanFactoryPostProcessor()).getOrder());
	}
}

