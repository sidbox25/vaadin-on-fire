package org.vaadin.artur.firebase.ui.crud;

import org.vaadin.artur.firebase.db.UserDB;
import org.vaadin.artur.firebase.db.data.User;

import com.vaadin.data.Binder;
//import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.HorizontalLayout;

public class UserForm extends HorizontalLayout {
    private TextField fach = new TextField("fach");
    private TextField lehrer = new TextField("lehrer");
    private TextField start = new TextField("start");
    private TextField ende = new TextField("ende");
    private TextField beschreibung = new TextField("beschreibung");
    private Button save = new Button("Save");
    private String key;
    private Binder<User> binder;

    public UserForm() {
        addComponents(fach, lehrer, start, ende, beschreibung, save);
        binder = new Binder<>(User.class);
        //binder.forField(start)
        //        .withConverter(new StringToIntegerConverter(0, "Not a number"))
        //        .bind("start");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> {
            saveItem();
        });

        setEnabled(false);
    }

    public void newItem() {
        setItem(null, new User("", "", "", "", ""));
    }

    public void setItem(String key, User user) {
        this.key = key;
        binder.setBean(user);
        setEnabled(true);
        fach.focus();
    }

    private void saveItem() {
        User item = binder.getBean();
        if (key == null) {
            UserDB.add(item); 
        } else {
            UserDB.update(key, item);
        }
        setEnabled(false);
    }

    public void reset() {
        setEnabled(false);
        binder.setBean(new User());
        key = null;
    }

}
