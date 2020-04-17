$.ajax({
    url: '/userPage',
    datatype: 'json',
    type: 'post',
    contenntType: 'application/json',
    data: JSON,
    success: function (data) {
        console.log(data);
    }
});