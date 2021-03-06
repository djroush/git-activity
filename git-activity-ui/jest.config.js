// jest.config.js
const { defaults } = require('jest-config');

module.exports = {
  globals: {
    'ts-jest': {
      tsConfig: 'tsconfig.json',
      babelConfig: 'babel.config.json'
    }
  },
  preset: "ts-jest",
  roots: [
    "<rootDir>/src"
  ],
  collectCoverage: true,
  collectCoverageFrom: [
    "**/*.{ts,tsx}",
    "!**/dist/**",
    "!**/node_modules/**"
  ],
  moduleFileExtensions: [...defaults.moduleFileExtensions, 'ts', 'tsx'],
  moduleNameMapper: {
    "\\.css$": "identity-obj-proxy"
  },
  testEnvironment: "jsdom",
  testMatch: [
    "**/__tests__/**/*.+(ts|tsx|js)",
    "**/?(*.)+(spec|test).+(ts|tsx|js)"
  ],
};
