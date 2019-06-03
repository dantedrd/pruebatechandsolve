import React from "react";
import { render } from "react-dom";

import "./assets/css/noty.css";
import "./assets/css/autogrid.css";
import "./assets/css/style.css";
import "./assets/css/movile.css";
import "./assets/css/animation.css";

import Main from "./containers/Main";


document.title = `Blog desktop`;
render(<Main />, document.getElementById("root"));
// Hot Module Replacement API
if (module.hot) {
  module.hot.accept("./store", () => {
    render(<Main />, document.getElementById("root"));
  });
}
