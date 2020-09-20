// preloader
var hellopreloader = document.getElementById("hellopreloader_preload");

var cache;
if (sessionStorage.getItem('cache') === 'true') {
    cache = true;
} else {
    cache = false;
}

function fadeOutnojquery(el) {
    el.style.opacity = 1;
    var interhellopreloader = setInterval(function () {
        el.style.opacity = el.style.opacity - 0.05;
        if (el.style.opacity <= 0.05) {
            clearInterval(interhellopreloader);
            hellopreloader.style.display = "none";
        }
    }, 16);
}

window.onload = function () {
    setTimeout(function () {
        fadeOutnojquery(hellopreloader);
    }, 0);
};

//datatables
$(document).ready(function() {
    $('#statisticDataTable').DataTable();
} );

//choose test
$().ready(
    function () {
        var alertBlock = document.getElementById('alertt');

        if(cache && alertBlock) {
            alertBlock.style.display = 'block';
            $('#alertt').toast('show');
        } else {
            alertBlock.style.display = 'none';
            sessionStorage.setItem('cache', true);
        }
        $("#themes").change(function (event) {
            $.ajax({
                url: "/choose/userChoose",
                type: "GET",
                dataType: "json",
                data: {topic: $(event.target).val()},
            })
                .done(function(data) {
                    setTests(data)
                })
                .fail(function(xhr, status, error) {
                    alert(xhr.responseText + '|\n' + status + '|\n'
                        +error);
                });
        });
    });
var setTests = function (data) {
    var submitButton = document.getElementById('submit-button');
    submitButton.disabled = false;

    $('#testss').find('option').remove();
    $.each(data, function (index, value) {
        $('#testss').append(new Option(value, value));
    });

    var alertBlock = document.getElementById('alertt');
    sessionStorage.setItem('cache', true);
    alertBlock.style.display = 'none';
    $('#alertt').toast('hidden');
};

window.onbeforeunload = function () {
    var alertBlock = document.getElementById('alertt');

    if (!alertBlock) {
        sessionStorage.setItem('cache', false);
    }
};

function changeStorage() {
    sessionStorage.setItem('cache', false);
}

//AA
$().ready(function () {
    $("#answers").change(function (event) {
        drawTable($(event.target).val());
    });
});

function drawTable(count) {
    $('#answerList tbody').empty();
    var html = '';
    for (var i = 0; i < count; i++) {
        let j = i+1;
        html += '<tr><td>' +
            j + '</td><td>' +
            '<input class="form-control" type="text" name="answer[]" value="">' + '</td><td>' +
            '<select id="correct" name="correct[]" class="select-dropdown form-control">'+
            '<option selected value="false">False</option>'+
            '<option value="true">True</option>'+
            '</select>\'\n' + '</td></tr>';
    }
    $('#answerList tbody').append(html);
}


$().ready(function () {
    $("#topics").change(function (event) {
        $.ajax({
            url: "/getTestsForEdit",
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            data: {
                id: $(event.target).val()
            }, success: function (data) {
                console.log("SUCCESS: ", data);
                setTestsId(data);
            }, error: function (e) {
                console.log("ERROR: ", e);
                alert("error" + JSON.stringify(e));
            },
            done: function (e) {
                console.log("DONE", e);
                alert("error");
            }
        })
    });
    $("#tests").change(function (event) {
        $.ajax({
            url: "/getQuestionForEdit",
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            data: {
                id: $(event.target).val()
            }, success: function (data) {
                console.log("SUCCESS: ", data);
                setQuestion(data);
                addButtonTest($(event.target).val());
            }, error: function (e) {
                console.log("ERROR: ", e);
                alert("error" + JSON.stringify(e));
            },
            done: function (e) {
                console.log("DONE", e);
                alert("error");
            }
        })
    });
    $("#questions").change(function (event) {
        $.ajax({
            url: "/getAnswersForEdit",
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            data: {
                id: $(event.target).val()
            }, success: function (data) {
                console.log("SUCCESS: ", data);
                drawTableAnswer(data);
                addButtonAnswer($(event.target).val());

            }, error: function (e) {
                console.log("ERROR: ", e);
                alert("error" + JSON.stringify(e));
            },
            done: function (e) {
                console.log("DONE", e);
                alert("error");
            }
        })
    });
});

function setTestsId(data) {
    $('#tests').find('option').remove();
    let opt = new Option('Choose test', '', true, true);
    opt.setAttribute("disabled", "disabled");
    opt.setAttribute("hidden", "hidden");
    $('#tests').append(opt)
    $.each(data, function (index, value) {
        $('#tests').append(new Option(value.description, value.id));
    });
}

function setQuestion(data) {
    $('#questions').find('option').remove();
    let opt = new Option('Choose question', '', true, true);
    opt.setAttribute("disabled", "disabled");
    opt.setAttribute("hidden", "hidden");
    $('#questions').append(opt)
    $.each(data, function (index, value) {
        $('#questions').append(new Option(value.description, value.id));
    });
}

function drawTableAnswer(data) {
    $('#tableAnswers tbody').empty();
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<tr><td>' +
            data[i].id + '</td><td>' +
            data[i].description + '</td><td>' +
            data[i].correct + '</td><td>' +
            '<a href="/editAnswer/' + data[i].id + '">Edit</a>' + '</td><td>' +
            '<a href="/deleteAnswer/' + data[i].id + '">Delete</a>' + '</td></tr>';
    }
    $("#tableAnswers tbody").append(html);
}

function setForm(data) {

}

function addButtonAnswer(val) {
    $("#addButtonForm").html('<a href="/addAnswer/' + val + '">Add Answer</a>')
}

function addButtonTest(val) {
    $("#editTestForm").html('<a href="/getTest/' + val + '">Edit Question</a>')
}


$().ready(function () {
    $("#topicList").change(function (event) {
        $.ajax({
            url: "/getTests",
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            data: {
                id: $(event.target).val()
            }, success: function (data) {
                console.log("SUCCESS: ", data);
                setTestsCreate(data);
            }, error: function (e) {
                console.log("ERROR: ", e);
                alert("error" + JSON.stringify(e));
            },
            done: function (e) {
                console.log("DONE", e);
                alert("error");
            }
        })
    });
});

function setTestsCreate (data) {
    $('#testList').find('option').remove();
    $.each(data, function (index,value) {
        $('#testList').append(new Option(value.name, value.id));
    });
}