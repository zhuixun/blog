package com.blog.web.action.article;

import com.blog.bean.PageView;
import com.blog.bean.QueryResult;
import com.blog.bean.article.ArticleType;
import com.blog.service.article.ArticleTypeService;
import com.blog.web.formbean.article.ArticleTypeForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-26
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
@Controller("/control/article/type/list")
public class ArticleTypeAction extends Action {
    @Resource(name = "articleTypeServiceBean")
    private ArticleTypeService articleTypeService;
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArticleTypeForm formbean = (ArticleTypeForm) form;
        StringBuffer jpql=new StringBuffer("o.visible= ?1");
        List<Object> params=new ArrayList<Object>();
        params.add(true);
        PageView<ArticleType> pageView=new PageView<ArticleType>(10,formbean.getPage());
        LinkedHashMap<String,String> orderby=new LinkedHashMap<String, String>();
        orderby.put("typeid","desc");
        QueryResult<ArticleType> qr= articleTypeService.getScrollData(pageView.getFirstResult(),pageView.getMaxresult()
        ,jpql.toString(),params.toArray(),orderby);
        request.setAttribute("pageView",pageView);
        //栏目
		request.setAttribute("classifyLists", articleTypeService.getAllClassify());
		pageView.setQueryResult(qr);
        return mapping.findForward("list");
    }
}