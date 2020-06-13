import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './components/App';

type ConfigProps = {
  myAppHost: string;
  mockMyApp: boolean;
};

const CONFIG: ConfigProps = {
  myAppHost: 'localhost:8080',
  mockMyApp: false,
};

export default CONFIG;

ReactDOM.render(<App />, document.getElementById('root'));
