package org.vaadin.artur.grid_extra_button;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;

@JavaScript("GridButtonExtension.js")
public class GridButtonExtension extends AbstractJavaScriptExtension {

    public GridButtonExtension(Grid grid) {
        super(grid);
        addFunction("clicked", arguments -> {
            Notification.show("You clicked the button");

        });

    }

}
