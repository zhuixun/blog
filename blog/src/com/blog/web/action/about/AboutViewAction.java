package com.blog.web.action.about;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;
import com.blog.bean.about.About;
import com.blog.service.about.AboutService;
import com.blog.web.formbean.about.AboutForm;

@Controller("/about/view")
public class AboutViewAction extends Action {
	@Resource(name="aboutServiceBean")
	private AboutService aboutService;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		AboutForm formbean=(AboutForm) form;
		About about=aboutService.find(formbean.getId());
		request.setAttribute("about", about);
        return mapping.findForward("about");
    }
}