function moveToPage(page){
    const url = new URL(window.location.href);
    url.searchParams.set('page',page);
    window.location.href=url.href;
}

function moveToUserSortIdPage(userSortId){
    let url = new URL(window.location.href);
    if(userSortId==='all'){
        url.searchParams.delete('userSortId');
    }else{
        url.searchParams.set('userSortId',userSortId);
    }
    url.searchParams.set('page','1');
    window.location.href=url.href;
}

const userSortRadio = document.getElementsByName("userSort");
function checkUserSortRadio(){
    const url = new URL(window.location.href);
    if(!url.searchParams.has('userSortId')){
        userSortRadio[0].checked=true;
    }
    userSortRadio.forEach(e=>{
        if(e.value==url.searchParams.get('userSortId')){
            e.checked=true;
        }
    })
}
checkUserSortRadio();

const companySelectOption = document.querySelectorAll('.company_select option');

function selectedCompanySelect(){
    const url = new URL(window.location.href);
    companySelectOption.forEach(e=>{
        if(e.value==url.searchParams.get('company')){
            e.selected=true;
        }
    })
}
selectedCompanySelect();

function changeSelect(element){
    console.log(element.value);
    const url = new URL(window.location.href);
    // if(url.searchParams.has('company')){
    //     url.searchParams.set('company',element.value);
    // }else{
    //     url.searchParams.append('company',element.value);
    // }
    if(element.value==='all'){
        url.searchParams.delete('company');
    }else{
        url.searchParams.set('company',element.value);
    }
    url.searchParams.set('page','1');
    window.location.href=url.href;
}

function search(element){
    const url = new URL(window.location.href);
    const searchWord = element.searchWord.value;
    if(searchWord===''){
        return false;
    }
    url.searchParams.set('search',searchWord);
    window.location.href=url.href;
    return false;
}

function searchWordInput(){
    const url = new URL(window.location.href);
    const searchWordElem = document.getElementsByName('searchWord');
    searchWordElem[0].value=url.searchParams.get('search');
}
searchWordInput();

function findSearchWord(){
    const url = new URL(window.location.href);
    if(url.searchParams.has('search')){
        let search = url.searchParams.get('search');
        $("td:contains('"+search+"')").css({color:"blue"});
        //
        // $("input:contains('"+search+"')").each(function () {
        //     var regex = new RegExp(search,'gi');
        //     $(this).html( $(this).text().replace(regex, "<span class='txt-hlight'>"+search+"</span>") );
        // });
    }
}
findSearchWord();