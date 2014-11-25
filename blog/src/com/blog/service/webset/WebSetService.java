package com.blog.service.webset;

import com.blog.bean.webset.SetSettings;
import com.blog.service.base.DAO;

public interface WebSetService extends DAO<SetSettings>{
	SetSettings getSiteSetting();
}
