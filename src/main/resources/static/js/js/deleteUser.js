$( "tbody" ).on( "click", "tr .buttonDelete", function() {
    var id = $(this).attr('data');
    $('.buttonAfterDelete').click(function() {
        deleteUserById(id);
        id = null;
    });

});
function deleteUserById(id) {
    $.ajax({
        url: '/admin/delete',
        datatype: 'json',
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            id: id
        }),
        success: function (data) {
            console.log(data);
            var elementStrinTableByID = $('tbody th').filter(function () {
                return $(this).text() == id;
            }).parent().remove();
            $('#exampleModal1').modal('hide');

        }
    });
}
