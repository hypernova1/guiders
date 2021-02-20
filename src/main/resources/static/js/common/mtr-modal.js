document.querySelector('body>button').addEventListener('click', () => {
    const modal = document.querySelector('#mtr-modal');
    const modalBody = document.querySelector('#mtr-modal-body');
    modal.style.display = 'block';
    let i = 1;
    const increase = setInterval(() => {
        if (i === 51) {
            clearInterval(increase);
        } else {
            modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
            i++;
        }
    }, 10);

    document.querySelector('button[type="button"]').addEventListener('click', () => {
        let i = 50;
        const decrease = setInterval(() => {
            if (i === -1) {
                modal.style.display = 'none';
                modalBody.style.opacity = 1;
                clearInterval(decrease);
            } else {
                modal.style.backgroundColor = 'rgba(0, 0, 0,' + 0.01 * i + ')';
                modalBody.style.opacity = 0.02 * i;
                i--;
            }
        }, 10);
    });
});