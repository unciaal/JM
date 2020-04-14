function moduleUserEdit() {
    $('#Modal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var id = button.data('userid')
        var name = button.data('username')
        var login = button.data('userlogin')
        var password = button.data('userpassword')
        var email = button.data('useremail')
        var modal = $(this)
        modal.find('.modal-title').text('Edit ' + name)
        modal.find('.id-modal input').val(id)
        modal.find('.name-modal input').val(name)
        modal.find('.login-modal input').val(login)
        modal.find('.password-modal input').val("")
        modal.find('.email-modal input').val(email)
    })
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

async function roles() {
    fetch('http://localhost:8888/roles')
        .then(status)
        .then(json)
        .then(function (roles) {
            console.log('Request succeeded with JSON roles response', roles);
            let li = '';
            roles.forEach(role => {
                li += `
            <div each="role : ${roles}" class="form-check form-check-inline">
                        <label class="form-check-label" text = '${role.role}' >${role.role}</label>
                        <input class="form-check-input"  value="${role.id}" type="checkbox">
                        <br>
                    </div>
            `
            })
            $("#roleListEdit").html(li);
            $("#roleListAdd").html(li);
        })
        .catch(function (error) {
            console.log('Request failed roles', error);
        });
}

function userTable() {
    let count = 0;
    fetch('http://localhost:8888/users')
        .then(status)
        .then(json)
        .then(function (users) {
            console.log('Request succeeded with JSON users response', users);
            let li = '';
            li += `<THEAD>
                <tr>
                <th scope="col">№</th>
                <th scope="col">name</th>
                <th scope="col">login</th>
                <th scope="col">email</th>
                <th scope="col">role(s)</th>
                <th scope="col" colspan="2">action</th>
                </tr>
                </THEAD>
                <TBODY>`
            users.forEach(user => {
                count = count + 1;
                li += `
                       <th scope = "row" text = ${count} > ${count} </th>
                       <td text=${user.name}> ${user.name}</td>
                       <td text=${user.login}> ${user.login} </td>
                       <td text=${user.email}> ${user.email}</td>
                       <td text=${user.roles}>${user.roles.map(role => role.role)}</td>
                    
                       <td>
 <button  type = "button" class = "btn-warning btn-lg btn-block" data-toggle = "modal" data-target = "#Modal" data-userid = "${user.id}" data-username = "${user.name}" data-userlogin = "${user.login}" data-useremail = "${user.email}" data-userpassword = "${user.password}" data-userroles = "${user.roles}">Edit</button>
                       </td>
                       <td>
                       
 <button onclick=" deleteUser(${user.id})"  type = "button"  role = "button" class = "btn btn-danger btn-lg btn-block">Delete</button>
                       </td>
                       </tr>`
            })
            li += `</TBODY>`
            $("#tableListUser").html(li);

        }).catch(function (error) {
        console.log('Request failed users', error);
    });
}


let editUserForm = document.getElementById('editForm');
let url = 'http://localhost:8888/user'

editUserForm.addEventListener('submit', function (event) {
    let formData = new FormData(this);
    formData = Object.fromEntries(formData);
    var arr = $(':checked').map(function (i, el) {
        return $(el).val();
    }).get();
    formData.strIdRoles = arr;
    console.log(formData);
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(formData)
    })
        .then(userTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });

});

let addUserForm = document.getElementById('addForm');

addUserForm.addEventListener('submit', function (event) {
    let formData = new FormData(this);
    formData = Object.fromEntries(formData);
    var arr = $(':checked').map(function (i, el) {
        return $(el).val();
    }).get();
    console.log(arr);
    formData.strIdRoles = arr;
    console.log(formData);
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(formData)
    })
        .then(userTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });

});


function deleteUser(idUser) {
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json', // отправляемые данные
        },
        body: JSON.stringify(idUser)
    })
        .then(userTable)
        .catch(function (error) {
            console.log('Request failed', error);
        });
}




