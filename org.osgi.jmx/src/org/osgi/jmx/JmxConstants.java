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

package org.osgi.jmx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.management.openmbean.ArrayType;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularType;

/**
 * Constants for OSGi JMX Specification.
 * 
 * Additionally, this class contains a number of utility types that are used in
 * different places in the specification. These are {@link #LONG_ARRAY_TYPE},
 * {@link #STRING_ARRAY_TYPE}, and {@link #PROPERTIES_TYPE}.
 * 
 * @author $Id$
 * @Immutable
 */
public class JmxConstants {

	/*
	 * Empty constructor to make sure this is not used as an object.
	 */
	private JmxConstants() {
		// empty
	}

	/**
	 * The MBean Open type for an array of strings
	 */
	public static final ArrayType<String[]>	STRING_ARRAY_TYPE	= Item
			.arrayType(1, SimpleType.STRING);
	/**
	 * The MBean Open type for an array of longs
	 */
	public static final ArrayType<Long[]>	LONG_ARRAY_TYPE		= Item
			.arrayType(1, SimpleType.LONG);

	/**
	 * For an encoded array we need to start with ARRAY_OF. This must be
	 * followed by one of the names in {@link #SCALAR}.
	 * 
	 */
	public final static String			ARRAY_OF			= "Array of ";

