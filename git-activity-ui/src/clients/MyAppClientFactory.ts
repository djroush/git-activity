import * as MyApp from './MyAppClient';
import MyAppClientMock from './MyAppClientMock';
import MyAppClientImpl from './MyAppClientImpl';
import CONFIG from '../Config';

class MyAppClientFactory {
  static MyAppClient: MyApp.Client = null; 
  
  static getInstance(): MyApp.Client {
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
