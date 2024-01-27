document.addEventListener("DOMContentLoaded" , function () {
    getCategories();
});

const getCategories = () => {
    fetch("http://localhost:8080/category").then((response) => {
        return response.json();
    }).then((data) => {
const categorySelect = document.getElementById('categoryId')
        data.map((category) =>{ //for each loop
            const option = document.createElement('option');
            option.value = category.id;
            option.text = category.name;
            categorySelect.appendChild(option);
        });


        console.log(data);
    }).catch((error) => {
        console.log(error);
    })
}
    const createItem = (event) => {
        event.preventDefault();

        let itemName = document.getElementById('name').value;
        let price = document.getElementById('price').value;
        let qty = document.getElementById('qty').value;
        let categoryId = document.getElementById('categoryId').value;

        const data ={ 
            "name" : itemName,
            "price" : price,
            "qty" : qty,
            "categoryId" : categoryId
        }

        fetch ("http://localhost:8080/item" , {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type" : "application/json"
            }
        }).then((response) => {
            return response.json();
        }).then((data) => {
            console.log(data);
        }).catch((error) => {
            console.log(error);
        })
    
}