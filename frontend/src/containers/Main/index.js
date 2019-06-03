import React from "react";
import { Provider } from "react-redux";
import { Route, Switch } from "react-router-dom";
import { ConnectedRouter } from "connected-react-router";

import { Components } from "../Menu";
import Header from "../Header";

import { history, store } from "../../store";

const Content = ({ auth, locale }) => {
  return (
    <ConnectedRouter history={history}>
      <div>
        <header>
          <Header/>
        </header>
        <body>
          <div>
            <App/>
          </div>
        </body>
      </div>
    </ConnectedRouter>
  );
};

const App = () => (
  <div className="App">
    <section>
      <AppRouter />
    </section>
  </div>
);

const AppRouter = () => (
  <Switch>
    <Route exact path="/" component={Components.UploadFile} />
    <Route path="*" component={Components.UploadFile} />
  </Switch>
);

export default () => (
  <Provider store={store}>
    <Content />
  </Provider>
);
