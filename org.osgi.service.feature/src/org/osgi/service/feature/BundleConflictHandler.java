/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/
package org.osgi.service.feature;

/**
 * Handler to resolve bundle merge conflicts.
 */
public interface BundleConflictHandler {
	/**
	 * Possible resolutions to a bundle conflict.
	 */
	public enum Resolution {
		/**
		 * Use the existing bundle.
		 */
		USE_EXISTING,

		/**
		 * Use thew new bundle
		 */
		USE_NEW,

		/**
		 * Use both bundles
		 */
		USE_BOTH
	}

	/**
	 * This method is called when a bundle conflict needs to be resolved. A
	 * bundle conflict happens when two features are merged which contain
	 * bundles with the same group ID and the same artifact ID, but different
	 * versions.
	 * 
	 * @param existingFeature The existing feature
	 * @param existingBundle The existing bundle
	 * @param newFeature The new feature
	 * @param newBundle The new bundle
	 * @return The resolution to the conflict
	 */
	Resolution resolveBundleConflict(Feature existingFeature,
			FeatureBundle existingBundle, Feature newFeature,
			FeatureBundle newBundle);
}
