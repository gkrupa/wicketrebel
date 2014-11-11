/*
 * Copyright 2014 gkrupa.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.gkrupa.wicket.base;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public abstract class BasePanel<T> extends GenericPanel<T> {

	private static final long serialVersionUID = 1L;

	public BasePanel(String id) {
		super(id);
	}
	
	public BasePanel(String id, IModel<T> model) {
		super(id,model);
	}
}