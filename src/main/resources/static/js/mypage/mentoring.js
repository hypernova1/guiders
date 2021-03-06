document.querySelector('#return-page').addEventListener('click', () => {
    history.back();
});

const content = [].join('\n');

const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    previewStyle: 'vertical',
    initialEditType: "wysiwyg",
    height: '500px',
    initialValue: content
});

document.getElementById("answer-btn").addEventListener('click', function(){
    document.getElementById('h_answer').value = editor.getMarkdown();
    document.getElementById("answer-form").submit();
});

/*document.querySelector('#answer-btn').addEventListener('click', () => {
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
});*/