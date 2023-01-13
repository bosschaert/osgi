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
 * A feature merger can merge two or more features together into a new feature.
 * Such merge operation can cause conflicts. To handle conflicts, conflict
 * handlers can be registered.
 */
public interface FeatureMerger {
	/**
	 * Obtain a convenience class that can provide pre-defined conflict
	 * handlers.
	 * 
	 * @return a Conflict Handlers instance
	 */
	ConflictHandlers getConflictHandlers();

	/**
	 * Register a bundle conflict handler.
	 * 
	 * @param bch The bundle conflict handler
	 */
	void setBundleConflictHandler(BundleConflictHandler bch);

	/**
	 * Register a configuration conflict handler.
	 * 
	 * @param cch The configuration conflict handler
	 */
	void setConfigConflictHandler(ConfigConflictHandler cch);

	/**
	 * Reigster an extension conflict handler.
	 * 
	 * @param ech The extension conflict handler
	 */
	void setExtensionConflictHandler(ExtensionConflictHandler ech);

	/**
	 * Merge multiple features into one.
	 * 
	 * @param newID The new ID for the feature to create.
	 * @param feature The first feature
	 * @param features The remaining features to merge
	 * @return The merged features
	 * @throws MergeException If there is an unhandled merge conflict.
	 */
	Feature merge(ID newID, Feature feature, Feature... features)
			throws MergeException;
}
