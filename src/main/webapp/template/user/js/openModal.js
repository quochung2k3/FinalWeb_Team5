const modalRegister = document.querySelector('.js-modal__register')
const modalLogin = document.querySelector('.js-modal__login')
const modal = document.querySelector('.js-modal')
const modalAuthRegister = document.querySelector('.js-auth__register')
const modalAuthLogin = document.querySelector('.js-auth__login')
const modalClose = document.querySelectorAll('.js-modal__close')
function showModalRegister() {
    modal.classList.add('open')
    modalAuthRegister.classList.add('open')
}

function showModalLogin() {
    modal.classList.add('open')
    modalAuthLogin.classList.add('open')
}

for(i of modalClose) {
    i.addEventListener('click', hideForm)
}

function hideForm() {
    modal.classList.remove('open')
    if(modalAuthLogin.classList.contains('open'))
    {
        modalAuthLogin.classList.remove('open')
    }
    if(modalAuthRegister.classList.contains('open'))
    {
        modalAuthRegister.classList.remove('open')
    }
}

modalRegister.addEventListener('click', showModalRegister)

modalLogin.addEventListener('click', showModalLogin)