function validate() {
    let username = document.form.username.value;
    let password = document.form.password.value;
    jQuery.validator.addMethod(
        'regexp',
        function (value, element, regexp) {
            let re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Please check your input."
    );
    if (username == null || username === "") {
        alert("Username cannot be blank");
        return false;
    } else if (password == null || password === "") {
        alert("Password cannot be blank");
        return false;
    }
}

$("#registerForm").validate({
    rules: {
        email: {
            required: true,
            email: true
        },
        password: {
            required: true,
            minlength: 4,
            regexp: '^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$'
        }
    },
    messages: {
        email: {
            required: "Поле обязательно для заполнения!"
        },
        password: {
            required: "Поле обязательно для заполнения!",
            minlength: jQuery.validator.format("Длина пароля должна быть больше 5 символов"),
            regexp: 'Пароль должен содержать как минимум один числовой символ один буквенный символ'
        }
    },
    submitHandler: function () {
        alert("Валидация успешна!");
    }
});

