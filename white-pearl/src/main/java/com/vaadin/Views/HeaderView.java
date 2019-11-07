package com.vaadin.Views;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class HeaderView extends VerticalLayout {

	
	public HeaderView()
	{
	MenuBar barmenu = new MenuBar();
	add(barmenu);
	// A top-level menu item that opens a submenu
	MenuItem drinks = barmenu.addItem("Home");
	barmenu.addItem(drinks);

	}
}
