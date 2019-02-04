$('#btn-save').on('click',

    function () {
        var file = $('#img')[0].files[0];
        var formData = new FormData();
        formData.append('data', file);

        $.ajax({
            type: 'POST',
            url: '/upload',
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                alert('이미지 등록 성공');
                /*속성부여하는 메서드,,   attr("속성","값") 또는 attr({"속성1": "새값1", "속성2":"새값2"}) 
                이런식으로 사용
                */
                alert(data);
                $('#result-image').attr("src", data);
            },
            error: function (request, status, error) {
                alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });