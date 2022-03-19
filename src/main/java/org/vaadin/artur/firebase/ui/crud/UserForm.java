package org.vaadin.artur.firebase.ui.crud;

import org.vaadin.artur.firebase.db.UserDB;
import org.vaadin.artur.firebase.db.data.User;

import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.HorizontalLayout;

public class UserForm extends HorizontalLayout {
    private TextField name = new TextField("Name");
    private TextField age = new TextField("Age");
    private TextField size = new TextField("Size");
    private TextField about = new TextField("About");
    private Button save = new Button("Save");
    private String key;
    private Binder<User> binder;

    public UserForm() {
        addComponents(name, age, size, about, save);
        binder = new Binder<>(User.class);
        binder.forField(age)
                .withConverter(new StringToIntegerConverter(0, "Not a number"))
                .bind("age");
        binder.forField(size)
                .withConverter(new StringToIntegerConverter(0, "Not a number"))
                .bind("size");
        binder.bindInstanceFields(this);

        save.addClickListener(e -> {
            saveItem();
        });

        setEnabled(false);
    }

    public void newItem() {
        setItem(null, new User("", 0, 0, ""));
    }

    public void setItem(String key, User user) {
        this.key = key;
        binder.setBean(user);
        setEnabled(true);
        name.focus();
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
