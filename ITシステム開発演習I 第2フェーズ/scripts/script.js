document.addEventListener('DOMContentLoaded', () => {
    const balanceElement = document.getElementById('balance');
    const monthlyTotalElement = document.getElementById('monthly-total');
    const monthSelect = document.getElementById('month-select');
    let balance = 0;
    let monthlyTotal = 0;
    let expenses = [];
    let fixedExpenses = [];

    const incomeForm = document.getElementById('income-form');
    const incomeTableBody = document.getElementById('income-table-body');

    const expenseForm = document.getElementById('expense-form');
    const expenseTableBody = document.getElementById('expense-table-body');

    const fixedExpenseForm = document.getElementById('fixed-expense-form');
    const backButton = document.getElementById('back-button');

    incomeForm.addEventListener('submit', (e) => {
        e.preventDefault();
        addIncome();
    });

    expenseForm.addEventListener('submit', (e) => {
        e.preventDefault();
        addExpense();
    });

    fixedExpenseForm.addEventListener('submit', (e) => {
        e.preventDefault();
        addFixedExpense();
    });

    backButton.addEventListener('click', () => {
        window.history.back();
    });

    monthSelect.addEventListener('change', (e) => {
        filterExpensesByMonth(e.target.value);
    });

    function addIncome() {
        const date = document.getElementById('income-date').value;
        const amount = parseFloat(document.getElementById('income-amount').value);

        if (!date || isNaN(amount) || amount <= 0) {
            alert('全てのフィールドを正しく入力してください');
            return;
        }

        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${date}</td>
            <td>${amount.toFixed(2)}</td>
        `;

        incomeTableBody.appendChild(row);

        balance += amount;
        monthlyTotal += amount;
        updateBalance();
        updateMonthlyTotal();

        incomeForm.reset();
    }

    function addExpense() {
        const date = document.getElementById('expense-date').value;
        const description = document.getElementById('description').value;
        const amount = parseFloat(document.getElementById('expense-amount').value);

        if (!date || !description || isNaN(amount) || amount <= 0) {
            alert('全てのフィールドを正しく入力してください');
            return;
        }

        const expense = {
            date,
            description,
            amount
        };
        expenses.push(expense);
        updateExpenseTable();

        balance -= amount;
        monthlyTotal -= amount;
        updateBalance();
        updateMonthlyTotal();

        addMonthToSelect(date);
        expenseForm.reset();
    }

    function addFixedExpense() {
        const description = document.getElementById('fixed-description').value;
        const amount = parseFloat(document.getElementById('fixed-amount').value);

        if (!description || isNaN(amount) || amount <= 0) {
            alert('全てのフィールドを正しく入力してください');
            return;
        }

        const fixedExpense = {
            description,
            amount
        };
        fixedExpenses.push(fixedExpense);
        updateExpenseTable();

        balance -= amount;
        monthlyTotal -= amount;
        updateBalance();
        updateMonthlyTotal();

        fixedExpenseForm.reset();
    }

    function updateBalance() {
        balanceElement.textContent = balance.toFixed(2);
    }

    function updateMonthlyTotal() {
        monthlyTotalElement.textContent = monthlyTotal.toFixed(2);
    }

    function updateExpenseTable() {
        const selectedMonth = monthSelect.value;
        filterExpensesByMonth(selectedMonth);
    }

    function filterExpensesByMonth(month) {
        expenseTableBody.innerHTML = '';
        expenses.forEach(expense => {
            const expenseDate = new Date(expense.date);
            const expenseMonth = `${expenseDate.getFullYear()}-${('0' + (expenseDate.getMonth() + 1)).slice(-2)}`;
            if (month === 'all' || month === expenseMonth) {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${expense.date}</td>
                    <td>${expense.description}</td>
                    <td>${expense.amount.toFixed(2)}</td>
                `;
                expenseTableBody.appendChild(row);
            }
        });

        fixedExpenses.forEach(expense => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>固定</td>
                <td>${expense.description}</td>
                <td>${expense.amount.toFixed(2)}</td>
            `;
            expenseTableBody.appendChild(row);
        });
    }

    function addMonthToSelect(date) {
        const expenseDate = new Date(date);
        const month = `${expenseDate.getFullYear()}-${('0' + (expenseDate.getMonth() + 1)).slice(-2)}`;
        if (![...monthSelect.options].some(option => option.value === month)) {
            const option = document.createElement('option');
            option.value = month;
            option.textContent = month;
            monthSelect.appendChild(option);
        }
    }
});
