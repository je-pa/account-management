const userSortRadio = document.getElementsByName("userSortId");
const moreInfos = document.querySelectorAll('.moreInfo');

userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        clickRadio(e.value);
    })
})

function clickRadio(checkedUserSort){

    switch (checkedUserSort){
        case '2':
            moreInfos[0].classList.remove('hide');
            moreInfos[1].classList.add('hide');
            moreInfos[2].classList.add('hide');
            break;
        case '3':
            moreInfos[0].classList.add('hide');
            moreInfos[1].classList.remove('hide');
            moreInfos[2].classList.add('hide');
            break;
        case '4':
            moreInfos[0].classList.add('hide');
            moreInfos[1].classList.add('hide');
            moreInfos[2].classList.remove('hide');
            break;
    }
}