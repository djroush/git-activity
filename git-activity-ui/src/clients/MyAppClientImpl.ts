import * as MyApp from './MyAppClient';
import CONFIG from '../Config';

import $ from 'jquery'

class MyAppClientImpl implements MyApp.Client {
  baseRequest = {
    type: 'GET',
    dataType: 'json',
    beforeSend(_xhr: JQuery.jqXHR<any>) {},
  };

  public getActivity(repoOwner: string, repoName: string, eventType: String, 
    callback: (response: MyApp.Activity[]) => void, errorCallback: () => void) : void {
         console.log(`Loading user: ${repoOwner}  repoName: ${repoName}   eventType: ${eventType}`);

    const url = `http://${CONFIG.myAppHost}/activity/${repoOwner}/${repoName}/${eventType}`;
    const request = {
      ...this.baseRequest,

      success: callback,
      error: errorCallback
    };
    $.ajax(url, request);
  }
}

export default MyAppClientImpl;
