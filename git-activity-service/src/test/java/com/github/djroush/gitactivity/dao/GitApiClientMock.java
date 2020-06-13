package com.github.djroush.gitactivity.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.djroush.gitactivity.model.git.Activity;
import com.github.djroush.gitactivity.model.git.Converter;

@Component
public class GitApiClientMock implements GitApiClient {
	@Override
	public List<Activity> getRepoActivity(String owner, String name) {
		ObjectMapper mapper = Converter.instantiateMapper();
		
		try {
			InputStream inputStream = GitApiClientMock.class.getClassLoader()
                .getResourceAsStream("response.json");
	    	Activity[] activityArray = mapper.readValue(inputStream, Activity[].class);
			List<Activity> activityList = Arrays.asList(activityArray);
			return activityList;
		} catch (IOException ioe ) {
			throw new DaoMockException(ioe);
		}

	}
}

class DaoMockException extends RuntimeException {
	private static final long serialVersionUID = -939934562883420858L;

	public DaoMockException(Throwable e) {
		super(e);
	}
}
