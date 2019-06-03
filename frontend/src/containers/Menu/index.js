import Loadable from "react-loadable";
import React from "react";

const Components = [];


Components.UploadFile = Loadable({
  loader: () => import("../UploadFile"),
  loading() {
    return <div className="loading">Loading...</div>;
  }
});

export { Components };