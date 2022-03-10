// const userSortRadio = document.getElementsByName("userSortId");
// const moreInfos = document.querySelectorAll('.moreInfo');
//
// userSortRadio.forEach(e=>{
//     e.addEventListener('click', ()=>{
//         console.log(e.value);
//         clickRadio(e.value);
//     })
// })
//
// function clickRadio(checkedUserSort){
//
//     switch (checkedUserSort){
//         case '2':
//             moreInfos[0].classList.remove('hide');
//             moreInfos[1].classList.add('hide');
//             moreInfos[2].classList.add('hide');
//             break;
//         case '3':
//             moreInfos[0].classList.add('hide');
//             moreInfos[1].classList.remove('hide');
//             moreInfos[2].classList.add('hide');
//             break;
//         case '4':
//             moreInfos[0].classList.add('hide');
//             moreInfos[1].classList.add('hide');
//             moreInfos[2].classList.remove('hide');
//             break;
//     }
// }

const userSortRadio = document.getElementsByName("userSortId");
const moreInfoTable = document.querySelectorAll('.more_info');


userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        clickRadio(e.value);
    })
})

function clickRadio(checkedUserSort){
    switch (checkedUserSort){
        case '2':
            moreInfoTable[0].classList.add('mode_company');
            moreInfoTable[0].classList.remove('mode_customer');
            moreInfoTable[0].classList.remove('mode_employee');
            moreInfoTable[0].classList.remove('mode_none');
            break;
        case '3':
            moreInfoTable[0].classList.remove('mode_company');
            moreInfoTable[0].classList.add('mode_customer');
            moreInfoTable[0].classList.remove('mode_employee');
            moreInfoTable[0].classList.remove('mode_none');
            break;
        case '4':
            moreInfoTable[0].classList.remove('mode_company');
            moreInfoTable[0].classList.remove('mode_customer');
            moreInfoTable[0].classList.add('mode_employee');
            moreInfoTable[0].classList.remove('mode_none');
            break;
    }
}

function checkedUserSortId(){
    const checked = document.querySelector('input[name="userSortId"]:checked');
    if(checked) {
        clickRadio(checked.value);
    }
}
checkedUserSortId();