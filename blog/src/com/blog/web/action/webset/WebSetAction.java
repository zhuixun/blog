package com.blog.web.action.webset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;

import com.blog.bean.webset.SetSettings;
import com.blog.service.webset.WebSetService;
import com.blog.web.formbean.webset.WebSetForm;

@Controller("/control/webset/manage")
public class WebSetAction extends DispatchAction{
	@Resource(name="webSetServiceBean")
	private WebSetService webSetService;

	 public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	        return mapping.findForward("add");
	   }
	 
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WebSetForm formbean=(WebSetForm) form;
		SetSettings setSettings=new SetSettings();
		setSettings.setTitle(formbean.getTitle());
		setSettings.setKeyword(formbean.getKeyword());
		setSettings.setDescription(formbean.getDescription());
		setSettings.setHotTitle(formbean.getHotTitle());
		setSettings.setFooter(formbean.getFooter());
		webSetService.save(setSettings);
		request.setAttribute("message","添加成功");
        return mapping.findForward("message");
	}
}
