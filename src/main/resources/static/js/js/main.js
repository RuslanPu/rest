//after load main page, display user list
$.ajax({
   url:'/admin/getUsersAfterLogin',
   datatype: 'json',
   type: 'get',
   contentType: 'application/json',
   data: JSON,
   success: function(data) {
       console.log(data);
       $("#emailUser b").text(data.user.email);
       $.each(data.user.roles, function(key, value) {
           $("#userRoles").append($("<span></span>", {text: value.name, class:"mr-1"}));
       });

       var table = $('tbody');
       $(table).find('tr').remove();
       for (i = 0; i < data.listUsers.length; i++) {
           var str = '<tr>';
           str += '<th class="row">' + data.listUsers[i].id + '</th>';
           str += '<td>' + data.listUsers[i].name + '</td>';
           str += '<td>' + data.listUsers[i].lastName + '</td>';
           str += '<td>' + data.listUsers[i].age + '</td>';
           str += '<td>' + data.listUsers[i].email + '</td>';
           var role = '<td>';
           for (j = 0; j < data.listUsers[i].roles.length; j++) {
               role += '<span class="mr-1">' + data.listUsers[i].roles[j].name + '</span>';
           }
           role += '</td>';
           str += role;
           str += '<td><button type="button" class="buttonEdit btn btn-info" data-toggle="modal" data-target="#exampleModal" data="'+ data.listUsers[i].id +'">Edit</button></td>';
           str += '<td><button type="button" class="buttonDelete btn btn-danger" data-toggle="modal" data-target="#exampleModal1" data="'+ data.listUsers[i].id +'">Delete</button></td>';
           str+='</tr>';
           table.append(str);
       }
   }
});

function addCheckRoleInUserRoles(arr) {
    var arr1 = new Array();
    $(arr).each(function (index, value) {
        if ($(this).prop('selected') == true) {
            arr1.push($(this).val());
        }
    });
    return arr1;

}

function checkOption(arr) {
    var i = 0;
    $(arr).each(function () {
        if ($(this).prop('selected') == true) {
            i++
        }
    });
    if (i == 0) {
        return false;
    } else {
        return true;
    }
}

function unicEmail(email) {
    //function which send ajax request to the server
    $.ajax({
        url: '/user/checkEmail',
        datatype: 'json',
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            email: email
        }),
        success: function (data) {
            console.log(data);
            return data.unicEmail;
        }
    });
}

