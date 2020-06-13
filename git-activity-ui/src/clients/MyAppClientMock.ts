import * as MyApp from './MyAppClient';


class MyAppClientMock implements MyApp.Client {
  public getActivity(_owner: string, _repo: string, _eventType: String, 
    callback: (response: MyApp.Activity[]) => void): void {
    callback(this.getActivityResponse);
  }

  getActivityResponse: MyApp.Activity[] = [
  {
    "id":"12570678860",
    "type":"DeleteEvent",
    "actor":{
      "id":39247445,
      "login":"djroush",
      "display_login":"djroush",
      "url":"https://api.github.com/users/djroush",
      "avatar_url":"https://avatars.githubusercontent.com/u/39247445?"
    },
    "public":true,
    "created_at":"2020-06-08T17:50:01Z"
  },{
    "id":"12563067033",
    "type":"DeleteEvent",
    "actor":{
      "id":39247445,
      "login":"djroush",
      "display_login":"djroush",
      "url":"https://api.github.com/users/djroush",
      "avatar_url":"https://avatars.githubusercontent.com/u/39247445?"
    },
    "public":true,
    "created_at":"2020-06-08T05:39:20Z"
  },{
    "id":"12563066737",
    "type":"DeleteEvent",
    "actor":{
      "id":39247445,
      "login":"djroush",
      "display_login":"djroush",
      "url":"https://api.github.com/users/djroush",
      "avatar_url":"https://avatars.githubusercontent.com/u/39247445?"
    },
    "public":true,
    "created_at":"2020-06-08T05:39:17Z"
  }
];

}
export default MyAppClientMock;