package com.github.djroush.gitactivity.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.djroush.gitactivity.model.git.Activity;

@Component @Primary
public class GitApiClientImpl implements GitApiClient {

	private String baseUrl = "api.github.com";
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Activity> getRepoActivity(String owner, String name) {
		final String url = "https://{baseUrl}/repos/{owner}/{name}/events";
		Activity[] results = restTemplate.getForObject(url, Activity[].class, baseUrl, owner, name);
		List<Activity> activityList = Arrays.asList(results);
		return activityList;
	}
}
