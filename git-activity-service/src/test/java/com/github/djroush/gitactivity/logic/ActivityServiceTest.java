package com.github.djroush.gitactivity.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.djroush.gitactivity.dao.GitApiClient;
import com.github.djroush.gitactivity.model.git.Activity;
import com.github.djroush.gitactivity.model.git.Actor;

@ExtendWith(MockitoExtension.class)
public class ActivityServiceTest {

	@InjectMocks
	private ActivityService activityService;
	
	@Mock
	private GitApiClient gitApiClient;
	
	@Test
	public void testGetRepoActivityFakeEvent() {
		List<Activity> activityList = Arrays.asList(
			PUSH_ACTIVITY_1, PUSH_ACTIVITY_2, DELETE_ACTIVITY, PULL_REQUEST_ACTIVITY
		);
		
		when(gitApiClient.getRepoActivity(anyString(), anyString()))
		  .thenReturn(activityList);
		
		List<Activity> actualActivityList = activityService.getRepoActivity(
			"djroush", "webos-streams", "FakeEvent");
		
		assertNotNull(actualActivityList);
		assertEquals(0, actualActivityList.size());
		
		verify(gitApiClient, times(1)).getRepoActivity(anyString(), anyString());
	}
	
	@Test
	public void testGetRepoActivityMatchEvent() {
		List<Activity> activityList = Arrays.asList(
			PUSH_ACTIVITY_1, PUSH_ACTIVITY_2, DELETE_ACTIVITY, PULL_REQUEST_ACTIVITY
		);
		
		when(gitApiClient.getRepoActivity(anyString(), anyString()))
		  .thenReturn(activityList);
		
		List<Activity> actualActivityList = activityService.getRepoActivity(
			"djroush", "webos-streams", "PushEvent");
		
		assertNotNull(actualActivityList);
		assertEquals(2, actualActivityList.size());
		assertEquals("pushID1", actualActivityList.get(0).getID());
		assertEquals("pushID2", actualActivityList.get(1).getID());
		
		verify(gitApiClient, times(1)).getRepoActivity(anyString(), anyString());
	}
	
	private static final Activity PUSH_ACTIVITY_1 = new Activity() {{
		setID("pushID1");
		setType("PushEvent");
		setActor(new Actor() {{
			setID(12345);
			setLogin("djroush");
			setURL("https://api.github.com/users/djroush");
			setAvatarURL("https://avatars.githubusercontent.com/u/39247445?");
		}});
		setCreatedAt(OffsetDateTime.now());
	}};
	

	private static final Activity PUSH_ACTIVITY_2 = new Activity() {{
		setID("pushID2");
		setType("PushEvent");
		setActor(new Actor() {{
			setID(12345);
			setLogin("djroush");
			setURL("https://api.github.com/users/djroush");
			setAvatarURL("https://avatars.githubusercontent.com/u/39247445?");
		}});
		setCreatedAt(OffsetDateTime.now().minusMinutes(30));
	}};

	private static final Activity DELETE_ACTIVITY = new Activity() {{
		setID("deleteID1");
		setType("DeleteEvent");
		setActor(new Actor() {{
			setID(12345);
			setLogin("djroush");
			setURL("https://api.github.com/users/djroush");
			setAvatarURL("https://avatars.githubusercontent.com/u/39247445?");
		}});
		setCreatedAt(OffsetDateTime.now().minusMinutes(45));
	}};
	
	private static final Activity PULL_REQUEST_ACTIVITY = new Activity() {{
		setID("pullRequest1");
		setType("PullRequestEvent");
		setActor(new Actor() {{
			setID(12345);
			setLogin("djroush");
			setURL("https://api.github.com/users/djroush");
			setAvatarURL("https://avatars.githubusercontent.com/u/39247445?");
		}});
		setCreatedAt(OffsetDateTime.now().minusMinutes(60));
	}};
}
