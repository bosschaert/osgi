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

package org.osgi.util.promise;

import static java.util.Objects.requireNonNull;

import org.osgi.annotation.versioning.ProviderType;

/**
 * A Deferred Promise resolution.
 * 
 * <p>
 * Instances of this class can be used to create a {@link Promise} that can be
 * resolved in the future. The {@link #getPromise() associated} Promise can be
 * successfully resolved with {@link #resolve(Object)} or resolved with a
 * failure with {@link #fail(Throwable)}. It can also be resolved with the
 * resolution of another promise using {@link #resolveWith(Promise)}.
 * 
 * <p>
 * The associated Promise can be provided to any one, but the Deferred object
 * should be made available only to the party that will responsible for
 * resolving the Promise.
 * 
 * @param <T> The value type associated with the created Promise.
 * 
 * @Immutable
 * @author $Id$
 */
@ProviderType
public class Deferred<T> {
	/**
	 * The Promise associated with this Deferred.
	 */
	private final DeferredPromiseImpl<T> promise;

	/**
	 * Create a new Deferred.
	 * <p>
	 * The {@link #getPromise() associated promise} will use the default
	 * callback executor and default scheduled executor.
	 * 
	 * @see PromiseFactory#deferred()
	 */
	public Deferred() {
		this(PromiseFactory.defaultFactory);
	}

	/**
	 * Create a new Deferred with the specified callback and scheduled
	 * executors.
	 * 
	 * @param factory The factory to use for callbacks and scheduled operations.
	 * @since 1.1
	 */
	Deferred(PromiseFactory factory) {
		promise = new DeferredPromiseImpl<>(factory);
	}

	/**
	 * Returns the Promise associated with this Deferred.
	 * <p>
	 * All Promise objects created by the associated Promise will use the
	 * executors of the associated Promise.
	 * 
	 * @return The Promise associated with this Deferred.
	 */
	public Promise<T> getPromise() {
		return promise;
	}

	/**
	 * Successfully resolve the Promise associated with this Deferred.
	 * 
	 * <p>
	 * After the associated Promise is resolved with the specified value, all
	 * registered {@link Promise#onResolve(Runnable) callbacks} are called and
	 * any {@link Promise#then(Success, Failure) chained} Promises are resolved.
	 * This may occur asynchronously to this method.
	 * <p>
	 * Resolving the associated Promise <i>happens-before</i> any registered
	 * callback is called. That is, in a registered callback,
	 * {@link Promise#isDone()} must return {@code true} and
	 * {@link Promise#getValue()} and {@link Promise#getFailure()} must not
	 * block.
	 * 
	 * @param value The value of the resolved Promise.
	 * @throws IllegalStateException If the associated Promise was already
	 *         resolved.
	 */
	public void resolve(T value) {
		promise.resolve(value, null);
	}

	/**
	 * Fail the Promise associated with this Deferred.
	 * 
	 * <p>
	 * After the associated Promise is resolved with the specified failure, all
	 * registered {@link Promise#onResolve(Runnable) callbacks} are called and
	 * any {@link Promise#then(Success, Failure) chained} Promises are resolved.
	 * This may occur asynchronously to this method.
	 * <p>
	 * Resolving the associated Promise <i>happens-before</i> any registered
	 * callback is called. That is, in a registered callback,
	 * {@link Promise#isDone()} must return {@code true} and
	 * {@link Promise#getValue()} and {@link Promise#getFailure()} must not
	 * block.
	 * 
	 * @param failure The failure of the resolved Promise. Must not be
	 *        {@code null}.
	 * @throws IllegalStateException If the associated Promise was already
	 *         resolved.
	 */
	public void fail(Throwable failure) {
		promise.resolve(null, requireNonNull(failure));
	}

	/**
	 * Resolve the Promise associated with this Deferred with the specified
	 * Promise.
	 * 
	 * <p>
	 * If the specified Promise is successfully resolved, the associated Promise
	 * is resolved with the value of the specified Promise. If the specified
	 * Promise is resolved with a failure, the associated Promise is resolved
	 * with the failure of the specified Promise.
	 * 
	 * <p>
	 * After the associated Promise is resolved with the specified Promise, all
	 * registered {@link Promise#onResolve(Runnable) callbacks} are called and
	 * any {@link Promise#then(Success, Failure) chained} Promises are resolved.
	 * This may occur asynchronously to this method.
	 * <p>
	 * Resolving the associated Promise <i>happens-before</i> any registered
	 * callback is called. That is, in a registered callback,
	 * {@link Promise#isDone()} must return {@code true} and
	 * {@link Promise#getValue()} and {@link Promise#getFailure()} must not
	 * block.
	 * 
	 * @param with A Promise whose value or failure must be used to resolve the
	 *        associated Promise. Must not be {@code null}.
	 * @return A Promise that is resolved only when the associated Promise is
	 *         resolved by the specified Promise. The returned Promise must be
	 *         successfully resolved with the value {@code null}, if the
	 *         associated Promise was resolved by the specified Promise. The
	 *         returned Promise must be resolved with a failure of
	 *         {@link IllegalStateException}, if the associated Promise was
	 *         already resolved when the specified Promise was resolved.
	 */
	public Promise<Void> resolveWith(Promise<? extends T> with) {
		return promise.resolveWith(with);
	}

	/**
	 * Returns a string representation of the associated Promise.
	 * 
	 * @return A string representation of the associated Promise.
	 * @since 1.1
	 */
	@Override
	public String toString() {
		return promise.toString();
	}
}
