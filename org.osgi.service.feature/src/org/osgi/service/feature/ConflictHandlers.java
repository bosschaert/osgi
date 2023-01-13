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

public interface ConflictHandlers {
	/**
	 * A bundle conflict handler that always uses the new bundle.
	 * 
	 * @return A bundle conflict handler that always uses the new bundle
	 */
	BundleConflictHandler useNewBundle();

	BundleConflictHandler useExistingBundle();

	BundleConflictHandler useBothBundles();

	ConfigConflictHandler useNewConfig();

	ConfigConflictHandler useExistingConfig();

	ConfigConflictHandler mergeNewOnExistingConfig();

	ConfigConflictHandler mergeExistingOnNewConfig();

	ExtensionConflictHandler useNewExtension();

	ExtensionConflictHandler useExistingExtension();

	ExtensionConflictHandler appendExtensionContent();
}
