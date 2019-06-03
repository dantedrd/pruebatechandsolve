/*
* Archivos para definer las constantes para  Main
*
* Versión 1.0
* Fecha de creación 2018-01-03
* Creado por admin
*/
import reduxHelper from '../../utils/reduxHelper';

const reduxUtil = reduxHelper('UploadFile');

export const SET_FILE = reduxUtil.defineAction('SET_FILE');
export const SET_IDENTIFICATION = reduxUtil.defineAction('SET_IDENTIFICATION');
export const SET_CASES = reduxUtil.defineAction('SET_CASES');
