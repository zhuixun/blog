package com.blog.web.action.article;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.blog.bean.about.About;
import com.blog.bean.article.ArticleInfo;

public class BuildHtmlFile {
	public static void createArticleHtml(ArticleInfo article, File saveDir){
		try {
			if(!saveDir.exists()) saveDir.mkdirs();
			VelocityContext context = new VelocityContext();
			context.put("article", article);
			Template template = Velocity.getTemplate("article/articleview.html");
			FileOutputStream outStream = new FileOutputStream(new File(saveDir, article.getId()+".shtml"));
			OutputStreamWriter writer =  new OutputStreamWriter(outStream,"UTF-8");
			BufferedWriter sw = new BufferedWriter(writer);
			template.merge(context, sw);
			sw.flush();
			sw.close();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createAboutHtml(About about, File saveDir){
		try {
			if(!saveDir.exists()) saveDir.mkdirs();
			VelocityContext context = new VelocityContext();
			context.put("about", about);
			Template template = Velocity.getTemplate("about/aboutview.html");
			FileOutputStream outStream = new FileOutputStream(new File(saveDir, "about"+".shtml"));
			OutputStreamWriter writer =  new OutputStreamWriter(outStream,"UTF-8");
			BufferedWriter sw = new BufferedWriter(writer);
			template.merge(context, sw);
			sw.flush();
			sw.close();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
