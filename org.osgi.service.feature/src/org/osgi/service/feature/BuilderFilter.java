package org.osgi.service.feature;

public interface BuilderFilter {
	default FeatureBundle filterBundle(Feature f, FeatureBundle bundle) {
		return bundle;
	}

	default FeatureConfiguration filterConfiguration(Feature f,
			FeatureConfiguration config) {
		return config;
	}
}
