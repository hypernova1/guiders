const content = [].join('\n');

const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    previewStyle: 'vertical',
    initialEditType: "wysiwyg",
    height: '500px',
    initialValue: content
});

document.getElementById("writeBtn").addEventListener('click', function(){
    const content = editor.getMarkdown();
    const title = document.getElementById('title').value;

    document.getElementById('h_title').value = title;
    document.getElementById('h_content').value = content;

    document.getElementById("essayForm").submit();
});
