package com.blog.web.action.article;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;
import com.blog.bean.article.ArticleInfo;
import com.blog.service.article.ArticleInfoService;
import com.blog.web.formbean.article.ArticleForm;

@Controller("/article/view")
public class ViewArticleAction extends Action {
	@Resource(name="articleInfoServiceBean")
	private ArticleInfoService articleInfoService;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArticleForm formbean=(ArticleForm) form;
		ArticleInfo article=articleInfoService.find(formbean.getArticleid());
		Integer count=0;
		if(article!=null){
			count=article.getClickcount();
			count=count+1;
		}
		article.setClickcount(count);
		articleInfoService.update(article);
		//网站关键词、描述
		request.getSession().setAttribute("title", article.getName());
		request.getSession().setAttribute("keyword", article.getKeyword());
		request.getSession().setAttribute("description", article.getName());
		request.setAttribute("article", article);
		return mapping.findForward("view");
	}
}