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

    $('#tests').find('option').remove();
    $.each(data, function (index, value) {
        $('#tests').append(new Option(value, value));
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