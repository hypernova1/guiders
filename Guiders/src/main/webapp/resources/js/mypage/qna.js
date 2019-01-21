document.querySelector('#return-page').addEventListener('click', () => {
    history.back();
});

document.querySelector('#reply-btn').addEventListener('click', () => {
   const form = document.createElement('form');
   form.setAttribute('method', 'post');
   form.setAttribute('action', '/mentoring/answer');
   const params = [{ name: 'mtrno', value: document.querySelector('#mtrno').value },
                  { name: 'mreply', value: document.querySelector('#answer-textarea').value}]
   for(let i = 0; i < params.length; i++){
       const hiddenField = document.createElement('input');
       hiddenField.setAttribute('type', 'hidden');
       hiddenField.setAttribute('name', params[i].name);
       hiddenField.setAttribute('value', params[i].value);
       
       form.appendChild(hiddenField);
   }
   
   document.body.appendChild(form);
   form.submit();
});