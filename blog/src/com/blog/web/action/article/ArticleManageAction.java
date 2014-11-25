package com.blog.web.action.article;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.blog.bean.PageView;
import com.blog.bean.QueryResult;
import com.blog.bean.article.ArticleInfo;
import com.blog.service.article.ArticleInfoService;
import com.blog.service.article.ArticleTypeService;
import com.blog.web.formbean.article.ArticleForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-3-3
 * Time: 下午2:05
 * To change this template use File | Settings | File Templates.
 */
@Controller("/control/article/manage")
public class ArticleManageAction extends DispatchAction {
    @Resource(name="articleInfoServiceBean")
    private ArticleInfoService articleInfoService;
    @Resource(name ="articleTypeServiceBean")
    private ArticleTypeService articleTypeService;

    @SuppressWarnings("unused")
	public ActionForward addUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleForm formbean=(ArticleForm)form;
        request.setAttribute("articletypelist",articleTypeService.getScrollData().getResultlist());
        return mapping.findForward("add");
    }

    @SuppressWarnings("unused")
	public ActionForward selectUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleForm formbean=(ArticleForm)form;
        String jpql="o.parent is null and o.visible=true";

        return mapping.findForward("add");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleForm formbean=(ArticleForm)form;
        ArticleInfo article=new ArticleInfo();
        article.setName(formbean.getName().trim());
        article.setDescription(request.getParameter("myContent"));
        //生成的文件存放在网站根目录的html/article/类别id/
        article.setUrl("www.xnbigdata.com"+"/html/article/"+formbean.getTypeid()+"/"+formbean.getArticleid()+".shtml");
        article.setArticletype(articleTypeService.find(formbean.getTypeid()));
        article.setKeyword(formbean.getKeyword());
        articleInfoService.save(article);
        articleTypeService.addTypeCount(formbean.getTypeid());
        request.setAttribute("message","添加成功");
        request.setAttribute("urladdress", "/control/article/manage.do?method=list");
		File saveDir = new File(request.getSession().getServletContext().getRealPath("/html/article/"+article.getArticletype().getTypeid()));
		BuildHtmlFile.createArticleHtml(article, saveDir);
        return mapping.findForward("message");
    }
    
    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleForm formbean = (ArticleForm) form;
        StringBuffer jpql=new StringBuffer("o.visible=?1");
        List<Object> params=new ArrayList<Object>();
        params.add(true);
        PageView<ArticleInfo> pageView=new PageView<ArticleInfo>(10,formbean.getPage());
        LinkedHashMap<String,String> orderby=new LinkedHashMap<String, String>();
        orderby.put("id","desc");
        QueryResult<ArticleInfo> qr= articleInfoService.getScrollData(pageView.getFirstResult(),pageView.getMaxresult()
                ,jpql.toString(),params.toArray(),orderby);
        request.setAttribute("pageView",pageView);
        pageView.setQueryResult(qr);
        return mapping.findForward("list");
    }
    
    
    public ActionForward editUI(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleForm formbean = (ArticleForm) form;
        ArticleInfo article=articleInfoService.find(formbean.getArticleid());
        formbean.setName(article.getName());
        if(article.getArticletype()!=null)formbean.setTypeid(article.getArticletype().getTypeid());
        formbean.setKeyword(article.getKeyword());
        formbean.setDescription(article.getDescription());
        request.setAttribute("description", articleInfoService.htmlToCode(article.getDescription()));
        request.setAttribute("articletypelist",articleTypeService.getScrollData().getResultlist());
        return mapping.findForward("edit");
    }
    //文章修改
    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ArticleForm formbean = (ArticleForm) form;
        ArticleInfo article=articleInfoService.find(formbean.getArticleid());
        article.setName(formbean.getName().trim());
        article.setDescription(request.getParameter("myContent"));
        article.setArticletype(articleTypeService.find(formbean.getTypeid()));
        article.setKeyword(formbean.getKeyword());
        articleInfoService.update(article);
        
        request.setAttribute("message", "修改成功了");
		request.setAttribute("urladdress", "/control/article/manage.do?method=list");
        //生成的文件存放在网站根目录的html/article/类别id/
		File saveDir = new File(request.getSession().getServletContext().getRealPath("/html/article/"+article.getArticletype().getTypeid()));
		BuildHtmlFile.createArticleHtml(article, saveDir);
        return mapping.findForward("message");
    }
}