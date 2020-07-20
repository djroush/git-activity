import React from 'react';

import RepoActivity from '../components/RepoActivity';
import SearchBar from '../components/SearchBar';

type AppState = {
  owner?: string;
  repo?: string;
  eventType?: string;
};

class App extends React.Component<unknown, AppState> {
  repoActivity: RepoActivity = null;

  searchBar: SearchBar = null;

  constructor(props: unknown) {
    super(props);
    this.loadActivities = this.loadActivities.bind(this);
  }
 
  loadActivities = (repoOwner: string, repoName: string, eventType: string): void => {
    this.repoActivity.loadActivities(repoOwner, repoName, eventType);
  };

  render(): JSX.Element {
    // TODO: find another place to bind these!
    const loadActivities = this.loadActivities;

    return (
      <div className="App">
        <SearchBar
          ref={(node) => {
            this.searchBar = node;
          }}
          loadActivities={loadActivities}
        />
        <RepoActivity
          ref={(node) => {
            this.repoActivity = node;
          }}
        />
      </div>
    );
  }
}

export default App;
