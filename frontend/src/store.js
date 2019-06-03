import { createHashHistory } from "history";
import { applyMiddleware, createStore, compose } from "redux";
import { connectRouter, routerMiddleware } from "connected-react-router";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

const initialState = {};

// Start history
const history = createHashHistory();

// Merge middlewares
const middlewares = [
  routerMiddleware(history),
  thunk.withExtraArgument({})
];

// define for dev tool
/* eslint-disable */
const composeEnhancers =
  typeof window === "object" && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
    ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({
        // Specify extension’s options like name, actionsBlacklist, actionsCreators, serialize...
      })
    : compose;

    // Generate store
const store = createStore(
  connectRouter(history)(rootReducer),
  initialState,
  composeEnhancers(
    applyMiddleware(...middlewares)
  )
);

// Export all the separate modules
export { history, store };
