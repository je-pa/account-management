const userSortRadio = document.getElementsByName("userSort");

userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        fetch(`userList?userSortId=${e.value}`)
            .then(res=>res.json())
            .then(myJson=>{
                console.log(myJson);
            })
    })
})

function makeUserListTable(checkedUserSort,userList){
    const nameTh = document.createElement('th');

    if(data.length == 0 ){return;}

    userList.forEach(e=>{

    })
}