package org.osgi.service.feature;

public interface FeatureMerger {
	void setBundleConflictHandler(BundleConflictHandler bch);

	Feature merge(ID newID, Feature f1, Feature... features);
}
