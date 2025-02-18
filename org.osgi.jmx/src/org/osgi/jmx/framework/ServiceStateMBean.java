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

package org.osgi.jmx.framework;

import java.io.IOException;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularType;
import org.osgi.jmx.Item;
import org.osgi.jmx.JmxConstants;

/**
 * This MBean represents the Service state of the framework. This MBean also
 * emits events that clients can use to get notified of the changes in the
 * service state of the framework.
 * 
 * @author $Id$
 * @ThreadSafe
 */
public interface ServiceStateMBean {
	/**
	 * The Object Name prefix for this mbean. The full object name also contains
	 * the framework name and uuid as properties.
	 */
	String			OBJECTNAME					= JmxConstants.OSGI_CORE + ":type=serviceState,version=1.7";
	/**
	 * The key BUNDLE_IDENTIFIER, used in {@link #BUNDLE_IDENTIFIER_ITEM}.
	 */
	String			BUNDLE_IDENTIFIER			= "BundleIdentifier";
	/**
	 * The item containing the bundle identifier in {@link #SERVICE_TYPE}. The
	 * key is {@link #BUNDLE_IDENTIFIER} and the type is {@link SimpleType#LONG}
	 * .
	 */
	Item			BUNDLE_IDENTIFIER_ITEM		= new Item(BUNDLE_IDENTIFIER, "The identifier of the bundle the service belongs to", SimpleType.LONG);

	/**
	 * The key OBJECT_CLASS, used {@link #OBJECT_CLASS_ITEM}.
	 */
	String			OBJECT_CLASS				= "objectClass";

	/**
	 * The item containing the interfaces of the service in
	 * {@link #SERVICE_TYPE}. The key is {@link #OBJECT_CLASS} and the type is
	 * {@link JmxConstants#STRING_ARRAY_TYPE}.
	 */
	Item			OBJECT_CLASS_ITEM			= new Item(OBJECT_CLASS, "An string array containing the interfaces under which the service has been registered", JmxConstants.STRING_ARRAY_TYPE);

	/**
	 * The key IDENTIFIER, used {@link #IDENTIFIER_ITEM}.
	 */
	String			IDENTIFIER					= "Identifier";

	/**
	 * The item containing the service identifier in {@link #SERVICE_TYPE}. The
	 * key is {@link #IDENTIFIER} and the type is {@link SimpleType#LONG}.
	 */
	Item			IDENTIFIER_ITEM				= new Item(IDENTIFIER, "The identifier of the service", SimpleType.LONG);

	/**
	 * The key PROPERTIES, used in {@link #PROPERTIES_ITEM}.
	 */
	String			PROPERTIES					= "Properties";

	/**
	 * The item containing service properties in {@link #SERVICE_TYPE}. The key
	 * is {@link #PROPERTIES} and the type is
	 * {@link JmxConstants#PROPERTIES_TYPE}.
	 */
	Item			PROPERTIES_ITEM				= new Item(PROPERTIES, "The service properties", JmxConstants.PROPERTIES_TYPE);

	/**
	 * The key USING_BUNDLES, used in {@link #USING_BUNDLES_ITEM}.
	 */
	String			USING_BUNDLES				= "UsingBundles";

	/**
	 * The item containing the bundles using the service in
	 * {@link #SERVICE_TYPE}. The key is {@link #USING_BUNDLES} and the type is
	 * {@link JmxConstants#LONG_ARRAY_TYPE}.
	 */
	Item			USING_BUNDLES_ITEM			= new Item(USING_BUNDLES, "The bundles using the service", JmxConstants.LONG_ARRAY_TYPE);

	/**
	 * The Composite Type for a CompositeData representing a service. This type
	 * consists of:
	 * <ul>
	 * <li>{@link #BUNDLE_IDENTIFIER}</li>
	 * <li>{@link #IDENTIFIER}</li>
	 * <li>{@link #OBJECT_CLASS}</li>
	 * <li>{@link #PROPERTIES}</li>
	 * <li>{@link #USING_BUNDLES}</li>
	 * </ul>
	 */
	CompositeType	SERVICE_TYPE				= Item.compositeType("SERVICE",
														"This type encapsulates an OSGi service",
														BUNDLE_IDENTIFIER_ITEM,
														IDENTIFIER_ITEM,
														OBJECT_CLASS_ITEM,
														PROPERTIES_ITEM,
														USING_BUNDLES_ITEM);

	/**
	 * The Tabular Type for a Service table. The rows consists of
	 * {@link #SERVICE_TYPE} Composite Data and the index is {@link #IDENTIFIER}
	 * .
	 */
	TabularType		SERVICES_TYPE				= Item.tabularType("SERVICES", "The table of all services", SERVICE_TYPE, IDENTIFIER);

	/**
	 * The key BUNDLE_LOCATION, used in {@link #SERVICE_EVENT_TYPE}.
	 */
	String			BUNDLE_LOCATION				= "BundleLocation";
	/**
	 * The item containing the bundle location in {@link #EVENT_ITEM}. The key
	 * is {@link #BUNDLE_LOCATION} and the the type is {@link SimpleType#STRING}
	 * .
	 */
	Item			BUNDLE_LOCATION_ITEM		= new Item(BUNDLE_LOCATION, "The location of the bundle", SimpleType.STRING);
	/**
	 * The key BUNDLE_SYMBOLIC_NAME, used in {@link #SERVICE_EVENT_TYPE}.
	 */
	String			BUNDLE_SYMBOLIC_NAME		= "BundleSymbolicName";

