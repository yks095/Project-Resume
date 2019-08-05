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
            location.href = '/project';
        },
        error: function () {
            alert('저장 실패!');
        }
    });
});

$('.deleteButton').click(function () {
    $.ajax({
        url: "http://localhost:8080/project/delete/" + $(this).val(),
        type: "DELETE",
        contentType: "application/json",
        success: function () {
            alert('삭제 성공!');
            location.reload();
        },
        error: function () {
            alert('삭제 실패!');
        }
    });
});

$('.lookButton').click(function () {

    location.href = "/project/look/" + $(this).val();

});

$('.modifyButton').click(function () {

    var jsonData = JSON.stringify({
        name: $(this).parent().parent().find('.show_name').text(),
        period: $(this).parent().parent().find('.show_period').text(),
        persons: $(this).parent().parent().find('.show_persons').text(),
        description: $(this).parent().parent().find('.show_description').text()
    });

    $.ajax({
        url: "http://localhost:8080/project/modify/" + $(this).val(),
        type: "PUT",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            alert('수정 성공!');
            location.reload();
        },
        error: function () {
            alert('수정 실패!');
        }
    });
});

$('.completeButton').click(function () {

    location.href = "/project";

});
