package es.uca.iw.wp.spring.AdminZone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.treegrid.TreeGrid;

import es.uca.iw.wp.Entity.User;
import es.uca.iw.wp.Repository.UserRepository;

@Secured("admin")
public class UserManage extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8613023743986289489L;
	
	private FormLayout _oColumnLayout;
	private TextField _txtFirstName, _txtLastName;
	private PasswordField _oPwdPassword;
	private Select<String> _oSlctValueSelect;
	private Button _oBtnNewUser, _oBtnShowUsers;
	private Grid<User> oGrid;
	
	private UserRepository _oUsrRepository;
	private PasswordEncoder _oPasswordEncoder;
	
	
	private void initializeView()
	{
		_oColumnLayout = new FormLayout();
		// Setting the desired responsive steps for the columns in the layout
		_oColumnLayout.setResponsiveSteps(
		           new ResponsiveStep("25em", 1),
		           new ResponsiveStep("32em", 2),
		           new ResponsiveStep("40em", 3));
		
		_txtFirstName = new TextField();
	    _txtFirstName.setPlaceholder("First Name");
	    _txtLastName = new TextField();
	    _txtLastName.setPlaceholder("Last Name");
	    _oPwdPassword = new PasswordField("User pass");
	    
	    _oSlctValueSelect = new Select<>();
	    _oSlctValueSelect.setItems("admin", "manager", "user");
	    _oSlctValueSelect.setValue("admin");
	    
	    _oBtnNewUser = new Button("Register");
	    _oBtnShowUsers = new Button("Show Users");
	    
	    oGrid = new Grid<>();
	    
	    
	    
	    //oGrid.getTreeData().addItems(lstUser.get(0), lstUser);
		   
	    _oColumnLayout.add(_txtFirstName, _txtLastName, _oPwdPassword, _oSlctValueSelect);
	    add(_oColumnLayout, _oBtnNewUser, oGrid, _oBtnShowUsers);
	}
	
	public UserManage(UserRepository oUsrRepository, PasswordEncoder oPasswordEncoder) 
	{
		initializeView();
		
		_oUsrRepository = oUsrRepository;
		_oPasswordEncoder = oPasswordEncoder;
		
		_oBtnNewUser.addClickListener(e->{
			
			if(_txtFirstName.getValue().equals("") || 
					_txtLastName.getValue().equals("") || 
					_oPwdPassword.getValue().equals(""))
			{
				Notification.show("Fields are required");
			}
			else
			{
				User oUser = new User();
				oUser.setName(_txtFirstName.getValue());
				oUser.setLastName(_txtLastName.getValue());
				oUser.setPassword(_oPasswordEncoder.encode(_oPwdPassword.getValue()));
				oUser.setRole(_oSlctValueSelect.getValue());
				
				_oUsrRepository.save(oUser);
				Notification.show("User added to our System.");
			}
		});
		
		_oBtnShowUsers.addClickListener(e->{
			List<User> oLstUser = _oUsrRepository.findAll();
			
			oGrid.removeAllColumns();
			
			oGrid.setItems(oLstUser);
			oGrid.addColumn(User::getName).setHeader("Name");
			oGrid.addColumn(User::getLastName).setHeader("Last Name");
			oGrid.addColumn(User::getRole).setHeader("Rol");
			//oGrid.getTreeData().addItems(oLstUser.get(0), oLstUser);
		});
	}
	
}
