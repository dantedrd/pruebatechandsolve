import { SET_FILE, SET_IDENTIFICATION, SET_CASES } from "./actionType";
import reduxHelper from "../../utils/reduxHelper";
import ChargeApi from "../../remote/ChargeApi";

import noty from "../../utils/noty";

const reduxUtil = reduxHelper("UploadFile");
// Crear todas las acciones aquí
const actions = {
  saveReduxFile: payload => dispatch => {
    dispatch({
      type: SET_FILE,
      payload: {
        file: payload.file
      }
    });
  },
  uploadFile: payload => dispatch => {
    uploadFile(dispatch, payload);
  },
  setIdentification: payload => dispatch => {
    dispatch({
      type: SET_IDENTIFICATION,
      payload: {
        identification: payload.identification
      }
    });
  }
};

const uploadFile = (dispatch, payload) => {
  const data = {
    file: payload.file,
    identification: payload.identification
  };
  ChargeApi.uploadFile(data, (response, error) => {
    if (error) {
      noty.error(error);
      return;
    }
    dispatch({
      type: SET_CASES,
      payload: {
        cases: response
      }
    });
  });
};

export default actions;
