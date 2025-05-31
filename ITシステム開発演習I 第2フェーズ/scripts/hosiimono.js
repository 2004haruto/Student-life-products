document.addEventListener('DOMContentLoaded', function() {
    fetch('/items')
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById('itemTable').getElementsByTagName('tbody')[0];
            data.forEach((item, index) => {
                const newRow = table.insertRow();
                newRow.setAttribute('data-id', item.id);
                newRow.innerHTML = `
                    <td>${index + 1}</td>
                    <td><input type="text" value="${item.name}" id="syou${item.id}"></td>
                    <td><input type="text" value="${item.price}" id="kin${item.id}"></td>
                    <td><input type="text" value="${item.savings}" id="kounyu${item.id}"></td>
                    <td><input type="text" value="${item.link}" id="link${item.id}"></td>
                    <td><button type="button" class="deleteRow" data-id="${item.id}">削除</button></td>
                `;
            });
        });

    document.getElementById('addRow').addEventListener('click', function() {
        const table = document.getElementById('itemTable').getElementsByTagName('tbody')[0];
        const rowCount = table.rows.length + 1;
        const newRow = table.insertRow();
        newRow.innerHTML = `
            <td>${rowCount}</td>
            <td><input type="text" id="syou"></td>
            <td><input type="text" id="kin"></td>
            <td><input type="text" id="kounyu"></td>
            <td><input type="text" id="link"></td>
            <td><button type="button" class="deleteRow">削除</button>
        `;
    });

    document.getElementById('itemTable').addEventListener('click', function(event) {
        if (event.target && event.target.classList.contains('deleteRow')) {
            const row = event.target.closest('tr');
            const id = event.target.dataset.id;
            if (id) {
                fetch(`/items/${id}`, {
                    method: 'DELETE'
                }).then(() => {
                    row.remove();
                    updateRowNumbers();
                });
            } else {
                row.remove();
                updateRowNumbers();
            }
        }
    });

    function updateRowNumbers() {
        const table = document.getElementById('itemTable').getElementsByTagName('tbody')[0];
        for (let i = 0; i < table.rows.length; i++) {
            table.rows[i].cells[0].innerText = i + 1;
        }
    }

    var el = document.getElementById('itemTable').getElementsByTagName('tbody')[0];
    var sortable = Sortable.create(el, {
        animation: 150,
        handle: 'tr',
        onEnd: function(evt) {
            updateRowNumbers();
            const rows = Array.from(table.rows);
            rows.forEach((row, index) => {
                const id = row.getAttribute('data-id');
                if (id) {
                    fetch(`/items/${id}/position`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({ position: index + 1 })
                    });
                }
            });
        }
    });
});
