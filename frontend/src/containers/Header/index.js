import React from "react";
import "./style.css";

export default class Header extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = { openLogin: false, openRegister: false };
  }
  render() {
    return (
      <nav class="fadeInDown">
        <div class="brand_image">
          <p>Upload LAZY LOAD</p>
        </div>
      </nav>
    );
  }
}
