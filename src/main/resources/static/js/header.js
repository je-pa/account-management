const profileImgBtnElem = document.querySelector('.profile');
const dropdownMenuElem = document.querySelector('.dropdown_menu');
if(profileImgBtnElem){
    profileImgBtnElem.addEventListener('click',()=>{
        dropdownMenuElem.classList.toggle('active');
    });
}
