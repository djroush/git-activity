import React from 'react';

import $ from 'jquery';

import '../css/SearchBar.css';

type SearchBarProps = {
  loadActivities: (repoOwner: string, repoName: string, eventType: string) => void;
};

class SearchBar extends React.Component<SearchBarProps, unknown> {
  inputKeyUp = (event: React.KeyboardEvent): void => {
    if (event.key === 'Enter') {
      this.buttonClick();
    }
  };

  buttonClick = (): void => {
    const owner: string = $('#ownerInput').val().toString();
    const repo: string = $('#repoInput').val().toString();
    const eventType: string = $('#eventTypeInput').val().toString();
    const { loadActivities } = this.props;
    if (!!owner && owner !== '' && !!repo && repo !== '' && !!eventType && eventType !== '') {
      loadActivities(owner, repo, eventType);
    }
  };

  render(): JSX.Element {
    const buttonClick = this.buttonClick.bind(this);
    return (
      <div id="searchBar">
        <span>Repo Owner:&nbsp;</span>
        <input
          id="ownerInput"
          type="text"
          placeholder="djroush"
        />
        <span>Repo Name:&nbsp;</span>
        <input
          id="repoInput"
          type="text"
          placeholder="webos-streams"
        />
        <span>EventType:&nbsp;</span>
        <input
          id="eventTypeInput"
          type="text"
          placeholder="PushEvent"
        />
        <button id="loadButton" type="button" onClick={buttonClick}>
          Load
        </button>
      </div>
    );
  }
}

export default SearchBar;
