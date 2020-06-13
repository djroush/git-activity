import React from 'react';

import '../css/RepoActivity.css';

import * as MyApp from '../clients/MyAppClient';
import MyAppClientFactory from '../clients/MyAppClientFactory';


type RepoActivityState = {
  activities: MyApp.Activity[];
  hasError: boolean
};

class RepoActivity extends React.Component<unknown, RepoActivityState> {
  myAppClient: MyApp.Client = MyAppClientFactory.getInstance();


  getActivityCallback(getActivityResponse: MyApp.Activity[]): void {
    const activities = getActivityResponse;
    this.setState({ activities, hasError: false });
  }
  
  getActivityErrorCallback(): void {
    console.error("Unable to lookup user.  Error with upstream service");

    this.setState({
      activities: null, hasError: true
    })
  }

  loadActivities = (repoOwner: string, repoName: string, eventType: string): void => {
    const callback = this.getActivityCallback.bind(this);
    const errorCallback = this.getActivityErrorCallback.bind(this);
    this.myAppClient.getActivity(repoOwner, repoName, eventType, callback, errorCallback);
  };

  render(): JSX.Element {
    const { activities, hasError } = this.state;
    
    if (hasError) {
      return (
        <div id="activities" className="error">
          <p>Unable to load activties from remote service</p>
        </div> 
      )
    }
    
    const activityList = !activities
      ? ''
      : activities.map((activity: MyApp.Activity) => (
          <div key={activity.id} className="activity">
            <div className="avatar"><img src={activity.actor.avatar_url} /></div>
            <div><span>Event Type:&nbsp;</span><span>{activity.type}</span></div>
            <div><span>Name:&nbsp;</span><span>{activity.actor.display_login}</span></div>
            <div><span>Owner Url:&nbsp;</span><span>{activity.actor.url}</span></div>
            <div><span>Created At:&nbsp;</span><span>{activity.created_at}</span></div>
          </div>
        ));

    return (
      <div id="activities">
        {activityList}
      </div>
    );
  }
}

RepoActivity.prototype.state = {
  activities: null,
  hasError: false
};

export default RepoActivity;
