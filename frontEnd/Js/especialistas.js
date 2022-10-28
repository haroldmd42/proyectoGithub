
function loadData(){
    let request = sendRequest('especialistas/list', 'GET', '')
    let table = document.getElementById('especialists-table');
    table.innerHTML = "";
    request.onload = function(){
        
        let data = request.response;
        console.log(data);
        data.forEach(element => {
            table.innerHTML += `
                <tr>
                    <th>${element.idEspecialistas}</th>
                    <td>${element.especialidad}</td>
                    <td>${element.nombre}</td>
                    <td>${element.apellidos}</td>
                    <td>${element.disponibiliad}</td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick='window.location = "form_especialistas.html?id=${element.idEspecialistas}"'>Editar</button>
                        <button type="button" class="btn btn-danger" onclick='deleteEspecialistas(${element.idEspecialistas})'>Eliminar</button>
                    </td>
                </tr>

                `
        });
    }
    request.onerror = function(){
        table.innerHTML = `
            <tr>
                <td colspan="6">Error al recuperar los datos.</td>
            </tr>
        `;
    }
}

function loadEspecialista(idEspecialistas){
    let request = sendRequest('especialista/list/'+idEspecialistas, 'GET', '')
    let especiality = document.getElementById('especialist-especiality')
    let name = document.getElementById('especialist-name')
    let apell = document.getElementById('especialist-apell')
    let disponib = document.getElementById('especialist-disponib')
    let id = document.getElementById('especialist-id')
    request.onload = function(){
        
        let data = request.response
        id.value = data.idEspecialistas
        especiality.value = data.especialidad
        name.value = data.nombre
        apell.value = data.apellidos
        disponib.value = data.disponibiliad
    }
    request.onerror = function(){
        alert("Error al recuperar los datos.");
    }
}

function deleteEspecialista(idEspecialistas){
    let request = sendRequest('especialista/'+idEspecialistas, 'DELETE', '')
    request.onload = function(){
        loadData()
    }
}

function saveEspecialista(){
    let especiality = document.getElementById('especialist-especiality').value
    let name = document.getElementById('especialist-name').value
    let apell = document.getElementById('especialist-apell').value
    let disponib = document.getElementById('especialist-disponib').value
    let id = document.getElementById('especialist-id').value
    let data = {'idEspecialistas': id,'especialidad':especiality,'nombre': name, 'apellidos': apell, 'disponibilidad':disponib }
    let request = sendRequest('especialista/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        window.location = 'especialistas.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}