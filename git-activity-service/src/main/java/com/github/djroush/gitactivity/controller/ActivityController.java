package com.github.djroush.gitactivity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.djroush.gitactivity.logic.ActivityService;
import com.github.djroush.gitactivity.model.git.Activity;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	private static final List<String> VALID_EVENT_TYPES = Arrays.asList("CommitCommentEvent", 
		"CreateEvent", "DeleteEvent", "ForkEvent", "GollumEvent", "IssuesCommentEvent", 
		"IssuesEvent", "MemberEvent", "PublicEvent", "PullRequestEvent", 
		"PullRequestReviewCommentEvent", "PushEvent", "ReleaseEvent", "SponsorshipEvent",
		"WatchEvent");
	
	private static final String VALID_EVENT_TYPES_LIST = String.join(", ", VALID_EVENT_TYPES);
	
	@GetMapping("/{repoOwner}/{repo}/{eventType}")
	public ResponseEntity<?> getRepoActivity(@PathVariable("repoOwner") String repoOwner, 
			@PathVariable("repo") String repo, @PathVariable("eventType") String eventType)  {
		boolean isValidEventType = validateEventType(eventType);
		if (!isValidEventType) {
			
			ResponseEntity<?> re = ResponseEntity.status(HttpStatus.BAD_REQUEST)
			.header("Access-Control-Allow-Origin", "*")
			.body(
			    "{\"errorMessage\":\"An invalid eventType was specified, you must use a valid type ("+ VALID_EVENT_TYPES_LIST + ")\"}"
			);
			return re;
				
		}
		List<Activity> result = activityService.getRepoActivity(repoOwner, repo, eventType);
		return ResponseEntity.status(HttpStatus.OK)		
				.header("Access-Control-Allow-Origin", "*")
				.body(result);
	}
	
	private boolean validateEventType(String eventType) {
		return VALID_EVENT_TYPES.contains(eventType);
	}
}