	/**
	 * The item containing the symbolic name in {@link #EVENT}. The key is
	 * {@link #BUNDLE_SYMBOLIC_NAME} and the the type is
	 * {@link SimpleType#STRING}.
	 */
	Item			BUNDLE_SYMBOLIC_NAME_ITEM	= new Item(BUNDLE_SYMBOLIC_NAME, "The symbolic name of the bundle", SimpleType.STRING);

	/**
	 * The key EVENT, used in {@link #EVENT_ITEM}.
	 */
	String			EVENT						= "ServiceEvent";

	/**
	 * The item containing the event type. The key is {@link #EVENT} and the
	 * type is {@link SimpleType#INTEGER}
	 */
	Item			EVENT_ITEM					= new Item(EVENT, "The eventType of the event: {REGISTERED=1, MODIFIED=2 UNREGISTERING=3}", SimpleType.INTEGER);

	/**
	 * The Composite Type that represents a service event. This composite
	 * consists of:
	 * <ul>
	 * <li>{@link #IDENTIFIER}</li>
	 * <li>{@link #OBJECT_CLASS}</li>
	 * <li>{@link #BUNDLE_LOCATION}</li>
	 * <li>{@link #BUNDLE_SYMBOLIC_NAME}</li>
	 * <li>{@link #EVENT}</li>
	 * </ul>
	 */
	CompositeType	SERVICE_EVENT_TYPE			= Item.compositeType("SERVICE_EVENT",
														"This type encapsulates OSGi service events",
														IDENTIFIER_ITEM,
														OBJECT_CLASS_ITEM,
														BUNDLE_IDENTIFIER_ITEM,
														BUNDLE_LOCATION_ITEM,
														BUNDLE_SYMBOLIC_NAME_ITEM,
														EVENT_ITEM);

	/**
	 * Answer the list of interfaces that this service implements
	 * 
	 * @param serviceId the identifier of the service
	 * @return the list of interfaces
	 * @throws IOException if the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	public String[] getObjectClass(long serviceId) throws IOException;

	/**
	 * Answer the bundle identifier of the bundle which registered the service
	 * 
	 * @param serviceId the identifier of the service
	 * @return the identifier for the bundle
	 * @throws IOException if the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	long getBundleIdentifier(long serviceId) throws IOException;

	/**
	 * Obtain information about a given service.
	 * 
	 * The result is defined by the CompositeType {@link #SERVICE_TYPE}.
	 * 
	 * @param serviceId the ID of the service to look up
	 * @return A CompositeData object with the service information
	 * @throws IOException if the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	CompositeData getService(long serviceId) throws IOException;

	/**
	 * Answer the map of properties associated with this service.
	 * 
	 * @see JmxConstants#PROPERTIES_TYPE for the details of the TabularType
	 * 
	 * @param serviceId the identifier of the service
	 * @return the table of properties. These include the standard mandatory
	 *         service.id and objectClass properties as defined in the
	 *         {@code org.osgi.framework.Constants} interface
	 * @throws IOException if the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	TabularData getProperties(long serviceId) throws IOException;

	/**
	 * Return a single property from the specified service.
	 * 
	 * @see JmxConstants#PROPERTY_TYPE for the details of the CompositeType.
	 * 
	 * @param serviceId the identifier of the service
	 * @param key the property key
	 * @return a CompositeData object holding the value and data type of the
	 *         property.
	 * @throws IOException if the operation fails
	 */
	CompositeData getProperty(long serviceId, String key) throws IOException;

	/**
	 * List all service IDs in the framework.
	 * 
	 * @return all the service ids in the framework.
	 * @throws IOException if the operation fails
	 */
	long[] getServiceIds() throws IOException;

	/**
	 * Answer the service state of the system in tabular form.
	 * 
	 * @see #SERVICES_TYPE for the details of the TabularType
	 * 
	 * @return the tabular representation of the service state
	 * @throws IOException If the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	TabularData listServices() throws IOException;

	/**
	 * Answer the service state of the system in tabular form. This method
	 * allows the specification of a class name and a filter to select services
	 * to be provided.
	 * 
	 * @see #SERVICES_TYPE for the details of the TabularType
	 * 
	 * @param clazz The class name with which the services were registered or
	 *        {@code null} for any class name.
	 * @param filter A filter expression to match the services or {@code null}
	 *        for no additional filter.
	 * @return the tabular representation of the service state
	 * @throws IOException If the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	TabularData listServices(String clazz, String filter) throws IOException;

	/**
	 * Answer the service state of the system in tabular form. Apart from class
	 * name and filter, this method allows the specification of a subset of the
	 * {@link #SERVICE_TYPE} items to be included in the result. Selecting only
	 * the relevant Service Type items may save bandwidth and improve
	 * performance over a remote connection.
	 * 
	 * @see #SERVICES_TYPE for the details of the TabularType
	 * 
	 * @param clazz The class name with which the services were registered or
	 *        {@code null} for any class name.
	 * @param filter A filter expression to match the services or {@code null}
	 *        for no additional filter.
	 * @param serviceTypeItems The names of the {@link #SERVICE_TYPE} items to
	 *        include in the result. For example "objectClass" or "Properties".
	 *        Note that the result always returns the "Identifier" item since
	 *        this serves as the key in the resulting table.
	 * @return the tabular representation of the service state
	 * @throws IOException If the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	TabularData listServices(String clazz, String filter, String... serviceTypeItems) throws IOException;

	/**
	 * Answer the list of identifiers of the bundles that use the service
	 * 
	 * @param serviceId the identifier of the service
	 * @return the list of bundle identifiers
	 * @throws IOException if the operation fails
	 * @throws IllegalArgumentException if the service indicated does not exist
	 */
	long[] getUsingBundles(long serviceId) throws IOException;

}
