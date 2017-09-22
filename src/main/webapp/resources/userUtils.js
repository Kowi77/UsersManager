var ajaxUrl = "user/";
var datatableApi;
var form=$('#detailsForm');

function add() {
    $("#modalTitle").html("Добавление пользователя");
    $("#detailsForm").find(":input").val("");
    $("#editRow").modal();
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data:form.serialize(),
        success: function () {
            $("#editRow").modal("hide");
             updateTable();
            //successNoty("common.saved");
        }
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: "DELETE",
        success: function () {
            updateTable();
            //  successNoty("common.deleted");
        }
    });
}

function updateRow(id) {
    $("#modalTitle").html("Редактирование пользователя");
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

    function updateTable() {
        $.ajax({
            type: "GET",
            url: ajaxUrl,
            dataType: 'json',
            success: function (data) {
                datatableApi.clear().rows.add(data).draw();
            }
        });
    }

$(function () {
    datatableApi = $("#datatable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": false,
        "columns": [
            {"data": "firstName"},
            {"data": "lastName"},
            {"data": "birthday"},
            {"data": "login"},
            {"data": "password"},
            {"data": "info"},
            {"data": "adress"},
            {"orderable": false,
                 "defaultContent": "",
                 "render": renderEditBtn
            },
            {"orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [[0,"asc"]]//,
       // "initComplete": makeEditable
    });
});
/*
function makeEditable() {
    form = $('#detailsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(key) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-ok'></span> &nbsp;" + i18n[key],
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    failedNote = new Noty({
        text: "<span class='glyphicon glyphicon-exclamation-sign'></span> &nbsp;" + i18n["common.errorStatus"] + ": " + jqXHR.status + (jqXHR.responseJSON ? "<br>" + jqXHR.responseJSON : ""),
        type: "error",
        layout: "bottomRight"
    }).show();
}*/

function renderEditBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='updateRow(" + row.id + ");'>" +
            "<span class='glyphicon glyphicon-pencil' cursor='pointer' aria-hidden='true'></span></a>";
    }
}

function renderDeleteBtn(data, type, row) {
        return "<a onclick='deleteRow(" + row.id + ");'>" +
            "<span class='glyphicon glyphicon-remove' cursor='pointer' aria-hidden='true'></span></a>";
}
