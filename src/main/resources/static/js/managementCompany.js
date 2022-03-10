// const theadTrOfUserTable = document.querySelector('.user_table thead tr');
// const tbodyOfUserTable = document.querySelector('.user_table tbody');
//
// const loginCompanyName = document.querySelector('.company_info').dataset.userName;
// console.log(loginCompanyName);
// getUserListAjax();
//
// let getUserListAjax = function (){
//     fetch(`userList?company=${loginCompanyName}`)
//         .then(res=>res.json())
//         .then(myJson=>{
//             console.log(myJson);
//             makeUserListTable(myJson);
//         })
// }
//
// function makeUserListTable(userList){
//     theadTrOfUserTable.innerHTML='';
//     const nameTh = document.createElement('th');
//     const idTh = document.createElement('th');
//     const departmentTh = document.createElement('th');
//     const emailTh = document.createElement('th');
//     const approvalTh = document.createElement('th');
//
//     nameTh.innerHTML='이름';
//     idTh.innerHTML='ID';
//     departmentTh.innerHTML='부서';
//     emailTh.innerHTML='이메일';
//     approvalTh.innerHTML='승인여부';
//
//     theadTrOfUserTable.append(nameTh);
//     theadTrOfUserTable.append(idTh);
//     theadTrOfUserTable.append(departmentTh);
//     theadTrOfUserTable.append(emailTh);
//     theadTrOfUserTable.append(approvalTh);
//
//
//     if(userList.length == 0 ){return;}
//
//     userList.forEach(e=>{
//         const tr = document.createElement('tr');
//         tr.onclick=function (){
//             console.log("cl");
//             window.location.href=`/user?userId=${e.userId}`;
//         }
//         const nameTd = document.createElement('td');
//         const idTd = document.createElement('td');
//         const departmentTd = document.createElement('td');
//         const emailTd = document.createElement('td');
//         const approvalTd = document.createElement('td');
//
//         userInnerHtml(nameTd,`${e.userName}`);
//         userInnerHtml(idTd,`${e.userId}`);
//         userInnerHtml(departmentTd,`${e.department}`);
//         userInnerHtml(emailTd,`${e.email}`);
//
//         if(`${e.approval}`=='null'){
//             approvalTd.innerHTML='승인안됨';
//         }else{
//             approvalTd.innerHTML='승인';
//         }
//
//         tr.append(nameTd);
//         tr.append(idTd);
//         tr.append(departmentTd);
//         tr.append(emailTd);
//         tr.append(approvalTd);
//         tbodyOfUserTable.append(tr);
//     })
// }
// function userInnerHtml(cont, elem){
//     if(elem===null || elem ==='null'){
//         return;
//     }
//     cont.innerHTML=elem;
// }