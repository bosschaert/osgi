package org.osgi.service.feature.launcher;

/**
 * Exception thrown when the launcher isn't able to launch the Feature.
 */
public class LauncherException extends Exception {
	private static final long serialVersionUID = 1L;

	public enum Reason {
		/**
		 * No configuration admin found
		 */
		NO_CONFIG_ADMIN,

		/**
		 * Problem during bundle installation
		 */
		BUNDLE_INSTALLATION,

		/**
		 * Problem during bundle resolution
		 */
		BUNDLE_RESOLUTION,

		/**
		 * Problem during bundle activation
		 */
		BUNDLE_ACTIVATION,

		/**
		 * Problem with framework property
		 */
		FRAMEWORK_PROPERTY,

		/**
		 * Problem during framework initialisation
		 */
		FRAMEWORK_INIT,

		/**
		 * Problem during framework activation
		 */
		FRAMEWORK_ACTIVATION,

		/**
		 * Bundle conflict
		 */
		BUNDLE_CONFLICT,

		/**
		 * IO problem
		 */
		IO
	}

	private final Reason reason;

	public LauncherException(Reason reason, String message) {
		super(message);

		this.reason = reason;
	}

	public LauncherException(Reason reason, Throwable exception) {
		super(exception);

		this.reason = reason;
	}

	public LauncherException(Reason reason, String message,
			Throwable exception) {
		super(message, exception);

		this.reason = reason;
	}

	/**
	 * Get the reason for the exception;
	 *
	 * @return The reason
	 */
	public Reason getReason() {
		return reason;
	}
}