// const userSortRadio = document.getElementsByName("userSort");
//
// userSortRadio.forEach(e=>{
//     e.addEventListener('click', ()=>{
//         console.log(e.value);
//         getUserListAjax(e.value);
//     })
// })
//
// function getUserListAjax(checkedUserSort){
//     fetch(`userList?userSortId=${checkedUserSort}`)
//         .then(res=>res.json())
//         .then(myJson=>{
//             console.log(myJson);
//             makeUserListTable(checkedUserSort,myJson);
//         })
// }
//
// // function approvalUserAjax(userId){
// //     fetch(`/user/approval?userId=${userId}`)
// //         .then(response => response.json())
// //         .then(myJson => {
// //             console.log(":: "+myJson)
// //             if(myJson==true){
// //                 resetPwAjax(userId);
// //             }
// //         })
// // }
// function approvalUserAjax(userId){
//     let user={
//         userId:userId ,
//     }
//     fetch('/user/approval',{
//         method: 'PUT',
//         headers:{"Content-Type":"application/json; charset=utf-8"},
//         body: JSON.stringify(user)
//     }).then(response => response.json())
//         .then(myJson => {
//             console.log(":: "+myJson)
//             if(myJson==true){
//                 resetPwAjax(userId);
//             }
//         })
// }
// function resetPwAjax(userId){
//     fetch(`/user/resetPw?userId=${userId}`,{
//         method: 'PUT',
//     })
//         .then(response => response.json())
//         .then(myJson => {
//             console.log(":: "+myJson)
//         })
// }
//
//
// const theadTrOfUserTable = document.querySelector('.user_table thead tr');
// const tbodyOfUserTable = document.querySelector('.user_table tbody');
//
// function makeUserListTable(checkedUserSort,userList){
//     theadTrOfUserTable.innerHTML='';
//     tbodyOfUserTable.innerHTML='';
//     const nameTh = document.createElement('th');
//     const idTh = document.createElement('th');
//     const emailTh = document.createElement('th');
//     const approvalTh = document.createElement('th');
//
//     userInnerHtml(nameTh,'??????');
//     userInnerHtml(idTh,'ID');
//     userInnerHtml(emailTh,'?????????');
//     userInnerHtml(approvalTh,'????????????');
//
//     theadTrOfUserTable.append(nameTh);
//     theadTrOfUserTable.append(idTh);
//     switch (checkedUserSort){
//         case '2':
//             const representativeTh = document.createElement('th');
//             userInnerHtml(representativeTh,'?????????');
//             theadTrOfUserTable.append(representativeTh);
//             break;
//         case '3':
//             const companyTh = document.createElement('th');
//             userInnerHtml(companyTh,'????????????');
//             theadTrOfUserTable.append(companyTh);
//             break;
//         case '4':
//             const departmentTh = document.createElement('th');
//             userInnerHtml(departmentTh,'??????');
//             theadTrOfUserTable.append(departmentTh);
//             break;
//     }
//     theadTrOfUserTable.append(emailTh);
//     theadTrOfUserTable.append(approvalTh);
//
//
//     if(userList.length == 0 ){return;}
//
//     userList.forEach(e=>{
//         const tr = document.createElement('tr');
//
//         const nameTd = document.createElement('td');
//         const idTd = document.createElement('td');
//         const emailTd = document.createElement('td');
//         moveToDetail(nameTd, e);
//         moveToDetail(idTd, e);
//         moveToDetail(emailTd, e);
//         const approvalTd = document.createElement('td');
//
//         userInnerHtml(nameTd,`${e.userName}`);
//         userInnerHtml(idTd,`${e.userId}`);
//         userInnerHtml(emailTd,`${e.email}`);
//
//         if(`${e.approval}`=='null'){
//             // approvalTd.innerHTML=`<a class="approval_button">????????????</a>`;
//             const approvalButton = document.createElement('a');
//             approvalButton.classList.add('approval_button');
//             approvalButton.innerHTML='????????????';
//             approvalTd.append(approvalButton);
//             approvalButton.addEventListener('click',()=>{
//                 approvalUserAjax(`${e.userId}`);
//                 console.log('1');
//             })
//         }else{
//             approvalTd.innerHTML='??????';
//             moveToDetail(approvalTd, e);
//         }
//
//         tr.append(nameTd);
//         tr.append(idTd);
//         switch (checkedUserSort){
//             case '2':
//                 const representativeTd = document.createElement('td');
//                 userInnerHtml(representativeTd,`${e.representative}`);
//                 moveToDetail(representativeTd, e);
//                 tr.append(representativeTd);
//                 break;
//             case '3':
//                 const companyTd = document.createElement('td');
//                 userInnerHtml(companyTd,`${e.company}`);
//                 moveToDetail(companyTd, e);
//                 tr.append(companyTd);
//                 break;
//             case '4':
//                 const departmentTd = document.createElement('td');
//                 userInnerHtml(departmentTd,`${e.department}`);
//                 moveToDetail(departmentTd, e);
//                 tr.append(departmentTd);
//                 break;
//         }
//         tr.append(emailTd);
//         tr.append(approvalTd);
//
//         tbodyOfUserTable.append(tr);
//     })
// }
//
// function userInnerHtml(cont, elem){
//     if(elem==null || elem =='null'){
//         return;
//     }
//     cont.innerHTML=elem;
// }
// getUserListAjax('2');
//
//
// function moveToDetail(userId){
//     console.log(userId);
//     window.location.href=`/user?userId=${userId}`;
// }

function approvalUserAjax(userId , element){
    console.log(userId);
    let user={
        userId:userId ,
    }
    fetch('/user/approval',{
        method: 'PUT',
        headers:{"Content-Type":"application/json; charset=utf-8"},
        body: JSON.stringify(user)
    }).then(response => response.json())
        .then(myJson => {
            console.log(":: "+myJson)
            if(myJson==true){
                resetPwAjax(userId, element);
            }
        })
}

function resetPwAjax(userId, element){
    fetch(`/user/resetPw?userId=${userId}`,{
        method: 'PUT',
    })
        .then(response => response.json())
        .then(myJson => {
            console.log(":: "+myJson)

            element.parentNode.innerHTML='??????';
        })
}