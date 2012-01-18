package com.agile.pages;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.agile.data.dao.interfaces.PersonDao;
import com.agile.data.dataobjects.Person;

public class ListPeoplePage extends BasePage {

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	PersonDao personDao;
	
	public ListPeoplePage() {
		add(new ListView<Person>("personList", new PropertyModel<List<Person>>(this, "personDao.findAll")){

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Person> item) {
				Person person = item.getModelObject();
				item.add(new Label("firstName", person.getFirstName()));
				item.add(new Label("lastName", person.getLastName()));
			}
			
		});
	}

}