	/**
	 * For an encoded vector we need to start with ARRAY_OF. This must be
	 * followed by one of the names in {@link #SCALAR}.
	 */
	public final static String			VECTOR_OF			= "Vector of ";

	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.String}
	 */
	public static final String			STRING				= "String";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Integer}
	 */
	public static final String			INTEGER				= "Integer";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Long}
	 */
	public static final String			LONG				= "Long";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Float}
	 */
	public static final String			FLOAT				= "Float";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Double}
	 */
	public static final String			DOUBLE				= "Double";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Byte}
	 */
	public static final String			BYTE				= "Byte";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Short}
	 */
	public static final String			SHORT				= "Short";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Character}
	 */
	public static final String			CHARACTER			= "Character";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.lang.Boolean}
	 */
	public static final String			BOOLEAN				= "Boolean";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.math.BigDecimal}
	 */
	public static final String			BIGDECIMAL			= "BigDecimal";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of
	 * {@link java.math.BigInteger}
	 */
	public static final String			BIGINTEGER			= "BigInteger";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of {@code Version}
	 * 
	 * @since 1.1
	 */
	public static final String			VERSION				= "Version";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code double}
	 * primitive type.
	 */
	public static final String			P_DOUBLE			= "double";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code float}
	 * primitive type.
	 */
	public static final String			P_FLOAT				= "float";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code long}
	 * primitive type.
	 */
	public static final String			P_LONG				= "long";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code int}
	 * primitive type.
	 */
	public static final String			P_INT				= "int";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code short}
	 * primitive type.
	 */
	public static final String			P_SHORT				= "short";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code byte}
	 * primitive type.
	 */
	public static final String			P_BYTE				= "byte";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code char}
	 * primitive type.
	 */
	public static final String			P_CHAR				= "char";
	/**
	 * Value for {@link #PROPERTY_TYPE} value in the case of the {@code boolean}
	 * primitive type.
	 */
	public static final String			P_BOOLEAN			= "boolean";

	/**
	 * A set of all scalars that can be used in the {@link #TYPE} property of a
	 * {@link #PROPERTIES_TYPE}. This contains the following names:
	 * <ul>
	 * <li>{@link #BIGDECIMAL}</li>
	 * <li>{@link #BIGINTEGER}</li>
	 * <li>{@link #BOOLEAN}</li>
	 * <li>{@link #BYTE}</li>
	 * <li>{@link #CHARACTER}</li>
	 * <li>{@link #DOUBLE}</li>
	 * <li>{@link #FLOAT}</li>
	 * <li>{@link #INTEGER}</li>
	 * <li>{@link #LONG}</li>
	 * <li>{@link #SHORT}</li>
	 * <li>{@link #STRING}</li>
	 * <li>{@link #VERSION}</li>
	 * <li>{@link #P_BYTE}</li>
	 * <li>{@link #P_CHAR}</li>
	 * <li>{@link #P_DOUBLE}</li>
	 * <li>{@link #P_FLOAT}</li>
	 * <li>{@link #P_INT}</li>
	 * <li>{@link #P_LONG}</li>
	 * <li>{@link #P_SHORT}</li>
	 */
	public final static List<String>	SCALAR				= Collections.unmodifiableList(Arrays.asList(STRING,
																	INTEGER,
																	LONG,
																	FLOAT,
																	DOUBLE,
																	BYTE,
																	SHORT,
																	CHARACTER,
																	BOOLEAN,
																	BIGDECIMAL,
																	BIGINTEGER,
																	VERSION,
																	P_BYTE,
																	P_CHAR,
																	P_SHORT,
																	P_INT,
																	P_LONG,
																	P_DOUBLE,
																	P_FLOAT));
	/**
	 * The key KEY.
	 */
	public static final String			KEY					= "Key";
	/**
	 * The key of a property. The key is {@link #KEY} and the type is
	 * {@link SimpleType#STRING}.
	 */
	public static final Item			KEY_ITEM			= new Item(KEY, "The key of the property", SimpleType.STRING);

	/**
	 * The key VALUE.
	 */
	public static final String			VALUE				= "Value";

	/**
	 * The value of a property. The key is {@link #VALUE} and the type is
	 * {@link SimpleType#STRING}. A value will be encoded by the string given in
	 * {@link #TYPE}. The syntax for this type is given in {@link #TYPE_ITEM}.
	 */
	public static final Item			VALUE_ITEM			= new Item(VALUE, "The value of the property", SimpleType.STRING);

	/**
	 * The key TYPE.
	 */
	public static final String			TYPE				= "Type";

	/**
	 * The type of the property. The key is {@link #TYPE} and the type is
	 * {@link SimpleType#STRING}. This string must follow the following syntax:
	 * <p/>
	 * 
	 * <pre>
	 * type      ::= {@link #SCALAR scalar} | vector | array
	 * vector    ::= 'Vector of' scalar
	 * array     ::= 'Array of' (scalar | primitive)
	 * scalar    ::= '{@link #STRING String}' | '{@link #BIGINTEGER BigInteger}' | '{@link #BIGDECIMAL BigDecimal}'
	 *              | '{@link #BYTE Byte}' | '{@link #CHARACTER Character}' | '{@link #SHORT Short}'
	 *              | '{@link #INTEGER Integer}' | '{@link #LONG Long}' | '{@link #FLOAT Float}'
	 *              | '{@link #DOUBLE Double}' | '{@link #VERSION Version}'
	 * primitive ::= '{@link #P_BYTE byte}' | '{@link #P_CHAR char}' | '{@link #P_SHORT short}'
	 *              | '{@link #P_INT int}' | '{@link #P_LONG long}' | '{@link #P_FLOAT float}'
	 *              | '{@link #P_DOUBLE double}'
	 * </pre>
	 * 
	 * This encoding does not support arrays in vectors or arrays. Arrays and
	 * vectors can only contain scalars. List properties are encoded as arrays.
	 * Empty lists, arrays or vectors are not represented. Null is not an
	 * allowed value.
	 * <p/>
	 * 
	 * For example, the encoding of a byte array <tt>byte[] {1,2,3,5,7}</tt>
	 * would look like:
	 * 
	 * <pre>
	 *   type:  'Array of byte'
	 *   value: 1,2,3,5,7
	 * </pre>
	 * 
	 * Quoting can be used as follows:
	 * 
	 * <pre>
	 *   type:  'Array of String'
	 *   value: 'abc', 'def', '\'quoted\'', "'quoted'", "\\"
	 * </pre>
	 */
	public static final Item			TYPE_ITEM			= new Item(TYPE,
																	"The type of the property",
																	SimpleType.STRING,
																	STRING,
																	INTEGER,
																	LONG,
																	FLOAT,
																	DOUBLE,
																	BYTE,
																	SHORT,
																	CHARACTER,
																	BOOLEAN,
																	BIGDECIMAL,
																	BIGINTEGER,
																	VERSION,
																	P_DOUBLE,
																	P_FLOAT,
																	P_LONG,
																	P_INT,
																	P_SHORT,
																	P_CHAR,
																	P_BYTE,
																	P_BOOLEAN);

	/**
	 * A Composite Type describing a a single property. A property consists of
	 * the following items {@link #KEY_ITEM}, {@link #VALUE_ITEM}, and
	 * {@link #TYPE_ITEM}.
	 */
	public static final CompositeType	PROPERTY_TYPE		= Item.compositeType("PROPERTY", "This type encapsulates a key/value pair with a type identifier", KEY_ITEM, VALUE_ITEM, TYPE_ITEM);

	/**
	 * Describes a map with properties. The row type is {@link #PROPERTY_TYPE}.
	 * The index is defined to the {@link #KEY} of the property.
	 */
	public static final TabularType		PROPERTIES_TYPE		= Item.tabularType("PROPERTIES", "A table of PROPERTY", PROPERTY_TYPE, KEY);

	/**
	 * The domain name of the core OSGi MBeans
	 */
	public static final String			OSGI_CORE			= "osgi.core";

	/**
	 * The domain name of the selected OSGi compendium MBeans
	 */
	public static final String			OSGI_COMPENDIUM		= "osgi.compendium";
}
