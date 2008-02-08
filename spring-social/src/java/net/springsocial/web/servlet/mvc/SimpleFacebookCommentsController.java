package net.springsocial.web.servlet.mvc;


import net.springsocial.context.support.FacebookCommentsModel;
import net.springsocial.web.servlet.http.FacebookHttpServletRequest;

public class SimpleFacebookCommentsController extends AbstractFacebookCommentsController {

	private String title;
	private String xid;
	
	public SimpleFacebookCommentsController() { }
	
	@Override
	protected FacebookCommentsModel createCommentsModel(
			FacebookHttpServletRequest request) {
		
		FacebookCommentsModel model = new FacebookCommentsModel(this.getXid());
		
		model.setTitle(this.getTitle());
		
		return model;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getXid() {
		return xid;
	}


	public void setXid(String xid) {
		this.xid = xid;
	}

}
