package com.agile.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public BasePage() {
		add(new Link<Void>("list") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new ListPeoplePage());
			}
		});
		
		add(new Link<Void>("add"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new AddPersonPage());	
			}
		});
	}

}
