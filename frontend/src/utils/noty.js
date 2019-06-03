import Noty from 'noty';

class Notices {
  static success(message) {
    this.notify(message, 'success', 5000);
  }

  static info(message) {
    this.notify(message, 'information', 5000);
  }

  static warning(message) {
    this.notify(message, 'warning', 5000);
  }

  static error(message) {
    this.notify(message, 'error', 5000);
  }

  static notify(message, type, timeout) {
    return new Noty({
      text: message,
      type: type,
      timeout: timeout,
      dismissQueue: true,
      theme: 'metroui',
      layout: 'topRight'
    }).show();
  }
}

export default Notices;
