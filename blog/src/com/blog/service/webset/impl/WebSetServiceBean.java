package com.blog.service.webset.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.blog.bean.webset.SetSettings;
import com.blog.service.base.DaoSupport;
import com.blog.service.webset.WebSetService;

@Service
public class WebSetServiceBean extends DaoSupport<SetSettings> implements WebSetService{

	public SetSettings getSiteSetting() {
		Query query=em.createQuery("select o from SetSettings o order by o.id desc");
		return (SetSettings) query.getSingleResult();
	}

}
