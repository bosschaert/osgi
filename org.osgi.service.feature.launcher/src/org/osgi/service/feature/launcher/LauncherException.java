package org.osgi.service.feature.launcher;

/**
 * Exception thrown when the launcher isn't able to launch the Feature.
 */
public class LauncherException extends Exception {
	private static final long serialVersionUID = 1L;

	public enum Reason {
		NO_CONFIG_ADMIN,

		BUNDLE_INSTALLATION, BUNDLE_RESOLUTION, BUNDLE_ACTIVATION,

		FRAMEWORK_PROPERTY, FRAMEWORK_INIT, FRAMEWORK_ACTIVATION,

		BUNDLE_CONFLICT, IO
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