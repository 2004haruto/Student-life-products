document.addEventListener("DOMContentLoaded", function() {
    const monthSelect = document.getElementById("month-select");
    const selectButton = document.getElementById("select-button");
    const incomeSections = document.querySelectorAll("div[id^='income-']");
    const spendingSections = document.querySelectorAll("div[id^='spending-']");
    const monthlyTotalHeader = document.getElementById("monthly-total-header");
    const monthlyTotalSpan = document.getElementById("monthly-total");

    selectButton.addEventListener("click", function() {
        const selectedMonth = monthSelect.value;
        const showTotal = selectedMonth !== "all";

        let totalIncome = 0;
        let totalSpending = 0;

        // 月ごとのデータの表示を切り替え
        incomeSections.forEach(section => {
            if (selectedMonth === "all" || section.id === "income-" + selectedMonth) {
                section.style.display = "";
                if (section.id === "income-" + selectedMonth) {
                    section.querySelectorAll("td:nth-child(2)").forEach(cell => {
                        totalIncome += parseInt(cell.textContent.replace(/[^0-9]/g, ''), 10);
                    });
                }
            } else {
                section.style.display = "none";
            }
        });

        spendingSections.forEach(section => {
            if (selectedMonth === "all" || section.id === "spending-" + selectedMonth) {
                section.style.display = "";
                if (section.id === "spending-" + selectedMonth) {
                    section.querySelectorAll("td:nth-child(3)").forEach(cell => {
                        totalSpending += parseInt(cell.textContent.replace(/[^0-9]/g, ''), 10);
                    });
                }
            } else {
                section.style.display = "none";
            }
        });

        const monthlyTotal = totalIncome - totalSpending;
        monthlyTotalSpan.textContent = monthlyTotal + " 円";

        // 総計の表示を切り替え
        monthlyTotalHeader.style.display = showTotal ? "" : "none";
    });

    // 初期表示
    selectButton.dispatchEvent(new Event("click"));
});