$('#beforeAdd').click(function () {
    $('.add .roles').find('option').remove();
    $.ajax({
        url: '/admin/add',
        datatype: 'json',
        type: "get",
        contentType: "application/json",
        data: JSON,
        success: function (data) {
            console.log(data);
            var objSelect = $(".add .roles");

            $.each(data.allRoles, function (key, value) {
                $(objSelect).append($("<option></option>", {value: value.name, text: value.name}));
            });
        }
    });
});


$('.buttonAddUser').click(function () {
    var roles = new Array;
    $('.add .roles option').each(function () {
        if ($(this).prop('selected') == true) {
            roles.push($(this).val());
        }
    });


    var name = $(".add input[name='name']").val();
    var lastName = $(".add input[name='lastName']").val();
    var age = $(".add input[name='age']").val();
    var password = $(".add input[name='password']").val();
    var email = $(".add input[name='email']").val();
    $.ajax({
        url: '/admin/add',
        datatype: 'json',
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            name: name,
            lastName: lastName,
            age: age,
            password: password,
            email: email,
            roles: roles
        }),
        success: function (data) {
            console.log(data);
            window.location.href = "/admin/users";
        }
    });

});