function ajax(url, method, obj) {
  return new Promise((resolve, reject) => {

    const xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
      if (xhr.readyState === XMLHttpRequest.DONE) {
        if(xhr.status === 200) {
          resolve(xhr.response);
        } else {
          reject('Error', xhr.status);
        }
      }
    }
    xhr.open(method, url);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(obj));
  });
}