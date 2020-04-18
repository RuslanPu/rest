$.ajax({
    url: '/user/getUserAfterLogin',
    datatype: 'json',
    type: 'get',
    contenntType: 'application/json',
    data: JSON,
    success: function (data) {
        console.log(data);
    }
});