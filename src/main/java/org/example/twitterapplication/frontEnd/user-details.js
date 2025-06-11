function getUserIdFromUrl() {
    const params = new URLSearchParams(window.location.search);
    return params.get('userId');
}

function createDropdown(title, users) {
    if (!users || users.length === 0) {
        return `
      <div class="mb-4">
        <h5>${title}</h5>
        <p class="text-muted">No ${title.toLowerCase()}.</p>
      </div>`;
    }

    const items = users.map(user =>
        `<li><a class="dropdown-item" href="user-details.html?userId=${user.id}">${user.name} (ID: ${user.id})</a></li>`
    ).join('');

    return `
    <div class="mb-4">
      <h5>${title}</h5>
      <div class="dropdown">
        <button class="btn btn-outline-primary dropdown-toggle" type="button" data-bs-toggle="dropdown">
          Show ${title}
        </button>
        <ul class="dropdown-menu">
          ${items}
        </ul>
      </div>
    </div>`;
}

async function deleteUser(userId) {
    if (!confirm("Are you sure you want to delete this user? This action cannot be undone.")) {
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/user/delete/${userId}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            throw new Error("Failed to delete user");
        }

        alert("User deleted successfully.");
        window.location.href = 'index.html';  // Redirect to the users grid page
    } catch (error) {
        console.error("Error deleting user:", error);
        alert("Failed to delete user.");
    }
}

async function updateUser(userId) {
    const name = document.getElementById('updateUserName').value;
    const email = document.getElementById('updateUserEmail').value;
    const timezone = document.getElementById('updateUserTimezone').value;

    const updatedUser = {
        id: userId,
        name: name,
        email: email,
        timezone: timezone
    };

    try {
        const response = await fetch('http://localhost:8080/user/update', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedUser)
        });

        if (!response.ok) {
            throw new Error('Failed to update user');
        }

        const user = await response.json();
        alert('User updated successfully!');
        document.getElementById('updateUserModal').modal('hide');
        loadUserDetails();

    } catch (error) {
        console.error('Error updating user:', error);
        alert('Failed to update user');
    }
}

async function loadUserDetails() {
    const userId = getUserIdFromUrl();
    const spinner = document.getElementById('spinner');
    const userDetails = document.getElementById('userDetails');
    const errorMessage = document.getElementById('errorMessage');

    try {
        const response = await fetch(`http://localhost:8080/user/getByIdWithFullData/${userId}`);
        if (!response.ok) throw new Error('Failed to fetch user details');

        const user = await response.json();

        userDetails.innerHTML = `
      <div class="card shadow p-4">
        <h4 class="card-title">${user.name}</h4>
        <p class="card-text"><strong>ID:</strong> ${user.id}</p>
        <p class="card-text"><strong>Email:</strong> ${user.email}</p>
        <p class="card-text"><strong>Timezone:</strong> ${user.timezone}</p>

        ${createDropdown('Followers', user.followers)}

        ${createDropdown('Followings', user.followings)}

        <div class="delete-btn-container">
          <button class="btn btn-danger" onclick="deleteUser(${user.id})">Delete User</button>
        </div>

        <div class="update-btn-container">
          <button class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateUserModal" 
          onclick="populateUpdateForm(${user.id}, '${user.name}', '${user.email}', '${user.timezone}')">Update User</button>
        </div>
      </div>
    `;
        userDetails.style.display = 'block';
    } catch (error) {
        errorMessage.classList.remove('d-none');
        console.error('Error loading user details:', error);
    } finally {
        spinner.style.display = 'none';
    }
}

function populateUpdateForm(userId, name, email, timezone) {
    document.getElementById('updateUserName').value = name;
    document.getElementById('updateUserEmail').value = email;
    document.getElementById('updateUserTimezone').value = timezone;
    document.getElementById('updateUserForm').onsubmit = function (event) {
        event.preventDefault();
        updateUser(userId);
    };
}

window.onload = loadUserDetails;
