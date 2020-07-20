import CONFIG from '../Config';
import MyAppClientFactory from './MyAppClientFactory';
import MyAppClientImpl from './MyAppClientImpl';
import MyAppClientMock from './MyAppClientMock';
import * as MyApp from './MyAppClient';

jest.mock('./MyAppClientImpl')
jest.mock('./MyAppClientMock')

beforeEach(() => {
  MyAppClientFactory.MyAppClient === null;
});


it('Check mockMyApp = false returns real implementation', () => {
  CONFIG.mockMyApp = false;
  const actual: MyApp.Client = MyAppClientFactory.getInstance();
  expect(actual !== null).toBe(true);
  expect(actual instanceof MyAppClientImpl).toBe(true);
  expect(actual instanceof MyAppClientMock).toBe(false);
})

it('Check mockMyApp = true returns mock implementation', () => {
  CONFIG.mockMyApp = true;
  const actual: MyApp.Client = MyAppClientFactory.getInstance();
  expect(actual !== null).toBe(true);
  expect(actual instanceof MyAppClientImpl).toBe(true);
  expect(actual instanceof MyAppClientMock).toBe(false);
})
