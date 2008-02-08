package net.springsocial.web.servlet.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.springsocial.context.support.FacebookCommentsModel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

/**
 * Provides a view to render an FBML comments tag as the only view output.
 * 
 * For information on why this view is necessary, see the
 * <a href="http://wiki.developers.facebook.com/index.php/Fb:comments">fb:comments</a>
 * documentation.
 * 
 * @author Scott Rossillo
 * 
 * @since 1.0
 *
 */
public class FacebookCommentsCallbackView extends AbstractView implements View {

	private final Log log = LogFactory.getLog(FacebookCommentsCallbackView.class);
	
	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(
			Map model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FacebookCommentsModel comments = (FacebookCommentsModel) model.get("comments");
		String commentsTag = createCommentsTag(comments);
		
		if(log.isInfoEnabled()) {
			log.info("Rendering comments callback view: \n" + commentsTag);
		}
		
		response.getWriter().println(commentsTag);
	}
	
	/**
	 * Creates a Facebook comments tag.
	 * 
	 * @param comments
	 * @return
	 */
	protected String createCommentsTag(FacebookCommentsModel comments) {
		
		StringBuffer buf = new StringBuffer(2000);
		
		buf.append("<fb:comments ");
		buf.append("xid='").append(comments.getXid()).append("' ");
		buf.append("canpost='").append(comments.isCanPost()).append("' ");
		
		buf.append("candelete='").append(comments.isCanDelete()).append("' ");
		buf.append("showform='").append(comments.isShowForm()).append("' ");
		
		if(comments.getNotifyUid() != null) {
			buf.append("send_notification_uid='").append(comments.getNotifyUid()).append("' ");
		}
		
		buf.append('>');
		
		buf.append("<fb:title>").append(comments.getTitle()).append("</fb:title>");
		
		buf.append("</fb:comments>");
		
		return buf.toString();
	}

}
