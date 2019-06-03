
import React from "react";

import sadness from "../../assets/img/sadness.jpg";

const NoData = ({ text }) => (
  <div className="mention">
    <div className="content_mention">
      <img className="picture" src={sadness} alt="" />
      <div className="text">
        <h5>{text}</h5>
      </div>
    </div>
  </div>
);
export default NoData;