import React from "react";
import { connect } from "react-redux";
import actions from "./actions";

import { URL_API } from "../../constants";

@connect(
  state => ({
    ...state.UploadFile
  }),
  actions
)
export default class UploadFile extends React.PureComponent {
  constructor(props) {
    super(props);
  }
  onSubmit(e) {
    e.preventDefault();
    this.props.uploadFile({
      file: this.props.file,
      identification: this.props.identification
    });
  }

  onChange(e) {
    this.props.saveReduxFile({ file: e.target.files[0] });
  }

  render() {
    const { cases } = this.props;
    const travelsItems = cases.map((travel, index) => {
      return <div>case number # {travel.caseNumber} : {travel.totalTravels}</div>;
    });
    return (
      <div class="grid">
        <div class="modulo_pago">
          <form
            onSubmit={e => {
              this.onSubmit(e);
            }}
          >
            <h1>Upload charge</h1>
            <label for="name">Identification</label><br></br>
            <input
              type="text"
              className="data"
              value={this.props.identification}
              onChange={e => {
                this.props.setIdentification({
                  identification: e.target.value
                });
              }}
            />
            <br />
            <label for="name">Select file</label><br></br>
            <input
              type="file"
              className="data"
              onChange={e => {
                this.onChange(e);
              }}
            />
            <br />
            <br />
            <button type="submit" class="main_button">
              Upload File
            </button>
          </form>
        </div>
        {cases.length >0 &&(
            <div class="modulo_pago">
              <div>{travelsItems}</div>
              <div>
                <a
                  href={`${URL_API}/charge/downloadFile/${
                    this.props.identification
                  }`}
                >
                  download file
                </a>
              </div>
            </div>
          )}
      </div>
    );
  }
}
