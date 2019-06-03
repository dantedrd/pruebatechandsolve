import reduxHelper from "../../utils/reduxHelper";
import {
  SET_FILE,
  SET_IDENTIFICATION,
  SET_CASES
} from "./actionType";

const reduxUtil = reduxHelper("UploadFile");

const initialState = {
  file: null,
  identification:"",
  cases:[]
};

// Crear el reducer segun la accion
const reducer = reduxUtil.createReducer(
  {
    [SET_FILE](state, action) {
      const newState = { ...state };
      newState.file = action.payload.file;
      return newState;
    },
    [SET_IDENTIFICATION](state, action) {
      const newState = { ...state };
      newState.identification = action.payload.identification;
      return newState;
    },
    [SET_CASES](state, action) {
      const newState = { ...state };
      newState.cases = action.payload.cases;
      return newState;
    }
  },
  initialState
);

export default reducer;
