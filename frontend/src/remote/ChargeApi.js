import axios from "axios";
import { URL_API } from "../constants";

export default class ChargeApi {
  static callWs(data) {
    return new Promise((resolve, reject) => {
      axios({
        method: data.method,
        url: URL_API + data.url,
        data: data.data ? data.data : {},
        config: data.config?data.config:{}
      })
        .then(response => {
          resolve(response.data);
        })
        .catch((err,res) => {
          reject(err.response.data.error);
        });
    });
  }
  static uploadFile(data, cb) {
    const formData = new FormData();

    formData.append("identification", data.identification);
    formData.append("file", data.file);
    
    ChargeApi.callWs({
      method: "post",
      url: `/charge/`,
      data:formData,
      config:{
        headers: {
          "content-type": "multipart/form-data"
        }
      }
    })
    .then(response => {
        cb(response, null);
    })
    .catch(error => {
        cb(null, error);
    });
    /*return axios
      .post(URL_API + "/charge/", formData, {
        headers: {
          "content-type": "multipart/form-data"
        }
      })
      .then((res) => {
        cb("OK");
      })
      .catch(err => {
        cb(err);
      });*/
  }
}
