const userSortRadio = document.getElementsByName("userSortId");
// const moreInfos = document.querySelectorAll('.moreInfo');
const moreInfoThs = document.querySelectorAll('.more_info_th');
const moreInfoTrs = document.querySelectorAll('.more_info_tr');

userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        clickRadio(e.value);
    })
})

function clickRadio(checkedUserSort){

    switch (checkedUserSort){
        case '2':
            moreInfoThs[0].classList.remove('hide');
            moreInfoThs[1].classList.add('hide');
            moreInfoThs[2].classList.add('hide');

            moreInfoTrs[0].classList.remove('hide');
            moreInfoTrs[1].classList.add('hide');
            moreInfoTrs[2].classList.add('hide');
            moreInfoTrs[3].classList.add('hide');
            moreInfoTrs[4].classList.remove('hide');
            moreInfoTrs[5].classList.remove('hide');
            break;
        case '3':
            moreInfoThs[0].classList.add('hide');
            moreInfoThs[1].classList.remove('hide');
            moreInfoThs[2].classList.add('hide');

            moreInfoTrs[0].classList.add('hide');
            moreInfoTrs[1].classList.remove('hide');
            moreInfoTrs[2].classList.remove('hide');
            moreInfoTrs[3].classList.remove('hide');
            moreInfoTrs[4].classList.remove('hide');
            moreInfoTrs[5].classList.remove('hide');
            break;
        case '4':
            moreInfoThs[0].classList.add('hide');
            moreInfoThs[1].classList.add('hide');
            moreInfoThs[2].classList.remove('hide');

            moreInfoTrs[0].classList.add('hide');
            moreInfoTrs[1].classList.add('hide');
            moreInfoTrs[2].classList.remove('hide');
            moreInfoTrs[3].classList.remove('hide');
            moreInfoTrs[4].classList.remove('hide');
            moreInfoTrs[5].classList.remove('hide');
            break;
    }
}