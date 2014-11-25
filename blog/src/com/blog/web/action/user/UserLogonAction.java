package com.blog.web.action.user;

import com.blog.service.user.UserService;
import com.blog.web.formbean.user.UserForm;
import net.sf.json.JSONObject;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-2-19
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
@Controller("/user/logon")
public class UserLogonAction extends Action {
    @Resource UserService userService;
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserForm formbean=(UserForm)form;
        if(formbean.getUsername()!=null&&!"".equals(formbean.getUsername().trim())
                && formbean.getPassword()!=null&&!"".equals(formbean.getPassword().trim())){
            if(userService.validate(formbean.getUsername().trim(),formbean.getPassword().trim())){
                request.getSession().setAttribute("user",userService.find(formbean.getUsername().trim()));
                //
//                request.setAttribute("message","登录成功");
                PrintWriter pw = response.getWriter();
                JSONObject obj=new JSONObject();
                obj.put("result","true");
                pw.print(obj);
                pw.close();
                return null;
//                return mapping.findForward("message");
            }else{
                PrintWriter pw = response.getWriter();
                JSONObject obj=new JSONObject();
                obj.put("result","error");
                pw.print(obj);
                pw.close();
                return null;
//                request.setAttribute("error", "用户名及密码错误");
            }
        }
        return mapping.findForward("logon");
    }
}
