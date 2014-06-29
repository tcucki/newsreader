package com.cognitive.newsreader.web.businessdelegate;

import com.cognitive.framework.businessdelegate.AbstractBusinessDelegate;
import com.cognitive.framework.businessdelegate.EnvironmentType;
import com.cognitive.framework.util.SystemConfiguration;

public class NewsReaderBusinessDelegate <T> extends AbstractBusinessDelegate<T> {

	protected void setup(String serviceName) {

		super.setup(
				EnvironmentType.GLOBAL.getValue(),
				SystemConfiguration.get("NEWSREADER_APPLICATION_NAME"), 
				SystemConfiguration.get("NEWSREADER_SERVICE_MODULE_NAME"), 
				serviceName);
	}
}
