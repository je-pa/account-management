const userSortRadio = document.getElementsByName("userSortId");
const infoInputTable = document.querySelector('.info_input_table');

userSortRadio.forEach(e=>{
    e.addEventListener('click', ()=>{
        console.log(e.value);
        makeInfoInputTable(e.value);
    })
})

function makeInfoInputTable(checkedUserSort){

    switch (checkedUserSort){
        case '2':
            infoInputTable.innerHTML =`
                <thead>
                    고객사 정보
                </thead>
                <tbody>
                    <tr>
                        <th>대표자</th>
                        <td>
                            <input type="text" th:field="*{representative}" placeholder="대표자">
                        </td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>
                            <input type="text" th:field="*{contact}" placeholder="연락처">
                        </td>
                    </tr>
                    <tr>
                        <th>비고</th>
                        <td>
                            <input type="text" th:field="*{note}" placeholder="비고">
                        </td>
                    </tr>
                </tbody>
            `;
            break;
        case '3':
            infoInputTable.innerHTML=`
                <thead>
                    고객 정보
                </thead>
                <tbody>
                    <tr>
                        <th>소속회사</th>
                        <td>
                            <select th:field="*{company}">
                                <option th:each="company : ${companys}" th:text="${company.userName}" th:value="${company.userId}"></option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>부서</th>
                        <td>
                            <input type="text" th:field="*{department}" placeholder="부서">
                        </td>
                    </tr>
                    <tr>
                        <th>직급</th>
                        <td>
                            <input type="text" th:field="*{position}" placeholder="직급">
                        </td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>
                            <input type="text" th:field="*{contact}" placeholder="연락처">
                        </td>
                    </tr>
                    <tr>
                        <th>비고</th>
                        <td>
                            <input type="text" th:field="*{note}" placeholder="비고">
                        </td>
                    </tr>
                </tbody>
            `;
            break;
        case '4':
            infoInputTable.innerHTML=`
                <thead>
                직원 정보
            </thead>
            <tbody>
                <tr>
                    <th>부서</th>
                    <td>
                        <input type="text" th:field="*{department}" placeholder="부서">
                    </td>
                </tr>
                <tr>
                    <th>직급</th>
                    <td>
                        <input type="text" th:field="*{position}" placeholder="직급">
                    </td>
                </tr>
                <tr>
                    <th>연락처</th>
                    <td>
                        <input type="text" th:field="*{contact}" placeholder="연락처">
                    </td>
                </tr>
                <tr>
                    <th>비고</th>
                    <td>
                        <input type="text" th:field="*{note}" placeholder="비고">
                    </td>
                </tr>
            </tbody>
            `;
            break;
    }
}