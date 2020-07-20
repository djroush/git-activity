import * as MyApp from './MyAppClient';
import CONFIG from '../Config';
import MyAppClientMock from './MyAppClientMock';
import MyAppClientImpl from './MyAppClientImpl';

class MyAppClientFactory {
  static MyAppClient: MyApp.Client = null; 
  
  static getInstance(): MyApp.Client {
    debugger;
    if (this.MyAppClient === null) {
      if (CONFIG.mockMyApp) {
        this.MyAppClient = new MyAppClientMock();       
      } else {
        this.MyAppClient = new MyAppClientImpl();
      }
    }
    return this.MyAppClient;
  }
}

export default MyAppClientFactory;
