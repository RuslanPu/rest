
// $( "tbody tr" ).on( "click", ".buttonEdit", function() {
//     console.log( $( this ).text() );
// });
$( "tbody" ).on( "click", "tr .buttonEdit", function() {

    $('.roles').find('option').remove();
    var id = $(this).attr('data');
    getUserById(id);
});
function getUserById(id) {
    $.ajax({
        url: '/admin/requestById',
        datatype: 'json',
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            id: id
        }),
        success: function (data) {
            console.log(data);
            $(".edit .name").attr("value", data.user.name);
            $(".edit .id").attr("value", data.user.id);
            $(".edit .lastName").attr("value", data.user.lastName);
            $(".edit .age").attr("value", data.user.age);
            $(".edit .password").attr("value", data.user.password);
            $(".edit .email").attr("value", data.user.email);
            var objSelect = $(".edit .roles");

            $.each(data.allRoles, function (key, value) {
                $(objSelect).append($("<option></option>", {value: value.name, text: value.name}));
            });


            $.each(data.user.roles, function (index, value) {
                selected($(".roles option"), value.name);
            });


        }
    });

    function selected(arr, value) {
        $(arr).each(function () {
            if ($(this).val() == value) { // EDITED THIS LINE
                $(this).attr("selected", "selected");
            }
        });
    }

}