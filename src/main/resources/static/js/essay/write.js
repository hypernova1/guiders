const content = [].join('\n');

const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    previewStyle: 'vertical',
    initialEditType: "wysiwyg",
    height: '500px',
    initialValue: content
});

document.getElementById("writeBtn").addEventListener('click', function(){
    document.getElementById('h_title').value = document.getElementById('title').value;
    document.getElementById('h_content').value = editor.getMarkdown();

    document.getElementById("essayForm").submit();
});
