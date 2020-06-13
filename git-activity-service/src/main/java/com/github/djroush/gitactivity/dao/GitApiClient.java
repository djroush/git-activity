package com.github.djroush.gitactivity.dao;

import java.util.List;

import com.github.djroush.gitactivity.model.git.Activity;

public interface GitApiClient {
	public List<Activity> getRepoActivity(String owner, String name);
}
