package com.blog.web.action.about;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.blog.bean.about.About;
import com.blog.service.about.AboutService;
import com.blog.web.action.article.BuildHtmlFile;


@Controller("/control/about/manage")
public class AboutAction extends DispatchAction {
	@Resource(name="aboutServiceBean")
	private AboutService aboutService;
	
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("add");
    }

	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        About about=new About();
        about.setContent(request.getParameter("myContent"));
        aboutService.save(about);
        request.setAttribute("message","添加成功");
        request.setAttribute("urladdress", "/control/article/manage.do?method=list");
		File saveDir = new File(request.getSession().getServletContext().getRealPath("/html/about/"));
		BuildHtmlFile.createAboutHtml(about, saveDir);
        return mapping.findForward("message");
    }
}