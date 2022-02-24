const userSortRadio = document.getElementsByName("userSort");

userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        getUserListAjax(e.value);
    })
})

getUserListAjax('2');

function getUserListAjax(checkedUserSort){
    fetch(`userList?userSortId=${checkedUserSort}`)
        .then(res=>res.json())
        .then(myJson=>{
            console.log(myJson);
            makeUserListTable(checkedUserSort,myJson);
        })
}

const theadTrOfUserTable = document.querySelector('.user_table thead tr');
const tbodyOfUserTable = document.querySelector('.user_table tbody');

function makeUserListTable(checkedUserSort,userList){
    theadTrOfUserTable.innerHTML='';
    tbodyOfUserTable.innerHTML='';
    const nameTh = document.createElement('th');
    const idTh = document.createElement('th');
    const emailTh = document.createElement('th');
    const approvalTh = document.createElement('th');

    nameTh.innerHTML='이름';
    idTh.innerHTML='ID';
    emailTh.innerHTML='이메일';
    approvalTh.innerHTML='승인여부';

    theadTrOfUserTable.append(nameTh);
    theadTrOfUserTable.append(idTh);
    switch (checkedUserSort){
        case '2':
            const representativeTh = document.createElement('th');
            representativeTh.innerHTML='대표자';
            theadTrOfUserTable.append(representativeTh);
            break;
        case '3':
            const customerCompanyTh = document.createElement('th');
            customerCompanyTh.innerHTML='소속회사';
            theadTrOfUserTable.append(customerCompanyTh);
            break;
        case '4':
            const departmentTh = document.createElement('th');
            departmentTh.innerHTML='부서';
            theadTrOfUserTable.append(departmentTh);
            break;
    }
    theadTrOfUserTable.append(emailTh);
    theadTrOfUserTable.append(approvalTh);


    if(userList.length == 0 ){return;}

    userList.forEach(e=>{
        const tr = document.createElement('tr');

        const nameTd = document.createElement('td');
        const idTd = document.createElement('td');
        const emailTd = document.createElement('td');
        const approvalTd = document.createElement('td');

        nameTd.innerHTML=`${e.userName}`;
        idTd.innerHTML=`${e.userId}`;
        emailTd.innerHTML=`${e.email}`;

        tr.append(nameTd);
        tr.append(idTd);

        tbodyOfUserTable.append(tr);
    })
}