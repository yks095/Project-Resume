$('#save_project').click(function () {

    var jsonData = JSON.stringify({
        name: $('#project_name').val(),
        period: $('#project_period').val(),
        persons: $('#project_persons').val(),
        description: $('#project_description').val()
    });

    $.ajax({
        url: "http://localhost:8080/project/save",
        type: "POST",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            console.log("1");
            location.href = '/project';
            console.log("2");
        },
        error: function () {
            alert('저장 실패!');
        }
    });
});