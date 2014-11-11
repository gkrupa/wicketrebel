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
package com.gkrupa.samples.rebel.wicket.pages.panels;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.IAjaxCallListener;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.gkrupa.wicket.base.BasePanel;

public class PanelOne extends BasePanel<PanelOneModel> {

	private static final long serialVersionUID = 1L;

	public PanelOne(String id) {
		super(id, new Model<PanelOneModel>(new PanelOneModel()));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final Form<Void> formOne = new Form<Void>("formOne");
		final Label nameLbl = new Label("nameLbl", new PropertyModel<String>(getModel(), "fullName"));
		nameLbl.setOutputMarkupId(true);
		
//		final TextField<String> firstName = new TextField<String>("firstName", new PropertyModel<String>(getModel(), "firstName"));
//		firstName.add(new AjaxFormSubmitBehavior(formOne, "onkeyup") {
//			private static final long serialVersionUID = 1L;
//			@Override
//			protected void onSubmit(AjaxRequestTarget target) {
//				target.add(nameLbl);
//				getModelObject().setFirstName(firstName.getValue());
//			}
//			
//			@Override
//			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
//				super.updateAjaxAttributes(attributes);
//				IAjaxCallListener listener = new AjaxCallListener() {
//					private static final long serialVersionUID = 1L;
//					
//					@Override
//					public CharSequence getAfterHandler(Component component) {
//						return "console.log('Hello World "+ getModelObject().getFullName() + "');";
//					}
//				};
//				attributes.getAjaxCallListeners().add(listener);
//			}
//		});
		
		final TextField<String> lastName = new TextField<String>("lastName", new PropertyModel<String>(getModel(), "lastName"));
		lastName.add(new AjaxFormSubmitBehavior(formOne, "onkeyup") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				target.add(nameLbl);
				getModelObject().setLastName(lastName.getValue());
			}
		});

		final TextField<Integer> age = new TextField<Integer>("age", new PropertyModel<Integer>(getModel(), "age"));
		age.add(new AjaxFormSubmitBehavior(formOne, "change") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				target.add(nameLbl);
			}
			
			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				IAjaxCallListener listener = new AjaxCallListener() {
					private static final long serialVersionUID = 1L;
					
					@Override
					public CharSequence getAfterHandler(Component component) {
						return "console.log('Hello World "+ getModelObject().getFullName() + "');";
					}
				};
				attributes.getAjaxCallListeners().add(listener);
			}
		});
		
		
//		formOne.add(firstName);
		formOne.add(lastName);
		formOne.add(age);
		formOne.add(nameLbl);
		add(formOne);
	}

}