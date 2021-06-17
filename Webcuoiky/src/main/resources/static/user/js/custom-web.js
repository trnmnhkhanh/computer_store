var data = {};
$('#email').change(function (e) {
        e.preventDefault(); //Chống load trang
        var email = $('#email').val();
        if (email.length > 0) {
            data["email"] = email;
            $.ajax({
                url: '/register/validate',
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(data),
                success: function (data) {
                    if (data.code === 0) {
                        $('#error-email').text(data.msg);
                        $('#error-email').addClass("text-success").removeClass("text-danger");
                        $('#btnSubmit').removeAttr("disabled");
                    } else {
                        $('#error-email').text(data.msg);
                        $('#error-email').addClass("text-danger").removeClass("text-success");
                        $('#btnSubmit').attr("disabled", "disabled");
                    }
                },
                error: function (error) {
                    console.log(error)
                    alert("Lỗi hệ thống");
                }
            })
        }
    }
);
