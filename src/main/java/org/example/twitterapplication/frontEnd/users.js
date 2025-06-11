async function loadUserGrid() {
    const userGrid = document.getElementById('userGrid');
    userGrid.innerHTML = '';

    try {
        document.getElementById('spinner').style.display = 'block';

        const response = await fetch('http://localhost:8080/user/getAll');
        if (!response.ok) {
            throw new Error('Failed to load users');
        }

        const users = await response.json();

        users.forEach(user => {
            const userCard = document.createElement('div');
            userCard.classList.add('col-md-4', 'col-sm-6', 'col-xs-12');

            userCard.innerHTML = `
                <div class="card shadow-sm h-100">
                    <img src="https://via.placeholder.com/150" class="card-img-top" alt="${user.name}">
                    <div class="card-body">
                        <h5 class="card-title">${user.name}</h5>
                        <p class="card-text">Email: ${user.email}</p>
                        <p class="card-text">Timezone: ${user.timezone}</p>
                        <a href="user-details.html?userId=${user.id}" class="btn btn-primary">View Details</a>
                    </div>
                </div>
            `;
            userGrid.appendChild(userCard);
        });

    } catch (error) {
        console.error('Error loading users:', error);
        document.getElementById('errorMessage').style.display = 'block';
    } finally {
        document.getElementById('spinner').style.display = 'none';
    }
}

document.getElementById('createUserForm')
    .addEventListener('submit', async function (event) {
    event.preventDefault();

    const userName = document.getElementById('userName').value;
    const userEmail = document.getElementById('userEmail').value;
    const userTimezone = document.getElementById('userTimezone').value;

    if (!userName || !userEmail || !userTimezone) {
        alert('All fields are required.');
        return;
    }

    const createUserDto = {
        name: userName,
        email: userEmail,
        timezone: userTimezone
    };

    try {
        document.getElementById('spinner').style.display = 'block';
        document.getElementById('errorMessage').style.display = 'none';

        const response = await fetch('http://localhost:8080/user/create', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(createUserDto),
        });

        if (!response.ok) {
            throw new Error('Failed to create user');
        }

        const createdUser = await response.json();

        alert(`User ${createdUser.name} created successfully!`);

        document.getElementById('createUserForm').reset();
        document.getElementById('createUserContainer').style.display = 'none';

        loadUserGrid();

    } catch (error) {
        console.error('Error creating user:', error);
        document.getElementById('errorMessage').style.display = 'block';
    } finally {
        document.getElementById('spinner').style.display = 'none';
    }
});


document.getElementById('toggleCreateForm').addEventListener('click', function () {
    const formContainer = document.getElementById('createUserContainer');
    formContainer.style.display = formContainer.style.display === 'none' ? 'block' : 'none';
});

loadUserGrid();
