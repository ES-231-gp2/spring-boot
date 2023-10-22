/*
 * Copyright 2012-2019 the original author or authors.
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

package smoketest.data.ldap;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleLdapApplication implements CommandLineRunner {

	private final PersonRepository repository;

	public SampleLdapApplication(PersonRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger
				= Logger.getLogger(
				SampleLdapApplication.class.getName());
		// fetch all people
		logger.log(Level.INFO, "People found with findAll():");
		logger.log(Level.INFO, "-------------------------------");
		for (Person person : this.repository.findAll()) {
			logger.log(Level.INFO, person.toString());
		}
		logger.log(Level.INFO, "");

		// fetch an individual person
		logger.log(Level.INFO, "Person found with findByPhone('+46 555-123456'):");
		logger.log(Level.INFO, "--------------------------------");
		logger.log(Level.INFO, this.repository.findByPhone("+46 555-123456").toString());
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleLdapApplication.class, args).close();
	}

}
