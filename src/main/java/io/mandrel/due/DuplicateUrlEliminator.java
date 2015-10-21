/*
 * Licensed to Mandrel under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Mandrel licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.mandrel.due;

import io.mandrel.common.loader.NamedDefinition;
import io.mandrel.common.service.ObjectFactory;
import io.mandrel.common.service.TaskContext;
import io.mandrel.common.service.TaskContextAware;
import io.mandrel.monitor.health.Checkable;

import java.io.Serializable;
import java.net.URI;
import java.util.Collection;
import java.util.Set;

public abstract class DuplicateUrlEliminator extends TaskContextAware implements Checkable {

	public DuplicateUrlEliminator(TaskContext context) {
		super(context);
	}

	public interface DuplicateUrlEliminatorDefinition extends NamedDefinition, ObjectFactory<DuplicateUrlEliminator>, Serializable {

	}
	
	public abstract void markAsPending(URI uri);

	public abstract void removePending(URI uri);

	public abstract Set<URI> filterPendings(Collection<URI> uris);

	public abstract Set<URI> deduplicate(Collection<URI> uris);
}
