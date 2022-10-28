package org.osgi.service.feature;

public interface BundleConflictHandler {
	public enum Resolution {
		USE_EXISTING, USE_NEW, USE_BOTH
	}

	Resolution resolveBundleConflict(Feature existingFeature,
			FeatureBundle existingBundle, Feature newFeature,
			FeatureBundle newBundle);
}
