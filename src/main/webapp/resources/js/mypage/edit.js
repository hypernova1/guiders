document.querySelector('#edit-submit').addEventListener('click', () => {
   if(document.querySelector('#quote')){
     let introdution = document.querySelector('#introdution-value').value;
       introdution = introdution.replace(/(?:\r\n|\r|\n)/g, '<br/>');
       document.querySelector('input[name="introdution"]').value = introdution;
       
       let quote = document.querySelector('#quote-value').value;
       quote = quote.replace(/(?:\r\n|\r|\n)/g, '<br/>');
       document.querySelector('input[name="quote"]').value = quote;
   }
   document.querySelector('#input-wrapper').submit();
});

window.addEventListener('load', () => {
    if(document.querySelector('#quote')){
        let introdution = document.querySelector('#introdution-value');
        introdution.innerHTML = introdution.value.split('<br/>').join('\r\n');
        
        let quote = document.querySelector('#quote-value');
        quote.innerHTML = quote.value.split('<br/>').join('\r\n');
    }
});