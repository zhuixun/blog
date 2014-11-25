package com.blog.web.action.article;

import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.bean.PageView;
import com.blog.bean.QueryResult;
import com.blog.bean.article.ArticleInfo;
import com.blog.service.article.ArticleInfoService;
import com.blog.service.article.ArticleTypeService;

@Controller("/article/switch")
public class ArticleSwitchAction extends DispatchAction{
	@Resource(name="articleInfoServiceBean")
    private ArticleInfoService articleInfoService;
    @Resource(name ="articleTypeServiceBean")
    private ArticleTypeService articleTypeService;
    
    //文章类型列表
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
    public ActionForward classifyList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("classifyLists", articleTypeService.getAllClassify());
		return mapping.findForward("classifyList");
	}
    
    //最新文章
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
    public ActionForward newestArticle(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	PageView<ArticleInfo> pageView=new PageView<ArticleInfo>(8, 0);
    	LinkedHashMap<String, String> orderby=new LinkedHashMap<String, String>();
		orderby.put("createdate", "desc");
		QueryResult<ArticleInfo> qr=articleInfoService.getScrollData(0, 8, orderby);
		request.setAttribute("pageView", pageView);
		pageView.setQueryResult(qr);
		return mapping.findForward("newestArticle");
	}
    //文章点击量
    public ActionForward viewCount(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	articleInfoService.clickcount(Integer.parseInt(request.getParameter("articleid")));
		return mapping.findForward("viewCount");
	}
}
