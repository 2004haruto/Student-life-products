document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const inputFields = document.querySelectorAll('.input-field');
    const loginBtn = document.querySelector('.loginBtn');
    const idError = document.getElementById('idError');
    const passwordError = document.getElementById('passwordError');

    // フォーカスされたフィールドの背景色を変更
    inputFields.forEach(input => {
        input.addEventListener('focus', function() {
            input.style.backgroundColor = '#e0f7fa';
            input.style.boxShadow = '0 0 5px rgba(0, 0, 0, 0.2)';
        });
        input.addEventListener('blur', function() {
            input.style.backgroundColor = '';
            input.style.boxShadow = '';
        });
    });

    // フォーム送信時のバリデーションとボタンアニメーション
    loginForm.addEventListener('submit', function(event) {
        let isValid = true;
        idError.style.display = 'none';
        passwordError.style.display = 'none';

        if (loginForm.id.value.trim() === '') {
            idError.style.display = 'block';
            isValid = false;
        }

        if (loginForm.password.value.trim() === '') {
            passwordError.style.display = 'block';
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault();
            return;
        }

        // 送信ボタンのアニメーション
        loginBtn.textContent = 'ログイン中...';
        loginBtn.disabled = true;
        loginBtn.style.backgroundColor = '#ccc';
        loginBtn.style.transform = 'scale(0.98)';

        // 仮のログイン処理のシミュレーション
        setTimeout(function() {
            loginForm.submit();
        }, 2000);
    });
});
