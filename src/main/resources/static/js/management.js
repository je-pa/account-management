function moveToPage(page){
    const url = new URL(window.location.href);
    if(url.searchParams.has('page')){
        url.searchParams.set('page',page);
    }else{
        url.searchParams.append('page',page);
    }
    window.location.href=url.href;
}

function moveToUserSortIdPage(userSortId){
    let url = new URL(window.location.href);
    if(userSortId==='all'){
        window.location.href='management';
        return;
    }else if(url.searchParams.has('userSortId')){
        url.searchParams.set('userSortId',userSortId);
    }else{
        url.searchParams.append('userSortId',userSortId);
    }
    url.searchParams.set('page','1');
    window.location.href=url.href;
}

const userSortRadio = document.getElementsByName("userSort");
function checkUserSortRadio(){
    const url = new URL(window.location.href);
    if(!url.searchParams.has('userSortId')){
        userSortRadio[0].checked=true;
    }else if(url.searchParams.get('userSortId')=='2'){
        userSortRadio[1].checked=true;
    }else if(url.searchParams.get('userSortId')=='3'){
        userSortRadio[2].checked=true;
    }else if(url.searchParams.get('userSortId')=='4'){
        userSortRadio[3].checked=true;
    }
}
checkUserSortRadio();

function changeSelect(element){
    console.log(element.value);
    const url = new URL(window.location.href);
    if(url.searchParams.has('company')){
        url.searchParams.set('company',element.value);
    }else{
        url.searchParams.append('company',element.value);
    }
    url.searchParams.set('page','1');
    window.location.href=url.href;
}