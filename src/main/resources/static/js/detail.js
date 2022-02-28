const resetPwButton = document.querySelector('.reset_pw_button');
const userId = document.querySelector('.userId');
console.log(userId.innerText);

function resetPwAjax(userId){
    console.log(userId);
    fetch(`/user/resetPw?userId=${userId}`)
        .then(response => response.json())
        .then(myJson => {
            console.log(":: "+myJson)
        })
}

resetPwButton.addEventListener('click',()=>{
    resetPwAjax(userId.innerText);
} )

