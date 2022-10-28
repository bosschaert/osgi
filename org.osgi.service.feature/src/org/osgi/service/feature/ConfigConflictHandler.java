package org.osgi.service.feature;

public interface ConfigConflictHandler {
	public enum Resolution {
		USE_EXISTING, USE_NEW, MERGE_NEW_ON_EXISTING, MERGE_EXISTING_ON_NEW
	}

	Resolution resolveConfigConflict(Feature existingFeature,
			FeatureConfiguration existingConfig, Feature newFeature,
			FeatureConfiguration newConfig);
}
