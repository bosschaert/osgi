package org.osgi.service.feature.launcher;

import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

/**
 * A launcher can launch a Feature to become a running system. The launcher is
 * created for a Feature using the LauncherFactory.
 */
public interface Launcher {
	/**
	 * Return a framework factory suited to launch the feature in. This factory
	 * satisfies the framework related requirements in the feature such as the
	 * minimum framework API version and the framework implementation if
	 * specified.
	 * 
	 * @return The framework factory or {@code null} if the launcher cannot find
	 *         a framework.
	 */
	FrameworkFactory findFrameworkFactory();

	/**
	 * Create a new framework with the framework launching properties as
	 * specified in the Feature.
	 * 
	 * @param factory The framework factory to use.
	 * @return The started framework.
	 */
	Framework createFramework(FrameworkFactory factory);

	/**
	 * Launch the Feature in the Framework provided.
	 * 
	 * @param framework The Framework the Feature is launched into.
	 * @throws LauncherException If an issue happens during launching
	 */
	void launch(Framework framework) throws LauncherException;
}
