(function () {

    $(".data-table table").on('click', "tr td a[ahref][ajax=true]", function (e) {
        var $this = $(e.target);
        var $tr = $this.parents(".data-table table tr");
        if ($tr.length === 0) {
            return false;
        }
        var confirm = $this.attr("confirm");
        var data = $tr.data();
        var href = $this.attr("ahref");
        var postFunction = function () {
            $.post(href, data, function () {
                messager.message(lang.option.success, function () {
                    window.location.reload();
                });
            }, "JSON");
        };
        if (confirm == "true") {
            messager.confirm(window.lang.option.confirmTitle, window.lang.option.confirmOption.format($this.text()), postFunction)
        } else {
            postFunction();
        }
        return false;
    })

})();