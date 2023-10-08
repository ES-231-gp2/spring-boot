/*
 * Copyright 2012-2022 the original author or authors.
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

package org.springframework.boot.cli.util;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.fusesource.jansi.AnsiRenderer.Code;

import org.springframework.boot.cli.command.shell.Shell;

/**
 * Simple logger used by the CLI.
 *
 * @author Phillip Webb
 * @since 1.0.0
 */
public abstract class Log {

	private static LogListener listener;

	public static void info(String message) {
		Logger logger
				= Logger.getLogger(
				Log.class.getName());
		logger.log(Level.INFO, message);
		if (listener != null) {
			listener.info(message);
		}
	}

	public static void infoPrint(String message) {
		Logger logger
				= Logger.getLogger(
				Log.class.getName());
		logger.log(Level.INFO, message);
		if (listener != null) {
			listener.infoPrint(message);
		}
	}

	public static void error(String message) {
		Logger logger
				= Logger.getLogger(
				Log.class.getName());
		logger.log(Level.INFO, message);
		if (listener != null) {
			listener.error(message);
		}
	}

	public static void error(Exception ex) {
		Logger logger
				= Logger.getLogger(
				Log.class.getName());
		logger.log(Level.SEVERE, System.err.toString());
		if (listener != null) {
			listener.error(ex);
		}
	}

	static void setListener(LogListener listener) {
		Log.listener = listener;
	}

}
