package net.springsocial.context.support;

/**
 * Provides a Facebook comments model.  The fields of this class correspond
 * directly with FBML attributes for Facebook's 
 * <a href="http://wiki.developers.facebook.com/index.php/Fb:comments">fb:comments</a> tag.
 * 
 * 
 * @author Scott Rossillo
 *
 */
public class FacebookCommentsModel {
	
	private final String xid;
	
	private boolean canPost;
	private boolean canDelete;
	private boolean showForm;
	
	private int numPosts;
	
	private Long notifyUid;
	
	private String title;
	
	private String returnUrl;
	
	/**
	 * Constructs a new Facebook comments model with the given comments id (xid).
	 * 
	 * @param xid the unique comments identifier for this comment model
	 * containing alphanumeric characters (Aa-Zz, 0-9), hyphens (-) and underscores (_) only 
	 */
	public FacebookCommentsModel(String xid) {
		this.xid = xid;
		this.canDelete = false;
		this.canPost = true;
		this.showForm = true;
	}

	/**
	 * Returns true if the comments support posting.
	 * 
	 * @return <code>true</code> if the comments support posting;
	 * <code>false</code> otherwise
	 */
	public boolean isCanPost() {
		return canPost;
	}

	/**
	 * Sets whether or not comments may be posted.
	 * 
	 * @param canPost <code>true</code> to allow comment posting
	 */
	public void setCanPost(boolean canPost) {
		this.canPost = canPost;
	}

	/**
	 * Returns true if the current user can delete comments.
	 * 
	 * @return <code>true</code> if the current user can delete comments
	 * <code>false</code> otherwise
	 */
	public boolean isCanDelete() {
		return canDelete;
	}

	/**
	 * Sets whether or not the current user can delete comments.
	 * 
	 * @param canDelete <code>true</code> to allow the current user
	 * to delete comments
	 */
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	/**
	 * Returns true if the comments form will be shown on the current view
	 * or should be displayed only on a Facebook hosted comments page.
	 * 
	 * @return <code>true</code> if the comments form should be shown on the
	 * current request; <code>false</code> otherwise
	 */
	public boolean isShowForm() {
		return showForm;
	}

	/**
	 * Sets whether or not the view should contain the comments posting form.
	 * 
	 * @param showForm <code>true</code> to display the comments posting form
	 */
	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	/**
	 * Returns the number of comments to be displayed.
	 * 
	 * @return the number of comments to be displayed
	 */
	public int getNumPosts() {
		return numPosts;
	}

	/**
	 * Sets the number of comments to be displayed.
	 * 
	 * @param numPosts the number of comments to be displayed
	 */
	public void setNumPosts(int numPosts) {
		this.numPosts = numPosts;
	}

	/**
	 * Returns the uid of the user who should be notified of new comment posts.
	 * 
	 * @return the uid of the user to be notified of new comment posts
	 */
	public Long getNotifyUid() {
		return notifyUid;
	}

	/**
	 * Sets the uid to notify of new comment posts.
	 * 
	 * @param notifyUid the uid to notify of new posts
	 */
	public void setNotifyUid(Long notifyUid) {
		this.notifyUid = notifyUid;
	}

	/**
	 * Returns the title of the comments box.
	 * 
	 * @return the comment's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the comments box.
	 * 
	 * @param title the title to use for the comments box
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the unique comments id for this comments model.
	 * 
	 * @return the unique comments id
	 */
	public String getXid() {
		return xid;
	}

	/**
	 * Returns the URL to be returned to after posting or viewing
	 * all comments.
	 * 
	 * @return the URL to return to after posting or viewing all
	 * comments 
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * Sets the URL to return to after viewing all comments or posting a comment;
	 * default to the current URL.
	 * 
	 * @param returnUrl the URl to return to after posting or viewing all comments
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

}
