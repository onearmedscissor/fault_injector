package faultinjector.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CreateFaultload32Action extends ActionSupport
{
	private static final long serialVersionUID = 4L;

	private List<String> accessTypes;

	public CreateFaultload32Action()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add("read");
		accessTypes.add("write");
	}

	public String execute()
	{
		return SUCCESS;
	}

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}
}
