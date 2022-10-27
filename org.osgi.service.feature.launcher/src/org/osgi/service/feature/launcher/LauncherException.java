package org.osgi.service.feature.launcher;

/**
 * Exception thrown when the launcher isn't able to launch the Feature.
 */
public class LauncherException extends Exception {
	private static final long serialVersionUID = 1L;

	enum Reason {
		NoConfigAdmin,

		BundleResolution, BundleActivation,

		FrameworkProperty

	}

	private final Reason reason;

	LauncherException(Reason reason, String message) {
		super(message);

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
