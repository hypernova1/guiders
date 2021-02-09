document.querySelector('#edit-submit').addEventListener('click', () => {
   if(document.querySelector('#quote')){
     let introduction = document.querySelector('#introduction-value').value;
       introduction = introduction.replace(/(?:\r\n|\r|\n)/g, '<br/>');
       document.querySelector('input[name="introduction"]').value = introduction;
       
       let quote = document.querySelector('#quote-value').value;
       quote = quote.replace(/(?:\r\n|\r|\n)/g, '<br/>');
       document.querySelector('input[name="quote"]').value = quote;
   }
   document.querySelector('#input-wrapper').submit();
});

window.addEventListener('load', () => {
    if(document.querySelector('#quote')){
        let introduction = document.querySelector('#introduction-value');
        introduction.innerHTML = introduction.value.split('<br/>').join('\r\n');
        
        let quote = document.querySelector('#quote-value');
        quote.innerHTML = quote.value.split('<br/>').join('\r\n');
    }
});