package com.agile;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.agile.pages.HomePage;

public class WicketApplication extends WebApplication {

	public WicketApplication() {
		
	}
	
	protected SpringComponentInjector getSpringInjector(){
		return new SpringComponentInjector(this);
	}
	
	@Override
	protected void init() {
		super.init();
		
		getComponentInstantiationListeners().add(getSpringInjector());
	}
	
	@Override
	public Class<? extends Page> getHomePage() {
		
		return HomePage.class;
	}

}
