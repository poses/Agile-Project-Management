package com.agile.pages;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.agile.data.dao.interfaces.PersonDao;
import com.agile.data.dataobjects.Person;

public class AddPersonPage extends BasePage {

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private PersonDao personDao;
	
	public AddPersonPage() {
		final Form<Person> personForm = new Form<Person>("personForm", new CompoundPropertyModel<Person>(new Person()));
		personForm.add(new TextField<String>("firstName").setRequired(true));
		personForm.add(new TextField<String>("lastName").setRequired(true));
		
		personForm.add(new SubmitLink("submit"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();
				
				Person person = personForm.getModelObject();
				personDao.save(person);
				
				setResponsePage(new ListPeoplePage());
			}
		});
		
		add(personForm);
	}

}
