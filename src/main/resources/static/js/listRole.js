function moduleRoleEdit() {
    $('#Modal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var idR = button.data('target1')
        var nameR = button.data('target2')
        var tar = button.data('target')
        var modal = $(this)
        console.log(idR)
        console.log(nameR)
        console.log(tar)
        modal.find('.modal-title').text('Edit ' + nameR)
        modal.find('.id-modal input').val(idR)
        modal.find('.name-modal input').val(nameR)})
}

function status(response) {
    if (response.status >= 200 && response.status < 300) {
        return Promise.resolve(response)
    } else {
        return Promise.reject(new Error(response.statusText))
    }
}

function json(response) {
    return response.json()
}

function roleTable() {
    let count = 0;
    fetch('http://localhost:8080/roles')
        .then(status)
        .then(json)
        .then(function (roles) {
            console.log('Request succeeded with JSON roles response', roles);
            let li = '';
            li += `<THEAD>
                        <tr>
                            <th scope="col">№</th>
                            <th scope="col">name</th>
                            <th scope="col" colspan="2">action</th>
                        </tr>
                        </THEAD>
                        <TBODY>`
            roles.forEach(role => {
                count = count + 1;
                li += `
                       <th scope = "row" text = ${count} > ${count} </th>
                       <td>${role.role}</td>
                   
                       <td>
 <button type="button" class="btn-warning btn-lg btn-block" data-toggle="modal" data-target="#Modal" data-target1="${role.id}" data-target2="${role.role}">Edit</button>
                       </td>
                       <td>
 <button onclick=" deleteRole(${role.id})"  type = "button"  role = "button" class = "btn btn-danger btn-lg btn-block">Delete</button>
                       </td>
                       </tr>`
            })
            li += `</TBODY>`
            $("#tableListRole").html(li);

        }).catch(function (error) {
        console.log('Request failed users', error);
    });
}

let editRoleForm = document.getElementById('editForm');
let url = 'http://localhost:8080/role'

editRoleForm.addEventListener('submit', function (event) {
    let formData = new FormData(this);
    formData = Object.fromEntries(formData);
    console.log(formData);
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(formData)
    })
        .then(roleTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });

});

let addUserForm = document.getElementById('addForm');

addUserForm.addEventListener('submit', function (event) {
    let formData = new FormData(this);
    formData = Object.fromEntries(formData);
    console.log(formData);
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(formData)
    })
        .then(roleTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });

});







function deleteRole(idRole) {
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(idRole)
    })
        .then(roleTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });
}
