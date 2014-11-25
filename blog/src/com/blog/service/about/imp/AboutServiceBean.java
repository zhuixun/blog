package com.blog.service.about.imp;


import org.springframework.stereotype.Service;
import com.blog.bean.about.About;
import com.blog.service.about.AboutService;
import com.blog.service.base.DaoSupport;

@Service
public class AboutServiceBean extends DaoSupport<About> implements AboutService {

}