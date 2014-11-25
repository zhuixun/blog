package com.blog.web.action.article;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;
import com.blog.bean.PageView;
import com.blog.bean.QueryResult;
import com.blog.bean.article.ArticleInfo;
import com.blog.service.article.ArticleInfoService;
import com.blog.service.article.ArticleTypeService;
import com.blog.web.formbean.article.ArticleForm;

@Controller("/index")
public class ArticleAction extends DispatchAction {
	@Resource(name="articleInfoServiceBean")
    private ArticleInfoService articleInfoService;
    @Resource(name ="articleTypeServiceBean")
    private ArticleTypeService articleTypeService;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArticleForm formbean=(ArticleForm) form;
		StringBuffer jpql=new StringBuffer("o.visible =?1");
		List<Object> params=new ArrayList<Object>();
		params.add(true);
		PageView<ArticleInfo> pageView=new PageView<ArticleInfo>(6, formbean.getPage());
		LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("id", "desc");
		QueryResult<ArticleInfo> qr=articleInfoService.getScrollData(pageView.getFirstResult(),pageView.getMaxresult()
				,jpql.toString(),params.toArray(),orderby);
		
		request.setAttribute("pageView", pageView);
		//栏目
		request.setAttribute("classifyLists", articleTypeService.getAllClassify());
		pageView.setQueryResult(qr);
		return mapping.findForward("articleList");
	}
}