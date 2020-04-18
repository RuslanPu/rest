$.ajax({
    url: '/user/getUserAfterLogin',
    datatype: 'json',
    type: 'get',
    contenntType: 'application/json',
    data: JSON,
    success: function (data) {
        console.log(data);
        $("tbody .id").text(data.user.id);
        $("tbody .name").text(data.user.name);
        $("tbody .lastName").text(data.user.lastName);
        $("tbody .age").text(data.user.age);
        $("tbody .email").text(data.user.email);
        $("#emailUser b").text(data.user.email);



        $.each(data.user.roles, function(key, value){
            $("tbody .roles").append($("<span></span>", {text: value.name, class: "pr-1"}));
            $("#userRoles").append($("<span></span>", {text: value.name, class:"mr-1"}));
        });

    }
});