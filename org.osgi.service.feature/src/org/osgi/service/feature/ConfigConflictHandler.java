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
 * Handler to resolve configuration merge conflicts.
 */
public interface ConfigConflictHandler {
	/**
	 * This method is called when a configuration conflict needs to be resolved.
	 * A configuration conflict happens when two features are merged which both
	 * have the same PID in their configurations.
	 * 
	 * @param existingFeature The existing feature
	 * @param existingConfig The existing configuration
	 * @param newFeature The new feature
	 * @param newConfig The new configuration
	 * @return The resulting configuration
	 */
	FeatureConfiguration resolveConfigConflict(Feature existingFeature,
			FeatureConfiguration existingConfig, Feature newFeature,
			FeatureConfiguration newConfig);
}
