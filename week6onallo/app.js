const InputText = document.querySelector('#bemenet');
const DingDong = document.querySelector('#gomb');
const MyListElement = document.querySelector('#ToDoList');

DingDong.addEventListener('click', () => {
    console.log(InputText.value);

    const MyList = document.createElement('li');
    MyList.textContent = InputText.value;
    
    MyList.addEventListener('click', () => {
        MyList.classList.add('MyElements');
    });

    MyListElement.appendChild(MyList);
});

