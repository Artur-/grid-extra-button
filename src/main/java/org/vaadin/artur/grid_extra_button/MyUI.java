package org.vaadin.artur.grid_extra_button;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("valo")
public class MyUI extends UI {
    public static class Person {
        private String name;
        private int age;

        public Person() {
            name = "Peter Pan";
            age = 13;
        }
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        getPage().getStyles().add(
                ".v-grid-sidebar.v-contextmenu.open .v-grid-sidebar-button {width: auto !important;}");
        BeanItemContainer<Person> dataSource = new BeanItemContainer<>(
                Person.class);
        for (int i = 0; i < 100; i++) {
            dataSource.addBean(new Person());
        }
        Grid grid = new Grid(dataSource);
        grid.getColumns().forEach(column -> column.setHidable(true));
        layout.addComponent(grid);
        setContent(layout);

        new GridButtonExtension(grid);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
