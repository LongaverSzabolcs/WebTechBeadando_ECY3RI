let accessToken = sessionStorage.getItem('accessToken');

if (!accessToken) {
    accessToken = prompt('Adja meg az access tokent:');
    sessionStorage.setItem('accessToken', accessToken);
}

const GITHUB_ACCESS_TOKEN = accessToken;

function loadNavigation() {
    fetch('nav.html')
        .then(res => res.text())
        .then(navHtml => {
            const body = document.querySelector('body');
            body.insertAdjacentHTML('afterbegin', navHtml);
        })
        .catch(err => console.error(err));
}

loadNavigation();