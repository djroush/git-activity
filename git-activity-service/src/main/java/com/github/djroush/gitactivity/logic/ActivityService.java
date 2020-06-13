package com.github.djroush.gitactivity.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.djroush.gitactivity.dao.GitApiClient;
import com.github.djroush.gitactivity.model.git.Activity;

@Service
public class ActivityService {
	@Autowired 
	private GitApiClient gitApiClient;
	
	//FIXME: should convert DAO model to App specific model here, 
	//nulling out fields in the Git model to save time
    public List<Activity> getRepoActivity(String owner, String name, String eventType) {
    	List<Activity> activityList = gitApiClient.getRepoActivity(owner, name);
    	List<Activity> filteredActivityList = activityList.stream()  
    		.filter(activity -> eventType.equals(activity.getType()))
    		.collect(Collectors.toList());
    	
    	return filteredActivityList;
    }
}
