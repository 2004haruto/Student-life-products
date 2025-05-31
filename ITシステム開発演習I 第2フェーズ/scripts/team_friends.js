document.addEventListener('DOMContentLoaded', () => {
    const balanceElement = document.getElementById('balanceAmount');
    const savingsGoalElement = document.getElementById('savingsGoal');
    const savingsForm = document.getElementById('savingsForm');

    let savingsGoal = 0;

    if (savingsForm) {
        savingsForm.addEventListener('submit', (event) => {
            event.preventDefault();
            const newGoal = parseInt(document.getElementById('savingsGoalInput').value);
            savingsGoal = newGoal;
            updateSavingsGoal();
        });
    }

    function updateSavingsGoal() {
        savingsGoalElement.textContent = `¥${savingsGoal}`;
    }

    const wishListTable = document.getElementById('wish_list_table');

    // スクロールイベントリスナーを追加
    if (wishListTable) {
        wishListTable.addEventListener('wheel', (event) => {
            event.preventDefault();
            wishListTable.scrollTop += event.deltaY;
        });

        // マウスドラッグによるスクロールを有効化
        let isDragging = false;
        let startX;
        let scrollLeft;

        wishListTable.addEventListener('mousedown', (event) => {
            isDragging = true;
            startX = event.pageX - wishListTable.offsetLeft;
            scrollLeft = wishListTable.scrollLeft;
        });

        wishListTable.addEventListener('mouseleave', () => {
            isDragging = false;
        });

        wishListTable.addEventListener('mouseup', () => {
            isDragging = false;
        });

        wishListTable.addEventListener('mousemove', (event) => {
            if (!isDragging) return;
            event.preventDefault();
            const x = event.pageX - wishListTable.offsetLeft;
            const walk = (x - startX) * 3; // スクロール速度調整
            wishListTable.scrollLeft = scrollLeft - walk;
        });
    }
});

