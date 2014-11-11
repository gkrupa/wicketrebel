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
package com.gkrupa.samples.rebel.wicket.pages;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.gkrupa.wicket.base.BasePage;

public class HomePage extends BasePage<HomePageModel> {
	
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
    }
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new Link<Void>("gotoPanelsLink") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(PanelsPage.class);
			}
		});
	}
}