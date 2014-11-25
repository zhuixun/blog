package com.blog.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.blog.bean.webset.SetSettings;
import com.blog.service.webset.WebSetService;


/**
 * 系统环境初始化监听器
 * @author 倪伟伟
 * @date-time 2010-08-20 8:54
 */

public class InitialListener implements ServletContextListener {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(InitialListener.class);
	private ApplicationContext app; 
	
	public void contextDestroyed(ServletContextEvent sce) {
		log.info("销毁系统监听器初始化参数");
	}

	public void contextInitialized(ServletContextEvent event) {
		log.info("初始化系统参数开始...");
		
		app = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext()); //获取spring上下文！  
//		app.getBean("webSetServiceBean"); //获取到bean了
		
		WebSetService webSetService=(WebSetService) app.getBean("webSetServiceBean");
		ServletContext application = event.getServletContext();
		
		SetSettings site =webSetService.getSiteSetting();
		if(site != null) {
			application.setAttribute("setSettings", site);
		}
        log.info("初始化系统参数结束...");
	}
}