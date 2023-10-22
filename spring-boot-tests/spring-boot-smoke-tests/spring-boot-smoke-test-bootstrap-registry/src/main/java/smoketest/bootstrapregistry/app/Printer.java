/*
 * Copyright 2012-2020 the original author or authors.
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

package smoketest.bootstrapregistry.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import smoketest.bootstrapregistry.external.svn.SubversionClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Printer {

	Printer(@Value("${svn}") String svn, SubversionClient subversionClient) {
		Logger logger
				= Logger.getLogger(
				Printer.class.getName());
		logger.log(Level.INFO, "--- svn " + svn);
		logger.log(Level.INFO, "--- client " + subversionClient.getClass().getName());
	}

}
